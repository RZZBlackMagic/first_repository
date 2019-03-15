package cn.ideal.portal.service;

import cn.ideal.common.results.MessageResult;

import javax.print.attribute.standard.MediaSize;

public interface CartService {
    MessageResult getCommodityForCart(Long id);
}
