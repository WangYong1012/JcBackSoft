/*  1:   */ package com.brave.feature.controller.userinfo;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.UserService;
/*  4:   */ import java.util.HashMap;
/*  5:   */ import java.util.List;
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
/* 17:   */ public class LoginGetHxid
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   public UserService userService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/login_get_hxid"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> doLogin(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:38 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:42 */       req.setCharacterEncoding("utf-8");
/* 30:43 */       resp.setCharacterEncoding("utf-8");
/* 31:   */       
/* 32:45 */       Map<String, Object> usermap = new HashMap();
/* 33:   */       
/* 34:47 */       String username = req.getParameter("name");
/* 35:48 */       usermap.put("Username", username);
/* 36:49 */       List<Map<String, Object>> list_rtn = this.userService.selectMydata(usermap);
/* 37:50 */       String fanhui = "";
/* 38:52 */       if ((list_rtn != null) && (list_rtn.size() > 0)) {
/* 39:53 */         fanhui = ((Map)list_rtn.get(0)).get("hxid").toString();
/* 40:   */       }
/* 41:55 */       map.put("data", fanhui);
/* 42:56 */       return map;
/* 43:   */     }
/* 44:   */     catch (Exception ex)
/* 45:   */     {
/* 46:59 */       ex.printStackTrace();
/* 47:60 */       map.put("error", ex.getMessage());
/* 48:   */     }
/* 49:61 */     return map;
/* 50:   */   }
/* 51:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.LoginGetHxid

 * JD-Core Version:    0.7.0.1

 */