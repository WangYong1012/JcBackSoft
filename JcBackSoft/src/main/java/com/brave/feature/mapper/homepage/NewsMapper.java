package com.brave.feature.mapper.homepage;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface NewsMapper
{
  public abstract List<Map<String, Object>> selectNewsList(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectNewsByID(@Param("id") String paramString);
  
  public abstract int insertNews(@Param("param") Map<String, Object> paramMap);
  
  public abstract int selectNewsAmount();
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.homepage.NewsMapper

 * JD-Core Version:    0.7.0.1

 */