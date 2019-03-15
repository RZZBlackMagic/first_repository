package cn.ideal.search.service.impl;

import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.SearchJsonResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.search.mapper.SearchCommodityMapper;
import cn.ideal.search.service.SearchCommodityService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author XINER
 * @create 2019-02-23 17:03
 * @desc
 **/
@Service
public class SearchCommodityServiceImpl implements SearchCommodityService {

    @Autowired
    private SearchCommodityMapper searchCommodityMapper;
    @Autowired
    private SolrServer solrServer;

    @Override
    public MessageResult importCommoditiesToIndex() {

        try {
            List<SearchJsonResult> itemList = searchCommodityMapper.getCommodityList();
            for (SearchJsonResult searchItem : itemList){
                SolrInputDocument document = new SolrInputDocument();
                document.addField("id", searchItem.getId());
                document.addField("item_title", searchItem.getTitle());
                document.addField("item_sellpoint", searchItem.getSellpoint());
                document.addField("item_price", searchItem.getPrice());
                document.addField("item_discount", searchItem.getDiscount());
                document.addField("item_image", searchItem.getImage());
                document.addField("item_category_name", searchItem.getCategory_name());
                document.addField("item_merchant_name", null);
                document.addField("item_productor_name", searchItem.getProductor_name());
                solrServer.add(document);
            }
            solrServer.commit();

        } catch (Exception e) {
            return MessageResult.build(500, "数据导入失败");
        }
        return MessageResult.ok();
    }

}
