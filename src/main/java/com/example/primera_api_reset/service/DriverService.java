package com.example.primera_api_reset.service;

import com.example.primera_api_reset.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    List<Driver> getAllDrivers();

    Optional<Driver> getDriverByCode(String code);

    //definicion metodo guardar driver
    Driver saveDriver(Driver driver);

}
