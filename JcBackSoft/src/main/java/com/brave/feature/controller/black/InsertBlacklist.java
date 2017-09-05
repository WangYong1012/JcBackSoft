/*  1:   */ package com.brave.feature.controller.black;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.BlacklistService;
/*  4:   */ import java.util.HashMap;
/*  5:   */ import java.util.Map;
/*  6:   */ import javax.servlet.http.HttpServletRequest;
/*  7:   */ import javax.servlet.http.HttpServletResponse;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.context.annotation.Scope;
/* 10:   */ import org.springframework.stereotype.Controller;
/* 11:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 12:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 13:   */ 
/* 14:   */ @Controller
/* 15:   */ @Scope("prototype")
/* 16:   */ public class InsertBlacklist
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private BlacklistService service;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/insertBlacklist"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> delete_suggest(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:37 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:39 */       req.setCharacterEncoding("utf-8");
/* 29:40 */       resp.setCharacterEncoding("utf-8");
/* 30:41 */       String username = req.getParameter("username");
/* 31:42 */       int list = this.service.insertBlacklist(username);
/* 32:43 */       map.put("data", Integer.valueOf(list));
/* 33:44 */       return map;
/* 34:   */     }
/* 35:   */     catch (Exception ex)
/* 36:   */     {
/* 37:47 */       ex.printStackTrace();
/* 38:48 */       map.put("error", ex.getMessage());
/* 39:   */     }
/* 40:49 */     return map;
/* 41:   */   }
/* 42:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.black.InsertBlacklist

 * JD-Core Version:    0.7.0.1

 */