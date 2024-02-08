package com.example.primera_api_reset.repository;

import com.example.primera_api_reset.model.Circuit;
import com.example.primera_api_reset.model.Driver;
import com.example.primera_api_reset.projecton.CircuitoProyeccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CircuitRepository  extends JpaRepository<Circuit, Long> {



    //metodo borrar driver por id
    void deleteByName(String name);

    Optional<Circuit> findByName(String name);

    Page<CircuitoProyeccion> findAllProjectedBy(Pageable pageable);
}
