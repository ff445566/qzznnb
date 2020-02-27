package com.whx.qzznnb.entity;

/**
 * @ClassName LikeIn
 * @Description
 * @Date 2019/12/7 14:57
 * @Version 1.0.0
 **/
public class LikeIn {

    private String uid;  // 用户id
    private String to_uid; // 被点赞的用户id
    private String like_id; // 点赞内容 id
    private String scope; //  点赞的类型 文章 计划 答案 评论
    private  int status; //  默认第一次的时候是0
    public  LikeIn(){
        status =0;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTo_uid() {
        return to_uid;
    }

    public void setTo_uid(String to_uid) {
        this.to_uid = to_uid;
    }

    public String getLike_id() {
        return like_id;
    }

    public void setLike_id(String like_id) {
        this.like_id = like_id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
