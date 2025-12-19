package com.example.demo.model;

import jakarta.persistence.*;
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

    private LocalDate analysisDate;

    private Integer crimeCount;

    private String detectedPattern;

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }
}
