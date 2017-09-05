package com.brave.feature.service;

import com.brave.feature.entity.JcAreas;
import com.brave.feature.entity.JcAreasExample;
import com.brave.feature.mapper.areas.JcAreasMapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class AreaService
{
    private JcAreasMapper writeMapper;
    private JcAreasMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((JcAreasMapper)sqlSession.getMapper(JcAreasMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((JcAreasMapper)sqlSession.getMapper(JcAreasMapper.class));
    }

    public int countByExample(JcAreasExample example)
    {
        return this.readMapper.countByExample(example);
    }

    public int deleteByExample(JcAreasExample example)
    {
        return this.writeMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Integer id)
    {
        return this.writeMapper.deleteByPrimaryKey(id);
    }

    public int insert(JcAreas record)
    {
        return this.writeMapper.insert(record);
    }

    public int insertSelective(JcAreas record)
    {
        return this.writeMapper.insertSelective(record);
    }

    public List<JcAreas> selectByExample(JcAreasExample example)
    {
        return this.readMapper.selectByExample(example);
    }

    public JcAreas selectByPrimaryKey(Integer id)
    {
        return this.readMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(JcAreas record, JcAreasExample example)
    {
        return this.writeMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(JcAreas record, JcAreasExample example)
    {
        return this.writeMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(JcAreas record)
    {
        return this.writeMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(JcAreas record)
    {
        return this.writeMapper.updateByPrimaryKey(record);
    }

    public String selectCityByProvinceId(String pid)
    {
        return this.readMapper.selectCityByProvinceId(pid);
    }
}
