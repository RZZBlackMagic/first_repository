package com.ideal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ideal.common.pojo.CommdoityTableJsonResult;
import com.ideal.mapper.CommodityCatMapper;
import com.ideal.mapper.CommodityMapper;
import com.ideal.pojo.Commodity;
import com.ideal.pojo.CommodityCat;
import com.ideal.pojo.CommodityCatExample;
import com.ideal.pojo.CommodityExample;
import com.ideal.pojo.ZtreeNodesEntity;
import com.ideal.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityCatMapper commodityCatMapper;


    @Override
    public Commodity getCommodityById(long commodityId) {
        /*CommodityExample commodity1 = new CommodityExample();
        CommodityExample.Criteria criteria = commodity1.createCriteria();
        criteria.andCommodityIdEqualTo(commodityId);
        Commodity commodity = commodityMapper.selectByExample(commodity1);*/
        return null;
    }

    @Override
    public List<ZtreeNodesEntity> getZtreeJsonNodesService() {
        CommodityCatExample commodityCat = new CommodityCatExample() ;
        CommodityCatExample.Criteria criteria= commodityCat.createCriteria();
        criteria.andCategoryIdIsNotNull();
        List<CommodityCat> list = commodityCatMapper.selectByExample(commodityCat);
        List<ZtreeNodesEntity> ztreeNodesList = new ArrayList<ZtreeNodesEntity>();

        for(int i=0;i<list.size();i++){
            ZtreeNodesEntity ztreeNodesEntity = new ZtreeNodesEntity();
            if(list.get(i).getParentId()==0){
                ztreeNodesEntity.setOpen(true);
            }else{
                ztreeNodesEntity.setOpen(false);
            }
            System.out.println(list.get(i));
            ztreeNodesEntity.setId(list.get(i).getCategoryId());
            ztreeNodesEntity.setpId(list.get(i).getParentId());
            ztreeNodesEntity.setName(list.get(i).getName());
            //System.out.println(ztreeNodesEntity);
            ztreeNodesList.add(ztreeNodesEntity);
        }
        return ztreeNodesList;
    }

    @Override
    public CommdoityTableJsonResult getProductList(String category_id,int limit,int page) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        //查询
          //解析id字符串
        String flag = "";
        List<String> idList = new ArrayList<String>();
        for(int i=0;i<category_id.length();i++){
            if(",".equals(category_id.charAt(i))){
                idList.add(flag);
                flag="";
                System.out.println(flag);
            }else{
                flag=flag+category_id.charAt(i);
            }
        }
          //查询CommodityCat表的isparent属性，判断是否为0，yes则根据category_id去查询Commodity表里的信息，返回
        List<Commodity> allSelectedProductList = new ArrayList<Commodity>();
        for(int i=0;i<idList.size();i++) {
            Long categoryId = Long.valueOf(idList.get(i));
            CommodityCatExample example = new CommodityCatExample();
            CommodityCatExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryIdEqualTo(categoryId);
            List<CommodityCat> commodityCatList =commodityCatMapper.selectByExample(example);
            System.out.println("查出来的CommodityCat的信息："+commodityCatList);
            if (commodityCatList.get(0).getIsParenet() == 0) {
                //则去Commodity表里面去查询商品信息
                CommodityExample commodityExample = new CommodityExample();
                CommodityExample.Criteria criteria1 = commodityExample.createCriteria();
                criteria1.andCategoryEqualTo(idList.get(i));
                List<Commodity> commodityList = commodityMapper.selectByExample(commodityExample);
                System.out.println("查询得到的要展示的商品信息："+commodityList);
                for (int j = 0; j < commodityList.size(); j++) {
                    allSelectedProductList.add(commodityList.get(j));
                }
            }
        }
        //取结果
        PageInfo<Commodity> pageInfo = new PageInfo<>(allSelectedProductList);
        CommdoityTableJsonResult commdoityTableJsonResult = new CommdoityTableJsonResult();
        commdoityTableJsonResult.setRows(allSelectedProductList);
        commdoityTableJsonResult.setTotal(pageInfo.getTotal());
        System.out.println(1);
        return commdoityTableJsonResult;
    }

}
