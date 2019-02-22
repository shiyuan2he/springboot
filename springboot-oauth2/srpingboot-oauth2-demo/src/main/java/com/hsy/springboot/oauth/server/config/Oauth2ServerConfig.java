package com.hsy.springboot.oauth.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.oauth.server.config
 * @date 19/02/2019 18:11
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2019 shiyuan4work@126.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Configuration
@EnableAuthorizationServer
public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    //认证方式
    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource(name = "userService")
    private UserDetailsService userDetailsService;

    @Autowired
    private ClientDetailsService clientDetailsService;
    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        /******分界线：以下是使用数据库存储******/
        configurer.withClientDetails(clientDetailsService);

        /******分界线：以下是使用内存存储******/
//        String secret = new BCryptPasswordEncoder().encode(CLIENT_SECRET);  // 用 BCrypt 对密码编码
        //配置3个个客户端,一个用于password认证、一个用于client认证、一个用于authorization_code认证
//        configurer.inMemory()  // 使用in-memory存储
//                .withClient(CLIEN_ID_ONE)    //client_id用来标识客户的Id  客户端1
//                .resourceIds(RESOURCE_ID)
//                .authorizedGrantTypes(GRANT_TYPE_CLIENT, REFRESH_TOKEN)  //允许授权类型   客户端授权模式
//                .scopes(SCOPE_READ,SCOPE_WRITE)  //允许授权范围
//                .authorities("oauth2")  //客户端可以使用的权限
//                .secret(secret)  //secret客户端安全码
//                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)   //token 时间秒
//                .refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS)//刷新token 时间 秒
//                .and()
//                .withClient(CLIEN_ID_TWO) //client_id用来标识客户的Id  客户端 2
//                .resourceIds(RESOURCE_ID)
//                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, REFRESH_TOKEN)   //允许授权类型  密码授权模式
//                .scopes(SCOPE_READ,SCOPE_WRITE) //允许授权范围
//                .authorities("oauth2") //客户端可以使用的权限
//                .secret(secret)  //secret客户端安全码
//                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)    //token 时间秒
//                .refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS); //刷新token 时间 秒
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager)
                .accessTokenConverter(accessTokenConverter())
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)  //支持GET  POST  请求获取token
                .userDetailsService(userDetailsService) //必须注入userDetailsService否则根据refresh_token无法加载用户信息
                .reuseRefreshTokens(true);  //开启刷新token
    }

    /**
     * 认证服务器的安全配置
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()") //isAuthenticated():排除anonymous   isFullyAuthenticated():排除anonymous以及remember-me
                .allowFormAuthenticationForClients();  //允许表单认证
    }
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("bcrypt");
        return converter;
    }

    @Bean
    public TokenStore tokenStore() {
        //基于jwt实现令牌（Access Token）
//        return new JwtTokenStore(accessTokenConverter());
        return new InMemoryTokenStore();
    }

    @Bean
    public ResourceServerTokenServices tokenService() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }
}
