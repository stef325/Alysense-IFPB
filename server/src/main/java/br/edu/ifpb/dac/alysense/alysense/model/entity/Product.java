package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;
    private String owner;
    private String ingredients;
    private Long userId;
    /*@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Characteristic> characteristics;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sample> samples;*/


    
    
}
