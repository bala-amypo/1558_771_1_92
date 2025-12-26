package com.example.demo.controller;

import com.example.demo.config.JwtUtil;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;
    private final JwtUtil jwtUtil;

    public AuthController(UserService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> req) {
        User user = service.findByEmail(req.get("email"));
        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
        return Map.of("token", token);
    }
}
