package com.whx.qzznnb.common;

/**
 * @ClassName codeConsta
 * @Description TODO  代码的对应意思
 * @Date 2019/9/10 16:34
 * @Version 1.0.0
 **/
public enum codeConsta {
    UIDEEROR(101), // uid 错误
    PARAMNOT(102), //参数不全
    //  user

    PHONEREPEAT(100), //  手机号已注册
    PHONENOT(103), //  手机号未注册
    PASSWORDERROR(104); //密码不正确
     private  final int code;

    private  codeConsta(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
