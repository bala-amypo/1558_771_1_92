package com.example.demo.controller;

import com.example.demo.model.AnalysisLog;
import com.example.demo.service.AnalysisLogService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class AnalysisLogController {

    private final AnalysisLogService analysisLogService;

    public AnalysisLogController(AnalysisLogService analysisLogService) {
        this.analysisLogService = analysisLogService;
    }

    // POST /logs/{zoneId}?message=...
    @PostMapping("/{zoneId}")
    public AnalysisLog addLog(
            @PathVariable Long zoneId,
            @RequestParam String message) {

        return analysisLogService.addLog(zoneId, message);
    }

    // GET /logs/zone/{zoneId}
    @GetMapping("/zone/{zoneId}")
    public List<AnalysisLog> getLogsByZone(@PathVariable Long zoneId) {
        return analysisLogService.getLogsByZone(zoneId);
    }
}
