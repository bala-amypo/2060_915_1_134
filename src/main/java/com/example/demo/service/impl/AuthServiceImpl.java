package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthServiceImpl implements AuthService {

    private final AppUserRepository repo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwt;

    public AuthServiceImpl(AppUserRepository r, PasswordEncoder e,
                           AuthenticationManager a, JwtTokenProvider j) {
        this.repo = r; this.encoder = e; this.authManager = a; this.jwt = j;
    }

    public AuthResponse register(RegisterRequest r) {
        AppUser u = AppUser.builder()
                .email(r.getEmail())
                .password(encoder.encode(r.getPassword()))
                .fullName(r.getFullName())
                .role(UserRole.CLINICIAN)
                .build();

        AppUser saved = repo.save(u);
        return new AuthResponse(saved.getEmail(), jwt.generateToken(saved));
    }

    public AuthResponse login(AuthRequest r) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(r.getEmail(), r.getPassword())
        );

        AppUser user = repo.findByEmail(r.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid"));

        return new AuthResponse(user.getEmail(), jwt.generateToken(user));
    }
}
