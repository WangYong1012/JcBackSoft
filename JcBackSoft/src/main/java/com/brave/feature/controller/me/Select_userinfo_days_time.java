/*   1:    */ package com.brave.feature.controller.me;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.UserService;
/*   4:    */ import java.io.PrintStream;
/*   5:    */ import java.text.SimpleDateFormat;
/*   6:    */ import java.util.Date;
/*   7:    */ import java.util.HashMap;
/*   8:    */ import java.util.List;
/*   9:    */ import java.util.Map;
/*  10:    */ import javax.servlet.http.HttpServletRequest;
/*  11:    */ import javax.servlet.http.HttpServletResponse;
/*  12:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  13:    */ import org.springframework.context.annotation.Scope;
/*  14:    */ import org.springframework.stereotype.Controller;
/*  15:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  16:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  17:    */ 
/*  18:    */ @Controller
/*  19:    */ @Scope("prototype")
/*  20:    */ public class Select_userinfo_days_time
/*  21:    */ {
/*  22:    */   @Autowired
/*  23:    */   private UserService userService;
/*  24:    */   
/*  25:    */   @ResponseBody
/*  26:    */   @RequestMapping(value={"/Select_userinfo_days_time"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  27:    */   public Map<String, Object> select_userinfo_days_time(HttpServletRequest req, HttpServletResponse resp)
/*  28:    */   {
/*  29: 40 */     Map<String, Object> map = new HashMap();
/*  30:    */     try
/*  31:    */     {
/*  32: 43 */       req.setCharacterEncoding("utf-8");
/*  33: 44 */       resp.setCharacterEncoding("utf-8");
/*  34: 45 */       String username = req.getParameter("username");
/*  35: 46 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*  36: 47 */       String qiandaotime = df.format(new Date());
/*  37: 48 */       Map<String, Object> usermap = new HashMap();
/*  38: 49 */       usermap.put("Qiandaotime", qiandaotime);
/*  39: 50 */       usermap.put("Username", username);
/*  40:    */       
/*  41:    */ 
/*  42:    */ 
/*  43: 54 */       List<Map<String, Object>> currentDateList = this.userService.selectCurrentDateList(usermap);
/*  44:    */       
/*  45:    */ 
/*  46: 57 */       List<Map<String, Object>> totalDateList = this.userService.selectUserScoreOrDayByName(usermap);
/*  47: 58 */       List<Map<String, Object>> signTimeLiST = this.userService.selectUserQiandaotimeByName(usermap);
/*  48: 59 */       Object signTime = ((Map)signTimeLiST.get(0)).get("qiandaotime");
/*  49: 60 */       int days = 0;
/*  50: 61 */       if ((signTime != null) && (!signTime.toString().equals("")))
/*  51:    */       {
/*  52: 63 */         List<Map<String, Object>> SignLiST = this.userService.decideContinuous(usermap);
/*  53: 64 */         days = Integer.parseInt(((Map)SignLiST.get(0)).get("num").toString());
/*  54:    */       }
/*  55: 67 */       if ((days > 1) || (signTime == null) || (signTime.equals("")))
/*  56:    */       {
/*  57: 68 */         days = 0;
/*  58: 69 */         Map<String, Object> dayMap = new HashMap();
/*  59: 70 */         dayMap.put("Days", days + "");
/*  60: 71 */         dayMap.put("Username", username);
/*  61: 72 */         int i = this.userService.updateUserinfoDays(dayMap);
/*  62:    */       }
/*  63:    */       else
/*  64:    */       {
/*  65: 74 */         int sumdays = Integer.parseInt(((Map)totalDateList.get(0)).get("days")
/*  66: 75 */           .toString());
/*  67: 76 */         if ((sumdays % 7 == 0) && (sumdays != 0)) {
/*  68: 77 */           days = 7;
/*  69:    */         } else {
/*  70: 79 */           days = sumdays % 7;
/*  71:    */         }
/*  72:    */       }
/*  73: 82 */       if ((null != currentDateList) && (0 < currentDateList.size()))
/*  74:    */       {
/*  75: 83 */         map.put("data", "1");
/*  76: 84 */         map.put("days", days + "");
/*  77: 85 */         map.put("score", ((Map)currentDateList.get(0)).get("score").toString());
/*  78:    */       }
/*  79: 88 */       else if ((null != totalDateList) && (0 < totalDateList.size()))
/*  80:    */       {
/*  81: 89 */         map.put("data", "0");
/*  82: 90 */         map.put("days", days + "");
/*  83: 91 */         map.put("score", ((Map)totalDateList.get(0)).get("score").toString());
/*  84:    */       }
/*  85: 94 */       return map;
/*  86:    */     }
/*  87:    */     catch (Exception ex)
/*  88:    */     {
/*  89: 97 */       ex.printStackTrace();
/*  90: 98 */       map.put("error", ex.getMessage());
/*  91:    */     }
/*  92: 99 */     return map;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public static void main(String[] args)
/*  96:    */   {
/*  97:104 */     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*  98:105 */     String qiandaotime = df.format(new Date());
/*  99:106 */     System.out.println(qiandaotime);
/* 100:    */   }
/* 101:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.me.Select_userinfo_days_time

 * JD-Core Version:    0.7.0.1

 */