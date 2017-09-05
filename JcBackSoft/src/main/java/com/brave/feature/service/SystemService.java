package com.brave.feature.service;

import com.brave.feature.mapper.homepage.SystemMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class SystemService
{
    private SystemMapper writeMapper;
    private SystemMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((SystemMapper)sqlSession.getMapper(SystemMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((SystemMapper)sqlSession.getMapper(SystemMapper.class));
    }

    public List<Map<String, Object>> selectSystem()
    {
        return this.readMapper.selectSystem();
    }
}
