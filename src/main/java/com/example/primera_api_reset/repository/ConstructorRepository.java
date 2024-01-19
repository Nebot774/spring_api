package com.example.primera_api_reset.repository;

import com.example.primera_api_reset.model.Circuit;
import com.example.primera_api_reset.model.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConstructorRepository  extends JpaRepository<Constructor, Long> {

    //buscar por nombre
    Optional<Constructor> findByName(String name);

    void deleteByName(String name);



}
