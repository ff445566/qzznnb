package com.whx.qzznnb.play.service.serviceImp;

import com.whx.qzznnb.common.DataChangeUtil;
import com.whx.qzznnb.entity.ArticleEntity;
import com.whx.qzznnb.play.entity.*;
import com.whx.qzznnb.play.mapper.Play_AnswerMapper;
import com.whx.qzznnb.play.mapper.Play_CommentMapper;
import com.whx.qzznnb.play.mapper.Play_QuestionMapper;
import com.whx.qzznnb.play.service.Play_Question_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service("play_Question_Service")
public  class Play_Question_ServiceImp implements Play_Question_Service {

    @Autowired
    Play_QuestionMapper play_questionMapper;
    @Autowired
    Play_AnswerMapper play_answerMapper;
    @Autowired
    Play_CommentMapper play_commentMapper;
    /**
     * 保存文章
     * @param play_question
     * @return
     */
    @Override
    public int save_Play_Question(Play_Question play_question) {
     return    play_questionMapper.save_Play_Question(play_question);
    }

    @Override
    public HashMap<String, Object> select_Play_QueAnsCom_Byid(String qid) {

        HashMap<String, Object> resHashMap = new HashMap<>(); //最终的返回值

        Play_Question play_question = play_questionMapper.selcet_Play_Question(qid);

        Play_Question_Entity play_questionOut = new Play_Question_Entity(play_question);

        resHashMap.put("question",play_questionOut);

        //一级评论集合 qid
        List<Play_Comment> comment_onelist= play_commentMapper.selcet_One_Comment(qid);
        List<Play_Comment_Out_One> comment_one_outlist = DataChangeUtil.listPlay_Comment_Out_One(comment_onelist);

        //二级评论集合 qid
        //遍历一级评论得到一级评论的id集合
        List commentid_list = new ArrayList();
        for (int x = 0; x < comment_onelist.size(); x++) {
            commentid_list.add(comment_onelist.get(x).getComment_id());
        }
        List<Play_Comment> comment_twolist=play_commentMapper.select_two_commentbyList(commentid_list);
        List<Play_Comment_Out_Two> comment_two_outlist = DataChangeUtil.listPlay_Comment_Out_Two(comment_twolist);

        //答案的集合 qid
        List<Play_Answer> answerlist = play_answerMapper.select_play_answer(qid);
        List<Play_Answer_out> answer_outlist = DataChangeUtil.listPlay_Answer_Out(answerlist);

        List<Ans_Com_Entity> ansList = new ArrayList<>();
        //对于回答下的  一级评论集合   和二级评论
        for (int i = 0; i < answer_outlist.size(); i++) {

            Ans_Com_Entity ans_com_entity = new Ans_Com_Entity();

            List<Play_Comment_Out_Two> resTwo = new ArrayList<Play_Comment_Out_Two>();
            Play_Answer_out play_answer = answer_outlist.get(i);
            String  anid =  play_answer.getAnid();

            ans_com_entity.setAn(play_answer);
            List<Play_Comment_Out_One> resOne = new ArrayList<Play_Comment_Out_One>();
            for (int j = 0; j <comment_one_outlist.size(); j++) {
                Play_Comment_Out_One play_comment_out_one = comment_one_outlist.get(j);
               if(play_comment_out_one.getAnid().equals(anid)){
                   resOne.add(play_comment_out_one);
                }
            }
            ans_com_entity.setPlay_comment_onelist(resOne);

            for (int k = 0; k < comment_two_outlist.size(); k++) {
                Play_Comment_Out_Two play_comment_out_two =comment_two_outlist.get(k);
                if(play_comment_out_two.getAnid().equals(anid)){
                       resTwo.add(play_comment_out_two);
                }
            }
            ans_com_entity.setPlay_comment_twolist(resTwo);
            ansList.add(ans_com_entity);
        }

        resHashMap.put("answer",ansList);
        return resHashMap;
    }

    @Override
    public List<Topic> select_Play_AllTopic() {
        return play_questionMapper.select_Play_AllTopic();

    }

    @Override
    public  List< HashMap<String,Object> > select_Play_QueAns_Feed(int page,int counts) {
         ArticleEntity articleEntity;
        List< HashMap<String,Object> > reslist = new ArrayList<>();
         int  pagesize =(page-1)* counts;
        Play_Answer play_answer=null;
        Play_Question play_question=null;
        List<Play_Question> questionlist = play_questionMapper.select_Play_FeedQuestion(pagesize, counts);

        for (int i = 0; i < questionlist.size(); i++) {
            HashMap<String,Object> resmap = new HashMap<>();
            play_question = questionlist.get(i);
            resmap.put("feed_style",play_question.getFeed_style());
              play_answer = play_questionMapper.select_Play_FeedQueAns(play_question.getQid());
              if(play_answer == null || "".equals(play_answer.getAnid())){
                  //回答是null的暂时这么处理
                  resmap.put("question",new Play_Question_Entity(play_question));
                  resmap.put("answer",null);
                  continue;
              }
              resmap.put("question",new Play_Question_Entity(play_question));
              resmap.put("answer",new Play_Answer_out(play_answer));
              reslist.add(resmap);
        }

        return reslist;
    }

    @Override
    public  List select_que_byuid(String uid) {
        List rselist = new ArrayList();
        List<Play_Question> list =play_questionMapper.select_que_byuid(uid);
        List<Play_Question_Entity> play_quelist = DataChangeUtil.listPlay_Question_Out(list);
        HashMap<String,Object> rehash =null;
        for (int i = 0; i < play_quelist.size(); i++) {
            rehash =new HashMap<>();
            rehash.put("feed_style", list.get(i).getFeed_style());
            rehash.put("question",play_quelist.get(i));
            rselist.add(rehash);
        }

        return rselist;
    }

    @Override
    public int select_Question_counts() {
        return play_questionMapper.select_Question_counts();
    }

}
