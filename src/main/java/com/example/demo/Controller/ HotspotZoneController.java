package com.example.demo.controller;

import com.example.demo.model.HotspotZone;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
@Tag(name = "Hotspot Zones")
public class HotspotZoneController {

    @PostMapping
    public HotspotZone create(@RequestBody HotspotZone zone) {
        return zone;
    }

    @GetMapping
    public List<HotspotZone> list() {
        return List.of();
    }
}
