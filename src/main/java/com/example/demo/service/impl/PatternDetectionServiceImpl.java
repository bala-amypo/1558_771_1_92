package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.PatternDetectionResult;
import com.example.demo.service.PatternDetectionService;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {

    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {
        PatternDetectionResult result = new PatternDetectionResult();
        result.setZoneId(zoneId);
        result.setTotalReports(10);
        result.setMessage("High crime activity detected");
        return result;
    }
}
