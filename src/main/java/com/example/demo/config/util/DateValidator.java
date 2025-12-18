package com.example.demo.util;

import java.time.LocalDateTime;

public class DateValidator {

    public static void validate(LocalDateTime time) {
        if (time.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("future");
        }
    }
}
