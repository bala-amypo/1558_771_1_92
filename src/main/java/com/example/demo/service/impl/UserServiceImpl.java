package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Logic to save user to repository goes here
        return user;
    }
}