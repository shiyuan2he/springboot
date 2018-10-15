package com.hsy.springboot.security.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.security.controller
 * @date 15/10/2018 4:40 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RestController
public class UserController {

    @GetMapping("/user/{userId}")
    public Map<String, Object> getUserInfo(@PathVariable(name = "userId") String userId){
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("userId", userId);
        userInfo.put("userName", "张三");
        return userInfo;
    }
}
