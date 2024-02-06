package com.example.primera_api_reset.service;

import com.example.primera_api_reset.model.Circuit;
import com.example.primera_api_reset.model.Constructor;
import com.example.primera_api_reset.projecton.ConstructorDTO;
import com.example.primera_api_reset.repository.ConstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConstructorServiceImpl implements ConstructorService {

    private  final ConstructorRepository constructorRepository;

    @Autowired
    public ConstructorServiceImpl(ConstructorRepository constructorRepository) {
        this.constructorRepository = constructorRepository;
    }

    @Override
    public List<Constructor> getAllConstructors() {
        return constructorRepository.findAll();
    }

    @Override
    public Optional<ConstructorDTO> getConstructorByName(String name) {
        return constructorRepository.findByName(name);
    }

    @Override
    public Constructor saveConstructor(Constructor constructor) {
        return constructorRepository.save(constructor);
    }

    @Override
    public void deleteConstructorByName(String name) {
        constructorRepository.deleteByName(name);
    }

    @Override
    public Constructor updateConstructor(String name, Constructor constructor) {
        return null;
    }
}
