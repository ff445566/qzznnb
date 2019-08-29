package com.whx.qzznnb.mapper;

import com.whx.qzznnb.entity.ArticleEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
    List<ArticleEntity> selectAll();//查询所有文章
    List<ArticleEntity> feedSelect(); //feed  页面
    ArticleEntity selectBy(@Param("aid") String aid,@Param("title") String title); //


}
