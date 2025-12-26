package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PatternDetectionResult {

    @Id
    @GeneratedValue
    private Long id;

    private Integer crimeCount;
    private String detectedPattern;
    private LocalDate analysisDate = LocalDate.now();

    @ManyToOne
    private HotspotZone zone;

    public Long getId() { return id; }

    public Integer getCrimeCount() { return crimeCount; }
    public void setCrimeCount(Integer crimeCount) { this.crimeCount = crimeCount; }

    public String getDetectedPattern() { return detectedPattern; }
    public void setDetectedPattern(String detectedPattern) { this.detectedPattern = detectedPattern; }

    public LocalDate getAnalysisDate() { return analysisDate; }
    public void setAnalysisDate(LocalDate analysisDate) { this.analysisDate = analysisDate; }

    public HotspotZone getZone() { return zone; }
    public void setZone(HotspotZone zone) { this.zone = zone; }
}
