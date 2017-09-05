package com.brave.feature.service;

import com.brave.feature.mapper.news.NewsEntityMapper;
import com.brave.system.entity.NewsEntity;
import com.brave.system.entity.NewsEntityExample;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class NewService
{
    private NewsEntityMapper writeMapper;
    private NewsEntityMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((NewsEntityMapper)sqlSession.getMapper(NewsEntityMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((NewsEntityMapper)sqlSession.getMapper(NewsEntityMapper.class));
    }

    public int countByExample(NewsEntityExample example)
    {
        return this.readMapper.countByExample(example);
    }

    public int deleteByExample(NewsEntityExample example)
    {
        return this.writeMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String newsid)
    {
        return this.writeMapper.deleteByPrimaryKey(newsid);
    }

    public int insert(NewsEntity record)
    {
        return this.writeMapper.insert(record);
    }

    public int insertSelective(NewsEntity record)
    {
        return this.writeMapper.insertSelective(record);
    }

    public List<NewsEntity> selectByExample(NewsEntityExample example)
    {
        return this.readMapper.selectByExample(example);
    }

    public NewsEntity selectByPrimaryKey(String newsid)
    {
        return this.readMapper.selectByPrimaryKey(newsid);
    }

    public int updateByExampleSelective(NewsEntity record, NewsEntityExample example)
    {
        return this.writeMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(NewsEntity record, NewsEntityExample example)
    {
        return this.writeMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(NewsEntity record)
    {
        return this.writeMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(NewsEntity record)
    {
        return this.writeMapper.updateByPrimaryKey(record);
    }

    public int getMaxNewsId()
    {
        return this.readMapper.getMaxNewsId();
    }
}
