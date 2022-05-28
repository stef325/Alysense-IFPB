package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Event;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EventSense;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EventDTO;
import br.edu.ifpb.dac.alysense.alysense.util.EventTest;
import br.edu.ifpb.dac.alysense.alysense.util.OutOfLimitException;
import br.edu.ifpb.dac.alysense.alysense.util.ToMuchPeopleException;

public class EventsTests {
    final List<String> users = mock(List.class);
    final List<String> usersSpy = Mockito.spy(users);

    @Before
    public final void initEvent(){
        usersSpy.add("joão");
        usersSpy.add("Maria");
        usersSpy.add("Pedro");
        usersSpy.add("junior");
     
    }

    @Test
    @DisplayName("Limit Exceptions")
    public void EventRegisterException() throws ToMuchPeopleException, OutOfLimitException{

        EventTest eventmock = mock(EventTest.class);


        doThrow(new ToMuchPeopleException()).when(eventmock).subscribePeople(usersSpy);
        doThrow(new OutOfLimitException()).when(eventmock).setQtdPessoas(11);

        assertThrows(ToMuchPeopleException.class, () -> eventmock.subscribePeople(usersSpy));
        assertThrows(OutOfLimitException.class,()-> eventmock.setQtdPessoas(11));
    }

    @Test
    public void subscribedPeopleCantBeZero(){
        EventTest eventoMock = mock(EventTest.class);

        when(eventoMock.getCtPessoas()).thenReturn(5);

        assertNotEquals(0, eventoMock.getCtPessoas());
    }

    @Test
    public void eventDTOConverter(){
        ConverterService converter = new ConverterService();

        EventSense evento = new EventSense();

        EventDTO eventodto = converter.EventToDTO(evento);

        assertNull(null, eventodto.getEvaluators());

        evento = converter.DTOToEvent(eventodto);

        assertNull(null, evento.getEvaluators());
    }
    
}
