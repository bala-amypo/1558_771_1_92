package com.example.demo.controller;

import com.example.demo.model.AnalysisLog;
import com.example.demo.service.AnalysisLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/logs")
public class AnalysisLogController {
    
    private final AnalysisLogService logService;
    
    public AnalysisLogController(AnalysisLogService logService) {
        this.logService = logService;
    }
    
    @PostMapping("/{zoneId}")
    public ResponseEntity<AnalysisLog> addLog(@PathVariable Long zoneId, 
                                              @RequestBody Map<String, String> request) {
        String message = request.get("message");
        AnalysisLog log = logService.addLog(zoneId, message);
        return ResponseEntity.ok(log);
    }
    
    @GetMapping("/zone/{zoneId}")
    public ResponseEntity<List<AnalysisLog>> getLogsByZone(@PathVariable Long zoneId) {
        List<AnalysisLog> logs = logService.getLogsByZone(zoneId);
        return ResponseEntity.ok(logs);
    }
}