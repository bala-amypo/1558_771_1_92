package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import org.springframework.stereotype.Service;

@Service
public class PatternDetectionServiceImpl {

    public void analyzeZone(HotspotZone zone) {
        // Uses the alias methods from the model
        Double lat = zone.getCenterLat(); 
        
        if (lat != null && lat > 40.0) {
            zone.setSeverityLevel("HIGH");
        } else {
            zone.setSeverityLevel("LOW");
        }
    }
}