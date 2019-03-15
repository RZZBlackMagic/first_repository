package cn.ideal.search.service.impl;

import cn.ideal.common.results.TableJsonResult;
import cn.ideal.search.dao.SearchDao;
import cn.ideal.search.service.SearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XINER
 * @create 2019-02-24 14:43
 * @desc
 **/
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao searchDao;

    @Override
    public TableJsonResult search(String queryString, Integer page, Integer limit) throws Exception {
        //根据查询条件拼装查询对象
        //创建一个SolrQuery对象
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery(new String(queryString.getBytes("ISO8859-1"), "UTF-8"));
        //设置分页条件
        if (page < 1) page =1;
        query.setStart((page - 1) * limit);
        if (limit < 1) limit = 10;
        query.setRows(limit);
        //设置默认搜索域
        query.set("df", "item_title");
        //设置高亮显示
        query.setHighlight(true);
        query.addHighlightField("item_title");
        query.setHighlightSimplePre("<font color='red'>");
        query.setHighlightSimplePost("</font>");
        //调用dao执行查询
        TableJsonResult res = searchDao.search(query, page, limit);
        return res;
    }
}
