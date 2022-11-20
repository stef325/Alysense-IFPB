package br.edu.ifpb.dac.alysense.alysense.model.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EvalueteItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answer;

    private User evaluatorUser;
    
    @OneToMany(mappedBy = "evalueteItem")
    private List<Sample> samples; 

    @OneToOne(fetch = FetchType.EAGER,
    cascade = { CascadeType.ALL}, orphanRemoval = true)
    private Note note;
    

}
