package com.example.demo.service;

import java.util.List;

import com.example.demo.model.HotspotZone;

public interface HotspotZoneService {

    HotspotZone addZone(HotspotZone zone);

    List<HotspotZone> getZonesBySeverity(String severityLevel);

    List<HotspotZone> getAllZones();
}
