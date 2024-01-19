package com.example.primera_api_reset.service;

import com.example.primera_api_reset.model.Circuit;
import com.example.primera_api_reset.model.Constructor;

import java.util.List;
import java.util.Optional;

public interface ConstructorService {

    List<Constructor> getAllConstructors();

    Optional<Constructor> getConstructorByName(String name  );

    //definicion metodo guardar Constructor
    Constructor saveConstructor(Constructor constructor);

    //definicion metodo borrar constructor
    void deleteConstructorByName(String name);

    Constructor updateConstructor(String name, Constructor constructor);
}
