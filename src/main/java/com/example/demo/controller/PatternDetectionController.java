package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class PatternDetectionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalReports;
    private String message;
    private Long zoneId;

    public Long getId() {
        return id;
    }

    public int getTotalReports() {
        return totalReports;
    }

    public void setTotalReports(int totalReports) {
        this.totalReports = totalReports;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
}
