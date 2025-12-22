package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.HotspotZone;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.HotspotZoneService;

@Service
public class HotspotZoneServiceImpl implements HotspotZoneService {

    private final HotspotZoneRepository repository;

    public HotspotZoneServiceImpl(HotspotZoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public HotspotZone addZone(HotspotZone zone) {
        return repository.save(zone);
    }

    @Override
    public List<HotspotZone> getZonesBySeverity(String severityLevel) {
        return repository.findBySeverityLevel(severityLevel);
    }

    @Override
    public List<HotspotZone> getAllZones() {
        return repository.findAll();
    }
}
