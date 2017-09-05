/*   1:    */ package com.brave.feature.controller.thisticket;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.FirsthandResourcesService;
/*   4:    */ import com.brave.feature.service.ThisticketService;
/*   5:    */ import com.brave.feature.service.UserService;
/*   6:    */ import com.brave.feature.util.PageUtil;
/*   7:    */ import com.brave.system.util.DistanceUtil;
/*   8:    */ import java.io.PrintStream;
/*   9:    */ import java.text.ParseException;
/*  10:    */ import java.text.SimpleDateFormat;
/*  11:    */ import java.util.Date;
/*  12:    */ import java.util.HashMap;
/*  13:    */ import java.util.List;
/*  14:    */ import java.util.Map;
/*  15:    */ import javax.servlet.http.HttpServletRequest;
/*  16:    */ import javax.servlet.http.HttpServletResponse;
/*  17:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  18:    */ import org.springframework.stereotype.Controller;
/*  19:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  20:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  21:    */ 
/*  22:    */ @Controller
/*  23:    */ public class Select_thisticket
/*  24:    */ {
/*  25: 33 */   private int pagesize = 10;
/*  26:    */   @Autowired
/*  27:    */   private FirsthandResourcesService service;
/*  28:    */   @Autowired
/*  29:    */   private ThisticketService thisticketService;
/*  30:    */   @Autowired
/*  31:    */   private UserService userService;
/*  32:    */   
/*  33:    */   @ResponseBody
/*  34:    */   @RequestMapping(value={"/select_thisticket"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  35:    */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/*  36:    */   {
/*  37: 45 */     Map<String, Object> map = new HashMap();
/*  38:    */     try
/*  39:    */     {
/*  40: 48 */       req.setCharacterEncoding("utf-8");
/*  41: 49 */       resp.setCharacterEncoding("utf-8");
/*  42: 50 */       String longitude = req.getParameter("jingdu");
/*  43: 51 */       String latitude = req.getParameter("weidu");
/*  44: 52 */       int pageindex = Integer.parseInt(req.getParameter("pageindex"));
/*  45: 53 */       String username = req.getParameter("username");
/*  46:    */       
/*  47: 55 */       Map<String, Object> selectMyDataMap = new HashMap();
/*  48: 56 */       if (1 == pageindex)
/*  49:    */       {
/*  50: 57 */         selectMyDataMap.put("Username", username);
/*  51: 58 */         System.out.println("username:" + username);
/*  52: 59 */         List<Map<String, Object>> list3 = this.userService.selectMydata(selectMyDataMap);
/*  53:    */         
/*  54: 61 */         List<Map<String, Object>> list1 = this.service.selectAuthenticationStatus(username);
/*  55: 62 */         if (list1.size() < 1) {
/*  56: 63 */           return null;
/*  57:    */         }
/*  58: 65 */         List<Map<String, Object>> list2 = this.service.selectAuthenticationTypeByUsername(username);
/*  59: 66 */         String pages = null;
/*  60: 67 */         String type = "";
/*  61: 68 */         if (list3.size() > 0)
/*  62:    */         {
/*  63: 69 */           String userIdentity = ((Map)list3.get(0)).get("useridentity").toString();
/*  64: 70 */           System.out.println("userIdentity:" + userIdentity);
/*  65: 71 */           if ("有票企业".equals(userIdentity)) {
/*  66: 72 */             type = "企业";
/*  67:    */           }
/*  68:    */         }
/*  69: 75 */         String status = ((Map)list1.get(0)).get("status").toString();
/*  70: 77 */         if ((list2.size() > 0) && (("1".equals(status)) || ("2".equals(status))))
/*  71:    */         {
/*  72: 78 */           type = ((Map)list2.get(0)).get("type").toString();
/*  73: 79 */           System.out.println("type:" + type);
/*  74:    */         }
/*  75: 81 */         System.out.println("status:" + status);
/*  76: 82 */         System.out.println("now:" + ((Map)list1.get(0)).toString());
/*  77: 83 */         System.out.println(longitude);
/*  78: 84 */         System.out.println(latitude);
/*  79: 85 */         int amount = this.thisticketService.selectThisticketAmount();
/*  80: 87 */         if (amount % this.pagesize == 0) {
/*  81: 88 */           pages = amount / this.pagesize + "";
/*  82:    */         } else {
/*  83: 90 */           pages = amount / this.pagesize + 1 + "";
/*  84:    */         }
/*  85: 92 */         map.put("status", status);
/*  86: 93 */         map.put("pages", pages);
/*  87: 94 */         map.put("type", type);
/*  88:    */       }
/*  89: 97 */       Map<String, Object> thisticketmap = new HashMap();
/*  90: 98 */       thisticketmap.put("Lat1", latitude);
/*  91: 99 */       thisticketmap.put("Log1", longitude);
/*  92:100 */       thisticketmap.put("Pageindex", PageUtil.getStartRow(pageindex, this.pagesize));
/*  93:101 */       thisticketmap.put("Pagesize", Integer.valueOf(this.pagesize));
/*  94:102 */       List<Map<String, Object>> list = this.thisticketService.selectThisticketList(thisticketmap);
/*  95:    */       
/*  96:104 */       String viewtimes = null;
/*  97:105 */       String ticketid = null;
/*  98:106 */       Map<String, Object> viewtimesMap = new HashMap();
/*  99:107 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
/* 100:108 */       Date date = null;
/* 101:109 */       for (int i = 0; i < list.size(); i++)
/* 102:    */       {
/* 103:110 */         String str = ((Map)list.get(i)).get("juli").toString();
/* 104:111 */         String distance = DistanceUtil.convertDistance(str);
/* 105:112 */         String issuetime = ((Map)list.get(i)).get("issuetime").toString();
/* 106:    */         try
/* 107:    */         {
/* 108:114 */           date = df.parse(issuetime);
/* 109:115 */           issuetime = df.format(date);
/* 110:    */         }
/* 111:    */         catch (ParseException e)
/* 112:    */         {
/* 113:117 */           e.printStackTrace();
/* 114:    */         }
/* 115:119 */         ((Map)list.get(i)).put("issuetime", issuetime);
/* 116:120 */         viewtimes = Integer.parseInt(((Map)list.get(i)).get("viewtimes").toString()) + 1 + "";
/* 117:121 */         ticketid = ((Map)list.get(i)).get("ticketid").toString();
/* 118:122 */         viewtimesMap.put("Viewtimes", viewtimes);
/* 119:123 */         viewtimesMap.put("Ticketid", ticketid);
/* 120:124 */         this.thisticketService.updateThisticketViewtimes(viewtimesMap);
/* 121:125 */         if (((Map)list.get(i)).get("username").toString().equals(username)) {
/* 122:126 */           distance = "0.0m";
/* 123:    */         }
/* 124:128 */         ((Map)list.get(i)).put("juli", distance);
/* 125:    */       }
/* 126:131 */       map.put("data", list);
/* 127:132 */       return map;
/* 128:    */     }
/* 129:    */     catch (Exception ex)
/* 130:    */     {
/* 131:135 */       ex.printStackTrace();
/* 132:136 */       map.put("error", ex.getMessage());
/* 133:    */     }
/* 134:137 */     return map;
/* 135:    */   }
/* 136:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.thisticket.Select_thisticket

 * JD-Core Version:    0.7.0.1

 */