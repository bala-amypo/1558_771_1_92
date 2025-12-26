package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PatternDetectionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
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

    public PatternDetectionResult detectPattern(Long zoneId) {
        HotspotZone zone = zoneRepo.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        int count = reportRepo
                .findByLatLongRange(0.0, 180.0, 0.0, 180.0)
                .size();

        PatternDetectionResult res = new PatternDetectionResult();
        res.setCrimeCount(count);
        res.setZone(zone);
        res.setDetectedPattern(count > 5 ? "HIGH RISK" : "NO RISK");

        resultRepo.save(res);
        logRepo.save(new AnalysisLog());

        return res;
    }

    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepo.findByZone_Id(zoneId);
    }
}
