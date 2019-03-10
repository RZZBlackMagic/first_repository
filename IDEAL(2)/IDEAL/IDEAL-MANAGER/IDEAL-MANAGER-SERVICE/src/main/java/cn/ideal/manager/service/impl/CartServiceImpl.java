package cn.ideal.manager.service.impl;

import cn.ideal.common.mapper.CommodityAddressMapper;
import cn.ideal.common.pojo.CommodityAddress;
import cn.ideal.common.pojo.CommodityAddressExample;
import cn.ideal.common.results.MessageResult;
import cn.ideal.manager.service.CartService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CommodityAddressMapper commodityAddressMapper;
    @Override
    public MessageResult insertAddress(CommodityAddress commodityAddress) {
        CommodityAddressExample example = new CommodityAddressExample();
        CommodityAddressExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(commodityAddress.getUserId());
        List<CommodityAddress> oldList = commodityAddressMapper.selectByExample(example);
        for(int i=0;i<oldList.size();i++){
            if(oldList.get(i).getAddress().equals(commodityAddress.getFullRegion())&&
                    oldList.get(i).getAddressTag().equals(commodityAddress.getAddressTag())&&
                    oldList.get(i).getAddress().equals(commodityAddress.getAddress())&&
                    oldList.get(i).getMobile().equals(commodityAddress.getMobile())&&
                    oldList.get(i).getName().equals(commodityAddress.getName())&&
                    oldList.get(i).getZip().equals(commodityAddress.getZip())){
                return MessageResult.ok("该地址已存在");
            }
        }
        commodityAddressMapper.insert(commodityAddress);
        return MessageResult.ok("地址存储成功");
    }

    @Override
    public MessageResult getAddressList() {
        CommodityAddressExample example = new CommodityAddressExample();
        List<CommodityAddress> list = commodityAddressMapper.selectByExample(example);
        return MessageResult.ok(list);
    }
}
