package com.hsy.springboot.distributed.lock.service;

import com.hsy.springboot.distributed.lock.dao.TLockDaoImpl;
import com.hsy.springboot.distributed.lock.dao.TStockDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.distributed.lock.service
 * @date 2018/7/20 14:55
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service(value = "lockService")
public class LockServiceImpl {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired private TLockDaoImpl lockDao;
    @Autowired private TStockDaoImpl stockDao;

    public void dbLock(){
        logger.info("开始业务");
        String lock = "dbLock" ;
        if(lockDao.insert(lock,"数据库实现分布式锁")>0){
            logger.info("进入lock区");
            logger.info("获取到数据库锁");
            // 减库存
            stockDao.reduce();
            lockDao.delete(lock);
        }else{
            logger.info("没有拿到锁，请求返回");
        }
        logger.info("结束业务");
    }
}
