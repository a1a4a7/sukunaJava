package com.domain.expansion.db_cache_service.controller;

import com.domain.expansion.db_cache_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{username}")
    public String getUserInfo(@PathVariable String username) {
        return userService.getUserInfo(username);
    }
}

