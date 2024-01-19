package com.example.primera_api_reset.repository;

import com.example.primera_api_reset.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
    List<Race> findByCircuitid(Integer circuitId);
}
