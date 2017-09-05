/*  1:   */ package com.brave.system.util;
/*  2:   */ 
/*  3:   */ public class PageParameter
/*  4:   */ {
/*  5:   */   private int pageNums;
/*  6:   */   private int lineNums;
/*  7:   */   private String pagenation;
/*  8:   */   
/*  9:   */   public int getPageNums()
/* 10:   */   {
/* 11:18 */     return this.pageNums;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public void setPageNums(int pageNums)
/* 15:   */   {
/* 16:22 */     this.pageNums = pageNums;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public int getLineNums()
/* 20:   */   {
/* 21:26 */     return this.lineNums;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void setLineNums(int lineNums)
/* 25:   */   {
/* 26:30 */     this.lineNums = lineNums;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getPagenation()
/* 30:   */   {
/* 31:34 */     return this.pagenation;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public void setPagenation(String pagenation)
/* 35:   */   {
/* 36:38 */     this.pagenation = pagenation;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public String toString()
/* 40:   */   {
/* 41:44 */     return "PageParameter [ pageNums = " + this.pageNums + ", lineNums = " + this.lineNums + " ] ";
/* 42:   */   }
/* 43:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.util.PageParameter

 * JD-Core Version:    0.7.0.1

 */