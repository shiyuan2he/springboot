package com.hsy.springboot.redis.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring/com.hsy.spring.redis.dao
 * @date 09/10/2018 2:51 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class BaseRedisRepositoryTest {

    public Map<String, String> generateMapForString() {
        Map<String, String> demoMap = new HashMap<>();
        for(int i=0;i<10;i++){
            demoMap.put(i+"", "value "+i);
        }
        return demoMap;
    }
}
