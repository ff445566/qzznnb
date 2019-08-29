package com.whx.qzznnb.controller;

import com.whx.qzznnb.common.RedisUtil;
import com.whx.qzznnb.common.ServeResponse;
import com.whx.qzznnb.common.UuidUtil;
import com.whx.qzznnb.common.WebToken;
import com.whx.qzznnb.entity.User;
import com.whx.qzznnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("getUser/{uid}")
    public User getUserById(@PathVariable String  uid){

        return userService.getUserById(uid);
    }

    /**
     * 用户注册模块
     * @param
     * @return
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST )
    //@PostMapping("createUser")
    public ServeResponse<String> createUser(User  user ){


        //检测用户名
       String name = userService.checkUserName(user.getUsername());
       if(name != null||"".equals(name)){
           // 100代表用户名已经注册
           return  ServeResponse.createByErrorCodeMessage(100,"用户名已经注册");
       }
       //检测邮箱
        String email = userService.checkEmail(user.getEmail());
        if(email != null||"".equals(email)){
            // 101 代表邮箱已经注册
            return  ServeResponse.createByErrorCodeMessage(101,"邮箱已经注册");
        }
       //增加唯一id
        user.setUid(UuidUtil.getUuid());
        if(userService.createUser(user) == 1){
            redisUtil.Sset(name,user.getPassword()); // 存储到redis中
            return  ServeResponse.createBySuccessMessage("用户注册成功");
        }
        return  ServeResponse.createByErrorMessage("注册失败 请重新注册");

    }
    @RequestMapping("/login")
    public ServeResponse<String> login(HttpServletRequest request, HttpServletResponse response){

        String username =request.getParameter("username");
        String password =request.getParameter("password");

       if(username != null && password !=null){
           //redis  检测
           //检测是否有这个key,有进行验证
           //在注册成功之后，就把用户账号密码进行一次存储redids
           if (redisUtil.hasKey(username) && redisUtil.Sget(username).equals( password)){ //登录成功
               //
           }

           String uid=userService.login(username,password);
           if(uid != null && !"".equals(uid)) { //登录成功
               Map<String,Object> tokenmap = new HashMap<String, Object>();
               tokenmap.put("uid",uid);
               String token =WebToken.createJavaWebToken(tokenmap);
               Cookie cookie  =new Cookie("token",token);
               cookie.setValue(token);
               cookie.setPath("/");
               response.addCookie(cookie);
//               response.addHeader("Set-cookie",token);
//               response.addHeader("token",token);

           return ServeResponse.createBySuccess("登录成功", token);

           }
           else
               return  ServeResponse.createByErrorMessage("用户或密码不正确，请重新登录");
       }
     return  ServeResponse.createByErrorMessage("登录嗝屁");
    }

}
