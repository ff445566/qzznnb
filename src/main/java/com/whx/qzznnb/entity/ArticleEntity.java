package com.whx.qzznnb.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ArticleEntity {


    private  String aid;
     private  String username;//作者
    private  String uid; //作者的id
    private  String title; //文章标题
    private  String content; // 文章内容
    private Date maketime; //创作时间
    private  String type; //文章类型
    private  String list_style; //  文章自创1


    public ArticleEntity(String aid, String username, String uid, String title, String content, Date maketime, String type, String list_style) {
        this.aid = aid;
        this.username = username;
        this.uid = uid;
        this.title = title;
        this.content = content;
        this.maketime = maketime;
        this.type = type;
        this.list_style = list_style;
    }

    public  ArticleEntity(){}
    public ArticleEntity(ArticleCan articleCan){
        this.aid = articleCan.getAid();
        this.username = articleCan.getUser_info().get("user_name");
        this.uid = articleCan.getUser_info().get("uid");
        this.title = articleCan.getTitle();
        this.content = articleCan.getContent();
        this.maketime = articleCan.getmake_time();

        this.list_style = articleCan.getList_style();
        String strType="";
       List typelist =articleCan.getType();//解析type
        for (int i = 0; i < typelist.size(); i++) {
            HashMap<String,String> typemap = ( HashMap<String,String>)typelist.get(i);
           String type_id = typemap.get("type_id");
            strType=strType+type_id+",";
            String type_name = typemap.get("type_name");
            strType=strType+type_name+";";
        }
        this.type=strType;

    }

    public String getList_style() {
        return list_style;
    }

    public void setList_style(String list_style) {
        this.list_style = list_style;
    }



    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getMaketime() {
        return maketime;
    }

    public void setMaketime(Date maketime) {
        this.maketime = maketime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
