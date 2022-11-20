package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Avaliation{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;  

    @ManyToOne
    private EventSense event;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<EvalueteItem> evalueteItems;
    
    @OneToOne(fetch = FetchType.EAGER)
    private Product product;
}