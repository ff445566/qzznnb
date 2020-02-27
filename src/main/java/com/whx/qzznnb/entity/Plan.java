package com.whx.qzznnb.entity;

/**
 * @ClassName Plan
 * @Description TODO
 * @Date 2019/10/17 15:54
 * @Version 1.0.0
 **/
public class Plan {

    private  String uid; // 用户 id
    private  String module_id; // 模块id
    private  String module_name; // 模块名称  例 数量 行测，判断
    private  String list_style; //  来源系统 0 ，用户为1
    private  String content;  // 具体的内容
    private  String factor;  // 内容的具体规定，进一步描述
    private  String id;

  public  Plan(){}
  public Plan(String id,String uid,String module_id,String module_name,String content,String factor){
      //唯一id
      this.id =id;
      this.uid =uid;
      this.module_id=module_id;
      this.module_name=module_name;
      this.content=content;
      this.factor=factor;
      this.list_style="1";// 来自用户端的

  }

    public String getList_style() {
        return list_style;
    }

    public void setList_style(String list_style) {
        this.list_style = list_style;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getModule_id() {
        return module_id;
    }

    public void setModule_id(String module_id) {
        this.module_id = module_id;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

