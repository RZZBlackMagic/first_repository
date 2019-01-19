package com.ideal.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.ideal.common.pojo.TableJsonResult;
import com.ideal.common.utils.IDUtils;
import com.ideal.mapper.CommodityContentCategoryMapper;
import com.ideal.mapper.CommodityContentMapper;
import com.ideal.pojo.CommodityContent;
import com.ideal.pojo.CommodityContentCategory;
import com.ideal.pojo.CommodityContentExample;
import com.ideal.portal.service.ContentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContentManagerServiceImpl implements ContentManagerService {
    @Autowired
    private CommodityContentMapper commodityContentMapper;
    @Override
    public TableJsonResult initContentTableService(String id, int page, int limit) {
        //设置分页信息
        PageHelper.startPage(page,limit);
        //查询
        List<CommodityContent> allSelectedList = new ArrayList();
        CommodityContentExample example = new CommodityContentExample();
        CommodityContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(Long.valueOf(id));
        //criteria.andIdEqualTo(Long.valueOf(id));
        List<CommodityContent> list =  commodityContentMapper.selectByExample(example);
        if(list!=null){
            for(int i=0;i<list.size();i++){
                allSelectedList.add(list.get(i));
            }
        }
        TableJsonResult tableJsonResult = new TableJsonResult(allSelectedList.size(),allSelectedList);
        return tableJsonResult;
    }

    /**
     * 删除商品内容
     * @param Id
     * @return
     */
    @Override
    public String deleteContentService(String Id) {
        //根据
        List<String> idlist = IDUtils.SplitString(Id);
        for(int i=0;i<idlist.size();i++){
            CommodityContentExample example = new CommodityContentExample();
            CommodityContentExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(Long.valueOf(idlist.get(i)));
            commodityContentMapper.deleteByExample(example);
        }
        return "删除成功";
    }

    @Override
    public String addContent(String categoryId,String title, String subTitle, String titleDesc, String url, String pic, String pic2, String content) {
        CommodityContent commodityContent = new CommodityContent();
        commodityContent.setCategoryId(Long.valueOf(categoryId));
        commodityContent.setContent(content);
        commodityContent.setCreated(new Date(System.currentTimeMillis()));
        commodityContent.setPic(pic);
        commodityContent.setPic2(pic2);
        commodityContent.setSubTitle(subTitle);
        commodityContent.setTitle(title);
        commodityContent.setTitleDesc(titleDesc);
        commodityContent.setUpdated(new Date(System.currentTimeMillis()));
        commodityContentMapper.insert(commodityContent);
        return "添加成功";
    }

    @Override
    public String editContentService(String id,String categoryId,String title,String subTitle,String titleDesc,String url,String pic,String pic2,String content) {
        CommodityContent commodityContent = new CommodityContent();
        commodityContent.setCategoryId(Long.valueOf(categoryId));
        commodityContent.setContent(content);

        commodityContent.setCreated(new Date(System.currentTimeMillis()));
        commodityContent.setPic(pic);
        commodityContent.setPic2(pic2);
        commodityContent.setId(Long.valueOf(id));

        commodityContent.setSubTitle(subTitle);
        commodityContent.setTitle(title);
        commodityContent.setTitleDesc(titleDesc);
        commodityContent.setUpdated(new Date(System.currentTimeMillis()));
        CommodityContentExample example = new CommodityContentExample();
        CommodityContentExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(commodityContent.getId());
        commodityContentMapper.updateByExampleSelective(commodityContent,example);
        return "修改成功";
    }
}
