package cn.ideal.manager.service;

import cn.ideal.common.pojo.CommodityContentCategory;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;

public interface ContentCategoryManagerService {

    MessageResult getCommodityCatListForZtree();

    TableJsonResult getCommodityCatListForTable(String id, int limit, int page);

    MessageResult updateContentCategory(CommodityContentCategory commodityContentCategory);

    MessageResult deleteContentCategory(String id);

    MessageResult addContentCategory(CommodityContentCategory category);

}
