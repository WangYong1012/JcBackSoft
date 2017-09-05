/*  1:   */ package com.brave.feature.controller.homepage;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.FirsthandResourcesService;
/*  4:   */ import java.util.ArrayList;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import java.util.List;
/*  7:   */ import java.util.Map;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import javax.servlet.http.HttpServletResponse;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.context.annotation.Scope;
/* 12:   */ import org.springframework.stereotype.Controller;
/* 13:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 14:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 15:   */ 
/* 16:   */ @Controller
/* 17:   */ @Scope("prototype")
/* 18:   */ public class Select_authentication_type
/* 19:   */ {
/* 20:   */   @Autowired
/* 21:   */   private FirsthandResourcesService service;
/* 22:   */   
/* 23:   */   @ResponseBody
/* 24:   */   @RequestMapping(value={"/select_authentication_type"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 25:   */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/* 26:   */   {
/* 27:39 */     Map<String, Object> map = new HashMap();
/* 28:   */     try
/* 29:   */     {
/* 30:42 */       req.setCharacterEncoding("utf-8");
/* 31:43 */       resp.setCharacterEncoding("utf-8");
/* 32:44 */       List<Map<String, Object>> list = this.service.selectAuthenticationType();
/* 33:45 */       List<String> list1 = new ArrayList();
/* 34:46 */       for (Map<String, Object> ma : list) {
/* 35:47 */         list1.add(ma.get("typename").toString());
/* 36:   */       }
/* 37:49 */       map.put("list", list1);
/* 38:50 */       return map;
/* 39:   */     }
/* 40:   */     catch (Exception ex)
/* 41:   */     {
/* 42:54 */       ex.printStackTrace();
/* 43:55 */       map.put("error", ex.getMessage());
/* 44:   */     }
/* 45:56 */     return map;
/* 46:   */   }
/* 47:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Select_authentication_type

 * JD-Core Version:    0.7.0.1

 */