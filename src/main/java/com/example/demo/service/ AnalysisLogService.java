package com.example.demo.service;

import com.example.demo.model.AnalysisLog;
import java.util.List;

public interface AnalysisLogService {
    List<AnalysisLog> getLogsByZone(Long zoneId);
    // Add other method signatures here
}