package cn.ideal.mapper;

import cn.ideal.pojo.CommoditySpu;
import cn.ideal.pojo.CommoditySpuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommoditySpuMapper {
    int countByExample(CommoditySpuExample example);

    int deleteByExample(CommoditySpuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommoditySpu record);

    int insertSelective(CommoditySpu record);

    List<CommoditySpu> selectByExample(CommoditySpuExample example);

    CommoditySpu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommoditySpu record, @Param("example") CommoditySpuExample example);

    int updateByExample(@Param("record") CommoditySpu record, @Param("example") CommoditySpuExample example);

    int updateByPrimaryKeySelective(CommoditySpu record);

    int updateByPrimaryKey(CommoditySpu record);
}