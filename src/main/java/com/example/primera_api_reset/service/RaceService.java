package com.example.primera_api_reset.service;

import com.example.primera_api_reset.model.Race;

import java.util.List;
import java.util.Optional;

public interface RaceService {

    List<Race> getAllRaces();

    List<Race> getRacesByCircuitId(Integer circuitId);

    Race saveRace(Race race);

    void deleteRace(Long raceId);
}

