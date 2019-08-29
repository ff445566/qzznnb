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

    public User getUserById( String uid){
       return userMapper.Sel(uid);
    }
    public  int createUser(User user){
        return   userMapper.createUser(user);
    }

    @Override
    public String checkUserName(String username) {
        return userMapper.checkUserName(username);

    }

    @Override
    public String checkEmail(String email) {
        return userMapper.checkEmail(email);
    }

    @Override
    public String login(String username, String password) {
        return userMapper.login(username,password);
    }

}
