package com.hsy.springboot.rpc.api.dao;

import com.hsy.java.bean.po.TExerciseZone;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p>dao层接口</p>
 * @path springboot/com.hsy.springboot.rpc.api.dao
 * @date 2017/11/23 16:14
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface ITExerciseZoneDao {
    String insertSql = "insert into t_exercise_zone(code,name,parent_id,remark,sort_id) values(?,?,?,?,?)" ;
    int insert(TExerciseZone exerciseZone);
    int[] batchInsert(List<Object[]> batchArgs);

    String deleteSql = "delete from t_exercise_zone where id = ?" ;
    int delete(Long id) ;
    int[] batchDelete(List<Long[]> ids);

    String updateSql = "updte t_exercise_zone set " +
            "code = ?," +
            "name = ?," +
            "parent_id = ?," +
            "sort_id = ?," +
            "remark = ? " +
            " where id = ?" ;
    int update(TExerciseZone exerciseZone) ;
    int[] batchUpdate(List<Object[]> batchArgs);

    String selectSql = "select * from t_exercise_zone where id = ?" ;
    TExerciseZone select(Long id) ;
    String selectAllSql = "select * from t_exercise_zone limit ?,?" ;
    List<TExerciseZone> selectAll(int offset,int limit) ;
}
