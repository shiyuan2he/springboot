package com.hsy.springboot.redis.dao.string;

import com.hsy.java.cache.redis.spring.string.impl.HashOperationsBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository(value = "hashStringRepository")
public class HashRedisRepository extends HashOperationsBase {

    @Autowired private StringRedisTemplate stringRedisTemplate;

    @Override
    public StringRedisTemplate getStringRedisTemplate() {
        log.info("正在初始化stringRedisTemplate。。。");
        if(null==stringRedisTemplate){
            log.error("spring容器未注入StringRedisTemplate。。。初始化redis失败");
        }
        return stringRedisTemplate;
    }
}
