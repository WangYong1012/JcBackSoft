/*   1:    */ package com.brave.feature.controller.homepage;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.FirsthandResourcesService;
/*   4:    */ import com.brave.feature.service.UserService;
/*   5:    */ import java.io.PrintStream;
/*   6:    */ import java.text.SimpleDateFormat;
/*   7:    */ import java.util.Date;
/*   8:    */ import java.util.HashMap;
/*   9:    */ import java.util.List;
/*  10:    */ import java.util.Map;
/*  11:    */ import javax.servlet.http.HttpServletRequest;
/*  12:    */ import javax.servlet.http.HttpServletResponse;
/*  13:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  14:    */ import org.springframework.context.annotation.Scope;
/*  15:    */ import org.springframework.stereotype.Controller;
/*  16:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  17:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  18:    */ 
/*  19:    */ @Controller
/*  20:    */ @Scope("prototype")
/*  21:    */ public class Select_authentication_status
/*  22:    */ {
/*  23:    */   @Autowired
/*  24:    */   private FirsthandResourcesService service;
/*  25:    */   @Autowired
/*  26:    */   private UserService userService;
/*  27:    */   
/*  28:    */   @ResponseBody
/*  29:    */   @RequestMapping(value={"/select_authentication_status"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  30:    */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/*  31:    */   {
/*  32: 43 */     Map<String, Object> map = new HashMap();
/*  33:    */     try
/*  34:    */     {
/*  35: 46 */       req.setCharacterEncoding("utf-8");
/*  36: 47 */       resp.setCharacterEncoding("utf-8");
/*  37: 48 */       String username = req.getParameter("username");
/*  38: 49 */       Map<String, Object> selectMyDataMap = new HashMap();
/*  39: 50 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*  40: 51 */       String Now = df.format(new Date());
/*  41: 52 */       List<Map<String, Object>> list3 = this.userService.selectAuthenticationStatusList();
/*  42: 53 */       Date date = new Date();
/*  43: 54 */       Map<String, Object> map2 = new HashMap();
/*  44:    */       try
/*  45:    */       {
/*  46: 56 */         for (int i = 0; i < list3.size(); i++)
/*  47:    */         {
/*  48: 57 */           String username1 = ((Map)list3.get(i)).get("username").toString();
/*  49: 58 */           String status = ((Map)list3.get(i)).get("authenticationStatus").toString();
/*  50: 59 */           List<Map<String, Object>> list2 = this.service.selectAuthenticationInfo(username1);
/*  51: 60 */           if (list2.size() < 1)
/*  52:    */           {
/*  53: 61 */             System.out.println("username1:" + username1);
/*  54:    */           }
/*  55:    */           else
/*  56:    */           {
/*  57: 64 */             String duedate = ((Map)list2.get(0)).get("duedate").toString();
/*  58: 65 */             date.setTime(df.parse(duedate).getTime() - 259200000L);
/*  59: 66 */             if ((df.parse(Now).getTime() - date.getTime() > 0L) && ("1".equals(status)))
/*  60:    */             {
/*  61: 67 */               map2.put("Status", "2");
/*  62: 68 */               map2.put("Username", username1);
/*  63: 69 */               this.service.update_firsthand_status(map2);
/*  64:    */             }
/*  65: 71 */             else if ((df.parse(Now).getTime() - df.parse(duedate).getTime() > 0L) && ("2".equals(status)))
/*  66:    */             {
/*  67: 72 */               map2.put("Status", "3");
/*  68: 73 */               map2.put("Username", username1);
/*  69: 74 */               this.service.update_firsthand_status(map2);
/*  70:    */             }
/*  71: 76 */             map2.clear();
/*  72:    */           }
/*  73:    */         }
/*  74:    */       }
/*  75:    */       catch (Exception e)
/*  76:    */       {
/*  77: 79 */         e.printStackTrace();
/*  78:    */       }
/*  79: 81 */       selectMyDataMap.put("Username", username);
/*  80: 82 */       System.out.println("username:" + username);
/*  81: 83 */       List list1 = this.userService.selectMydata(selectMyDataMap);
/*  82: 84 */       String userIdentity = "";
/*  83:    */       
/*  84: 86 */       List list = this.service.selectAuthenticationStatus(username);
/*  85: 87 */       if (list.size() < 1) {
/*  86: 88 */         return null;
/*  87:    */       }
/*  88: 90 */       System.out.println("list:" + list.toString());
/*  89: 91 */       String status = ((Map)list.get(0)).get("status").toString();
/*  90: 92 */       System.out.println("status:" + status);
/*  91: 93 */       String type = "";
/*  92: 94 */       if (("1".equals(status)) || ("2".equals(status)))
/*  93:    */       {
/*  94: 95 */         List list2 = this.service.selectAuthenticationTypeByUsername(username);
/*  95: 96 */         if (list2.size() > 0)
/*  96:    */         {
/*  97: 97 */           type = ((Map)list2.get(0)).get("type").toString();
/*  98: 98 */           ((Map)list.get(0)).put("type", type);
/*  99:    */         }
/* 100:    */       }
/* 101:101 */       if (list1.size() > 0)
/* 102:    */       {
/* 103:102 */         userIdentity = ((Map)list1.get(0)).get("useridentity").toString();
/* 104:103 */         System.out.println("userIdentity:" + userIdentity);
/* 105:104 */         if ("有票企业".equals(userIdentity))
/* 106:    */         {
/* 107:105 */           userIdentity = "企业";
/* 108:106 */           ((Map)list.get(0)).put("type", userIdentity);
/* 109:    */         }
/* 110:    */       }
/* 111:109 */       map.put("data", list);
/* 112:110 */       return map;
/* 113:    */     }
/* 114:    */     catch (Exception ex)
/* 115:    */     {
/* 116:113 */       ex.printStackTrace();
/* 117:114 */       map.put("error", ex.getMessage());
/* 118:    */     }
/* 119:115 */     return map;
/* 120:    */   }
/* 121:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Select_authentication_status

 * JD-Core Version:    0.7.0.1

 */