package com.whx.qzznnb.entity;

import com.whx.qzznnb.common.TimeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArticleCan {

    private String aid;
    private HashMap<String, String> user_info =
            new HashMap<String, String>(); // 把作者uid 和username 一起传过去{uid.username}
    private String title; //文章标题
    private String content; // 文章内容
    private long make_time; //创作时间

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public HashMap<String, String> getUser_info() {
        return user_info;
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

    public long getMake_time() {
        return make_time;
    }

    public void setMake_time(long make_time) {
        this.make_time = make_time;
    }

    public List<HashMap<String, String>> getType() {
        return type;
    }

    public void setType(List<HashMap<String, String>> type) {
        this.type = type;
    }

    public String getList_style() {
        return list_style;
    }

    public void setList_style(String list_style) {
        this.list_style = list_style;
    }

    private List<HashMap<String, String>> type =
            new ArrayList<HashMap<String, String>>(); //文章类型  处理成{type_id:"11',type_name:" "}
    private String list_style; //  文章自创1


    public static class Builder {
        private String aid;
        private HashMap<String, String> user_info = new HashMap<String, String>(); // 把作者uid 和username 一起传过去{uid.username}
        private String title; //文章标题
        private String content; // 文章内容
        private long make_time; //创作时间
        private List<HashMap<String, String>> type =
                new ArrayList<HashMap<String, String>>(); //文章类型  处理成{type_id:"11
        private String list_style; //  文章自创1

        public Builder(ArticleEntity articleEntity) {
            this.user_info = new HashMap<String, String>();
            this.user_info.put("uid", articleEntity.getUid());  //用户信息键值对的形式
            this.user_info.put("user_name", articleEntity.getUsername());
            this.aid = articleEntity.getAid();
            this.title = articleEntity.getTitle();
            this.content = articleEntity.getContent();
            this.make_time = TimeUtil.dateToStamp(articleEntity.getMaketime());
            this.list_style = articleEntity.getList_style();
            this.type = typeGet(articleEntity.getType());

        }

        public ArticleCan builder() {
            return new ArticleCan(this);
        }

        private List<HashMap<String, String>> typeGet(String types) {

            List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
            String[] st = types.split(";");
            if(st.length ==0) return  null;
            for (int i = 0; i < st.length; i++) {
                String s = st[i];
                String[] res = s.split(",");
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("type_id", res[0]);
                hashMap.put("type_name", res[1]);
                list.add(hashMap);
            }
            return list;
        }


    }

    private ArticleCan(Builder builder) {
        this.user_info = builder.user_info;
        this.aid = builder.aid;
        this.title = builder.title;
        this.content = builder.content;
        this.make_time = builder.make_time;
        this.list_style = builder.list_style;
        this.type = builder.type;
    }

}
