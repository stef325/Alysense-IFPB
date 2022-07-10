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
public class EvalueteItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    
   private Long evaluator;

   @OneToOne(fetch = FetchType.EAGER,
    cascade = { CascadeType.ALL}, orphanRemoval = true)
   private Sample sample; 

   @OneToOne(fetch = FetchType.EAGER,
   cascade = { CascadeType.ALL}, orphanRemoval = true)
   private Note note;
    


    
}
