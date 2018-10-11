package com.hsy.springboot.redis.dao.object;
import com.hsy.java.cache.redis.spring.object.impl.HashOperationsBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository(value = "hashRepository")
public class HashRedisRepository extends HashOperationsBase{

    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired JedisConnectionFactory jedisConnectionFactory;
    @Override
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }
}
