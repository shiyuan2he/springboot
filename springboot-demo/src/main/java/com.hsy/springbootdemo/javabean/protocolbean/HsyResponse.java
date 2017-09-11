package com.hsy.springbootdemo.javabean.protocolbean;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spring/com.hsy.springbootdemo.javabean.protocolbean
 * @date 2017/7/8 上午10:18
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class HsyResponse {
    private String responseMessage ;

    public String getResponseMessage() {
        return responseMessage;
    }

    public HsyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
