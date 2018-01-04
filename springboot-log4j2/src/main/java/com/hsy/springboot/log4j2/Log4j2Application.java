package com.hsy.springboot.log4j2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.log4j2
 * @date 2018/1/4 21:18
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@SpringBootApplication
public class Log4j2Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Log4j2Application.class)
                .web(false)
                .run(args)
                ;
    }
}
