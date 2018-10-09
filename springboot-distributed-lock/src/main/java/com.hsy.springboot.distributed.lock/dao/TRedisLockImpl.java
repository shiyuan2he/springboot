package com.hsy.springboot.distributed.lock.dao;

import com.hsy.java.util.cache.redis.impl.AbstractSpringRedisLock;
import com.hsy.springboot.distributed.lock.utils.DBUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.distributed.lock.dao
 * @date 2018/7/20 10:42
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Repository(value = "redisLock")
public class TRedisLockImpl extends AbstractSpringRedisLock {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Override
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }
}
