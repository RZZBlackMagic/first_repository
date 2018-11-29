package com.ideal.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.ideal.common.CommdoityTableJsonResult;
import com.ideal.common.CommodityZtreeJsonResult;
import com.ideal.mapper.CommodityCatMapper;
import com.ideal.mapper.CommodityMapper;
import com.ideal.mapper.RelaCommodityCatMapper;
import com.ideal.pagehelper.PageInfo;
import com.ideal.pojo.*;
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

    @Autowired
    private RelaCommodityCatMapper relaCommodityCatMapper;
    
	public Commodity getCommodityById(long commodityId) {
		// TODO Auto-generated method stub
		return null;
	}




	public List<ZtreeNodesEntity> getZtreeJsonNodesService() {
		 CommodityCatExample commodityCat = new CommodityCatExample() ;
	        CommodityCatExample.Criteria criteria= commodityCat.createCriteria();
	        criteria.andCidIsNotNull();
	        List<CommodityCat> list = commodityCatMapper.selectByExample(commodityCat);
	        List<ZtreeNodesEntity> ztreeNodesList = new ArrayList<ZtreeNodesEntity>();

	        for(int i=0;i<list.size();i++){
	            ZtreeNodesEntity ztreeNodesEntity = new ZtreeNodesEntity();
	            if(list.get(i).getPid()==0){
	                ztreeNodesEntity.setOpen(true);
	            }else{
	                ztreeNodesEntity.setOpen(false);
	            }
	            System.out.println(list.get(i));
	            ztreeNodesEntity.setId(list.get(i).getCid());
	            ztreeNodesEntity.setpId(list.get(i).getPid());
	            ztreeNodesEntity.setName(list.get(i).getName());
	            //System.out.println(ztreeNodesEntity);
	            ztreeNodesList.add(ztreeNodesEntity);
	        }
	        CommodityZtreeJsonResult commodityZtreeJsonResult = new CommodityZtreeJsonResult(ztreeNodesList);
	        return ztreeNodesList;		
	}




	public CommdoityTableJsonResult getProductList(String category_id, int limit, int page) {
		System.out.println(category_id);
		//设置分页信息
        PageHelper.startPage(page, limit);
        //查询
        //解析id字符串
        String flag = "";
        List<String> idList = new ArrayList<String>();
        for(int i=0;i<category_id.length();i++){
        	char a = category_id.charAt(i);
        	char b = ',';
            if(b==a){
                //System.out.println("id="+flag);
                idList.add(flag);
                flag="";
                		
            }else{
                flag=flag+category_id.charAt(i);
            }
        }
        //System.out.println(idList);
        //查询CommodityCat表的isparent属性，判断是否为0，yes则根据category_id去查询Commodity表里的信息，返回
        List<Commodity> allSelectedProductList = new ArrayList<Commodity>();
        for(int i=0;i<idList.size();i++) {
            Long categoryId = Long.valueOf(idList.get(i));
            System.out.println(categoryId);
            CommodityCatExample example = new CommodityCatExample();
            CommodityCatExample.Criteria criteria = example.createCriteria();
            criteria.andCidEqualTo(categoryId);
            List<CommodityCat> commodityCatList =commodityCatMapper.selectByExample(example);
            System.out.println("查出来的CommodityCat的信息："+commodityCatList);
            if (commodityCatList.get(0).getParent() == 0) {
            	
                //则去关系表去查询cid对应的id
                RelaCommodityCatExample rce = new RelaCommodityCatExample();
                RelaCommodityCatExample.Criteria c = rce.createCriteria();
                c.andCidEqualTo(commodityCatList.get(0).getCid());
                List<RelaCommodityCat> relaList = relaCommodityCatMapper.selectByExample(rce);
                
                //relaList.get(0).getId();//得到商品的ID，然后去商品表查询商品信息
                for(int j=0;j<relaList.size();j++){
                	CommodityExample ce = new CommodityExample();
                    CommodityExample.Criteria cc = ce.createCriteria();
                    cc.andIdEqualTo(relaList.get(j).getId());
                    List<Commodity> commodityList = commodityMapper.selectByExample(ce);
                    System.out.println("查询得到的要展示的商品信息："+commodityList);
                    for (int m = 0; m < commodityList.size(); m++) {
                        allSelectedProductList.add(commodityList.get(m));
                    }
                }
                
                
               
            }
        }
        //取结果
        
        PageInfo<Commodity> pageInfo = new PageInfo<Commodity>(allSelectedProductList);
        CommdoityTableJsonResult commdoityTableJsonResult = new CommdoityTableJsonResult();
        commdoityTableJsonResult.setRows(allSelectedProductList);
        commdoityTableJsonResult.setTotal(pageInfo.getTotal());
        System.out.println(1);
        return commdoityTableJsonResult;		
	}
}
