package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommoditySpuSpeExample;
import cn.ideal.common.pojo.CommoditySpuSpeKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommoditySpuSpeMapper {
    int countByExample(CommoditySpuSpeExample example);

    int deleteByExample(CommoditySpuSpeExample example);

    int deleteByPrimaryKey(CommoditySpuSpeKey key);

    int insert(CommoditySpuSpeKey record);

    int insertSelective(CommoditySpuSpeKey record);

    List<CommoditySpuSpeKey> selectByExample(CommoditySpuSpeExample example);

    int updateByExampleSelective(@Param("record") CommoditySpuSpeKey record, @Param("example") CommoditySpuSpeExample example);

    int updateByExample(@Param("record") CommoditySpuSpeKey record, @Param("example") CommoditySpuSpeExample example);
}