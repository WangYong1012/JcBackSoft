/*  1:   */ package com.brave.system.util;
/*  2:   */ 
/*  3:   */ public class PageUtil
/*  4:   */ {
/*  5:   */   public static String setTotalPageCountByRs(String pageindex, int pagesize)
/*  6:   */   {
/*  7: 5 */     int pageCount = 0;
/*  8: 6 */     int count = Integer.parseInt(pageindex);
/*  9: 7 */     if ((pagesize > 0) && (count > 0) && (count % pagesize == 0)) {
/* 10: 8 */       pageCount = count / pagesize;
/* 11: 9 */     } else if ((pagesize > 0) && (count > 0) && (count % pagesize > 0)) {
/* 12:10 */       pageCount = count / pagesize + 1;
/* 13:   */     } else {
/* 14:12 */       pageCount = 0;
/* 15:   */     }
/* 16:14 */     return pageCount + "";
/* 17:   */   }
/* 18:   */   
/* 19:   */   public static Integer getStartRow(int index, int pagesize)
/* 20:   */   {
/* 21:22 */     return Integer.valueOf((index - 1) * pagesize);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getEndRow(String index, int pagesize)
/* 25:   */   {
/* 26:30 */     return Integer.parseInt(index) * pagesize + "";
/* 27:   */   }
/* 28:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.util.PageUtil

 * JD-Core Version:    0.7.0.1

 */