package com.springboot.properties;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.properties
 * @date 2017/4/21 上午10:06
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Configuration
@ComponentScan("com.springboot.properties")
@PropertySource("classpath:test/elconfig.properties")
public class ELConfig {
    @Value("this is normal!")
    private String normalValue ;

    @Value("#{systemEnvironment['os.name']}")
    private String osName ;

    @Value("#{T(java.lang.Math).random() * 1000.0}")
    private double randomNumber ;

    @Value("classpath:test/elconfig.properties")
    private Resource elConfig ;

    @Value("www.baidu.com")
    private  Resource testUrl ;

    @Value("${author.name}")
    private String authorName ;

    @Autowired
    private Environment environment ;

    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer() ;
    }

    public void outputResource(){
        System.out.println(normalValue);
        System.out.println(osName);
        System.out.println(randomNumber);
        System.out.println(elConfig);
        System.out.println(testUrl);
        System.out.println(authorName);
        try {
            System.out.println(IOUtils.toString(elConfig.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(environment.getProperty("author.name"));
    }

}
