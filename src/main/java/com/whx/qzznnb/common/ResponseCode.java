package com.whx.qzznnb.common;

public enum  ResponseCode {
    /**
     * 0 是成功 1 是失败
     * 2是逻辑成功 但是数据失败的情况
     * 10开始是数据库相关的失败
     * 11 参数接收失败 为null
     */
    SUCCESS(0 ,"sucess"),
    Error(1, "eror"),


    RESULTNULL(201,"数据库查询得到的结果是null"),//数据库查询得到的结果是null

    NEED_LOGIN(10,"needlogin"),
    ILLEGAL_ARGUMENT(111,"传入参数解析失败"),
    ERRORDATABASE(101,"数据库查询出错"),
    ERRORUPDATEDATABASE(102,"数据库更新出错");
    private final int  code;
    private final String desc;
    ResponseCode(int code,String desc){
        this.code=code;
        this.desc=desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
