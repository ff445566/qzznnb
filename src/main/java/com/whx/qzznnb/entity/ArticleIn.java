package com.whx.qzznnb.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName ArticleIn
 * @Description TODO
 * @Date 2019/9/11 10:41
 * @Version 1.0.0
 **/
public class ArticleIn {

    private HashMap<String ,String > user_info =new HashMap<String, String>(); // 把作者uid 和username 一起传过去{uid.username}
    private  String title; //文章标题
    private  String content; // 文章内容
    private List<HashMap<String,String>> type =
            new ArrayList<HashMap<String,String>>(); //文章类型  处理成{type_id:"11',type_name:" "}
    private  String list_style; // 文章内容


    public HashMap<String, String> getUser_info() {
        return user_info;
    }

    public String getList_style() {
        return list_style;
    }

    public void setList_style(String list_style) {
        this.list_style = list_style;
    }
    public void setUser_info(HashMap<String, String> user_info) {
        this.user_info = user_info;
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

    public List<HashMap<String, String>> getType() {
        return type;
    }

    public void setType(List<HashMap<String, String>> type) {
        this.type = type;
    }

}
