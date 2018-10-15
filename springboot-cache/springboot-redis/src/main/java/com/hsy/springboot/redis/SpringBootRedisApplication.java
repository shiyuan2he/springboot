package com.hsy.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRedisApplication {

    public static void main(String[] args) {
        // 最简单的启动方式
//        SpringApplication.run(SpringBootRedisApplication.class,args) ;

        // 启动Spring的应用上下文
        SpringApplication app = new SpringApplication(SpringBootRedisApplication.class);

        // app.setWebEnvironment(true);

        // Set<Object> set = new HashSet<Object>();
        // set.add("classpath:applicationContext.xml");

        // app.setSources(set);
        app.run(args);
    }
}
