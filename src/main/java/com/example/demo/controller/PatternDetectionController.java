package com.example.demo.controller;

import com.example.demo.service.PatternDetectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patterns")
public class PatternDetectionController {

    private final PatternDetectionService patternService;

    // Constructor Injection
    public PatternDetectionController(PatternDetectionService patternService) {
        this.patternService = patternService;
    }

    @PostMapping("/analyze")
    public void runAnalysis() {
        patternService.detectPatterns();
    }
}