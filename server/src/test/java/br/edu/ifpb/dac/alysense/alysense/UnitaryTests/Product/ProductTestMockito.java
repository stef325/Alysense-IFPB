package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EventSense;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.presentation.controller.EventController;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EventDTO;

@TestMethodOrder(Random.class)
public class ProductTestMockito{

    EventSense event= mock(EventSense.class);
    Product product = mock(Product.class);
    EventController controller = mock(EventController.class);
    ConverterService converter=mock(ConverterService.class);
    

    @Test
    public void mockExceptiontest(){
        when(product.getId()).thenThrow(new NullPointerException());
        when(product.getName()).thenThrow(new NullPointerException());
        //when(product.getCharacteristics()).thenThrow(new NullPointerException());
        when(product.getOwner()).thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> product.getName());
        assertThrows(NullPointerException.class, () ->product.getId());
        assertThrows(NullPointerException.class, ()-> product.getOwner());
        //assertThrows(NullPointerException.class,()-> product.getCharacteristics());
    }

    @Test
    public void mockEventDate(){
        when(event.getDate()).thenReturn(LocalDate.now());
        assertEquals(LocalDate.now(), event.getDate());

        when(event.getDate()).thenReturn(LocalDate.parse("2022-10-07"));
        assertTrue(LocalDate.now().isBefore(event.getDate()));
        assertFalse(LocalDate.now().isAfter(event.getDate()));

        when(event.getDate()).thenThrow(new NullPointerException());
        assertThrows(NullPointerException.class, ()-> event.getDate());

        event.setDate(LocalDate.now());

        verify(event).setDate(LocalDate.now());

    }

    @Test
    public void mockEventLocal(){
        when(event.getLocal()).thenReturn("IFPB - Campus Monteiro");
        assertEquals("IFPB - Campus Monteiro", event.getLocal());

        assertTrue(event.getLocal().contains("Monteiro"));

        when(event.getLocal()).thenThrow(new NullPointerException());
        assertThrows(NullPointerException.class, ()-> event.getLocal());

        verify(event, times(0)).getDate();
        
    }
/*
    @Test
    public void mockEventLimitUsers(){
        when(event.getPeopleLimit()).thenReturn(10);
        List<User> spy = Mockito.spy(event.getEvaluators());
        when(spy.size()).thenReturn(10);
        assertTrue(event.getPeopleLimit() >= spy.size());

        assertTrue(event.getPeopleLimit() >= spy.size());
        when(event.getPeopleLimit()).thenReturn(9);
        assertFalse(event.getPeopleLimit() >= spy.size());

        spy.add(new User());
        assertInstanceOf(User.class, spy.get(0));

        reset(event);
		verifyZeroInteractions(event);

        

    }
    */

 //========================Controller=================================
    @Test
    public void mockEventControllerSave(){
        EventDTO dto = new EventDTO();
        controller.save(dto);
        verify(controller, times(1)).save(dto);
    }

    @Test
    public void mockEventControllerUpdate(){
        EventDTO dto = new EventDTO();
        controller.update(dto.getId(), dto);
        verify(controller, times(1)).update(dto.getId(), dto);
    }
    @Test
    public void mockEventControllerGet(){
        controller.findAll();
        verify(controller, times(1)).findAll();

        long id = 1;
        when(controller.findById(id)).thenReturn(new ResponseEntity(new EventSense(), HttpStatus.OK));

        assertEquals(new ResponseEntity(new EventSense(), HttpStatus.OK), controller.findById(id));
    }
    @Test
    public void mockEventControllerDelete(){
        long id = 1;
        controller.delete(id);
        verify(controller, times(1)).delete(id);
    }
//========================Controller=================================


//========================ConverterService=================================

@Test
public void mockEventServiceDTO(){
    EventDTO dto = new EventDTO();
    converter.DTOToEvent(dto);
    verify(converter, times(1)).DTOToEvent(dto);
}

@Test
public void mockEventServiceEvent(){
    EventSense eve = new EventSense();
    converter.EventToDTO(eve);
    verify(converter, times(1)).EventToDTO(eve);
}

//========================ConverterService=================================
    

}
