package com.hsy.springbootdemo.service;
import com.github.pagehelper.PageHelper;
import com.hsy.springbootdemo.javabean.entitybean.City;
import com.hsy.springbootdemo.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @description <p></p>
 * @param
 * @author heshiyuan 
 * @date 2017/7/14 16:13
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public List<City> getAll(City city) {
        if (city.getPage() != null && city.getRows() != null) {
            PageHelper.startPage(city.getPage(), city.getRows());
        }
        return cityMapper.selectAll();
    }

    public City getById(Integer id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        cityMapper.deleteByPrimaryKey(id);
    }

    public void save(City country) {
        if (country.getId() != null) {
            cityMapper.updateByPrimaryKey(country);
        } else {
            cityMapper.insert(country);
        }
    }
}
