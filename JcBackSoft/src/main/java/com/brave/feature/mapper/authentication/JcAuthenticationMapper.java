package com.brave.feature.mapper.authentication;

import com.brave.feature.entity.JcAuthentication;
import com.brave.feature.entity.JcAuthenticationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface JcAuthenticationMapper
{
  public abstract int countByExample(JcAuthenticationExample paramJcAuthenticationExample);
  
  public abstract int deleteByExample(JcAuthenticationExample paramJcAuthenticationExample);
  
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(JcAuthentication paramJcAuthentication);
  
  public abstract int insertSelective(JcAuthentication paramJcAuthentication);
  
  public abstract List<JcAuthentication> selectByExample(JcAuthenticationExample paramJcAuthenticationExample);
  
  public abstract JcAuthentication selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByExampleSelective(@Param("record") JcAuthentication paramJcAuthentication, @Param("example") JcAuthenticationExample paramJcAuthenticationExample);
  
  public abstract int updateByExample(@Param("record") JcAuthentication paramJcAuthentication, @Param("example") JcAuthenticationExample paramJcAuthenticationExample);
  
  public abstract int updateByPrimaryKeySelective(JcAuthentication paramJcAuthentication);
  
  public abstract int updateByPrimaryKey(JcAuthentication paramJcAuthentication);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.authentication.JcAuthenticationMapper

 * JD-Core Version:    0.7.0.1

 */