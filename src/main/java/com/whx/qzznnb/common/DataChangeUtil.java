package com.whx.qzznnb.common;

import com.whx.qzznnb.entity.ArticleCan;
import com.whx.qzznnb.entity.ArticleEntity;
import com.whx.qzznnb.entity.ArticleFeed;
import com.whx.qzznnb.play.entity.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DataChange
 * @Description TODO
 * @Date 2019/9/9 17:04
 * @Version 1.0.0
 **/
public class DataChangeUtil {
    /**
     * 文章出参时候的转换
     * @param entityList
     * @return
     */
    public static  List<ArticleCan> listArticle(List<ArticleEntity> entityList){
        List<ArticleCan> listArticleCan = new ArrayList<ArticleCan>();

        for (int i = 0; i < entityList.size(); i++) {
            ArticleCan article =new ArticleCan.
                    Builder(entityList.get(i)).builder();
            listArticleCan.add(article);
        }
        return listArticleCan;
    }
    //ArticleEntity
    /**
     * 文章出参时候的转换
     * @param entityList
     * @return
     */
    public static  List<ArticleFeed> listArticle_feed(List<ArticleEntity> entityList){
        List<ArticleFeed> listfeed = new ArrayList<ArticleFeed>();

        for (int i = 0; i < entityList.size(); i++) {
            ArticleFeed article =new ArticleFeed(entityList.get(i));
            listfeed.add(article);
        }
        return listfeed;
    }

    /**
     * 论坛 评论出参覆盖  一级评论
     * @param play_commentList
     * @return
     */
    public static  List<Play_Comment_Out_One> listPlay_Comment_Out_One(List<Play_Comment> play_commentList){
        List<Play_Comment_Out_One> play_comment_out_oneList = new ArrayList<Play_Comment_Out_One>();
        Play_Comment_Out_One play_comment_out_one=null;
        for (int i = 0; i < play_commentList.size(); i++) {
             play_comment_out_one =new Play_Comment_Out_One(play_commentList.get(i));
                     play_comment_out_oneList.add(play_comment_out_one);
        }
        return play_comment_out_oneList;
    }

    /**
     * 论坛 评论出参覆盖 二级评论
     * @param play_commentList
     * @return
     */
    public static  List<Play_Comment_Out_Two> listPlay_Comment_Out_Two(List<Play_Comment> play_commentList){
        List<Play_Comment_Out_Two> play_comment_out_twoList = new ArrayList<Play_Comment_Out_Two>();
        Play_Comment_Out_Two play_comment_out_two=null;
        for (int i = 0; i < play_commentList.size(); i++) {
            play_comment_out_two =new Play_Comment_Out_Two(play_commentList.get(i));
            play_comment_out_twoList.add(play_comment_out_two);
        }
        return play_comment_out_twoList;
    }

    /**
     *
     * @param play_answerList
     * @return 回答出参
     */
    public static  List<Play_Answer_out> listPlay_Answer_Out(List<Play_Answer> play_answerList){
         List<Play_Answer_out> play_answer_inList = new ArrayList<>();
        Play_Answer_out play_comment;
        for (int i = 0; i < play_answerList.size(); i++) {
            play_comment =new Play_Answer_out(play_answerList.get(i));
            play_answer_inList.add(play_comment);
        }
return play_answer_inList;
    }

    /**
     * 出参的时候使用question
     * @param play_questionList
     * @return
     */
    public  static  List<Play_Question_Entity> listPlay_Question_Out(List<Play_Question> play_questionList){
        List<Play_Question_Entity> play_answer_inList = new ArrayList<>();
        Play_Question_Entity Play_Question_Entity;
        for (int i = 0; i < play_questionList.size(); i++) {
            Play_Question_Entity =new Play_Question_Entity(play_questionList.get(i));
            play_answer_inList.add(Play_Question_Entity);
        }
        return play_answer_inList;
    }

}
