package com.domain.expansion.auth_service.controller;

import com.domain.expansion.auth_service.model.LoginRequest;
import com.domain.expansion.auth_service.service.AuthService;
import com.domain.expansion.auth_service.service.MessageSenderService;
import com.domain.expansion.auth_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MessageSenderService messageSenderService;

    @GetMapping("/send")
    public String sendMessage() {
        messageSenderService.sendMessage("Hello from Auth Service");
        return "Message sent!";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            String token = authService.login(loginRequest);
            redisTemplate.opsForValue().set(token, loginRequest.getUsername(), 10, TimeUnit.HOURS);
            return ResponseEntity.ok(token);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid credentials");
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestParam String token) {
        String username = redisTemplate.opsForValue().get(token);
        boolean isValid = username != null && jwtUtil.validateToken(token, username);
        return ResponseEntity.ok(isValid);
    }

    // 示例：调用另一个微服务
    @GetMapping("/call-db-cache-service")
    public ResponseEntity<String> callOtherService() {
        String serviceUrl = "http://db-cache-service/api/resource";  // 使用服务名称而不是具体的 URL
        String response = restTemplate.getForObject(serviceUrl, String.class);
        return ResponseEntity.ok(response);
    }

    // 添加测试路由
    @GetMapping("/test")
    public String test() {
        return "Auth service is working!";
    }
}
