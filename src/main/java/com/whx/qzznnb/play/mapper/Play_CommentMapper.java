package com.whx.qzznnb.play.mapper;

import com.whx.qzznnb.play.entity.Play_Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 此mapper  主要是服务 发文
 *
 */
@Repository
public interface Play_CommentMapper {

    int save_Play_Comment(Play_Comment play_comment);// 保存答案
    List<Play_Comment> selcet_One_Comment(String  anid);//查看一级评论 通过问题qid
    List<Play_Comment> selcet_Two_Comment(String  comment_id);//查看二级评论 通过一级评论id
    List<Play_Comment> select_two_commentbyList(@Param("comment_list") List  comment_list);//查看某个问题下的二级评论， 通过一级评论id集合

}
