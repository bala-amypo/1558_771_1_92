package com.example.demo.service.impl;

import com.example.demo.model.AnalysisLog;
import com.example.demo.model.HotspotZone;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.AnalysisLogService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisLogServiceImpl implements AnalysisLogService {

    private final AnalysisLogRepository analysisLogRepository;
    private final HotspotZoneRepository hotspotZoneRepository;

    public AnalysisLogServiceImpl(
            AnalysisLogRepository analysisLogRepository,
            HotspotZoneRepository hotspotZoneRepository) {
        this.analysisLogRepository = analysisLogRepository;
        this.hotspotZoneRepository = hotspotZoneRepository;
    }

    @Override
    public AnalysisLog addLog(Long zoneId, String message) {
        HotspotZone zone = hotspotZoneRepository.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        AnalysisLog log = new AnalysisLog();
        log.setMessage(message);
        log.setZone(zone);

        return analysisLogRepository.save(log);
    }

    @Override
    public List<AnalysisLog> getLogsByZone(Long zoneId) {
        HotspotZone zone = hotspotZoneRepository.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        return analysisLogRepository.findByZone(zone);
    }
}
