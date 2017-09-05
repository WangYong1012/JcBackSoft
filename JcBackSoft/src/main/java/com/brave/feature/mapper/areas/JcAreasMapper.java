package com.brave.feature.mapper.areas;

import com.brave.feature.entity.JcAreas;
import com.brave.feature.entity.JcAreasExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface JcAreasMapper
{
  public abstract int countByExample(JcAreasExample paramJcAreasExample);
  
  public abstract int deleteByExample(JcAreasExample paramJcAreasExample);
  
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(JcAreas paramJcAreas);
  
  public abstract int insertSelective(JcAreas paramJcAreas);
  
  public abstract List<JcAreas> selectByExample(JcAreasExample paramJcAreasExample);
  
  public abstract JcAreas selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByExampleSelective(@Param("record") JcAreas paramJcAreas, @Param("example") JcAreasExample paramJcAreasExample);
  
  public abstract int updateByExample(@Param("record") JcAreas paramJcAreas, @Param("example") JcAreasExample paramJcAreasExample);
  
  public abstract int updateByPrimaryKeySelective(JcAreas paramJcAreas);
  
  public abstract int updateByPrimaryKey(JcAreas paramJcAreas);
  
  public abstract String selectCityByProvinceId(@Param("areaPid") String paramString);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.areas.JcAreasMapper

 * JD-Core Version:    0.7.0.1

 */