package com.hsy.springboot.mybatis.service.impl;

import com.hsy.java.bean.po.TExerciseZone;
import com.hsy.springboot.mybatis.mapper.TExerciseZoneMapper;
import com.hsy.springboot.mybatis.service.ITExerciseZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service(value = "exerciseZoneService")
public class TExerciseZoneServiceImpl implements ITExerciseZoneService{
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired private TExerciseZoneMapper tExerciseZoneMapper ;
    @Override
    public List<TExerciseZone> getAll(Integer offset,Integer limit) {
        return tExerciseZoneMapper.selectAll(offset,limit);
    }
    @Transactional
    @Override
    public Boolean update(Integer parentId,Long id) {
        tExerciseZoneMapper.update(100000,1l) ;
        int i = 1 / 0 ;
        tExerciseZoneMapper.update(110000,2l) ;
        return true;
    }
}
