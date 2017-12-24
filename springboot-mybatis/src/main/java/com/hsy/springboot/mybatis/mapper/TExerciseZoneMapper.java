package com.hsy.springboot.mybatis.mapper;

import com.hsy.java.bean.po.TExerciseZone;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TExerciseZoneMapper {

    List<TExerciseZone> selectAll(@Param(value = "offset") Integer offset, @Param(value = "limit") Integer limit) ;

    int update(@Param(value = "parentId") Integer parentId,@Param(value = "id") Long id) ;
}
