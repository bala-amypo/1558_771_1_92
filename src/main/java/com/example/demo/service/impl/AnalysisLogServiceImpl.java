package com.example.demo.service.impl;

import com.example.demo.model.AnalysisLog;
import com.example.demo.service.AnalysisLogService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service // <--- This annotation tells Spring to create the Bean
public class AnalysisLogServiceImpl implements AnalysisLogService {

    @Override
    public AnalysisLog saveLog(AnalysisLog log) {
        // Your logic to save (e.g., repository.save(log))
        return log;
    }

    @Override
    public List<AnalysisLog> getAllLogs() {
        // Your logic to find all
        return new ArrayList<>();
    }
}