package com.brave.feature.mapper.news;

import com.brave.system.entity.NewsEntity;
import com.brave.system.entity.NewsEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface NewsEntityMapper
{
  public abstract int countByExample(NewsEntityExample paramNewsEntityExample);
  
  public abstract int deleteByExample(NewsEntityExample paramNewsEntityExample);
  
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(NewsEntity paramNewsEntity);
  
  public abstract int insertSelective(NewsEntity paramNewsEntity);
  
  public abstract List<NewsEntity> selectByExample(NewsEntityExample paramNewsEntityExample);
  
  public abstract NewsEntity selectByPrimaryKey(String paramString);
  
  public abstract int updateByExampleSelective(@Param("record") NewsEntity paramNewsEntity, @Param("example") NewsEntityExample paramNewsEntityExample);
  
  public abstract int updateByExample(@Param("record") NewsEntity paramNewsEntity, @Param("example") NewsEntityExample paramNewsEntityExample);
  
  public abstract int updateByPrimaryKeySelective(NewsEntity paramNewsEntity);
  
  public abstract int updateByPrimaryKey(NewsEntity paramNewsEntity);
  
  public abstract int getMaxNewsId();
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.news.NewsEntityMapper

 * JD-Core Version:    0.7.0.1

 */