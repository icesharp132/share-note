package com.lzh.sharenote.enums;

/**
 * Created by Lu Zhaohui on 2017/7/6.
 */
public enum HttpCodeEnum {

    SUCCESS(200, "正常"),
    ERROR(500, "异常");

    private int code;
    private String desc;

    HttpCodeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
