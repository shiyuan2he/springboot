package com.hsy.springboot.filter.listener.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.filter.listener.listener
 * @date 2017/12/4 21:32
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@WebListener
public class MyListener implements ServletContextListener {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        _logger.info("contextInitialized");
        _logger.info(servletContextEvent.getServletContext().getContextPath());
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        _logger.info("contextDestroyed");
    }
}
