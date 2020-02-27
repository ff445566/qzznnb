package com.whx.qzznnb.play.entity;

import com.whx.qzznnb.common.TimeUtil;

import java.util.HashMap;

/** 实体类 在出参参时的使用
 *
 * @ClassName Play_Answer
 * @Description TODO
 * @Date 2019/11/11 15:22
 * @Version 1.0.0
 **/
public class Play_Answer_out {

    private  String  anid;    //答案id
    private  String  qid;    //回答id
    private HashMap<String ,String > user_info =
            new HashMap<String, String>();// 把作者uid 和username 一起传过去{uid.username}   //回答人id
    private  String content; //回答内容


    private  long maketime;  //创作时间 仅出参的时候使用
    //private  String type;    //回答类型
    private  String list_style; //回答的来源  0 1
    //  数据库中没有字段

    //sprivate  String status;
  //出参的时候使用
    public Play_Answer_out(Play_Answer play_answer) {
        this.maketime= TimeUtil.dateToStamp(play_answer.getMaketime());
        this.anid =play_answer.getAnid();
        this.qid=play_answer.getQid();
        this.content=play_answer.getContent();
        this.list_style=play_answer.getList_style();
        this.user_info.put("uid",play_answer.getUid());
        this.user_info.put("user_name",play_answer.getUsername());
    }
    public Play_Answer_out(Play_AnswerAndQuestion play_answerAndQuestion) {
        this.maketime= TimeUtil.dateToStamp(play_answerAndQuestion.getA_maketime());
        this.anid =play_answerAndQuestion.getA_anid();
        this.qid=play_answerAndQuestion.getA_qid();
        this.content=play_answerAndQuestion.getA_content();
        this.list_style=play_answerAndQuestion.getA_list_style();
        this.user_info.put("uid",play_answerAndQuestion.getA_uid());
        this.user_info.put("user_name",play_answerAndQuestion.getA_username());
    }
    public Play_Answer_out(){}

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

    public HashMap<String, String> getUser_info() {
        return user_info;
    }

    public void setUser_info(HashMap<String, String> user_info) {
        this.user_info = user_info;
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

    public void setMaketime(long maketime) {
        this.maketime = maketime;
    }


    public String getList_style() {
        return list_style;
    }

    public void setList_style(String list_style) {
        this.list_style = list_style;
    }




}
