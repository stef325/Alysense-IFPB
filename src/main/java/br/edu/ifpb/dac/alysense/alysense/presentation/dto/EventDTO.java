package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import java.time.LocalDate;
import java.util.List;

import br.edu.ifpb.dac.alysense.alysense.model.entity.EvaluateItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {
    private Long id;
    private String title;
    private LocalDate date;
    private int peopleLimit;
    private List<User> evaluators;
    private List<EvaluateItem> items;
    
}
