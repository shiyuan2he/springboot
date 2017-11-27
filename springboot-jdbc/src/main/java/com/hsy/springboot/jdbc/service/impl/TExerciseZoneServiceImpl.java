package com.hsy.springboot.jdbc.service.impl;

import com.hsy.java.bean.po.TExerciseZone;
import com.hsy.springboot.rpc.api.dao.ITExerciseZoneDao;
import com.hsy.springboot.rpc.api.service.ITExerciseZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service(value="exerciseZoneService")
public class TExerciseZoneServiceImpl implements ITExerciseZoneService{
    @Autowired private ITExerciseZoneDao exerciseDao ;
    @Override
    public boolean createTExerciseZone(Integer code, String name, Long parentId, Integer sortId, String remark) {
        TExerciseZone exerciseZone = new TExerciseZone() ;
        exerciseZone.setCode(code);
        exerciseZone.setName(name);
        exerciseZone.setParentId(parentId);
        exerciseZone.setSortId(sortId);
        exerciseZone.setRemark(remark);
        int insertCount = exerciseDao.insert(exerciseZone) ;
        if(insertCount>0){
            return true ;
        }
        return false;
    }

    @Override
    public boolean bachtCreateTExcrciseZone(List<TExerciseZone> list) {
        List<Object[]> objArgs = new ArrayList<>() ;
        for (int i=0;i<list.size();i++){
            Object[] objs = new Object[]{} ;
            objs[0] = list.get(i).getCode();
            objs[1] = list.get(i).getName();
            objs[2] = list.get(i).getParentId() ;
            objs[3] = list.get(i).getRemark() ;
            objs[4] = list.get(i).getSortId() ;
            objArgs.add(objs) ;
        }
        if(exerciseDao.batchInsert(objArgs).length>0){
            return true ;
        }
        return false;
    }

    @Override
    public boolean deleteTExerciseZone(Long id) {
        if(exerciseDao.delete(id)>0){
            return true ;
        }
        return false;
    }

    @Override
    public boolean batchDeleteTExerciseZone(List<Long> ids) {
        List<Long[]> objArgs = new ArrayList<>() ;
        for (int i = 0; i < ids.size(); i++) {
            Long[] objs = new Long[]{} ;
            objs[0] = ids.get(i);
            objArgs.add(objs);
        }
        if(exerciseDao.batchDelete(objArgs).length>0){
            return true ;
        }
        return false;
    }

    @Override
    public boolean updateTExerciseZone(TExerciseZone exerciseZone) {
        if (exerciseDao.update(exerciseZone)>0){
            return true ;
        }
        return false;
    }

    @Override
    public boolean batchUpdateTEerciseZone(List<TExerciseZone> list) {
        List<Object[]> objArgs = new ArrayList<>() ;
        for (int i = 0; i < list.size(); i++) {
            Object[] objs = new Object[]{} ;
            objs[0] = list.get(i).getCode();
            objs[1] = list.get(i).getName();
            objs[2] = list.get(i).getParentId() ;
            objs[3] = list.get(i).getRemark() ;
            objs[4] = list.get(i).getSortId() ;
            objs[5] = list.get(i).getId() ;
            objArgs.add(objs) ;
        }
        if(exerciseDao.batchUpdate(objArgs).length>0){
            return true ;
        }
        return false;
    }

    @Override
    public TExerciseZone getOne(Long id) {
        return exerciseDao.select(id) ;
    }

    @Override
    public List<TExerciseZone> getList(Integer offset, Integer limit) {
        return exerciseDao.selectAll(offset,limit);
    }
}
