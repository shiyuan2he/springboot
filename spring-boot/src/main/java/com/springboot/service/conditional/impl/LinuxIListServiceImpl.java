package com.springboot.service.conditional.impl;
import com.springboot.service.conditional.IListService;
/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path spring-boot/com.springboot.service.contional.impl
 * @date 2017/4/24 下午12:43
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class LinuxIListServiceImpl implements IListService {
    @Override
    public String showCmd() {
        return "ls";
    }
}
