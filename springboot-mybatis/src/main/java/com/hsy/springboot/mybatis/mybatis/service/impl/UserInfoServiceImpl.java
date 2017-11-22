package com.hsy.springboot.mybatis.mybatis.service.impl;

import com.hsy.java.base.utils.MathHelper;
import com.hsy.java.util.secure.Base64Helper;
import com.hsy.springboot.demo.springboot.mybatis.bean.entity.TUserInfo;
import com.hsy.springboot.demo.springboot.mybatis.mapper.TUserInfoMapper;
import com.hsy.springboot.demo.springboot.mybatis.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.mybatis.service.impl
 * @date 25/10/2017 9:31 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService{
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    TUserInfoMapper tUserInfoMapper ;
    @Override
    public boolean save(String username, String password) {
        TUserInfo userInfo = new TUserInfo();
        userInfo.setId(String.valueOf(MathHelper.generateRandomOfLongByLength(19)));
        userInfo.setUsername(username);
        userInfo.setPassword(Base64Helper.stringToBase64OfCc(password));
        userInfo.setEncryptionType("BASE64");
        userInfo.setInserter("0");
        userInfo.setIsDel(0);
        userInfo.setInsertTime(Calendar.getInstance().getTime());
        int count = tUserInfoMapper.insertTUserInfo(userInfo) ;
        if(count>0){
            return true ;
        }
        return false;
    }
}
