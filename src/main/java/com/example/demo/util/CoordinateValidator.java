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
            throw new IllegalArgumentException("Invalid latitude: must be between -90 and 90");
        }
        if (!isValidLongitude(longitude)) {
            throw new IllegalArgumentException("Invalid longitude: must be between -180 and 180");
        }
    }
}