package com.hsy.solr.common;

import com.hsy.solr.bean.TheaterSolrBean;
import com.hsy.javase.utils.MathHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path solr/com.java.common
 * @date 14/08/2017 11:20 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class BusinessUtils {

    public static TheaterSolrBean createBean(){
        //2.创建一文档对象
        TheaterSolrBean theaterSolrBean = new TheaterSolrBean();
        //3.向文档对象中添加域 （先定义后使用）
        theaterSolrBean.setId(String.valueOf(MathHelper.generateRandomByLength(7)));
        theaterSolrBean.setTheaterId(String.valueOf(MathHelper.generateRandomByLength(9)));
        theaterSolrBean.setTheaterName("中国戏剧黄金一代剧场典范话剧《冬之旅》");
        theaterSolrBean.setTheaterImg("images/theatre-place.jpg");
        List<String> listDesc = new ArrayList<>() ;
        for(int i=0;i<3;i++){
            listDesc.add("在线选座/打折"+(i+1)) ;
        }
        theaterSolrBean.setTheaterDescription(listDesc);
        //theaterSolrBean.setTheaterTicketPrice(500 + Math.ceil(Math.random() * 500)); // 500~1000
        //theaterSolrBean.setTheaterType("话剧/歌剧");
        //theaterSolrBean.setTheaterTypeId((long)MathHelper.generateRandomByLength(7));

        /*Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC")); //
        calendar.add(Calendar.HOUR_OF_DAY, 8); //获取北京时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        try {
            Date startTime = sdf.parse(sdf.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, 1); //加一天
            Date endTime = sdf.parse(sdf.format(calendar.getTime()));
            theaterSolrBean.setTheaterStartTime(startTime.getTime());
            theaterSolrBean.setTheaterEndTime(endTime.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        return theaterSolrBean ;
    }
}
