package com.whx.qzznnb.controller;

import com.whx.qzznnb.common.ServeResponse;
import com.whx.qzznnb.entity.ArticleEntity;
import com.whx.qzznnb.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("art")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 查询所有的文章
     *
     * @return
     */
    @GetMapping("/selectAll")
    public List<ArticleEntity> selectAll() {
        // 查询所有的
        return articleService.selectAll();
    }

//    /**
//     * 查询 文章根据标题
//     *
//     * @param title
//     * @return
//     */
//    @GetMapping("articleSelectByTitle/{title}")
//    public List<ArticleEntity> selectByTitle(@PathVariable String title) {
//        return articleService.selectArticleByTitle(title);
//    }

    /**
     * feed 页面查询
     * @return
     */
    @RequestMapping("/selectFeed")
    public   ServeResponse<List<ArticleEntity>> feedSelect(){
        List<ArticleEntity> artlist =articleService.feedSelect();
        if(artlist.size()==0){
            return ServeResponse.createByErrorMessage("传输失败");
        }
        return  ServeResponse.createBySuccess("成功",articleService.feedSelect());

    }
    /**
     * 查询某一篇文章 根据文章id
     */
  @RequestMapping("/selectByAid/{aid}")
    public  ServeResponse<ArticleEntity> selectByAid(@RequestParam String aid){
        ArticleEntity articleEntity =articleService.selectArticleByAid(aid);
        if(articleEntity != null)
        return  ServeResponse.createBySuccess(articleEntity);
        else
            return ServeResponse.createByErrorMessage("查询失败 gg了");
    }

}
