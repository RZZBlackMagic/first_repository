package cn.ideal.manager.service.impl;

import cn.ideal.manager.service.MerchantManagerService;
import cn.ideal.mapper.RelaMerchantProductorMapper;
import cn.ideal.pojo.RelaMerchantProductor;
import cn.ideal.pojo.RelaMerchantProductorExample;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantManagerImpl implements MerchantManagerService {
    @Autowired
    private RelaMerchantProductorMapper relaMerchantProductorMapper;
    @Override
    public List<RelaMerchantProductor> initMerchantApplyTable() {
        System.out.println("哈哈哈哈哈哈哈啊哈哈");
        RelaMerchantProductorExample relaMerchantProductorExample = new RelaMerchantProductorExample();
        RelaMerchantProductorExample.Criteria criteria = relaMerchantProductorExample.createCriteria();
        List<RelaMerchantProductor> list = relaMerchantProductorMapper.selectByExample(relaMerchantProductorExample);
        List<RelaMerchantProductor> applyList = new ArrayList<RelaMerchantProductor>();
        List<RelaMerchantProductor> applyCommodityList = new ArrayList<>();
        for(RelaMerchantProductor relaMerchantProductor:list){
            if(relaMerchantProductor.getCommodityId()==null){
                applyList.add(relaMerchantProductor);
            }else{
                applyCommodityList.add(relaMerchantProductor);
            }
        }

        System.out.println("*88888888888888"+applyList);
        return applyList;
    }
}
