package com.whx.qzznnb.plan.entity;

/**
 * @ClassName plan_today_in
 * @Description TODO
 * @Date 2019/12/10 10:57
 * @Version 1.0.0
 **/
public class Plan_today_in {

    private  String uid;        //  用户uid
    private  String plan_content; // 计划的具体的内容
    private  String plan_type; //  计划的类别 言语理解
    private  String plan_id; // 同一个计划下的id 相同
    private  String plan_status; // 计划状态是 新建还是修改或者删除 012


    // 后台需要自己生成的
    private String  id;// 唯一性id
    private String create_time; // 创建时间
    private String  update_time; // 修改时间

    public String getPlan_status() {
        return plan_status;
    }

    public void setPlan_status(String plan_status) {
        this.plan_status = plan_status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPlan_content() {
        return plan_content;
    }

    public void setPlan_content(String plan_content) {
        this.plan_content = plan_content;
    }

    public String getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(String plan_type) {
        this.plan_type = plan_type;
    }

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }
   public Plan_today_in(){}

}
