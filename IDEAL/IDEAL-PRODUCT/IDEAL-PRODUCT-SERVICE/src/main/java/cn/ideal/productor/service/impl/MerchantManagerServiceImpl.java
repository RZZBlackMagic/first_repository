package cn.ideal.productor.service.impl;

import cn.ideal.common.mapper.RelaMerProComMapper;
import cn.ideal.common.mapper.RelaMerProMapper;
import cn.ideal.common.pojo.RelaMerPro;
import cn.ideal.common.pojo.RelaMerProComExample;
import cn.ideal.common.pojo.RelaMerProExample;
import cn.ideal.common.pojo.RelaMerProKey;
import cn.ideal.common.results.MerchantRelaJsonResult;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.productor.service.MerchantManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class MerchantManagerServiceImpl implements MerchantManagerService {

    @Autowired
    private RelaMerProMapper relaMerProMapper;
    @Autowired
    private RelaMerProComMapper relaMerProComMapper;

    @Override
    public TableJsonResult getMerchantApplyList(Integer limit, Integer page, Long product_id) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        //查询
        RelaMerProExample example = new RelaMerProExample();
        RelaMerProExample.Criteria criteria = example.createCriteria();
        criteria.andProductorIdEqualTo(product_id);
        criteria.andStatusEqualTo(0);
        List<RelaMerPro> list = relaMerProMapper.selectByExample(example);
        //取查询结果
        PageInfo<RelaMerPro> pageInfo = new PageInfo<>(list);
        TableJsonResult result = new TableJsonResult(pageInfo.getTotal(), list);
        return result;
    }

    @Override
    public MessageResult handleMerchantApply(Long product_id, String merchant_id, String option) {
        for (String mid : merchant_id.split(",")){
            if (option.compareTo("AGREE") == 0)
                relaMerProMapper.updateByPrimaryKeySelective(new RelaMerPro(Long.parseLong(mid), product_id, null, null, null, 1, new Date(System.currentTimeMillis())));
            else if (option.compareTo("DELETE") == 0)
                relaMerProMapper.deleteByPrimaryKey(new RelaMerProKey(Long.parseLong(mid), product_id));
            else if (option.compareTo("LOCK") == 0){
                if (relaMerProMapper.selectByPrimaryKey(new RelaMerProKey(Long.parseLong(mid), product_id)).getStatus() == 1)
                    relaMerProMapper.updateByPrimaryKeySelective(new RelaMerPro(Long.parseLong(mid), product_id, null, null, null, 2, null));
                else
                    relaMerProMapper.updateByPrimaryKeySelective(new RelaMerPro(Long.parseLong(mid), product_id, null, null, null, 1, null));
            }
        }
        return MessageResult.ok(true);
    }

    @Override
    public TableJsonResult getMerchantManageList(Integer limit, Integer page, Long product_id) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        //查询
        RelaMerProExample example = new RelaMerProExample();
        RelaMerProExample.Criteria criteria = example.createCriteria();
        criteria.andProductorIdEqualTo(product_id);
        criteria.andStatusEqualTo(1);
        List<RelaMerPro> list = relaMerProMapper.selectByExample(example);
        List<MerchantRelaJsonResult> sList = new ArrayList<>();
        for (RelaMerPro cell : list){
            RelaMerProComExample example1 = new RelaMerProComExample();
            RelaMerProComExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andProductorIdEqualTo(product_id);
            criteria1.andMerchantIdEqualTo(cell.getMerchantId());
            sList.add(new MerchantRelaJsonResult(cell.getMerchantId(), cell.getProductorId(), cell.getApplyTime(), cell.getMerchantName(), cell.getProductorName(), cell.getStatus(), cell.getAgreeTime(), relaMerProComMapper.countByExample(example1)));
        }
        //取查询结果
        PageInfo<MerchantRelaJsonResult> pageInfo = new PageInfo<>(sList);
        TableJsonResult result = new TableJsonResult(pageInfo.getTotal(), sList);
        return result;
    }


}
