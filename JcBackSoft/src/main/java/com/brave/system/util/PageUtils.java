/*   1:    */ package com.brave.system.util;
/*   2:    */ 
/*   3:    */ public class PageUtils
/*   4:    */ {
/*   5:  8 */   private static int PageRecorders = 10;
/*   6: 10 */   private static int ButtonNumbers = 9;
/*   7:    */   
/*   8:    */   public static String getPagenationInfo(long listSize, long currentPage, String url)
/*   9:    */   {
/*  10: 14 */     StringBuffer pagenation = new StringBuffer();
/*  11: 15 */     long pageNums = 0L;
/*  12: 17 */     if (listSize >= PageRecorders) {
/*  13: 22 */       if (listSize % PageRecorders == 0L) {
/*  14: 24 */         pageNums = listSize / PageRecorders;
/*  15:    */       } else {
/*  16: 27 */         pageNums = listSize / PageRecorders + 1L;
/*  17:    */       }
/*  18:    */     }
/*  19: 30 */     pagenation.append("<nav>");
/*  20: 31 */     pagenation.append("<ul class=\"pagination\">");
/*  21: 32 */     pagenation.append("<li>");
/*  22: 33 */     pagenation.append("<a href=");
/*  23: 34 */     pagenation.append("javascript:goPage('1'); ");
/*  24: 35 */     pagenation.append("aria-label=\"Previous\">");
/*  25: 36 */     pagenation.append("<span aria-hidden=\"true\">首页</span>");
/*  26: 37 */     pagenation.append("</a>");
/*  27: 38 */     pagenation.append("</li>");
/*  28: 42 */     if (pageNums < 9L)
/*  29:    */     {
/*  30: 44 */       for (long len = 1L; len <= pageNums; len += 1L)
/*  31:    */       {
/*  32: 46 */         pagenation.append("<li");
/*  33: 47 */         if (currentPage == len) {
/*  34: 49 */           pagenation.append(" class=\"active\"");
/*  35:    */         }
/*  36: 51 */         pagenation.append("><a href=\"");
/*  37: 52 */         pagenation.append("javascript:goPage('");
/*  38: 53 */         pagenation.append(len);
/*  39: 54 */         pagenation.append("'); \">");
/*  40: 55 */         pagenation.append(len);
/*  41: 56 */         pagenation.append("</a></li>");
/*  42:    */       }
/*  43:    */     }
/*  44:    */     else
/*  45:    */     {
/*  46: 60 */       long startNum = 0L;
/*  47: 61 */       long endNum = 0L;
/*  48: 62 */       if (4L >= currentPage)
/*  49:    */       {
/*  50: 65 */         startNum = 1L;
/*  51: 66 */         endNum = startNum + ButtonNumbers;
/*  52:    */       }
/*  53: 70 */       else if (pageNums >= currentPage + 4L)
/*  54:    */       {
/*  55: 72 */         startNum = currentPage - 4L;
/*  56: 73 */         endNum = currentPage + 4L;
/*  57:    */       }
/*  58:    */       else
/*  59:    */       {
/*  60: 76 */         startNum = currentPage - 4L;
/*  61: 77 */         endNum = pageNums;
/*  62:    */       }
/*  63: 81 */       for (long nums = startNum; nums < endNum; nums += 1L)
/*  64:    */       {
/*  65: 83 */         pagenation.append("<li");
/*  66: 84 */         if (currentPage == nums) {
/*  67: 86 */           pagenation.append(" class=\"active\"");
/*  68:    */         }
/*  69: 88 */         pagenation.append("><a href=\"");
/*  70: 89 */         pagenation.append("javascript: goPage('");
/*  71: 90 */         pagenation.append(nums);
/*  72: 91 */         pagenation.append("'); \" >");
/*  73: 92 */         pagenation.append(nums);
/*  74: 93 */         pagenation.append("</a></li>");
/*  75:    */       }
/*  76:    */     }
/*  77: 97 */     pagenation.append("<li>");
/*  78: 98 */     pagenation.append("<a href=");
/*  79: 99 */     pagenation.append("javascript:goPage('");
/*  80:100 */     pagenation.append(pageNums);
/*  81:101 */     pagenation.append("'); ");
/*  82:102 */     pagenation.append("aria-label=\"Next\">");
/*  83:103 */     pagenation.append("<span aria-hidden=\"true\">尾页</span>");
/*  84:104 */     pagenation.append("</a>");
/*  85:105 */     pagenation.append("</li>");
/*  86:106 */     pagenation.append("</ul>");
/*  87:107 */     pagenation.append("</nav>");
/*  88:    */     
/*  89:109 */     return pagenation.toString();
/*  90:    */   }
/*  91:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.util.PageUtils

 * JD-Core Version:    0.7.0.1

 */