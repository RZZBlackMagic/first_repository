package com.ideal.mapper;

import com.ideal.pojo.CommodityContentCategory;
import com.ideal.pojo.CommodityContentCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityContentCategoryMapper {
    int countByExample(CommodityContentCategoryExample example);

    int deleteByExample(CommodityContentCategoryExample example);

    int insert(CommodityContentCategory record);

    int insertSelective(CommodityContentCategory record);

    List<CommodityContentCategory> selectByExample(CommodityContentCategoryExample example);

    int updateByExampleSelective(@Param("record") CommodityContentCategory record, @Param("example") CommodityContentCategoryExample example);

    int updateByExample(@Param("record") CommodityContentCategory record, @Param("example") CommodityContentCategoryExample example);
}