package com.brave.feature.mapper.homepage;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface SendNoteMapper
{
  public abstract List<Map<String, Object>> selectSendNote(@Param("param") Map<String, Object> paramMap);
  
  public abstract int insertSendnote(@Param("param") Map<String, Object> paramMap);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.homepage.SendNoteMapper

 * JD-Core Version:    0.7.0.1

 */