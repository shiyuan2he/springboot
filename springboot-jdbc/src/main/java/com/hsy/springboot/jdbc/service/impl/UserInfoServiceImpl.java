package com.hsy.springboot.jdbc.service.impl;

import com.hsy.java.base.utils.MathHelper;
import com.hsy.java.util.secure.Base64Helper;
import com.hsy.springboot.demo.springboot.jdbc.bean.entity.TUserInfo;
import com.hsy.springboot.demo.springboot.jdbc.dao.ITUserInfoDao;
import com.hsy.springboot.demo.springboot.jdbc.service.ITUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.jdbc.service.impl
 * @date 24/10/2017 7:49 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service
public class UserInfoServiceImpl implements ITUserInfoService{
    @Autowired
    ITUserInfoDao userInfoDao ;
    @Override
    public int saveUserInfo(String username, String password) {
        TUserInfo userInfo = new TUserInfo();
        userInfo.setId(String.valueOf(MathHelper.generateRandomOfLongByLength(19)));
        userInfo.setUsername(username);
        userInfo.setPassword(Base64Helper.stringToBase64OfCc(password));
        userInfo.setEncryptionType("BASE64");
        userInfo.setInserter("0");
        userInfo.setInsertTime(Calendar.getInstance().getTime());
        return userInfoDao.insertTUserInfo(userInfo) ;
    }
}
