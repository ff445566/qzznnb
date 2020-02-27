package com.whx.qzznnb.access.service.serviceImp;

import com.whx.qzznnb.access.mapper.Acc_ArticleMapper;
import com.whx.qzznnb.access.service.ArticleService_acc;
import com.whx.qzznnb.common.RedisUtil;
import com.whx.qzznnb.entity.ArticleEntity;
import com.whx.qzznnb.service.serviceimp.ArticleServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleServiceAccImp")
public  class ArticleServiceAccImp implements ArticleService_acc {

    @Autowired
    private Acc_ArticleMapper acc_ArticleMapper;
    @Autowired
    private RedisUtil redisUtil;

    private Logger logs = LoggerFactory.getLogger(ArticleServiceImp.class);

    /**
     * 保存文章
     * @param articleEntity
     * @return
     */
    @Override
    public int saveArticle(ArticleEntity articleEntity) {
        return  acc_ArticleMapper.saveArticle(articleEntity);
    }

    @Override
    public int delete_aid(String aid) {
        // 后期此处的删除文章 是否考虑进行备份? 或者仅仅是进行文章的冻结

        return acc_ArticleMapper.delete_aid(aid);
    }

    @Override
    public int delete_aid_list(List<String> list) {
        return acc_ArticleMapper.delete_aid_list(list);
    }

    @Override
    public List<ArticleEntity> selectAll_status() {
        return null;
    }

    @Override
    public int update_status(String status, String aid) {
        return acc_ArticleMapper.update_status(status, aid);
    }

    @Override
    public int update_status_list(String status, List staus_list) {
        return acc_ArticleMapper.update_status_list(status,staus_list);
    }
}
