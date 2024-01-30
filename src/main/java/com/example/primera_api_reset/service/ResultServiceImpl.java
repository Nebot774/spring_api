package com.example.primera_api_reset.service;

import com.example.primera_api_reset.model.Result;
import com.example.primera_api_reset.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {



    private final ResultsRepository resultRepository;

    @Autowired
    public ResultServiceImpl(ResultsRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }



}
