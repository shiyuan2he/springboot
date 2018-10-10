package com.hsy.springboot.redis.dao.string;

import com.hsy.springboot.redis.SpringBootRedisApplication;
import com.hsy.springboot.redis.dao.BaseRedisRepositoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.redis.dao.string
 * @date 10/10/2018 9:54 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRedisApplication.class)
public class HashRedisRepositoryTest extends BaseRedisRepositoryTest {
    @Autowired private HashRedisRepository hashStringRepository;

    private String hashKey = "hash:" ;
    @Test
    public void testPutAll(){
        hashStringRepository.putAll(hashKey, generateMapForString(), true);
    }


}