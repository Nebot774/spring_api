package com.example.primera_api_reset.service;

import com.example.primera_api_reset.model.Circuit;
import com.example.primera_api_reset.model.Driver;

import java.util.List;
import java.util.Optional;

public interface CircuitService {

    List<Circuit> getAllCircuits();

    Optional<Circuit> getCircuitByName(String name  );

    //definicion metodo guardar circuito
    Circuit saveCircuit(Circuit circuit);

    //definicion metodo borrar driver por codigo
    void deleteCircuitByName(String name);


}
