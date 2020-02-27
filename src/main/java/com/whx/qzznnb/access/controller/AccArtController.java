package com.whx.qzznnb.access.controller;

import com.whx.qzznnb.access.service.ArticleService_acc;
import com.whx.qzznnb.common.ServeResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**胡汉三 又他妈的回来了  回来了回来了
 * @ClassName AccArtController
 * @Description TODO
 * @Date 2019/10/31 13:25
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("acc")
public class AccArtController {
    /**
     * 该模块下的处理 都需要被监听， 即是只能通过页面进行访问，直接通过url就会被回退到登录页面
     * 或者说 必须是处于登录状态下+ 管理员 才可以进行操作
     */
    @Autowired
    private ArticleService_acc articleServiceAccImp;
    //  完成 删除文章 根据文章id
    //  冻结文章
    //  批量删除

    // 删除文章
    @RequestMapping( value = "/delete_aid" ,method = RequestMethod.POST)
    public ServeResponse<String> delete_by_aid(String aid,String uid ){
        if(aid ==null||"".equals(aid) ){
            return ServeResponse.createByErrorMessage("参数接收失败，重新发送");
        }
        // 用户的uid 必须是管理员 或者超级管理员 否则回退到初始化页面

         // 删除文章
        int res = articleServiceAccImp.delete_aid(aid);
        if(res == 0){
            return ServeResponse.createByErrorMessage("删除失败 请重新删除");
        }else
            return  ServeResponse.createBySuccessMessage("删除成功");
    }

    // 删除文章批量
    @RequestMapping( value = "/delete_aid_list" ,method = RequestMethod.POST)
    public ServeResponse<String> delete_by_aid_list(@RequestBody JSONObject aid_list ){
//        if(aid ==null||"".equals(aid) ){
//            return ServeResponse.createByErrorMessage("参数接收失败，重新发送");
//        }
        // 用户的uid 必须是管理员 或者超级管理员 否则回退到初始化页面


        JSONArray arr = aid_list.getJSONArray("list");
        ArrayList<String> resList = new ArrayList<String>();
        for (int i = 0; i < arr.size(); i++) {
             resList.add(arr.get(i).toString());
        }

        int res = articleServiceAccImp.delete_aid_list(resList);
        System.out.println(resList.toString());
        if(res == 0){
            return ServeResponse.createByErrorMessage("删除失败 请重新删除");
        }else
            return  ServeResponse.createBySuccessMessage("删除成功");
    }
    //  文章审核

    @RequestMapping( value = "/update_status" ,method = RequestMethod.POST)
    public ServeResponse<String> update_status(String status,String aid,String user){
        if(aid ==null||"".equals(aid) ){
            return ServeResponse.createByErrorMessage("参数接收失败，重新发送");
        }
        // 用户的uid 必须是管理员 或者超级管理员 否则回退到初始化页面

        // 删除文章
        int res = articleServiceAccImp.update_status(status,aid);
        if(res == 0){
            return ServeResponse.createByErrorMessage("修改状态失败 请重新审核");
        }else
            return  ServeResponse.createBySuccessMessage("审核成功");
    }

    // 删除文章批量
    @RequestMapping( value = "/update_status_list" ,method = RequestMethod.POST)
    public ServeResponse<String> update_status_list (@RequestBody JSONObject aid_list ){
//        if(aid ==null||"".equals(aid) ){
//            return ServeResponse.createByErrorMessage("参数接收失败，重新发送");
//        }
        // 用户的uid 必须是管理员 或者超级管理员 否则回退到初始化页面


        JSONArray arr = aid_list.getJSONArray("list");
        JSONArray arr_status=aid_list.getJSONArray("status");
        ArrayList<String> resList = new ArrayList<String>();
        for (int i = 0; i < arr.size(); i++) {
            resList.add(arr.get(i).toString());
        }
        String status = arr_status.get(0).toString();

        int res = articleServiceAccImp.update_status_list(status,resList);
        System.out.println(resList.toString());
        if(res == 0){
            return ServeResponse.createByErrorMessage("批量更新失败 请重新删除");
        }else
            return  ServeResponse.createBySuccessMessage("更新成功 "+res+"条文章状态被改变");
    }
}
