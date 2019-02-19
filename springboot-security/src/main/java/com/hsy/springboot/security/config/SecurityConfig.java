package com.hsy.springboot.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.security.config
 * @date 18/02/2019 19:24
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2019 shiyuan4work@126.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //  允许所有用户访问"/"和"/index.html"
        http.authorizeRequests()
            .antMatchers("/", "/index.html").permitAll().anyRequest().authenticated()   // 其他地址的访问均需验证权限
            .and()
            .formLogin()
            .loginPage("/login.html")   //  登录页
            .failureUrl("/login-error.html").permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/index.html");
    }

}
