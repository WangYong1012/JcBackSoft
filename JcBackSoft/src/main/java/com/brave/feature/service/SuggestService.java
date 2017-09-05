package com.brave.feature.service;

import com.brave.feature.mapper.homepage.SuggestMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class SuggestService
{
    private SuggestMapper writeMapper;
    private SuggestMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((SuggestMapper)sqlSession.getMapper(SuggestMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((SuggestMapper)sqlSession.getMapper(SuggestMapper.class));
    }

    public List<Map<String, Object>> selectSuggest()
    {
        return this.readMapper.selectSuggest();
    }

    public int deleteSuggestById(Map<String, Object> param)
    {
        return this.writeMapper.deleteSuggestById(param);
    }

    public int insertSuggest(Map<String, Object> param)
    {
        return this.writeMapper.insertSuggest(param);
    }

    public int updateSuggestById(Map<String, Object> param)
    {
        return this.writeMapper.updateSuggestById(param);
    }
}
