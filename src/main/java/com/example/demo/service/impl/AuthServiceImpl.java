package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse login(AuthRequest request) {
        return new AuthResponse(
                request.getEmail(),
                "dummy-token"
        );
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        return new AuthResponse(
                request.getEmail(),
                "dummy-token"
        );
    }
}
