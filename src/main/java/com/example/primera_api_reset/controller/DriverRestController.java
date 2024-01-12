package com.example.primera_api_reset.controller;

import com.example.primera_api_reset.model.Driver;
import com.example.primera_api_reset.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverRestController {

    private final DriverService driverService;

    @Autowired
    public DriverRestController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> getAll(){
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @GetMapping("/drivers/{code}")
    public ResponseEntity<Driver> getByCode(@PathVariable String code){
        return this.driverService.getDriverByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());


    }

    @PostMapping("/drivers")
    public ResponseEntity<Driver> create(@RequestBody Driver driver){
        // Verificar si el ID del conductor ya está establecido
        if(driver.getDriverId() != null)
            // Si el ID del conductor no es null, se devuelve una respuesta de error
            return ResponseEntity.badRequest().build();

        // Guardar el objeto Driver en la base de datos
        this.driverService.saveDriver(driver);

        // Devolver una respuesta HTTP 200 OK con el objeto Driver en el cuerpo
        return ResponseEntity.ok(driver);
    }





}
