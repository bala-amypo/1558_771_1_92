package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "hotspot_zones")
public class HotspotZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "zone_name", unique = true)
    private String zoneName;
    
    @Column(name = "center_lat")
    private Double centerLat;
    
    @Column(name = "center_long")
    private Double centerLong;
    
    @Column(name = "severity_level")
    private String severityLevel;
    
    // Constructors
    public HotspotZone() {}
    
    public HotspotZone(String zoneName, Double centerLat, Double centerLong, String severityLevel) {
        this.zoneName = zoneName;
        this.centerLat = centerLat;
        this.centerLong = centerLong;
        this.severityLevel = severityLevel;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getZoneName() { return zoneName; }
    public void setZoneName(String zoneName) { this.zoneName = zoneName; }
    
    public Double getCenterLat() { return centerLat; }
    public void setCenterLat(Double centerLat) { this.centerLat = centerLat; }
    
    public Double getCenterLong() { return centerLong; }
    public void setCenterLong(Double centerLong) { this.centerLong = centerLong; }
    
    public String getSeverityLevel() { return severityLevel; }
    public void setSeverityLevel(String severityLevel) { this.severityLevel = severityLevel; }
}