package com.brave.system.mapper.system;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface AccessUserDetailMapper
{
  public abstract Map<String, Object> findUserByUserName(@Param("userName") String paramString);
  
  public abstract List<Map<String, Object>> findUserRoleByUserName(@Param("userName") String paramString);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.mapper.system.AccessUserDetailMapper

 * JD-Core Version:    0.7.0.1

 */