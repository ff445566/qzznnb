package com.whx.qzznnb.play.service.serviceImp;

import com.whx.qzznnb.play.entity.Play_Comment;
import com.whx.qzznnb.play.mapper.Play_CommentMapper;
import com.whx.qzznnb.play.service.Play_Comment_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论模块
 */
@Service("play_Comment_Service")
public  class Play_Comment_ServiceImp implements Play_Comment_Service {

    @Autowired
    Play_CommentMapper play_commentMapper;


    @Override
    public int save_Play_Comment(Play_Comment play_comment) {
        return play_commentMapper.save_Play_Comment(play_comment);
    }

    /**
     *
     * @param anid
     * @return
     */
    @Override
    public List<Play_Comment> select_one_comment(String anid) {

        return play_commentMapper.selcet_One_Comment(anid);
    }

    /**
     * 查看某个评论下的所有评论
     * @param comment_id
     * @return
     * 11.17
     */
    @Override
    public List<Play_Comment> select_two_comment(String comment_id) {

        return play_commentMapper.selcet_Two_Comment(comment_id);
    }

    @Override
    public List<Play_Comment> select_two_commentbyList(List comment_id) {
        return null;
    }
}
