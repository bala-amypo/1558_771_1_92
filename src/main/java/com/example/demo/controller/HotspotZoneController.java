package com.example.demo.controller;

import com.example.demo.model.HotspotZone;
import com.example.demo.service.HotspotZoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/zones")
public class HotspotZoneController {
    
    private final HotspotZoneService zoneService;
    
    public HotspotZoneController(HotspotZoneService zoneService) {
        this.zoneService = zoneService;
    }
    
    @PostMapping
    public ResponseEntity<HotspotZone> addZone(@RequestBody HotspotZone zone) {
        HotspotZone savedZone = zoneService.addZone(zone);
        return ResponseEntity.ok(savedZone);
    }
    
    @GetMapping
    public ResponseEntity<List<HotspotZone>> getAllZones() {
        List<HotspotZone> zones = zoneService.getAllZones();
        return ResponseEntity.ok(zones);
    }
}