package com.brave.feature.service;

import com.brave.feature.mapper.homepage.ThisticketMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class ThisticketService
{
    private ThisticketMapper writeMapper;
    private ThisticketMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((ThisticketMapper)sqlSession.getMapper(ThisticketMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((ThisticketMapper)sqlSession.getMapper(ThisticketMapper.class));
    }

    public List<Map<String, Object>> selectThisticketList(Map<String, Object> param)
    {
        return this.readMapper.selectThisticketList(param);
    }

    public int insertThisticket(Map<String, Object> param)
    {
        return this.writeMapper.insertThisticket(param);
    }

    public int updateThisticketViewtimes(Map<String, Object> param)
    {
        return this.writeMapper.updateThisticketViewtimes(param);
    }

    public int selectThisticketAmount()
    {
        return this.readMapper.selectThisticketAmount();
    }
}
