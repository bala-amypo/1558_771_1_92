package com.example.demo.service.impl;

import com.example.demo.model.CrimeReport;
import com.example.demo.model.PatternDetectionResult;
import com.example.demo.service.PatternDetectionService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {

    @Override
    public PatternDetectionResult detectPattern(List<CrimeReport> reports) {

        PatternDetectionResult result = new PatternDetectionResult();
        result.setTotalReports(reports.size());
        result.setMessage("Pattern detection completed");

        return result;
    }
}
