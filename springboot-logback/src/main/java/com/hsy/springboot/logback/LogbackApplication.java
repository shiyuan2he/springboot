package com.hsy.springboot.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.slf4j
 * @date 2017/12/5 21:10
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@SpringBootApplication
public class LogbackApplication {
    private final static Logger _logger = LoggerFactory.getLogger(LogbackApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class,args);
        for (int i=0;i<10;i++){
            _logger.info("this is springboot main");
        }
    }
}
