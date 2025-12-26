package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.PatternDetectionResult;
import com.example.demo.repository.PatternDetectionResultRepository;
import com.example.demo.service.PatternDetectionService;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {

    private final PatternDetectionResultRepository repository;

    public PatternDetectionServiceImpl(PatternDetectionResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {
        PatternDetectionResult result = new PatternDetectionResult();
        result.setZoneId(zoneId);
        result.setMessage("Pattern detected");
        result.setTotalReports(10);
        return repository.save(result);
    }

    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return repository.findByZoneId(zoneId);
    }
}
