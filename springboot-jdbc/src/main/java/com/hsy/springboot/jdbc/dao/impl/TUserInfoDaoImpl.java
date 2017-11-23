package com.hsy.springboot.jdbc.dao.impl;
import org.springframework.stereotype.Repository;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.jdbc.dao.impl
 * @date 24/10/2017 7:46 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Repository("userInfoDao")
public class TUserInfoDaoImpl{
    /*@Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insertTUserInfo(TUserInfo userInfo) {
        return jdbcTemplate.update("insert into t_user_info(id,username,password,encryption_type,inserter,insert_time) values(?,?,?,?,?,?)",
                userInfo.getId(),userInfo.getUsername(),userInfo.getPassword(),userInfo.getEncryptionType(),
                userInfo.getInserter(),userInfo.getInsertTime());
    }*/
}
