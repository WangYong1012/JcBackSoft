/*   1:    */ package com.brave.feature.controller.userinfo;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.UserService;
/*   4:    */ import com.brave.feature.util.Pushall_ser;
/*   5:    */ import com.brave.feature.util.Pushall_ser_ios;
/*   6:    */ import java.util.ArrayList;
/*   7:    */ import java.util.HashMap;
/*   8:    */ import java.util.List;
/*   9:    */ import java.util.Map;
/*  10:    */ import java.util.regex.Matcher;
/*  11:    */ import java.util.regex.Pattern;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  15:    */ import org.springframework.context.annotation.Scope;
/*  16:    */ import org.springframework.stereotype.Controller;
/*  17:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  18:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  19:    */ 
/*  20:    */ @Controller
/*  21:    */ @Scope("prototype")
/*  22:    */ public class Registeruser_push
/*  23:    */ {
/*  24:    */   @Autowired
/*  25:    */   public UserService userService;
/*  26:    */   
/*  27:    */   @ResponseBody
/*  28:    */   @RequestMapping(value={"/registeruser_push"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  29:    */   public Map<String, Object> registeruser_push(HttpServletRequest req, HttpServletResponse resp)
/*  30:    */   {
/*  31: 41 */     Map<String, Object> map = new HashMap();
/*  32:    */     try
/*  33:    */     {
/*  34: 44 */       List<Map<String, Object>> channelid = this.userService.selectUserChannelidByAd();
/*  35: 45 */       List<Map<String, Object>> Ioschannel = this.userService.selectUserChannelidByIos();
/*  36:    */       
/*  37: 47 */       List<String> listchannelandroid = new ArrayList();
/*  38: 48 */       List<String> ios_channel = new ArrayList();
/*  39: 51 */       for (int x = 0; x < Ioschannel.size(); x++) {
/*  40: 52 */         ios_channel.add(((Map)Ioschannel.get(x)).get("channelid").toString());
/*  41:    */       }
/*  42: 55 */       for (int g = 0; g < ios_channel.size() - 1; g++) {
/*  43: 56 */         for (int j = ios_channel.size() - 1; j > g; j--) {
/*  44: 57 */           if (((String)ios_channel.get(j)).equals(ios_channel.get(g))) {
/*  45: 58 */             ios_channel.remove(j);
/*  46:    */           }
/*  47:    */         }
/*  48:    */       }
/*  49: 63 */       Pushall_ser_ios pios = new Pushall_ser_ios();
/*  50: 64 */       String s = "";
/*  51: 65 */       for (int m = 0; m < ios_channel.size(); m++)
/*  52:    */       {
/*  53: 66 */         s = "sound.caf";
/*  54: 67 */         pios.pushall_ser_ios((String)ios_channel.get(m), "有新的用户注册", s);
/*  55:    */       }
/*  56: 71 */       for (int x = 0; x < channelid.size(); x++) {
/*  57: 73 */         listchannelandroid.add(((Map)channelid.get(x)).get("channelid").toString());
/*  58:    */       }
/*  59: 76 */       for (int g = 0; g < listchannelandroid.size() - 1; g++) {
/*  60: 77 */         for (int j = listchannelandroid.size() - 1; j > g; j--) {
/*  61: 78 */           if (((String)listchannelandroid.get(j)).equals(listchannelandroid.get(g))) {
/*  62: 79 */             listchannelandroid.remove(j);
/*  63:    */           }
/*  64:    */         }
/*  65:    */       }
/*  66: 84 */       Pushall_ser ph = new Pushall_ser();
/*  67: 85 */       ph.push_ser(listchannelandroid, "新用户注册提示", "新的用户注册，请进行审核");
/*  68:    */       
/*  69: 87 */       map.put("data", "1");
/*  70: 88 */       return map;
/*  71:    */     }
/*  72:    */     catch (Exception ex)
/*  73:    */     {
/*  74: 91 */       ex.printStackTrace();
/*  75: 92 */       map.put("error", ex.getMessage());
/*  76:    */     }
/*  77: 93 */     return map;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public static boolean isNumeric(String str)
/*  81:    */   {
/*  82: 98 */     Pattern pattern = Pattern.compile("[0-9]*");
/*  83: 99 */     Matcher isNum = pattern.matcher(str);
/*  84:100 */     if (!isNum.matches()) {
/*  85:101 */       return false;
/*  86:    */     }
/*  87:103 */     return true;
/*  88:    */   }
/*  89:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Registeruser_push

 * JD-Core Version:    0.7.0.1

 */