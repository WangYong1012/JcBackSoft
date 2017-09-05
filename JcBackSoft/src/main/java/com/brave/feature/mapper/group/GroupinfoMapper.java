package com.brave.feature.mapper.group;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface GroupinfoMapper
{
  public abstract List<Map<String, Object>> selectGroupinfoData(@Param("Groupid") String paramString);
  
  public abstract List<Map<String, Object>> SelectGroupinfoByMaster(@Param("GroupMaster") String paramString);
  
  public abstract List<Map<String, Object>> selectGroupinfoSummaryById(@Param("Groupid") String paramString);
  
  public abstract List<Map<String, Object>> selectGroupinfoRuleById(@Param("Groupid") String paramString);
  
  public abstract List<Map<String, Object>> SelectGroupinfo();
  
  public abstract List<Map<String, Object>> SelectGroupinfoIdAndProvince();
  
  public abstract int updateGroupinfoDataById(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateGroupinfoRule(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateGroupinfoSummary(@Param("param") Map<String, Object> paramMap);
  
  public abstract int deleteGroupinfoById(@Param("param") Map<String, Object> paramMap);
  
  public abstract int insertGroupinfo(@Param("param") Map<String, Object> paramMap);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.group.GroupinfoMapper

 * JD-Core Version:    0.7.0.1

 */