package com.example.demo.service;

import com.example.demo.model.AnalysisLog;
import java.util.List;

public interface AnalysisLogService {

    AnalysisLog saveLog(AnalysisLog log);

    List<AnalysisLog> getLogsByZone(Long zoneId);
}
