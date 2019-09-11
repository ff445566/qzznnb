package com.whx.qzznnb.controller;

import com.whx.qzznnb.common.DataChangeUtil;
import com.whx.qzznnb.common.ServeResponse;
import com.whx.qzznnb.entity.ArticleCan;
import com.whx.qzznnb.entity.ArticleEntity;
import com.whx.qzznnb.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("art")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * feed 页面查询
     * @return
     */
    @RequestMapping("/select_feed")
    public   ServeResponse<List<ArticleCan>> feedSelect(){
        List<ArticleEntity> artlist =articleService.feedSelect();
        if(artlist.size()==0){
            return ServeResponse.createByErrorMessage("传输失败");
        }
        List<ArticleCan> canList =DataChangeUtil.listArticle(artlist);
        return  ServeResponse.createBySuccess("成功",canList);

    }
    /**
     * 查询某一篇文章 根据文章id
     */
  @RequestMapping("/select_by_aid")
    public  ServeResponse<ArticleCan> selectByAid(@RequestParam String aid){
        ArticleEntity articleEntity =articleService.selectArticleByAid(aid);
        if(articleEntity != null){
            ArticleCan articleCan = new ArticleCan(articleEntity);
            return  ServeResponse.createBySuccess("查询成功",articleCan);
        }
        else
            return ServeResponse.createByErrorMessage("查询失败 gg了");
    }
    /**
     * 保存文章
     */
    //{"aid":"1","user_info":{"uid":"1","user_name":"whx"},"title":"相信自己","content":"  ","make_time":"2019-08-20T22:18:13.000+0000",
    //                                             "type":[
    //											 {"type_name":"行测","type_id":"A000"},{"type_name":"申论","type_id":"B000"}
    //											         ],
    //								"list_style":"1"},{},{}
    //		  ] {user_info":{"uid":"1","user_name":"whx"},
    //"type":[
    //{"type_name":"行测","type_id":"A000"},{"type_name":"申论","type_id":"B000"}
    //],
    //"title":"相信自己","content":" ","list_style":"1"}
    //}
    @RequestMapping("/save")
    public  ServeResponse<String> saveArticle( List<HashMap<String ,String >> type,HashMap<String,String> user_info,String title,String content,String list_style){
    //public  ServeResponse<String> saveArticle(@RequestBody ){
//            articleCan.setmake_time(TimeUtil.getNowTime());
//        articleCan.setAid(UuidUtil.getUuid());
        int result=0;
        try {
            //result =articleService.saveArticle(new ArticleEntity(articleCan));
            if(result!=0){
                return  ServeResponse.createBySuccess("保存成功");
            }
            else return  ServeResponse.createByErrorMessage("保存失败");

        } catch (Exception e) {
            e.printStackTrace();
           return ServeResponse.createByErrorMessage("保存异常，请检查参数");
        }

    }

}
