package cn.ideal.common.mapper;

import cn.ideal.common.pojo.AccountMerchant;
import cn.ideal.common.pojo.AccountMerchantExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMerchantMapper {
    int countByExample(AccountMerchantExample example);

    int deleteByExample(AccountMerchantExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountMerchant record);

    int insertSelective(AccountMerchant record);

    List<AccountMerchant> selectByExample(AccountMerchantExample example);

    AccountMerchant selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccountMerchant record, @Param("example") AccountMerchantExample example);

    int updateByExample(@Param("record") AccountMerchant record, @Param("example") AccountMerchantExample example);

    int updateByPrimaryKeySelective(AccountMerchant record);

    int updateByPrimaryKey(AccountMerchant record);
}