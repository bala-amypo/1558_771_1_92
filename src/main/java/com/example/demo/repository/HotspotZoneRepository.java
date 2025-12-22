package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HotspotZone;

@Repository
public interface HotspotZoneRepository extends JpaRepository<HotspotZone, Long> {

    List<HotspotZone> findBySeverityLevel(String severityLevel);
}
