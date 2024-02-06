package com.example.primera_api_reset.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raceid")
    private Long raceid;

    @Column(name = "year")
    private Integer year;

    @Column(name = "round")
    private Integer round;


    //clave foranea
    @JsonManagedReference
    @OneToOne()
    @JoinColumn(name = "circuitid")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Circuit circuit;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @Column(name = "url")
    private String url;


    @OneToMany(mappedBy = "race")
    @JsonIgnore
    private Set<Result> results = new HashSet<>();


}
