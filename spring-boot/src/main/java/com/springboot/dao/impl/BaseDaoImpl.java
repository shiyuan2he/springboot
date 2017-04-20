package com.springboot.dao.impl;

import com.springboot.dao.BaseDao;
import org.springframework.stereotype.Component;

/**
 * Created by heshiyuan on 2017/4/6.
 */
@Component
public class BaseDaoImpl implements BaseDao {
    /**
     *
     */
    public Integer getId(){
        return 1 ;
    }

}