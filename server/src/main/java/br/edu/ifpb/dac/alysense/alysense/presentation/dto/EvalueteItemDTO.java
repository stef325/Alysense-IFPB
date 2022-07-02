package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Note;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Sample;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvalueteItemDTO {
    private Long id;

    private User evaluator;
    private Sample sample;
    private Note note;
    private String question;
}
