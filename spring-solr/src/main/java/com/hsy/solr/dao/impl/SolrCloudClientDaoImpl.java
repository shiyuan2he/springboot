package com.hsy.solr.dao.impl;

import com.hsy.solr.bean.PageBean;
import com.hsy.solr.dao.SolrDao;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p>solrcloud数据访问层/p>
 * @path java/com.java.dao.impl
 * @date 2017/7/1 11:05
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Repository("solrCloudClientDao")
public class SolrCloudClientDaoImpl<O> implements SolrDao<O> {
    @Autowired
    CloudSolrClient cloudSolrClient ;

    @Override
    public Integer addByField(Map<String, Object> objectMap) {
        return null;
    }

    @Override
    public Integer addByBean(O o) throws IOException, SolrServerException {
        UpdateResponse response = cloudSolrClient.addBean(o) ;
        cloudSolrClient.optimize() ;
        cloudSolrClient.commit();
        if ("0".equals(response.getStatus())){
            return 1 ;
        }else {
            return 0 ;
        }
    }

    @Override
    public Integer addByBeans(List<O> os) throws IOException, SolrServerException {
        UpdateResponse response = cloudSolrClient.addBeans(os) ;
        cloudSolrClient.optimize() ;
        cloudSolrClient.commit();
        if("0".equals(response.getStatus())){
            return os.size() ;
        }else{
            return 0 ;
        }
    }

    @Override
    public PageBean selectBeanList(O o, Integer newPage, Integer pageSize) {
        return null;
    }

    @Override
    public O getById(Long id) throws IOException, SolrServerException {
        cloudSolrClient.getById(String.valueOf(id)) ;
        return null;
    }

    @Override
    public Integer deleteById(Long id) {
        try {
            UpdateResponse response = cloudSolrClient.deleteById(String.valueOf(id)) ;
            cloudSolrClient.optimize() ;
            cloudSolrClient.commit();
            if("0".equals(response.getStatus())){
                return 1;
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0 ;
    }

    @Override
    public Integer deleteAll() throws IOException, SolrServerException {
        cloudSolrClient.deleteByQuery("*:*") ;
        cloudSolrClient.optimize() ;
        cloudSolrClient.commit();
        return null;
    }

    @Override
    public Integer deleteByParam(O o) {
        return null;
    }

    @Override
    public Integer update(O o) {
        return null;
    }
}
