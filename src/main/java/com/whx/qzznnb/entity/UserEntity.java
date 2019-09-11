package com.whx.qzznnb.entity;

import java.util.HashMap;

/**
 * @ClassName UserEntity
 * @Description TODO
 * @Date 2019/9/10 22:13
 * @Version 1.0.0
 **/
public class UserEntity {
    private HashMap<String ,String > user_info =
            new HashMap<String, String>(); // 把作者uid 和username 一起传过去{uid.username}
   public  UserEntity(){}
   public UserEntity(User user){
       this.user_info.put("uid",user.getUid());
       this.user_info.put("username",user.getUsername());

   }
    public HashMap<String, String> getUser_info() {
        return user_info;
    }

    public void setUser_info(HashMap<String, String> user_info) {
        this.user_info = user_info;
    }
}
