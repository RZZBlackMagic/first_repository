package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommodityCart;
import cn.ideal.common.pojo.CommodityCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityCartMapper {
    int countByExample(CommodityCartExample example);

    int deleteByExample(CommodityCartExample example);

    int insert(CommodityCart record);

    int insertSelective(CommodityCart record);

    List<CommodityCart> selectByExample(CommodityCartExample example);

    int updateByExampleSelective(@Param("record") CommodityCart record, @Param("example") CommodityCartExample example);

    int updateByExample(@Param("record") CommodityCart record, @Param("example") CommodityCartExample example);
}