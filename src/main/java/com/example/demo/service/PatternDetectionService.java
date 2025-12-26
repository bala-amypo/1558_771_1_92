package com.example.demo.service;

import com.example.demo.model.HotspotZone;
import java.util.List;

public interface PatternDetectionService {
    void detectPatterns();
    String analyzeZone(HotspotZone zone);
}