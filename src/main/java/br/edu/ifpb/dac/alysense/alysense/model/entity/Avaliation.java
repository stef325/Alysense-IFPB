package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.edu.ifpb.dac.alysense.alysense.model.Enum.Aspect;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Avaliation{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Aspect answer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EvaluateItem> evaluateItems;
    
    
}