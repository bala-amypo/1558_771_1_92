package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "crime_reports")
public class CrimeReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String crimeType;

    private String description;

    private Double latitude;

    private Double longitude;

    private LocalDateTime occurredAt;

    // ===== VALIDATION =====

    @PrePersist
    @PreUpdate
    public void validate() {
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90");
        }
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180");
        }
        if (occurredAt.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("OccurredAt cannot be in the future");
        }
    }

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}
