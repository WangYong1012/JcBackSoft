package com.brave.feature.mapper.homepage;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface FirsthandResourcesMapper
{
  public abstract List<Map<String, Object>> selectFirsthandResourcesList(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectFirsthandByUsername(@Param("username") String paramString);
  
  public abstract List<Map<String, Object>> selectAuthenticationRegionByUsername(@Param("username") String paramString);
  
  public abstract List<Map<String, Object>> selectAuthenticationInfo(@Param("username") String paramString);
  
  public abstract List<Map<String, Object>> selectAuthenticationTypeByUsername(@Param("username") String paramString);
  
  public abstract List<Map<String, Object>> selectAuthenticationType();
  
  public abstract int update_firsthand(@Param("param") Map<String, Object> paramMap);
  
  public abstract int insert_firsthand(@Param("param") Map<String, Object> paramMap);
  
  public abstract int delete_firsthandByUsername(@Param("username") String paramString);
  
  public abstract List<Map<String, Object>> selectAuthenticationStatus(@Param("username") String paramString);
  
  public abstract int updateAuthenticationStatus(@Param("param") Map<String, Object> paramMap);
  
  public abstract int update_firsthand_status(@Param("param") Map<String, Object> paramMap);
  
  public abstract int selectNewsAmount();
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.homepage.FirsthandResourcesMapper

 * JD-Core Version:    0.7.0.1

 */