package com.springboot.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring-boot/com.springboot.core
 * @date 2017/6/11 下午1:03
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class TimeInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(TimeInterceptor.class.getName()) ;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler){
        request.setAttribute("startTime",System.currentTimeMillis());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,Object handler,ModelAndView modelAndView){
        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis() ;
        logger.info("本次请求耗时："+(endTime - startTime) +"毫秒") ;
    }
}
