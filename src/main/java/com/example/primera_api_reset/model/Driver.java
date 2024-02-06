package com.example.primera_api_reset.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid")
    private Long driverId;

    @Column(unique = true)
    private String code;
    private String forename;
    private String surname;
    @JsonProperty("dateOfBirth")
    private LocalDate dob;
    private String nationality;
    private String url;

    //relacion con el constructor
    @ManyToOne
    @JoinColumn(name = "constructorid")
    @JsonIgnoreProperties("driverList")
    private Constructor constructor;

    //relacion con resultado
    //almacenamos array de resultados
    @OneToMany(mappedBy = "driver")
    @JsonIgnore
    private Set<Result> results = new HashSet<>();



}



