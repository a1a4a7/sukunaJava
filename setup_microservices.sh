#!/bin/bash

# 项目根目录
ROOT_DIR="/Users/mankitho/Desktop/---projects_2024---/Sukuna"
SRC_MAIN_JAVA="$ROOT_DIR/src/main/java/com/domain/expansion/Sukuna"
SRC_MAIN_RESOURCES="$ROOT_DIR/src/main/resources"

# 服务列表
SERVICES=("auth-service" "api-gateway-service" "communications-service" "cicd-service" "db-cache-service" "docs-testing-service" "exception-service" "monitoring-logs-service" "message-queue-service")

# 创建服务目录和基本文件
for SERVICE in "${SERVICES[@]}"; do
    SERVICE_DIR="$ROOT_DIR/$SERVICE"
    SERVICE_PACKAGE=$(echo "$SERVICE" | tr '-' '_')
    SERVICE_CLASS=$(echo "$SERVICE_PACKAGE" | awk -F'-' '{for(i=1;i<=NF;i++){printf toupper(substr($i,1,1)) substr($i,2)}}')

    # 创建目录结构
    mkdir -p "$SERVICE_DIR/src/main/java/com/domain/expansion/$SERVICE_PACKAGE/config"
    mkdir -p "$SERVICE_DIR/src/main/java/com/domain/expansion/$SERVICE_PACKAGE/controller"
    mkdir -p "$SERVICE_DIR/src/main/java/com/domain/expansion/$SERVICE_PACKAGE/repository"
    mkdir -p "$SERVICE_DIR/src/main/java/com/domain/expansion/$SERVICE_PACKAGE/service"
    mkdir -p "$SERVICE_DIR/src/main/resources"

    # 创建pom.xml文件
    SERVICE_POM_XML=$(cat <<EOF
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.domain.expansion</groupId>
        <artifactId>Sukuna</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>$SERVICE</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>$SERVICE-service</name>
    <description>$SERVICE Service</description>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
            <version>0.9.1</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
    </dependencies>

</project>
EOF
    )
    echo "$SERVICE_POM_XML" > "$SERVICE_DIR/pom.xml"

    # 创建application.properties文件
    SERVICE_APP_PROPERTIES=$(cat <<EOF
spring.application.name=$SERVICE-service
server.port=8080

eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
EOF
    )
    echo "$SERVICE_APP_PROPERTIES" > "$SERVICE_DIR/src/main/resources/application.properties"

    # 创建主类
    SERVICE_MAIN_CLASS=$(cat <<EOF
package com.domain.expansion.$SERVICE_PACKAGE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ${SERVICE_CLASS}Application {
    public static void main(String[] args) {
        SpringApplication.run(${SERVICE_CLASS}Application.class, args);
    }
}
EOF
    )
    echo "$SERVICE_MAIN_CLASS" > "$SERVICE_DIR/src/main/java/com/domain/expansion/$SERVICE_PACKAGE/${SERVICE_CLASS}Application.java"
done

echo "所有服务的目录结构和基本文件已创建成功。"
