package cn.ideal.manager.service.impl;

import cn.ideal.common.mapper.CommodityContentMapper;
import cn.ideal.common.pojo.CommodityContent;
import cn.ideal.common.pojo.CommodityContentExample;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.common.utils.IDUtils;
import cn.ideal.manager.service.ContentManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public TableJsonResult getContentListForTable(Long id, int page, int limit) {
        //设置分页信息
        PageHelper.startPage(page,limit);
        //查询
        CommodityContentExample example = new CommodityContentExample();
        CommodityContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(id);
        List<CommodityContent> list =  commodityContentMapper.selectByExample(example);
        PageInfo<CommodityContent> pageInfo = new PageInfo<>(list);
        return new TableJsonResult(pageInfo.getTotal(), list);
    }

    @Override
    public MessageResult deleteContent(String id) {
        //根据
        String[] idList = id.split(",");
        for(int i = 0; i < idList.length ; i++){
            commodityContentMapper.deleteByPrimaryKey(Long.valueOf(idList[i]));
        }
        return MessageResult.ok(true);
    }

    @Override
    public MessageResult insertContent(CommodityContent commodityContent) {
        commodityContent.setCreated(new Date(System.currentTimeMillis()));
        commodityContent.setUpdated(new Date(System.currentTimeMillis()));
        commodityContentMapper.insert(commodityContent);
        return MessageResult.ok(true);
    }

    @Override
    public MessageResult updateContent(CommodityContent commodityContent) {
        commodityContent.setUpdated(new Date(System.currentTimeMillis()));
        commodityContentMapper.updateByPrimaryKeySelective(commodityContent);
        return MessageResult.ok(true);
    }
}
