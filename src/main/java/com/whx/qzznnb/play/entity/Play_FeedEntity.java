package com.whx.qzznnb.play.entity;

/**
 * @ClassName Play_FeedEntity
 * @Description TODO
 * @Date 2019/11/17 15:48
 * @Version 1.0.0
 **/
public class Play_FeedEntity {

    private String feed_style;
    private Play_Question_Entity question;
    private  Play_Answer_out answer;

    public String getFeed_style() {
        return feed_style;
    }

    public void setFeed_style(String feed_style) {
        this.feed_style = feed_style;
    }

    public Play_Question_Entity getQuestion() {
        return question;
    }

    public void setQuestion(Play_Question_Entity question) {
        this.question = question;
    }

    public Play_Answer_out getAnswer() {
        return answer;
    }

    public void setAnswer(Play_Answer_out answer) {
        this.answer = answer;
    }
}
