package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PatternDetectionResult;
import com.example.demo.service.PatternDetectionService;

@RestController
@RequestMapping("/patterns")
public class PatternDetectionController {

    private final PatternDetectionService service;

    public PatternDetectionController(PatternDetectionService service) {
        this.service = service;
    }

    @PostMapping("/{zoneId}")
    public PatternDetectionResult detect(@PathVariable Long zoneId) {
        return service.detectPattern(zoneId);
    }

    @GetMapping("/{zoneId}")
    public List<PatternDetectionResult> getByZone(@PathVariable Long zoneId) {
        return service.getResultsByZone(zoneId);
    }
}
