package com.whx.qzznnb.play.controller;

import com.whx.qzznnb.common.*;
import com.whx.qzznnb.play.entity.Play_Comment;
import com.whx.qzznnb.play.entity.Play_Comment_In;
import com.whx.qzznnb.play.entity.Play_Comment_Out_One;
import com.whx.qzznnb.play.entity.Play_Comment_Out_Two;
import com.whx.qzznnb.play.service.Play_Comment_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class PlayCommentController {


    @Autowired
    private Play_Comment_Service play_comment_service;

    /**
     * -------------------------评论相关模块-----------------
     */
// 2.根据某个问题下 展现所有的一级评论 3.根据一级评评论id，展示该一级评论的下的所有评论 按照时间
// 需不需要带姓名 我往前端发的时候肯定是带着名字的，有两种思路 第一是联合数据库的用户表进行查询多表查询。  第二直接带着姓名和id不过第一种会不会消耗太大 每次的反馈都是查询
    @RequestMapping("/save_comment")
    public ServeResponse<String> saveComment(@RequestBody Play_Comment_In play_comment_in) {

        Date maketime = TimeUtil.getNowTime();
        String comment_id = UuidUtil.getUuid();
        int result = 0;
        try {
            result = play_comment_service.save_Play_Comment(new Play_Comment(play_comment_in, maketime, comment_id));

            if (result != 0) {
                return ServeResponse.createBySuccess("保存成功");
            } else return ServeResponse.createByErrorMessage("保存失败");

        } catch (Exception e) {
            e.printStackTrace();
            return  ServeResponse.createByErrorCodeMessage(ResponseCode.ERRORDATABASE.getCode(),ResponseCode.ERRORDATABASE.getDesc());
        }

    }

    /**
     * 查询 某一回答下的 评论 一级
     * @param anid
     * @return
     */
    @RequestMapping(value = "/select_one_comment" ,method = RequestMethod.POST)
    public ServeResponse<List<Play_Comment_Out_One>> slectOneComment(@RequestParam String anid) {
        if(anid.equals("")||anid ==null){
            return ServeResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        List<Play_Comment> list = null;
        try {
            list = play_comment_service.select_one_comment(anid);
            if (list.size() == 0) {
                return ServeResponse.createBySuccessCodeMessage(ResponseCode.RESULTNULL.getCode(), "数据库中数据为null");
            }
            List<Play_Comment_Out_One> reslist = DataChangeUtil.listPlay_Comment_Out_One(list);
            return ServeResponse.createBySuccess("数据查询成功",reslist);
        } catch (Exception e) {
            e.printStackTrace();
            return  ServeResponse.createByErrorCodeMessage(ResponseCode.ERRORDATABASE.getCode(),ResponseCode.ERRORDATABASE.getDesc());
        }


    }
    /**
     * 查询 某一评论下的相关评论
     * @param comment_id
     * @return
     */
    @RequestMapping("/select_two_comment")
    public ServeResponse<List<Play_Comment_Out_Two>> slectTwoComment(String comment_id) {
        List<Play_Comment> list=null;
        try {
              list = play_comment_service.select_two_comment(comment_id);

            if (list == null ||list.size() == 0) {
                return ServeResponse.createBySuccessCodeMessage(ResponseCode.RESULTNULL.getCode(), "数据库中数据为null");
            }
            List<Play_Comment_Out_Two> reslist = DataChangeUtil.listPlay_Comment_Out_Two(list);
            return ServeResponse.createBySuccess(reslist);
        } catch (Exception e) {
            e.printStackTrace();
            return  ServeResponse.createByErrorCodeMessage(ResponseCode.ERRORDATABASE.getCode(),ResponseCode.ERRORDATABASE.getDesc());
        }


    }
}