package com.domain.expansion.Sukuna.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /*controller + resBody*/ public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello, master sukuna";
    }
}
