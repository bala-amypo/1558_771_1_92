package com.example.demo.service.impl;

import com.example.demo.model.CrimeReport;
import com.example.demo.service.CrimeReportService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {

    @Override
    public CrimeReport saveReport(CrimeReport report) {
        // Implementation logic (e.g., repository.save(report))
        return report;
    }

    @Override
    public List<CrimeReport> getAllReports() {
        // Implementation logic (e.g., repository.findAll())
        return new ArrayList<>();
    }
}