package cn.ideal.manager.service.impl;

import cn.ideal.common.mapper.CommodityContentCategoryMapper;
import cn.ideal.common.pojo.CommodityContentCategory;
import cn.ideal.common.pojo.CommodityContentCategoryExample;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.common.results.TreeJsonResult;
import cn.ideal.manager.service.ContentCategoryManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    /**
     * 将商品内容分类查出来用来加载Ztree
     */
    public MessageResult getCommodityCatListForZtree() {
        CommodityContentCategoryExample example = new CommodityContentCategoryExample();
        List<CommodityContentCategory> list = commodityContentCategoryMapper.selectByExample(example);
        List<TreeJsonResult> ztreeList = new ArrayList<>();
        for (CommodityContentCategory commodityContentCategory : list) {
            TreeJsonResult treeJsonResult = new TreeJsonResult(commodityContentCategory.getId(), commodityContentCategory.getName(), commodityContentCategory.getParentId(), String.valueOf(commodityContentCategory.getIsParent()));
            ztreeList.add(treeJsonResult);
        }
        return MessageResult.ok(ztreeList);
    }

    @Override
    public TableJsonResult getCommodityCatListForTable(String id, int page, int limit) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        //查询
        CommodityContentCategoryExample example = new CommodityContentCategoryExample();
        CommodityContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(Long.valueOf(id));
        List<CommodityContentCategory> list = commodityContentCategoryMapper.selectByExample(example);
        PageInfo<CommodityContentCategory> pageInfo = new PageInfo<>(list);
        return new TableJsonResult(pageInfo.getTotal(), list);
    }

    //更新CommodityContentcategory内容
    @Override
    public MessageResult updateContentCategory(CommodityContentCategory commodityContentCategory) {
        commodityContentCategory.setUpdated(new Date(System.currentTimeMillis()));
        commodityContentCategoryMapper.updateByPrimaryKeySelective(commodityContentCategory);
        return MessageResult.ok(true);
    }

    @Override
    public MessageResult deleteContentCategory(String id) {
        String[] list = id.split(",");
        for (int i = 0; i < list.length; i++) {
            commodityContentCategoryMapper.deleteByPrimaryKey(Long.valueOf(list[i]));
        }
        return MessageResult.ok(true);
    }

    /**
     * 向ContentCategory表里面填加数据
     *
     * @param id   添加节点的父节点
     * @param name 添加节点的名字
     * @return
     */
    @Override
    public MessageResult addContentCategory(String id, String name) {
        commodityContentCategoryMapper.insert(new CommodityContentCategory(null, Long.valueOf(id), name, 1, 1, 0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
        return MessageResult.ok(true);
    }


}
