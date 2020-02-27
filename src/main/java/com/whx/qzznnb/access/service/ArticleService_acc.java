package com.whx.qzznnb.access.service;

import com.whx.qzznnb.entity.ArticleEntity;

import java.util.List;


public interface ArticleService_acc {

    public  int saveArticle(ArticleEntity articleEntity);
     public  int delete_aid(String aid);
     public  int delete_aid_list(List<String> list);
     // 查看待审核文章
     public List<ArticleEntity> selectAll_status();

    public int update_status(String status,String aid);
    public int update_status_list(String status,List staus_list);


}
