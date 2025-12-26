package com.example.demo.controller;

import com.example.demo.model.CrimeReport;
import com.example.demo.service.CrimeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class CrimeReportController {

    @Autowired
    private CrimeReportService service;

    @PostMapping
    public CrimeReport createReport(@RequestBody CrimeReport report) {
        return service.saveReport(report);
    }

    @GetMapping
    public List<CrimeReport> fetchAllReports() {
        return service.getAllReports();
    }
}