/*  1:   */ package com.brave.feature.controller.userinfo;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.SystemService;
/*  4:   */ import com.brave.feature.service.UserService;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import java.util.List;
/*  7:   */ import java.util.Map;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import javax.servlet.http.HttpServletResponse;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.context.annotation.Scope;
/* 12:   */ import org.springframework.stereotype.Controller;
/* 13:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 14:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 15:   */ 
/* 16:   */ @Controller
/* 17:   */ @Scope("prototype")
/* 18:   */ public class Update_banben
/* 19:   */ {
/* 20:   */   @Autowired
/* 21:   */   public UserService userService;
/* 22:   */   @Autowired
/* 23:   */   private SystemService systemService;
/* 24:   */   
/* 25:   */   @ResponseBody
/* 26:   */   @RequestMapping(value={"/update_banben"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 27:   */   public Map<String, Object> update_banben(HttpServletRequest req, HttpServletResponse resp)
/* 28:   */   {
/* 29:41 */     Map<String, Object> map = new HashMap();
/* 30:   */     try
/* 31:   */     {
/* 32:44 */       req.setCharacterEncoding("utf-8");
/* 33:45 */       resp.setCharacterEncoding("utf-8");
/* 34:46 */       String banben_num = req.getParameter("version");
/* 35:47 */       String username = req.getParameter("username");
/* 36:   */       
/* 37:49 */       Map<String, Object> usermap = new HashMap();
/* 38:50 */       usermap.put("Hxid", username);
/* 39:51 */       usermap.put("Adver", banben_num);
/* 40:52 */       this.userService.updateUserinfoAdver(usermap);
/* 41:53 */       List<Map<String, Object>> list_rtn = this.systemService.selectSystem();
/* 42:54 */       String banben = ((Map)list_rtn.get(0)).get("version").toString();
/* 43:55 */       String version = ((Map)list_rtn.get(0)).get("url").toString();
/* 44:56 */       map.put("banben", banben);
/* 45:57 */       map.put("update", version);
/* 46:58 */       return map;
/* 47:   */     }
/* 48:   */     catch (Exception ex)
/* 49:   */     {
/* 50:61 */       ex.printStackTrace();
/* 51:62 */       map.put("error", ex.getMessage());
/* 52:   */     }
/* 53:63 */     return map;
/* 54:   */   }
/* 55:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Update_banben

 * JD-Core Version:    0.7.0.1

 */