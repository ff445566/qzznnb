package com.whx.qzznnb.entity;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 与数据库打交道的类
 */
public class ArticleEntity {

    private String aid;
    private String username;//作者
    private String uid; //作者的id
    private String title; //文章标题
    private String content; // 文章内容
    private Date maketime; //创作时间
    private String type; //文章类型
    private String list_style; //  文章自创1
    private  String feed_style;


    public ArticleEntity(ArticleIn articleIn, Date maketime, String aid) {
        this.aid = aid;
        this.username = articleIn.getUser_info().get("user_name");
        this.uid = articleIn.getUser_info().get("uid");
        this.title = articleIn.getTitle();
        this.content = articleIn.getContent();
        this.maketime = maketime;
        this.list_style = articleIn.getList_style();
        String strType = "";
        List typelist = articleIn.getType();//解析type
        for (int i = 0; i < typelist.size(); i++) {
            HashMap<String, String> typemap = (HashMap<String, String>) typelist.get(i);
            String type_id = typemap.get("type_id");
            strType = strType + type_id + ",";
            String type_name = typemap.get("type_name");
            strType = strType + type_name + ";";
        }
        this.type = strType;

    }
  public  ArticleEntity(){}

    public static class Builder {

        private String aid;
        private String username;//作者
        private String uid; //作者的id
        private String title; //文章标题
        private String content; // 文章内容
        private Date maketime; //创作时间
        private String type; //文章类型
        private String list_style; //  文章自创1

        public Builder(String uid, String username) {
            this.uid = uid;
            this.username = username;
        }

        public Builder aid(String val) {
            this.aid = val;
            return this;
        }

        public Builder maketime(Date val) {
            this.maketime = val;
            return this;
        }

        public Builder title(String val) {
            this.title = val;
            return this;
        }

        public Builder content(String val) {
            this.content = val;
            return this;
        }

        public Builder list_style(String val) {
            this.list_style = val;
            return this;
        }

        public Builder type(String val) {
            this.type = val;
            return this;
        }

        public ArticleEntity build() {
            return new ArticleEntity(this);
        }
    }

    private ArticleEntity(Builder builder) {
        aid = builder.aid;
        username = builder.username;
        uid = builder.uid; //作者的id
        title = builder.title; //文章标题
        content = builder.content; // 文章内容
        maketime = builder.maketime; //创作时间
        type = builder.type; //文章类型
        list_style = builder.list_style; //  文章自创1
    }

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

    //<!-- set  和 get方法  -->
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFeed_style() {
        return feed_style;
    }

    public void setFeed_style(String feed_style) {
        this.feed_style = feed_style;
    }

}
