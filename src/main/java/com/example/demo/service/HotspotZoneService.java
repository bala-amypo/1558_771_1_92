package com.example.demo.service;

import com.example.demo.model.HotspotZone;
import java.util.List;

public interface HotspotZoneService {
    HotspotZone saveZone(HotspotZone zone);
    List<HotspotZone> getAllZones();
    HotspotZone getZoneById(Long id);
}