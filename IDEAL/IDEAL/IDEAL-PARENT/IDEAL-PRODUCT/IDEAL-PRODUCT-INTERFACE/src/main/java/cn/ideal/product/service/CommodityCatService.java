package cn.ideal.product.service;

import cn.ideal.common.results.TreeJsonResult;

import java.util.List;

public interface CommodityCatService {

    List<TreeJsonResult> getCommodityCatList(long parentID);

}
