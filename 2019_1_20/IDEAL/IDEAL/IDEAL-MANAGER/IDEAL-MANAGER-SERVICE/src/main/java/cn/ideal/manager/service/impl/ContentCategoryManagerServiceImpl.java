package cn.ideal.manager.service.impl;

import cn.ideal.common.pojo.TreeJsonResult;
import cn.ideal.common.utils.IDUtils;
import cn.ideal.manager.service.ContentCategoryManagerService;
import cn.ideal.mapper.CommodityContentCategoryMapper;
import cn.ideal.pojo.CommodityContentCategory;
import cn.ideal.pojo.CommodityContentCategoryExample;
import cn.ideal.pojo.CommodityContentCategoryKey;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class ContentCategoryManagerServiceImpl implements ContentCategoryManagerService {

    @Autowired
    private CommodityContentCategoryMapper commodityContentCategoryMapper;
    String message = null;
    @Override
    /**
     * 将商品内容分类查出来用来加载Ztree
     */
    public List showZtreeListService() {
        CommodityContentCategoryExample commodityContentCategoryExample = new CommodityContentCategoryExample();
        commodityContentCategoryExample.createCriteria();
        List<CommodityContentCategory> list =commodityContentCategoryMapper.selectByExample(commodityContentCategoryExample);
        List<TreeJsonResult> ztreeList = new ArrayList<TreeJsonResult>();
        for(CommodityContentCategory commodityContentCategory:list){
            TreeJsonResult treeJsonResult = new TreeJsonResult();
            treeJsonResult.setId(commodityContentCategory.getId());
            treeJsonResult.setName(commodityContentCategory.getName());
            treeJsonResult.setpId(commodityContentCategory.getParentId());
            if(commodityContentCategory.getParentId()==0){
                treeJsonResult.setOpen(true);
            }else{
                treeJsonResult.setOpen(false);
            }
            ztreeList.add(treeJsonResult);
        }
        return ztreeList;
    }

    @Override
    public List<CommodityContentCategory> initBootstrapTableService(String id,int page,int limit) {
        //设置分页信息
        PageHelper.startPage(page,limit);
        //查询
            List allSelectedList = new ArrayList();
            CommodityContentCategoryExample example = new CommodityContentCategoryExample();
            CommodityContentCategoryExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(Long.valueOf(id));
            List<CommodityContentCategory> list = commodityContentCategoryMapper.selectByExample(example);
            if(list!=null){
                for(int i=0;i<list.size();i++){
                    allSelectedList.add(list.get(i));
                }
            }
        return allSelectedList;
    }

    //更新CommodityContentcategory内容
    @Override
    public String updateContentCategoryService(String id, String parent_id, String name, String status, String sort_order, String is_parent, String created, String updated) {
        CommodityContentCategory commodityContentCategory = new CommodityContentCategory();
        commodityContentCategory.setCreated(new Date(Long.valueOf(created)));
        commodityContentCategory.setId(Long.valueOf(id));
        commodityContentCategory.setIsParent(Integer.valueOf(is_parent));
        commodityContentCategory.setName(name);
        commodityContentCategory.setParentId(Long.valueOf(parent_id));
        commodityContentCategory.setSortOrder(Integer.valueOf(sort_order));
        commodityContentCategory.setStatus(Integer.valueOf(status));
        commodityContentCategory.setUpdated(new Date(Long.valueOf(updated)));
        CommodityContentCategoryExample example = new CommodityContentCategoryExample();
        CommodityContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(commodityContentCategory.getId());
        int row = commodityContentCategoryMapper.updateByExample(commodityContentCategory,example);
        if(row==1){
            message = "修改成功";
        }else{
            message = "修改失败";
        }
        return message;
    }

    @Override
    public String removeContentcategoryService(String id,String name) {
        List<String> list = IDUtils.SplitString(id);
        for(int i=0;i<list.size();i++){
            Long ID = Long.valueOf(list.get(i));
            CommodityContentCategoryKey commodityContentCategoryKey = new CommodityContentCategoryKey();
            commodityContentCategoryKey.setId(ID);
            commodityContentCategoryMapper.deleteByPrimaryKey(commodityContentCategoryKey);
        }


        return "修改成功";
    }

    /**
     * 向ContentCategory表里面填加数据
     * @param id  添加节点的父节点
     * @param name 添加节点的名字
     * @return
     */
    @Override
    public String addContentCategoryService(String id, String name) {
        CommodityContentCategory com = new CommodityContentCategory();
        com.setStatus(1);
        com.setSortOrder(1);
        com.setParentId(Long.valueOf(id));
        com.setIsParent(0);
        com.setCreated(new Date(System.currentTimeMillis()));
        com.setUpdated(new Date(System.currentTimeMillis()));
        com.setName(name);
        int row = commodityContentCategoryMapper.insert(com);
        if(row==1){
            message = "修改成功；";
        }else{
            message = "修改失败；";
        }
        return message;
    }




}
