package com.ideal.portal.service;

import com.ideal.common.pojo.TableJsonResult;

import java.util.List;

public interface ContentManagerService {

    public TableJsonResult initContentTableService(String id,int page,int limit);
    public String deleteContentService(String Id);
    public String addContent(String categoryId,String title,String subTitle,String titleDesc,String url ,String pic,String pic2 ,String content);
    public String editContentService(String id,String categoryId,String title,String subTitle,String titleDesc,String url,String pic,String pic2,String content);
}
