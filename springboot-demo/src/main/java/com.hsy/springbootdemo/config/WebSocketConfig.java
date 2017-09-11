package com.hsy.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @param
 * @author heshiyuan
 * @description <p>websocket 支持</p>
 * @date 2017/7/7 10:07
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Configuration
@EnableWebSocketMessageBroker // 添加此注解之后支持@MessageMapping
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //注册节点endpointSpringboot，并制定sockJs协议
        //SockJs是一个WebSocket的通信js库，Spring对这个js库进行了后台的自动支持，也就是说，我们如果使用SockJs，那么我们就不需要对后台进行更多的配置，只需要加上这一句就可以了。
        stompEndpointRegistry.addEndpoint("/endpointWebsocket").withSockJS();
        stompEndpointRegistry.addEndpoint("/endpointChat").withSockJS();
    }
    // 配置消息代理
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        //广播式配置一个/topic消息代理;网页上要发送消息到服务器上的地址是/pc/topic
        System.out.println("websocket....");
        registry.enableSimpleBroker("/topic","/queue") ;
        //registry.setApplicationDestinationPrefixes("/pc");
    }
}
