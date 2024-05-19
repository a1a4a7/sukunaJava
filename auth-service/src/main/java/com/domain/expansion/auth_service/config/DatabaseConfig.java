package com.domain.expansion.auth_service.config;

import com.domain.expansion.auth_service.exception.DatabaseConnectionException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class DatabaseConfig implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        try {
            // 尝试连接数据库
            // 你可以在这里添加实际的数据库连接逻辑
        } catch (Exception e) {
            if (e.getCause() instanceof SQLException) {
                System.err.println("Failed to connect to the database: " + e.getCause().getMessage());
                throw new DatabaseConnectionException("Failed to connect to the database", e);
                // 或者你可以选择继续运行应用程序，而不是抛出异常
                // System.err.println("Continuing application without database connection...");
            } else {
                throw e;
            }
        }
    }
}
