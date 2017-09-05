/*   1:    */ package com.brave.feature.controller.homepage;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.NewsService;
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
/*  22:    */ 
/*  23:    */ @Controller
/*  24:    */ @Scope("prototype")
/*  25:    */ public class Select_news
/*  26:    */ {
/*  27: 36 */   private int pagesize = 10;
/*  28:    */   @Autowired
/*  29:    */   private NewsService newsService;
/*  30:    */   
/*  31:    */   @ResponseBody
/*  32:    */   @RequestMapping(value={"/select_news"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  33:    */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/*  34:    */   {
/*  35: 45 */     Map<String, Object> map = new HashMap();
/*  36:    */     try
/*  37:    */     {
/*  38: 48 */       req.setCharacterEncoding("utf-8");
/*  39: 49 */       resp.setCharacterEncoding("utf-8");
/*  40: 50 */       int pageindex = Integer.parseInt(req.getParameter("pageindex"));
/*  41:    */       
/*  42: 52 */       Map<String, Object> newsMap = new HashMap();
/*  43: 53 */       newsMap.put("Pageindex", PageUtil.getStartRow(pageindex, this.pagesize));
/*  44: 54 */       newsMap.put("Pagesize", Integer.valueOf(this.pagesize));
/*  45: 55 */       List<Map<String, Object>> list = this.newsService.selectNews(newsMap);
/*  46:    */       
/*  47: 57 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
/*  48: 58 */       Date date = null;
/*  49: 59 */       for (int i = 0; i < list.size(); i++)
/*  50:    */       {
/*  51: 60 */         String issuetime = ((Map)list.get(i)).get("issuetime").toString();
/*  52:    */         try
/*  53:    */         {
/*  54: 62 */           date = df.parse(issuetime);
/*  55: 63 */           issuetime = df.format(date);
/*  56:    */         }
/*  57:    */         catch (ParseException e)
/*  58:    */         {
/*  59: 65 */           e.printStackTrace();
/*  60:    */         }
/*  61: 67 */         ((Map)list.get(i)).put("issuetime", issuetime);
/*  62:    */       }
/*  63: 69 */       int amount = this.newsService.selectNewsAmount();
/*  64: 70 */       String pages = null;
/*  65: 71 */       if (amount % this.pagesize == 0) {
/*  66: 72 */         pages = amount / this.pagesize + "";
/*  67:    */       } else {
/*  68: 74 */         pages = amount / this.pagesize + 1 + "";
/*  69:    */       }
/*  70: 76 */       String path = req.getRequestURL().toString().replace("select_news", "") + "homeimage/";
/*  71: 77 */       String path1 = req.getSession().getServletContext().getRealPath("/homeimage/");
/*  72:    */       
/*  73: 79 */       File file = new File(path1);
/*  74: 80 */       String imageURL = null;
/*  75: 81 */       String id = null;
/*  76: 82 */       if (file.isDirectory())
/*  77:    */       {
/*  78: 83 */         File[] files = file.listFiles();
/*  79: 84 */         id = files[0].getName();
/*  80: 85 */         System.out.println("id:" + id);
/*  81: 86 */         imageURL = path + id;
/*  82: 87 */         System.out.println("imageURL:" + imageURL);
/*  83: 88 */         id = id.replace(".jpg", "");
/*  84:    */       }
/*  85: 92 */       List<Map<String, Object>> list2 = this.newsService.selectNewsByID(id);
/*  87:    */       String title;
/*  88: 94 */       if (list2.size() < 1) {
/*  89: 95 */         title = null;
/*  90:    */       } else {
/*  91: 97 */         title = ((Map)list2.get(0)).get("title").toString();
/*  92:    */       }
/*  93: 99 */       map.put("data", list);
/*  94:100 */       map.put("pages", pages);
/*  95:101 */       map.put("imageURL", imageURL);
/*  96:102 */       map.put("id", id);
/*  97:103 */       map.put("title", title);
/*  98:104 */       return map;
/*  99:    */     }
/* 100:    */     catch (Exception ex)
/* 101:    */     {
/* 102:107 */       ex.printStackTrace();
/* 103:108 */       map.put("error", ex.getMessage());
/* 104:    */     }
/* 105:109 */     return map;
/* 106:    */   }
/* 107:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Select_news

 * JD-Core Version:    0.7.0.1

 */