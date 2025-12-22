package com.example.demo.service.impl;

import com.example.demo.model.AnalysisLog;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.service.AnalysisLogService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisLogServiceImpl implements AnalysisLogService {

    private final AnalysisLogRepository analysisLogRepository;

    public AnalysisLogServiceImpl(AnalysisLogRepository analysisLogRepository) {
        this.analysisLogRepository = analysisLogRepository;
    }

    @Override
    public AnalysisLog saveLog(AnalysisLog log) {
        return analysisLogRepository.save(log);
    }

    @Override
    public List<AnalysisLog> getAllLogs() {
        return analysisLogRepository.findAll();
    }
}
