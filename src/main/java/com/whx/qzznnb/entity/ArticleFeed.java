package com.whx.qzznnb.entity;


import com.whx.qzznnb.common.TimeUtil;

/**
 * feed页的时候 与ArticleEntity不同之处就是long maketime造成的
 */
public class ArticleFeed {

    private String aid;
    private String username;//作者
    private String uid; //作者的id
    private String title; //文章标题
    private String content; // 文章内容
    private long maketime; //创作时间
    private String type; //文章类型
    private String list_style; //  文章自创1
    private  String feed_style;



  public ArticleFeed(){}

    public ArticleFeed(ArticleEntity articleEntity){
        this.aid = articleEntity.getAid();
        this.username = articleEntity.getUsername();
        this.uid = articleEntity.getUid();
        this.title = articleEntity.getTitle();
        this.content = articleEntity.getContent();
        this.maketime = TimeUtil.dateToStamp(articleEntity.getMaketime());
        this.type = articleEntity.getType();
        this.list_style = articleEntity.getList_style();
    }



    //<!-- set  和 get方法  -->
    public String getList_style() {
        return list_style;
    }

    public void setList_style(String list_style) {
        this.list_style = list_style;
    }


    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public long getMaketime() {
        return maketime;
    }

    public void setMaketime(long maketime) {
        this.maketime = maketime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFeed_style() {
        return feed_style;
    }

    public void setFeed_style(String feed_style) {
        this.feed_style = feed_style;
    }

}
