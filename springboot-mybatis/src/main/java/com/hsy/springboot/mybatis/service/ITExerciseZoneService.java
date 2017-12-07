package com.hsy.springboot.mybatis.service;

import com.hsy.java.bean.po.TExerciseZone;

import java.util.List;

public interface ITExerciseZoneService {

    List<TExerciseZone> getAll(Integer offset,Integer limit) ;

    Boolean update(Integer parentId,Long id) ;
}
