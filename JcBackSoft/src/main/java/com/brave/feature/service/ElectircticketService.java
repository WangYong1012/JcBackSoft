package com.brave.feature.service;

import com.brave.feature.mapper.homepage.ElectricticketMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class ElectircticketService
{
    private ElectricticketMapper readMapper;

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((ElectricticketMapper)sqlSession.getMapper(ElectricticketMapper.class));
    }

    public List<Map<String, Object>> selectElectricTicketContent()
    {
        return this.readMapper.selectElectricTicketContent();
    }
}
