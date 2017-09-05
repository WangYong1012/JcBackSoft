package com.brave.feature.service;

import com.brave.feature.entity.JcAuthentication;
import com.brave.feature.entity.JcAuthenticationExample;
import com.brave.feature.mapper.authentication.JcAuthenticationMapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService
{
    private JcAuthenticationMapper writeMapper;
    private JcAuthenticationMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((JcAuthenticationMapper)sqlSession.getMapper(JcAuthenticationMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((JcAuthenticationMapper)sqlSession.getMapper(JcAuthenticationMapper.class));
    }

    public int countByExample(JcAuthenticationExample example)
    {
        return this.readMapper.countByExample(example);
    }

    public int deleteByExample(JcAuthenticationExample example)
    {
        return this.writeMapper.deleteByExample(example);
    }

    public int insert(JcAuthentication record)
    {
        return this.writeMapper.insert(record);
    }

    public int insertSelective(JcAuthentication record)
    {
        return this.writeMapper.insertSelective(record);
    }

    public List<JcAuthentication> selectByExample(JcAuthenticationExample example)
    {
        return this.readMapper.selectByExample(example);
    }

    public int updateByExampleSelective(JcAuthentication record, JcAuthenticationExample example)
    {
        return this.writeMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(JcAuthentication record, JcAuthenticationExample example)
    {
        return this.writeMapper.updateByExample(record, example);
    }
}
