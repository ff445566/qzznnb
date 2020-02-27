package com.whx.qzznnb.play.entity;

import java.util.Date;

/** 与数据库中保持一致的实体类
 * @ClassName Play_Answer
 * @Description TODO
 * @Date 2019/11/11 15:22
 * @Version 1.0.0
 **/
public class Play_Answer {

    private  String  anid;    //答案id
    private  String  qid;    //回答id
    private  String  uid;    //回答人id
    private  String content; //回答内容
    private Date maketime;  //创作时间
    private  String list_style; //回答的来源  0 1
    //  数据库中没有字段
    private  String username;
    private  String status;
  // 构造方法
    public Play_Answer(){};
    public Play_Answer(Play_Answer_In play_question_in, Date maketime, String anid) {
        this.anid = anid;
        this.qid = play_question_in.getQid();
        this.username = play_question_in.getUser_info().get("user_name");
        this.uid = play_question_in.getUser_info().get("uid");
        this.content = play_question_in.getContent();
        this.maketime = maketime;
        this.list_style = play_question_in.getList_style();
    }
    public String getAnid() {
        return anid;
    }

    public void setAnid(String anid) {
        this.anid = anid;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
