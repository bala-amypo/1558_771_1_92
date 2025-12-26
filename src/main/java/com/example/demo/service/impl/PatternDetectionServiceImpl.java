package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PatternDetectionService;

import java.time.LocalDate;
import java.util.List;

public class PatternDetectionServiceImpl implements PatternDetectionService {

    private final HotspotZoneRepository zoneRepo;
    private final CrimeReportRepository reportRepo;
    private final PatternDetectionResultRepository resultRepo;
    private final AnalysisLogRepository logRepo;

    public PatternDetectionServiceImpl(
            HotspotZoneRepository zoneRepo,
            CrimeReportRepository reportRepo,
            PatternDetectionResultRepository resultRepo,
            AnalysisLogRepository logRepo) {
        this.zoneRepo = zoneRepo;
        this.reportRepo = reportRepo;
        this.resultRepo = resultRepo;
        this.logRepo = logRepo;
    }

    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {
        HotspotZone zone = zoneRepo.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        List<CrimeReport> reports =
                reportRepo.findByLatLongRange(
                        zone.getCenterLat() - 0.1,
                        zone.getCenterLat() + 0.1,
                        zone.getCenterLong() - 0.1,
                        zone.getCenterLong() + 0.1
                );

        PatternDetectionResult r = new PatternDetectionResult();
        r.setZone(zone);
        r.setCrimeCount(reports.size());
        r.setAnalysisDate(LocalDate.now());

        if (reports.size() > 5) {
            r.setDetectedPattern("HIGH RISK");
            zone.setSeverityLevel("HIGH");
        } else {
            r.setDetectedPattern("NO RISK");
            zone.setSeverityLevel("LOW");
        }

        zoneRepo.save(zone);
        logRepo.save(new AnalysisLog());
        return resultRepo.save(r);
    }

    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepo.findByZone_Id(zoneId);
    }
}
