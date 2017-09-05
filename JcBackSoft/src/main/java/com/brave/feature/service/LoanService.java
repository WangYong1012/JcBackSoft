package com.brave.feature.service;

import com.brave.feature.mapper.homepage.LoanMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class LoanService
{
    private LoanMapper writeMapper;
    private LoanMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((LoanMapper)sqlSession.getMapper(LoanMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((LoanMapper)sqlSession.getMapper(LoanMapper.class));
    }

    public int insertLoaninfo(Map<String, Object> param)
    {
        return this.writeMapper.insertLoaninfo(param);
    }

    public List<Map<String, Object>> selectLenderList(Map<String, Object> param)
    {
        return this.readMapper.selectLenderList(param);
    }
}
