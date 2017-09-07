package com.hsy.solr.bean;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.java.bean
 * @date 2017/7/1 10:31
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class TheaterSolrBean implements TheaterSolrBeanField{
    @Field(ID_FIELD)
    private String id ;//话剧id，关联话剧表 @Field(THEATER_ID_FIELD)
    @Field(THEATER_ID_FIELD)
    private String theaterId ;//话剧id，关联话剧表
    @Field(THEATER_NAME_FIELD)
    private String theaterName; //话剧名称
    @Field(THEATER_IMG_FIELD)
    private String theaterImg;//话剧图片
    //@Field(THEATER_TYPE_ID_FIELD)
    private Long theaterTypeId; //话剧类别Id,关联话剧类别表
    //@Field(THEATER_TYPE_FIELD)
    private String theaterType; //话剧类别
    //@Field(THEATER_START_TIME_FIELD)
    private Long theaterStartTime;//话剧演出开始时间
    //@Field(THEATER_END_TIME_FIELD)
    private Long theaterEndTime; //话剧演出结束时间
    @Field(THEATER_DESCRIPTION_FIELD)
    private List<String> theaterDescription; //话剧描述
    //@Field(THEATER_TICKET_PRICE_FIELD)
    private Double theaterTicketPrice; //话剧票价

    // 查询参数
    private String keyWords ;//关键字查询
    private Double startPrice ;
    private Double endPrice ;
    public String getTheaterId() {
        return theaterId;
    }
    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }
    public String getTheaterName() {
        return theaterName;
    }
    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterImg() {
        return theaterImg;
    }

    public void setTheaterImg(String theaterImg) {
        this.theaterImg = theaterImg;
    }

    public Long getTheaterTypeId() {
        return theaterTypeId;
    }

    public void setTheaterTypeId(Long theaterTypeId) {
        this.theaterTypeId = theaterTypeId;
    }

    public String getTheaterType() {
        return theaterType;
    }

    public void setTheaterType(String theaterType) {
        this.theaterType = theaterType;
    }

    public List<String> getTheaterDescription() {
        return theaterDescription;
    }

    public void setTheaterDescription(List<String> theaterDescription) {
        this.theaterDescription = theaterDescription;
    }

    public Double getTheaterTicketPrice() {
        return theaterTicketPrice;
    }

    public void setTheaterTicketPrice(Double theaterTicketPrice) {
        this.theaterTicketPrice = theaterTicketPrice;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Double endPrice) {
        this.endPrice = endPrice;
    }

    public Long getTheaterStartTime() {
        return theaterStartTime;
    }

    public void setTheaterStartTime(Long theaterStartTime) {
        this.theaterStartTime = theaterStartTime;
    }

    public Long getTheaterEndTime() {
        return theaterEndTime;
    }

    public void setTheaterEndTime(Long theaterEndTime) {
        this.theaterEndTime = theaterEndTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TheaterSolrBean{" +
                ", theaterId='" + theaterId + '\'' +
                ", theaterName='" + theaterName + '\'' +
                ", theaterImg='" + theaterImg + '\'' +
                ", theaterTypeId='" + theaterTypeId + '\'' +
                ", theaterType='" + theaterType + '\'' +
                ", theaterStartTime=" + theaterStartTime +
                ", theaterEndTime=" + theaterEndTime +
                ", theaterDescription='" + theaterDescription + '\'' +
                ", theaterTicketPrice=" + theaterTicketPrice +
                '}';
    }
}
