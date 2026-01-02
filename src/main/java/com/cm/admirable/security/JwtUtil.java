package com.cm.admirable.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private final Key secretkey=Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long EXPERTATION_TIME =100000000;
    public boolean validateToken(String token){
        try {
            extractUsername(token);
            return true;
        }catch(JwtException jwtException){
            return false;
        }
    }
    public String extractUsername(String token){
        return Jwts.parserBuilder().setSigningKey(secretkey).build().parseClaimsJwt(token).getBody().getSubject();
    }

    public String generateToken(String email){
        return Jwts.builder().setSubject(email).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+EXPERTATION_TIME))
                .signWith(secretkey).compact();
    }
}
