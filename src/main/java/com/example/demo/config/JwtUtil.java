package com.example.demo.config;

import io.jsonwebtoken.*;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final String SECRET = "secretkey123";

    public String generateToken(Long id, String email, String role) {
        return Jwts.builder()
                .setClaims(Map.of("userId", id, "email", email, "role", role))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
