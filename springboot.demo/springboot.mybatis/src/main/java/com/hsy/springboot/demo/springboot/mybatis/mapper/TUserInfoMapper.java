package com.hsy.springboot.demo.springboot.mybatis.mapper;

import com.hsy.springboot.demo.springboot.mybatis.bean.entity.TUserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.mybatis.mapper
 * @date 25/10/2017 8:56 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Mapper
public interface TUserInfoMapper {
    @Insert("insert into t_user_info(id,username,password,encryption_type,inserter,insert_time,is_del) " +
            "values(#{id},#{username},#{password},#{encryptionType},#{inserter},#{insertTime},#{isDel})")
    int insertTUserInfo(@Param("userInfo") TUserInfo userInfo) ;
}
