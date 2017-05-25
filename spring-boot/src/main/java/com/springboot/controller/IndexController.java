package com.springboot.controller;

import com.springboot.annotation.Action;
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
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 2017/5/19 下午9:33 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    @Action(name="进入首页")
    @RequestMapping("/hello")
    public String hello(){
        return "hello" ;
    }
}
