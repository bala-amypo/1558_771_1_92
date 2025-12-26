package com.example.demo.util;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class DateValidator {
    
    public boolean isFuture(LocalDateTime dateTime) {
        return dateTime.isAfter(LocalDateTime.now());
    }
    
    public boolean isPast(LocalDateTime dateTime) {
        return dateTime.isBefore(LocalDateTime.now());
    }
    
    public void validateNotFuture(LocalDateTime dateTime) {
        if (isFuture(dateTime)) {
            throw new IllegalArgumentException("Date cannot be in the future");
        }
    }
}