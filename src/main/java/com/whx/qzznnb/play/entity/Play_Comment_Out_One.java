//<editor-fold desc="Description">
package com.whx.qzznnb.play.entity;

import com.whx.qzznnb.common.TimeUtil;

import java.util.HashMap;


/** 出参实体类 一级评论
 * @ClassName Play_Answer
 * @Description TODO
 * @Date 2019/11/11 15:22
 * @Version 1.0.0
 **/

public class    Play_Comment_Out_One {

    private String anid;    //答案id

    //可以考虑 把commeent_id uid username  做成一个
    private HashMap<String,String> comment_info = new HashMap<String, String>();
    private String content; //回答内容



    private Long maketime;  //创作时间
    private String list_style; //回答的来源  0 1
    //  数据库中没有字段
   // private String status;



    // 构造方法
    public Play_Comment_Out_One() {
    }

    /**
     * 出参转换
     * @param play_comment
     */
    public  Play_Comment_Out_One(Play_Comment play_comment){

       this.maketime= TimeUtil.dateToStamp(play_comment.getMaketime());
       this.anid =play_comment.getAnid();
       this.content=play_comment.getContent();
       this.list_style=play_comment.getList_style();
       this.comment_info.put("comment_id",play_comment.getComment_id());
       this.comment_info.put("uid",play_comment.getUid());
       this.comment_info.put("user_name",play_comment.getUsername());

    }
    public String getAnid() {
        return anid;
    }

    public void setAnid(String anid) {
        this.anid = anid;
    }

    public HashMap<String, String> getComment_info() {
        return comment_info;
    }

    public void setComment_info(HashMap<String, String> comment_info) {
        this.comment_info = comment_info;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getList_style() {
        return list_style;
    }

    public void setList_style(String list_style) {
        this.list_style = list_style;
    }
    public Long getMaketime() {
        return maketime;
    }

    public void setMaketime(Long maketime) {
        this.maketime = maketime;
    }
}
//</editor-fold>