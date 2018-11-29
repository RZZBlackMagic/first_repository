package com.ideal.service;

import com.ideal.common.CommdoityTableJsonResult;
import com.ideal.common.CommodityZtreeJsonResult;
import com.ideal.pojo.Commodity;
import com.ideal.pojo.ZtreeNodesEntity;

import java.util.List;

public interface CommodityService {

    Commodity getCommodityById(long commodityId);
    List<ZtreeNodesEntity> getZtreeJsonNodesService();
    CommdoityTableJsonResult getProductList(String category_id, int limit, int page);

}
