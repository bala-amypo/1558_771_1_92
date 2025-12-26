package com.example.demo.controller;

import com.example.demo.model.AnalysisLog;
import com.example.demo.service.AnalysisLogService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class AnalysisLogController {

    private final AnalysisLogService analysisLogService;

    // Standard constructor injection
    public AnalysisLogController(AnalysisLogService analysisLogService) {
        this.analysisLogService = analysisLogService;
    }

    @GetMapping
    public List<AnalysisLog> getLogs() {
        return analysisLogService.getAllLogs();
    }
}