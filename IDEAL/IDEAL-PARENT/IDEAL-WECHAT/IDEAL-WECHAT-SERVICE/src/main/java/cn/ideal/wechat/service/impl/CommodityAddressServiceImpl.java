package cn.ideal.wechat.service.impl;

import cn.ideal.common.mapper.CommodityAddressMapper;
import cn.ideal.common.pojo.CommodityAddress;
import cn.ideal.common.pojo.CommodityAddressExample;
import cn.ideal.common.results.MessageResult;
import cn.ideal.wechat.service.CommodityAddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author XINER
 * @create 2019-03-05 22:55
 * @desc
 **/
public class CommodityAddressServiceImpl implements CommodityAddressService {

    @Autowired
    private CommodityAddressMapper commodityAddressMapper;

    @Override
    public MessageResult getAddressList(Long uid) {

        CommodityAddressExample example = new CommodityAddressExample();
        CommodityAddressExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(uid);
        List<CommodityAddress> addressList = commodityAddressMapper.selectByExample(example);
        return MessageResult.ok(addressList);
    }

    @Override
    public MessageResult addAddressItem(CommodityAddress address) throws UnsupportedEncodingException {
        address.setAddress(new String(address.getAddress().getBytes("ISO8859-1"), "UTF-8"));
        address.setFullRegion(new String(address.getFullRegion().getBytes("ISO8859-1"), "UTF-8"));
        address.setName(new String(address.getName().getBytes("ISO8859-1"), "UTF-8"));
        commodityAddressMapper.insert(address);
        return MessageResult.ok();
    }

    @Override
    public MessageResult deleteAddressItem(Long id) {
        commodityAddressMapper.deleteByPrimaryKey(id);
        return MessageResult.ok();
    }


}
