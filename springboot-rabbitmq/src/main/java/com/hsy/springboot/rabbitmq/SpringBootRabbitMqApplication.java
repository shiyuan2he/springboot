package com.hsy.springboot.rabbitmq;

import com.hsy.springboot.rabbitmq.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class SpringBootRabbitMqApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitMqApplication.class,args);
    }

    @Autowired
    Producer producer;

    @Override
    public void run(String... strings) throws Exception {
        while (true){
            producer.sendMessageRabbitmq(UUID.randomUUID().toString());
        }
    }
}
