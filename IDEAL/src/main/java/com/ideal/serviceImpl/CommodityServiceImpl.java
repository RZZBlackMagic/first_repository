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

import java.sql.Date;
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
	

	public String EditCommodity(Commodity com) {
		com.setUpdated(new Date(System.currentTimeMillis()));
		CommodityExample ce = new CommodityExample();
        CommodityExample.Criteria cc = ce.createCriteria();
        cc.andIdEqualTo(com.getId());
        int row = commodityMapper.updateByExample(com, ce);
        String message;
        if(row!=0){
        	 message = "修改成功";
        }else{
        	 message = "修改失败";
        }
        return message;
	}




	public String addGood(String name, String title, String price, String quantity, String hitpoint, String status) {
		Commodity com = new Commodity();
		
		return null;
	}




	public String removeGood(String title) {
		//解析字符串
		String flag = "";
        List<String> titleList = new ArrayList<String>();
        for(int i=0;i<title.length();i++){
        	char a = title.charAt(i);
        	char b = ',';
            if(b==a){
                //System.out.println("id="+flag);
            	titleList.add(flag);
                flag="";
                		
            }else{
                flag=flag+title.charAt(i);
            }
        }
        String success = "删除成功" ;
        String error = "";
        int flag1 = 0;//判断删除是否成功
        for(int i=0;i<titleList.size();i++){
            //在商品表Commodity表里面删除
        	CommodityExample ce = new CommodityExample();
            CommodityExample.Criteria cc = ce.createCriteria();
            cc.andTitleEqualTo(titleList.get(i));
            int row = commodityMapper.deleteByExample(ce);
            //在关系表Real_COmmodity_Cat里删除
            RelaCommodityCatExample rce = new RelaCommodityCatExample();
        	RelaCommodityCatExample.Criteria rc = rce.createCriteria();
        	rc.andTitleEqualTo(titleList.get(i));
        	int row1 = relaCommodityCatMapper.deleteByExample(rce);
            if(row==0||row1==0){
            	flag1=1;
            	error=error+ titleList.get(i)+"删除失败;";
            	continue;
            }
        }
        
        if(flag1==1){
        	//删除失败
    		return error;
        }else{
        	//删除成功
        	return success;
        }
        
		
	}
}
