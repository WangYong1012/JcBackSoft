/*  1:   */ package com.brave.feature.entity;
/*  2:   */ 
/*  3:   */ import java.util.Date;
/*  4:   */ 
/*  5:   */ public class JcAuthentication
/*  6:   */ {
/*  7:   */   private Integer id;
/*  8:   */   private String username;
/*  9:   */   private Date startdate;
/* 10:   */   private Date duedate;
/* 11:   */   private String region;
/* 12:   */   private String type;
/* 13:   */   private String paytype;
/* 14:   */   
/* 15:   */   public Integer getId()
/* 16:   */   {
/* 17:21 */     return this.id;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setId(Integer id)
/* 21:   */   {
/* 22:25 */     this.id = id;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public String getUsername()
/* 26:   */   {
/* 27:29 */     return this.username;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setUsername(String username)
/* 31:   */   {
/* 32:33 */     this.username = (username == null ? null : username.trim());
/* 33:   */   }
/* 34:   */   
/* 35:   */   public Date getStartdate()
/* 36:   */   {
/* 37:37 */     return this.startdate;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public void setStartdate(Date startdate)
/* 41:   */   {
/* 42:41 */     this.startdate = startdate;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public Date getDuedate()
/* 46:   */   {
/* 47:45 */     return this.duedate;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setDuedate(Date duedate)
/* 51:   */   {
/* 52:49 */     this.duedate = duedate;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public String getRegion()
/* 56:   */   {
/* 57:53 */     return this.region;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setRegion(String region)
/* 61:   */   {
/* 62:57 */     this.region = (region == null ? null : region.trim());
/* 63:   */   }
/* 64:   */   
/* 65:   */   public String getType()
/* 66:   */   {
/* 67:61 */     return this.type;
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void setType(String type)
/* 71:   */   {
/* 72:65 */     this.type = (type == null ? null : type.trim());
/* 73:   */   }
/* 74:   */   
/* 75:   */   public String getPaytype()
/* 76:   */   {
/* 77:69 */     return this.paytype;
/* 78:   */   }
/* 79:   */   
/* 80:   */   public void setPaytype(String paytype)
/* 81:   */   {
/* 82:73 */     this.paytype = (paytype == null ? null : paytype.trim());
/* 83:   */   }
/* 84:   */ }