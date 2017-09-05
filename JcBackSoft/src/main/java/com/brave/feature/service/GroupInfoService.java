package com.brave.feature.service;

import com.brave.feature.mapper.group.GroupinfoMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class GroupInfoService
{
    private GroupinfoMapper writeMapper;
    private GroupinfoMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((GroupinfoMapper)sqlSession.getMapper(GroupinfoMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((GroupinfoMapper)sqlSession.getMapper(GroupinfoMapper.class));
    }

    public List<Map<String, Object>> selectGroupinfoData(String Groupid)
    {
        return this.readMapper.selectGroupinfoData(Groupid);
    }

    public List<Map<String, Object>> SelectGroupinfoByMaster(String GroupMaster)
    {
        return this.readMapper.SelectGroupinfoByMaster(GroupMaster);
    }

    public List<Map<String, Object>> selectGroupinfoSummaryById(String Groupid)
    {
        return this.readMapper.selectGroupinfoSummaryById(Groupid);
    }

    public List<Map<String, Object>> selectGroupinfoRuleById(String Groupid)
    {
        return this.readMapper.selectGroupinfoRuleById(Groupid);
    }

    public List<Map<String, Object>> SelectGroupinfo()
    {
        return this.readMapper.SelectGroupinfo();
    }

    public List<Map<String, Object>> SelectGroupinfoIdAndProvince()
    {
        return this.readMapper.SelectGroupinfoIdAndProvince();
    }

    public int insertGroupinfo(Map<String, Object> param)
    {
        return this.writeMapper.insertGroupinfo(param);
    }

    public int updateGroupinfoDataById(Map<String, Object> param)
    {
        return this.writeMapper.updateGroupinfoDataById(param);
    }

    public int updateGroupinfoRule(Map<String, Object> param)
    {
        return this.writeMapper.updateGroupinfoRule(param);
    }

    public int updateGroupinfoSummary(Map<String, Object> param)
    {
        return this.writeMapper.updateGroupinfoSummary(param);
    }

    public int deleteGroupinfoById(Map<String, Object> param)
    {
        return this.writeMapper.deleteGroupinfoById(param);
    }
}
