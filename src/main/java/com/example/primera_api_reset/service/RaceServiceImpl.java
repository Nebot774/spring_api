package com.example.primera_api_reset.service;

import com.example.primera_api_reset.model.Race;
import com.example.primera_api_reset.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    @Override
    public List<Race> getRacesByCircuitId(Integer circuitId) {
        return raceRepository.findByCircuitid(circuitId);
    }

    @Override
    public Race saveRace(Race race) {
        return raceRepository.save(race);
    }

    @Override
    public void deleteRace(Long raceId) {
        raceRepository.deleteById(raceId);
    }
}

