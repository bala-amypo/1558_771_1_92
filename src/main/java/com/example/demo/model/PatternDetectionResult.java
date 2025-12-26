package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pattern_detection_results")
public class PatternDetectionResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "zone_id")
    private HotspotZone zone;
    
    @Column(name = "analysis_date")
    private LocalDate analysisDate;
    
    @Column(name = "crime_count")
    private Integer crimeCount;
    
    @Column(name = "detected_pattern")
    private String detectedPattern;
    
    // Constructors
    public PatternDetectionResult() {}
    
    public PatternDetectionResult(HotspotZone zone, LocalDate analysisDate, 
                                 Integer crimeCount, String detectedPattern) {
        this.zone = zone;
        this.analysisDate = analysisDate;
        this.crimeCount = crimeCount;
        this.detectedPattern = detectedPattern;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public HotspotZone getZone() { return zone; }
    public void setZone(HotspotZone zone) { this.zone = zone; }
    
    public LocalDate getAnalysisDate() { return analysisDate; }
    public void setAnalysisDate(LocalDate analysisDate) { this.analysisDate = analysisDate; }
    
    public Integer getCrimeCount() { return crimeCount; }
    public void setCrimeCount(Integer crimeCount) { 
        if (crimeCount < 0) {
            throw new IllegalArgumentException("Crime count cannot be negative");
        }
        this.crimeCount = crimeCount; 
    }
    
    public String getDetectedPattern() { return detectedPattern; }
    public void setDetectedPattern(String detectedPattern) { 
        if (detectedPattern == null || detectedPattern.trim().isEmpty()) {
            throw new IllegalArgumentException("Pattern text cannot be empty");
        }
        this.detectedPattern = detectedPattern; 
    }
}