package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import java.util.Set;

import br.edu.ifpb.dac.alysense.alysense.model.Enum.Aspect;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EvaluateItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliationDTO {
    
    private Long id;

    private Aspect answer;
    private Set<EvaluateItem> evaluateItems;
}
