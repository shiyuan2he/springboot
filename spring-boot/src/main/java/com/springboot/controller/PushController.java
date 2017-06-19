package com.springboot.controller;

import com.springboot.service.push.PushServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author heshiyuan
 * @description <p>servlet3.0提供的服务器端推送技术</p>
 * @path spring-boot/com.springboot.controller
 * @date 2017/6/18 上午9:22
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Controller
@RequestMapping("/push")
public class PushController {

    @Autowired
    PushServiceImpl pushService ;

    @RequestMapping("/getData")
    @ResponseBody
    public DeferredResult<String> getPushData(){
        return pushService.getDeferredResult() ;
    }
}
