package cn.ideal.wechat.service;

import java.util.ArrayList;
import java.util.Map;

public interface CommodityCatService {

    Map<String, Object> catalogList();

    Map<String, Object> catalogCurrent(Long id);

    Map<String, Object> brotherCategory(Long id);

}
