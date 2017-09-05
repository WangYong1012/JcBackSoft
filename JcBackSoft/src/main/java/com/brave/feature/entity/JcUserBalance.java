/*  1:   */ package com.brave.feature.entity;
/*  2:   */ 
/*  3:   */ import java.util.Date;
/*  4:   */ 
/*  5:   */ public class JcUserBalance
/*  6:   */ {
/*  7:   */   private Integer id;
/*  8:   */   private String username;
/*  9:   */   private Integer balance;
/* 10:   */   private String purpose;
/* 11:   */   private Date operdate;
/* 12:   */   private String remark;
/* 13:   */   
/* 14:   */   public Integer getId()
/* 15:   */   {
/* 16:19 */     return this.id;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public void setId(Integer id)
/* 20:   */   {
/* 21:23 */     this.id = id;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getUsername()
/* 25:   */   {
/* 26:27 */     return this.username;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setUsername(String username)
/* 30:   */   {
/* 31:31 */     this.username = (username == null ? null : username.trim());
/* 32:   */   }
/* 33:   */   
/* 34:   */   public Integer getBalance()
/* 35:   */   {
/* 36:35 */     return this.balance;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setBalance(Integer balance)
/* 40:   */   {
/* 41:39 */     this.balance = balance;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public String getPurpose()
/* 45:   */   {
/* 46:43 */     return this.purpose;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setPurpose(String purpose)
/* 50:   */   {
/* 51:47 */     this.purpose = (purpose == null ? null : purpose.trim());
/* 52:   */   }
/* 53:   */   
/* 54:   */   public Date getOperdate()
/* 55:   */   {
/* 56:51 */     return this.operdate;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setOperdate(Date operdate)
/* 60:   */   {
/* 61:55 */     this.operdate = operdate;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public String getRemark()
/* 65:   */   {
/* 66:59 */     return this.remark;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setRemark(String remark)
/* 70:   */   {
/* 71:63 */     this.remark = (remark == null ? null : remark.trim());
/* 72:   */   }
/* 73:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.entity.JcUserBalance

 * JD-Core Version:    0.7.0.1

 */