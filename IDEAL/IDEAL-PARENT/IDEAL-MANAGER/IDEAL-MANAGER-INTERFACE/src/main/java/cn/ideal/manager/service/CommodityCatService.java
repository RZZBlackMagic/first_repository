package cn.ideal.manager.service;


import cn.ideal.common.pojo.CommodityCat;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.common.results.TreeJsonResult;

import java.util.List;

/**
 * @author XINER
 * @create 2018-11-27 19:14
 * @desc 商品分类--Service Interface
 **/
public interface CommodityCatService {

    /**
     * 向 Bootstrap Table 填充的分类表单
     *
     * @param pid 按父类Pid检索
     * @return 父类的子分类
     */
    TableJsonResult getCategoryByPidForTable(Long pid, int page, int limit);

    /**
     * 从 Bootstrap Table 接收的编辑修改请求
     *
     * @param commodityCat 修改的分类条目信息
     * @return MessageResult 反馈消息
     */
    MessageResult editCategoryByPidAndFieldForTable(CommodityCat commodityCat);

    /**
     * 向 zTree 填充分类树
     *
     * @return 全部分类
     */
    List<TreeJsonResult> getCategoryListForTree();

    /**
     * 新增 CommodityCat 商品分类
     *
     * @param data
     * @return MessageResult
     */
    MessageResult insertCategory(CommodityCat data);

    /**
     * 删除 CommodityCat List 商品分类列表
     * @param cid 商品分类id的列表
     * @return MessageResult
     */
    MessageResult deleteCategory(String cid, Long pid);
}