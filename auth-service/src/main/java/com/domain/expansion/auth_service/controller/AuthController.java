package com.domain.expansion.auth_service.controller;

import com.domain.expansion.auth_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (authenticate(username, password)) {
            String token = jwtUtil.generateToken(username);
            redisTemplate.opsForValue().set(token, username, 10, TimeUnit.HOURS);
            return token;
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    @GetMapping("/validate")
    public boolean validateToken(@RequestParam String token) {
        String username = redisTemplate.opsForValue().get(token);
        return username != null && jwtUtil.validateToken(token, username);
    }

    private boolean authenticate(String username, String password) {
        // 假设这里是验证逻辑
        return "user".equals(username) && "password".equals(password);
    }

    // 添加测试路由
    @GetMapping("/test")
    public String test() {
        return "Auth service is working!";
    }
}
