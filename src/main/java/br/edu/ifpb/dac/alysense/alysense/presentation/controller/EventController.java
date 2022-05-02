package br.edu.ifpb.dac.alysense.alysense.presentation.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.business.service.EventService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Event;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EventDTO;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService service;

    @Autowired
    private ConverterService converter;

    
    /*-----Create-----*/
    @PostMapping
    public ResponseEntity save(@RequestBody EventDTO dto){
        try {
            Event entity = converter.DTOToEvent(dto);
            service.save(entity);
            dto = converter.EventToDTO(entity);

            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    /*-----Read-----*/
    @GetMapping("/filter")
    public ResponseEntity find(
        @RequestParam(value = "id", required = false) Long id,
        @RequestParam(value = "title", required = false) String title,
        @RequestParam(value = "date", required = false) LocalDate date,
        @RequestParam(value = "peopleLimit", required = false) int peopleLimit
        ){
        try {
            Event filter = new Event();

            List<Event> entities = service.find(filter);
            List<EventDTO> dtos = converter.EventToDTO(entities);

            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity findAll(){
        try {
            List<Event> entities = service.findAll();
            List<EventDTO> dtos = converter.EventToDTO(entities);

            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        try {
            Event entity = service.findById(id);
            EventDTO dto = converter.EventToDTO(entity);

            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    /*-----Update-----*/
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody EventDTO dto){
        try {
            dto.setId(id);
            Event entity = converter.DTOToEvent(dto);
            service.update(entity);
            dto = converter.EventToDTO(entity);

            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    /*-----Delete-----*/
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            service.delete(id);

            return new ResponseEntity("Succesffuly deleted!", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }

    
}
