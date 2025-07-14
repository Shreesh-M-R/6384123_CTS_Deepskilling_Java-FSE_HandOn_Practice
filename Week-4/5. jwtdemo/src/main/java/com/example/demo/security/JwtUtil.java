package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String secretKey = "ThisIsASecretKeyUsedToSignAndVerifyJWTsWithHmacSha256ItMustBeLongEnoughToProvideSecurityAndAvoidWarningsOrExceptionsRelatedToKeyLengthEspeciallyWhenUsingStrongEncryptionAlgorithmsInProduction";

    public String generateToken(String username) {
        long currentTimeMillis = System.currentTimeMillis();
        long expirationTime = currentTimeMillis + 10 * 60 * 1000;

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(expirationTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
