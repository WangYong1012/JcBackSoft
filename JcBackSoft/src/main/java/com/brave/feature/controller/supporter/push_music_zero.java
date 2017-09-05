/*  1:   */ package com.brave.feature.controller.supporter;
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
/* 16:   */ public class push_music_zero
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private UserService userService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/Push_music_zero"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> insert_channelid(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:37 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:40 */       req.setCharacterEncoding("utf-8");
/* 29:41 */       resp.setCharacterEncoding("utf-8");
/* 30:42 */       String channelid = req.getParameter("channelid");
/* 31:43 */       Map<String, Object> userMap = new HashMap();
/* 32:44 */       userMap.put("Channelid", channelid);
/* 33:45 */       int list = this.userService.updateUserinfoPushmusicZero(userMap);
/* 34:46 */       map.put("data", list + "");
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

 * Qualified Name:     com.jcsoft.feature.controller.supporter.push_music_zero

 * JD-Core Version:    0.7.0.1

 */