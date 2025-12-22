package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.CrimeReport;
import com.example.demo.service.CrimeReportService;

@RestController
@RequestMapping("/crime-reports")
public class CrimeReportController {

    private final CrimeReportService service;

    public CrimeReportController(CrimeReportService service) {
        this.service = service;
    }

    @PostMapping
    public CrimeReport create(@RequestBody CrimeReport report) {
        return service.saveReport(report);
    }

    @GetMapping
    public List<CrimeReport> getAll() {
        return service.getAllReports();
    }
}
