package com.example.demo.controller;

import com.example.demo.model.CrimeReport;
import com.example.demo.service.CrimeReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crimes")
public class CrimeReportController {

    private final CrimeReportService service;

    public CrimeReportController(CrimeReportService service) {
        this.service = service;
    }

    @PostMapping
    public CrimeReport create(@RequestBody CrimeReport report) {
        return service.save(report);
    }

    @GetMapping
    public List<CrimeReport> getAll() {
        return service.getAll();
    }
}
