package com.hsy.springboot.hibernate.service.impl;

import com.hsy.springboot.hibernate.dao.TExerciseZoneRepository;
import com.hsy.springboot.hibernate.entity.TExerciseZone;
import com.hsy.springboot.hibernate.service.ITExerciseZoneTestService;
import com.hsy.springboot.hibernate.utils.QueryTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "exerciseZoneSerivce")
public class TExerciseZoneTestServiceImpl implements ITExerciseZoneTestService{

    @Autowired private TExerciseZoneRepository exerciseZoneRepository ;

    @Override
    public boolean createTExerciseZone(Integer code, String name, Long parentId, Integer sortId, String remark) {
        TExerciseZone exerciseZone = new TExerciseZone() ;
        exerciseZone.setCode(code);
        exerciseZone.setName(name);
        exerciseZone.setParentId(parentId);
        exerciseZone.setSortId(sortId);
        exerciseZone.setRemark(remark);
        if(null!=exerciseZoneRepository.saveAndFlush(exerciseZone)){
            return true ;
        }
        return false;
    }

    @Override
    public boolean bachtCreateTExcrciseZone(List<TExerciseZone> list) {
        if(exerciseZoneRepository.save(list).size() == list.size()){
            return true ;
        }
        return false;
    }

    @Override
    public boolean deleteTExerciseZone(Long id) {
        try {
            exerciseZoneRepository.delete(id);
            return false ;
        } catch (Exception e) {
            return false ;
        }
    }

    @Override
    public boolean batchDeleteTExerciseZone(List<Long> ids) {
        try {
            ids.forEach(id -> exerciseZoneRepository.delete(id));
            return true ;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateTExerciseZone(TExerciseZone exerciseZone) {
        return false;
    }

    @Override
    public boolean batchUpdateTEerciseZone(List<TExerciseZone> list) {
        return false;
    }

    @Override
    public TExerciseZone getOne(Long id) {
        try {
            return exerciseZoneRepository.getOne(id) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<TExerciseZone> getList(Integer offset, Integer limit) {
        Integer currentPage=0,pageSize=0;
        if(offset % limit == 0){
            currentPage = offset / limit ;
        }else{
            currentPage = (offset / limit) + 1;
        }
        Page<TExerciseZone> page = exerciseZoneRepository.findAll(QueryTool.buildPageRequest(currentPage,pageSize,"code"));
        return page;
    }
}

