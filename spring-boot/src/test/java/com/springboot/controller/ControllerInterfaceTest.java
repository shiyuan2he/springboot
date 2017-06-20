package com.springboot.controller;

import com.springboot.config.SpringWebApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author heshiyuan
 * @description <p>模拟springmvc接口方法的测试</p>
 * @path spring-boot/com.springboot.controller
 * @date 2017/6/18 上午9:59
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebApplication.class})
@WebAppConfiguration("src/main/resources")// 默认 src/main/webapp 指定为 src/main/resource
public class ControllerInterfaceTest {
    private MockMvc mockMvc ;
    @Autowired
    WebApplicationContext ctx ; //注入 context
    @Autowired
    MockHttpSession session  ; //注入 httpsession
    @Autowired
    MockHttpServletRequest reqquest ; //注入 httprequest
    @Before
    public void before(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build(); //模拟mvc对象
    }
    @Test
    public void testSkipToView(){
        try {
            mockMvc.perform(get("/push/getData")) //向／hello发送get请求
                    .andExpect(status().isOk()) //预期控制返回状态为200
                    //.andExpect(view().name("view")) // 预期视图名称 view
                    //.andExpect(forwardedUrl("/WEB-INF/classes/views/hello.jsp")) // 预期跳转到hello.jsp页面
                    //.andExpect(model().attribute("msg",""))
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetData(){
        try {
            mockMvc.perform(get("/push/getData"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json;charset=UTF-8")) // 预期返回值的媒体类型是application/json;charset=UTF-8
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
