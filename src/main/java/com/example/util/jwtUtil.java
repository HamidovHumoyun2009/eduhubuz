package com.example.util;

import com.example.auth.TokenResponse;
import com.example.auth.UserRole;
import com.example.exp.UnAuthorizedException;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;

public class jwtUtil {
    private static long expiry = 1000 * 3600 * 24 * 1;

    private static String secret = "fsdgdfgdfgd42839+nyf423gikeyodun298143ydrijom!mh9l8e]fh";

    public static String encode(Integer id, UserRole role) {

        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS256, secret);

        jwtBuilder.claim("id", id);
        jwtBuilder.claim("role", role);

        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (expiry)));

        jwtBuilder.setIssuer("test");
        return jwtBuilder.compact();
    }

    public static TokenResponse decode(String token) {
        try {
            JwtParser jwtParser = Jwts.parser();
            jwtParser.setSigningKey(secret);

            Jws<Claims> jws = jwtParser.parseClaimsJws(token);
            Claims claims = jws.getBody();

            Integer id = (Integer) claims.get("id");
            String userRole = (String) claims.get("role");
            UserRole role = UserRole.valueOf(userRole);

            return new TokenResponse(id, role, encode(id, role));

        } catch (JwtException e) {
            throw new UnAuthorizedException();
        }
    }

    public static boolean checkRole(HttpServletRequest request, UserRole... roles) {

        String token = request
                .getHeader("Authorization")
                .substring(7);

        TokenResponse response = decode(token);

        for (UserRole role : roles) {
            if (response.getRole() == role) {
                return true;
            }
        }
        return false;
    }
}
