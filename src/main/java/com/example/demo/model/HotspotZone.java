package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hotspot_zones")
public class HotspotZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zoneName;
    private Double latitude;
    private Double longitude;
    private String severityLevel;

    public HotspotZone() {}

    // ID
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Zone Name
    public String getZoneName() { return zoneName; }
    public void setZoneName(String zoneName) { this.zoneName = zoneName; }

    // Latitude / CenterLat Aliases
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    
    public Double getCenterLat() { return latitude; }
    public void setCenterLat(Double centerLat) { this.latitude = centerLat; }

    // Longitude / CenterLong Aliases
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    
    public Double getCenterLong() { return longitude; }
    public void setCenterLong(Double centerLong) { this.longitude = centerLong; }

    // Severity
    public String getSeverityLevel() { return severityLevel; }
    public void setSeverityLevel(String severityLevel) { this.severityLevel = severityLevel; }
}