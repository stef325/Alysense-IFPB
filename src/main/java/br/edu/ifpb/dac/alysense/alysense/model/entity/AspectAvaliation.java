package br.edu.ifpb.dac.alysense.alysense.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AspectAvaliation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float olfato;
    private float visao;
    private float tato;
    private float paladar;
    private float audicao;
    
    
    //private Avaliation avaliation;
}
