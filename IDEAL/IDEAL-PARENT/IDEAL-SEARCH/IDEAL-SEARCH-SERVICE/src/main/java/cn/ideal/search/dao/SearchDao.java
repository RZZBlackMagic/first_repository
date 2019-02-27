package cn.ideal.search.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.ideal.common.results.SearchJsonResult;
import cn.ideal.common.results.TableJsonResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SearchDao {
	
	@Autowired
	private SolrServer solrServer;

	public TableJsonResult search(SolrQuery query, Integer page, Integer limit) throws Exception{
		//根据query对象进行查询
		QueryResponse response = solrServer.query(query);
		//取查询结果
		SolrDocumentList solrDocumentList = response.getResults();
		//取查询结果总记录数
		List<SearchJsonResult> itemList = new ArrayList<>();
		//把查询结果封装到SearchJsonResult对象中
		for (SolrDocument solrDocument : solrDocumentList) {
			SearchJsonResult item = new SearchJsonResult();
			item.setId((String) solrDocument.get("id"));
			item.setTitle((String) solrDocument.get("item_title"));
			item.setSellpoint((String) solrDocument.get("item_sellpoint"));
			item.setPrice((Float) solrDocument.get("item_price"));
			item.setDiscount((Float) solrDocument.get("item_discount"));
			item.setImage((String) solrDocument.get("item_image"));
			item.setCategory_name((String) solrDocument.get("item_category_name"));
			item.setProductor_name((String) solrDocument.get("item_productor_name"));
			item.setMerchant_name((String) solrDocument.get("item_merchant_name"));
			//取高亮显示
			Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
			List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
			String title = "";
			if (list != null && list.size() > 0) {
				title = list.get(0);
			} else {
				title = (String) solrDocument.get("item_title");
			}
			item.setTitle(title);
			//添加到商品列表
			itemList.add(item);
		}
		//把结果添加到TableJsonResult中
		TableJsonResult result = new TableJsonResult(itemList.size(), itemList);
		//返回
		return result;
	}
}
