package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import com.example.demo.service.PatternDetectionService;
import org.springframework.stereotype.Service;

@Service // This tells Spring to manage this class
public class PatternDetectionServiceImpl implements PatternDetectionService {

    @Override
    public void detectPatterns() {
        // Your logic for detecting patterns
    }

    @Override
    public String analyzeZone(HotspotZone zone) {
        // Example logic
        if (zone.getCenterLat() != null && zone.getCenterLat() > 40.0) {
            return "High Risk Pattern";
        }
        return "Normal";
    }
}