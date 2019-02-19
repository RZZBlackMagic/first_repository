package cn.ideal.manager.service.impl;

import cn.ideal.common.pojo.TableJsonResult;
import cn.ideal.manager.service.MerchantManagerService;
import cn.ideal.mapper.RelaMerProComMapper;
import cn.ideal.mapper.RelaMerProMapper;
import cn.ideal.pojo.*;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MerchantManagerImpl implements MerchantManagerService {
    @Autowired
    private RelaMerProMapper relaMerProMapper;
    @Autowired
    private RelaMerProComMapper relaMerProComMapper;
    @Override
    public TableJsonResult getUnRelaMerProListForTable(int limit,int page) {
        PageHelper.startPage(page,limit);
        RelaMerProExample example = new RelaMerProExample();
        RelaMerProExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        List<RelaMerPro > list = relaMerProMapper.selectByExample(example);
        TableJsonResult tableJsonResult = new TableJsonResult();
        tableJsonResult.setRows(list);
        tableJsonResult.setTotal(list.size());
        return tableJsonResult;
    }
    public TableJsonResult getRelaMerProListForTable(int limit ,int page){
        PageHelper.startPage(page,limit);
        RelaMerProExample example = new RelaMerProExample();
        RelaMerProExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        List<RelaMerPro > list = relaMerProMapper.selectByExample(example);
        TableJsonResult tableJsonResult = new TableJsonResult();
        tableJsonResult.setRows(list);
        tableJsonResult.setTotal(list.size());
        return tableJsonResult;
    }
    public TableJsonResult getRelaProMerComListForTable(int limit ,int page){
        PageHelper.startPage(page,limit);
        RelaMerProComExample example = new RelaMerProComExample();
        RelaMerProComExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        List<RelaMerProCom> list = relaMerProComMapper.selectByExample(example);
        TableJsonResult tableJsonResult = new TableJsonResult();
        tableJsonResult.setTotal(list.size());
        tableJsonResult.setRows(list);
        return tableJsonResult;
    }
    public TableJsonResult getUnRelaProMerComListForTable(int limit ,int page){
        PageHelper.startPage(page,limit);
        RelaMerProComExample example = new RelaMerProComExample();
        RelaMerProComExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        List<RelaMerProCom> list = relaMerProComMapper.selectByExample(example);
        TableJsonResult tableJsonResult = new TableJsonResult();
        tableJsonResult.setTotal(list.size());
        tableJsonResult.setRows(list);
        return tableJsonResult;
    }
}
