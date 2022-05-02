package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private LocalDate date;
    private String local;
    private Integer peopleLimit;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_avaliation", joinColumns = @JoinColumn(name= "eventid"), inverseJoinColumns = @JoinColumn(name = "userid"))
    private List<User> evaluators;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EvaluateItem> items;


}
