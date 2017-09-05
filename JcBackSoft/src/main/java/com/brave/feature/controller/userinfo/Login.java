/*   1:    */ package com.brave.feature.controller.userinfo;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.UserService;
/*   4:    */ import com.brave.feature.util.Push_ser;
/*   5:    */ import com.brave.feature.util.Pushall_ser_ios;
/*   6:    */ import java.text.SimpleDateFormat;
/*   7:    */ import java.util.ArrayList;
/*   8:    */ import java.util.Date;
/*   9:    */ import java.util.HashMap;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.Map;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import org.slf4j.Logger;
/*  15:    */ import org.slf4j.LoggerFactory;
/*  16:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  17:    */ import org.springframework.context.annotation.Scope;
/*  18:    */ import org.springframework.stereotype.Controller;
/*  19:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  20:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  21:    */ 
/*  22:    */ @Controller
/*  23:    */ @Scope("prototype")
/*  24:    */ public class Login
/*  25:    */ {
/*  26:    */   @Autowired
/*  27:    */   public UserService userService;
/*  28: 40 */   private static final Logger log = LoggerFactory.getLogger(Login.class);
/*  29:    */   
/*  30:    */   @ResponseBody
/*  31:    */   @RequestMapping(value={"/login_in"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  32:    */   public Map<String, Object> doLogin(HttpServletRequest req, HttpServletResponse resp)
/*  33:    */   {
/*  34: 46 */     Map<String, Object> map = new HashMap();
/*  35:    */     try
/*  36:    */     {
/*  37: 49 */       req.setCharacterEncoding("utf-8");
/*  38: 50 */       resp.setCharacterEncoding("utf-8");
/*  39:    */       
/*  40: 52 */       List<Map<String, Object>> list = new ArrayList();
/*  41:    */       
/*  42:    */ 
/*  43:    */ 
/*  44: 56 */       String user = req.getParameter("name");
/*  45: 57 */       String pwd = req.getParameter("pwd");
/*  46: 58 */       String channelId = req.getParameter("channelId");
/*  47: 59 */       String zhuangtai = req.getParameter("zhuangtai");
/*  48: 60 */       String version = req.getParameter("version");
/*  49: 61 */       String platform = req.getParameter("plat");
/*  50:    */       
/*  51: 63 */       Map<String, Object> queryUserMap = new HashMap();
/*  52: 64 */       queryUserMap.put("Username", user);
/*  53:    */       
/*  54: 66 */       List<Map<String, Object>> list_rtn = this.userService.selectMydata(queryUserMap);
/*  55:    */       
/*  56: 68 */       String fanhui = "";
/*  57: 69 */       int i = 0;
/*  58: 71 */       if ((version != null) && (!"".equals(version)))
/*  59:    */       {
/*  60: 72 */         Map<String, Object> updateUserInfoMap = new HashMap();
/*  61: 73 */         updateUserInfoMap.put("ADVER", version);
/*  62: 74 */         updateUserInfoMap.put("PLAT", platform);
/*  63: 75 */         updateUserInfoMap.put("USERNAME", user);
/*  64: 76 */         if (platform.equals("ad")) {
/*  65: 78 */           i = this.userService.updateUserByVersionAndPlatAndroid(updateUserInfoMap);
/*  66: 79 */         } else if (platform.equals("ios")) {
/*  67: 81 */           i = this.userService.updateUserByVersionAndPlatIOS(updateUserInfoMap);
/*  68:    */         }
/*  69:    */       }
/*  70: 86 */       if (list_rtn.size() > 0)
/*  71:    */       {
/*  72: 87 */         if (pwd.equals(((Map)list_rtn.get(0)).get("password")))
/*  73:    */         {
/*  74: 88 */           if (((Map)list_rtn.get(0)).get("channelid").toString().equals(channelId))
/*  75:    */           {
/*  76: 90 */             fanhui = "0";
/*  77:    */           }
/*  78: 91 */           else if (((Map)list_rtn.get(0)).get("channelid") != null)
/*  79:    */           {
/*  80: 93 */             if ("3".equals(((Map)list_rtn.get(0)).get("terminalstate")
/*  81: 94 */               .toString()))
/*  82:    */             {
/*  83: 95 */               Push_ser ph = new Push_ser();
/*  84: 96 */               ph.push_ser(((Map)list_rtn.get(0)).get("channelid")
/*  85: 97 */                 .toString(), "异地登陆提示", "您的账号在别处登录了");
/*  86:    */             }
/*  87: 99 */             if ("4".equals(((Map)list_rtn.get(0)).get("terminalstate")
/*  88:100 */               .toString()))
/*  89:    */             {
/*  90:102 */               Pushall_ser_ios ph = new Pushall_ser_ios();
/*  91:103 */               ph.pushall_ser_ios(((Map)list_rtn.get(0)).get("channelid")
/*  92:104 */                 .toString(), "异地登陆提示", "");
/*  93:    */             }
/*  94:107 */             fanhui = "2";
/*  95:    */           }
/*  96:110 */           if ((channelId != null) && (!"".equals(channelId)))
/*  97:    */           {
/*  98:111 */             Map<String, Object> updateUserInfoMap = new HashMap();
/*  99:112 */             updateUserInfoMap.put("CHANNELID", channelId);
/* 100:113 */             updateUserInfoMap.put("TERMINALSTATE", zhuangtai);
/* 101:114 */             updateUserInfoMap.put("USERNAME", user);
/* 102:115 */             this.userService
/* 103:116 */               .updateUserChannelIdByUserName(updateUserInfoMap);
/* 104:    */           }
/* 105:    */         }
/* 106:    */         else
/* 107:    */         {
/* 108:119 */           fanhui = "1";
/* 109:    */         }
/* 110:    */       }
/* 111:    */       else {
/* 112:123 */         fanhui = "-1";
/* 113:    */       }
/* 114:125 */       if ((fanhui.equals("2")) || (fanhui.equals("0")))
/* 115:    */       {
/* 116:126 */         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 117:    */         
/* 118:128 */         String loginleftdate = df.format(new Date());
/* 119:    */         
/* 120:130 */         Map<String, Object> userMap = new HashMap();
/* 121:131 */         userMap.put("Username", user);
/* 122:132 */         userMap.put("Loginleftdate", loginleftdate);
/* 123:133 */         list = this.userService.selectMydata(userMap);
/* 124:134 */         this.userService.UpdateUserLogindate(userMap);
/* 125:135 */         map.put("info", list);
/* 126:    */       }
/* 127:137 */       map.put("data", fanhui);
/* 128:138 */       map.put("num", i + "");
/* 129:139 */       return map;
/* 130:    */     }
/* 131:    */     catch (Exception ex)
/* 132:    */     {
/* 133:143 */       ex.printStackTrace();
/* 134:144 */       map.put("error", ex.getMessage());
/* 135:    */     }
/* 136:145 */     return map;
/* 137:    */   }
/* 138:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Login

 * JD-Core Version:    0.7.0.1

 */