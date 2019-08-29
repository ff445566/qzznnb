package com.whx.qzznnb.entity;

import java.util.Date;

public class Article {

    private  String  aid;
    private  String  uid;//作者id
    private  String title; //文章标题
    private  String content; // 文章内容
    private Date maketime; //创作时间
    private  String type; //文章类型



    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
}
