package cn.ideal.manager.service.impl;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.pojo.TableJsonResult;
import cn.ideal.common.utils.IDUtils;
import cn.ideal.manager.service.ProductorManagerService;
import cn.ideal.mapper.AccountProductorMapper;
import cn.ideal.pojo.AccountProductor;
import cn.ideal.pojo.AccountProductorExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductorManagerServiceImpl implements ProductorManagerService {

    @Autowired
    private AccountProductorMapper accountProductorMapper;
    /**
     * 初始化生产商注册信息表
     * @return
     */
    @Override
    public TableJsonResult getProductorListForTable(int page, int limit) {
        PageHelper.startPage(page,limit);
        AccountProductorExample example = new AccountProductorExample();
        AccountProductorExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        List<AccountProductor> list = accountProductorMapper.selectByExample(example);
        //取查询结果(分页)
        TableJsonResult tableJsonResult = new TableJsonResult(list.size(),list);
        return tableJsonResult;
    }

    /**
     * 修改注册用户的申请
     * @param id
     * @return
     */
    @Override
    public MessageResult editProductorStatus(String id) {
        //解析字符串
        List<String> idlist = IDUtils.SplitString(id);
        for(int i=0;i<idlist.size();i++){
            //将选中的状态从0改为1
            AccountProductor accountProductor = accountProductorMapper.selectByPrimaryKey(Long.valueOf(idlist.get(i)));
            accountProductor.setStatus(1);
            accountProductorMapper.updateByPrimaryKey(accountProductor);
        }
        return MessageResult.ok();
    }

    @Override
    public MessageResult deleteProductor(String id) {
        //解析字符串

        List<String> idlist = IDUtils.SplitString(id);
        for(int i=0;i<idlist.size();i++){
            accountProductorMapper.deleteByPrimaryKey(Long.valueOf(idlist.get(i)));
        }
        return MessageResult.ok("删除成功");
    }

    @Override
    public TableJsonResult getAllowedProductorListForTable(int page, int limit) {
        PageHelper.startPage(page,limit);
        AccountProductorExample example = new AccountProductorExample();
        AccountProductorExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        List<AccountProductor> list = accountProductorMapper.selectByExample(example);
        //取查询结果(分页)
        PageInfo<AccountProductor> pageInfo = new PageInfo<>(list);
        TableJsonResult tableJsonResult = new TableJsonResult(list.size(),list);
        return tableJsonResult;
    }

    /**
     * 将已通过的用户进行封号操作，将status从1改为2
     * @param id
     * @return
     */
    @Override
    public MessageResult clockProductor(String id) {
        //解析字符串
        List<String> idlist = IDUtils.SplitString(id);
        for(int i=0;i<idlist.size();i++){
            AccountProductor accountProductor = accountProductorMapper.selectByPrimaryKey(Long.valueOf(idlist.get(i)));
            accountProductor.setStatus(2);
            accountProductorMapper.updateByPrimaryKey(accountProductor);
        }
        return MessageResult.ok();
    }

    @Override
    public TableJsonResult getClockProductorListForTable(int page, int limit) {
        PageHelper.startPage(page,limit);
        AccountProductorExample example = new AccountProductorExample();
        AccountProductorExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(2);
        List<AccountProductor> list = accountProductorMapper.selectByExample(example);
        //取查询结果(分页)

        TableJsonResult tableJsonResult = new TableJsonResult(list.size(),list);
        return tableJsonResult;
    }

    /**
     * 将选中的status从2改为1
     * @param id
     * @return
     */
    @Override
    public MessageResult unClockProductor(String id) {

        //解析字符串
        List<String> idlist = IDUtils.SplitString(id);
        for(int i=0;i<idlist.size();i++){
            AccountProductor accountProductor = accountProductorMapper.selectByPrimaryKey(Long.valueOf(idlist.get(i)));
            accountProductor.setStatus(1);
            accountProductorMapper.updateByPrimaryKey(accountProductor);
        }
        return MessageResult.ok();
    }
}
