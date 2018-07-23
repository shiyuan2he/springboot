package com.hsy.springboot.distributed.lock.dao;

import com.hsy.springboot.distributed.lock.DistributedLockApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.distributed.lock.dao
 * @date 2018/7/23 8:40
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@SpringBootTest(classes = DistributedLockApplication.class)
@RunWith(SpringRunner.class)
public class RedisRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RedisRepository redisRepository;

    @Test
    public void testRedis(){
        logger.info("开始业务");
        String key = "TO:redisLock";
        if(redisRepository.getRedisTemplate().getConnectionFactory().getConnection().setNX(key.getBytes(), "redisLock".getBytes())){
            redisRepository.getRedisTemplate().getConnectionFactory().getConnection().expire(key.getBytes(), 1000 * 300);
            logger.info("进入lock区");
            logger.info("获取到数据库锁");
            redisRepository.getRedisTemplate().getConnectionFactory().getConnection().del(key.getBytes());
        }else{
            logger.info("没有拿到锁，请求返回");
        }
        logger.info("结束业务");
    }
}