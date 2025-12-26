package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import com.example.demo.service.HotspotZoneService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service // This is what allows the Controller to "find" this bean
public class HotspotZoneServiceImpl implements HotspotZoneService {

    @Override
    public HotspotZone saveZone(HotspotZone zone) {
        // Logic to save to repository goes here
        return zone;
    }

    @Override
    public List<HotspotZone> getAllZones() {
        return new ArrayList<>();
    }

    @Override
    public HotspotZone getZoneById(Long id) {
        return null;
    }
}