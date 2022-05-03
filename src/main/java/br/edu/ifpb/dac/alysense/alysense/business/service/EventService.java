package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Event;
import br.edu.ifpb.dac.alysense.alysense.model.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    /*-----Create-----*/
    public void save(Event event){
        repository.save(event);
    }


    /*-----Read-----*/
    public List<Event> find(Event filter ){
        Example<Event> example = Example.of(filter, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
        return repository.findAll(example);
    }

    public List<Event> findAll(){
        return repository.findAll();
    }

    public Event findById(Long id){
        return repository.getById(id);
    }


    /*-----Update-----*/
    public Event update(Event entity){
        return repository.save(entity);
    }
    
    /*-----Delete-----*/
    public void delete(Long id){
        repository.deleteById(id);
    }
    
}
