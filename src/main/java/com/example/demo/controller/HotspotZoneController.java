package com.example.demo.controller;

import com.example.demo.model.HotspotZone;
import com.example.demo.service.HotspotZoneService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hotspots")
public class HotspotZoneController {

    private final HotspotZoneService hotspotZoneService;

    // Constructor Injection
    public HotspotZoneController(HotspotZoneService hotspotZoneService) {
        this.hotspotZoneService = hotspotZoneService;
    }

    @GetMapping
    public List<HotspotZone> getAllHotspots() {
        return hotspotZoneService.getAllZones();
    }

    @PostMapping
    public HotspotZone createHotspot(@RequestBody HotspotZone zone) {
        return hotspotZoneService.saveZone(zone);
    }
}