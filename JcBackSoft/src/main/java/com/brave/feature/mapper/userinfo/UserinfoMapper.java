package com.brave.feature.mapper.userinfo;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface UserinfoMapper
{
  public abstract List<Map<String, Object>> selectMyDataInfo(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectSignLiST();
  
  public abstract List<Map<String, Object>> selectUserChannelidByAd();
  
  public abstract List<Map<String, Object>> selectUserChannelidByIos();
  
  public abstract List<Map<String, Object>> selectRegisterstateIsOne();
  
  public abstract List<Map<String, Object>> selectTitudeAll();
  
  public abstract List<Map<String, Object>> selectAllUserinfo();
  
  public abstract List<Map<String, Object>> SelectPhoneUsername(@Param("Data") String paramString);
  
  public abstract List<Map<String, Object>> selectUserinfoGrouptimeByName(@Param("Name") String paramString);
  
  public abstract List<Map<String, Object>> selectUserChannelIdByAd1(@Param("ChannelId") String paramString);
  
  public abstract List<Map<String, Object>> selectUserChannelIdByAd2();
  
  public abstract List<Map<String, Object>> selectUserChannelIdByIos1(@Param("ChannelId") String paramString);
  
  public abstract List<Map<String, Object>> selectUserChannelIdByIos2();
  
  public abstract List<Map<String, Object>> selectUserinfoByPhone(@Param("Phone") String paramString);
  
  public abstract List<Map<String, Object>> selectPhoneStateByUsername(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectUserScore(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectUserScoreByTrueName(@Param("TrueName") String paramString);
  
  public abstract List<Map<String, Object>> selectUserDataInfoByHxid(@Param("HuanxinId") String paramString);
  
  public abstract List<Map<String, Object>> selectBatchdataByHxid(@Param("Hxid") String paramString);
  
  public abstract List<Map<String, Object>> selectUserDataByHxid(@Param("Huanxinid") String paramString);
  
  public abstract List<Map<String, Object>> SelectUserinfoAreaPhone(@Param("Phone") String paramString);
  
  public abstract List<Map<String, Object>> selectCurrentDateList(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectUserScoreOrDayByName(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectUserQiandaotimeByName(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> decideContinuous(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectUserStateByusername(@Param("Username") String paramString);
  
  public abstract List<Map<String, Object>> selectUserTimeScoreOrDayByName(@Param("Username") String paramString);
  
  public abstract List<Map<String, Object>> decideContinueSign(@Param("Username") String paramString);
  
  public abstract List<Map<String, Object>> selectUserinfoJuliByLatitudeAndLongitude(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectAuthenticationStatusList();
  
  public abstract List<Map<String, Object>> selectAdminInfo();
  
  public abstract List<Map<String, Object>> selectShareInfoByUsername(@Param("username") String paramString);
  
  public abstract List<Map<String, Object>> selectLastShareInfoByUsername(@Param("username") String paramString);
  
  public abstract int insertUserInfo(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserByVersionAndPlatAndroid(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserByVersionAndPlatIOS(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserChannelIdByUserName(@Param("param") Map<String, Object> paramMap);
  
  public abstract int UpdateUserLogindate(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoScoreByusername(@Param("param") Map<String, Object> paramMap);
  
  public abstract int deleteUserinfoByUsername(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoPassword(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoPasswordByPhone(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoLatitudeAndLongitude(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoIosver(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoAdver(@Param("param") Map<String, Object> paramMap);
  
  public abstract int deleteUserinfoById(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoOperationdate(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoDays(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfo(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoPushmusicOne(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoPushmusicZero(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoCheckdateById(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoRegisterstateById(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoDaysByusername(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updatePushStatrSupportersOne(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updatePushStatrSupportersZero(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoTerminalstateByusername(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoChannelIdByusername(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserinfoScoreByGroupTrueusername(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateShareInfoByUsername(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateUserAuthenticationStatusByUsername(@Param("UserName") String paramString);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.userinfo.UserinfoMapper

 * JD-Core Version:    0.7.0.1

 */