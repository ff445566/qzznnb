package com.whx.qzznnb.common;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @ClassName NameUtil
 * @Description TODO
 * @Date 2019/9/2 20:43
 * @Version 1.0.0
 **/
public class NameUtil {
    public static String getRandomJianHan(int len) {
        String randomName = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); // 转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            randomName += str;
        }
        return randomName;
    }

//    public static void main(String[] args) {
//        System.out.println(getRandomJianHan(6));
//    }
}
