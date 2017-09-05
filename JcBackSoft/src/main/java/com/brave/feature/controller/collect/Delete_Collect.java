/*  1:   */ package com.brave.feature.controller.collect;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.CollectService;
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
/* 16:   */ public class Delete_Collect
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private CollectService service;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/delete_collect_id"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> delete_collect(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:34 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:37 */       req.setCharacterEncoding("utf-8");
/* 29:38 */       resp.setCharacterEncoding("utf-8");
/* 30:39 */       String ID = req.getParameter("ID");
/* 31:40 */       String username = req.getParameter("username");
/* 32:41 */       Map<String, Object> deleteCollectMap = new HashMap();
/* 33:42 */       deleteCollectMap.put("Supportersid", ID);
/* 34:43 */       deleteCollectMap.put("Username", username);
/* 35:44 */       int i = this.service.deleteCollectByIdUsername(deleteCollectMap);
/* 36:45 */       map.put("data", i + "");
/* 37:46 */       return map;
/* 38:   */     }
/* 39:   */     catch (Exception ex)
/* 40:   */     {
/* 41:49 */       ex.printStackTrace();
/* 42:50 */       map.put("error", ex.getMessage());
/* 43:   */     }
/* 44:51 */     return map;
/* 45:   */   }
/* 46:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.collect.Delete_Collect

 * JD-Core Version:    0.7.0.1

 */