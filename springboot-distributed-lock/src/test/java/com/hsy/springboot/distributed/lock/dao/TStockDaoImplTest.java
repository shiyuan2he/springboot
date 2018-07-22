package com.hsy.springboot.distributed.lock.dao;

import com.hsy.springboot.distributed.lock.DistributedLockApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.distributed.lock.dao
 * @date 2018/7/21 19:45
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@SpringBootTest(classes = DistributedLockApplication.class)
@RunWith(SpringRunner.class)
public class TStockDaoImplTest {
    private Logger logger = LoggerFactory.getLogger(TStockDaoImpl.class);
    @Autowired private TStockDaoImpl stockDao;
    @Test
    public void reduce() {
    }

    @Test
    public void getCount() {
        logger.info("{}--------------", stockDao.getCount(1l));
    }
}