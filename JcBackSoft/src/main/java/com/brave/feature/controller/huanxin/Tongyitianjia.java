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
/* 16:   */ public class Tongyitianjia
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private FriendService friendService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/tongyihaoyou"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> tongyitianjia(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:37 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:40 */       req.setCharacterEncoding("utf-8");
/* 29:41 */       resp.setCharacterEncoding("utf-8");
/* 30:42 */       String username = req.getParameter("friendusername");
/* 31:43 */       String friendusername = req.getParameter("username");
/* 32:   */       
/* 33:45 */       Map<String, Object> friendMap = new HashMap();
/* 34:46 */       friendMap.put("Username", username);
/* 35:47 */       friendMap.put("FriendUsername", friendusername);
/* 36:48 */       int fri = this.friendService.updateFriend(friendMap);
/* 37:49 */       if (fri < 1)
/* 38:   */       {
/* 39:50 */         friendMap.put("Username", friendusername);
/* 40:51 */         friendMap.put("FriendUsername", username);
/* 41:52 */         fri = this.friendService.updateFriend(friendMap);
/* 42:   */       }
/* 43:54 */       map.put("bendi", fri + "");
/* 44:55 */       return map;
/* 45:   */     }
/* 46:   */     catch (Exception ex)
/* 47:   */     {
/* 48:58 */       ex.printStackTrace();
/* 49:59 */       map.put("error", ex.getMessage());
/* 50:   */     }
/* 51:60 */     return map;
/* 52:   */   }
/* 53:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.huanxin.Tongyitianjia

 * JD-Core Version:    0.7.0.1

 */