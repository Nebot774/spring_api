package com.example.primera_api_reset.controller;

import com.example.primera_api_reset.model.Constructor;
import com.example.primera_api_reset.projecton.ConstructorDTO;
import com.example.primera_api_reset.service.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ConstructorRestController {

    private final ConstructorService constructorService;

    @Autowired
    public ConstructorRestController(ConstructorService constructorService) {
        this.constructorService = constructorService;
    }

    // Obtener todos los constructores
    @GetMapping("/constructors")
    public ResponseEntity<List<Constructor>> getAllConstructors() {
        return ResponseEntity.ok(constructorService.getAllConstructors());
    }

    // Obtener un constructor por nombre
    @GetMapping("/constructors/{name}")
    public ResponseEntity<ConstructorDTO> getConstructorByName(@PathVariable String name) {
        Optional<ConstructorDTO> constructorDTO = constructorService.getConstructorByName(name);
        if (constructorDTO.isPresent()) {
            return ResponseEntity.ok(constructorDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo constructor
    @PostMapping("/constructors")
    public ResponseEntity<Constructor> saveConstructor(@RequestBody Constructor constructor) {
        return ResponseEntity.ok(constructorService.saveConstructor(constructor));
    }

    // Actualizar un constructor existente
    @PutMapping("/constructors/{name}")
    public ResponseEntity<Constructor> updateConstructor(@PathVariable String name, @RequestBody Constructor constructor) {
        // Asumimos que hay un método en el servicio para actualizar un constructor
        return ResponseEntity.ok(constructorService.updateConstructor(name, constructor));
    }

    // Eliminar un constructor por nombre
    @DeleteMapping("/constructors/{name}")
    public ResponseEntity<Void> deleteConstructorByName(@PathVariable String name) {
        constructorService.deleteConstructorByName(name);
        return ResponseEntity.ok().build();
    }




}
