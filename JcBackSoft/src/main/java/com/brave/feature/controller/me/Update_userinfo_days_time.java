/*  1:   */ package com.brave.feature.controller.me;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.UserService;
/*  4:   */ import java.text.SimpleDateFormat;
/*  5:   */ import java.util.Date;
/*  6:   */ import java.util.HashMap;
/*  7:   */ import java.util.List;
/*  8:   */ import java.util.Map;
/*  9:   */ import javax.servlet.http.HttpServletRequest;
/* 10:   */ import javax.servlet.http.HttpServletResponse;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.context.annotation.Scope;
/* 13:   */ import org.springframework.stereotype.Controller;
/* 14:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 15:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ @Scope("prototype")
/* 19:   */ public class Update_userinfo_days_time
/* 20:   */ {
/* 21:   */   @Autowired
/* 22:   */   private UserService userService;
/* 23:   */   
/* 24:   */   @ResponseBody
/* 25:   */   @RequestMapping(value={"/Update_userinfo_days_time"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 26:   */   public Map<String, Object> update_userinfo_days_time(HttpServletRequest req, HttpServletResponse resp)
/* 27:   */   {
/* 28:40 */     Map<String, Object> map = new HashMap();
/* 29:   */     try
/* 30:   */     {
/* 31:43 */       req.setCharacterEncoding("utf-8");
/* 32:44 */       resp.setCharacterEncoding("utf-8");
/* 33:45 */       String username = req.getParameter("username");
/* 34:46 */       int i = 0;
/* 35:47 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 36:48 */       String qiandaotime = df.format(new Date());
/* 37:   */       
/* 38:50 */       List<Map<String, Object>> list = this.userService.selectUserTimeScoreOrDayByName(username);
/* 39:51 */       int days = Integer.parseInt(((Map)list.get(0)).get("days").toString());
/* 40:52 */       int score = Integer.parseInt(((Map)list.get(0)).get("score").toString());
/* 41:   */       
/* 42:54 */       int sumdays = Integer.parseInt(((Map)list.get(0)).get("sumdays").toString());
/* 43:55 */       sumdays++;
/* 44:56 */       Object signTime = ((Map)list.get(0)).get("qiandaotime").toString();
/* 45:57 */       int num = 0;
/* 46:58 */       if ((signTime != null) && (!signTime.toString().equals("")))
/* 47:   */       {
/* 48:60 */         List<Map<String, Object>> list_rtn = this.userService.decideContinueSign(username);
/* 49:61 */         num = Integer.parseInt(((Map)list_rtn.get(0)).get("num").toString());
/* 50:62 */         if (num != 0) {
/* 51:63 */           if (num == 1)
/* 52:   */           {
/* 53:64 */             days++;
/* 54:65 */             if ((days % 7 == 0) && (days != 0))
/* 55:   */             {
/* 56:66 */               score += 13;
/* 57:67 */               days = 7;
/* 58:   */             }
/* 59:   */             else
/* 60:   */             {
/* 61:69 */               score += 3;
/* 62:70 */               days %= 7;
/* 63:   */             }
/* 64:   */           }
/* 65:   */           else
/* 66:   */           {
/* 67:73 */             score += 3;
/* 68:74 */             days = 1;
/* 69:   */           }
/* 70:   */         }
/* 71:   */       }
/* 72:   */       else
/* 73:   */       {
/* 74:78 */         score += 3;
/* 75:79 */         days = 1;
/* 76:   */       }
/* 77:82 */       Map<String, Object> userMap = new HashMap();
/* 78:83 */       userMap.put("Username", username);
/* 79:84 */       userMap.put("Days", Integer.valueOf(days));
/* 80:85 */       userMap.put("Score", Integer.valueOf(score));
/* 81:86 */       userMap.put("Sumdays", Integer.valueOf(sumdays));
/* 82:87 */       userMap.put("Qiandaotime", qiandaotime);
/* 83:88 */       i = this.userService.updateUserinfoDaysByusername(userMap);
/* 84:89 */       map.put("data", i + "");
/* 85:90 */       map.put("days", Integer.valueOf(days));
/* 86:91 */       map.put("score", Integer.valueOf(score));
/* 87:92 */       return map;
/* 88:   */     }
/* 89:   */     catch (Exception ex)
/* 90:   */     {
/* 91:95 */       ex.printStackTrace();
/* 92:96 */       map.put("error", ex.getMessage());
/* 93:   */     }
/* 94:97 */     return map;
/* 95:   */   }
/* 96:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.me.Update_userinfo_days_time

 * JD-Core Version:    0.7.0.1

 */