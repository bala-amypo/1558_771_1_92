package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "analysis_logs")
public class AnalysisLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "zone_id") // This links to the HotspotZone
    private HotspotZone zone;

    private String logDetails;

    public AnalysisLog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public HotspotZone getZone() { return zone; }
    public void setZone(HotspotZone zone) { this.zone = zone; }

    public String getLogDetails() { return logDetails; }
    public void setLogDetails(String logDetails) { this.logDetails = logDetails; }
}