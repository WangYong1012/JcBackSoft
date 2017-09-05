/*  1:   */ package com.brave.feature.controller.homepage;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.FirsthandResourcesService;
/*  4:   */ import com.brave.feature.service.UserService;
/*  5:   */ import java.io.PrintStream;
/*  6:   */ import java.text.SimpleDateFormat;
/*  7:   */ import java.util.Date;
/*  8:   */ import java.util.HashMap;
/*  9:   */ import java.util.List;
/* 10:   */ import java.util.Map;
/* 11:   */ import javax.servlet.http.HttpServletRequest;
/* 12:   */ import javax.servlet.http.HttpServletResponse;
/* 13:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 14:   */ import org.springframework.context.annotation.Scope;
/* 15:   */ import org.springframework.stereotype.Controller;
/* 16:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 17:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 18:   */ 
/* 19:   */ @Controller
/* 20:   */ @Scope("prototype")
/* 21:   */ public class Update_authentication_status
/* 22:   */ {
/* 23:   */   @Autowired
/* 24:   */   private FirsthandResourcesService service;
/* 25:   */   @Autowired
/* 26:   */   private UserService userService;
/* 27:   */   
/* 28:   */   @ResponseBody
/* 29:   */   @RequestMapping(value={"/update_authentication_status"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 30:   */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/* 31:   */   {
/* 32:43 */     Map<String, Object> map = new HashMap();
/* 33:   */     try
/* 34:   */     {
/* 35:46 */       req.setCharacterEncoding("utf-8");
/* 36:47 */       resp.setCharacterEncoding("utf-8");
/* 37:48 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/* 38:49 */       String Now = df.format(new Date());
/* 39:50 */       List<Map<String, Object>> list = this.userService.selectAuthenticationStatusList();
/* 40:   */       
/* 41:52 */       Date date = new Date();
/* 42:53 */       Map<String, Object> map1 = new HashMap();
/* 43:   */       try
/* 44:   */       {
/* 45:55 */         for (int i = 0; i < list.size(); i++)
/* 46:   */         {
/* 47:56 */           String username = ((Map)list.get(i)).get("username").toString();
/* 48:57 */           String status = ((Map)list.get(i)).get("authenticationStatus").toString();
/* 49:58 */           List<Map<String, Object>> list2 = this.service.selectAuthenticationInfo(username);
/* 50:59 */           System.out.println(list2.size());
/* 51:60 */           if (list2.size() >= 1)
/* 52:   */           {
/* 53:63 */             String duedate = ((Map)list2.get(0)).get("duedate").toString();
/* 54:64 */             date.setTime(df.parse(duedate).getTime() - 259200000L);
/* 55:65 */             if ((df.parse(Now).getTime() - date.getTime() > 0L) && ("1".equals(status))) {
/* 56:66 */               map.put("Status", "2");
/* 57:68 */             } else if ((df.parse(Now).getTime() - df.parse(duedate).getTime() > 0L) && ("2".equals(status))) {
/* 58:69 */               map.put("Status", "3");
/* 59:   */             }
/* 60:71 */             map.put("Username", username);
/* 61:72 */             this.service.update_firsthand_status(map);
/* 62:73 */             map.clear();
/* 63:   */           }
/* 64:   */         }
/* 65:75 */         map1.put("data", "1");
/* 66:   */       }
/* 67:   */       catch (Exception e)
/* 68:   */       {
/* 69:77 */         map1.put("data", "0");
/* 70:78 */         e.printStackTrace();
/* 71:   */       }
/* 72:80 */       return map;
/* 73:   */     }
/* 74:   */     catch (Exception ex)
/* 75:   */     {
/* 76:83 */       ex.printStackTrace();
/* 77:84 */       map.put("error", ex.getMessage());
/* 78:   */     }
/* 79:85 */     return map;
/* 80:   */   }
/* 81:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Update_authentication_status

 * JD-Core Version:    0.7.0.1

 */