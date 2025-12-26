package com.example.demo.service.impl;

import com.example.demo.model.CrimeReport;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.service.CrimeReportService;
import com.example.demo.util.CoordinateValidator;
import com.example.demo.util.DateValidator;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {
    
    private final CrimeReportRepository reportRepository;
    private final CoordinateValidator coordinateValidator;
    private final DateValidator dateValidator;
    
    public CrimeReportServiceImpl(CrimeReportRepository reportRepository) {
        this.reportRepository = reportRepository;
        this.coordinateValidator = new CoordinateValidator();
        this.dateValidator = new DateValidator();
    }
    
    @Override
    public CrimeReport addReport(CrimeReport report) {
        // Validate coordinates
        if (!coordinateValidator.isValidLatitude(report.getLatitude())) {
            throw new IllegalArgumentException("Invalid latitude value");
        }
        if (!coordinateValidator.isValidLongitude(report.getLongitude())) {
            throw new IllegalArgumentException("Invalid longitude value");
        }
        
        // Validate date (not in future)
        if (report.getOccurredAt() == null) {
            report.setOccurredAt(LocalDateTime.now());
        } else if (dateValidator.isFuture(report.getOccurredAt())) {
            throw new IllegalArgumentException("Date cannot be in the future");
        }
        
        return reportRepository.save(report);
    }
    
    @Override
    public List<CrimeReport> getAllReports() {
        return reportRepository.findAll();
    }
}