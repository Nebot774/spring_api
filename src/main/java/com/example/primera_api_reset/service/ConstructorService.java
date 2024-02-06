package com.example.primera_api_reset.service;

import com.example.primera_api_reset.model.Circuit;
import com.example.primera_api_reset.model.Constructor;
import com.example.primera_api_reset.projecton.ConstructorDTO;

import java.util.List;
import java.util.Optional;

public interface ConstructorService {

    List<Constructor> getAllConstructors();

    Optional<ConstructorDTO> getConstructorByName(String name  );

    //definicion metodo guardar Constructor
    Constructor saveConstructor(Constructor constructor);

    //definicion metodo borrar constructor
    void deleteConstructorByName(String name);

    Constructor updateConstructor(String name, Constructor constructor);
}
