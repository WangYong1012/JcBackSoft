/*  1:   */ package com.brave.feature.entity;
/*  2:   */ 
/*  3:   */ public class JcAreas
/*  4:   */ {
/*  5:   */   private Integer id;
/*  6:   */   private String areaid;
/*  7:   */   private String areapid;
/*  8:   */   private String areaname;
/*  9:   */   private Integer sort;
/* 10:   */   
/* 11:   */   public Integer getId()
/* 12:   */   {
/* 13:15 */     return this.id;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public void setId(Integer id)
/* 17:   */   {
/* 18:19 */     this.id = id;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public String getAreaid()
/* 22:   */   {
/* 23:23 */     return this.areaid;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public void setAreaid(String areaid)
/* 27:   */   {
/* 28:27 */     this.areaid = (areaid == null ? null : areaid.trim());
/* 29:   */   }
/* 30:   */   
/* 31:   */   public String getAreapid()
/* 32:   */   {
/* 33:31 */     return this.areapid;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public void setAreapid(String areapid)
/* 37:   */   {
/* 38:35 */     this.areapid = (areapid == null ? null : areapid.trim());
/* 39:   */   }
/* 40:   */   
/* 41:   */   public String getAreaname()
/* 42:   */   {
/* 43:39 */     return this.areaname;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void setAreaname(String areaname)
/* 47:   */   {
/* 48:43 */     this.areaname = (areaname == null ? null : areaname.trim());
/* 49:   */   }
/* 50:   */   
/* 51:   */   public Integer getSort()
/* 52:   */   {
/* 53:47 */     return this.sort;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public void setSort(Integer sort)
/* 57:   */   {
/* 58:51 */     this.sort = sort;
/* 59:   */   }
/* 60:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.entity.JcAreas

 * JD-Core Version:    0.7.0.1

 */