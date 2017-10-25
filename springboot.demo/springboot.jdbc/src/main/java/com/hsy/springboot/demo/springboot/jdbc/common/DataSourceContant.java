package com.hsy.springboot.demo.springboot.jdbc.common;

import com.hsy.java.base.utils.PropertiesFileUtil;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path sso/com.hsy.sso.base.common.constants
 * @date 20/10/2017 10:54 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class DataSourceContant {
    private static PropertiesFileUtil propertiesFileUtil = PropertiesFileUtil.getInstance("db.properties");
    private static String driver = null ;
    private static String url = null ;
    private static String username = null ;
    private static String password = null ;
    static{
        driver = propertiesFileUtil.get("jdbc.mariadb.driver") ;
        url = propertiesFileUtil.get("jdbc.mariadb.url") ;
        username = propertiesFileUtil.get("jdbc.mariadb.username") ;
        password = propertiesFileUtil.get("jdbc.mariadb.password") ;
        /*Properties properties = new Properties() ;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("datasource.properties")) ;
            properties.load(fileInputStream);
            driver = properties.getProperty("jdbc.mariadb.driver") ;
            url = properties.getProperty("jdbc.mariadb.url") ;
            username = properties.getProperty("jdbc.mariadb.username") ;
            password = properties.getProperty("jdbc.mariadb.password") ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        DataSourceContant.driver = driver;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        DataSourceContant.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DataSourceContant.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DataSourceContant.password = password;
    }
}
