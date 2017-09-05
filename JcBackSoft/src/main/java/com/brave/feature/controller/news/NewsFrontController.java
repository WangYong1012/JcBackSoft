/*  1:   */ package com.brave.feature.controller.news;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.NewService;
/*  4:   */ import com.brave.system.entity.NewsEntity;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import java.util.Map;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import javax.servlet.http.HttpServletResponse;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.context.annotation.Scope;
/* 11:   */ import org.springframework.stereotype.Controller;
/* 12:   */ import org.springframework.ui.ModelMap;
/* 13:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 14:   */ 
/* 15:   */ @Controller
/* 16:   */ @Scope("prototype")
/* 17:   */ @RequestMapping({"/news"})
/* 18:   */ public class NewsFrontController
/* 19:   */ {
/* 20:   */   @Autowired
/* 21:   */   private NewService newService;
/* 22:   */   
/* 23:   */   @RequestMapping(value={"/detail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 24:   */   public String detail(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 25:   */   {
/* 26:32 */     Map<String, Object> resultMap = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:36 */       String newsId = request.getParameter("newsId") == null ? "" : request.getParameter("newsId");
/* 30:37 */       if ("".equals(newsId)) {
/* 31:39 */         resultMap.put("error", "未发现传递的参数值。");
/* 32:   */       }
/* 33:41 */       NewsEntity newsEntity = this.newService.selectByPrimaryKey(newsId);
/* 34:42 */       model.addAttribute("newsEntity", newsEntity);
/* 35:43 */       return "detail";
/* 36:   */     }
/* 37:   */     catch (Exception ex)
/* 38:   */     {
/* 39:46 */       ex.printStackTrace();
/* 40:   */     }
/* 41:47 */     return "detail";
/* 42:   */   }
/* 43:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.news.NewsFrontController

 * JD-Core Version:    0.7.0.1

 */