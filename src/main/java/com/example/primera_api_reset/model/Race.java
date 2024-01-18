package com.example.primera_api_reset.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

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

    @Column(name = "circuitid")
    private Integer circuitid;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @Column(name = "url")
    private String url;

    // Constructores, getters y setters
}
