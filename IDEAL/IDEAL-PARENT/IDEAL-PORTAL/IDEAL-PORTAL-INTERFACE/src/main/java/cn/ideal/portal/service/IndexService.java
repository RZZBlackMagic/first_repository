package cn.ideal.portal.service;

import cn.ideal.common.results.MessageResult;

import java.util.Map;

public interface IndexService {

    MessageResult getSlidePicture(Long cid);

    Map<String, Object> getSlideContent();

    Map<String, Object> getAdContent();

    Map<String, Object> getContentList(Long pid);

}
