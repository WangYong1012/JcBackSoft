/*  1:   */ package com.brave.feature.controller.supporter;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.SupporterService;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import java.util.Map;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import javax.servlet.http.HttpServletResponse;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.context.annotation.Scope;
/* 11:   */ import org.springframework.stereotype.Controller;
/* 12:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 13:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 14:   */ 
/* 15:   */ @Controller
/* 16:   */ @Scope("prototype")
/* 17:   */ public class Genggaijingweidu
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private SupporterService supporterService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/genggaijingweidu"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> genggaijingweidu(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:37 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:40 */       req.setCharacterEncoding("utf-8");
/* 30:41 */       resp.setCharacterEncoding("utf-8");
/* 31:42 */       String username = req.getParameter("username");
/* 32:43 */       String supportersid = req.getParameter("supportersid");
/* 33:44 */       Map<String, Object> supportersMap = new HashMap();
/* 34:45 */       supportersMap.put("Username", username);
/* 35:46 */       supportersMap.put("Supportersid", supportersid);
/* 36:47 */       System.out.println("genggaijingweidu:" + username);
/* 37:48 */       int i = this.supporterService.updateSupportersTitude(supportersMap);
/* 38:49 */       map.put("data", i + "");
/* 39:50 */       return map;
/* 40:   */     }
/* 41:   */     catch (Exception ex)
/* 42:   */     {
/* 43:53 */       ex.printStackTrace();
/* 44:54 */       map.put("error", ex.getMessage());
/* 45:   */     }
/* 46:55 */     return map;
/* 47:   */   }
/* 48:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.supporter.Genggaijingweidu

 * JD-Core Version:    0.7.0.1

 */