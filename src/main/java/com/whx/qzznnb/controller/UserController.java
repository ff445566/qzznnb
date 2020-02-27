package com.whx.qzznnb.controller;

import com.whx.qzznnb.common.*;
import com.whx.qzznnb.entity.*;
import com.whx.qzznnb.play.service.Play_Answer_Service;
import com.whx.qzznnb.play.service.Play_Question_Service;
import com.whx.qzznnb.service.ArticleService;
import com.whx.qzznnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private Play_Question_Service play_question_service;
@Autowired
private Play_Answer_Service play_answer_service;
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
        //String  phone =null;
        User  userP  = userService.checkPhone(user.getPhone());
        if(userP !=null){
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
        User user =userService.checkPhone(phone);
        if(user == null){// 手机号未注册
            return ServeResponse.createByErrorCodeMessage(codeConsta.PHONENOT.getCode(),"该手机号未注册");

        }else if(user.getPassword().equals(password)){
            return ServeResponse.createBySuccess("登录成功", new UserEntity(user.getUid(),user.getUsername()));
        }
        else {

            return ServeResponse.createByErrorCodeMessage(codeConsta.PASSWORDERROR.getCode(),
                    "密码不正确");
        }


    }
     return  ServeResponse.createByErrorCodeMessage(codeConsta.PARAMNOT.getCode(),"登录参数获取不完整");
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
     * 查询个人信息  个人主页
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
             // 我的问题
            List que_List = play_question_service.select_que_byuid(uid);

            // 我的答案
            List ansque_list = play_answer_service.select_paly_answerbyuid(uid);


           UserInfo userInfo = new UserInfo(user.getUsername(),user.getUser_type(),user.getUid(),user.getPhone(),articleList,que_List,ansque_list);
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
    @RequestMapping(value = "update_info" ,method = RequestMethod.POST)
  //public  ServeResponse<String> updateInfo(@RequestParam ("uid") String uid,@RequestParam("user_name")  String user_name,@RequestParam("user_type") String user_type,@RequestParam("password") String password){ // 多个类型
       //同时更新多个
    public  ServeResponse<String> updateInfo(@RequestBody Map<String,String> map){
        int result = 0;
        String uid=null;
        String user_name =null;
        String user_type =null;
        String password  = null;
      try {
          if(map.containsKey("uid")){
                uid =map.get("uid");
          }
          if(map.containsKey("user_name")){
              user_name =map.get("user_name");
          }if(map.containsKey("user_type")){
              user_type =map.get("user_type");
          }if(map.containsKey("password")){
              password =map.get("password");
          }

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
