package com.brave.feature.mapper.company;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface CompanyMapper
{
  public abstract List<Map<String, Object>> selectMountCompany(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectRelationCompany(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectCompanyById(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectCompanyCity();
  
  public abstract List<Map<String, Object>> selectCompanyByCity();
  
  public abstract List<Map<String, Object>> selectCompanyCountByCity(@Param("City") String paramString);
  
  public abstract List<Map<String, Object>> selectCompanyNumByCity(@Param("City") String paramString);
  
  public abstract List<Map<String, Object>> selectCompanyDataByPage(@Param("param") Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> selectRelationCompanyByCity(@Param("param") Map<String, Object> paramMap);
  
  public abstract int insertRelationCompany(@Param("param") Map<String, Object> paramMap);
  
  public abstract int updateCompanyPurchaseMount(@Param("param") Map<String, Object> paramMap);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.company.CompanyMapper

 * JD-Core Version:    0.7.0.1

 */