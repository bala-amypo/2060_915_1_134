package com.example.demo.security;

import com.example.demo.model.AppUser;
import com.example.demo.model.UserRole;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {
    
    private final SecretKey key;
    private final long validityInMs;
    
    public JwtTokenProvider(@Value("${app.jwt.secret}") String secret, 
                           @Value("${app.jwt.expiration}") long validityInMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityInMs = validityInMs;
    }
    
    public String generateToken(AppUser user) {
        Claims claims = Jwts.claims().setSubject(user.getEmail());
        claims.put("userId", user.getId());
        claims.put("role", user.getRole().toString());
        
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMs);
        
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }
    
    public Long getUserIdFromToken(String token) {
        return ((Number) getAllClaimsFromToken(token).get("userId")).longValue();
    }
    
    public String getEmailFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }
    
    public UserRole getRoleFromToken(String token) {
        return UserRole.valueOf((String) getAllClaimsFromToken(token).get("role"));
    }
    
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}