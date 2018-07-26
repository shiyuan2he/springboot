package com.hsy.springboot.redis;

import com.hsy.springboot.redis.dao.StringRedisRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring/com.hsy.spring.redis.dao
 * @date 2018/7/24 10:13
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRedisApplication.class)
public class StringRedisRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired private StringRedisRepository stringRedisRepository;
    @Test
    public void testSet(){
        stringRedisRepository.set("name", "robot");
        stringRedisRepository.set("name", "robot", 60);
        stringRedisRepository.set("name2", "robot", 1600, TimeUnit.SECONDS);
    }

    @Test
    public void testGet(){
        logger.info(stringRedisRepository.get("name", false));
        logger.info(stringRedisRepository.get("name", true));
        logger.info(stringRedisRepository.getAndSet("name", "new value",false));
        logger.info(stringRedisRepository.getAndSet("name", "new value",true));
    }

    @Test
    public void testIncrement(){
        for (int i = 0; i < 10; i++) {
            logger.info("{}", stringRedisRepository.increment("mobile:15911111111", 1l, 60, TimeUnit.MINUTES));
            logger.info("{}", stringRedisRepository.increment("tel:15911111111", 1.0, 70, TimeUnit.MINUTES));
        }
    }
    @Test
    public void testSetArray(){
        for (int i = 0; i < 10; i++) {
            logger.info("{}", stringRedisRepository.addSet("set:array1",String.valueOf(i)));
        }
        for (int i = 5; i < 20; i++) {
            logger.info("{}", stringRedisRepository.addSet("set:array1",String.valueOf(i)));
            logger.info("{}", stringRedisRepository.addSet("set:array2",String.valueOf(i)));
        }
        //logger.info("{}", stringRedisRepository.popSet("set:array"));
        logger.info("{}", stringRedisRepository.difference("set:array1","set:array2"));
        logger.info("{}", stringRedisRepository.differenceAndStore("set:array1","set:array2", "set:array3"));
    }
    @Test
    public void testList(){
        for (int i = 0; i < 10; i++) {
            logger.info("{}", stringRedisRepository.leftPush("list:lilo", String.valueOf(i)));
            logger.info("{}", stringRedisRepository.leftPush("list:liro", String.valueOf(i)));
            logger.info("{}", stringRedisRepository.rightPush("list:rilo", String.valueOf(i)));
            logger.info("{}", stringRedisRepository.rightPush("list:riro", String.valueOf(i)));
        }

        for (int i = 0; i < 5; i++) {
            logger.info("{}", stringRedisRepository.leftPop("list:lilo"));
            logger.info("{}", stringRedisRepository.rightPop("list:liro"));
            logger.info("{}", stringRedisRepository.leftPop("list:rilo"));
            logger.info("{}", stringRedisRepository.rightPop("list:riro"));
        }
    }
    @Test
    public void testZSet(){
      /*  for (int i = 0; i < 10; i++) {
            logger.info("{}", stringRedisRepository.addZSet("zset", String.valueOf(i), i+1));
        }*/
        stringRedisRepository.incrementScore("zset", "4", 30);
    }
    @Test
    public void testHash(){
        for (int i = 0; i < 10; i++) {
            stringRedisRepository.put4Hash("hash", String.valueOf(i), String.valueOf(i));
            logger.info("{}", stringRedisRepository.get("hash", String.valueOf(i)));
        }
    }
}