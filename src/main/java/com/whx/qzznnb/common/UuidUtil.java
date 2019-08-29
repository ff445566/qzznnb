package com.whx.qzznnb.common;

import java.util.UUID;

/**
 * @ClassName UuidUtil
 * @Description TODO
 * @Date 2019/8/27 13:58
 * @Version 1.0.0
 **/
public class UuidUtil {
    public static  String getUuid(){

        return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }

}
