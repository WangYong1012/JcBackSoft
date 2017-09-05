package com.brave.feature.service;

import com.brave.feature.mapper.homepage.SupportersMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class SupporterService
{
    private SupportersMapper writeMapper;
    private SupportersMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((SupportersMapper)sqlSession.getMapper(SupportersMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((SupportersMapper)sqlSession.getMapper(SupportersMapper.class));
    }

    public List<Map<String, Object>> selectSupportersAllByName(String username)
    {
        return this.readMapper.selectSupportersAllByName(username);
    }

    public List<Map<String, Object>> screenSupportersByCondition(String Sql)
    {
        return this.readMapper.screenSupportersByCondition(Sql);
    }

    public List<Map<String, Object>> selectSupportersData()
    {
        return this.readMapper.selectSupportersData();
    }

    public List<Map<String, Object>> selectSupportersDataById(String SupportersId)
    {
        return this.readMapper.selectSupportersDataById(SupportersId);
    }

    public List<Map<String, Object>> selectSupportersDataByEndorsement(String Endorsement)
    {
        return this.readMapper.selectSupportersDataByEndorsement(Endorsement);
    }

    public List<Map<String, Object>> selectPushstatrsupportersByName(String Username)
    {
        return this.readMapper.selectPushstatrsupportersByName(Username);
    }

    public List<Map<String, Object>> selectSupportersQuantity()
    {
        return this.readMapper.selectSupportersQuantity();
    }

    public List<Map<String, Object>> selectSupportersByType(String Type)
    {
        return this.readMapper.selectSupportersByType(Type);
    }

    public List<Map<String, Object>> selectCommonUser(int Num)
    {
        return this.readMapper.selectCommonUser(Num);
    }

    public List<Map<String, Object>> selectSupportersDataByPage(Map<String, Object> param)
    {
        return this.readMapper.selectSupportersDataByPage(param);
    }

    public int selectSupportersAmountByIssuetime(String Issuetime)
    {
        return this.readMapper.selectSupportersAmountByIssuetime(Issuetime);
    }

    public List<Map<String, Object>> selectSupportersState(String username)
    {
        return this.readMapper.selectSupportersState(username);
    }

    public List<Map<String, Object>> selectSupportersInfoByPage(Map<String, Object> param)
    {
        return this.readMapper.selectSupportersInfoByPage(param);
    }

    public int updateSupportersPhone(Map<String, Object> param)
    {
        return this.writeMapper.updateSupportersPhone(param);
    }

    public int deleteSupportersById(Map<String, Object> param)
    {
        return this.writeMapper.deleteSupportersById(param);
    }

    public int updateSupportersTitude(Map<String, Object> param)
    {
        return this.writeMapper.updateSupportersTitude(param);
    }

    public int insertSupportersInfo(Map<String, Object> param)
    {
        return this.writeMapper.insertSupportersInfo(param);
    }

    public int updateSupportersCheckOut(Map<String, Object> param)
    {
        return this.writeMapper.updateSupportersCheckOut(param);
    }

    public int updateSupportersCollectstateZero(Map<String, Object> param)
    {
        return this.writeMapper.updateSupportersCollectstateZero(param);
    }

    public int updateSupportersCollectstateOne(Map<String, Object> param)
    {
        return this.writeMapper.updateSupportersCollectstateOne(param);
    }
}
