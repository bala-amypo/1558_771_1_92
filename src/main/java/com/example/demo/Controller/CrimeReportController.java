package com.example.demo.controller;

import com.example.demo.model.CrimeReport;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@Tag(name = "Crime Reports")
public class CrimeReportController {

    @PostMapping
    public CrimeReport add(@RequestBody CrimeReport report) {
        return report;
    }

    @GetMapping
    public List<CrimeReport> all() {
        return List.of();
    }
}
