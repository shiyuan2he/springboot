package com.hsy.springboot.demo.springboot.jdbc.bean.javabean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description <p>读取配置文件</p>
 * @author heshiyuan
 * @date 24/10/2017 4:50 PM
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Component
@PropertySource(value = "classpath:db.properties")
@ConfigurationProperties(prefix = "database.mariadb")
public class DataBaseConfig {
    private String driver ;
    private String url ;
    private String username ;
    private String password ;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
