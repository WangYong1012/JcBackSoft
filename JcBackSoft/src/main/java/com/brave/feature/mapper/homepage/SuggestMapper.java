package com.brave.feature.mapper.homepage;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface SuggestMapper
{
  public abstract List<Map<String, Object>> selectSuggest();
  
  public abstract int deleteSuggestById(@Param("param") Map<String, Object> paramMap);
  
  public abstract int insertSuggest(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateSuggestById(@Param("param") Map<String, Object> paramMap);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.homepage.SuggestMapper

 * JD-Core Version:    0.7.0.1

 */