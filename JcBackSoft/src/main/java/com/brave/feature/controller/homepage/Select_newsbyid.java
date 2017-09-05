/*  1:   */ package com.brave.feature.controller.homepage;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.NewsService;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import java.util.List;
/*  7:   */ import java.util.Map;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import javax.servlet.http.HttpServletResponse;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.context.annotation.Scope;
/* 12:   */ import org.springframework.stereotype.Controller;
/* 13:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 14:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 15:   */ 
/* 16:   */ @Controller
/* 17:   */ @Scope("prototype")
/* 18:   */ public class Select_newsbyid
/* 19:   */ {
/* 20:   */   @Autowired
/* 21:   */   private NewsService newsService;
/* 22:   */   
/* 23:   */   @ResponseBody
/* 24:   */   @RequestMapping(value={"/select_newsbyid "}, method={org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"application/json"})
/* 25:   */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/* 26:   */   {
/* 27:39 */     Map<String, Object> map = new HashMap();
/* 28:   */     try
/* 29:   */     {
/* 30:42 */       req.setCharacterEncoding("utf-8");
/* 31:43 */       resp.setCharacterEncoding("utf-8");
/* 32:44 */       String id = req.getParameter("id");
/* 33:45 */       System.out.println("id:" + id);
/* 34:46 */       List<Map<String, Object>> list = this.newsService.selectNewsByID(id);
/* 35:47 */       System.out.println("list:" + list.toString());
/* 36:48 */       map.put("data", list);
/* 37:49 */       return map;
/* 38:   */     }
/* 39:   */     catch (Exception ex)
/* 40:   */     {
/* 41:52 */       ex.printStackTrace();
/* 42:53 */       map.put("error", ex.getMessage());
/* 43:   */     }
/* 44:54 */     return map;
/* 45:   */   }
/* 46:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Select_newsbyid

 * JD-Core Version:    0.7.0.1

 */