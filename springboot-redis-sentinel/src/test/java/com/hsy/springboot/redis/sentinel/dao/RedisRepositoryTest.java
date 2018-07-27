package com.hsy.springboot.redis.sentinel.dao;

import com.hsy.springboot.redis.sentinel.RedisSentinelApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring/com.hsy.spring.redis.dao
 * @date 2018/7/23 18:42
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@SuppressWarnings("Duplicates")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisSentinelApplication.class)
public class RedisRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired private RedisRepository redisRepository;

    public Map<String, Object> generateMap(){
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("aa", "aa");
        Map<String, Object> innerMap = new HashMap<>();
        innerMap.put("ss", 3);
        innerMap.put("rr",false);
        innerMap.put("tt","中文");
        returnMap.put("bb", innerMap);
        returnMap.put("cc", 1.000);
        returnMap.put("dd", true);
        returnMap.put("ee", 2);
        return returnMap;
    }
    public List<Map<String, Object>> generateList(){
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(generateMap());
        }
        return list;
    }
    @Test
    public void clear(){
        redisRepository.clear();
    }
    @Test
    public void testSet(){
        redisRepository.valueSet("name", "robot");
        redisRepository.valueSet("name2", "robot", 1600, TimeUnit.SECONDS);
        redisRepository.valueSet("set:map", generateMap());
        redisRepository.valueSet("set:map", generateMap(), 1600, TimeUnit.SECONDS);
        redisRepository.valueSet("set:list", generateList());
        redisRepository.valueSet("set:list", generateList(), 1600, TimeUnit.SECONDS);
    }
    @Test
    public void delete(){
        redisRepository.delete("name" , false);
        redisRepository.delete("name2", true);
    }
    @Test
    public void testGet(){
        logger.info("{}", redisRepository.valueGet("name", false));
        logger.info("{}", redisRepository.valueGet("name2", true));
        logger.info("{}", redisRepository.valueGet("set:map", false));
        logger.info("{}", redisRepository.valueGet("set:map", true));
        logger.info("{}", redisRepository.valueGet("set:list", false));
        logger.info("{}", redisRepository.valueGet("set:list", true));
        //logger.info("{}", redisRepository.getAndSet("name", "new value",false));
        //logger.info("{}", redisRepository.getAndSet("name", "new value",true));
    }

    @Test
    public void testIncrement(){
        for (int i = 0; i < 10; i++) {
            logger.info("{}", redisRepository.valueIncrement("mobile:15911111111", 1l, 60, TimeUnit.MINUTES));
            logger.info("{}", redisRepository.valueIncrement("tel:15911111111", 1.0, 70, TimeUnit.MINUTES));
        }
    }
    @Test
    public void testSetArray(){
        for (int i = 0; i < 10; i++) {
            logger.info("{}", redisRepository.setAdd("set:array1",i));
        }
        for (int i = 5; i < 20; i++) {
            logger.info("{}", redisRepository.setAdd("set:array1",i));
            logger.info("{}", redisRepository.setAdd("set:array2",i));
        }
        //logger.info("{}", redisRepository.setPop("set:array"));
        logger.info("{}", redisRepository.setDifference("set:array1","set:array2"));
        logger.info("{}", redisRepository.setDifferenceAndStore("set:array1","set:array2", "set:array3"));

        logger.info("{}", redisRepository.setAdd("set:add:map",generateMap()));
        logger.info("{}", redisRepository.setAdd("set:add:list",generateList()));
        logger.info("{}", redisRepository.setPop("set:add:map"));
        logger.info("{}", redisRepository.setPop("set:add:list"));
    }
    @Test
    public void testList(){
        for (int i = 0; i < 10; i++) {
            logger.info("{}", redisRepository.listLeftPush("list:lilo:list", generateList()));
            logger.info("{}", redisRepository.listLeftPush("list:liro:list", generateList()));
            logger.info("{}", redisRepository.listRightPush("list:rilo:list", generateList()));
            logger.info("{}", redisRepository.listRightPush("list:riro:list", generateList()));
        }

        for (int i = 0; i < 5; i++) {
            logger.info("{}", redisRepository.listLeftPop("list:lilo:list"));
            logger.info("{}", redisRepository.listRightPop("list:liro:list"));
            logger.info("{}", redisRepository.listLeftPop("list:rilo:list"));
            logger.info("{}", redisRepository.listRightPop("list:riro:list"));
        }
        for (int i = 0; i < 10; i++) {
            logger.info("{}", redisRepository.listLeftPush("list:lilo:map", generateMap()));
            logger.info("{}", redisRepository.listLeftPush("list:liro:map", generateMap()));
            logger.info("{}", redisRepository.listRightPush("list:rilo:map", generateMap()));
            logger.info("{}", redisRepository.listRightPush("list:riro:map", generateMap()));
        }

        for (int i = 0; i < 5; i++) {
            logger.info("{}", redisRepository.listLeftPop("list:lilo:map"));
            logger.info("{}", redisRepository.listRightPop("list:liro:map"));
            logger.info("{}", redisRepository.listLeftPop("list:rilo:map"));
            logger.info("{}", redisRepository.listRightPop("list:riro:map"));
        }
    }
    @Test
    public void testZSet(){
        for (int i = 0; i < 10; i++) {
            logger.info("{}", redisRepository.zSetAdd("zset:map", generateMap(), i));
        }
        redisRepository.zSetIncrementScore("zset:Map", "4", 30);
    }
    @Test
    public void testHash(){
        for (int i = 0; i < 10; i++) {
            redisRepository.hashPut("hash:map", String.valueOf(i), generateMap());
            logger.info("{}", redisRepository.hashGet("hash:map", String.valueOf(i)));
        }
        for (int i = 0; i < 10; i++) {
            redisRepository.hashPut("hash:list", String.valueOf(i), generateList());
            logger.info("{}", redisRepository.hashGet("hash:list", String.valueOf(i)));
        }
    }
}
