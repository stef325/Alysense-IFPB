package br.edu.ifpb.dac.alysense.alysense.Integration.Event;
/*
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ifpb.dac.alysense.alysense.business.service.EventService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EvaluateItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Event;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.model.repository.EventRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.controller.EventController;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EventDTO;

@SpringBootTest
public class EventIntegrationsTests {
    
    @Autowired
    private EventController ctrl;

    @Autowired
    private EventService srv;

    @Autowired
    private EventRepository repo;

    private Event event;

    public void init(){
        event = new Event();
        event.setDate(LocalDate.now().plusWeeks(1));

        List<EvaluateItem> items = new ArrayList<>();
        EvaluateItem ev = new EvaluateItem();

        for (int i = 0; i < 5; i++) {
            Product prod = new Product();
            prod.setName("Produto "+i);
            ev.setProduct(prod);
            items.add(ev);
        }
        event.setItems(items);
        event.setTitle("Avaliação de produtos de limpeza");
    }

    public void eventRepositoryTest() {
        Event savedEvent = repo.save(event);

        assertEquals(event.getDate(), savedEvent.getDate());

        Event DBEvent = srv.findById(savedEvent.getId());

        assertAll(
            () -> assertEquals(savedEvent.getId()),
            () -> assertEquals(savedEvent.getId(), DBUser.getId()),
            () -> assertEquals(savedEvent.getEmail(), DBUser.getEmail()),
        );
        
        
    }

    public void eventServiceTest(){}

}*/
