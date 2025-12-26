package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PatternDetectionService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {
    
    private final HotspotZoneRepository zoneRepository;
    private final CrimeReportRepository reportRepository;
    private final PatternDetectionResultRepository resultRepository;
    private final AnalysisLogRepository logRepository;
    
    public PatternDetectionServiceImpl(HotspotZoneRepository zoneRepository,
                                      CrimeReportRepository reportRepository,
                                      PatternDetectionResultRepository resultRepository,
                                      AnalysisLogRepository logRepository) {
        this.zoneRepository = zoneRepository;
        this.reportRepository = reportRepository;
        this.resultRepository = resultRepository;
        this.logRepository = logRepository;
    }
    
    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {
        // Fetch zone
        Optional<HotspotZone> zoneOpt = zoneRepository.findById(zoneId);
        if (zoneOpt.isEmpty()) {
            throw new IllegalArgumentException("Zone not found");
        }
        
        HotspotZone zone = zoneOpt.get();
        
        // Define search radius (±0.1 degrees ≈ 11km)
        double latRange = 0.1;
        double longRange = 0.1;
        double minLat = zone.getCenterLat() - latRange;
        double maxLat = zone.getCenterLat() + latRange;
        double minLong = zone.getCenterLong() - longRange;
        double maxLong = zone.getCenterLong() + longRange;
        
        // Find crimes in the area
        List<CrimeReport> crimes = reportRepository.findByLatLongRange(minLat, maxLat, minLong, maxLong);
        int crimeCount = crimes.size();
        
        // Determine pattern based on threshold
        String detectedPattern;
        if (crimeCount > 5) {
            detectedPattern = "High crime density detected - Immediate attention required";
        } else if (crimeCount > 0) {
            detectedPattern = "Medium crime activity - Monitor closely";
        } else {
            detectedPattern = "No significant crime pattern detected";
        }
        
        // Update zone severity based on count
        if (crimeCount > 5) {
            zone.setSeverityLevel("HIGH");
        } else if (crimeCount > 0) {
            zone.setSeverityLevel("MEDIUM");
        } else {
            zone.setSeverityLevel("LOW");
        }
        zoneRepository.save(zone);
        
        // Create and save pattern detection result
        PatternDetectionResult result = new PatternDetectionResult();
        result.setZone(zone);
        result.setAnalysisDate(LocalDate.now());
        result.setCrimeCount(crimeCount);
        result.setDetectedPattern(detectedPattern);
        PatternDetectionResult savedResult = resultRepository.save(result);
        
        // Create analysis log
        AnalysisLog log = new AnalysisLog();
        log.setZone(zone);
        log.setMessage("Pattern detection completed for zone: " + zone.getZoneName() + 
                      ". Crimes found: " + crimeCount + ". Pattern: " + detectedPattern);
        logRepository.save(log);
        
        return savedResult;
    }
    
    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepository.findByZone_Id(zoneId);
    }
}