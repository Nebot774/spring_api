package com.example.primera_api_reset.service;

import com.example.primera_api_reset.model.Driver;
import com.example.primera_api_reset.repository.DriverRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //implementacion metodo buscar driver por ID
    @Override
    public Optional<Driver> getDriverByCode(String code) {
        return repository.findByCodeIgnoreCase(code);
    }


    //implementacion metodo guardar driver
    @Override
    public Driver saveDriver(Driver driver) {
        return repository.save(driver);
    }

    //implementacion metodo borrar piloto por ID
    @Override
    @Transactional
    public void deleteDriverByCode(String code) {
        repository.deleteByCode(code);
    }





}
