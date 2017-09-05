package com.brave.feature.mapper.userinfo;

import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface ImageMapper
{
  public abstract int updateUserinfoImage(@Param("param") Map<String, Object> paramMap);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.userinfo.ImageMapper

 * JD-Core Version:    0.7.0.1

 */