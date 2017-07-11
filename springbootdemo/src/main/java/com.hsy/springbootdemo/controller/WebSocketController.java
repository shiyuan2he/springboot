package com.hsy.springbootdemo.controller;

import com.hsy.springbootdemo.javabean.protocolbean.HsyMessage;
import com.hsy.springbootdemo.javabean.protocolbean.HsyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

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
@MessageMapping("/websocket")
public class WebSocketController {

    @Autowired
    SimpMessagingTemplate messagingTemplate ;//通过SimpMessagingTemplate向浏览器发送消息

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public HsyResponse getMessage(HsyMessage message){
        return new HsyResponse(message.getMessage());
    }
    @MessageMapping("/chat")
    //springMvc中Principal包含当前用户信息
    public void handleChat(Principal principal,String msg){
        if(principal.getName().equals("hsy")){
            /**
             * @description <p>/queue/notifications 消息订阅地址</p>
             * @author heshiyuan
             * @date 2017/7/11 15:41
             */
            messagingTemplate.convertAndSendToUser("wsp","/queue/notifications",principal.getName()+":"+msg);
        }else{
            messagingTemplate.convertAndSendToUser("hsy","/queue/notifications",principal.getName()+":"+msg);
        }
    }
}
