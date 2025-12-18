package com.example.demo.util;

public class CoordinateValidator {

    public static void validate(double latitude, double longitude) {
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("latitude");
        }
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("longitude");
        }
    }
}
