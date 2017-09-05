/*  1:   */ package com.brave.feature.controller.userinfo;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.UserService;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.text.SimpleDateFormat;
/*  6:   */ import java.util.Date;
/*  7:   */ import java.util.HashMap;
/*  8:   */ import java.util.List;
/*  9:   */ import java.util.Map;
/* 10:   */ import javax.servlet.http.HttpServletRequest;
/* 11:   */ import javax.servlet.http.HttpServletResponse;
/* 12:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 13:   */ import org.springframework.stereotype.Controller;
/* 14:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 15:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ public class UpdateShareInfo
/* 19:   */ {
/* 20:   */   @Autowired
/* 21:   */   private UserService userService;
/* 22:   */   
/* 23:   */   @ResponseBody
/* 24:   */   @RequestMapping(value={"/UpdateShareInfo"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 25:   */   public Map<String, Object> share_addPoints(HttpServletRequest req, HttpServletResponse resp)
/* 26:   */   {
/* 27:35 */     Map<String, Object> map = new HashMap();
/* 28:   */     try
/* 29:   */     {
/* 30:38 */       req.setCharacterEncoding("utf-8");
/* 31:39 */       resp.setCharacterEncoding("utf-8");
/* 32:40 */       String username = req.getParameter("username");
/* 33:41 */       System.out.println("username:" + username);
/* 34:42 */       List<Map<String, Object>> list = this.userService.selectShareInfoByUsername(username);
/* 35:43 */       int sharetimes = Integer.parseInt(((Map)list.get(0)).get("sharetimes").toString());
/* 36:   */       
/* 37:45 */       int lastSharetime = Integer.parseInt(((Map)list.get(0)).get("lastSharetime").toString());
/* 38:46 */       if (lastSharetime > 0) {
/* 39:47 */         sharetimes = 0;
/* 40:   */       }
/* 41:49 */       if (sharetimes >= 5)
/* 42:   */       {
/* 43:50 */         map.put("status", "2");
/* 44:51 */         return map;
/* 45:   */       }
/* 46:53 */       int totalSharetimes = Integer.parseInt(((Map)list.get(0)).get("totalSharetimes").toString());
/* 47:54 */       totalSharetimes++;
/* 48:55 */       sharetimes++;
/* 49:56 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/* 50:57 */       String sharetime = df.format(new Date());
/* 51:58 */       Map<String, Object> usermap = new HashMap();
/* 52:59 */       usermap.put("Username", username);
/* 53:60 */       usermap.put("TotalSharetimes", totalSharetimes + "");
/* 54:61 */       usermap.put("Sharetimes", sharetimes + "");
/* 55:62 */       usermap.put("LastSharetime", sharetime);
/* 56:63 */       int i = this.userService.updateShareInfoByUsername(usermap);
/* 57:64 */       map.put("status", i + "");
/* 58:65 */       return map;
/* 59:   */     }
/* 60:   */     catch (Exception ex)
/* 61:   */     {
/* 62:68 */       ex.printStackTrace();
/* 63:69 */       map.put("error", ex.getMessage());
/* 64:   */     }
/* 65:70 */     return map;
/* 66:   */   }
/* 67:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.UpdateShareInfo

 * JD-Core Version:    0.7.0.1

 */