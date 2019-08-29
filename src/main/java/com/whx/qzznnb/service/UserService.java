package com.whx.qzznnb.service;

import com.whx.qzznnb.entity.User;


public interface  UserService {


    public User getUserById(String uid);
    public  int createUser(User user);
    public  String checkUserName(String username);
    public  String checkEmail(String email);
    public  String login(String username,String password);

}
