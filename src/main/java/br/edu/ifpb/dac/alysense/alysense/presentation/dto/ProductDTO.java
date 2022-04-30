package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import java.time.LocalDate;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Characteristic;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    
    private Long id;

	private String name;
    private LocalDate expirationDate;
    private String owner;
    private Characteristic characteristic; 
}
