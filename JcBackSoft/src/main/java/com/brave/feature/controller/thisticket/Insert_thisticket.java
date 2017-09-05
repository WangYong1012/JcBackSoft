/*   1:    */ package com.brave.feature.controller.thisticket;
/*   2:    */ 
/*   3:    */ import com.brave.feature.entity.JcAuthentication;
/*   4:    */ import com.brave.feature.entity.JcAuthenticationExample;
/*   5:    */ import com.brave.feature.entity.JcAuthenticationExample.Criteria;
/*   6:    */ import com.brave.feature.service.AuthenticationService;
/*   7:    */ import com.brave.feature.service.ThisticketService;
/*   8:    */ import java.io.PrintStream;
/*   9:    */ import java.text.SimpleDateFormat;
/*  10:    */ import java.util.Date;
/*  11:    */ import java.util.HashMap;
/*  12:    */ import java.util.List;
/*  13:    */ import java.util.Map;
/*  14:    */ import javax.servlet.http.HttpServletRequest;
/*  15:    */ import javax.servlet.http.HttpServletResponse;
/*  16:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  17:    */ import org.springframework.stereotype.Controller;
/*  18:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  19:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  20:    */ 
/*  21:    */ @Controller
/*  22:    */ public class Insert_thisticket
/*  23:    */ {
/*  24:    */   @Autowired
/*  25:    */   private ThisticketService thisticketService;
/*  26:    */   @Autowired
/*  27:    */   private AuthenticationService authenticationService;
/*  28:    */   
/*  29:    */   @ResponseBody
/*  30:    */   @RequestMapping(value={"/insert_thisticket"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  31:    */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/*  32:    */   {
/*  33: 39 */     Map<String, Object> map = new HashMap();
/*  34:    */     try
/*  35:    */     {
/*  36: 42 */       req.setCharacterEncoding("utf-8");
/*  37: 43 */       resp.setCharacterEncoding("utf-8");
/*  38: 44 */       String longitude = req.getParameter("jingdu");
/*  39: 45 */       String latitude = req.getParameter("weidu");
/*  40: 46 */       String ticketid = req.getParameter("ticketid");
/*  41: 47 */       String username = req.getParameter("username");
/*  42: 48 */       String realname = req.getParameter("realname");
/*  43: 49 */       String imageAmount = req.getParameter("imageAmount");
/*  44: 50 */       String useridentity = req.getParameter("useridentity");
/*  45: 51 */       String content = req.getParameter("content");
/*  46: 52 */       System.out.println("content:" + content);
/*  47: 53 */       String viewtimes = "0";
/*  48: 54 */       String region = req.getParameter("region");
/*  49: 55 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  50: 56 */       String issuetime = df.format(new Date());
/*  51: 57 */       System.out.println(longitude);
/*  52: 58 */       System.out.println(latitude);
/*  53: 59 */       System.out.println("content:" + content);
/*  54:    */       
/*  55:    */ 
/*  56: 62 */       JcAuthenticationExample example = new JcAuthenticationExample();
/*  57: 63 */       JcAuthenticationExample.Criteria criteria = example.createCriteria();
/*  58: 64 */       criteria.andUsernameEqualTo(username);
/*  59: 65 */       List<JcAuthentication> authenticationList = this.authenticationService.selectByExample(example);
/*  60:    */       
/*  61: 67 */       JcAuthentication jcAuthentication = (JcAuthentication)authenticationList.get(0);
/*  62:    */       
/*  63: 69 */       Map<String, Object> thisticketmap = new HashMap();
/*  64: 70 */       thisticketmap.put("Latitude", latitude);
/*  65: 71 */       thisticketmap.put("Longitude", longitude);
/*  66: 72 */       thisticketmap.put("Ticketid", ticketid);
/*  67: 73 */       thisticketmap.put("Username", username);
/*  68: 74 */       thisticketmap.put("Useridentity", jcAuthentication.getType());
/*  69: 75 */       thisticketmap.put("Content", content);
/*  70: 76 */       thisticketmap.put("Viewtimes", viewtimes);
/*  71: 78 */       if (region == null) {
/*  72: 79 */         thisticketmap.put("Region", "未定位");
/*  73:    */       } else {
/*  74: 81 */         thisticketmap.put("Region", region);
/*  75:    */       }
/*  76: 83 */       thisticketmap.put("Realname", realname);
/*  77: 84 */       if (imageAmount == null) {
/*  78: 85 */         thisticketmap.put("ImageAmount", "");
/*  79:    */       } else {
/*  80: 87 */         thisticketmap.put("ImageAmount", imageAmount);
/*  81:    */       }
/*  82: 90 */       thisticketmap.put("Issuetime", issuetime);
/*  83: 91 */       int i = 0;
/*  84:    */       try
/*  85:    */       {
/*  86: 93 */         i = this.thisticketService.insertThisticket(thisticketmap);
/*  87:    */       }
/*  88:    */       catch (Exception e)
/*  89:    */       {
/*  90: 95 */         e.printStackTrace();
/*  91:    */       }
/*  92: 98 */       map.put("data", i + "");
/*  93: 99 */       return map;
/*  94:    */     }
/*  95:    */     catch (Exception ex)
/*  96:    */     {
/*  97:102 */       ex.printStackTrace();
/*  98:103 */       map.put("error", ex.getMessage());
/*  99:    */     }
/* 100:104 */     return map;
/* 101:    */   }
/* 102:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.thisticket.Insert_thisticket

 * JD-Core Version:    0.7.0.1

 */