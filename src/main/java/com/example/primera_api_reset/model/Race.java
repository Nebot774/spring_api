package com.example.primera_api_reset.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

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
    private Long raceid;

    @Column(name = "year")
    private Integer year;

    @Column(name = "round")
    private Integer round;


    //clave foranea
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "circuitid", referencedColumnName = "circuitid")
    private Circuit circuit;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @Column(name = "url")
    private String url;


    //@OneToMany(mappedBy = "race")
    //@JsonIgnore
    //private Set<Result> results = new HashSet<>();


}
