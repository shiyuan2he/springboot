package com.hsy.springboot.canal.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * https://www.cnblogs.com/benwu/articles/8616141.html
 */
@Data
@Component(value = "redisPoolConfig")
@ConfigurationProperties(prefix = "redis.pool")
public class RedisPoolConfig {
    private int maxActive;
    private int maxTotal;
    private int maxIdle;
    private int minIdle; // 毫秒
    private int maxWaitMillis; // 毫秒
    private boolean testOnBorrow;
    private boolean testWhileIdle;
    private boolean testOnReturn;
    private int minEvictableIdleTimeMillis; // 毫秒
    private int softMinEvictableIdleTimeMillis; // 毫秒
    private int timeBetweenEvictionRunsMillis; // 毫秒
    private int numTestsPerEvictionRun; // 毫秒
}
