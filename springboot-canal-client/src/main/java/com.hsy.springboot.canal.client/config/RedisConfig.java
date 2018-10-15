package com.hsy.springboot.canal.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * https://www.cnblogs.com/benwu/articles/8616141.html
 */
@Component(value = "redisConfig")
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig {
    private String host;
    private int port;
    private int timeout; // 毫秒
    private String password;
    private int database;
}
