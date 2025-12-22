package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AnalysisLog;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.service.AnalysisLogService;

@Service
public class AnalysisLogServiceImpl implements AnalysisLogService {

    private final AnalysisLogRepository repository;

    public AnalysisLogServiceImpl(AnalysisLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public AnalysisLog saveLog(AnalysisLog log) {
        return repository.save(log);
    }

    @Override
    public List<AnalysisLog> getLogsByZone(Long zoneId) {
        return repository.findByZoneId(zoneId);
    }
}
