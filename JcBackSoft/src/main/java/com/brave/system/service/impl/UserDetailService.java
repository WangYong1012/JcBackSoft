/*  1:   */ package com.brave.system.service.impl;
/*  2:   */ 
/*  3:   */ import com.brave.system.mapper.system.AccessUserDetailMapper;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.util.ArrayList;
/*  6:   */ import java.util.List;
/*  7:   */ import java.util.Map;
/*  8:   */ import javax.annotation.Resource;
/*  9:   */ import org.apache.ibatis.session.SqlSession;
/* 10:   */ import org.springframework.security.core.GrantedAuthority;
/* 11:   */ import org.springframework.security.core.authority.GrantedAuthorityImpl;
/* 12:   */ import org.springframework.security.core.userdetails.User;
/* 13:   */ import org.springframework.security.core.userdetails.UserDetails;
/* 14:   */ import org.springframework.security.core.userdetails.UserDetailsService;
/* 15:   */ import org.springframework.security.core.userdetails.UsernameNotFoundException;
/* 16:   */ import org.springframework.stereotype.Component;
/* 17:   */ 
/* 18:   */ @Component("backUserDetailService")
/* 19:   */ public class UserDetailService
/* 20:   */   implements UserDetailsService
/* 21:   */ {
/* 22:   */   private AccessUserDetailMapper writeMapper;
/* 23:   */   private AccessUserDetailMapper readMapper;
/* 24:   */   
/* 25:   */   @Resource(name="sqlSessionSlave")
/* 26:   */   public void setReadMapper(SqlSession sqlSession)
/* 27:   */   {
/* 28:36 */     this.readMapper = ((AccessUserDetailMapper)sqlSession.getMapper(AccessUserDetailMapper.class));
/* 29:   */   }
/* 30:   */   
/* 31:   */   @Resource(name="sqlSessionMaster")
/* 32:   */   public void setWriteMapper(SqlSession sqlSession)
/* 33:   */   {
/* 34:40 */     this.writeMapper = ((AccessUserDetailMapper)sqlSession.getMapper(AccessUserDetailMapper.class));
/* 35:   */   }
/* 36:   */   
/* 37:   */   public UserDetails loadUserByUsername(String userName)
/* 38:   */     throws UsernameNotFoundException
/* 39:   */   {
/* 40:   */     try
/* 41:   */     {
/* 42:51 */       System.out.println("执行登录的用户为：" + userName);
/* 43:   */       
/* 44:53 */       Map<String, Object> userMap = this.readMapper.findUserByUserName(userName);
/* 45:54 */       if ((null != userMap) && (0 < userMap.size()))
/* 46:   */       {
/* 47:56 */         List<GrantedAuthority> authorities = getGrantedAuthorties(userName);
/* 48:   */         
/* 49:58 */         return new User(userMap.get("username").toString(), userMap.get("password").toString(), authorities);
/* 50:   */       }
/* 51:62 */       return null;
/* 52:   */     }
/* 53:   */     catch (Exception e)
/* 54:   */     {
/* 55:67 */       System.out.println("不存在的用户..");
/* 56:   */     }
/* 57:68 */     return null;
/* 58:   */   }
/* 59:   */   
/* 60:   */   @Deprecated
/* 61:   */   private List<GrantedAuthority> getGrantedAuthorties(String userName)
/* 62:   */   {
/* 63:   */     try
/* 64:   */     {
/* 65:77 */       List<GrantedAuthority> grantedAuthorities = new ArrayList();
/* 66:78 */       List<Map<String, Object>> authorities = this.readMapper.findUserRoleByUserName(userName);
/* 67:80 */       for (Map<String, Object> map : authorities) {
/* 68:82 */         grantedAuthorities.add(new GrantedAuthorityImpl(map.get("authority").toString()));
/* 69:   */       }
/* 70:84 */       return grantedAuthorities;
/* 71:   */     }
/* 72:   */     catch (Exception e)
/* 73:   */     {
/* 74:90 */       System.out.println("用户无权限访问..");
/* 75:   */     }
/* 76:91 */     return null;
/* 77:   */   }
/* 78:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.service.impl.UserDetailService

 * JD-Core Version:    0.7.0.1

 */