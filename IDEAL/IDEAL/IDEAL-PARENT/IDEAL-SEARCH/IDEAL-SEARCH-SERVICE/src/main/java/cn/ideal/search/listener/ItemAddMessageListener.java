package cn.ideal.search.listener;

import cn.ideal.common.results.SearchJsonResult;
import cn.ideal.search.mapper.SearchCommodityMapper;
import cn.ideal.search.service.SearchCommodityService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author XINER
 * @create 2019-03-17 13:03
 * @desc 监听商品添加事件
 **/
public class ItemAddMessageListener implements MessageListener {

    @Autowired
    private SearchCommodityMapper searchCommodityMapper;
    @Autowired
    private SolrServer solrServer;

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            Thread.sleep(1000);
            SearchJsonResult searchItem = searchCommodityMapper.getItemById(Long.parseLong(text));

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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
