package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.AnalysisLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisLogServiceImpl implements AnalysisLogService {

    private final AnalysisLogRepository logRepo;
    private final HotspotZoneRepository zoneRepo;

    public AnalysisLogServiceImpl(AnalysisLogRepository logRepo, HotspotZoneRepository zoneRepo) {
        this.logRepo = logRepo;
        this.zoneRepo = zoneRepo;
    }

    public AnalysisLog addLog(Long zoneId, String msg) {
        HotspotZone z = zoneRepo.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        AnalysisLog log = new AnalysisLog();
        log.setMessage(msg);
        log.setZone(z);
        return logRepo.save(log);
    }

    public List<AnalysisLog> getLogsByZone(Long zoneId) {
        return logRepo.findByZone_Id(zoneId);
    }
}
