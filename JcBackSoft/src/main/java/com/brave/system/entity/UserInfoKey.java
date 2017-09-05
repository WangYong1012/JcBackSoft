/*  1:   */ package com.brave.system.entity;
/*  2:   */ 
/*  3:   */ public class UserInfoKey
/*  4:   */ {
/*  5:   */   private String id;
/*  6:   */   private String username;
/*  7:   */   
/*  8:   */   public String getId()
/*  9:   */   {
/* 10: 9 */     return this.id;
/* 11:   */   }
/* 12:   */   
/* 13:   */   public void setId(String id)
/* 14:   */   {
/* 15:13 */     this.id = (id == null ? null : id.trim());
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getUsername()
/* 19:   */   {
/* 20:17 */     return this.username;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public void setUsername(String username)
/* 24:   */   {
/* 25:21 */     this.username = (username == null ? null : username.trim());
/* 26:   */   }
/* 27:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.entity.UserInfoKey

 * JD-Core Version:    0.7.0.1

 */