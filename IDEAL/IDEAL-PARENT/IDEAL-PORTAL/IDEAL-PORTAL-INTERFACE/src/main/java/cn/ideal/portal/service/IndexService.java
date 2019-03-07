package cn.ideal.portal.service;

import cn.ideal.common.results.MessageResult;

public interface IndexService {

    MessageResult getSlidePicture(Long category_id);

    MessageResult getMainCategory(Long pid);
}
