package com.whx.qzznnb.play.mapper;

import com.whx.qzznnb.play.entity.Play_Answer;
import com.whx.qzznnb.play.entity.Play_AnswerAndQuestion;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 此mapper  主要是服务 发文
 *
 */
@Repository
public interface Play_AnswerMapper {
    int save_play_answer(Play_Answer play_answer);// 保存答案
    List<Play_Answer> select_play_answer(String qid);
    // 根据uid  查询自己的的回答，以及对应的问题
    List<Play_AnswerAndQuestion> select_paly_answerbyuid(String uid);
}
