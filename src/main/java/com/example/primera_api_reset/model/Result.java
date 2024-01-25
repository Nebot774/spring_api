package com.example.primera_api_reset.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "new_results")
public class Result {
    @EmbeddedId
    private ResultKey id;

    @ManyToOne
    @MapsId("raceid")
    @JoinColumn(name = "race_id", referencedColumnName = "raceid")
    private Race race;

    @ManyToOne
    @MapsId("driverid")
    @JoinColumn(name = "driver_id", referencedColumnName = "driverid")
    private Driver driver;

    @Column(name = "resultado")
    String resultado;//atributo resultado agregado

}

