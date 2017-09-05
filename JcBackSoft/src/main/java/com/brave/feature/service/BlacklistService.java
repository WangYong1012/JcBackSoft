package com.brave.feature.service;

import com.brave.feature.mapper.black.BlacklistMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class BlacklistService
{
    private BlacklistMapper writeMapper;
    private BlacklistMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((BlacklistMapper)sqlSession.getMapper(BlacklistMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((BlacklistMapper)sqlSession.getMapper(BlacklistMapper.class));
    }

    public int insertBlacklist(String username)
    {
        return this.writeMapper.insertBlacklist(username);
    }

    public int deleteBlacklistByUsername(String username)
    {
        return this.writeMapper.deleteBlacklistByUsername(username);
    }
}
