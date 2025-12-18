package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HotspotZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String zoneName;

    private Double centerLat;
    private Double centerLong;
    private String severityLevel;

    // getters & setters
}
