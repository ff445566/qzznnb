package com.whx.qzznnb.mapper;

import com.whx.qzznnb.entity.ArticleEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {

    List<ArticleEntity> selectAll();//查询所有文章

    List<ArticleEntity> feedSelect(); //feed页面

    ArticleEntity selectBy(@Param("aid") String aid); //根据 文章id查询

    List<ArticleEntity> selectByUid(String uid);//查询我的文章

    int saveArticle(ArticleEntity articleEntity);// 保存文章

}
