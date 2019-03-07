package cn.ideal.wechat.service;

import cn.ideal.common.pojo.CommodityAddress;
import cn.ideal.common.results.MessageResult;

import java.io.UnsupportedEncodingException;
import java.rmi.MarshalException;

/**
 * @author XINER
 * @create 2019-03-05 22:56
 * @desc
 **/
public interface CommodityAddressService {

    MessageResult getAddressList(Long uid);

    MessageResult addAddressItem(CommodityAddress address) throws UnsupportedEncodingException;

    MessageResult deleteAddressItem(Long id);
}
