package br.edu.ifpb.dac.alysense.alysense.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Long>{
    
}
