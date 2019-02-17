package cn.ideal.mapper;

import cn.ideal.pojo.CommodityCategory;
import cn.ideal.pojo.CommodityCategoryExample;
import cn.ideal.pojo.CommodityCategoryKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityCategoryMapper {
    int countByExample(CommodityCategoryExample example);

    int deleteByExample(CommodityCategoryExample example);

    int deleteByPrimaryKey(CommodityCategoryKey key);

    int insert(CommodityCategory record);

    int insertSelective(CommodityCategory record);

    List<CommodityCategory> selectByExample(CommodityCategoryExample example);

    CommodityCategory selectByPrimaryKey(CommodityCategoryKey key);

    int updateByExampleSelective(@Param("record") CommodityCategory record, @Param("example") CommodityCategoryExample example);

    int updateByExample(@Param("record") CommodityCategory record, @Param("example") CommodityCategoryExample example);

    int updateByPrimaryKeySelective(CommodityCategory record);

    int updateByPrimaryKey(CommodityCategory record);
}