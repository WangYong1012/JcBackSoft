/*  1:   */ package com.brave.feature.controller.huanxin;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.FriendService;
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
/* 17:   */ public class Tianjiahaoyou
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private FriendService friendService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/tianjiahaoyou"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> tianjiahaoyou(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:38 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:41 */       req.setCharacterEncoding("utf-8");
/* 30:42 */       resp.setCharacterEncoding("utf-8");
/* 31:43 */       String username = req.getParameter("username");
/* 32:44 */       String userphone = req.getParameter("userphone");
/* 33:45 */       String friendusername = req.getParameter("friendusername");
/* 34:46 */       String friendphone = req.getParameter("friendphone");
/* 35:47 */       String friendstatr = "0";
/* 36:48 */       Map<String, Object> friendMap = new HashMap();
/* 37:49 */       friendMap.put("Username", username);
/* 38:50 */       friendMap.put("Userphone", userphone);
/* 39:51 */       friendMap.put("FriendUsername", friendusername);
/* 40:52 */       friendMap.put("Friendphone", friendphone);
/* 41:53 */       friendMap.put("Friendstatr", friendstatr);
/* 42:   */       
/* 43:55 */       int i = 0;
/* 44:56 */       List<Map<String, Object>> list = this.friendService.selectFriendState(friendMap);
/* 45:57 */       if ((list.size() == 0) && (list != null)) {
/* 46:58 */         i = this.friendService.insertFriend(friendMap);
/* 47:   */       }
/* 48:60 */       map.put("bendi", i + "");
/* 49:61 */       return map;
/* 50:   */     }
/* 51:   */     catch (Exception ex)
/* 52:   */     {
/* 53:64 */       ex.printStackTrace();
/* 54:65 */       map.put("error", ex.getMessage());
/* 55:   */     }
/* 56:66 */     return map;
/* 57:   */   }
/* 58:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.huanxin.Tianjiahaoyou

 * JD-Core Version:    0.7.0.1

 */