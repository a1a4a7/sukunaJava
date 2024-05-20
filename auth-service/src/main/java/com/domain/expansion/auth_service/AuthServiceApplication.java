package com.domain.expansion.auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
// @config 是个sprinng BEAN +
// @EnableAutoConfig 自动DI constructor, 不用写DataSource +
// @CompScan 其他包
public class AuthServiceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = null;
        try {
            // 状态 = context + DI
            // srping continar + DI beans , scan for @anno.
            // pom.xml -> tmocat
            // pub sub ?
            // tell 谁是主config类
            context = SpringApplication.run(AuthServiceApplication.class, args);
        } catch (Exception e) {
            // throwable class
            if (e.getCause() instanceof SQLException) {

                System.err.println("Failed to connect to the database: " + e.getCause().getMessage());
                // Log the exception and continue running the application
                // Here you can set a flag or take other actions
            } else {
                throw e;
            }
        }

        // Application logic continues here
        if (context != null) {
            // If the application context is initialized, proceed with the rest of your application
        }
    }
}
