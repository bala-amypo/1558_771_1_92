package com.example.demo.controller;

import com.example.demo.config.JwtUtil;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;
    private final JwtUtil jwt;

    public AuthController(UserService service, JwtUtil jwt) {
        this.service = service;
        this.jwt = jwt;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email) {
        User u = service.findByEmail(email);
        return jwt.generateToken(u.getId(), u.getEmail(), u.getRole());
    }
}
