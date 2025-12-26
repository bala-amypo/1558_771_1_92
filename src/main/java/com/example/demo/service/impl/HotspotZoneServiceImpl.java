package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.HotspotZoneService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotspotZoneServiceImpl implements HotspotZoneService {

    private final HotspotZoneRepository repo;

    public HotspotZoneServiceImpl(HotspotZoneRepository repo) {
        this.repo = repo;
    }

    public HotspotZone addZone(HotspotZone z) {
        if (repo.existsByZoneName(z.getZoneName()))
            throw new RuntimeException("Zone exists");

        if (Math.abs(z.getCenterLat()) > 90 || Math.abs(z.getCenterLong()) > 180)
            throw new RuntimeException("Invalid latitude/longitude");

        z.setLatitude(z.getCenterLat());
        z.setLongitude(z.getCenterLong());

        return repo.save(z);
    }

    public List<HotspotZone> getAllZones() {
        return repo.findAll();
    }
}
