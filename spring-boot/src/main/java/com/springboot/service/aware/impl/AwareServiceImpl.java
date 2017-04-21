package com.springboot.service.aware.impl;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p>加载application容器内的bean资源以及文件资源</p>
 * @path spring-boot/com.springboot.service.aware.impl
 * @date 2017/4/21 下午7:20
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service
public class AwareServiceImpl implements BeanNameAware,ResourceLoaderAware{

    private String beanName  ;
    private ResourceLoader loader ;
    @Override
    public void setBeanName(String s) {
        this.beanName = s ;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult(){
        System.out.println("beanName:"+beanName);
        Resource resource = loader.getResource("classpath:test/elconfig.properties") ;
        try {
            System.out.println("ResourceLoader加载的资源文件："+ IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        };
    }
}
