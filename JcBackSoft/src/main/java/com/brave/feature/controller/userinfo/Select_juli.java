/*  1:   */ package com.brave.feature.controller.userinfo;
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
/* 17:   */ public class Select_juli
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private UserService userService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/select_juli"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> select_supporters(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:38 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:41 */       req.setCharacterEncoding("utf-8");
/* 30:42 */       resp.setCharacterEncoding("utf-8");
/* 31:   */       
/* 32:44 */       String log1 = req.getParameter("log1");
/* 33:   */       
/* 34:46 */       String lat1 = req.getParameter("lat1");
/* 35:47 */       Map<String, Object> userMap = new HashMap();
/* 36:48 */       userMap.put("Log1", log1);
/* 37:49 */       userMap.put("Lat1", lat1);
/* 38:   */       
/* 39:51 */       List<Map<String, Object>> list = this.userService.selectUserinfoJuliByLatitudeAndLongitude(userMap);
/* 40:   */       
/* 41:53 */       map.put("data", list);
/* 42:54 */       return map;
/* 43:   */     }
/* 44:   */     catch (Exception ex)
/* 45:   */     {
/* 46:57 */       ex.printStackTrace();
/* 47:58 */       map.put("error", ex.getMessage());
/* 48:   */     }
/* 49:59 */     return map;
/* 50:   */   }
/* 51:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Select_juli

 * JD-Core Version:    0.7.0.1

 */