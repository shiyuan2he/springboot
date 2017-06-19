package com.springboot.service.push;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring-boot/com.springboot.service.push
 * @date 2017/6/18 上午9:23
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service("pushService")
public class PushServiceImpl {

    private DeferredResult deferredResult ; //前台发送的请求

    public DeferredResult<String> getDeferredResult(){
        deferredResult = new DeferredResult() ;
        return deferredResult ;
    }
    @Scheduled(fixedRate = 3000) //每隔3秒从请求中扫描一次请求，扫描到就开始推送
    public void refresh(){
        if(null!=deferredResult){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString()) ;
        }
    }
}
