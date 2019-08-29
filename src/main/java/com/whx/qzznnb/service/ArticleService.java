package com.whx.qzznnb.service;

import com.whx.qzznnb.entity.ArticleEntity;

import java.util.List;


public interface ArticleService {

    public List<ArticleEntity> selectAll();
 //   public List<ArticleEntity> selectArticleByTitle(String title) ;
    public List<ArticleEntity> feedSelect();
    public  ArticleEntity  selectArticleByAid(String aid) ;


}
