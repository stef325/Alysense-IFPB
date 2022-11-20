package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import java.util.List;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EvalueteItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EventSense;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliationDTO {
    
    private Long id;

    private String question;

    private List<EvalueteItem> evalueteItems;

    private Product product;

    private EventSense event;
}
 