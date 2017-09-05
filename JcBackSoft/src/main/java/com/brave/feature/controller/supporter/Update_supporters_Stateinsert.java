/*  1:   */ package com.brave.feature.controller.supporter;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.SupporterService;
/*  4:   */ import java.util.HashMap;
/*  5:   */ import java.util.Map;
/*  6:   */ import javax.servlet.http.HttpServletRequest;
/*  7:   */ import javax.servlet.http.HttpServletResponse;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.context.annotation.Scope;
/* 10:   */ import org.springframework.stereotype.Controller;
/* 11:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 12:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 13:   */ 
/* 14:   */ @Controller
/* 15:   */ @Scope("prototype")
/* 16:   */ public class Update_supporters_Stateinsert
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private SupporterService supporterService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/Update_supporters_insert"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> uptate_collect_insert(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:36 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:39 */       req.setCharacterEncoding("utf-8");
/* 29:40 */       resp.setCharacterEncoding("utf-8");
/* 30:   */       
/* 31:42 */       String username = req.getParameter("username");
/* 32:43 */       Map<String, Object> supportersMap = new HashMap();
/* 33:44 */       supportersMap.put("Username", username);
/* 34:45 */       int i = this.supporterService.updateSupportersCollectstateOne(supportersMap);
/* 35:   */       
/* 36:47 */       map.put("data", i + "");
/* 37:48 */       return map;
/* 38:   */     }
/* 39:   */     catch (Exception ex)
/* 40:   */     {
/* 41:51 */       ex.printStackTrace();
/* 42:52 */       map.put("error", ex.getMessage());
/* 43:   */     }
/* 44:53 */     return map;
/* 45:   */   }
/* 46:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.supporter.Update_supporters_Stateinsert

 * JD-Core Version:    0.7.0.1

 */