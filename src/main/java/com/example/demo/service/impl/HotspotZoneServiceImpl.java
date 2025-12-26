package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import com.example.demo. repository.HotspotZoneRepository;
import com.example. demo.service.HotspotZoneService;
import org. springframework.stereotype.Service;

import java.util.List;

@Service
public class HotspotZoneServiceImpl implements HotspotZoneService {
    
    private final HotspotZoneRepository hotspotZoneRepository;
    
    public HotspotZoneServiceImpl(HotspotZoneRepository hotspotZoneRepository) {
        this.hotspotZoneRepository = hotspotZoneRepository;
    }
    
    @Override
    public HotspotZone addZone(HotspotZone zone) {
        // Check duplicate zone name
        if (hotspotZoneRepository.existsByZoneName(zone.getZoneName())) {
            throw new RuntimeException("Zone name already exists");
        }
        
        // Validate coordinates
        if (zone.getCenterLat() == null || zone.getCenterLat() < -90 || zone.getCenterLat() > 90) {
            throw new RuntimeException("Invalid latitude: must be between -90 and 90");
        }
        
        if (zone.getCenterLong() == null || zone.getCenterLong() < -180 || zone.getCenterLong() > 180) {
            throw new RuntimeException("Invalid longitude:  must be between -180 and 180");
        }
        
        return hotspotZoneRepository.save(zone);
    }
    
    @Override
    public List<HotspotZone> getAllZones() {
        return hotspotZoneRepository.findAll();
    }
}