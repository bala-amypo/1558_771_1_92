package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.HotspotZone;
import com.example.demo.service.HotspotZoneService;

@RestController
@RequestMapping("/zones")
public class HotspotZoneController {

    private final HotspotZoneService service;

    public HotspotZoneController(HotspotZoneService service) {
        this.service = service;
    }

    @PostMapping
    public HotspotZone create(@RequestBody HotspotZone zone) {
        return service.addZone(zone);
    }

    @GetMapping
    public List<HotspotZone> list() {
        return service.getAllZones();
    }
}
