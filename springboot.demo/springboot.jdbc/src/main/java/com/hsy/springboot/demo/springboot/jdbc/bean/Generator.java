package com.hsy.springboot.demo.springboot.jdbc.bean;

import com.hsy.java.util.jdbc.EntityGenerator;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.jdbc.bean
 * @date 24/10/2017 5:06 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class Generator {
    private static final String packageName = "com.hsy.springboot.demo.springboot.jdbc.bean.entity" ;
    private static final String tableName = "t_user_info" ;
    private static final String driver = "org.mariadb.jdbc.Driver" ;
    private static final String url = "jdbc:mariadb://192.168.216.129:3306/springboot?useUnicode=true&characterEncoding=UTF-8" ;
    private static final String username = "root" ;
    private static final String password = "root@mariadb" ;
    public static void main(String[] args){
        /*new EntityGenerator(packageName,tableName, DataSourceContant.getUrl(),
                DataSourceContant.getUsername(),DataSourceContant.getPassword(),DataSourceContant.getDriver()) ;*/
        new EntityGenerator(packageName,tableName, url,
                username,password,driver) ;
    }
}
