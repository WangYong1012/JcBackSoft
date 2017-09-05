/*  1:   */ package com.brave.feature.controller.me;
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
/* 17:   */ public class Select_userinfo
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private UserService userService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/select_userinfo"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> select_userinfo(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:38 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:41 */       req.setCharacterEncoding("utf-8");
/* 30:42 */       resp.setCharacterEncoding("utf-8");
/* 31:43 */       List<Map<String, Object>> list_rtn = this.userService.selectAllUserinfo();
/* 32:44 */       map.put("data", list_rtn);
/* 33:45 */       return map;
/* 34:   */     }
/* 35:   */     catch (Exception ex)
/* 36:   */     {
/* 37:48 */       ex.printStackTrace();
/* 38:49 */       map.put("error", ex.getMessage());
/* 39:   */     }
/* 40:50 */     return map;
/* 41:   */   }
/* 42:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.me.Select_userinfo

 * JD-Core Version:    0.7.0.1

 */