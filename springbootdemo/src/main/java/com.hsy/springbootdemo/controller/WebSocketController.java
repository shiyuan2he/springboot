package com.hsy.springbootdemo.controller;

import com.hsy.springbootdemo.javabean.protocolbean.HsyMessage;
import com.hsy.springbootdemo.javabean.protocolbean.HsyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring/com.hsy.springbootdemo.controller
 * @date 2017/7/8 上午10:12
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Controller
public class WebSocketController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public HsyResponse getMessage(HsyMessage message){
        return new HsyResponse(message.getMessage());
    }
}
