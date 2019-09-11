package com.whx.qzznnb.common;

import com.whx.qzznnb.entity.ArticleCan;
import com.whx.qzznnb.entity.ArticleEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DataChange
 * @Description TODO
 * @Date 2019/9/9 17:04
 * @Version 1.0.0
 **/
public class DataChangeUtil {
    public static  List<ArticleCan> listArticle(List<ArticleEntity> entityList){
        List<ArticleCan> listArticleCan = new ArrayList<ArticleCan>();

        for (int i = 0; i < entityList.size(); i++) {
            ArticleCan article =new ArticleCan();
            article.setAll(entityList.get(i));
            listArticleCan.add(article);
        }
        return listArticleCan;

    }
}
