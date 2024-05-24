package com.domain.expansion.auth_service.service;

import com.domain.expansion.auth_service.model.LoginRequest;
import com.domain.expansion.auth_service.model.User;
import com.domain.expansion.auth_service.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Value("${jwt.secret}")
    private String secretKey;

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(LoginRequest loginRequest) {
        logger.info("Login attempt for username: {}", loginRequest.getUsername());
        if (authenticate(loginRequest.getUsername(), loginRequest.getPassword())) {
            logger.info("Authentication successful for username: {}", loginRequest.getUsername());
            return Jwts.builder()
                    .setSubject(loginRequest.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                    .compact();
        } else {
            logger.error("Authentication failed for username: {}", loginRequest.getUsername());
            throw new RuntimeException("Invalid credentials");
        }
    }

    private boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            logger.error("User not found: {}", username);
            return false;
        }
        if (!user.getPassword().equals(password)) {
            logger.error("Password mismatch for username: {}", username);
            return false;
        }
        return true;
    }
}
