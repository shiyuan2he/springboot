package com.hsy.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRedisCacheApplication {

    public static void main(String[] args) {
        // 启动Spring的应用上下文
        SpringApplication app = new SpringApplication(SpringBootRedisCacheApplication.class);
        app.run(args);
    }
}
