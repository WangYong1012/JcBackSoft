/*  1:   */ package com.brave.feature.controller.userinfo;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.UserService;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import java.util.Map;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import javax.servlet.http.HttpServletResponse;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.context.annotation.Scope;
/* 11:   */ import org.springframework.stereotype.Controller;
/* 12:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 13:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 14:   */ 
/* 15:   */ @Controller
/* 16:   */ @Scope("prototype")
/* 17:   */ public class Update_supporters_update_terminalstate
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private UserService userService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/Update_supporters_terminalstate"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> uptate_supporters(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:37 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:40 */       req.setCharacterEncoding("utf-8");
/* 30:41 */       resp.setCharacterEncoding("utf-8");
/* 31:   */       
/* 32:43 */       String username = req.getParameter("username");
/* 33:44 */       String terminalstate = req.getParameter("terminalstate");
/* 34:45 */       System.out.println("terminalstate:" + terminalstate);
/* 35:46 */       String supporters = null;
/* 36:47 */       if (("3".equals(terminalstate)) || ("4".equals(terminalstate))) {
/* 37:48 */         supporters = "1";
/* 38:49 */       } else if ("1".equals(terminalstate)) {
/* 39:50 */         supporters = "0";
/* 40:   */       }
/* 41:52 */       String channelid = req.getParameter("channelid");
/* 42:   */       
/* 43:   */ 
/* 44:55 */       Map<String, Object> supportersMap = new HashMap();
/* 45:56 */       supportersMap.put("Username", username);
/* 46:57 */       supportersMap.put("Channelid", channelid);
/* 47:58 */       supportersMap.put("Supporters", supporters);
/* 48:59 */       supportersMap.put("Terminalstate", terminalstate);
/* 49:60 */       int i = this.userService.updateUserinfoTerminalstateByusername(supportersMap);
/* 50:61 */       map.put("data", i + "");
/* 51:62 */       return map;
/* 52:   */     }
/* 53:   */     catch (Exception ex)
/* 54:   */     {
/* 55:65 */       ex.printStackTrace();
/* 56:66 */       map.put("error", ex.getMessage());
/* 57:   */     }
/* 58:67 */     return map;
/* 59:   */   }
/* 60:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Update_supporters_update_terminalstate

 * JD-Core Version:    0.7.0.1

 */