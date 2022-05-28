package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.model.entity.EventSense;
import br.edu.ifpb.dac.alysense.alysense.model.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    /*-----Create-----*/
    public void save(EventSense event){
        repository.save(event);
    }


    /*-----Read-----*/
    public List<EventSense> find(EventSense filter ){
        Example<EventSense> example = Example.of(filter, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
        return repository.findAll(example);
    }

    public List<EventSense> findAll(){
        return repository.findAll();
    }

    public EventSense findById(Long id){
        return repository.getById(id);
    }


    /*-----Update-----*/
    public EventSense update(EventSense entity){
        return repository.save(entity);
    }
    
    /*-----Delete-----*/
    public void delete(Long id){
        repository.deleteById(id);
    }
    
}
