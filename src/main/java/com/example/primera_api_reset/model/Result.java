package com.example.primera_api_reset.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultid")
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "raceid")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "driverid")
    @JsonIgnoreProperties
    private Driver driver;


    @Column(name = "grid", nullable = false)
    private Integer grid;

    @Column(name = "position")
    private Integer position;

    @Column(name = "points", nullable = false)
    private Integer points;

    //@Column(name = "resultado")
    //private String resultado; // Atributo resultado agregado


}


