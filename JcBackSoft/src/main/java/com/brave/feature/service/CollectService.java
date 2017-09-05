package com.brave.feature.service;

import com.brave.feature.mapper.collect.CollectMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class CollectService
{
    private CollectMapper writeMapper;
    private CollectMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((CollectMapper)sqlSession.getMapper(CollectMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((CollectMapper)sqlSession.getMapper(CollectMapper.class));
    }

    public List<Map<String, Object>> selectCollectByUsername(String Username)
    {
        return this.readMapper.selectCollectByUsername(Username);
    }

    public int insertCollect(Map<String, Object> param)
    {
        return this.writeMapper.insertCollect(param);
    }

    public int updateCollectPhone(Map<String, Object> param)
    {
        return this.writeMapper.updateCollectPhone(param);
    }

    public int deleteCollectById(Map<String, Object> param)
    {
        return this.writeMapper.deleteCollectById(param);
    }

    public int deleteCollectByIdUsername(Map<String, Object> param)
    {
        return this.writeMapper.deleteCollectByIdUsername(param);
    }

    public List<Map<String, Object>> selectCollectById(Map<String, Object> param)
    {
        return this.readMapper.selectCollectById(param);
    }
}
