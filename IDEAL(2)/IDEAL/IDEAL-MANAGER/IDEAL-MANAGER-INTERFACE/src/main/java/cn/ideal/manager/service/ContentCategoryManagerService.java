package cn.ideal.manager.service;

import cn.ideal.common.pojo.CommodityContentCategory;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.common.results.TreeJsonResult;

import java.util.List;

public interface ContentCategoryManagerService {

    MessageResult getCommodityCatListForZtree();

    TableJsonResult getCommodityCatListForTable(String id, int limit, int page);

    MessageResult updateContentCategory(CommodityContentCategory commodityContentCategory);

    MessageResult deleteContentCategory(String id);

    MessageResult addContentCategory(String id, String name);

}
