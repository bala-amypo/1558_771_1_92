package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patterns")
@Tag(name = "Pattern Detection")
public class PatternDetectionController {

    @PostMapping("/detect/{zoneId}")
    public String detect(@PathVariable Long zoneId) {
        return "Pattern detected for zone " + zoneId;
    }

    @GetMapping("/zone/{zoneId}")
    public String results(@PathVariable Long zoneId) {
        return "Results for zone " + zoneId;
    }
}
