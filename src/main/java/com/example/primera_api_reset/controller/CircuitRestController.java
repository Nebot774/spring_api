package com.example.primera_api_reset.controller;

import com.example.primera_api_reset.model.Circuit;
import com.example.primera_api_reset.projecton.CircuitoProyeccion;
import com.example.primera_api_reset.service.CircuitService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CircuitRestController {

    private final CircuitService circuitService;


    @Autowired
    public CircuitRestController(CircuitService circuitService) {
        this.circuitService = circuitService;
    }

    //GET http://localhost:8080/api/circuits
    @GetMapping("/circuits")
    public ResponseEntity<List<Circuit>> getAll(){
        return ResponseEntity.ok(circuitService.getAllCircuits());
    }

    //GET http://localhost:8080/api/circuits/{code}
    @GetMapping("/circuits/{code}")
    public ResponseEntity<Circuit> getByCode(@PathVariable String code){
        return circuitService.getCircuitByName(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("")
    public ResponseEntity<List<CircuitoProyeccion>> getAllPagedAndSorted(@RequestParam(defaultValue = "5") int page,
                                                                         @RequestParam(defaultValue = "5") int size,
                                                                         @RequestParam(defaultValue = "code") String sortBy,
                                                                         @RequestParam(defaultValue = "ASC") String sortDirection) {
        Page<CircuitoProyeccion> CircuitPage = this.circuitService.getAllCircuitPaged(page, size, sortBy, sortDirection);
        return ResponseEntity.ok(CircuitPage.getContent());
    }

    @PostMapping("/circuits")
    public ResponseEntity<Circuit> create(@RequestBody Circuit circuit){
        if(circuit.getCircuitid() != null)
            return ResponseEntity.badRequest().build();

        Circuit savedCircuit = circuitService.saveCircuit(circuit);
        return ResponseEntity.ok(savedCircuit);
    }

    @PutMapping("/circuits")
    public ResponseEntity<Circuit> update(@RequestBody Circuit circuit){
        Circuit updatedCircuit = circuitService.saveCircuit(circuit);
        return ResponseEntity.ok(updatedCircuit);
    }

    //DELETE http://localhost:8080/api/circuits/{code}
    @DeleteMapping("/circuits/name/{name}")
    public ResponseEntity<Void> deleteCircuitByName(@PathVariable String name) {
        circuitService.deleteCircuitByName(name);
        return ResponseEntity.ok().build();
    }

}

