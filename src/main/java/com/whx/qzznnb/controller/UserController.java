package com.whx.qzznnb.controller;

import com.whx.qzznnb.common.*;
import com.whx.qzznnb.entity.*;
import com.whx.qzznnb.service.ArticleService;
import com.whx.qzznnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 用户注册模块
     * @param
     * @return
     */
    @RequestMapping(value = "/create" )
    public ServeResponse<UserEntity> createUser(User  user ){
        if(user.getPhone() == null  || user.getPassword()== null || user.getUser_type() == null){
            return ServeResponse.createByErrorCodeMessage(codeConsta.PARAMNOT.getCode(),"参数不全");
        }
       //检测手机号
         String  phone =null;
         phone  = userService.checkPhone(user.getPhone());
        if(phone !=null|| "".equals(phone)){
            // 100代表手机号已经注册
            return  ServeResponse.createByErrorCodeMessage(codeConsta.PHONEREPEAT.getCode(),"手机号已经注册");
        }
       //增加唯一id
        user.setUid(UuidUtil.getUuid());
        String username =NameUtil.getRandomJianHan(4);
        String checkUsername = userService.checkUserName(username);
        while(checkUsername !=null){ //说明已存在名字 给username另外赋值
            String usernameT =NameUtil.getRandomJianHan(4);
            username=usernameT;
            checkUsername = userService.checkUserName(usernameT);
        }
        user.setUsername(username);
        if(userService.createUser(user) == 1){
            //redisUtil.Sset(phone,user.getPassword()); // 存储到redis中
            return  ServeResponse.createBySuccess("用户注册成功", new UserEntity(user));
        }
        return  ServeResponse.createByErrorMessage("注册失败 请重新注册");

    }

    /**
     * 用户登录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login")
    public ServeResponse<UserEntity> login(HttpServletRequest request, HttpServletResponse response){

        String  phone =request.getParameter("phone");
        String password =request.getParameter("password");

       if(phone != null && password !=null){
           //redis  检测
           //检测是否有这个key,有进行验证
           //在注册成功之后，就把用户账号密码进行一次存储redids
//           if (redisUtil.hasKey(phone) && redisUtil.Sget(phone).equals( password)){ //登录成功
//               //
//           }

           User user =userService.login(phone,password);
           if( user != null) { //登录成功
//               Map<String,Object> tokenmap = new HashMap<String, Object>();
//               tokenmap.put("uid",uid);
//               String token =WebToken.createJavaWebToken(tokenmap);
//               Cookie cookie  =new Cookie("token",token);
//               cookie.setValue(token);
//               cookie.setPath("/");
//               response.addCookie(cookie);

           return ServeResponse.createBySuccess("登录成功", new UserEntity(user));

           }
           else
               return  ServeResponse.createByErrorMessage("用户或密码不正确，请重新登录");
       }
     return  ServeResponse.createByErrorMessage("登录参数获取失败");
    }
         //<!--用户打卡 -->

    /**
     *   查询当前用户最新时间打卡
     * @param uid
     * @return
     */
        @RequestMapping("/call_last_time")
    public ServeResponse<String> callLastTime( @RequestParam String uid, @RequestParam String call_time){
          // 获取数据库的最新时间戳
          // 与前端进行比较  比较之后
          // 选择存储  还是返回已经打卡了
        String lastTime =userService.selectkLastTime(uid);
        if(lastTime == null||"".equals(lastTime)){ // 第一次打卡
            // 直接插入
            //
            int callResult= userService.updateProgress(uid,call_time);
            if(callResult == 0){
                return  ServeResponse.createByErrorMessage("打卡存储失败，重新打卡");
            }
            return   ServeResponse.createBySuccessMessage("打卡成功");
        }
        else{
            int t =TimeUtil.stampCompare(call_time,lastTime);
            if(t ==0){//相等 就不在打卡  今日已经打卡
            return ServeResponse.createByErrorMessage("重复打卡，今日已经打开");
            }
            else if(t==1){ //今日未打卡，插入打卡  更新
                //
                 int callResult= userService.updateProgress(uid,call_time);
                 if(callResult == 0){
                   return  ServeResponse.createByErrorMessage("打卡存储失败，重新打卡");
                    }
              return   ServeResponse.createBySuccessMessage("打卡成功");
            }
            else{ // 不打卡  最新时间 比库中的时间晚
              return   ServeResponse.createByErrorMessage("未成功打开，打卡时间不正确");
            }

        }
    }


    /**
     * 查询个人信息
     * @param uid
     * @return
     */
    @RequestMapping("/check_info")
    public  ServeResponse<UserInfo> check_info(String uid){

        User user = null;
        try {
            user = userService.selectByUid(uid);
            if(user ==null){
                return  ServeResponse.createByErrorCodeMessage(codeConsta.UIDEEROR.getCode(),"uid 不正确");
            }
            List<ArticleEntity> articleEntityList =articleService.selectArticleByUid(uid);

           List<ArticleCan> articleList = DataChangeUtil.listArticle(articleEntityList);
            UserInfo userInfo = new UserInfo(user.getUsername(),user.getUser_type(),user.getUid(),user.getPhone(),articleList);
            return ServeResponse.createBySuccess("获取成功",userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return  ServeResponse.createByErrorMessage("获取信息失败，稍后再试");
        }


    }
    /**
     *修改个人记录
     *
     */
    @RequestMapping("update_info")
  public  ServeResponse<String> updateInfo(String uid,String user_name,String user_type,String password){ // 多个类型
       //同时更新多个
        int result = 0;
      try {
          result = userService.updateInfo(uid, user_name, user_type, password);
          if(result !=0){
              return ServeResponse.createBySuccess("更新信息成功");
          }else
          {
              return ServeResponse.createByErrorMessage("更新信息失败");
          }
      } catch (Exception e) {
          e.printStackTrace();
          return ServeResponse.createByErrorMessage("更新信息出现异常咧");
      }

  }
}
