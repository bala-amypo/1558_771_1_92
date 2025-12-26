package com.example.demo.controller;

import com.example.demo.config.JwtUtil;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;
    private final JwtUtil jwtUtil = new JwtUtil();

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email) {
        User user = service.findByEmail(email);
        return jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
    }
}
