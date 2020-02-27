package com.whx.qzznnb.access.mapper;

import com.whx.qzznnb.entity.ArticleEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 此mapper  主要是服务与后台文章的管理
 *
 */
@Repository
public interface Acc_ArticleMapper {


    ArticleEntity selectBy(@Param("aid") String aid); //根据 文章id查询
    int saveArticle(ArticleEntity articleEntity);// 保存 精华 文章
    int delete_aid(String aid); // 根据aid 删除文章
    int delete_aid_list(List list);//批量 ——根据aid 删除文章

     //  查看待审核文章
      List<ArticleEntity> selectAll_status();
    //  审核文章     审核通过/不通过

    int update_status(String status,String aid);
    int update_status_list(String status,List staus_list);

    // 查询文章的审核状态





}
