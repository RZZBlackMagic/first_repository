package cn.ideal.search.service;

import cn.ideal.common.results.TableJsonResult;


public interface SearchService {

    TableJsonResult search(String queryString, Integer page, Integer rows) throws Exception;
}
