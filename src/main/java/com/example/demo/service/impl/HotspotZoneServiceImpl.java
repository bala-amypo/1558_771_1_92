package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.HotspotZoneService;
import com.example.demo.util.CoordinateValidator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotspotZoneServiceImpl implements HotspotZoneService {
    
    private final HotspotZoneRepository zoneRepository;
    private final CoordinateValidator coordinateValidator;
    
    public HotspotZoneServiceImpl(HotspotZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
        this.coordinateValidator = new CoordinateValidator();
    }
    
    @Override
    public HotspotZone addZone(HotspotZone zone) {
        // Validate coordinates
        if (!coordinateValidator.isValidLatitude(zone.getCenterLat())) {
            throw new IllegalArgumentException("Invalid latitude value");
        }
        if (!coordinateValidator.isValidLongitude(zone.getCenterLong())) {
            throw new IllegalArgumentException("Invalid longitude value");
        }
        
        // Check for duplicate zone name
        if (zoneRepository.existsByZoneName(zone.getZoneName())) {
            throw new IllegalArgumentException("Zone name already exists");
        }
        
        // Set default severity if not provided
        if (zone.getSeverityLevel() == null) {
            zone.setSeverityLevel("MEDIUM");
        }
        
        return zoneRepository.save(zone);
    }
    
    @Override
    public List<HotspotZone> getAllZones() {
        return zoneRepository.findAll();
    }
}