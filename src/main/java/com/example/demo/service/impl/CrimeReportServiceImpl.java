package com.example.demo.service.impl;

import com.example.demo.model. CrimeReport;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.service. CrimeReportService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {
    
    private final CrimeReportRepository crimeReportRepository;
    
    public CrimeReportServiceImpl(CrimeReportRepository crimeReportRepository) {
        this.crimeReportRepository = crimeReportRepository;
    }
    
    @Override
    public CrimeReport addReport(CrimeReport report) {
        // Validate latitude
        if (report.getLatitude() == null || report.getLatitude() < -90 || report.getLatitude() > 90) {
            throw new RuntimeException("Invalid latitude:  must be between -90 and 90");
        }
        
        // Validate longitude
        if (report.getLongitude() == null || report.getLongitude() < -180 || report.getLongitude() > 180) {
            throw new RuntimeException("Invalid longitude: must be between -180 and 180");
        }
        
        // Validate occurredAt is not in future
        if (report.getOccurredAt() != null && report.getOccurredAt().isAfter(LocalDateTime. now())) {
            throw new RuntimeException("Crime occurrence time cannot be in the future");
        }
        
        return crimeReportRepository.save(report);
    }
    
    @Override
    public List<CrimeReport> getAllReports() {
        return crimeReportRepository.findAll();
    }
}