package com.springboot.service.scheduledtask.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p>计划任务实现类</p>
 * @path spring-boot/com.springboot.service.scheduletask.impl
 * @date 2017/4/21 下午10:57
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service
public class ScheduledTaskServiceImpl {
    private static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss") ;

    @Scheduled(fixedRate = 5000) //每隔5秒执行一次
    public void reportCurrentTime(){
        System.out.println("每隔5秒执行一次:"+ format.format(Calendar.getInstance().getTime()));
    }
    // 秒 分 时 ？日 月   每天11：28分执行
    @Scheduled(cron="0 39 23 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间执行："+format.format(Calendar.getInstance().getTime()));
    }

}
