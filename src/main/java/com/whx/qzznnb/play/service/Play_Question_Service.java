package com.whx.qzznnb.play.service;

import com.whx.qzznnb.play.entity.Play_Question;
import org.springframework.data.redis.listener.Topic;

import java.util.HashMap;
import java.util.List;


public interface Play_Question_Service {



    // ---------------问题模块---------------------
    public  int save_Play_Question(Play_Question play_question);
    public HashMap<String,Object> select_Play_QueAnsCom_Byid(String qid);
    public List<Topic> select_Play_AllTopic();
    // 查询问题和答案 feed 页
    public  List< HashMap<String,Object> > select_Play_QueAns_Feed(int page,int counts);
     // 根据用户id 查询问题
    public   List  select_que_byuid(String uid);
//    // 根据用 问题id查询
//    public   Play_Question  select_que_byqid(String qid);
    //查询问题的总数量
    public  int select_Question_counts();
}
