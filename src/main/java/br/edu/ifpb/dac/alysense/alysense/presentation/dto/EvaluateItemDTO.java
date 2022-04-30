package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import br.edu.ifpb.dac.alysense.alysense.model.entity.AspectAvaliation;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvaluateItemDTO {
    private Long id;

    private Product product;

    private AspectAvaliation aspectAvaliation;
}
