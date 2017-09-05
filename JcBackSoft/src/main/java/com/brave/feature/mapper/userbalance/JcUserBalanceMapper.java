package com.brave.feature.mapper.userbalance;

import com.brave.feature.entity.JcUserBalance;
import com.brave.feature.entity.JcUserBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface JcUserBalanceMapper
{
  public abstract int countByExample(JcUserBalanceExample paramJcUserBalanceExample);
  
  public abstract int deleteByExample(JcUserBalanceExample paramJcUserBalanceExample);
  
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(JcUserBalance paramJcUserBalance);
  
  public abstract int insertSelective(JcUserBalance paramJcUserBalance);
  
  public abstract List<JcUserBalance> selectByExample(JcUserBalanceExample paramJcUserBalanceExample);
  
  public abstract JcUserBalance selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByExampleSelective(@Param("record") JcUserBalance paramJcUserBalance, @Param("example") JcUserBalanceExample paramJcUserBalanceExample);
  
  public abstract int updateByExample(@Param("record") JcUserBalance paramJcUserBalance, @Param("example") JcUserBalanceExample paramJcUserBalanceExample);
  
  public abstract int updateByPrimaryKeySelective(JcUserBalance paramJcUserBalance);
  
  public abstract int updateByPrimaryKey(JcUserBalance paramJcUserBalance);
}



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.mapper.userbalance.JcUserBalanceMapper

 * JD-Core Version:    0.7.0.1

 */