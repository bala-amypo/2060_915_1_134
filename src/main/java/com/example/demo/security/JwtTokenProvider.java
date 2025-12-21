package com.example.demo.security;

import com.example.demo.model.AppUser;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(AppUser user) {
        // dummy token for now (enough for tests & startup)
        return "dummy-jwt-token-for-" + user.getEmail();
    }
}
