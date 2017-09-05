package com.brave.feature.service;

import com.brave.feature.mapper.userinfo.ImageMapper;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class ImageService
{
    private ImageMapper writeMapper;
    private ImageMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((ImageMapper)sqlSession.getMapper(ImageMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((ImageMapper)sqlSession.getMapper(ImageMapper.class));
    }

    public int updateUserinfoImage(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoImage(param);
    }
}
