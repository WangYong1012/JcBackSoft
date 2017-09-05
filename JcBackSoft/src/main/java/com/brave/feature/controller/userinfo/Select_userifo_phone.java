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
/* 17:   */ public class Select_userifo_phone
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   public UserService userService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/Select_userifo_phone"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> select_userinfo_name(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:37 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:40 */       req.setCharacterEncoding("utf-8");
/* 30:41 */       resp.setCharacterEncoding("utf-8");
/* 31:42 */       String phone = req.getParameter("phone");
/* 32:43 */       List<Map<String, Object>> list = this.userService.selectUserinfoByPhone(phone);
/* 33:   */       
/* 34:45 */       map.put("data", list);
/* 35:46 */       return map;
/* 36:   */     }
/* 37:   */     catch (Exception ex)
/* 38:   */     {
/* 39:49 */       ex.printStackTrace();
/* 40:50 */       map.put("error", ex.getMessage());
/* 41:   */     }
/* 42:51 */     return map;
/* 43:   */   }
/* 44:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Select_userifo_phone

 * JD-Core Version:    0.7.0.1

 */