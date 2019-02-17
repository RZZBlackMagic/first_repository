package cn.ideal.merchant.service.impl;

import cn.ideal.mapper.AccountProductorMapper;
import cn.ideal.mapper.RelaMerProMapper;
import cn.ideal.merchant.service.ApplyMerchantService;
import cn.ideal.pojo.*;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

@Service
public class ApplyMerchantServiceImpl implements ApplyMerchantService {

    @Autowired
    private RelaMerProMapper relaMerProMapper;

    @Autowired
    private AccountProductorMapper accountProductorMapper;
    /**
     * 代理商申请代理，在生产商表中去查找生产商，将其添加在rela_mer_pro表中，状态为0（未同意)
     * @param limit
     * @param page
     * @param search
     * @return
     */
    public  List SearchCompanyForTable(String limit, String page, String search){
        System.out.println("Service********"+search);
        AccountProductorExample example = new AccountProductorExample();
        AccountProductorExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyzhEqualTo(search);
        List<AccountProductor> list = accountProductorMapper.selectByExample(example);


        return list;
    }

    /**
     * 先去关系表中查找，如果没有就可以直接申请，如果有就提示用户民已经是该生产商的代理
     * @param merchantId
     * @param merchantName
     * @param productorId
     * @param productorName
     * @return
     */
    public String ApplyCompany(Long merchantId,String merchantName,Long productorId,String productorName){
        RelaMerProExample example = new RelaMerProExample();
        RelaMerProExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(merchantId);
        criteria.andProductorIdEqualTo(productorId);
        List list = relaMerProMapper.selectByExample(example);

        if(list==null){
            RelaMerPro relaMerPro = new RelaMerPro();
            relaMerPro.setApplyTime(new Date(System.currentTimeMillis()));
            relaMerPro.setAgreeTime(null);
            relaMerPro.setMerchantId(merchantId);
            relaMerPro.setProductorId(productorId);
            relaMerPro.setMerchantName(merchantName);
            relaMerPro.setStatus(0);//未同意
            relaMerPro.setProductorName(productorName);
            int row = relaMerProMapper.insert(relaMerPro);
            if(row==1){
                return "申请成功";
            }
            return "申请失败";
        }else{
            return "您已经是该生产商的代理";
        }

    }
    public List initAppliedComTable(int limit,int page,Long merchantId){
        System.out.println("****************服务层"+merchantId);
        RelaMerProExample example = new RelaMerProExample();
        RelaMerProExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(merchantId);
        criteria.andStatusEqualTo(1);
        List list = relaMerProMapper.selectByExample(example);
        if(list==null){
            throw new RuntimeException("该公司不存在");
        }
        return list;
    }

    /**
     * 根据生产者的Id去查询生产者的所有商品，加载Table
     * @param productorId
     * @return
     */
    public List getCommdityForMer(String productorId){

        return null;
    }
}
