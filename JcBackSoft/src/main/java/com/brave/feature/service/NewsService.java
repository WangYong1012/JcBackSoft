package com.brave.feature.service;

import com.brave.feature.mapper.homepage.NewsMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class NewsService
{
    private NewsMapper writeMapper;
    private NewsMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((NewsMapper)sqlSession.getMapper(NewsMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((NewsMapper)sqlSession.getMapper(NewsMapper.class));
    }

    public List<Map<String, Object>> selectNews(Map<String, Object> param)
    {
        return this.readMapper.selectNewsList(param);
    }

    public List<Map<String, Object>> selectNewsByID(String id)
    {
        return this.readMapper.selectNewsByID(id);
    }

    public int selectNewsAmount()
    {
        return this.readMapper.selectNewsAmount();
    }

    public int insertNews(Map<String, Object> param)
    {
        return this.writeMapper.insertNews(param);
    }
}
