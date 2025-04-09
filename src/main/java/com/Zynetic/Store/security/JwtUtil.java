package com.Zynetic.Store.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long EXPIRATION=86400000; //approx 1 dAy

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key) .compact();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch (JwtException e){
            return false;
        }
    }

    public String extractEmail(String token ){
        return Jwts.parserBuilder()
                .setSigningKey(key).build().parseClaimsJws(token)
                .getBody().getSubject();
    }
}