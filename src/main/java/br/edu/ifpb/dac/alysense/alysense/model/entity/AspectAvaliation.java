package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.util.List;

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

    private List<Avaliation> olfato;
    private List<Avaliation> visao;
    private List<Avaliation> tato;
    private List<Avaliation> paladar;
    private List<Avaliation> audicao;

}
