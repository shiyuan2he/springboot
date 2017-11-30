package com.hsy.springboot.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hsy.springboot.async")
public class SpringBootAsyncApplication{
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAsyncApplication.class,args) ;
    }
}
