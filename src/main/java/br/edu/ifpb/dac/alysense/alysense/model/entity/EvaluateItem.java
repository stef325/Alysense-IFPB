package br.edu.ifpb.dac.alysense.alysense.model.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EvaluateItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER,
     cascade = { CascadeType.ALL}, orphanRemoval = true)
    private Product product;

    @OneToOne(fetch = FetchType.EAGER,
     cascade = { CascadeType.ALL}, orphanRemoval = true)
    private AspectAvaliation aspectAvaliation;

    


    
}
