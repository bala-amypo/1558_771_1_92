package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Logic to save to repository: return userRepository.save(user);
        return user;
    }

    @Override
    public User login(String email, String password) {
        // Logic to find user by email and verify password
        // Example:
        // User user = userRepository.findByEmail(email);
        // if (user != null && passwordEncoder.matches(password, user.getPassword())) {
        //     return user;
        // }
        return null;
    }
}