package com.domain.expansion.Sukuna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SukunaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SukunaApplication.class, args);
    }

}
