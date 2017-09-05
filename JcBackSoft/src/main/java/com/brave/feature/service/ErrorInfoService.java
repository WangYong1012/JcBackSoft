package com.brave.feature.service;

import com.brave.feature.mapper.homepage.ErrorinfoMapper;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class ErrorInfoService
{
    private ErrorinfoMapper writeMapper;
    private ErrorinfoMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((ErrorinfoMapper)sqlSession.getMapper(ErrorinfoMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((ErrorinfoMapper)sqlSession.getMapper(ErrorinfoMapper.class));
    }

    public int insertErrorInfo(Map<String, Object> param)
    {
        return this.writeMapper.insertErrorInfo(param);
    }

    public int updateErrorInfo(Map<String, Object> param)
    {
        return this.writeMapper.updateErrorInfo(param);
    }
}
