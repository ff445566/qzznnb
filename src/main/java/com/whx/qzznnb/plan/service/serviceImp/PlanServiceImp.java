package com.whx.qzznnb.plan.service.serviceImp;

import com.whx.qzznnb.common.TimeUtil;
import com.whx.qzznnb.common.UuidUtil;
import com.whx.qzznnb.entity.Plan;
import com.whx.qzznnb.mapper.PlanMapper;
import com.whx.qzznnb.plan.entity.Plan_today_in;
import com.whx.qzznnb.plan.entity.Plan_today_out;
import com.whx.qzznnb.plan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PlanServiceImp
 * @Description TODO
 * @Date 2019/10/17 16:25
 * @Version 1.0.0
 **/
@Service
public class PlanServiceImp implements PlanService {
    @Autowired
    private PlanMapper planMapper;

    /**
     *
     * @return 返回结果是 一个list 的list集合，
     * 里面的list存放的实体类（按照模块划分的）
     */
    @Override
    public  List<List<Plan>> selectPlan() {
        //  将module_id相同的放在一个list下面，目的是为了一个模块一个list的。
        List< List<Plan>> result = new ArrayList<List<Plan>>();// 返回的集合
        List<Plan> plan_list= planMapper.selectPlan(); // 数据库获取
        // 需要返回的内在集合
        List<Plan> Plan_list= new ArrayList<Plan>() ;
        String module_id= plan_list.get(0).getModule_id();
        Plan plan_for=null;
        Plan_list.add( plan_list.get(0));
        for (int i =1; i < plan_list.size(); i++) {
              plan_for =plan_list.get(i);
             if(module_id.equals(plan_for.getModule_id())){
                  Plan_list.add(plan_for);
             }else {
                 // new  一个新的集合
                 Plan_list = new ArrayList<Plan>();
                 Plan_list.add(plan_for);
                 module_id =plan_list.get(i).getModule_id();
                 result.add(Plan_list);
             }
        }
        return   result ;
    }

    @Override
    public int up_plan(Plan plan) {

       return planMapper.up_plan(plan);

    }

    @Override
    public int save_plan(List<Plan_today_in> planList) {
        ArrayList<Plan_today_in> plan_list = new ArrayList<>(); // ArrayList<String>  update_list = new ArrayList<>();
        ArrayList<String>  remove_list = new ArrayList<>();
        Plan_today_in plan_today;
        for (int i = 0; i < planList.size(); i++) {
            plan_today   = planList.get(i);
            if("0".equals(plan_today.getPlan_status())){ //如果是新加的plan_today.setId( TimeUtil.getTodayStamp()+UuidUtil.getUuid());
                plan_today.setId(TimeUtil.getTodayStamp()+UuidUtil.getUuid());
                plan_today.setCreate_time(TimeUtil.getTodayStamp()); // 获取时间
                // 一次性 更新多条
                plan_list.add(plan_today);
            }else if("1".equals(plan_today.getPlan_status())){ //修改（先删除原来的 在产生一条新的 )
                // 从数据库中查处相应的id
                // 将状态设置为1 标识这是个过时的，已经被修改了
                remove_list.add(plan_today.getId()); //根据id 删除原来的那条
                plan_today.setId(TimeUtil.getTodayStamp()+ UuidUtil.getUuid());
                plan_today.setCreate_time(TimeUtil.getTodayStamp());
                plan_list.add(plan_today);// 作为一条新的加入
            } else  if("2".equals(plan_today.getPlan_status())){ // 删除
                 remove_list.add(plan_today.getId());
            }
        }
             // 先执行删除操作  将Status 状态改为2
           if(remove_list.size() != 0){
               int re =planMapper.update_today(TimeUtil.getNowTime(),remove_list);
               if(re== 0) return 0;
                  // 批量插入
                 if(plan_list.size() != 0){
                    return  planMapper.save_today(plan_list);
                   }
                 return re;
           }else {
               if(plan_list.size() != 0){
                   return  planMapper.save_today(plan_list);
               }
           }
        return 0;
    }

    @Override
    public List<Plan_today_out> selct_all_today_Plan() {
        ArrayList<Plan_today_out> todayList = planMapper.select_all_today_Plan();
        ArrayList<Plan_today_out> today= new ArrayList<>();
        for (int i = 0; i < todayList.size(); i++) {
            Plan_today_out plan_out = todayList.get(i);

        }
        return null;
    }
}
