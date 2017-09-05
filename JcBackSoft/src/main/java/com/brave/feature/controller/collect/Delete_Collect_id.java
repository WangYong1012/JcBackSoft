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
/* 12:   */ 
/* 13:   */ @Controller
/* 14:   */ @Scope("prototype")
/* 15:   */ public class Delete_Collect_id
/* 16:   */ {
/* 17:   */   @Autowired
/* 18:   */   private CollectService service;
/* 19:   */   
/* 20:   */   @RequestMapping(value={"/Delete_piao_Collect_id"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 21:   */   public Map<String, Object> delete_collect_id(HttpServletRequest req, HttpServletResponse resp)
/* 22:   */   {
/* 23:31 */     Map<String, Object> map = new HashMap();
/* 24:   */     try
/* 25:   */     {
/* 26:34 */       req.setCharacterEncoding("utf-8");
/* 27:35 */       resp.setCharacterEncoding("utf-8");
/* 28:36 */       String ID = req.getParameter("ID");
/* 29:37 */       Map<String, Object> deleteCollectMap = new HashMap();
/* 30:38 */       deleteCollectMap.put("Supportersid", ID);
/* 31:39 */       int i = this.service.deleteCollectById(deleteCollectMap);
/* 32:   */       
/* 33:41 */       map.put("data", i + "");
/* 34:42 */       return map;
/* 35:   */     }
/* 36:   */     catch (Exception ex)
/* 37:   */     {
/* 38:45 */       ex.printStackTrace();
/* 39:46 */       map.put("error", ex.getMessage());
/* 40:   */     }
/* 41:47 */     return map;
/* 42:   */   }
/* 43:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.collect.Delete_Collect_id

 * JD-Core Version:    0.7.0.1

 */