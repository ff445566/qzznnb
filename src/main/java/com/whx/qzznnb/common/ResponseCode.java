package com.whx.qzznnb.common;

public enum  ResponseCode {
    SUCCESS(0 ,"sucess"),
    Error(1, "eror"),
    NEED_LOGIN(10,"needlogin"),
    ILLEGAL_ARGUMENT(2,"illega-argument");
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
