package cn.ideal.search.mapper;

import cn.ideal.common.results.SearchJsonResult;

import java.util.List;

public interface SearchCommodityMapper {

    List<SearchJsonResult> getCommodityList();

    SearchJsonResult getItemById(long itemId);
}
