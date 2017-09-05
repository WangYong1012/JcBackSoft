package com.brave.feature.mapper.homepage;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface ThisticketMapper
{
  public abstract List<Map<String, Object>> selectThisticketList(@Param("param") Map<String, Object> paramMap);
  
  public abstract int insertThisticket(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateThisticketViewtimes(@Param("param") Map<String, Object> paramMap);
  
  public abstract int selectThisticketAmount();
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.homepage.ThisticketMapper

 * JD-Core Version:    0.7.0.1

 */