package com.whx.qzznnb.service.serviceimp;

import com.whx.qzznnb.common.RedisUtil;
import com.whx.qzznnb.entity.ArticleEntity;
import com.whx.qzznnb.mapper.ArticleMapper;
import com.whx.qzznnb.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

    /**
     *
     * @param page  当前页数
     * @param artCount 文章当前页的数量（是否读完了）
     * @param fCount 前端请求的数量
     * @param artAll 文章所有的数量
     * @return
     */
    @Override
    public List< HashMap<String ,Object>> feedSelect_Main(int page, int artCount,int fCount,int artAll) {

        //fCount 不等于0 说明问答已经没有文章了， 取的数量就是fcout，但是取的位置就是从artCount
        List< HashMap<String ,Object> > reslist = new ArrayList<>();
        List<ArticleEntity> list=null;
        int pagesize = (page-1)*fCount;

        if((fCount/2)== artCount){ //  第一个数据充足
             pagesize = (page-1)*artCount;
            list = articleMapper.feedSelect_Main(pagesize, artCount);
        }
        else  if(artCount == 0){ //第一个已经完全没数据了
            //从第几个开始取    (page-1)*artCount
//            int a =(artAll*2/fCount);
            //   page 当前页数
            //    之前共同的页数  ((artAll*2/fcount)+1) 8 3 9 5
            int apage = ((artAll*2/fCount)); //两边一样多的时候
            int endcount =artAll%(fCount/2);
            //    从 page-1 ((artAll*2/fcount)+1) 她自己的页数 +1
            //第二页 不满
                pagesize = (apage)*(fCount/2) +(fCount-endcount) + (page-1-apage-1)*fCount;
            //    现在的页数
           // int a=(page-1)*artCount;
            // pagesize =  artAll+(page-a)*fCount;
            list = articleMapper.feedSelect_Main(pagesize, fCount);
            // a（AartCount / fCount） *2  页数
            //  (a+1) 数量 page-(a+1)*fCount ，取fCount数量
            //8条数据，  确定从哪里计算， 总数量、根据第一个的总条数
        }
        else if(artCount < (fCount/2)) {// 第一个数据不充分
            //当前页数 取值数量改变
            pagesize=(page-1)*(fCount/2);
             list = articleMapper.feedSelect_Main(pagesize, fCount-artCount);
        }

        for (int i = 0; i < list.size(); i++) {
            HashMap<String ,Object> resmap = new HashMap<>();
            ArticleEntity art = list.get(i);
            resmap.put("feed_style",art.getFeed_style());
            resmap.put("article",art);
            reslist.add(resmap);
        }

        return  reslist;

    }

    public boolean setRedis() {
        List<ArticleEntity> list =articleMapper.selectAll();

        redisUtil.lSet("AllArticle", list);
        if (!redisUtil.hasKey("AllArticle")) {

        }
        return true;
    }

}
