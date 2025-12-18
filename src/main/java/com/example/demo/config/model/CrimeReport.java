package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CrimeReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;
    private LocalDateTime occurredAt;

    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public LocalDateTime getOccurredAt() { return occurredAt; }
}
