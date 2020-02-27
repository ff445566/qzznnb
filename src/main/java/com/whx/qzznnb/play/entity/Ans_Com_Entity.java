package com.whx.qzznnb.play.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Ans_Com_Entity  查询问题详情的实体类
 * @Description TODO
 * @Date 2019/11/15 9:23
 * @Version 1.0.0
 **/
public class Ans_Com_Entity {

    private  Play_Answer_out an ;
    private List<Play_Comment_Out_One> play_comment_onelist = new ArrayList<>();
    private  List<Play_Comment_Out_Two> play_comment_twolist =new ArrayList<>();

    public List<Play_Comment_Out_One> getPlay_comment_onelist() {
        return play_comment_onelist;
    }

    public void setPlay_comment_onelist(List<Play_Comment_Out_One> play_comment_onelist) {
        this.play_comment_onelist = play_comment_onelist;
    }

    public List<Play_Comment_Out_Two> getPlay_comment_twolist() {
        return play_comment_twolist;
    }

    public void setPlay_comment_twolist(List<Play_Comment_Out_Two> play_comment_twolist) {
        this.play_comment_twolist = play_comment_twolist;
    }

    public Play_Answer_out getAn() {
        return an;
    }

    public void setAn(Play_Answer_out an) {
        this.an = an;
    }





}
