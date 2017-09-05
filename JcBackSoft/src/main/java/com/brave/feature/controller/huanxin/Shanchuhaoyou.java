/*  1:   */ package com.brave.feature.controller.huanxin;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.FriendService;
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
/* 16:   */ public class Shanchuhaoyou
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private FriendService friendService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/shanchuhaoyou"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> shanchuhaoyou(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:37 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:40 */       req.setCharacterEncoding("utf-8");
/* 29:41 */       resp.setCharacterEncoding("utf-8");
/* 30:42 */       String username = req.getParameter("username");
/* 31:43 */       String friendusername = req.getParameter("friendusername");
/* 32:44 */       Map<String, Object> friendMap = new HashMap();
/* 33:45 */       friendMap.put("Username", username);
/* 34:46 */       friendMap.put("FriendUsername", friendusername);
/* 35:47 */       int fri = this.friendService.deleteFriend(friendMap);
/* 36:48 */       if (fri == 0)
/* 37:   */       {
/* 38:49 */         friendMap.put("Username", friendusername);
/* 39:50 */         friendMap.put("FriendUsername", username);
/* 40:51 */         fri = this.friendService.deleteFriend(friendMap);
/* 41:   */       }
/* 42:53 */       map.put("bendi", fri + "");
/* 43:54 */       return map;
/* 44:   */     }
/* 45:   */     catch (Exception ex)
/* 46:   */     {
/* 47:57 */       ex.printStackTrace();
/* 48:58 */       map.put("error", ex.getMessage());
/* 49:   */     }
/* 50:59 */     return map;
/* 51:   */   }
/* 52:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.huanxin.Shanchuhaoyou

 * JD-Core Version:    0.7.0.1

 */