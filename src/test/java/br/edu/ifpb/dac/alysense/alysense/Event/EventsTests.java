package br.edu.ifpb.dac.alysense.alysense.Event;

import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import br.edu.ifpb.dac.alysense.alysense.util.EventTest;
import br.edu.ifpb.dac.alysense.alysense.util.OutOfLimitException;
import br.edu.ifpb.dac.alysense.alysense.util.ToMuchPeopleException;

public class EventsTests {
    final EventTest event = new EventTest();
    final List<String> users = new ArrayList<>();
    @Before
    public final void initEvent(){
        users.add("joão");
        users.add("Maria");
        users.add("Pedro");
        users.add("junior");
    }

    @Test
    @DisplayName("Limit Exceptions")
    public void EventRegisterException(){
        assertThrows(ToMuchPeopleException.class, () -> event.setInscritos(users));
        assertThrows(OutOfLimitException.class,()-> event.setQtdPessoas(11));
    }


    
}
