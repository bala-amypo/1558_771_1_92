package com.example.demo.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DateValidator {
    
    public boolean isNotFuture(LocalDateTime dateTime) {
        return dateTime == null || ! dateTime.isAfter(LocalDateTime.now());
    }
    
    public void validateNotFuture(LocalDateTime dateTime, String fieldName) {
        if (dateTime != null && dateTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException(fieldName + " cannot be in the future");
        }
    }
}