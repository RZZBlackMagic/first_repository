package cn.ideal.manager.service.impl;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.pojo.TableJsonResult;
import cn.ideal.common.pojo.TreeJsonResult;
import cn.ideal.common.utils.IDUtils;
import cn.ideal.manager.service.CommodityCatService;
import cn.ideal.mapper.CommodityCatMapper;
import cn.ideal.pojo.CommodityCat;
import cn.ideal.pojo.CommodityCatExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Integer.*;

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
    public TableJsonResult getCategoryByPidForTable(long pid, int page, int limit) {
        System.out.println("*********"+pid+page+limit);
        //设置分页信息
        PageHelper.startPage(page, limit);
        //查询(按升序)
        CommodityCatExample example = new CommodityCatExample();
        example.createCriteria().andPidEqualTo(pid);
        List<CommodityCat> list = commodityCatMapper.selectByExample(example);
        //取查询结果(分页)
        PageInfo<CommodityCat> pageInfo = new PageInfo<>(list);
        TableJsonResult result = new TableJsonResult();
        result.setRows(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    /**
     * 从 Bootstrap Table 接收的编辑修改请求
     *
     * @param commodityCat 修改的分类条目信息
     * @return MessageResult 反馈消息
     */
    @Override
    public MessageResult editCategoryByPidAndFieldForTable(String id,String pId,String name,String status,String sort,String isparent,String created,String updated) {
        //更新--updated字段的更新时间和界面中修改的字段
        CommodityCat commodityCat = new CommodityCat();
        commodityCat.setId(Long.valueOf(id));
        commodityCat.setPid(Long.valueOf(pId));
        commodityCat.setCreated(new Date(System.currentTimeMillis()));
        commodityCat.setIsparent( Byte.valueOf(isparent));
        commodityCat.setName(name);
        commodityCat.setSort(Integer.valueOf(sort));
        commodityCat.setStatus(Byte.valueOf(status));
        commodityCat.setUpdated(new Date(System.currentTimeMillis()));
        System.out.println("*********"+commodityCat);
        CommodityCatExample example = new CommodityCatExample();
        example.createCriteria().andIdEqualTo(commodityCat.getId());
        commodityCat.setUpdated(new Date(System.currentTimeMillis()));
        commodityCatMapper.updateByExample(commodityCat, example);
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
        CommodityCatExample.Criteria criteria = example.createCriteria();
        List<CommodityCat> categoryList = commodityCatMapper.selectByExample(example);
        System.out.println("*********"+categoryList);
        List<TreeJsonResult> resultList = new ArrayList<>();
        //装填TreeNode
        for(int i=0;i<categoryList.size();i++){
            TreeJsonResult treeJsonResult = new TreeJsonResult();
            treeJsonResult.setId(categoryList.get(i).getId());
            categoryList.get(i).getIsparent();
/*
            treeJsonResult.setIsParent((int) categoryList.get(i).getIsparent());
*/
            treeJsonResult.setName(categoryList.get(i).getName());
            treeJsonResult.setOpen(false);
            treeJsonResult.setpId(categoryList.get(i).getPid());
            resultList.add(treeJsonResult);
        }
        /*for (CommodityCat cell : categoryList) {
            TreeJsonResult node = new TreeJsonResult();
            node.setId(cell.getId());
            node.setpId(cell.getPid());
            node.setName(cell.getName());
            node.setIsParent((int) cell.getIsparent());
            resultList.add(node);
        }*/
        return resultList;
    }

    /**
     * 新增 CommodityCat 商品分类
     *
     * @param  商品分类表单
     * @return MessageResult
     */
    @Override
    public MessageResult insertCategory(String name,String pid) {
        //查询父分类的 parent字段 是否为0 是则更新父分类parent
        String message ;
        CommodityCat com = new CommodityCat();
        com.setPid(Long.valueOf(pid));
        com.setUpdated(new Date(System.currentTimeMillis()));
        com.setStatus((byte) 1);
        com.setSort(0);
        com.setName(name);
        com.setIsparent((byte) 0);
        com.setCreated(new Date(System.currentTimeMillis()));
        //判断要添加节点的父节点是不是子叶节点，如果是，则将其变为父节点状态
        CommodityCatExample example = new CommodityCatExample();
        CommodityCatExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(Long.valueOf(pid));
        List<CommodityCat> list = commodityCatMapper.selectByExample(example);
        CommodityCat commodityCat = list.get(0);
        if(commodityCat.getIsparent()==0){
            commodityCat.setIsparent((byte) 1);
        }
        commodityCatMapper.updateByExample(commodityCat,example);
        int row = commodityCatMapper.insert(com);
        if(row==1){
            message = "添加成功";
        }else{
            message = "添加失败";
        }
        return MessageResult.ok(message);
    }

    /**
     * 删除 CommodityCat List 商品分类列表
     * @param cidList 商品分类id的列表
     * @return MessageResult
     */
    @Override
    public MessageResult deleteCategory(String  id,String pid) {
        List<String> idlist = IDUtils.SplitString(id);
        //cid对应父节点集合
        //
        CommodityCatExample example = new CommodityCatExample();
        CommodityCatExample.Criteria criteria = example.createCriteria();
        String message;
        int row ;
        for (String cid : idlist){
            criteria.andIdEqualTo(Long.valueOf(cid));
             row =  commodityCatMapper.deleteByExample(example);
        }
        criteria.andIdEqualTo(Long.valueOf(pid));
        List<CommodityCat> list = commodityCatMapper.selectByExample(example);
        if(list==null){
            criteria.andIdEqualTo(Long.valueOf(id));
            List<CommodityCat> commodityCats = commodityCatMapper.selectByExample(example);
            commodityCats.get(0).setIsparent((byte) 0);

        }
        return MessageResult.ok("成功");
    }
}
