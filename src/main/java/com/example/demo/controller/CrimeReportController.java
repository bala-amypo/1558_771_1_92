package com.example.demo.controller;

import com.example.demo.model.CrimeReport;
import com.example.demo. service.CrimeReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org. springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@Tag(name = "Crime Reports", description = "Crime report management endpoints")
@SecurityRequirement(name = "Bearer Authentication")
public class CrimeReportController {
    
    private final CrimeReportService crimeReportService;
    
    public CrimeReportController(CrimeReportService crimeReportService) {
        this.crimeReportService = crimeReportService;
    }
    
    @PostMapping("/")
    @Operation(summary = "Add a new crime report")
    public ResponseEntity<?> addReport(@RequestBody CrimeReport report) {
        try {
            CrimeReport saved = crimeReportService.addReport(report);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity. badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/")
    @Operation(summary = "Get all crime reports")
    public ResponseEntity<List<CrimeReport>> getAllReports() {
        return ResponseEntity.ok(crimeReportService.getAllReports());
    }
}