package com.example.demo.util;

public class CoordinateValidator {
    public static void validate(double lat, double lon) {
        if (lat < -90 || lat > 90)
            throw new IllegalArgumentException("latitude");
        if (lon < -180 || lon > 180)
            throw new IllegalArgumentException("longitude");
    }
}
