package com.whx.qzznnb.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TimeUtil
 * @Description TODO
 * @Date 2019/9/6 9:12
 * @Version 1.0.0
 **/
public class TimeUtil {
    /**
     * 获取当期时间 并与数据库保持一致
     * @return
     */
    public  static Date getNowTime(){
    return  new Date(System.currentTimeMillis());
    }
    /**
     * 两个时间戳 比较大小 具体到天
     * 0  是相等
     * 1 是newdate > olddate
     * -1 是newdate < olddate
     */
    public  static int stampCompare(String newdate ,String olddate ){
               long dateone = new Long(newdate);
               long datetwo =new Long(olddate);
               Date datenew = new Date(dateone*1000);
               Date dateold =new Date(datetwo*1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
       int one = Integer.valueOf(simpleDateFormat.format(datenew));
        int two =Integer.valueOf(simpleDateFormat.format(dateold));
        System.out.println(one+ "  "+ two);
        if(one == two) return 0;
        if(one > two) return 1;
        else return -1;
    }
   //将时间转换为时间戳
     public static  long dateToStamp(Date date){
         String res;
         long ts = date.getTime();
         res = String.valueOf(ts);
         return Long.valueOf(res);
     }
     public static void main(String[] args) {

        System.out.println(" 结果"+getTodayStamp());
    }
    // 得到今天的时间 具体到天 例如 20191210
    public  static String   getTodayStamp(){

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return  sdf.format(d);

    }
}
