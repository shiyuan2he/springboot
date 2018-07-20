package com.hsy.springboot.distributed.lock.dao;

import com.hsy.springboot.distributed.lock.utils.DBUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.distributed.lock.dao
 * @date 2018/7/20 10:42
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Repository(value = "stockDao")
public class TStockDaoImpl {
    private PreparedStatement ps = null ;

    public int reduce(){
        Connection connection = DBUtils.getConnetction();
        try {
            ps = connection.prepareStatement("update t_stock set count = count-1 where id = 1");
            return ps.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }
    }
}
