package com.brave.feature.service;

import com.brave.feature.entity.JcUserBalance;
import com.brave.feature.entity.JcUserBalanceExample;
import com.brave.feature.mapper.userbalance.JcUserBalanceMapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class UserBalanceService
{
    private JcUserBalanceMapper writeMapper;
    private JcUserBalanceMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((JcUserBalanceMapper)sqlSession.getMapper(JcUserBalanceMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((JcUserBalanceMapper)sqlSession.getMapper(JcUserBalanceMapper.class));
    }

    public int countByExample(JcUserBalanceExample example)
    {
        return this.readMapper.countByExample(example);
    }

    public int deleteByExample(JcUserBalanceExample example)
    {
        return this.writeMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Integer id)
    {
        return this.writeMapper.deleteByPrimaryKey(id);
    }

    public int insert(JcUserBalance record)
    {
        return this.writeMapper.insert(record);
    }

    public int insertSelective(JcUserBalance record)
    {
        return this.writeMapper.insertSelective(record);
    }

    public List<JcUserBalance> selectByExample(JcUserBalanceExample example)
    {
        return this.readMapper.selectByExample(example);
    }

    public JcUserBalance selectByPrimaryKey(Integer id)
    {
        return this.readMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(JcUserBalance record, JcUserBalanceExample example)
    {
        return this.writeMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(JcUserBalance record, JcUserBalanceExample example)
    {
        return this.writeMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(JcUserBalance record)
    {
        return this.writeMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(JcUserBalance record)
    {
        return this.writeMapper.updateByPrimaryKey(record);
    }
}
