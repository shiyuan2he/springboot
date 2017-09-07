package com.hsy.solr.dao;

import com.hsy.solr.bean.TheaterSolrBean;
import com.hsy.solr.common.BusinessUtils;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path solr/com.java.dao
 * @date 14/08/2017 10:49 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext*.xml")
public class SolrcloudClientDaoImplTest {
    private static final Logger _logger = LoggerFactory.getLogger(SolrcloudClientDaoImplTest.class);
    @Autowired
    SolrDao solrCloudClientDao;

    @Test
    public void testAddBean() {
        try {
            solrCloudClientDao.deleteAll();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        try {
            solrCloudClientDao.addByBean(BusinessUtils.createBean());
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddBeans() {
        List<TheaterSolrBean> beanList = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            beanList.add(BusinessUtils.createBean());
        }
        try {
            solrCloudClientDao.addByBeans(beanList);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testDeleteById() {
        // _logger.info(solrCloudClientDao.deleteById(4783782));
    }

    @Test
    public void testDeleteAll() {
        try {
            _logger.info("" + solrCloudClientDao.deleteAll());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
    }
}
