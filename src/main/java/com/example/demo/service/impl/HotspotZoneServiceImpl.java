package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import org.springframework.stereotype.Service;

@Service
public class HotspotZoneServiceImpl {

    public void updateZoneLocation(HotspotZone z, Double lat, Double lon) {
        // These calls will now work with the model above
        z.setLatitude(lat);
        z.setLongitude(lon);
    }
}