package com.whx.qzznnb.play.service.serviceImp;

import com.whx.qzznnb.play.entity.Play_Answer;
import com.whx.qzznnb.play.entity.Play_AnswerAndQuestion;
import com.whx.qzznnb.play.entity.Play_Answer_out;
import com.whx.qzznnb.play.entity.Play_Question_Entity;
import com.whx.qzznnb.play.mapper.Play_AnswerMapper;
import com.whx.qzznnb.play.service.Play_Answer_Service;
import com.whx.qzznnb.play.service.Play_Question_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service("play_Answer_Service")
public  class Play_Answer_ServiceImp implements Play_Answer_Service {


    @Autowired
    Play_AnswerMapper play_answerMapper;
    @Autowired
    Play_Question_Service play_question_service;

    /**
     * 保存回答
     * @param play_answer
     * @return
     */
    @Override
    public int save_Play_Answer(Play_Answer play_answer) {
        return play_answerMapper.save_play_answer(play_answer);
    }

    @Override
    public List<Play_Answer> select_play_answer(String qid) {
        return play_answerMapper.select_play_answer(qid);
    }

    @Override
    public List select_paly_answerbyuid(String uid) {
        List reslist = new ArrayList();

        List<Play_AnswerAndQuestion> answerList =play_answerMapper.select_paly_answerbyuid(uid);

        Play_AnswerAndQuestion play_answerAndQuestion;
        Play_Answer_out play_answer_out;
        Play_Question_Entity play_question_entity;
        for (int i = 0; i < answerList.size(); i++) {
            HashMap<String,Object> reshashMap = new HashMap<>();
            play_answerAndQuestion  = answerList.get(i);
            play_answer_out =new Play_Answer_out(play_answerAndQuestion);
            play_question_entity = new Play_Question_Entity(play_answerAndQuestion);
            reshashMap.put("feed_style",play_answerAndQuestion.getQ_feed_style());
            reshashMap.put("question",play_question_entity);
            reshashMap.put("answer",play_answer_out);
            reslist.add(reshashMap);
        }

        return reslist;
    }


}
