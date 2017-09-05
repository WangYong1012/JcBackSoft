package com.brave.feature.service;

import com.brave.feature.mapper.userinfo.UserinfoMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private UserinfoMapper writeMapper;
    private UserinfoMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((UserinfoMapper)sqlSession.getMapper(UserinfoMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((UserinfoMapper)sqlSession.getMapper(UserinfoMapper.class));
    }

    public List<Map<String, Object>> selectMydata(Map<String, Object> param)
    {
        return this.readMapper.selectMyDataInfo(param);
    }

    public List<Map<String, Object>> selectAuthenticationStatusList()
    {
        return this.readMapper.selectAuthenticationStatusList();
    }

    public List<Map<String, Object>> selectUserDataInfoByHxid(String HuanxinId)
    {
        return this.readMapper.selectUserDataInfoByHxid(HuanxinId);
    }

    public List<Map<String, Object>> selectUserScore(Map<String, Object> param)
    {
        return this.readMapper.selectUserScore(param);
    }

    public List<Map<String, Object>> selectUserScoreByTrueName(String TrueName)
    {
        return this.readMapper.selectUserScoreByTrueName(TrueName);
    }

    public List<Map<String, Object>> selectUserChannelidByAd()
    {
        return this.readMapper.selectUserChannelidByAd();
    }

    public List<Map<String, Object>> selectUserChannelidByIos()
    {
        return this.readMapper.selectUserChannelidByIos();
    }

    public List<Map<String, Object>> SelectPhoneUsername(String Data)
    {
        return this.readMapper.SelectPhoneUsername(Data);
    }

    public List<Map<String, Object>> selectPhoneStateByUsername(Map<String, Object> param)
    {
        return this.readMapper.selectPhoneStateByUsername(param);
    }

    public List<Map<String, Object>> selectUserinfoByPhone(String Phone)
    {
        return this.readMapper.selectUserinfoByPhone(Phone);
    }

    public List<Map<String, Object>> selectBatchdataByHxid(String Hxid)
    {
        return this.readMapper.selectBatchdataByHxid(Hxid);
    }

    public List<Map<String, Object>> selectAdminInfo()
    {
        return this.readMapper.selectAdminInfo();
    }

    public List<Map<String, Object>> selectRegisterstateIsOne()
    {
        return this.readMapper.selectRegisterstateIsOne();
    }

    public List<Map<String, Object>> selectUserDataByHxid(String Huanxinid)
    {
        return this.readMapper.selectUserDataByHxid(Huanxinid);
    }

    public List<Map<String, Object>> SelectUserinfoAreaPhone(String Phone)
    {
        return this.readMapper.SelectUserinfoAreaPhone(Phone);
    }

    public List<Map<String, Object>> selectTitudeAll()
    {
        return this.readMapper.selectTitudeAll();
    }

    public List<Map<String, Object>> selectUserinfoGrouptimeByName(String Name)
    {
        return this.readMapper.selectUserinfoGrouptimeByName(Name);
    }

    public List<Map<String, Object>> selectCurrentDateList(Map<String, Object> param)
    {
        return this.readMapper.selectCurrentDateList(param);
    }

    public List<Map<String, Object>> selectUserScoreOrDayByName(Map<String, Object> param)
    {
        return this.readMapper.selectUserScoreOrDayByName(param);
    }

    public List<Map<String, Object>> selectUserQiandaotimeByName(Map<String, Object> param)
    {
        return this.readMapper.selectUserQiandaotimeByName(param);
    }

    public List<Map<String, Object>> decideContinuous(Map<String, Object> param)
    {
        return this.readMapper.decideContinuous(param);
    }

    public List<Map<String, Object>> selectAllUserinfo()
    {
        return this.readMapper.selectAllUserinfo();
    }

    public List<Map<String, Object>> selectUserStateByusername(String username)
    {
        return this.readMapper.selectUserStateByusername(username);
    }

    public List<Map<String, Object>> selectUserTimeScoreOrDayByName(String username)
    {
        return this.readMapper.selectUserTimeScoreOrDayByName(username);
    }

    public List<Map<String, Object>> decideContinueSign(String username)
    {
        return this.readMapper.decideContinueSign(username);
    }

    public List<Map<String, Object>> selectUserChannelIdByAd1(String ChannelId)
    {
        return this.readMapper.selectUserChannelIdByAd1(ChannelId);
    }

    public List<Map<String, Object>> selectUserChannelIdByAd2()
    {
        return this.readMapper.selectUserChannelIdByAd2();
    }

    public List<Map<String, Object>> selectUserChannelIdByIos1(String ChannelId)
    {
        return this.readMapper.selectUserChannelIdByIos1(ChannelId);
    }

    public List<Map<String, Object>> selectUserChannelIdByIos2()
    {
        return this.readMapper.selectUserChannelIdByIos2();
    }

    public List<Map<String, Object>> selectUserinfoJuliByLatitudeAndLongitude(Map<String, Object> param)
    {
        return this.readMapper.selectUserinfoJuliByLatitudeAndLongitude(param);
    }

    public List<Map<String, Object>> selectShareInfoByUsername(String username)
    {
        return this.readMapper.selectShareInfoByUsername(username);
    }

    public List<Map<String, Object>> selectLastShareInfoByUsername(String username)
    {
        return this.readMapper.selectLastShareInfoByUsername(username);
    }

    public int insertUserInfo(Map<String, Object> param)
    {
        return this.writeMapper.insertUserInfo(param);
    }

    public int updateUserByVersionAndPlatAndroid(Map<String, Object> param)
    {
        return this.writeMapper.updateUserByVersionAndPlatAndroid(param);
    }

    public int updateUserByVersionAndPlatIOS(Map<String, Object> param)
    {
        return this.writeMapper.updateUserByVersionAndPlatIOS(param);
    }

    public int deletetUserInfo(Map<String, Object> param)
    {
        return this.writeMapper.deleteUserinfoByUsername(param);
    }

    public int updateUserChannelIdByUserName(Map<String, Object> param)
    {
        return this.writeMapper.updateUserChannelIdByUserName(param);
    }

    public int UpdateUserLogindate(Map<String, Object> param)
    {
        return this.writeMapper.UpdateUserLogindate(param);
    }

    public int updateUserinfoScoreByusername(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoScoreByusername(param);
    }

    public int updateUserinfoPassword(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoPassword(param);
    }

    public int updateUserinfoPasswordByPhone(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoPasswordByPhone(param);
    }

    public int updateUserinfoLatitudeAndLongitude(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoLatitudeAndLongitude(param);
    }

    public int updateUserinfoIosver(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoIosver(param);
    }

    public int updateUserinfoAdver(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoAdver(param);
    }

    public int updateUserinfoDays(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoDays(param);
    }

    public int updateUserinfo(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfo(param);
    }

    public int updateUserinfoCheckdateById(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoCheckdateById(param);
    }

    public int updateUserinfoRegisterstateById(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoRegisterstateById(param);
    }

    public int updateUserinfoPushmusicOne(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoPushmusicOne(param);
    }

    public int updateUserinfoPushmusicZero(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoPushmusicZero(param);
    }

    public int updatePushStatrSupportersOne(Map<String, Object> param)
    {
        return this.writeMapper.updatePushStatrSupportersOne(param);
    }

    public int updatePushStatrSupportersZero(Map<String, Object> param)
    {
        return this.writeMapper.updatePushStatrSupportersOne(param);
    }

    public int updateUserinfoOperationdate(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoOperationdate(param);
    }

    public int updateUserinfoDaysByusername(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoDaysByusername(param);
    }

    public int updateUserinfoTerminalstateByusername(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoTerminalstateByusername(param);
    }

    public int updateUserinfoChannelIdByusername(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoChannelIdByusername(param);
    }

    public int updateUserinfoScoreByGroupTrueusername(Map<String, Object> param)
    {
        return this.writeMapper.updateUserinfoScoreByGroupTrueusername(param);
    }

    public int updateShareInfoByUsername(Map<String, Object> param)
    {
        return this.writeMapper.updateShareInfoByUsername(param);
    }

    public int deleteUserinfoById(Map<String, Object> param)
    {
        return this.writeMapper.deleteUserinfoById(param);
    }

    public int updateUserAuthenticationStatusByUsername(String username)
    {
        return this.writeMapper.updateUserAuthenticationStatusByUsername(username);
    }
}
