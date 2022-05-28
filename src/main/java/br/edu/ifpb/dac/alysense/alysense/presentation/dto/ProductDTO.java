package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import java.time.LocalDate;
import java.util.Set;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Characteristic;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Sample;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    
    private Long id;

	private String name;
    private LocalDate expirationDate;
    private String owner;
    private String ingredients;
    private Set<Characteristic> characteristics;
    private Set<Sample> samples;
}
