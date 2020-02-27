package com.whx.qzznnb.mapper;

import com.whx.qzznnb.entity.Plan;
import com.whx.qzznnb.plan.entity.Plan_today_out;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface PlanMapper {


   List <Plan> selectPlan();
   int up_plan_s(@Param("list") List<Plan> list);//插入多条计划
   int up_plan(Plan plan); // 插入单条计划
   int delete_today_plan(List list, Date updatetime); //执行删除计划
   int update_today(@Param("update_time") Date updatetime, @Param("list")ArrayList list);
   int save_today(@Param("list")ArrayList list);
   ArrayList<Plan_today_out> select_all_today_Plan(); //展示今日计划
}
