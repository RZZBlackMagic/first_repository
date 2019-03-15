package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommodityStore;
import cn.ideal.common.pojo.CommodityStoreExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityStoreMapper {
    long countByExample(CommodityStoreExample example);

    int deleteByExample(CommodityStoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommodityStore record);

    int insertSelective(CommodityStore record);

    List<CommodityStore> selectByExample(CommodityStoreExample example);

    CommodityStore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommodityStore record, @Param("example") CommodityStoreExample example);

    int updateByExample(@Param("record") CommodityStore record, @Param("example") CommodityStoreExample example);

    int updateByPrimaryKeySelective(CommodityStore record);

    int updateByPrimaryKey(CommodityStore record);
}