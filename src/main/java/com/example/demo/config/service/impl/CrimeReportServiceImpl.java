package com.example.demo.service.impl;

import com.example.demo.model.CrimeReport;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.service.CrimeReportService;
import com.example.demo.util.CoordinateValidator;
import com.example.demo.util.DateValidator;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {

    private final CrimeReportRepository repo;

    public CrimeReportServiceImpl(CrimeReportRepository repo) {
        this.repo = repo;
    }

    @Override
    public CrimeReport addReport(CrimeReport report) {
        CoordinateValidator.validate(report.getLatitude(), report.getLongitude());
        DateValidator.validate(report.getOccurredAt());
        return repo.save(report);
    }

    @Override
    public List<CrimeReport> getAllReports() {
        return repo.findAll();
    }
}
