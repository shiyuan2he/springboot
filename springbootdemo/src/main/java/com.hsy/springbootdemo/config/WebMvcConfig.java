package com.hsy.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @param
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/7/7 10:24
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/view").setViewName("/view");
    }
}
