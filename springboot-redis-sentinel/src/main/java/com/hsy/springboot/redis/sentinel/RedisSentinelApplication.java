package com.hsy.springboot.redis.sentinel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.redis.sentinel
 * @date 2017/12/29 14:14
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@SpringBootApplication
public class RedisSentinelApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RedisSentinelApplication.class)
                .web(true)
                .run(args)
                ;
    }
}
