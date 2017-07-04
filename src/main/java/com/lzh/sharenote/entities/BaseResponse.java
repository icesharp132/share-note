package com.lzh.sharenote.entities;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * Created by Lu Zhaohui on 2017/6/30.
 */
public class BaseResponse {

    private int code;

    private String msg;

    private Map<String, Object> data;

    public BaseResponse() {
    }

    public BaseResponse(Map<String, Object> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        String json = JSON.toJSONString(data);
        this.data = JSON.parseObject(json, Map.class);
    }
}
