package cn.ideal.merchant.service.impl;

import cn.ideal.common.mapper.AccountProductorMapper;
import cn.ideal.common.mapper.CommoditySpuMapper;
import cn.ideal.common.mapper.RelaMerProComMapper;
import cn.ideal.common.mapper.RelaMerProMapper;
import cn.ideal.common.pojo.*;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.merchant.service.ApplyMerchantService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

@Service
public class ApplyMerchantServiceImpl implements ApplyMerchantService {

    @Autowired
    private RelaMerProMapper relaMerProMapper;

    @Autowired
    private AccountProductorMapper accountProductorMapper;
    @Autowired
    private CommoditySpuMapper commoditySpuMapper;
    @Autowired
    private RelaMerProComMapper relaMerProComMapper;

    /**
     * 代理商申请代理，在生产商表中去查找生产商，将其添加在rela_mer_pro表中，状态为0（未同意)
     *
     * @param limit
     * @param page
     * @param search
     * @return
     */
    public TableJsonResult getCompanyListForTable(Integer limit, Integer page, String search) {
        PageHelper.startPage(page, limit);
        AccountProductorExample example = new AccountProductorExample();
        AccountProductorExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyZhEqualTo(search);
        List<AccountProductor> list = accountProductorMapper.selectByExample(example);
        PageInfo<AccountProductor> pageInfo = new PageInfo<>(list);
        return new TableJsonResult(pageInfo.getTotal(), list);
    }

    /**
     * 先去关系表中查找，如果没有就可以直接申请，如果有就提示用户民已经是该生产商的代理
     *
     * @return
     */
    public MessageResult ApplyCompany(RelaMerPro relaMerPro) {
        RelaMerProExample example = new RelaMerProExample();
        RelaMerProExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(relaMerPro.getMerchantId());
        criteria.andProductorIdEqualTo(relaMerPro.getProductorId());
        List list = relaMerProMapper.selectByExample(example);
        if (list.size() == 0) {
            relaMerPro.setApplyTime(new Date(System.currentTimeMillis()));
            relaMerPro.setAgreeTime(null);
            relaMerPro.setStatus(0);//未同意
            int row = relaMerProMapper.insert(relaMerPro);
            if (row == 1) {
                return MessageResult.ok("申请成功");
            }
            return MessageResult.build(400, "申请失败");
        } else {
            return MessageResult.build(400, "您已经是该生产商的代理");
        }

    }

    /**
     * 初始化已代理公司列表
     *
     * @param limit
     * @param page
     * @param merchantId
     * @return
     */
    public TableJsonResult getAppliedComListForTable(int limit, int page, Long merchantId) {
        PageHelper.startPage(page, limit);
        RelaMerProExample example = new RelaMerProExample();
        RelaMerProExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(merchantId);
        criteria.andStatusEqualTo(1);
        List<RelaMerPro> list = relaMerProMapper.selectByExample(example);
        PageInfo<RelaMerPro> pageInfo = new PageInfo<>(list);
        return new TableJsonResult(pageInfo.getTotal(), list);
    }

    /**
     * 根据生产者的Id去commodity_spu表里面查询生产者的所有商品，加载Table
     *
     * @param productorId
     * @return
     */
    public TableJsonResult getCommdityListForMer(int limit, int page, String productorId) {
        PageHelper.startPage(page, limit);
        CommoditySpuExample example = new CommoditySpuExample();
        CommoditySpuExample.Criteria criteria = example.createCriteria();
        criteria.andApidEqualTo(Long.valueOf(productorId));
        List<CommoditySpu> list = commoditySpuMapper.selectByExample(example);
        PageInfo<CommoditySpu> pageInfo = new PageInfo<>(list);
        return new TableJsonResult(pageInfo.getTotal(), list);
    }

    public MessageResult ApplyCommodityForMer(String id, Long merchantId, Long productorId, String productorName, String merchantName) {
        String[] idList = id.split(",");
        for (String cid : idList) {
            RelaMerProCom com = relaMerProComMapper.selectByPrimaryKey(new RelaMerProComKey(merchantId, productorId, Long.valueOf(cid)));
            if (com != null) {
                return MessageResult.build(400, "你已经代理该商品");
            }
            String commodityName = commoditySpuMapper.selectByPrimaryKey(Long.valueOf(cid)).getTitle();
            RelaMerProCom relaMerProCom = new RelaMerProCom(merchantId, productorId, Long.valueOf(cid), new Date(System.currentTimeMillis()), merchantName, productorName, commodityName, 0);
            if (relaMerProComMapper.insert(relaMerProCom) == 0) {
                return MessageResult.build(400, "申请失败");
            }
        }
        return MessageResult.ok();
    }
}
