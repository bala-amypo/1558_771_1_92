package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "hotspot_zones",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "zoneName")
    }
)
public class HotspotZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String zoneName;

    private Double centerLat;

    private Double centerLong;

    private String severityLevel; // LOW / MEDIUM / HIGH

    @PrePersist
    @PreUpdate
    public void validateCoordinates() {
        if (centerLat < -90 || centerLat > 90) {
            throw new IllegalArgumentException("Invalid latitude");
        }
        if (centerLong < -180 || centerLong > 180) {
            throw new IllegalArgumentException("Invalid longitude");
        }
    }

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }
}
