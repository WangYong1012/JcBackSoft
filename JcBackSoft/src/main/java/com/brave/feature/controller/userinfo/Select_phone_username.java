/*   1:    */ package com.brave.feature.controller.userinfo;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.UserService;
/*   4:    */ import java.util.HashMap;
/*   5:    */ import java.util.LinkedList;
/*   6:    */ import java.util.List;
/*   7:    */ import java.util.Map;
/*   8:    */ import javax.servlet.http.HttpServletRequest;
/*   9:    */ import javax.servlet.http.HttpServletResponse;
/*  10:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  11:    */ import org.springframework.context.annotation.Scope;
/*  12:    */ import org.springframework.stereotype.Controller;
/*  13:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  14:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  15:    */ import org.springframework.web.servlet.ModelAndView;
/*  16:    */ 
/*  17:    */ @Controller
/*  18:    */ @Scope("prototype")
/*  19:    */ public class Select_phone_username
/*  20:    */ {
/*  21:    */   @Autowired
/*  22:    */   public UserService userService;
/*  23:    */   
/*  24:    */   @ResponseBody
/*  25:    */   @RequestMapping(value={"/Select_phone_username"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  26:    */   public ModelAndView select_phone_username(HttpServletRequest req, HttpServletResponse resp)
/*  27:    */   {
/*  28: 39 */     ModelAndView modelView = new ModelAndView();
/*  29: 40 */     Map<String, Object> map = new HashMap();
/*  30:    */     try
/*  31:    */     {
/*  32: 44 */       req.setCharacterEncoding("utf-8");
/*  33: 45 */       resp.setCharacterEncoding("utf-8");
/*  34:    */       
/*  35: 47 */       Map<String, Object> usermap = new HashMap();
/*  36:    */       
/*  37: 49 */       String phone = req.getParameter("phone");
/*  38: 50 */       String username = req.getParameter("username");
/*  39: 51 */       List<String> list_p = new LinkedList();
/*  40:    */       
/*  41: 53 */       String[] phones = null;
/*  42: 54 */       if ((phone != null) && (!"".equals(phone)))
/*  43:    */       {
/*  44: 55 */         if (phone.indexOf(",") != -1)
/*  45:    */         {
/*  46: 56 */           phones = phone.split(",");
/*  47:    */         }
/*  48: 58 */         else if (phone.indexOf(",") == -1)
/*  49:    */         {
/*  50: 59 */           phones = new String[1];
/*  51: 60 */           phones[0] = phone;
/*  52:    */         }
/*  53: 62 */         for (String str : phones) {
/*  54: 63 */           if (!list_p.contains(str)) {
/*  55: 64 */             list_p.add(str);
/*  56:    */           }
/*  57:    */         }
/*  58:    */       }
/*  59: 68 */       Object list_rtn = null;
/*  60: 69 */       Object jieguoji = new HashMap();
/*  61: 70 */       if (phones.length > 0)
/*  62:    */       {
/*  63: 71 */         String phnum = "'" + phones[0] + "'";
/*  64: 72 */         for (int i = 1; i < phones.length; i++) {
/*  65: 73 */           phnum = phnum + ",'" + phones[i] + "'";
/*  66:    */         }
/*  67: 75 */         list_rtn = this.userService.SelectPhoneUsername(phnum);
/*  68: 76 */         if (((List)list_rtn).size() > 0)
/*  69:    */         {
/*  70: 77 */           for (int j = 0; j < ((List)list_rtn).size(); j++)
/*  71:    */           {
/*  72: 78 */             String str = ((Map)((List)list_rtn).get(j)).get("phone").toString();
/*  73: 79 */             ((Map)jieguoji).put(str, "1");
/*  74: 80 */             list_p.remove(str);
/*  75:    */           }
/*  76: 82 */           for (int k = 0; k < list_p.size(); k++) {
/*  77: 83 */             ((Map)jieguoji).put(list_p.get(k), "0");
/*  78:    */           }
/*  79:    */         }
/*  80:    */       }
/*  81: 87 */       usermap.put("Username", username);
/*  82: 88 */       Object list = this.userService.selectPhoneStateByUsername(usermap);
/*  83: 94 */       for (int i = 0; i < ((List)list).size(); i++)
/*  84:    */       {
/*  85: 95 */         String friendphone = ((Map)((List)list).get(i)).get("friendphone").toString();
/*  86: 96 */         String statr = ((Map)((List)list).get(i)).get("friendstatr").toString();
/*  87: 97 */         if ("1".equals(statr)) {
/*  88: 98 */           statr = "2";
/*  89: 99 */         } else if ("0".equals(statr)) {
/*  90:100 */           statr = "4";
/*  91:    */         }
/*  92:102 */         if (((Map)jieguoji).get(friendphone) != null)
/*  93:    */         {
/*  94:103 */           ((Map)jieguoji).remove(friendphone);
/*  95:104 */           ((Map)jieguoji).put(friendphone, statr);
/*  96:    */         }
/*  97:    */       }
/*  98:107 */       map.put("data", jieguoji);
/*  99:108 */       modelView.addAllObjects(map);
/* 100:109 */       return modelView;
/* 101:    */     }
/* 102:    */     catch (Exception ex)
/* 103:    */     {
/* 104:112 */       ex.printStackTrace();
/* 105:113 */       map.put("error", ex.getMessage());
/* 106:114 */       modelView.addAllObjects(map);
/* 107:    */     }
/* 108:115 */     return modelView;
/* 109:    */   }
/* 110:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Select_phone_username

 * JD-Core Version:    0.7.0.1

 */