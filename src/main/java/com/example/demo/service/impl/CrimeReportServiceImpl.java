package com.example.demo.service.impl;

import com.example.demo.model.CrimeReport;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.service.CrimeReportService;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {

    private final CrimeReportRepository repository;

    public CrimeReportServiceImpl(CrimeReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public CrimeReport saveReport(CrimeReport report) {
        return repository.save(report);
    }

    @Override
    public List<CrimeReport> getAllReports() {
        return repository.findAll();
    }
}
