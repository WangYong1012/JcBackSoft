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
/* 17:   */ public class Select_Mydata
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   public UserService userService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/select_Mydata"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> select_Mydata(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:37 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:40 */       req.setCharacterEncoding("utf-8");
/* 30:41 */       resp.setCharacterEncoding("utf-8");
/* 31:42 */       String username = req.getParameter("name");
/* 32:43 */       Map<String, Object> selectMyDataMap = new HashMap();
/* 33:44 */       selectMyDataMap.put("Username", username);
/* 34:45 */       List<Map<String, Object>> list = this.userService.selectMydata(selectMyDataMap);
/* 35:   */       
/* 36:47 */       map.put("data", list);
/* 37:48 */       return map;
/* 38:   */     }
/* 39:   */     catch (Exception ex)
/* 40:   */     {
/* 41:51 */       ex.printStackTrace();
/* 42:52 */       map.put("error", ex.getMessage());
/* 43:   */     }
/* 44:53 */     return map;
/* 45:   */   }
/* 46:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Select_Mydata

 * JD-Core Version:    0.7.0.1

 */