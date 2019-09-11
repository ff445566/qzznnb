package com.whx.qzznnb.common;

/**
 * @ClassName codeConsta
 * @Description TODO
 * @Date 2019/9/10 16:34
 * @Version 1.0.0
 **/
public enum codeConsta {
    UIDEEROR(101), // uid 错误
    PHONEREPEAT(100), //  手机号重复
    PARAMNOT(102); //参数不全
     private  final int code;

    private  codeConsta(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
