package com.whx.qzznnb.service;

import com.whx.qzznnb.entity.User;


public interface  UserService {
    public  int createUser(User user);
    public  String checkUserName(String username);
    public  User checkPhone(String phone);
    public  User login(String phone,String password);

    public String selectkLastTime(String uid); // 最新打卡时间
    public  int updateProgress(String uid ,String call_progress); //更新打开
    public  User selectByUid(String uid);
    public int updateInfo(String uid,String username ,String user_type,String password); // 更新个人信息
}
