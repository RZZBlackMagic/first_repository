package cn.ideal.manager.service;

import cn.ideal.common.pojo.CommodityContent;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;

public interface ContentManagerService {

    TableJsonResult getContentListForTable(Long id, int page, int limit);

    MessageResult deleteContent(String id);

    MessageResult insertContent(CommodityContent commodityContent);

    MessageResult updateContent(CommodityContent commodityContent);
}