package com.whx.qzznnb.plan.service;

import com.whx.qzznnb.entity.Plan;
import com.whx.qzznnb.plan.entity.Plan_today_in;
import com.whx.qzznnb.plan.entity.Plan_today_out;

import java.util.List;


public interface PlanService {

    public List< List<Plan>>   selectPlan(); // 查询制定的整个计划卡片
    public  int  up_plan(Plan plan); //上传单条计划
    public int save_plan(List<Plan_today_in> planlist);
    public  List<Plan_today_out> selct_all_today_Plan(); // 展现所有的今日计划

}
