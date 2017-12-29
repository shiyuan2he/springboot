package com.hsy.springboot.redis.dao;

import com.hsy.java.util.cache.redis.impl.AbstractSpringRedisCacheEnhance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Repository(value = "redisRepository")
public class RedisRepository extends AbstractSpringRedisCacheEnhance{

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }
}
