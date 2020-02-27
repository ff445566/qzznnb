package com.whx.qzznnb.play.entity;

import com.whx.qzznnb.common.TimeUtil;

import java.util.HashMap;

/** 与数据库中保持一致的实体类
 * @ClassName Play_Answer
 * @Description TODO
 * @Date 2019/11/11 15:22
 * @Version 1.0.0
 **/

public class Play_Comment_Out_Two {

    private String anid;    //答案id
    private String father_id;// 一级评论的id
    private String content; //回答内容
    private Long maketime;  //创作时间
    private String list_style; //回答的来源  0 1

    private HashMap<String, String> comment_info = new HashMap<String, String>();
    // private String comment_id;// 评论id
    //private String uid;    //评论人id (+name)
    // to_id to_uid to_username
    private HashMap<String, String> to_info = new HashMap<String, String>();
//    private String to_id; //评论的哪条id （+username）
//    private  String to_uid;// 被评论的uid
    //  数据库中没有字段
    // private String status;


    // 构造方法
    public Play_Comment_Out_Two() {
    }

    /**
     * 从数据库中得到  转换成出参
     * @param play_comment
     */
     public  Play_Comment_Out_Two(Play_Comment play_comment){

         this.comment_info.put("uid",play_comment.getUid());
         this.comment_info.put("user_name",play_comment.getUsername());
         this.comment_info.put("comment_id",play_comment.getComment_id());

         this.to_info.put("to_id",play_comment.getTo_id());
         this.to_info.put("to_username",play_comment.getTo_username());

         this.anid =play_comment.getAnid();
         this.content =play_comment.getContent();
         this.maketime = TimeUtil.dateToStamp(play_comment.getMaketime());
         this.list_style =play_comment.getList_style();
         this.father_id =play_comment.getFather_id();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getMaketime() {
        return maketime;
    }

    public void setMaketime(Long maketime) {
        this.maketime = maketime;
    }

    public String getList_style() {
        return list_style;
    }

    public void setList_style(String list_style) {
        this.list_style = list_style;
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


}