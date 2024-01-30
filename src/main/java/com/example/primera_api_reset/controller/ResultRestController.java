package com.example.primera_api_reset.controller;

import com.example.primera_api_reset.model.Result;
import com.example.primera_api_reset.service.ResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultRestController {

    private final ResultServiceImpl resultService;

    @Autowired
    public ResultRestController(ResultServiceImpl resultService) {
        this.resultService = resultService;
    }

    // Obtener todos los resultados
    @GetMapping
    public ResponseEntity<List<Result>> getAllResults() {
        List<Result> results = resultService.findAll();
        return ResponseEntity.ok(results);
    }


}
