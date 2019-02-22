package com.hsy.springboot.oauth.server.utils;

public class Oauth2Constant {
    public static final String AUTHORIZATION_CODE = "authorization_code";
    //简化授权模式
    public static final String IMPLICIT = "implicit";
    public static final String REFRESH_TOKEN = "refresh_token";
    //客户端模式
    public static final String GRANT_TYPE_CLIENT = "client_credentials";
    public static final String SCOPE_READ = "read";
    public static final String SCOPE_WRITE = "write";
    public static final String TRUST = "trust";
    public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 3*60;
    public static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 3*60;

    //客户端1 用来标识客户的Id 客户端模式授权
    public static final String CLIEN_ID_ONE = "client_1";
    //客户端2 密码模式授权
    public static final String CLIEN_ID_TWO = "client_2";
    //客户端3 授权码模式
    public static final String CLIEN_ID_THREE = "client_3";
    //secret客户端安全码
    public static final String CLIENT_SECRET = "secret";
    // 密码模式授权
    public static final String GRANT_TYPE_PASSWORD = "password";
    /**
     * 授权码模式  授权码模式使用到了回调地址，是最为复杂的方式，通常网站中经常出现的微博，qq第三方登录，都会采用这个形式。
     */

    //指定哪些资源是需要授权验证的
    public static final String RESOURCE_ID = "*";
}
