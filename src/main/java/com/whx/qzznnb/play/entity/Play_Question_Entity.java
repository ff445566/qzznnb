package com.whx.qzznnb.play.entity;

import com.whx.qzznnb.common.TimeUtil;

import java.util.HashMap;

/**
 * 出参的时候必须完全统一，入参的时候则不一定
 * 当入参是出参的子集的时候可以进行使用。
 * @ClassName Play_Question_In  作为入参 提问实体类
 * 目前来看也可以作为出参
 * @Description TODO
 * @Date 2019/11/10 17:14
 * @Version 1.0.0
 **/
public class Play_Question_Entity {

    private HashMap<String ,String > user_info =
            new HashMap<String, String>();// 把作者uid 和username 一起传过去{uid.username}
    private  HashMap<String ,String > type =
            new HashMap<String ,String > (); //问题类型
    private  String title; //标题
    private  String content; // 内容
    private  String list_style; //  问题制造商

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    private  String qid;

    // 出参的时候使用
    private  Long maketime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Long getMaketime() {
        return maketime;
    }

    public void setMaketime(long maketime) {
        this.maketime = maketime;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HashMap<String,String>getType() {
        return type;
    }

    public void setType( HashMap<String, String> type) {
        this.type = type;
    }
    public void setUser_info(HashMap<String, String> user_info) {
        this.user_info = user_info;
    }
    public String getList_style() {
        return list_style;
    }

    public void setList_style(String list_style) {
        this.list_style = list_style;
    }
    public HashMap<String, String> getUser_info() {
        return user_info;
    }


    @Override
    public String toString() {
        return user_info.get("uid")+user_info.get("user_name");
    }
   public Play_Question_Entity(){}
    public Play_Question_Entity(Play_Question play_question){
        this.user_info.put("uid",play_question.getUid());
        this.user_info.put("user_name",play_question.getUsername());
        this.type.put("tid",play_question.getType());
        this.type.put("type_name",play_question.getType_name());
        //
        this.maketime = TimeUtil.dateToStamp(play_question.getMaketime());
        this.content =play_question.getContent();
        this.list_style =play_question.getList_style();
        this.title =play_question.getTitle();
        this.qid =play_question.getQid();

    }
    // 个人主页返回答案对应问题时使用
    public Play_Question_Entity(Play_AnswerAndQuestion play_answerAndQuestion){
        this.user_info.put("uid",play_answerAndQuestion.getQ_uid());
        this.user_info.put("user_name",play_answerAndQuestion.getQ_username());
        this.type.put("tid",play_answerAndQuestion.getQ_type());
        this.type.put("type_name",play_answerAndQuestion.getQ_type_name());
        //
        this.maketime = TimeUtil.dateToStamp(play_answerAndQuestion.getQ_maketime());
        this.content =play_answerAndQuestion.getQ_content();
        this.list_style =play_answerAndQuestion.getQ_list_style();
        this.title =play_answerAndQuestion.getQ_title();
        this.qid =play_answerAndQuestion.getQ_qid();

    }
}
