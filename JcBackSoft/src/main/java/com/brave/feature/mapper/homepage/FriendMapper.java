package com.brave.feature.mapper.homepage;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface FriendMapper
{
  public abstract int deleteFriend(@Param("param") Map<String, Object> paramMap);
  
  public abstract int insertFriend(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateFriend(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectFriendState(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectFriendByUsername(@Param("username") String paramString);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.homepage.FriendMapper

 * JD-Core Version:    0.7.0.1

 */