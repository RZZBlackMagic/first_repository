package cn.ideal.manager.service.impl;

import cn.ideal.common.mapper.RelaMerProComMapper;
import cn.ideal.common.mapper.RelaMerProMapper;
import cn.ideal.common.pojo.RelaMerPro;
import cn.ideal.common.pojo.RelaMerProCom;
import cn.ideal.common.pojo.RelaMerProComExample;
import cn.ideal.common.pojo.RelaMerProExample;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.manager.service.MerchantManagerService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MerchantManagerImpl implements MerchantManagerService {
    @Autowired
    private RelaMerProMapper relaMerProMapper;
    @Autowired
    private RelaMerProComMapper relaMerProComMapper;
    @Override
    public TableJsonResult getUnRelaMerProListForTable(int limit, int page) {
        PageHelper.startPage(page,limit);
        RelaMerProExample example = new RelaMerProExample();
        RelaMerProExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        List<RelaMerPro> list = relaMerProMapper.selectByExample(example);
        PageInfo<RelaMerPro> pageInfo = new PageInfo<>(list);
        return new TableJsonResult(pageInfo.getTotal(), list);
    }
    public TableJsonResult getRelaMerProListForTable(int limit ,int page){
        PageHelper.startPage(page,limit);
        RelaMerProExample example = new RelaMerProExample();
        RelaMerProExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        List<RelaMerPro> list = relaMerProMapper.selectByExample(example);
        PageInfo<RelaMerPro> pageInfo = new PageInfo<>(list);
        return new TableJsonResult(pageInfo.getTotal(), list);
    }
    public TableJsonResult getRelaProMerComListForTable(int limit ,int page){
        PageHelper.startPage(page,limit);
        RelaMerProComExample example = new RelaMerProComExample();
        RelaMerProComExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        List<RelaMerProCom> list = relaMerProComMapper.selectByExample(example);
        PageInfo<RelaMerProCom> pageInfo = new PageInfo<>(list);
        return new TableJsonResult(pageInfo.getTotal(), list);
    }
    public TableJsonResult getUnRelaProMerComListForTable(int limit ,int page){
        PageHelper.startPage(page,limit);
        RelaMerProComExample example = new RelaMerProComExample();
        RelaMerProComExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        List<RelaMerProCom> list = relaMerProComMapper.selectByExample(example);
        PageInfo<RelaMerProCom> pageInfo = new PageInfo<>(list);
        return new TableJsonResult(pageInfo.getTotal(), list);
    }
}
