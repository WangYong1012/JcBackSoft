/*  1:   */ package com.brave.system.util;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class DistanceUtil
/*  6:   */ {
/*  7:   */   public static String convertDistance(String str)
/*  8:   */   {
/*  9: 7 */     if (str.endsWith("km")) {
/* 10: 8 */       str = Double.parseDouble(str.replaceAll("km", "")) * 1000.0D + "";
/* 11: 9 */     } else if (str.endsWith("m")) {
/* 12:10 */       str = str.replaceAll("m", "");
/* 13:   */     }
/* 14:12 */     double distance = Double.parseDouble(str);
/* 15:13 */     String juli = null;
/* 16:14 */     if (distance < 1000.0D)
/* 17:   */     {
/* 18:15 */       BigDecimal b = new BigDecimal(distance);
/* 19:16 */       distance = b.setScale(2, 4).doubleValue();
/* 20:17 */       juli = distance + "m";
/* 21:   */     }
/* 22:   */     else
/* 23:   */     {
/* 24:19 */       BigDecimal b = new BigDecimal(distance / 1000.0D);
/* 25:20 */       distance = b.setScale(2, 4).doubleValue();
/* 26:21 */       juli = distance + "km";
/* 27:   */     }
/* 28:23 */     return juli;
/* 29:   */   }
/* 30:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.util.DistanceUtil

 * JD-Core Version:    0.7.0.1

 */