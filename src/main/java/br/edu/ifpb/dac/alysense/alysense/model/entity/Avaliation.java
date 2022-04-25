package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Avaliation{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private ArrayList<Float> avaliacoes;

    private float avaliacaoMedia = 0;

    public float avaliacaoMedia(){
        int contador = avaliacoes.size();
        if(contador == 0){
            return avaliacaoMedia = -1;
        }
        for(int i = 0; i < contador; i++) {
            avaliacaoMedia = avaliacaoMedia + avaliacoes.get(i);
        }
        return avaliacaoMedia = avaliacaoMedia/contador;
        
    }

    
    
}