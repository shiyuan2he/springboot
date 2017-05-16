package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.controller
 * @date 2017/4/26 下午10:40
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello" ;
    }
}
