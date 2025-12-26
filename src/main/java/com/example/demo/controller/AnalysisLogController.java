package com.example.demo.controller;

import com.example.demo.model. AnalysisLog;
import com.example.demo.service. AnalysisLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger. v3.oas.annotations. tags.Tag;
import org. springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/logs")
@Tag(name = "Analysis Logs", description = "Analysis log management endpoints")
@SecurityRequirement(name = "Bearer Authentication")
public class AnalysisLogController {
    
    private final AnalysisLogService analysisLogService;
    
    public AnalysisLogController(AnalysisLogService analysisLogService) {
        this.analysisLogService = analysisLogService;
    }
    
    @PostMapping("/{zoneId}")
    @Operation(summary = "Add an analysis log for a zone")
    public ResponseEntity<?> addLog(@PathVariable Long zoneId, @RequestBody Map<String, String> payload) {
        try {
            String message = payload.get("message");
            AnalysisLog log = analysisLogService.addLog(zoneId, message);
            return ResponseEntity.ok(log);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/zone/{zoneId}")
    @Operation(summary = "Get logs for a zone")
    public ResponseEntity<List<AnalysisLog>> getLogsByZone(@PathVariable Long zoneId) {
        return ResponseEntity.ok(analysisLogService.getLogsByZone(zoneId));
    }
}