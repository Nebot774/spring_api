package com.example.primera_api_reset.repository;

import com.example.primera_api_reset.model.Driver;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    //metodo buscar pilotos por su codigo
    Optional<Driver> findByCodeIgnoreCase(String code);

    //metodo borrar driver por id
    void deleteByCode(String code);
}
