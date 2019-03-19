package cn.ideal.manager.service.impl;

import cn.ideal.common.mapper.CommodityCatMapper;
import cn.ideal.common.pojo.CommodityCat;
import cn.ideal.common.pojo.CommodityCatExample;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.common.results.TreeJsonResult;
import cn.ideal.manager.service.CommodityCatService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;


/**
 * @author XINER
 * @create 2018-11-27 19:17
 * @desc 商品分类--Service
 **/

@Service
public class CommodityCatServiceImpl implements CommodityCatService {

    @Autowired
    private CommodityCatMapper commodityCatMapper;

    /**
     * 向 Bootstrap Table 填充的分类表单
     *
     * @param pid 按父类Pid检索
     * @return 父类的子分类
     */
    @Override
    public TableJsonResult getCategoryByPidForTable(Long pid, int page, int limit) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        //查询(按升序)
        CommodityCatExample example = new CommodityCatExample();
        example.createCriteria().andPidEqualTo(pid);
        List<CommodityCat> list = commodityCatMapper.selectByExample(example);
        //取查询结果(分页)
        PageInfo<CommodityCat> pageInfo = new PageInfo<>(list);
        TableJsonResult result = new TableJsonResult(pageInfo.getTotal(), list);
        return result;
    }

    /**
     * 从 Bootstrap Table 接收的编辑修改请求
     *
     * @param commodityCat 修改的分类条目信息
     * @return MessageResult 反馈消息
     */
    @Override
    public MessageResult editCategoryByPidAndFieldForTable(CommodityCat commodityCat) {
        //更新--updated字段的更新时间和界面中修改的字段
        commodityCat.setUpdated(new Date(System.currentTimeMillis()));
        commodityCatMapper.updateByPrimaryKeySelective(commodityCat);
        return MessageResult.ok();
    }

    /**
     * 向 zTree 填充分类树
     *
     * @return 全部分类
     */
    @Override
    public List<TreeJsonResult> getCategoryListForTree() {
        //升序排列
        CommodityCatExample example = new CommodityCatExample();
        List<CommodityCat> categoryList = commodityCatMapper.selectByExample(example);
        List<TreeJsonResult> resultList = new ArrayList<>();
        //装填TreeNode
        for (int i = 0; i < categoryList.size(); i++) {
            TreeJsonResult treeJsonResult = new TreeJsonResult();
            treeJsonResult.setId(categoryList.get(i).getId());
            treeJsonResult.setIsParent(categoryList.get(i).getIsparent().toString());
            treeJsonResult.setName(categoryList.get(i).getName());
            treeJsonResult.setpId(categoryList.get(i).getPid());
            resultList.add(treeJsonResult);
        }
        return resultList;
    }

    /**
     * 新增 CommodityCat 商品分类
     *
     * @return MessageResult
     */
    @Override
    public MessageResult insertCategory(CommodityCat commodityCat) {

        //查询父分类的 parent字段 是否为0 是则更新父分类parent
        //判断要添加节点的父节点是不是子叶节点，如果是，则将其变为父节点状态
        CommodityCat com = new CommodityCat(null, commodityCat.getPid(), commodityCat.getName(), commodityCat.getImage(), commodityCat.getFrontName(), (byte) 1, 0, (byte) 0, new Date(), new Date());
        CommodityCat father = commodityCatMapper.selectByPrimaryKey(commodityCat.getPid());
        if (father.getIsparent() == 0) {
            father.setIsparent((byte) 1);
            commodityCatMapper.updateByPrimaryKey(father);
        }
        commodityCatMapper.insert(com);
        return MessageResult.ok();
    }

    /**
     * 删除 CommodityCat List 商品分类列表
     *
     * @param cid
     * @param pid
     * @return MessageResult
     */
    @Override
    public MessageResult deleteCategory(String cid, Long pid) {
        //cid对应父节点集合
        String[] cidList = cid.split(",");
        for (String cell : cidList) {
            commodityCatMapper.deleteByPrimaryKey(Long.valueOf(cell));
        }
        CommodityCatExample example = new CommodityCatExample();
        CommodityCatExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        List<CommodityCat> list = commodityCatMapper.selectByExample(example);
        if (list.size() == 0) {
            CommodityCat commodityCat = commodityCatMapper.selectByPrimaryKey(pid);
            commodityCat.setIsparent((byte) 0);
            commodityCatMapper.updateByPrimaryKey(commodityCat);
        }
        return MessageResult.ok();
    }
}
