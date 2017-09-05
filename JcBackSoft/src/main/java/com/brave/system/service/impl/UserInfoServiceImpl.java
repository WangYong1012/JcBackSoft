/*   1:    */ package com.brave.system.service.impl;
/*   2:    */ 
/*   3:    */ import com.brave.system.entity.UserInfo;
/*   4:    */ import com.brave.system.entity.UserInfoExample;
/*   5:    */ import com.brave.system.entity.UserInfoKey;
/*   6:    */ import com.brave.system.mapper.system.UserInfoMapper;
/*   7:    */ import com.brave.system.service.IUserInfoService;
/*   8:    */ import java.util.List;
/*   9:    */ import java.util.Map;
/*  10:    */ import javax.annotation.Resource;
/*  11:    */ import org.apache.ibatis.annotations.Param;
/*  12:    */ import org.apache.ibatis.session.SqlSession;
/*  13:    */ import org.springframework.stereotype.Service;
/*  14:    */ 
/*  15:    */ @Service
/*  16:    */ public class UserInfoServiceImpl
/*  17:    */   implements IUserInfoService
/*  18:    */ {
/*  19:    */   private UserInfoMapper writeMapper;
/*  20:    */   private UserInfoMapper readMapper;
/*  21:    */   
/*  22:    */   @Resource(name="sqlSessionSlave")
/*  23:    */   public void setReadMapper(SqlSession sqlSession)
/*  24:    */   {
/*  25: 31 */     this.readMapper = ((UserInfoMapper)sqlSession.getMapper(UserInfoMapper.class));
/*  26:    */   }
/*  27:    */   
/*  28:    */   @Resource(name="sqlSessionMaster")
/*  29:    */   public void setWriteMapper(SqlSession sqlSession)
/*  30:    */   {
/*  31: 35 */     this.writeMapper = ((UserInfoMapper)sqlSession.getMapper(UserInfoMapper.class));
/*  32:    */   }
/*  33:    */   
/*  34:    */   public int countByExample(UserInfoExample example)
/*  35:    */   {
/*  36: 40 */     return this.readMapper.countByExample(example);
/*  37:    */   }
/*  38:    */   
/*  39:    */   public int deleteByExample(UserInfoExample example)
/*  40:    */   {
/*  41: 45 */     return this.writeMapper.deleteByExample(example);
/*  42:    */   }
/*  43:    */   
/*  44:    */   public int deleteByPrimaryKey(UserInfoKey key)
/*  45:    */   {
/*  46: 50 */     return this.writeMapper.deleteByPrimaryKey(key);
/*  47:    */   }
/*  48:    */   
/*  49:    */   public int insert(UserInfo record)
/*  50:    */   {
/*  51: 55 */     return this.writeMapper.insert(record);
/*  52:    */   }
/*  53:    */   
/*  54:    */   public int insertSelective(UserInfo record)
/*  55:    */   {
/*  56: 60 */     return this.writeMapper.insertSelective(record);
/*  57:    */   }
/*  58:    */   
/*  59:    */   public List<UserInfo> selectByExample(UserInfoExample example)
/*  60:    */   {
/*  61: 65 */     return this.readMapper.selectByExample(example);
/*  62:    */   }
/*  63:    */   
/*  64:    */   public UserInfo selectByPrimaryKey(UserInfoKey key)
/*  65:    */   {
/*  66: 70 */     return this.readMapper.selectByPrimaryKey(key);
/*  67:    */   }
/*  68:    */   
/*  69:    */   public int updateByExampleSelective(UserInfo record, UserInfoExample example)
/*  70:    */   {
/*  71: 75 */     return this.writeMapper.updateByExampleSelective(record, example);
/*  72:    */   }
/*  73:    */   
/*  74:    */   public int updateByExample(UserInfo record, UserInfoExample example)
/*  75:    */   {
/*  76: 80 */     return this.writeMapper.updateByExample(record, example);
/*  77:    */   }
/*  78:    */   
/*  79:    */   public int updateByPrimaryKeySelective(UserInfo record)
/*  80:    */   {
/*  81: 85 */     return this.writeMapper.updateByPrimaryKeySelective(record);
/*  82:    */   }
/*  83:    */   
/*  84:    */   public int updateByPrimaryKey(UserInfo record)
/*  85:    */   {
/*  86: 90 */     return this.writeMapper.updateByPrimaryKey(record);
/*  87:    */   }
/*  88:    */   
/*  89:    */   public List<Map<String, Object>> userinfo2d(Map<String, Object> param)
/*  90:    */   {
/*  91: 96 */     return this.readMapper.userinfo2d(param);
/*  92:    */   }
/*  93:    */   
/*  94:    */   public List<Map<String, Object>> userinfopiePlat(@Param("param") Map<String, Object> param)
/*  95:    */   {
/*  96:101 */     return this.readMapper.userinfopiePlat(param);
/*  97:    */   }
/*  98:    */   
/*  99:    */   public int userinfopieAllCount(@Param("param") Map<String, Object> param)
/* 100:    */   {
/* 101:106 */     return this.readMapper.userinfopieAllCount(param);
/* 102:    */   }
/* 103:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.service.impl.UserInfoServiceImpl

 * JD-Core Version:    0.7.0.1

 */