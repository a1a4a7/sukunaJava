package com.domain.expansion.db_cache_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/api/resource")
    public ResponseEntity<String> getResource() {
        // 返回简单的响应，您可以根据实际需求进行修改
        return ResponseEntity.ok("Response from db-cache-service");
    }
}