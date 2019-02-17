package cn.ideal.mapper;

import cn.ideal.pojo.RelaMerchantProductor;
import cn.ideal.pojo.RelaMerchantProductorExample;
import cn.ideal.pojo.RelaMerchantProductorKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelaMerchantProductorMapper {
    int countByExample(RelaMerchantProductorExample example);

    int deleteByExample(RelaMerchantProductorExample example);

    int deleteByPrimaryKey(RelaMerchantProductorKey key);

    int insert(RelaMerchantProductor record);

    int insertSelective(RelaMerchantProductor record);

    List<RelaMerchantProductor> selectByExample(RelaMerchantProductorExample example);

    RelaMerchantProductor selectByPrimaryKey(RelaMerchantProductorKey key);

    int updateByExampleSelective(@Param("record") RelaMerchantProductor record, @Param("example") RelaMerchantProductorExample example);

    int updateByExample(@Param("record") RelaMerchantProductor record, @Param("example") RelaMerchantProductorExample example);

    int updateByPrimaryKeySelective(RelaMerchantProductor record);

    int updateByPrimaryKey(RelaMerchantProductor record);
}