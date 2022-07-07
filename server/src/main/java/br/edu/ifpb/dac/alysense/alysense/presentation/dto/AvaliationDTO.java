package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import java.util.List;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EvalueteItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliationDTO {
    
    private Long id;

    private String answer;
    private List<EvalueteItem> evalueteItems;
}
