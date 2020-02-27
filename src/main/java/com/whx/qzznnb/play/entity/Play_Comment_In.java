package com.whx.qzznnb.play.entity;

import java.util.HashMap;

/**  入参实体类
 * @ClassName Play_Answer
 * @Description TODO
 * @Date 2019/11/11 15:22
 * @Version 1.0.0
 **/
public class Play_Comment_In {

    private String anid;    //答案id

    private String is_father; //是不是一级评论
    private String father_id;// 一级评论的id
    private String to_id; //被评论id （+username）


    private String to_uid; //被评论 uid （+username）

    //可以考虑 把commeent_id uid username  做成一个
    private HashMap<String,String> comment_info = new HashMap<String, String>();
    // 把to_id to_uid to_username 做成一个
    private  HashMap<String ,String>  to_info= new HashMap<String, String>();
    private String content; //回答内容
    private Long maketime;  //创作时间

    private String list_style; //回答的来源  0 1
    //  数据库中没有字段
    private String status;



    // 构造方法
    public Play_Comment_In() {
    }

    public String getAnid() {
        return anid;
    }

    public void setAnid(String anid) {
        this.anid = anid;
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

    public HashMap<String, String> getComment_info() {
        return comment_info;
    }

    public void setComment_info(HashMap<String, String> comment_info) {
        this.comment_info = comment_info;
    }


    public HashMap<String, String> getTo_info() {
        return to_info;
    }

    public void setTo_info(HashMap<String, String> to_info) {
        this.to_info = to_info;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getTo_uid() {
        return to_uid;
    }

    public void setTo_uid(String to_uid) {
        this.to_uid = to_uid;
    }

    public Long getMaketime() {
        return maketime;
    }

    public void setMaketime(Long maketime) {
        this.maketime = maketime;
    }

    public String getIs_father() {
        return is_father;
    }

    public void setIs_father(String is_father) {
        this.is_father = is_father;
    }

    public String getList_style() {
        return list_style;
    }

    public void setList_style(String list_style) {
        this.list_style = list_style;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}