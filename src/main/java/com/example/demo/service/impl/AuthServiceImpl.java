package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.AppUser;
import com.example.demo.model.UserRole;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository repo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwt;

    public AuthServiceImpl(AppUserRepository repo,
                           PasswordEncoder encoder,
                           AuthenticationManager authManager,
                           JwtTokenProvider jwt) {
        this.repo = repo;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwt = jwt;
    }

    @Override
    public AuthResponse register(RegisterRequest r) {

        AppUser user = new AppUser();
        user.setEmail(r.getEmail());
        user.setPassword(encoder.encode(r.getPassword()));
        user.setFullName(r.getFullName());
        user.setRole(UserRole.CLINICIAN);

        AppUser saved = repo.save(user);
        return new AuthResponse(saved.getEmail(), jwt.generateToken(saved));
    }

    @Override
    public AuthResponse login(AuthRequest r) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        r.getEmail(),
                        r.getPassword()
                )
        );

        AppUser user = repo.findByEmail(r.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        return new AuthResponse(user.getEmail(), jwt.generateToken(user));
    }
}
