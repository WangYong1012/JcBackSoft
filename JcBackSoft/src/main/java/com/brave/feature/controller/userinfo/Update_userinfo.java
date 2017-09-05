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
/* 16:   */ public class Update_userinfo
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   public UserService userService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/uptate_userinfo"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> uptate_userinfo_juli(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:36 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:39 */       req.setCharacterEncoding("utf-8");
/* 29:40 */       resp.setCharacterEncoding("utf-8");
/* 30:41 */       String longitude = req.getParameter("longitude");
/* 31:42 */       String latitude = req.getParameter("latitude");
/* 32:43 */       String area = req.getParameter("area");
/* 33:44 */       String username = req.getParameter("username");
/* 34:45 */       Map<String, Object> userMap = new HashMap();
/* 35:46 */       userMap.put("Longitude", longitude);
/* 36:47 */       userMap.put("Latitude", latitude);
/* 37:48 */       userMap.put("Area", area);
/* 38:49 */       userMap.put("Username", username);
/* 39:50 */       int list = this.userService.updateUserinfoLatitudeAndLongitude(userMap);
/* 40:   */       
/* 41:52 */       map.put("data", list + "");
/* 42:53 */       return map;
/* 43:   */     }
/* 44:   */     catch (Exception ex)
/* 45:   */     {
/* 46:56 */       ex.printStackTrace();
/* 47:57 */       map.put("error", ex.getMessage());
/* 48:   */     }
/* 49:58 */     return map;
/* 50:   */   }
/* 51:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Update_userinfo

 * JD-Core Version:    0.7.0.1

 */