package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PatternDetectionResult;
import com.example.demo.service.PatternDetectionService;

@RestController
public class PatternDetectionController {

    private final PatternDetectionService service;

    public PatternDetectionController(PatternDetectionService service) {
        this.service = service;
    }

    @GetMapping("/patterns/{zoneId}")
    public PatternDetectionResult detect(@PathVariable Long zoneId) {
        return service.detectPattern(zoneId);
    }
}
