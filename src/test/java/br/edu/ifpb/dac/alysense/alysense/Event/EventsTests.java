package br.edu.ifpb.dac.alysense.alysense.Event;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        
        try {
            event.setQtdPessoas(3);
        } catch (OutOfLimitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Limit Exceptions")
    public void EventRegisterException(){
        assertThrows(ToMuchPeopleException.class, () -> event.subscribePeople(users));
        assertThrows(OutOfLimitException.class,()-> event.setQtdPessoas(11));
    }

    @Test
    public void subscribedPeopleCantBeZero(){
        try {
            event.subscribePerson("Bruna");
        } catch (ToMuchPeopleException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertNotEquals(0, event.getCtPessoas());
    }

    
}
