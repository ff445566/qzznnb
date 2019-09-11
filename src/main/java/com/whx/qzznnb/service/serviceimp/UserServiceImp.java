package com.whx.qzznnb.service.serviceimp;

import com.whx.qzznnb.entity.User;
import com.whx.qzznnb.mapper.UserMapper;
import com.whx.qzznnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;


    public  int createUser(User user){
        return   userMapper.createUser(user);
    }

    @Override
    public String checkUserName(String username) {
        return userMapper.checkUserName(username);
    }


    @Override
    public String checkPhone(String phone) {
        return userMapper.checkPhone(phone);
    }



    @Override
    public User login(String  phone, String password) {
        return userMapper.login(phone,password);
    }

    @Override
    public String selectkLastTime(String uid) {
        return userMapper.checkLastTime(uid);
    }

    @Override
    public int updateProgress(String uid, String call_progress) {
        return userMapper.updateCall(uid,call_progress);
    }


    /**
     * 根据uid 查询基本信息
     * @param uid
     * @return
     */
    @Override
    public User selectByUid(String uid) {
        return userMapper.selectByUid(uid);
    }

    @Override
    public int updateInfo(String uid, String username,String user_type,String password) {
        return userMapper.updateInfo(uid,username,user_type,password);
    }

}
