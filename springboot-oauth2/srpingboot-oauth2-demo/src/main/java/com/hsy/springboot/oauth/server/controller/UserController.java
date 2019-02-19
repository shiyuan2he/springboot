package com.hsy.springboot.oauth.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heshiyuan
 * @description <p>
 *
 *     1. /oauth/authorize：授权端点。
 *     2. /oauth/token：获取token。
 *     3. /oauth/confirm_access：用户确认授权提交端点。
 *     4. /oauth/error：授权服务错误信息端点。
 *     5. /oauth/check_token：用于资源服务访问的令牌解析端点。
 *     6. /oauth/token_key：提供公有密匙的端点，如果你使用JWT令牌的话。
 *     7. /oauth/logout: 退出
 * </p>
 * @path springboot/com.hsy.springboot.oauth2.client.controller
 * @date 19/02/2019 18:22
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2019 shiyuan4work@126.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RestController
public class UserController {
    @GetMapping(value = "users/list")
    public String listUser(){
        return "user";
    }

    @GetMapping(value = "opt/list")
    public String optList(){
        return "optList";
    }
}
