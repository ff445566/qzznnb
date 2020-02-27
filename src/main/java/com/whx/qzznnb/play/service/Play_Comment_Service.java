package com.whx.qzznnb.play.service;

import com.whx.qzznnb.play.entity.Play_Comment;

import java.util.List;


public interface Play_Comment_Service {

    //--------------------评论模块---------------------
    public  int save_Play_Comment(Play_Comment play_comment);
    // 查看问题下的评论
    public List<Play_Comment> select_one_comment(String anid);

    // 查看某个评论下的所有相关评论
    public List<Play_Comment> select_two_comment(String  comment_id);

    // 查看某个问题下的的所有相关二级评论根据所有的一级评论id集合来的
    public List<Play_Comment> select_two_commentbyList(List comment_id);

}
