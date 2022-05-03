package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class AspectAvaliation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = { CascadeType.ALL}, orphanRemoval = true)
    private Set<Avaliation> olfato;

    @OneToMany(cascade = { CascadeType.ALL}, orphanRemoval = true)
    private Set<Avaliation> visao;

    @OneToMany(cascade = { CascadeType.ALL}, orphanRemoval = true)
    private Set<Avaliation> tato;

    @OneToMany(cascade = { CascadeType.ALL}, orphanRemoval = true)
    private Set<Avaliation> paladar;

    @OneToMany(cascade = { CascadeType.ALL}, orphanRemoval = true)
    private Set<Avaliation> audicao;

}
