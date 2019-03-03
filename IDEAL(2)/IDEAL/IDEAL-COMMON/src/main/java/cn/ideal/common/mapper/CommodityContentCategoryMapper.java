package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommodityContentCategory;
import cn.ideal.common.pojo.CommodityContentCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityContentCategoryMapper {
    int countByExample(CommodityContentCategoryExample example);

    int deleteByExample(CommodityContentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommodityContentCategory record);

    int insertSelective(CommodityContentCategory record);

    List<CommodityContentCategory> selectByExample(CommodityContentCategoryExample example);

    CommodityContentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommodityContentCategory record, @Param("example") CommodityContentCategoryExample example);

    int updateByExample(@Param("record") CommodityContentCategory record, @Param("example") CommodityContentCategoryExample example);

    int updateByPrimaryKeySelective(CommodityContentCategory record);

    int updateByPrimaryKey(CommodityContentCategory record);
}