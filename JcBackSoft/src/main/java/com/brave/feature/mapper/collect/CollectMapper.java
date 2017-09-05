package com.brave.feature.mapper.collect;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface CollectMapper
{
  public abstract List<Map<String, Object>> selectCollectByUsername(@Param("Username") String paramString);
  
  public abstract int updateCollectPhone(@Param("param") Map<String, Object> paramMap);
  
  public abstract int deleteCollectById(@Param("param") Map<String, Object> paramMap);
  
  public abstract int insertCollect(@Param("param") Map<String, Object> paramMap);
  
  public abstract int deleteCollectByIdUsername(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectCollectById(@Param("param") Map<String, Object> paramMap);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.collect.CollectMapper

 * JD-Core Version:    0.7.0.1

 */