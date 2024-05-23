package com.domain.expansion.auth_service.service;

import com.domain.expansion.auth_service.model.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {

    @Value("${jwt.secret}")
    private String secretKey;

    public String login(LoginRequest loginRequest) {
        // 验证用户名和密码
        if (authenticate(loginRequest.getUsername(), loginRequest.getPassword())) {
            // 生成 JWT 令牌
            return Jwts.builder()
                    .setSubject(loginRequest.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                    .compact();
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    private boolean authenticate(String username, String password) {
        // 假设这里是验证逻辑
        return "user".equals(username) && "password".equals(password);
    }
}
