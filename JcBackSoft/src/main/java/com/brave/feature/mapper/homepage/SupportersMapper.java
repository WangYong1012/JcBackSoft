package com.brave.feature.mapper.homepage;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface SupportersMapper
{
  public abstract List<Map<String, Object>> selectSupportersAllByName(@Param("Username") String paramString);
  
  public abstract List<Map<String, Object>> screenSupportersByCondition(@Param("Sql") String paramString);
  
  public abstract List<Map<String, Object>> selectSupportersDataById(@Param("SupportersId") String paramString);
  
  public abstract List<Map<String, Object>> selectSupportersDataByEndorsement(@Param("Endorsement") String paramString);
  
  public abstract List<Map<String, Object>> selectPushstatrsupportersByName(@Param("Username") String paramString);
  
  public abstract List<Map<String, Object>> selectSupportersByType(@Param("type") String paramString);
  
  public abstract List<Map<String, Object>> selectCommonUser(@Param("Num") int paramInt);
  
  public abstract List<Map<String, Object>> selectSupportersDataByPage(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectSupportersData();
  
  public abstract List<Map<String, Object>> selectSupportersQuantity();
  
  public abstract List<Map<String, Object>> selectSupportersInfoByPage(@Param("param") Map<String, Object> paramMap);
  
  public abstract int selectSupportersAmountByIssuetime(@Param("Issuetime") String paramString);
  
  public abstract List<Map<String, Object>> selectSupportersState(@Param("username") String paramString);
  
  public abstract int updateSupportersTitude(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateSupportersPhone(@Param("param") Map<String, Object> paramMap);
  
  public abstract int deleteSupportersById(@Param("param") Map<String, Object> paramMap);
  
  public abstract int insertSupportersInfo(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateSupportersCheckOut(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateSupportersCollectstateZero(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateSupportersCollectstateOne(@Param("param") Map<String, Object> paramMap);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.homepage.SupportersMapper

 * JD-Core Version:    0.7.0.1

 */