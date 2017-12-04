package com.hsy.springboot.template.jsp.servlet;

import com.hsy.springboot.template.jsp.SpringBootJspApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.template.jsp.servlet
 * @date 2017/12/3 12:19
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ServletInitalizer extends SpringBootServletInitializer{

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(SpringBootJspApplication.class);
    }
}
