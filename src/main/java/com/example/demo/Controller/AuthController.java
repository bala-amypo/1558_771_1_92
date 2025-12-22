package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth Controller")
public class AuthController {

    @PostMapping("/register")
    public String register() {
        return "User Registered";
    }

    @PostMapping("/login")
    public String login() {
        return "User Logged In";
    }
}
