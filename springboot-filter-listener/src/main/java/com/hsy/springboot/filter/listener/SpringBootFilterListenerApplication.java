package com.hsy.springboot.filter.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@SpringBootApplication
@ServletComponentScan({
        "com.hsy.springboot.filter.listener.filter",
        "com.hsy.springboot.filter.listener.listener"
})
public class SpringBootFilterListenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootFilterListenerApplication.class,args);
    }
}