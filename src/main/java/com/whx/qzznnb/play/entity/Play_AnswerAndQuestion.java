package com.whx.qzznnb.play.entity;

import java.util.Date;

/**
 * @ClassName Play_AnswerAndQuestion
 * @Description TODO
 * @Date 2019/11/23 15:59
 * @Version 1.0.0
 **/
public class Play_AnswerAndQuestion {

    private  String  a_anid;    //答案id
    private  String  a_qid;    //回答id
    private  String  a_uid;    //回答人id
    private  String  a_content; //回答内容
    private Date  a_maketime;  //创作时间
    private  String  a_list_style; //回答的来源  0 1
    //  数据库中没有字段
    private  String  a_username;
    private  String  a_status;

    // 问题相关的字段
    private  String  q_qid;    //问题id
    private  String  q_uid;    //作者id
    private  String q_title;   //问题标题
    private  String q_content; //问题内容
    private Date q_maketime;  //创作时间
    private  String q_type;    //问题类型
    private  String q_list_style; //问题的来源  0 1
    private  String q_feed_style; //feed页
    private  String q_type_name;
    //  数据库中没有字段
    private  String q_username;

 public Play_AnswerAndQuestion(){}
    public String getA_anid() {
        return a_anid;
    }

    public void setA_anid(String a_anid) {
        this.a_anid = a_anid;
    }

    public String getA_qid() {
        return a_qid;
    }

    public void setA_qid(String a_qid) {
        this.a_qid = a_qid;
    }

    public String getA_uid() {
        return a_uid;
    }

    public void setA_uid(String a_uid) {
        this.a_uid = a_uid;
    }

    public String getA_content() {
        return a_content;
    }

    public void setA_content(String a_content) {
        this.a_content = a_content;
    }

    public Date getA_maketime() {
        return a_maketime;
    }

    public void setA_maketime(Date a_maketime) {
        this.a_maketime = a_maketime;
    }

    public String getA_list_style() {
        return a_list_style;
    }

    public void setA_list_style(String a_list_style) {
        this.a_list_style = a_list_style;
    }

    public String getA_username() {
        return a_username;
    }

    public void setA_username(String a_username) {
        this.a_username = a_username;
    }

    public String getA_status() {
        return a_status;
    }

    public void setA_status(String a_status) {
        this.a_status = a_status;
    }

    public String getQ_qid() {
        return q_qid;
    }

    public void setQ_qid(String q_qid) {
        this.q_qid = q_qid;
    }

    public String getQ_uid() {
        return q_uid;
    }

    public void setQ_uid(String q_uid) {
        this.q_uid = q_uid;
    }

    public String getQ_title() {
        return q_title;
    }

    public void setQ_title(String q_title) {
        this.q_title = q_title;
    }

    public String getQ_content() {
        return q_content;
    }

    public void setQ_content(String q_content) {
        this.q_content = q_content;
    }

    public Date getQ_maketime() {
        return q_maketime;
    }

    public void setQ_maketime(Date q_maketime) {
        this.q_maketime = q_maketime;
    }

    public String getQ_type() {
        return q_type;
    }

    public void setQ_type(String q_type) {
        this.q_type = q_type;
    }

    public String getQ_list_style() {
        return q_list_style;
    }

    public void setQ_list_style(String q_list_style) {
        this.q_list_style = q_list_style;
    }

    public String getQ_type_name() {
        return q_type_name;
    }

    public void setQ_type_name(String q_type_name) {
        this.q_type_name = q_type_name;
    }

    public String getQ_username() {
        return q_username;
    }

    public void setQ_username(String q_username) {
        this.q_username = q_username;
    }
    public String getQ_feed_style() {
        return q_feed_style;
    }

    public void setQ_feed_style(String q_feed_style) {
        this.q_feed_style = q_feed_style;
    }
}
