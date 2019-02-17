package cn.ideal.mapper;

import cn.ideal.pojo.CommodityContentCategory;
import cn.ideal.pojo.CommodityContentCategoryExample;
import cn.ideal.pojo.CommodityContentCategoryKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityContentCategoryMapper {
    int countByExample(CommodityContentCategoryExample example);

    int deleteByExample(CommodityContentCategoryExample example);

    int deleteByPrimaryKey(CommodityContentCategoryKey key);

    int insert(CommodityContentCategory record);

    int insertSelective(CommodityContentCategory record);

    List<CommodityContentCategory> selectByExample(CommodityContentCategoryExample example);

    CommodityContentCategory selectByPrimaryKey(CommodityContentCategoryKey key);

    int updateByExampleSelective(@Param("record") CommodityContentCategory record, @Param("example") CommodityContentCategoryExample example);

    int updateByExample(@Param("record") CommodityContentCategory record, @Param("example") CommodityContentCategoryExample example);

    int updateByPrimaryKeySelective(CommodityContentCategory record);

    int updateByPrimaryKey(CommodityContentCategory record);
}