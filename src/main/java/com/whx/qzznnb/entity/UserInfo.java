package com.whx.qzznnb.entity;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Date 2019/9/6 10:16
 * @Version 1.0.0
 **/
public class UserInfo {

    private String user_name; //昵称
   private String uid; //唯一性id

    private String user_type; //用户类型
    private HashMap<String ,String > user_info =new HashMap<String, String>(); // 把作者uid 和username 一起传过去{uid.username}
    private String  phone;
    private List<ArticleCan> article_list; // 我的文章

    public List<ArticleCan> getArticle_list() {
        return article_list;
    }

    public void setArticle_list(List<ArticleCan> article_list) {
        this.article_list = article_list;
    }

    public UserInfo(){

}
    public  UserInfo(String user_name, String user_type, String uid, String phone, List<ArticleCan> articleCanList) {
        this.user_name = user_name;
        this.user_type = user_type;
        this.uid = uid;
        this.phone = phone;
        this.article_list = articleCanList;
    }



    public String getuser_name() {
        return user_name;
    }

    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }



    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }




}
