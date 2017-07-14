package com.hsy.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @param
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/7/11 15:01
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/","/views/login","/websocket/chat","/countries").permitAll()//设置对 /,/login不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login.do")//  登录页面 的访问路径为/login
                .defaultSuccessUrl("/views/chat").permitAll()//   登录成功之后转向/chat路径
                .and()
                .logout().permitAll()
        ;

    }
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.inMemoryAuthentication()//在内存中分别配置两个用户
                .withUser("hsy").password("pwd").roles("USER")
                .and()
                .withUser("wsp").password("pwd").roles("USER") ;
    }
    @Override
    public void configure(WebSecurity webSecurity) throws Exception{
        //  /resources/static/**下的静态资源不拦截
        webSecurity.ignoring().antMatchers("/resources/static/**") ;
    }
}
