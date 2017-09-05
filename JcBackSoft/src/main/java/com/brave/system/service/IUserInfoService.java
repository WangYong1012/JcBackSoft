package com.brave.system.service;

import com.brave.system.entity.UserInfo;
import com.brave.system.entity.UserInfoExample;
import com.brave.system.entity.UserInfoKey;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface IUserInfoService
{
  public abstract int countByExample(UserInfoExample paramUserInfoExample);
  
  public abstract int deleteByExample(UserInfoExample paramUserInfoExample);
  
  public abstract int deleteByPrimaryKey(UserInfoKey paramUserInfoKey);
  
  public abstract int insert(UserInfo paramUserInfo);
  
  public abstract int insertSelective(UserInfo paramUserInfo);
  
  public abstract List<UserInfo> selectByExample(UserInfoExample paramUserInfoExample);
  
  public abstract UserInfo selectByPrimaryKey(UserInfoKey paramUserInfoKey);
  
  public abstract int updateByExampleSelective(UserInfo paramUserInfo, UserInfoExample paramUserInfoExample);
  
  public abstract int updateByExample(UserInfo paramUserInfo, UserInfoExample paramUserInfoExample);
  
  public abstract int updateByPrimaryKeySelective(UserInfo paramUserInfo);
  
  public abstract int updateByPrimaryKey(UserInfo paramUserInfo);
  
  public abstract List<Map<String, Object>> userinfo2d(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> userinfopiePlat(@Param("param") Map<String, Object> paramMap);
  
  public abstract int userinfopieAllCount(@Param("param") Map<String, Object> paramMap);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.service.IUserInfoService

 * JD-Core Version:    0.7.0.1

 */