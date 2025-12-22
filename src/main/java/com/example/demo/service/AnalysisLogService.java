package com.example.demo.service;

import java.util.List;
import com.example.demo.model.AnalysisLog;

public interface AnalysisLogService {
    List<AnalysisLog> getLogsByZone(Long zoneId);
}
