package com.springboot.service.annotation.impl;
/**
 * @description <p></p>
 * @path spring-boot/com.springboot.service.annotation.impl
 * @author heshiyuan
 * @date 2017/4/25 下午8:28
 * @github http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */

import org.springframework.stereotype.Service;

/**
 * @description <p></p>
 * @path spring-boot/com.springboot.service.annotation.impl
 * @author heshiyuan
 * @date 2017/4/25 下午8:28
 * @github http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service
public class AnnotationServiceImpl {
    @SuppressWarnings("unused")
    public void outputStream(){
        System.out.println("用组合注解获得bean。。。");
    }
}
