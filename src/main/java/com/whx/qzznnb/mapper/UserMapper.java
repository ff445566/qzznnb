package com.whx.qzznnb.mapper;

import com.whx.qzznnb.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User Sel(String  uid);
    int  createUser(User user);
    String checkUserName(String username);
    String checkEmail(String email);
    String login(String username,String password);

}
