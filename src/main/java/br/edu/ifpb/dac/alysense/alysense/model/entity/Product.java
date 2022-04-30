package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Product {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
    private LocalDate expirationDate;
    private String owner;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Characteristic characteristic;
    


    

}
