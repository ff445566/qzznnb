package com.whx.qzznnb.service.serviceimp;

import com.whx.qzznnb.common.RedisUtil;
import com.whx.qzznnb.entity.ArticleEntity;
import com.whx.qzznnb.mapper.ArticleMapper;
import com.whx.qzznnb.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class ArticleServiceImp  implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private RedisUtil redisUtil;


    private Logger logs = LoggerFactory.getLogger(ArticleServiceImp.class);

    /**
     * 查询所有的文章
     *
     * @param
     * @return
     */
    public List<ArticleEntity> selectAll() {

        List<ArticleEntity> list = (List<ArticleEntity>) (Object) redisUtil.lGet("AllArticle", 0, -1);
        if (list != null) {
            logs.info("redis 的articelAll执行");
           // logs.info(" "+list.get(0).toString()+" "+"list.size 的 "+list.size());
            return list;
        }//redis 如果有直接返回redis的内容
        else {
            logs.info("redis 的articelAll 没有执行");
            return articleMapper.selectAll();
        }

    }

    @Override
    public List<ArticleEntity> selectArticleByUid(String uid) {
        return articleMapper.selectByUid(uid);
    }


//    public List<ArticleEntity> selectArticleByTitle(String title) {
//
//        return articleMapper.selectBy(title);
//    }

    /**
     * 查询某一篇文章，根据文章id
     * @param aid 文章id
     * @return
     */
    public   ArticleEntity  selectArticleByAid(String aid) {
        System.out.println("aid" +aid);
        return articleMapper.selectBy(aid);
    }

    /**
     * 保存文章
     * @param articleEntity
     * @return
     */
    @Override
    public int saveArticle(ArticleEntity articleEntity) {
        return  articleMapper.saveArticle(articleEntity);
    }

    /**
     * feed 页面查询
     * @return
     */
    @Override
    public List<ArticleEntity> feedSelect() {
        return articleMapper.feedSelect();
    }

    public boolean setRedis() {
        List<ArticleEntity> list =articleMapper.selectAll();

        redisUtil.lSet("AllArticle", list);
        if (!redisUtil.hasKey("AllArticle")) {

        }
        return true;
    }

}
