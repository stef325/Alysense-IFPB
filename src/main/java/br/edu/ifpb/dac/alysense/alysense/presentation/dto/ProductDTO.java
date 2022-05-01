package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import java.time.LocalDate;
import java.util.List;

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
    private List<Characteristic> characteristic; 
}
