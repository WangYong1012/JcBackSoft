/*  1:   */ package com.brave.feature.controller.huanxin;
/*  2:   */ 
/*  3:   */ import com.fasterxml.jackson.databind.node.ObjectNode;
/*  4:   */ import com.brave.feature.util.EasemobMessages;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import java.util.Map;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import javax.servlet.http.HttpServletResponse;
/*  9:   */ import net.sf.json.JSONObject;
/* 10:   */ import org.slf4j.Logger;
/* 11:   */ import org.slf4j.LoggerFactory;
/* 12:   */ import org.springframework.context.annotation.Scope;
/* 13:   */ import org.springframework.stereotype.Controller;
/* 14:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 15:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ @Scope("prototype")
/* 19:   */ public class Check_login
/* 20:   */ {
/* 21:35 */   public static final Logger LOGGER = LoggerFactory.getLogger(Check_login.class);
/* 22:   */   
/* 23:   */   @ResponseBody
/* 24:   */   @RequestMapping(value={"/Check_login_state"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 25:   */   public Map<String, Object> check_login(HttpServletRequest req, HttpServletResponse resp)
/* 26:   */   {
/* 27:41 */     Map<String, Object> map = new HashMap();
/* 28:   */     try
/* 29:   */     {
/* 30:44 */       req.setCharacterEncoding("utf-8");
/* 31:45 */       resp.setCharacterEncoding("utf-8");
/* 32:46 */       String username = req.getParameter("username");
/* 33:47 */       ObjectNode usernode = EasemobMessages.getUserStatus(username);
/* 34:48 */       if (null != usernode)
/* 35:   */       {
/* 36:49 */         LOGGER.info("检测用户是否在线: " + usernode.toString());
/* 37:50 */         String result = usernode.toString();
/* 38:51 */         JSONObject json = JSONObject.fromObject(result);
/* 39:   */         
/* 40:53 */         String dataString = json.getString("data");
/* 41:54 */         JSONObject Status_json = JSONObject.fromObject(dataString);
/* 42:55 */         String status = Status_json.getString(username + "");
/* 43:56 */         if (status.equals("online")) {
/* 44:57 */           map.put("data", "1");
/* 45:   */         } else {
/* 46:60 */           map.put("data", "2");
/* 47:   */         }
/* 48:   */       }
/* 49:   */       else
/* 50:   */       {
/* 51:63 */         map.put("data", "0");
/* 52:   */       }
/* 53:65 */       return map;
/* 54:   */     }
/* 55:   */     catch (Exception ex)
/* 56:   */     {
/* 57:68 */       ex.printStackTrace();
/* 58:69 */       map.put("error", ex.getMessage());
/* 59:   */     }
/* 60:70 */     return map;
/* 61:   */   }
/* 62:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.huanxin.Check_login

 * JD-Core Version:    0.7.0.1

 */