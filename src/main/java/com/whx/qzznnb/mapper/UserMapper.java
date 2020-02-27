package com.whx.qzznnb.mapper;

import com.whx.qzznnb.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectByUid(String  uid); //uid 查询个人基本信息

    int  createUser(User user);

    String checkUserName(String username); //检查用户名

    User checkPhone(String phone); //检查手机号是否注册

    User login(@Param("phone")String  phone,@Param("password") String password); //登录

    String checkLastTime(@Param("uid")String uid); // 查询最新打卡时间的时间

    int updateCall( @Param("uid") String uid, @Param("progress") String progress);//更新// 最新打卡时间 ，更新打卡总进度

    int updateInfo(@Param("uid")String uid, @Param("username") String username ,@Param("user_type")String user_type,
                    @Param("password") String password);

}
