package com.whx.qzznnb.play.entity;


import java.util.Date;

/**
 * @ClassName paly_question
 * @Description TODO  问题实体类
 * @Date 2019/11/10 15:38
 * @Version 1.0.0
 **/

public class Play_Question {

    private  String  qid;    //问题id
    private  String  uid;    //作者id
    private  String title;   //问题标题
    private  String content; //问题内容
    private  Date  maketime;  //创作时间
    private  String type;    //问题类型
    private  String list_style; //问题的来源  0 1
    private  String feed_style; //feed页
    private  String type_name;
    //  数据库中没有字段
    private  String username;

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
    public String getFeed_style() {
        return feed_style;
    }

    public void setFeed_style(String feed_style) {
        this.feed_style = feed_style;
    }

    //  private String status; // 审核状态  目前还没有进行数据库的存储操作

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
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

    public String getList_style() {
        return list_style;
    }

    public void setList_style(String list_style) {
        this.list_style = list_style;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


public Play_Question(){}
    public Play_Question(Play_Question_Entity play_question_entity, Date maketime, String qid) {
        this.qid = qid;
        this.username = play_question_entity.getUser_info().get("user_name");
        this.uid = play_question_entity.getUser_info().get("uid");
        this.title = play_question_entity.getTitle();
        this.content = play_question_entity.getContent();
        this.maketime = maketime;
        this.list_style = play_question_entity.getList_style();
        this.type = play_question_entity.getType().get("type_id");//解析type

    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }


}
