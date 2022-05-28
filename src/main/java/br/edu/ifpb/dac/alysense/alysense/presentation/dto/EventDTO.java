package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import java.time.LocalDate;
import java.util.Set;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Note;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {
    private Long id;
    private String title;
    private LocalDate date;
    private String local;
    private Integer peopleLimit;
    private Integer numberSample;
    private Set<UserDTO> evaluators;
    private Set<Product> items;
    private User admUser;
    
}
