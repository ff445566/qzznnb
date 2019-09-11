package com.whx.qzznnb.service;

import com.whx.qzznnb.entity.ArticleEntity;

import java.util.List;


public interface ArticleService {

    public List<ArticleEntity> selectAll();
    public List<ArticleEntity> selectArticleByUid(String uid) ;
    public List<ArticleEntity> feedSelect();
    public  ArticleEntity  selectArticleByAid(String aid) ;
    public  int saveArticle(ArticleEntity articleEntity);


}
