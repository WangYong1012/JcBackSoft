/*  1:   */ package com.brave.feature.controller.homepage;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.NewsService;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.text.SimpleDateFormat;
/*  6:   */ import java.util.Date;
/*  7:   */ import java.util.HashMap;
/*  8:   */ import java.util.Map;
/*  9:   */ import javax.servlet.http.HttpServletRequest;
/* 10:   */ import javax.servlet.http.HttpServletResponse;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.context.annotation.Scope;
/* 13:   */ import org.springframework.stereotype.Controller;
/* 14:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 15:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ @Scope("prototype")
/* 19:   */ public class Insert_news
/* 20:   */ {
/* 21:   */   @Autowired
/* 22:   */   private NewsService newsService;
/* 23:   */   
/* 24:   */   @ResponseBody
/* 25:   */   @RequestMapping(value={"/insert_news"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 26:   */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/* 27:   */   {
/* 28:39 */     Map<String, Object> map = new HashMap();
/* 29:   */     try
/* 30:   */     {
/* 31:42 */       req.setCharacterEncoding("utf-8");
/* 32:43 */       resp.setCharacterEncoding("utf-8");
/* 33:44 */       String author = req.getParameter("author");
/* 34:45 */       String newsid = req.getParameter("newsid");
/* 35:46 */       String username = req.getParameter("username");
/* 36:47 */       String content = req.getParameter("content");
/* 37:48 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
/* 38:49 */       String issuetime = df.format(new Date());
/* 39:50 */       System.out.println("issuetime:" + issuetime);
/* 40:51 */       Map<String, Object> newsMap = new HashMap();
/* 41:52 */       newsMap.put("Author", author);
/* 42:53 */       newsMap.put("Newsid", newsid);
/* 43:54 */       newsMap.put("Username", username);
/* 44:55 */       newsMap.put("Content", content);
/* 45:56 */       newsMap.put("Issuetime", issuetime);
/* 46:57 */       int i = this.newsService.insertNews(newsMap);
/* 47:58 */       map.put("data", i + "");
/* 48:59 */       return map;
/* 49:   */     }
/* 50:   */     catch (Exception ex)
/* 51:   */     {
/* 52:62 */       ex.printStackTrace();
/* 53:63 */       map.put("error", ex.getMessage());
/* 54:   */     }
/* 55:64 */     return map;
/* 56:   */   }
/* 57:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Insert_news

 * JD-Core Version:    0.7.0.1

 */