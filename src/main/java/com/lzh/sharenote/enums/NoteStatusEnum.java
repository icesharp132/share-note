package com.lzh.sharenote.enums;

/**
 * Created by Lu Zhaohui on 2017/7/6.
 */
public enum NoteStatusEnum {

    DELETE(-1, "已删除"),
    NORMAL(1, "展示中"),
    HIDE(0, "未展示");

    private int code;
    private String desc;

    NoteStatusEnum(int code, String desc){
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
