package com.whx.qzznnb.play.controller;

import com.whx.qzznnb.common.ResponseCode;
import com.whx.qzznnb.common.ServeResponse;
import com.whx.qzznnb.common.TimeUtil;
import com.whx.qzznnb.common.UuidUtil;
import com.whx.qzznnb.play.entity.Play_Question;
import com.whx.qzznnb.play.entity.Play_Question_Entity;
import com.whx.qzznnb.play.service.Play_Question_Service;
import com.whx.qzznnb.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.Topic;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName AccArtController
 * @Description TODO
 * @Date 2019/10/31 13:25
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("play")
public class PlayController {
    /**
     * 该模块下处理  发文模块
     */
    @Autowired
    private Play_Question_Service play_question_service;
    @Autowired
    private ArticleService articleService;


    /**
     * -------------------------问题相关模块---------------------
     * /**
     * 保存问题
     * 其中  注意  目前对type得处理时默认只有一个值 数据库存的时type_id
     */
    @RequestMapping("/save_question")
    public ServeResponse<String> saveQuestion(@RequestBody Play_Question_Entity play_question_entity) {

        Date maketime = TimeUtil.getNowTime();
        String qid = UuidUtil.getUuid();
        int result = 0;
        try {
            result = play_question_service.save_Play_Question(new Play_Question(play_question_entity, maketime, qid));

            if (result != 0) {
                return ServeResponse.createBySuccess("保存成功");
            } else return ServeResponse.createByErrorMessage("保存失败");

        } catch (Exception e) {
            e.printStackTrace();
            return ServeResponse.createByErrorCodeMessage(ResponseCode.ERRORDATABASE.getCode(), ResponseCode.ERRORDATABASE.getDesc());
        }

    }


    /**
     *
     */
    /**
     * 根据问题id，返回答案，一级评论，二级评论
     *
     * @param qid
     * @returnselect_main_feed
     */
    @RequestMapping("/select_question_info")
    public ServeResponse<HashMap> selcetByQid(String qid) {

        HashMap<String, Object> resMap = null;
        try {
            resMap = play_question_service.select_Play_QueAnsCom_Byid(qid);
        } catch (Exception e) {
            e.printStackTrace();
            return ServeResponse.createByErrorCodeMessage(ResponseCode.ERRORDATABASE.getCode(), ResponseCode.ERRORDATABASE.getDesc());
        }
        if (resMap != null && resMap.size() != 0) {
            return ServeResponse.createBySuccess(resMap);
        } else
            return ServeResponse.createBySuccessCodeMessage(ResponseCode.RESULTNULL.getCode(), ResponseCode.RESULTNULL.getDesc());

    }

    /**  分页查询展示
     * @param page
     * @param counts
     * @return
     */
    @RequestMapping("/select_main_feed")
    public ServeResponse<List> selcetMainFeed(int page, int counts) {
        List reslist = new ArrayList();
        try {
          //第一个
            // 几种情况，
            //  1.  各一半  没问题
            //  2.  第一个不足了，让第二个补  还是从原先页读取 数量变
            //  3.  第个直接没有了，只能让第二个上 ==0 说明直接没有了，直接从第 （n-1） *4+1+counts开始读取；
            // 分页查询 第一个8 1-4,5-8，9-10；
            //第二个 1-4,5-8，9-15 16-（）
            // （n-1） *4+1

            // 问题答案页面
            List<HashMap<String, Object>> quelist = play_question_service.select_Play_QueAns_Feed(page, counts / 2);
             //查询总的数量
            int artAll=play_question_service.select_Question_counts();

            for (int i = 0; i < quelist.size(); i++) {
                reslist.add(quelist.get(i));
            }
            //int artCount = (counts - quelist.size());
            // 文章页面
            List<HashMap<String, Object>> artlist = articleService.feedSelect_Main(page, quelist.size(),counts,artAll);

            for (int i = 0; i < artlist.size(); i++) {
                reslist.add(artlist.get(i));
            }
            // 说明没有数据了
            HashMap<String, String> data_status = new HashMap<>();

            if ((artlist.size() + reslist.size()) < counts) {
                data_status.put("data_status", "false"); //1表示没有数据了，最后一页了， 0标识还有
                reslist.add(data_status);
            } else {
                data_status.put("data_status", "true"); //  0标识还有数据
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ServeResponse.createByErrorCodeMessage(ResponseCode.ERRORDATABASE.getCode(), ResponseCode.ERRORDATABASE.getDesc());
        }
        if (reslist != null && reslist.size() != 0) {
            return ServeResponse.createBySuccess(reslist);
        } else
            return ServeResponse.createBySuccessCodeMessage(ResponseCode.RESULTNULL.getCode(), ResponseCode.RESULTNULL.getDesc());


    }

    /**
     * 查询话题内容
     */
    @RequestMapping("/select_topic")
    public ServeResponse<List<Topic>> selectAllTopic() {

        List<Topic> listTopic = null;
        try {
            listTopic = play_question_service.select_Play_AllTopic();
        } catch (Exception e) {
            e.printStackTrace();
            return ServeResponse.createByErrorCodeMessage(ResponseCode.ERRORDATABASE.getCode(), ResponseCode.ERRORDATABASE.getDesc());
        }
        if (listTopic != null && listTopic.size() != 0) {
            return ServeResponse.createBySuccess(listTopic);
        } else
            return ServeResponse.createBySuccessCodeMessage(ResponseCode.RESULTNULL.getCode(), ResponseCode.RESULTNULL.getDesc());

    }


    /***********************通知模块************************/
    @RequestMapping("/select_notify")
    public ServeResponse<List<Topic>> selectMyNotify(String  uid ) {

        List<Topic> listTopic = null;
        try {
            listTopic = play_question_service.select_Play_AllTopic();
        } catch (Exception e) {
            e.printStackTrace();
            return ServeResponse.createByErrorCodeMessage(ResponseCode.ERRORDATABASE.getCode(), ResponseCode.ERRORDATABASE.getDesc());
        }
        if (listTopic != null && listTopic.size() != 0) {
            return ServeResponse.createBySuccess(listTopic);
        } else
            return ServeResponse.createBySuccessCodeMessage(ResponseCode.RESULTNULL.getCode(), ResponseCode.RESULTNULL.getDesc());

    }


}
