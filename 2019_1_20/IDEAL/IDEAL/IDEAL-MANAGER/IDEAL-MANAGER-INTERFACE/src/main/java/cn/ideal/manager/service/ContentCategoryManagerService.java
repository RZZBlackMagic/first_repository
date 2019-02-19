package cn.ideal.manager.service;

import cn.ideal.pojo.CommodityContentCategory;

import java.util.List;

public interface ContentCategoryManagerService {

    public List showZtreeListService();
    public List<CommodityContentCategory> initBootstrapTableService(String id, int limit, int page);
    public String updateContentCategoryService(String id, String parent_id, String name, String status, String sort_order, String is_parent, String created, String updated);
    public String removeContentcategoryService(String id, String name);
    public String addContentCategoryService(String id, String name);

}
