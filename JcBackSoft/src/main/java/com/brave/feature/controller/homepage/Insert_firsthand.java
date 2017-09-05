/*   1:    */ package com.brave.feature.controller.homepage;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.FirsthandResourcesService;
/*   4:    */ import com.brave.feature.service.UserService;
/*   5:    */ import java.io.PrintStream;
/*   6:    */ import java.text.ParseException;
/*   7:    */ import java.text.SimpleDateFormat;
/*   8:    */ import java.util.Calendar;
/*   9:    */ import java.util.Date;
/*  10:    */ import java.util.HashMap;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.Map;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import org.slf4j.Logger;
/*  16:    */ import org.slf4j.LoggerFactory;
/*  17:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  18:    */ import org.springframework.context.annotation.Scope;
/*  19:    */ import org.springframework.stereotype.Controller;
/*  20:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  21:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  22:    */ 
/*  23:    */ @Controller
/*  24:    */ @Scope("prototype")
/*  25:    */ public class Insert_firsthand
/*  26:    */ {
/*  27:    */   @Autowired
/*  28:    */   private FirsthandResourcesService service;
/*  29:    */   @Autowired
/*  30:    */   private UserService userService;
/*  31: 45 */   private static final Logger log = LoggerFactory.getLogger(Insert_firsthand.class);
/*  32:    */   
/*  33:    */   @ResponseBody
/*  34:    */   @RequestMapping(value={"/insert_firsthand"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  35:    */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/*  36:    */   {
/*  37: 51 */     Map<String, Object> map = new HashMap();
/*  38:    */     try
/*  39:    */     {
/*  40: 54 */       req.setCharacterEncoding("utf-8");
/*  41: 55 */       resp.setCharacterEncoding("utf-8");
/*  42: 56 */       String region = req.getParameter("region");
/*  43: 57 */       String username = req.getParameter("username");
/*  44: 58 */       String type = req.getParameter("type");
/*  45: 59 */       String status = req.getParameter("status");
/*  46: 60 */       String payType = req.getParameter("payType");
/*  47:    */       
/*  48:    */ 
/*  49: 63 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  50: 64 */       SimpleDateFormat ds = new SimpleDateFormat("yyyy-MM-dd");
/*  51: 65 */       Date now = new Date();
/*  52: 66 */       String startDate = null;
/*  53:    */       
/*  54:    */ 
/*  55: 69 */       Calendar calendar = Calendar.getInstance();
/*  56: 70 */       String dueDate = null;
/*  57: 71 */       Map<String, Object> firsthandMap = new HashMap();
/*  58:    */       
/*  59: 73 */       int result = this.userService.updateUserAuthenticationStatusByUsername(username);
/*  60: 74 */       if (0 < result) {
/*  61: 76 */         log.debug("用户 [ " + username + " ] 通过认证.");
/*  62:    */       }
/*  63: 79 */       if (("0".equals(status)) || ("3".equals(status)))
/*  64:    */       {
/*  65: 81 */         startDate = df.format(now);
/*  66: 82 */         System.out.println("startDate:" + startDate);
/*  67: 83 */         calendar.setTime(now);
/*  68: 84 */         calendar.add(2, 1);
/*  69: 85 */         dueDate = df.format(calendar.getTime());
/*  70:    */       }
/*  71:    */       else
/*  72:    */       {
/*  73: 87 */         if (("1".equals(status)) || ("4".equals(status))) {
/*  74: 90 */           return null;
/*  75:    */         }
/*  76: 91 */         if ("2".equals(status))
/*  77:    */         {
/*  78: 94 */           List<Map<String, Object>> maps = this.service.selectAuthenticationInfo(username);
/*  79: 95 */           if (maps.size() == 0) {
/*  80: 96 */             return null;
/*  81:    */           }
/*  82: 98 */           startDate = ((Map)maps.get(0)).get("duedate").toString();
/*  83: 99 */           System.out.println("startDate:" + startDate);
/*  84:100 */           Date newDate = null;
/*  85:    */           try
/*  86:    */           {
/*  87:102 */             newDate = ds.parse(startDate);
/*  88:    */           }
/*  89:    */           catch (ParseException e)
/*  90:    */           {
/*  91:104 */             e.printStackTrace();
/*  92:    */           }
/*  93:106 */           calendar.setTime(newDate);
/*  94:107 */           calendar.add(2, 1);
/*  95:108 */           dueDate = df.format(calendar.getTime());
/*  96:    */         }
/*  97:    */       }
/*  98:110 */       firsthandMap.put("Type", type);
/*  99:111 */       firsthandMap.put("Username", username);
/* 100:112 */       firsthandMap.put("StartDate", startDate);
/* 101:113 */       firsthandMap.put("DueDate", dueDate);
/* 102:114 */       firsthandMap.put("Region", region);
/* 103:115 */       firsthandMap.put("PayType", payType);
/* 104:116 */       int i = this.service.insert_firsthand(firsthandMap);
/* 105:    */       
/* 106:    */ 
/* 107:    */ 
/* 108:    */ 
/* 109:    */ 
/* 110:    */ 
/* 111:    */ 
/* 112:    */ 
/* 113:    */ 
/* 114:    */ 
/* 115:    */ 
/* 116:    */ 
/* 117:    */ 
/* 118:    */ 
/* 119:    */ 
/* 120:    */ 
/* 121:    */ 
/* 122:    */ 
/* 123:    */ 
/* 124:    */ 
/* 125:    */ 
/* 126:    */ 
/* 127:    */ 
/* 128:    */ 
/* 129:    */ 
/* 130:142 */       map.put("status", "1");
/* 131:143 */       return map;
/* 132:    */     }
/* 133:    */     catch (Exception ex)
/* 134:    */     {
/* 135:146 */       ex.printStackTrace();
/* 136:147 */       map.put("error", ex.getMessage());
/* 137:    */     }
/* 138:148 */     return map;
/* 139:    */   }
/* 140:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Insert_firsthand

 * JD-Core Version:    0.7.0.1

 */