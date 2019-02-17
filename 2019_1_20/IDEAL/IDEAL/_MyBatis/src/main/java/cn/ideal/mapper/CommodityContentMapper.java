package cn.ideal.mapper;

import cn.ideal.pojo.CommodityContent;
import cn.ideal.pojo.CommodityContentExample;
import cn.ideal.pojo.CommodityContentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityContentMapper {
    int countByExample(CommodityContentExample example);

    int deleteByExample(CommodityContentExample example);

    int deleteByPrimaryKey(CommodityContentKey key);

    int insert(CommodityContent record);

    int insertSelective(CommodityContent record);

    List<CommodityContent> selectByExampleWithBLOBs(CommodityContentExample example);

    List<CommodityContent> selectByExample(CommodityContentExample example);

    CommodityContent selectByPrimaryKey(CommodityContentKey key);

    int updateByExampleSelective(@Param("record") CommodityContent record, @Param("example") CommodityContentExample example);

    int updateByExampleWithBLOBs(@Param("record") CommodityContent record, @Param("example") CommodityContentExample example);

    int updateByExample(@Param("record") CommodityContent record, @Param("example") CommodityContentExample example);

    int updateByPrimaryKeySelective(CommodityContent record);

    int updateByPrimaryKeyWithBLOBs(CommodityContent record);

    int updateByPrimaryKey(CommodityContent record);
}