package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Sample {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private Long code = (long) Math.floor(Math.random() * 1001);

    @ManyToOne
    @JoinColumn(name = "evaluate_id")
    private EvalueteItem evalueteItem;

    private String detailsSample;

}
