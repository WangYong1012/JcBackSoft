package com.brave.feature.mapper.black;

import org.apache.ibatis.annotations.Param;

public abstract interface BlacklistMapper
{
  public abstract int insertBlacklist(@Param("username") String paramString);
  
  public abstract int deleteBlacklistByUsername(@Param("username") String paramString);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.black.BlacklistMapper

 * JD-Core Version:    0.7.0.1

 */