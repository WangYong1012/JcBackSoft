package com.brave.feature.service;

import com.brave.feature.mapper.homepage.FirsthandResourcesMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class FirsthandResourcesService
{
    private FirsthandResourcesMapper writeMapper;
    private FirsthandResourcesMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((FirsthandResourcesMapper)sqlSession.getMapper(FirsthandResourcesMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((FirsthandResourcesMapper)sqlSession.getMapper(FirsthandResourcesMapper.class));
    }

    public List<Map<String, Object>> selectFirsthandResourcesList(Map<String, Object> param)
    {
        return this.readMapper.selectFirsthandResourcesList(param);
    }

    public List<Map<String, Object>> selectAuthenticationInfo(String username)
    {
        return this.readMapper.selectAuthenticationInfo(username);
    }

    public List<Map<String, Object>> selectAuthenticationType()
    {
        return this.readMapper.selectAuthenticationType();
    }

    public List<Map<String, Object>> selectAuthenticationTypeByUsername(String username)
    {
        return this.readMapper.selectAuthenticationTypeByUsername(username);
    }

    public int update_firsthand(Map<String, Object> param)
    {
        return this.writeMapper.update_firsthand(param);
    }

    public int update_firsthand_status(Map<String, Object> param)
    {
        return this.writeMapper.update_firsthand_status(param);
    }

    public int insert_firsthand(Map<String, Object> param)
    {
        return this.writeMapper.insert_firsthand(param);
    }

    public List<Map<String, Object>> selectFirsthandByUsername(String username)
    {
        return this.readMapper.selectFirsthandByUsername(username);
    }

    public List<Map<String, Object>> selectAuthenticationRegionByUsername(String username)
    {
        return this.readMapper.selectAuthenticationRegionByUsername(username);
    }

    public List<Map<String, Object>> selectAuthenticationStatus(String username)
    {
        return this.readMapper.selectAuthenticationStatus(username);
    }

    public int updateAuthenticationStatus(Map<String, Object> param)
    {
        return this.writeMapper.updateAuthenticationStatus(param);
    }

    public int delete_firsthandByUsername(String username)
    {
        return this.writeMapper.delete_firsthandByUsername(username);
    }
}
