package com.hsy.springboot.jdbc.dao.impl;

import com.hsy.java.bean.po.TExerciseZone;
import com.hsy.java.enums.DBEnum;
import com.hsy.java.exception.dao.DBHandleException;
import com.hsy.springboot.rpc.api.dao.ITExerciseZoneDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p>t_exercise_zone表 crud</p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.jdbc.dao.impl
 * @date 24/10/2017 7:46 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 */
@Repository("exerciseDao")
public class TExerciseZoneDaoImpl implements ITExerciseZoneDao{
    private static final Logger _logger = LoggerFactory.getLogger(TExerciseZoneDaoImpl.class) ;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(TExerciseZone exerciseZone) {
        try{
            return jdbcTemplate.update(insertSql,
                    exerciseZone.getCode(),exerciseZone.getName(),exerciseZone.getParentId(),exerciseZone.getRemark());
        }catch(Exception e){
            _logger.error("出错信息:{}",e);
            throw new DBHandleException(DBEnum.DB_INSERT_RESULT_ERROR,e) ;
        }
    }

    @Override
    public int[] batchInsert(List<Object[]> batchArgs) {
        try{
            return jdbcTemplate.batchUpdate(insertSql,batchArgs);
        }catch(Exception e){
            throw new DBHandleException(DBEnum.DB_INSERT_RESULT_ERROR,e) ;
        }
    }
    @Override
    public int delete(Long id) {
        try{
            return jdbcTemplate.update(deleteSql,id);
        }catch(Exception e){
            throw new DBHandleException(DBEnum.DB_DELETE_RESULT_ERROR,e) ;
        }
    }

    @Override
    public int[] batchDelete(List<Long[]> ids) {
        try{
            List<Object[]> oids = null ;
            ids.forEach(id -> {
                Object[] oid = null ;
                for(int i=0;i<id.length;i++){
                    oid[i] = id[i] ;
                }
                oids.add(oid) ;
            });
            return jdbcTemplate.batchUpdate(deleteSql,oids) ;
        }catch (Exception e){

        }
        return new int[0];
    }

    @Override
    public int update(TExerciseZone exerciseZone) {
        try{
            //return jdbcTemplate.update(deleteSql,id);
        }catch(Exception e){
            throw new DBHandleException(DBEnum.DB_DELETE_RESULT_ERROR,e) ;
        }
        return 0 ;
    }

    @Override
    public TExerciseZone select(TExerciseZone exerciseZone) {
        return null;
    }

    @Override
    public List<TExerciseZone> selectAll(int offset, int limit) {
        return null;
    }
    /*
    @Override
    public List<TProvince> getTProvinceList() {
        List<TProvince> list = jdbcTemplate.query("select * from t_province", new Object[]{}, new BeanPropertyRowMapper(TProvince.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    @Override
    public TProvince getTProvinceById(String id) {
        TProvince province = jdbcTemplate.queryForObject("select * from t_province where id = ?", new Object[]{id}, TProvince.class) ;
        *//*List<TProvince> list = jdbcTemplate.query("select * from t_province where id = ?", new Object[]{id}, new BeanPropertyRowMapper(TProvince.class));
        if(null!=list&&list.size()>0){
            return list.get(0);
        }*//*
        return province;
    */
}
