package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.util.List;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Characteristic {
    
    private Long id;
    private String name;
    private List<String> atributes;
    

    public void setAtributes(String atribute){
        if (!atributes.contains(atribute)) {
           atributes.add(atribute); 
        }
    }
}
