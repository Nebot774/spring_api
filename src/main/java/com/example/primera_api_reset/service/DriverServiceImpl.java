package com.example.primera_api_reset.service;

import com.example.primera_api_reset.model.Driver;
import com.example.primera_api_reset.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService{

    private final DriverRepository repository;

    @Autowired
    public DriverServiceImpl(DriverRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return repository.findAll();
    }



}