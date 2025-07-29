package com.example.jwtauthservice.controller;

import com.example.jwtauthservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Base64;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public String authenticate(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }

        String base64Credentials = header.substring("Basic ".length());
        String credentials = new String(Base64.getDecoder().decode(base64Credentials));
        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        // (In real apps, validate username/password from DB or service here)

        String token = jwtUtil.generateToken(username);
        return "{\"token\": \"" + token + "\"}";
    }
}
