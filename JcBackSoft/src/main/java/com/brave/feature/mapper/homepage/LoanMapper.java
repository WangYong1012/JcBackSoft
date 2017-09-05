package com.brave.feature.mapper.homepage;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface LoanMapper
{
  public abstract int insertLoaninfo(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectLenderList(@Param("param") Map<String, Object> paramMap);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.homepage.LoanMapper

 * JD-Core Version:    0.7.0.1

 */