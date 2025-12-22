package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AnalysisLog;
import com.example.demo.service.AnalysisLogService;

@RestController
public class AnalysisLogController {

    private final AnalysisLogService service;

    public AnalysisLogController(AnalysisLogService service) {
        this.service = service;
    }

    @GetMapping("/logs/{zoneId}")
    public List<AnalysisLog> getLogs(@PathVariable Long zoneId) {
        return service.getLogsByZone(zoneId);
    }
}
