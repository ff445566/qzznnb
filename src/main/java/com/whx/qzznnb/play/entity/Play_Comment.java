package com.whx.qzznnb.play.entity;

import java.util.Date;

/** 与数据库中保持一致的实体类
 * @ClassName Play_Answer
 * @Description TODO
 * @Date 2019/11/11 15:22
 * @Version 1.0.0
 **/

public class Play_Comment {
    private String comment_id;// 评论id
    private String anid;    //答案id
    private String uid;    //评论人id (+name)
    private String is_father; //是不是一级评论
    private String father_id;// 一级评论的id
    private String to_id; //评论的哪条id （+username）
    private  String to_uid;// 被评论的uid
    private String content; //回答内容
    private Date maketime;  //创作时间
    private String list_style; //回答的来源  0 1
    //  数据库中该表没有字段
   // private String status;
    private  String username; //从数据库中取数据的时候使用的字段 本条评论的username
    private  String to_username; //从数据库中取数据的时候使用的字段 被评论评论的to_username

    public String getTo_username() {
        return to_username;
    }

    public void setTo_username(String to_username) {
        this.to_username = to_username;
    }






    // 构造方法
    public Play_Comment() {
    }


    public Play_Comment(Play_Comment_In play_comment_in, Date maketime, String comment_id) {

        this.comment_id=comment_id;
        this.anid = play_comment_in.getAnid();
        this.uid = play_comment_in.getComment_info().get("uid");
        this.is_father=play_comment_in.getIs_father();
        this.father_id=play_comment_in.getFather_id();
        this.to_id =play_comment_in.getTo_info().get("to_id");
        this.to_uid =play_comment_in.getTo_info().get("to_uid");
        this.content = play_comment_in.getContent();
        this.maketime = maketime;
        this.list_style = play_comment_in.getList_style();


    }
    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getAnid() {
        return anid;
    }

    public void setAnid(String anid) {
        this.anid = anid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public String getFather_id() {
        return father_id;
    }

    public void setFather_id(String father_id) {
        this.father_id = father_id;
    }

    public String getTo_id() {
        return to_id;
    }

    public void setTo_id(String to_id) {
        this.to_id = to_id;
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
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public String getTo_uid() {
        return to_uid;
    }

    public void setTo_uid(String to_uid) {
        this.to_uid = to_uid;
    }

    public String getIs_father() {
        return is_father;
    }
    public void setIs_father(String is_father) {
        this.is_father = is_father;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}