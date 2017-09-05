/*  1:   */ package com.brave.feature.controller.userinfo;
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
/* 16:   */ public class Update_password
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   public UserService userService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/uptate_password"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> uptate_userinfo_juli(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:37 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:40 */       req.setCharacterEncoding("utf-8");
/* 29:41 */       resp.setCharacterEncoding("utf-8");
/* 30:42 */       String password = req.getParameter("password");
/* 31:43 */       String username = req.getParameter("username");
/* 32:44 */       Map<String, Object> userMap = new HashMap();
/* 33:45 */       userMap.put("Username", username);
/* 34:46 */       userMap.put("Password", password);
/* 35:47 */       int list = this.userService.updateUserinfoPassword(userMap);
/* 36:   */       
/* 37:49 */       map.put("data", list + "");
/* 38:50 */       return map;
/* 39:   */     }
/* 40:   */     catch (Exception ex)
/* 41:   */     {
/* 42:53 */       ex.printStackTrace();
/* 43:54 */       map.put("error", ex.getMessage());
/* 44:   */     }
/* 45:55 */     return map;
/* 46:   */   }
/* 47:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Update_password

 * JD-Core Version:    0.7.0.1

 */