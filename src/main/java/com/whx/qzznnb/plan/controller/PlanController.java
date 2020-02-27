package com.whx.qzznnb.plan.controller;

import com.whx.qzznnb.common.ResponseCode;
import com.whx.qzznnb.common.ServeResponse;
import com.whx.qzznnb.common.UuidUtil;
import com.whx.qzznnb.entity.Plan;
import com.whx.qzznnb.plan.entity.Plan_today_in;
import com.whx.qzznnb.plan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName PlanController
 * @Description TODO   该类主要为计划模块 提供接口
 * @Date 2019/10/17 15:44
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("plan")
public class PlanController {

    
    @Autowired
    private PlanService planService;
    /**
     * @Description  查询自己的数据, 计划组
     *
     */
    @RequestMapping(value = "/select_plan",method =RequestMethod.GET)
    public ServeResponse<List<List<Plan>>> myPlan(){

        try {
            List<List<Plan>> res_list = planService.selectPlan();
            if(res_list.size()!=0){
                return  ServeResponse.createBySuccess("计划数据成功返回",res_list);
            }
            else {
                return  ServeResponse.createByErrorMessage("查询数据为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  ServeResponse.createByErrorMessage("返回计划数据异常");
        }

    }

    /**
     *
     * @param module_id 模块id
     * @param module_name  模块名称
     * @param uid 用户id
     * @param content 内容
     * @param factor 具体的描述
     * @return
     */

    @RequestMapping(value ="/up_plan")
    public  ServeResponse<String> up_plan(String module_id,String module_name,
                                     String uid,String content,String factor){
      String  plan_id= UuidUtil.getUuid();
      Plan plan_entity = new Plan(plan_id,uid,module_id,module_name,content,factor);
    try {

        int res = planService.up_plan(plan_entity);
        if (res != 0) {
            return ServeResponse.createBySuccessMessage("插入成功");
        } else
            return ServeResponse.createByErrorMessage("数据库插入失败");
    }catch (Exception e){
        e.printStackTrace();
        return  ServeResponse.createByErrorMessage("插入失败，出现异常");
    }
    }

    //保存今日我的计划
    @RequestMapping(value ="/save_today_plan")
    public  ServeResponse<String> save_plan( List<Plan_today_in> planList){
        try {

            int res =planService.save_plan(planList);
            if (res != 0) {
                return ServeResponse.createBySuccessMessage("数据库更新成功");
            } else
                return ServeResponse.createByErrorCodeMessage(ResponseCode.ERRORUPDATEDATABASE.getCode(),ResponseCode.ERRORUPDATEDATABASE.getDesc());
        }catch (Exception e){
            e.printStackTrace();
            return  ServeResponse.createByErrorMessage("插入失败，出现异常");
        }

    }

    // 展示所有的今日计划
    // sql语句查询 排序

   public  ServeResponse<String> select_todayPlan(){

        return null;
   }
    // 展示我的完成情况
    }
