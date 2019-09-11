package com.whx.qzznnb.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * redis 工具类
 * @date
 *
 */

@Component
public final  class RedisUtil {
    @Autowired
    private RedisTemplate <String ,Object> redisTemplate;
    @Autowired
    private static final Logger Log = LoggerFactory.getLogger(RedisUtil.class);

    /**
     * 制定缓存失效时间
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key,long time){
        if(time <0){
            try {
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;
    }

   public boolean hasKey(String key){
       try {
           return  redisTemplate.hasKey(key);
       } catch (Exception e) {
           e.printStackTrace();
       return  false;
       }
    }
    //*************************string**********************************
    public  String Sget(String key){
        try {
           return redisTemplate.opsForValue().get(key,0,-1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public  String Sget(int key){
        try {
            return redisTemplate.opsForValue().get(String.valueOf(key),0,-1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public  boolean Sset(String key ,String value){

               redisTemplate.opsForValue().set(key,value);
        return true;
    }
    public  boolean Sset(int key ,String value){

        redisTemplate.opsForValue().set(String.valueOf(key),value);
        return true;
    }

  //**************************  list **********************************

    /**
     *获取list 缓存中的内容
     * @param key
     * @param start 开始
     * @param end 结束 0到 -1表示所有值
     * @return
     */
       public List<Object> lGet(String key, long start,long end){
           try {
               return redisTemplate.opsForList().range(key,start,end);
           } catch (Exception e) {
               e.printStackTrace();
               return  null;
           }

       }

    /**
     * list 放入缓存
     * @param key
     * @param object value
     * @return
     */
       public boolean lSet(String key,Object object){
           try {
              redisTemplate.opsForList().rightPush(key,object);
               return true;
           } catch (Exception e) {
               e.printStackTrace();
               return  false;
           }

       }
    /**
     * list 放入缓存
     * @param key
     * @param object List
     * @return
     */
    public boolean lSet(String key,List<Object> object){
        try {
            redisTemplate.opsForList().rightPushAll(key,object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }

    }

    /**
     * list 放入缓存
     * @param key
     * @param object List
     * @return
     */
    public boolean lSet(String key,List<Object> object, long time){
        try {
            redisTemplate.opsForList().rightPushAll(key,object);
            if(time>0)
                expire(key,time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }

    }
   }

