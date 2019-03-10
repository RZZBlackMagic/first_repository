package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommodityAddress;
import cn.ideal.common.pojo.CommodityAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityAddressMapper {
    int countByExample(CommodityAddressExample example);

    int deleteByExample(CommodityAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommodityAddress record);

    int insertSelective(CommodityAddress record);

    List<CommodityAddress> selectByExample(CommodityAddressExample example);

    CommodityAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommodityAddress record, @Param("example") CommodityAddressExample example);

    int updateByExample(@Param("record") CommodityAddress record, @Param("example") CommodityAddressExample example);

    int updateByPrimaryKeySelective(CommodityAddress record);

    int updateByPrimaryKey(CommodityAddress record);
}