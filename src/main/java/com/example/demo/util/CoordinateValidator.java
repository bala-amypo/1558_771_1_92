package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class CoordinateValidator {
    
    public boolean isValidLatitude(Double latitude) {
        return latitude != null && latitude >= -90 && latitude <= 90;
    }
    
    public boolean isValidLongitude(Double longitude) {
        return longitude != null && longitude >= -180 && longitude <= 180;
    }
    
    public void validateCoordinates(Double latitude, Double longitude) {
        if (!isValidLatitude(latitude)) {
            throw new IllegalArgumentException("Invalid latitude value: " + latitude);
        }
        if (!isValidLongitude(longitude)) {
            throw new IllegalArgumentException("Invalid longitude value: " + longitude);
        }
    }
}