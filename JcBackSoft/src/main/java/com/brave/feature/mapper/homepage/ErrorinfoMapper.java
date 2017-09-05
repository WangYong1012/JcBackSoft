package com.brave.feature.mapper.homepage;

import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface ErrorinfoMapper
{
  public abstract int insertErrorInfo(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateErrorInfo(@Param("param") Map<String, Object> paramMap);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.homepage.ErrorinfoMapper

 * JD-Core Version:    0.7.0.1

 */