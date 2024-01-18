package com.example.primera_api_reset.repository;

import com.example.primera_api_reset.model.Circuit;
import com.example.primera_api_reset.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CircuitRepository  extends JpaRepository<Circuit, Long> {



    //metodo borrar driver por id
    void deleteByName(String name);

    Optional<Circuit> findByName(String name);
}
