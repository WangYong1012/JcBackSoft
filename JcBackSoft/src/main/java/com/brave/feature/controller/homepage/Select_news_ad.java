/*   1:    */ package com.brave.feature.controller.homepage;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.NewsAdService;
/*   4:    */ import com.brave.system.util.PageUtil;
/*   5:    */ import java.io.File;
/*   6:    */ import java.io.PrintStream;
/*   7:    */ import java.text.ParseException;
/*   8:    */ import java.text.SimpleDateFormat;
/*   9:    */ import java.util.Date;
/*  10:    */ import java.util.HashMap;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.Map;
/*  13:    */ import javax.servlet.ServletContext;
/*  14:    */ import javax.servlet.http.HttpServletRequest;
/*  15:    */ import javax.servlet.http.HttpServletResponse;
/*  16:    */ import javax.servlet.http.HttpSession;
/*  17:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  18:    */ import org.springframework.context.annotation.Scope;
/*  19:    */ import org.springframework.stereotype.Controller;
/*  20:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  21:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  22:    */ import org.springframework.web.servlet.ModelAndView;
/*  23:    */ 
/*  24:    */ @Controller
/*  25:    */ @Scope("prototype")
/*  26:    */ public class Select_news_ad
/*  27:    */ {
/*  28: 30 */   private int pagesize = 10;
/*  29:    */   @Autowired
/*  30:    */   private NewsAdService newsAdService;
/*  31:    */   
/*  32:    */   @ResponseBody
/*  33:    */   @RequestMapping(value={"/select_news_ad"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  34:    */   public ModelAndView Select_news_ad(HttpServletRequest request, HttpServletResponse response)
/*  35:    */   {
/*  36: 38 */     ModelAndView model = new ModelAndView();
/*  37: 39 */     Map<String, Object> resultMap = new HashMap();
/*  38:    */     try
/*  39:    */     {
/*  40: 42 */       request.setCharacterEncoding("utf-8");
/*  41: 43 */       response.setCharacterEncoding("utf-8");
/*  42: 44 */       int pageindex = Integer.parseInt(request.getParameter("pageindex"));
/*  43:    */       
/*  44: 46 */       Map<String, Object> newsMap = new HashMap();
/*  45: 47 */       newsMap.put("Pageindex", PageUtil.getStartRow(pageindex, this.pagesize));
/*  46: 48 */       newsMap.put("Pagesize", Integer.valueOf(this.pagesize));
/*  47: 49 */       List<Map<String, Object>> list = this.newsAdService.selectNews(newsMap);
/*  48:    */       
/*  49: 51 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
/*  50: 52 */       Date date = null;
/*  51: 53 */       for (int i = 0; i < list.size(); i++)
/*  52:    */       {
/*  53: 54 */         String issuetime = ((Map)list.get(i)).get("issuetime").toString();
/*  54:    */         try
/*  55:    */         {
/*  56: 56 */           date = df.parse(issuetime);
/*  57: 57 */           issuetime = df.format(date);
/*  58:    */         }
/*  59:    */         catch (ParseException e)
/*  60:    */         {
/*  61: 59 */           e.printStackTrace();
/*  62:    */         }
/*  63: 61 */         ((Map)list.get(i)).put("issuetime", issuetime);
/*  64:    */       }
/*  65: 63 */       int amount = this.newsAdService.selectNewsAmount();
/*  66: 64 */       String pages = null;
/*  67: 65 */       if (amount % this.pagesize == 0) {
/*  68: 66 */         pages = amount / this.pagesize + "";
/*  69:    */       } else {
/*  70: 68 */         pages = amount / this.pagesize + 1 + "";
/*  71:    */       }
/*  72: 70 */       String path = request.getRequestURL().toString().replace("select_news", "") + "homeimage/";
/*  73: 71 */       String path1 = request.getSession().getServletContext().getRealPath("/homeimage/");
/*  74:    */       
/*  75: 73 */       File file = new File(path1);
/*  76: 74 */       String imageURL = null;
/*  77: 75 */       String id = null;
/*  78: 76 */       if (file.isDirectory())
/*  79:    */       {
/*  80: 77 */         File[] files = file.listFiles();
/*  81: 78 */         id = files[0].getName();
/*  82: 79 */         System.out.println("id:" + id);
/*  83: 80 */         imageURL = path + id;
/*  84: 81 */         System.out.println("imageURL:" + imageURL);
/*  85: 82 */         id = id.replace(".jpg", "");
/*  86:    */       }
/*  87: 86 */       List<Map<String, Object>> list2 = this.newsAdService.selectNewsByID(id);
/*  89:    */       String title;
/*  90: 88 */       if (list2.size() < 1) {
/*  91: 89 */         title = null;
/*  92:    */       } else {
/*  93: 91 */         title = ((Map)list2.get(0)).get("title").toString();
/*  94:    */       }
/*  95: 93 */       resultMap.put("data", list);
/*  96: 94 */       resultMap.put("pages", pages);
/*  97: 95 */       resultMap.put("imageURL", imageURL);
/*  98: 96 */       resultMap.put("id", id);
/*  99: 97 */       resultMap.put("title", title);
/* 100: 98 */       model.addAllObjects(resultMap);
/* 101: 99 */       return model;
/* 102:    */     }
/* 103:    */     catch (Exception ex)
/* 104:    */     {
/* 105:102 */       ex.printStackTrace();
/* 106:103 */       resultMap.put("error", ex.getMessage());
/* 107:104 */       model.addAllObjects(resultMap);
/* 108:    */     }
/* 109:105 */     return model;
/* 110:    */   }
/* 111:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Select_news_ad

 * JD-Core Version:    0.7.0.1

 */