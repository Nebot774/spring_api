package com.example.primera_api_reset.controller;

import com.example.primera_api_reset.model.Circuit;
import com.example.primera_api_reset.model.Race;
import com.example.primera_api_reset.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/races")
public class RaceRestController {

    private final RaceService raceService;

    @Autowired
    public RaceRestController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/circuit")
    public ResponseEntity<List<Race>> getAllRaces() {
        return ResponseEntity.ok(raceService.getAllRaces());
    }

    @GetMapping("/circuit/{circuitId}")
    public ResponseEntity<List<Race>> getRacesByCircuitId(@PathVariable Circuit circuitId) {
        return ResponseEntity.ok(raceService.getRacesByCircuitId(circuitId));
    }

    @PostMapping
    public ResponseEntity<Race> createRace(@RequestBody Race race) {
        return ResponseEntity.ok(raceService.saveRace(race));
    }

    @DeleteMapping("/{raceId}")
    public ResponseEntity<Void> deleteRace(@PathVariable Long raceId) {
        raceService.deleteRace(raceId);
        return ResponseEntity.ok().build();
    }

}
