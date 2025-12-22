package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(service.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return ResponseEntity.ok(
                service.login(user.getEmail(), user.getPassword())
        );
    }
}
