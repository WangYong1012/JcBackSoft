/*  1:   */ package com.brave.feature.controller.me;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.UserService;
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
/* 16:   */ public class Operation_itme
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private UserService userService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/operation_itme"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> operation_itme(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:35 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:38 */       req.setCharacterEncoding("utf-8");
/* 29:39 */       resp.setCharacterEncoding("utf-8");
/* 30:40 */       String operationdate = req.getParameter("operation_itme");
/* 31:41 */       String username = req.getParameter("username");
/* 32:42 */       Map<String, Object> userMap = new HashMap();
/* 33:43 */       userMap.put("Operationdate", operationdate);
/* 34:44 */       userMap.put("Username", username);
/* 35:45 */       int list = this.userService.updateUserinfoOperationdate(userMap);
/* 36:46 */       map.put("data", list + "");
/* 37:47 */       return map;
/* 38:   */     }
/* 39:   */     catch (Exception ex)
/* 40:   */     {
/* 41:50 */       ex.printStackTrace();
/* 42:51 */       map.put("error", ex.getMessage());
/* 43:   */     }
/* 44:52 */     return map;
/* 45:   */   }
/* 46:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.me.Operation_itme

 * JD-Core Version:    0.7.0.1

 */