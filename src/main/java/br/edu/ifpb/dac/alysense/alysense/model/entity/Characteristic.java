package br.edu.ifpb.dac.alysense.alysense.model.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Characteristic {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String atributes;
    

   /* public void setAtributes(String atribute){
        if (!atributes.contains(atribute)) {
           atributes.add(atribute); 
        }
    }*/
}
