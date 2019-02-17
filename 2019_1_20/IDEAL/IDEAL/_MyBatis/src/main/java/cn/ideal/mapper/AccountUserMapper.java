package cn.ideal.mapper;

import cn.ideal.pojo.AccountUser;
import cn.ideal.pojo.AccountUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountUserMapper {
    int countByExample(AccountUserExample example);

    int deleteByExample(AccountUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountUser record);

    int insertSelective(AccountUser record);

    List<AccountUser> selectByExample(AccountUserExample example);

    AccountUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccountUser record, @Param("example") AccountUserExample example);

    int updateByExample(@Param("record") AccountUser record, @Param("example") AccountUserExample example);

    int updateByPrimaryKeySelective(AccountUser record);

    int updateByPrimaryKey(AccountUser record);
}