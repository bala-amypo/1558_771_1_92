package com.example.demo. service.impl;

import com. example.demo.model. AnalysisLog;
import com.example.demo.model.CrimeReport;
import com. example.demo.model.HotspotZone;
import com.example.demo.model.PatternDetectionResult;
import com.example.demo.repository. AnalysisLogRepository;
import com.example.demo.repository. CrimeReportRepository;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.repository.PatternDetectionResultRepository;
import com.example. demo.service.PatternDetectionService;
import org.springframework. stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {
    
    private final HotspotZoneRepository hotspotZoneRepository;
    private final CrimeReportRepository crimeReportRepository;
    private final PatternDetectionResultRepository patternDetectionResultRepository;
    private final AnalysisLogRepository analysisLogRepository;
    
    public PatternDetectionServiceImpl(
            HotspotZoneRepository hotspotZoneRepository,
            CrimeReportRepository crimeReportRepository,
            PatternDetectionResultRepository patternDetectionResultRepository,
            AnalysisLogRepository analysisLogRepository) {
        this.hotspotZoneRepository = hotspotZoneRepository;
        this.crimeReportRepository = crimeReportRepository;
        this.patternDetectionResultRepository = patternDetectionResultRepository;
        this.analysisLogRepository = analysisLogRepository;
    }
    
    @Override
    @Transactional
    public PatternDetectionResult detectPattern(Long zoneId) {
        // Fetch zone
        HotspotZone zone = hotspotZoneRepository.findById(zoneId)
            .orElseThrow(() -> new RuntimeException("Zone not found"));
        
        // Define range (±0.1 degrees)
        double range = 0.1;
        double minLat = zone.getCenterLat() - range;
        double maxLat = zone.getCenterLat() + range;
        double minLong = zone. getCenterLong() - range;
        double maxLong = zone.getCenterLong() + range;
        
        // Fetch crimes in range
        List<CrimeReport> crimesInRange = crimeReportRepository.findByLatLongRange(minLat, maxLat, minLong, maxLong);
        int crimeCount = crimesInRange. size();
        
        // Determine pattern
        String detectedPattern;
        String severity;
        if (crimeCount > 5) {
            detectedPattern = "High crime pattern detected";
            severity = "HIGH";
        } else if (crimeCount > 0) {
            detectedPattern = "Medium crime pattern detected";
            severity = "MEDIUM";
        } else {
            detectedPattern = "No significant crime pattern detected";
            severity = "LOW";
        }
        
        // Update zone severity
        zone.setSeverityLevel(severity);
        hotspotZoneRepository.save(zone);
        
        // Create detection result
        PatternDetectionResult result = new PatternDetectionResult();
        result.setZone(zone);
        result.setAnalysisDate(LocalDate.now());
        result.setCrimeCount(crimeCount);
        result.setDetectedPattern(detectedPattern);
        result = patternDetectionResultRepository.save(result);
        
        // Create analysis log
        AnalysisLog log = new AnalysisLog();
        log.setZone(zone);
        log.setMessage("Pattern detection completed for zone " + zone.getZoneName() + 
                      ":  " + crimeCount + " crimes found, severity: " + severity);
        analysisLogRepository.save(log);
        
        return result;
    }
    
    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return patternDetectionResultRepository.findByZone_Id(zoneId);
    }
}