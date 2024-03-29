package com.example.primera_api_reset.service;

import com.example.primera_api_reset.model.Circuit;
import com.example.primera_api_reset.model.Driver;
import com.example.primera_api_reset.projecton.CircuitoProyeccion;
import com.example.primera_api_reset.repository.CircuitRepository;
import com.example.primera_api_reset.repository.DriverRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuitServiceImpl implements CircuitService {

    private final CircuitRepository circuitRepository;

    @Autowired
    public CircuitServiceImpl(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }

    @Override
    public List<Circuit> getAllCircuits() {
        return circuitRepository.findAll();
    }

    @Override
    public Optional<Circuit> getCircuitByName(String name) {
        return  circuitRepository.findByName(name);
    }


    @Override
    public Circuit saveCircuit(Circuit circuit) {
        return circuitRepository.save(circuit);
    }

    @Override
    public void deleteCircuitByName(String name) {
         circuitRepository.deleteByName(name);
    }

    @Override
    public Page<CircuitoProyeccion> getAllCircuitPaged(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize, sort);
        return circuitRepository.findAllProjectedBy(pageable);
    }


}

