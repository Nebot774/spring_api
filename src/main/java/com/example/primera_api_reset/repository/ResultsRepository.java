package com.example.primera_api_reset.repository;

import com.example.primera_api_reset.model.Circuit;
import com.example.primera_api_reset.model.Race;
import com.example.primera_api_reset.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultsRepository extends JpaRepository<Result, Long> {

}

