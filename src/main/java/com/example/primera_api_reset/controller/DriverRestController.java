package com.example.primera_api_reset.controller;

import com.example.primera_api_reset.DTO.DriverDTO;
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

    //modificado para devolver DTO
    @GetMapping("/drivers")
    public ResponseEntity<List<DriverDTO>> getAll() {
        List<DriverDTO> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/drivers/{code}")
    public ResponseEntity<Driver> getByCode(@PathVariable String code){
        return this.driverService.getDriverByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());


    }

    //POST http://localhost:8080/api/drivers/
    @PostMapping("/drivers")
    public ResponseEntity<Driver> create(@RequestBody Driver driver){

        if(driver.getDriverId() != null)

            return ResponseEntity.badRequest().build();


        this.driverService.saveDriver(driver);


        return ResponseEntity.ok(driver);
    }

    //POST http://localhost:8080/api/drivers/
    @PutMapping("/drivers")
    public ResponseEntity<Driver> update(@RequestBody Driver driver){
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);

    }


    //DELETE http://localhost:8080/api/drivers/alo
    @DeleteMapping("/drivers/{code}")
    public ResponseEntity<Driver> deleteByCode(@PathVariable String code){
        this.driverService.deleteDriverByCode(code);
        return ResponseEntity.noContent().build();
    }


}
