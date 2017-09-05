/*  1:   */ package com.brave.feature.controller.userinfo;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.UserService;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.util.HashMap;
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
/* 17:   */ public class Update_version
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   public UserService userService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/check_version"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> update_version(HttpServletRequest request, HttpServletResponse response)
/* 25:   */   {
/* 26:37 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:40 */       String version = request.getParameter("version");
/* 30:41 */       String hxid = request.getParameter("hxid");
/* 31:42 */       String plat = request.getParameter("plat");
/* 32:43 */       System.out.println("vesion : " + version);
/* 33:44 */       System.out.println("hxid : " + hxid);
/* 34:45 */       System.out.println("plat : " + plat);
/* 35:   */       
/* 36:47 */       version = version == null ? "" : version;
/* 37:48 */       hxid = hxid == null ? "" : hxid;
/* 38:49 */       plat = plat == null ? "" : plat;
/* 39:   */       
/* 40:51 */       System.out.println("vesion : " + version);
/* 41:52 */       System.out.println("hxid : " + hxid);
/* 42:53 */       System.out.println("plat : " + plat);
/* 43:   */       int i;
/* 45:56 */       if (plat.equals("ios"))
/* 46:   */       {
/* 47:57 */         Map<String, Object> UserInfoMap = new HashMap();
/* 48:58 */         UserInfoMap.put("Iosver", version);
/* 49:59 */         UserInfoMap.put("Hxid", hxid);
/* 50:60 */         i = this.userService.updateUserinfoIosver(UserInfoMap);
/* 51:   */       }
/* 52:   */       else
/* 53:   */       {
/* 54:62 */         Map<String, Object> UserInfoMap = new HashMap();
/* 55:63 */         UserInfoMap.put("Adver", version);
/* 56:64 */         UserInfoMap.put("Hxid", hxid);
/* 57:65 */         i = this.userService.updateUserinfoAdver(UserInfoMap);
/* 58:   */       }
/* 59:67 */       map.put("data", i + "");
/* 60:68 */       return map;
/* 61:   */     }
/* 62:   */     catch (Exception ex)
/* 63:   */     {
/* 64:71 */       ex.printStackTrace();
/* 65:72 */       map.put("error", ex.getMessage());
/* 66:   */     }
/* 67:73 */     return map;
/* 68:   */   }
/* 69:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Update_version

 * JD-Core Version:    0.7.0.1

 */