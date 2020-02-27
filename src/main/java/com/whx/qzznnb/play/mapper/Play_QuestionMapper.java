package com.whx.qzznnb.play.mapper;

import com.whx.qzznnb.play.entity.Play_Answer;
import com.whx.qzznnb.play.entity.Play_Question;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 此mapper  主要是服务问题
 *
 */
@Repository
public interface Play_QuestionMapper {

    int save_Play_Question(Play_Question play_question);// 保存问题
    Play_Question selcet_Play_Question(String qid); // 通过qid 查询问题
    List<Topic>  select_Play_AllTopic(); //查询所有的话题
    List<Play_Question> select_Play_FeedQuestion(int page ,int counts ); //查询feed页的问题
    Play_Answer select_Play_FeedQueAns(String qid ); //查询feed页的问题
    List<Play_Question> select_que_byuid(String uid);//查询
    int select_Question_counts(); //查询问题的总数量
}
