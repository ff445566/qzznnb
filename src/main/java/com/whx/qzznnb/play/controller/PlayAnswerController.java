package com.whx.qzznnb.play.controller;

import com.whx.qzznnb.common.*;
import com.whx.qzznnb.entity.LikeIn;
import com.whx.qzznnb.play.entity.Play_Answer;
import com.whx.qzznnb.play.entity.Play_Answer_In;
import com.whx.qzznnb.play.entity.Play_Answer_out;
import com.whx.qzznnb.play.service.Play_Answer_Service;
import com.whx.qzznnb.play.service.Play_Question_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @ClassName AccArtController
 * @Description TODO
 * @Date 2019/10/31 13:25
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("play")
public class PlayAnswerController {
    /**
     * 该模块下处理  发文模块
     */
    @Autowired
    private Play_Question_Service play_question_service;

    @Autowired
    private Play_Answer_Service play_answer_service;



    /**
     *
     * /**
     * 保存答案
     *
     * @param play_answer_in
     * @return
     */
    @RequestMapping("/save_answer")
    public ServeResponse<String> saveAnswer(@RequestBody Play_Answer_In play_answer_in) {

        Date maketime = TimeUtil.getNowTime();
        String qid = UuidUtil.getUuid();
        int result = 0;
        try {
            result = play_answer_service.save_Play_Answer(new Play_Answer(play_answer_in, maketime, qid));

            if (result != 0) {
                return ServeResponse.createBySuccess("保存成功");
            } else return ServeResponse.createByErrorMessage("保存失败");

        } catch (Exception e) {
            e.printStackTrace();
            return ServeResponse.createByErrorCodeMessage(ResponseCode.ERRORDATABASE.getCode(),ResponseCode.ERRORDATABASE.getDesc());
        }

    }
    @RequestMapping("/like_answer")
    public  ServeResponse<String> likeAnswer(@RequestBody LikeIn likeIn) {

        //  存redis   具体的点赞行为
        TimeUtil.getNowTime();
        RedisUtil  redisUtil = new RedisUtil();
        redisUtil.hHasKey_like(likeIn);

        // 定时刷新

        // 分为两种 统计点赞的数量\
        //  谁给谁点的赞
        //文章id + set集合（点赞的用户） 定时刷到总量
        Date maketime = TimeUtil.getNowTime();
        String qid = UuidUtil.getUuid();
        int result = 0;
        try {

            if (result != 0) {
                return ServeResponse.createBySuccess("保存成功");
            } else return ServeResponse.createByErrorMessage("保存失败");

        } catch (Exception e) {
            e.printStackTrace();
            return ServeResponse.createByErrorCodeMessage(ResponseCode.ERRORDATABASE.getCode(),ResponseCode.ERRORDATABASE.getDesc());
        }

    }

    /**
     * 根据问题查看下面的答案  目前就是全部传过去
     * 查看所有的问题 以及问题下的评论 以及 部分二级评论
     * @param qid
     * @return
     */
    @RequestMapping("/select_answer")
     public  ServeResponse<List<Play_Answer_out>> selectAnswer(String qid){


         if(qid.equals("")||qid ==null){
             return ServeResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
         }

         try {
             List<Play_Answer> list = play_answer_service.select_play_answer(qid);
             if (list.size() == 0) {
                 return ServeResponse.createBySuccessCodeMessage(ResponseCode.RESULTNULL.getCode(), "数据库中数据为null");
             }
             List<Play_Answer_out> reslist = DataChangeUtil.listPlay_Answer_Out(list);
             return ServeResponse.createBySuccess("数据查询成功",reslist);
         } catch (Exception e) {
             e.printStackTrace();
             return  ServeResponse.createByErrorCodeMessage(ResponseCode.ERRORDATABASE.getCode(),ResponseCode.ERRORDATABASE.getDesc());
         }

     }


}