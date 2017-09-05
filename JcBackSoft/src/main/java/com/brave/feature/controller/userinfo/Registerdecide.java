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
/* 17:   */ public class Registerdecide
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   public UserService userService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/registerdecide"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> registerdecide(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:38 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:41 */       req.setCharacterEncoding("utf-8");
/* 30:42 */       resp.setCharacterEncoding("utf-8");
/* 31:43 */       String username = req.getParameter("username");
/* 32:   */       
/* 33:45 */       Map<String, Object> usermap = new HashMap();
/* 34:46 */       usermap.put("Username", username);
/* 35:47 */       List<Map<String, Object>> list_rtn = this.userService.selectMydata(usermap);
/* 36:49 */       if (list_rtn.size() > 0)
/* 37:   */       {
/* 38:51 */         map.put("sate", "1");
/* 39:52 */         return map;
/* 40:   */       }
/* 41:55 */       map.put("sate", "-1");
/* 42:56 */       return map;
/* 43:   */     }
/* 44:   */     catch (Exception ex)
/* 45:   */     {
/* 46:60 */       ex.printStackTrace();
/* 47:61 */       map.put("error", ex.getMessage());
/* 48:   */     }
/* 49:62 */     return map;
/* 50:   */   }
/* 51:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Registerdecide

 * JD-Core Version:    0.7.0.1

 */