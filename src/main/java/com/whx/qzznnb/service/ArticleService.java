package com.whx.qzznnb.service;

import com.whx.qzznnb.entity.ArticleEntity;

import java.util.HashMap;
import java.util.List;


public interface ArticleService {

    public List<ArticleEntity> selectAll();
    public List<ArticleEntity> selectArticleByUid(String uid) ;
    public List<ArticleEntity> feedSelect();
    public List< HashMap<String ,Object>> feedSelect_Main(int page, int artCount,int fCount,int artAll);

    public  ArticleEntity  selectArticleByAid(String aid) ;
    public  int saveArticle(ArticleEntity articleEntity);


}
