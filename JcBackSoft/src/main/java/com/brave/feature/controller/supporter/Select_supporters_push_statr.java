/*  1:   */ package com.brave.feature.controller.supporter;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.SupporterService;
/*  4:   */ import java.util.HashMap;
/*  5:   */ import java.util.List;
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
/* 17:   */ public class Select_supporters_push_statr
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private SupporterService supporterService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/Select_supporters_push_statr"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> select_supporters_push_statr(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:38 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:41 */       req.setCharacterEncoding("utf-8");
/* 30:42 */       resp.setCharacterEncoding("utf-8");
/* 31:43 */       String username = req.getParameter("username");
/* 32:44 */       List<Map<String, Object>> mun = this.supporterService.selectPushstatrsupportersByName(username);
/* 33:   */       
/* 34:46 */       map.put("data", mun);
/* 35:47 */       return map;
/* 36:   */     }
/* 37:   */     catch (Exception ex)
/* 38:   */     {
/* 39:50 */       ex.printStackTrace();
/* 40:51 */       map.put("error", ex.getMessage());
/* 41:   */     }
/* 42:52 */     return map;
/* 43:   */   }
/* 44:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.supporter.Select_supporters_push_statr

 * JD-Core Version:    0.7.0.1

 */