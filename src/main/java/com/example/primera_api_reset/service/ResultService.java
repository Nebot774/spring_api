package com.example.primera_api_reset.service;

import com.example.primera_api_reset.model.Result;
import com.example.primera_api_reset.repository.ResultsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {


    List<Result> findAll();

}

