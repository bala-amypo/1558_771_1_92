package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.HotspotZone;
import com.example.demo.service.HotspotZoneService;

@RestController
@RequestMapping("/api/hotspots")
public class HotspotZoneController {

    private final HotspotZoneService service;

    public HotspotZoneController(HotspotZoneService service) {
        this.service = service;
    }

    @PostMapping
    public HotspotZone addZone(@RequestBody HotspotZone zone) {
        return service.addZone(zone);
    }

    @GetMapping
    public List<HotspotZone> getAllZones() {
        return service.getAllZones();
    }

    @GetMapping("/severity/{level}")
    public List<HotspotZone> getBySeverity(@PathVariable String level) {
        return service.getZonesBySeverity(level);
    }
}
