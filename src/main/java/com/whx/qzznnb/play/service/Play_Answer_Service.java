package com.whx.qzznnb.play.service;

import com.whx.qzznnb.play.entity.Play_Answer;

import java.util.List;


public interface Play_Answer_Service {

    // ---------------回答模块---------------------
    // 保存回答
    public  int save_Play_Answer(Play_Answer play_answer);
    // 查看某一个问题下的所有回答
    public List<Play_Answer> select_play_answer(String qid);
   // 根据uid 查询回答
    public  List select_paly_answerbyuid(String uid);
}
