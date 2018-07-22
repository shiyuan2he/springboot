package com.hsy.springboot.distributed.lock.dao;

import com.hsy.java.util.cache.redis.impl.AbstractSpringRedisCacheEnhance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "redisRepository")
public class RedisRepository extends AbstractSpringRedisCacheEnhance{

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }
}
