package com.hsy.springboot.jdbc.dao.impl;

import com.hsy.java.bean.po.TExerciseZone;
import com.hsy.java.enums.DBEnum;
import com.hsy.java.exception.dao.DBHandleException;
import com.hsy.springboot.rpc.api.dao.ITExerciseZoneDao;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
            return jdbcTemplate.update(updateSql,exerciseZone.getCode(),exerciseZone.getName(),exerciseZone.getParentId(),
                    exerciseZone.getSortId(),exerciseZone.getRemark(),exerciseZone.getId());
        }catch(Exception e){
            throw new DBHandleException(DBEnum.DB_UPDATE_RESULT_ERROR,e) ;
        }
    }

    @Override
    public int[] batchUpdate(List<Object[]> batchArgs) {
        try {
            return jdbcTemplate.batchUpdate(updateSql,batchArgs);
        } catch (DataAccessException e) {
            _logger.error("反生异常：{}",e);
            throw new DBHandleException(DBEnum.DB_UPDATE_RESULT_ERROR,e);
        }
    }

    @Override
    public TExerciseZone select(Long id) {
        TExerciseZone queryExerciseZone = jdbcTemplate.queryForObject(selectSql,new Object[]{id},new BeanPropertyRowMapper<>(TExerciseZone.class)) ;
        if(null!=queryExerciseZone){
            return queryExerciseZone;
        }
        return new TExerciseZone() ;
    }

    @Override
    public List<TExerciseZone> selectAll(Integer offset, Integer limit) {
        List<TExerciseZone> list = null;
        try {
            if(null!=offset&&null!=limit){
                list = jdbcTemplate.query(selectAllSql + "limit ?,?",new Object[]{offset,limit},new BeanPropertyRowMapper<>(TExerciseZone.class));
            }else{
                list = jdbcTemplate.query(selectAllSql,new Object[]{},new BeanPropertyRowMapper<>(TExerciseZone.class));
            }
        } catch (DataAccessException e) {
            _logger.error("捕获异常：",e);
            throw new DBHandleException(DBEnum.DB_SELECT_IS_NULL,e);
        }
        if(null!=list&&list.size()>0){
            return list ;
        }
        return null;
    }
}
