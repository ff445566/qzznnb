package com.whx.qzznnb.controller;

import com.whx.qzznnb.common.DataChangeUtil;
import com.whx.qzznnb.common.ServeResponse;
import com.whx.qzznnb.common.TimeUtil;
import com.whx.qzznnb.common.UuidUtil;
import com.whx.qzznnb.entity.ArticleCan;
import com.whx.qzznnb.entity.ArticleEntity;
import com.whx.qzznnb.entity.ArticleIn;
import com.whx.qzznnb.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("art")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * feed 页面查询  查询精华文章
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

            ArticleCan articleCan =  new ArticleCan.Builder(articleEntity).builder();
            return  ServeResponse.createBySuccess("查询成功",articleCan);
        }
        else
            return ServeResponse.createByErrorMessage("查询失败 gg了");
    }
    /**
     * 保存文章
     */

    @RequestMapping("/save")
    public ServeResponse<String>  saveArticle(@RequestBody ArticleIn articleIn){
        Date maketime = TimeUtil.getNowTime();
        String aid =UuidUtil.getUuid();
       int result=0;
        try {
            result =articleService.saveArticle(new ArticleEntity(articleIn,maketime,aid));
            result =articleService.saveArticle(new ArticleEntity(articleIn,maketime,aid));
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
