package com.hsy.solr.dao;

import com.hsy.solr.bean.TheaterSolrBean;
import com.hsy.solr.dao.impl.SolrClientDaoImpl;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext*.xml")
public class SolrClientDaoImplTest {
    @Autowired
    SolrClientDaoImpl solrDao;

    @Test
    public void testAddBean() throws Exception {
        solrDao.deleteAll();
        for (int i = 1; i <= 1; i++) {
            //2.创建一文档对象
            TheaterSolrBean theaterSolrBean = new TheaterSolrBean();
            //3.向文档对象中添加域 （先定义后使用）
            //theaterSolrBean.setId((long) 10003 + i);
            theaterSolrBean.setTheaterId((20003 + i) + "");
            theaterSolrBean.setTheaterName("中国戏剧黄金一代剧场典范 话剧《冬之旅》第" + i + "场");
            theaterSolrBean.setTheaterImg("images/theatre-place" + i + ".jpg");
            //theaterSolrBean.setTheaterDescription("在线选座/打折");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            calendar.add(Calendar.HOUR_OF_DAY, 8);
            //calendar.add(Calendar.DAY_OF_MONTH, 1); //加一天
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            Date startTime = null, endTime = null;
            try {
                //sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                startTime = sdf.parse(sdf.format(calendar.getTime()));
                //Calendar calendar2 = Calendar.getInstance();
                //calendar2.add(Calendar.DAY_OF_MONTH, 1); //加一天
                //calendar2.add(Calendar.HOUR_OF_DAY, 3); //加三小时
                endTime = sdf.parse(sdf.format(calendar.getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            theaterSolrBean.setTheaterStartTime(startTime.getTime());
            theaterSolrBean.setTheaterEndTime(endTime.getTime());
            theaterSolrBean.setTheaterTicketPrice(500 + Math.ceil(Math.random() * 500)); // 500~1000
            theaterSolrBean.setTheaterType("话剧/歌剧");
            theaterSolrBean.setTheaterTypeId((long) 9999999);
            try {
                solrDao.addByBean(theaterSolrBean);
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testDeleteAll() throws Exception {
        System.out.println(solrDao.deleteAll());
    }
}
