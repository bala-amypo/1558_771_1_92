package com.example.demo.service.impl;

import com.example.demo.model.AnalysisLog;
import com.example.demo.model.HotspotZone;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.AnalysisLogService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnalysisLogServiceImpl implements AnalysisLogService {
    
    private final AnalysisLogRepository logRepository;
    private final HotspotZoneRepository zoneRepository;
    
    public AnalysisLogServiceImpl(AnalysisLogRepository logRepository, 
                                 HotspotZoneRepository zoneRepository) {
        this.logRepository = logRepository;
        this.zoneRepository = zoneRepository;
    }
    
    @Override
    public AnalysisLog addLog(Long zoneId, String message) {
        // Fetch zone
        Optional<HotspotZone> zoneOpt = zoneRepository.findById(zoneId);
        if (zoneOpt.isEmpty()) {
            throw new IllegalArgumentException("Zone not found");
        }
        
        // Create and save log
        AnalysisLog log = new AnalysisLog();
        log.setZone(zoneOpt.get());
        log.setMessage(message);
        
        return logRepository.save(log);
    }
    
    @Override
    public List<AnalysisLog> getLogsByZone(Long zoneId) {
        return logRepository.findByZone_Id(zoneId);
    }
}