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
/* 16:   */ public class Update_supporters_channelid
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private UserService userService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/Update_supporters_channelid"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> uptate_supporters(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:36 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:39 */       req.setCharacterEncoding("utf-8");
/* 29:40 */       resp.setCharacterEncoding("utf-8");
/* 30:   */       
/* 31:42 */       String username = req.getParameter("username");
/* 32:43 */       String channelid = req.getParameter("channelid");
/* 33:44 */       Map<String, Object> userMap = new HashMap();
/* 34:45 */       userMap.put("Username", username);
/* 35:46 */       userMap.put("Channelid", channelid);
/* 36:47 */       int i = this.userService.updateUserinfoChannelIdByusername(userMap);
/* 37:   */       
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

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Update_supporters_channelid

 * JD-Core Version:    0.7.0.1

 */