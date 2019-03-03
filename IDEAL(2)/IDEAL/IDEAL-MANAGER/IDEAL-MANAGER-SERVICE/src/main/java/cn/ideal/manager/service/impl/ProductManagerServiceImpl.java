package cn.ideal.manager.service.impl;

import cn.ideal.common.mapper.AccountProductorMapper;
import cn.ideal.common.pojo.AccountProductor;
import cn.ideal.common.pojo.AccountProductorExample;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.manager.service.ProductManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagerServiceImpl implements ProductManagerService {

    @Autowired
    private AccountProductorMapper accountProductorMapper;
    /**
     * 初始化生产商注册信息表
     * @return
     */
    @Override
    public TableJsonResult getProductListForTable(int page, int limit) {
        PageHelper.startPage(page,limit);
        AccountProductorExample example = new AccountProductorExample();
        AccountProductorExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        List<AccountProductor> list = accountProductorMapper.selectByExample(example);
        //取查询结果(分页)
        PageInfo<AccountProductor> pageInfo = new PageInfo<>(list);
        TableJsonResult tableJsonResult = new TableJsonResult(pageInfo.getTotal(),list);
        return tableJsonResult;
    }

    /**
     * 修改注册用户的申请
     * @param id
     * @return
     */
    @Override
    public MessageResult editProductStatus(String id) {
        //解析字符串
        String[] idList = id.split(",");
        for(int i = 0; i < idList.length; i++){
            //将选中的状态从0改为1
            AccountProductor accountProductor = accountProductorMapper.selectByPrimaryKey(Long.parseLong(idList[i]));
            accountProductor.setStatus(1);
            accountProductorMapper.updateByPrimaryKey(accountProductor);
        }
        return MessageResult.ok(true);
    }

    @Override
    public MessageResult deleteProduct(String id) {
        //解析字符串
        String[] idlist = id.split(",");
        for(int i = 0; i < idlist.length; i++){
            accountProductorMapper.deleteByPrimaryKey(Long.parseLong(idlist[i]));
        }
        return MessageResult.ok(true);
    }

    @Override
    public TableJsonResult allowProduct(int page, int limit) {
        PageHelper.startPage(page,limit);
        AccountProductorExample example = new AccountProductorExample();
        AccountProductorExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        List<AccountProductor> list = accountProductorMapper.selectByExample(example);
        //取查询结果(分页)
        PageInfo<AccountProductor> pageInfo = new PageInfo<>(list);
        TableJsonResult tableJsonResult = new TableJsonResult(pageInfo.getTotal(),list);
        return tableJsonResult;
    }

    /**
     * 将已通过的用户进行封号操作，将status从1改为2
     * @param id
     * @return
     */
    @Override
    public MessageResult lockProduct(String id) {
        //解析字符串
        String[] idList = id.split(",");
        for(int i = 0;i < idList.length; i++){
            AccountProductor accountProductor = accountProductorMapper.selectByPrimaryKey(Long.parseLong(idList[i]));
            accountProductor.setStatus(2);
            accountProductorMapper.updateByPrimaryKey(accountProductor);
        }
        return MessageResult.ok(true);
    }

    /**
     * 将选中的status从2改为1
     * @param id
     * @return
     */
    @Override
    public MessageResult unlockProduct(String id) {

        //解析字符串
        String[] idList = id.split(",");
        for(int i = 0; i < idList.length; i++){
            AccountProductor accountProductor = accountProductorMapper.selectByPrimaryKey(Long.parseLong(idList[i]));
            accountProductor.setStatus(1);
            accountProductorMapper.updateByPrimaryKey(accountProductor);
        }
        return MessageResult.ok(true);
    }

    @Override
    public TableJsonResult getLockProductForTable(int page, int limit) {
        PageHelper.startPage(page,limit);
        AccountProductorExample example = new AccountProductorExample();
        AccountProductorExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(2);
        List<AccountProductor> list = accountProductorMapper.selectByExample(example);
        //取查询结果(分页)
        PageInfo<AccountProductor> pageInfo = new PageInfo<>(list);
        TableJsonResult tableJsonResult = new TableJsonResult(pageInfo.getTotal(),list);
        return tableJsonResult;
    }
}
