/*  1:   */ package com.brave.feature.controller.me;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.UserService;
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
/* 17:   */ public class Select_userifo_username
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private UserService userService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/select_userinfo_username"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> select_userinfo_username(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:38 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:41 */       req.setCharacterEncoding("utf-8");
/* 30:42 */       resp.setCharacterEncoding("utf-8");
/* 31:43 */       Map<String, Object> usermap = new HashMap();
/* 32:44 */       String username = req.getParameter("username");
/* 33:45 */       usermap.put("Username", username);
/* 34:46 */       List<Map<String, Object>> list = this.userService.selectMydata(usermap);
/* 35:47 */       List<Map<String, Object>> zuobiao = this.userService.selectTitudeAll();
/* 36:48 */       map.put("data", list);
/* 37:49 */       map.put("zuobiao", zuobiao);
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

 * Qualified Name:     com.jcsoft.feature.controller.me.Select_userifo_username

 * JD-Core Version:    0.7.0.1

 */