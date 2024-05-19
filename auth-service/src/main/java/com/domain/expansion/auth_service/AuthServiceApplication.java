package com.domain.expansion.auth_service;

import com.domain.expansion.auth_service.exception.DatabaseConnectionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class AuthServiceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = null;
        try {
            context = SpringApplication.run(AuthServiceApplication.class, args);
        } catch (Exception e) {
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
