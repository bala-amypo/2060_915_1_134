
package com.example.demo.security;

import com.example.demo.model.AppUser;

public class JwtTokenProvider {
    public String generateToken(AppUser user) {
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("good");
    }
}
