package com.hsy.springboot.hibernate.service;

import com.hsy.springboot.hibernate.entity.TExerciseZone;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ITExerciseZoneTestService {
    /**
     * 创建一条记录
     * @return
     */
    boolean createTExerciseZone(Integer code, String name, Long parentId, Integer sortId, String remark) ;

    /**
     * 创建多条记录
     */
    boolean bachtCreateTExcrciseZone(List<TExerciseZone> list);

    /**
     * 删除一条记录
     * @param id
     * @return
     */
    boolean deleteTExerciseZone(Long id) ;

    /**
     * 批量删除
     * @param ids
     * @return
     */
    boolean batchDeleteTExerciseZone(List<Long> ids) ;

    /**
     * 修改一条记录
     * @param exerciseZone
     * @return
     */
    boolean updateTExerciseZone(TExerciseZone exerciseZone) ;

    /**
     * 批量删除
     * @param list
     * @return
     */
    boolean batchUpdateTEerciseZone(List<TExerciseZone> list) ;

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    TExerciseZone getOne(Long id);

    /**
     * 获取列表
     * @param offset
     * @param limit
     * @return
     */
    Page<TExerciseZone> getList(Integer offset, Integer limit) ;
}
