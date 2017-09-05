/*   1:    */ package com.brave.feature.controller.huanxin;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.SendNoteServce;
/*   4:    */ import com.brave.feature.service.UserService;
/*   5:    */ import java.text.SimpleDateFormat;
/*   6:    */ import java.util.ArrayList;
/*   7:    */ import java.util.Date;
/*   8:    */ import java.util.HashMap;
/*   9:    */ import java.util.LinkedList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.Map;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  15:    */ import org.springframework.context.annotation.Scope;
/*  16:    */ import org.springframework.stereotype.Controller;
/*  17:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  18:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  19:    */ import org.springframework.web.servlet.ModelAndView;
/*  20:    */ 
/*  21:    */ @Controller
/*  22:    */ @Scope("prototype")
/*  23:    */ public class SendGroupNote
/*  24:    */ {
/*  25:    */   @Autowired
/*  26:    */   private UserService userService;
/*  27:    */   @Autowired
/*  28:    */   private SendNoteServce sendNoteServce;
/*  29:    */   
/*  30:    */   @ResponseBody
/*  31:    */   @RequestMapping(value={"/sendmessage_group_note"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  32:    */   public ModelAndView sendmessage(HttpServletRequest req, HttpServletResponse resp)
/*  33:    */   {
/*  34: 38 */     ModelAndView model = new ModelAndView();
/*  35: 39 */     Map<String, Object> map = new HashMap();
/*  36:    */     try
/*  37:    */     {
/*  38: 42 */       req.setCharacterEncoding("utf-8");
/*  39: 43 */       resp.setCharacterEncoding("utf-8");
/*  40: 44 */       String phone = req.getParameter("phone");
/*  41: 45 */       String name = req.getParameter("name");
/*  42:    */       
/*  43: 47 */       phone = phone.replace("[", "").replace("]", "").replace("{", "").replace("}", "");
/*  44: 48 */       String message = "您的朋友" + name + "邀请您使用《金池金融汇》手机汇票软件。下载请点http://t.cn/RGBmvcd 回复TD退订";
/*  45:    */       
/*  46: 50 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  47: 51 */       String sendtime = df.format(new Date());
/*  48: 52 */       Map<String, Object> noteMap = new HashMap();
/*  49: 53 */       noteMap.put("Username", name);
/*  50: 54 */       noteMap.put("Sendtime", sendtime);
/*  51: 55 */       int i = 0;
/*  52: 56 */       int k = 0;
/*  53: 57 */       int m = 0;
/*  54: 58 */       int sum = 0;
/*  55: 59 */       String[] phones = null;
/*  56:    */       
/*  57: 61 */       List<String> list_arr = new LinkedList();
/*  58: 62 */       List list_str = new ArrayList();
/*  59: 65 */       if ((phone != null) && (!"".equals(phone)))
/*  60:    */       {
/*  61: 67 */         phones = phone.split(",");
/*  62: 68 */         for (int j = 0; j < phones.length; j++)
/*  63:    */         {
/*  64: 70 */           Map<String, Object> param = new HashMap();
/*  65: 71 */           param.put("Username", phones[j]);
/*  66: 72 */           List list_user = this.userService.selectMydata(param);
/*  67: 73 */           if ((null != list_user) && (0 < list_user.size())) {
/*  68: 75 */             list_str.add(phones[j]);
/*  69:    */           }
/*  70:    */         }
/*  71: 78 */         for (int n = 0; n < list_str.size(); n++)
/*  72:    */         {
/*  73: 80 */           noteMap.put("Phone", list_str.get(n));
/*  74: 81 */           List list = this.sendNoteServce.selectSendNote(noteMap);
/*  75: 82 */           if (list.size() < 1)
/*  76:    */           {
/*  77: 83 */             i = this.sendNoteServce.insertSendnote(noteMap);
/*  78: 84 */             if (i > 0)
/*  79:    */             {
/*  80: 85 */               m++;
/*  81: 86 */               list_arr.add((String)list_str.get(n));
/*  82:    */             }
/*  83:    */           }
/*  84:    */         }
/*  85:    */       }
/*  86: 92 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*  87: 93 */       String testtime = sdf.format(new Date());
/*  88:    */       
/*  89: 95 */       List list_true = this.userService.selectUserinfoGrouptimeByName(name);
/*  90: 96 */       if ((null != list_true) && (0 < list_true.size()))
/*  91:    */       {
/*  92: 98 */         String grouptime = ((Map)list_true.get(0)).get("grouptime").toString();
/*  93: 99 */         if (("".equals(grouptime)) || (!grouptime.contains(testtime)))
/*  94:    */         {
/*  95:100 */           phone = list_arr.toString().replace("[", "").replace("]", "");
/*  96:101 */           String result = HttpSender.batchSend(phone, message);
/*  97:102 */           String[] arr = result.split(",");
/*  98:103 */           map.put("note", "1");
/*  99:104 */           if (arr[1].startsWith("0"))
/* 100:    */           {
/* 101:105 */             map.put("data", "1");
/* 102:106 */             List list_rtn = this.userService.selectUserScoreByTrueName(name);
/* 103:107 */             int score = Integer.parseInt(((Map)list_rtn.get(0)).get("score")
/* 104:108 */               .toString());
/* 105:109 */             sum = 3 * m;
/* 106:110 */             score += sum;
/* 107:111 */             Map<String, Object> userMap = new HashMap();
/* 108:112 */             userMap.put("Trueusername", name);
/* 109:113 */             userMap.put("Score", Integer.valueOf(score));
/* 110:114 */             userMap.put("Grouptime", sendtime);
/* 111:115 */             k = this.userService.updateUserinfoScoreByGroupTrueusername(userMap);
/* 112:    */           }
/* 113:    */           else
/* 114:    */           {
/* 115:117 */             map.put("data", "0");
/* 116:    */           }
/* 117:    */         }
/* 118:    */         else
/* 119:    */         {
/* 120:120 */           map.put("note", "0");
/* 121:121 */           map.put("data", "0");
/* 122:    */         }
/* 123:    */       }
/* 124:    */       else
/* 125:    */       {
/* 126:125 */         map.put("note", "0");
/* 127:126 */         map.put("data", "0");
/* 128:    */       }
/* 129:128 */       map.put("sumscore", Integer.valueOf(sum));
/* 130:129 */       model.addAllObjects(map);
/* 131:130 */       return model;
/* 132:    */     }
/* 133:    */     catch (Exception ex)
/* 134:    */     {
/* 135:133 */       ex.printStackTrace();
/* 136:134 */       map.put("error", ex.getMessage());
/* 137:135 */       model.addAllObjects(map);
/* 138:    */     }
/* 139:136 */     return model;
/* 140:    */   }
/* 141:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.huanxin.SendGroupNote

 * JD-Core Version:    0.7.0.1

 */