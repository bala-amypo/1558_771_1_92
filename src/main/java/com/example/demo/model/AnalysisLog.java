package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "analysis_logs")
public class AnalysisLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private HotspotZone zone;

    private String logDetails;
    private String message; // Field the service is looking for

    public AnalysisLog() {}

    // ID
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Zone Relationship
    public HotspotZone getZone() { return zone; }
    public void setZone(HotspotZone zone) { this.zone = zone; }

    // Log Details
    public String getLogDetails() { return logDetails; }
    public void setLogDetails(String logDetails) { this.logDetails = logDetails; }

    // Message (This fixes the current error)
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}