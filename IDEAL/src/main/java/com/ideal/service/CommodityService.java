package com.ideal.service;

import com.ideal.common.CommdoityTableJsonResult;
import com.ideal.common.CommodityZtreeJsonResult;
import com.ideal.pojo.Commodity;
import com.ideal.pojo.ZtreeNodesEntity;

import java.util.List;

public interface CommodityService {

	/**
	 * 通过ID查询商品
	 * @param commodityId
	 * @return
	 */
    Commodity getCommodityById(long commodityId);
    /**
     * 加载Ztree节点
     * @return
     */
    List<ZtreeNodesEntity> getZtreeJsonNodesService();
    /**
     * 加载商品信息列表
     * @param category_id
     * @param limit
     * @param page
     * @return
     */
    CommdoityTableJsonResult getProductList(String category_id, int limit, int page);
    String EditCommodity(Long id,String title,String hotpoint,Long price,Integer quantity,Long bid,String image,String position,String category,Byte status,String created,String updated);
    String addGood(String name,String title ,String price,String quantity,String hitpoint, String status);
    String removeGood(String title);
}
