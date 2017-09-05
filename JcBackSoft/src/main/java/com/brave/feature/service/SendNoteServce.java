package com.brave.feature.service;

import com.brave.feature.mapper.homepage.SendNoteMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class SendNoteServce
{
    private SendNoteMapper writeMapper;
    private SendNoteMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((SendNoteMapper)sqlSession.getMapper(SendNoteMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((SendNoteMapper)sqlSession.getMapper(SendNoteMapper.class));
    }

    public List<Map<String, Object>> selectSendNote(Map<String, Object> param)
    {
        return this.readMapper.selectSendNote(param);
    }

    public int insertSendnote(Map<String, Object> param)
    {
        return this.writeMapper.insertSendnote(param);
    }
}
