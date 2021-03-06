/*  1:   */ package com.brave.feature.controller.collect;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.CollectService;
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
/* 17:   */ public class select_collect_id
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private CollectService collectService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/select_collect_id"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> select_collect_id(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:33 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:36 */       req.setCharacterEncoding("utf-8");
/* 30:37 */       resp.setCharacterEncoding("utf-8");
/* 31:38 */       String ID = req.getParameter("ID");
/* 32:39 */       String username = req.getParameter("username");
/* 33:40 */       Map<String, Object> CollectMap = new HashMap();
/* 34:41 */       CollectMap.put("Supportersid", ID);
/* 35:42 */       CollectMap.put("Username", username);
/* 36:43 */       List<Map<String, Object>> list = this.collectService.selectCollectById(CollectMap);
/* 37:44 */       map.put("data", list);
/* 38:45 */       return map;
/* 39:   */     }
/* 40:   */     catch (Exception ex)
/* 41:   */     {
/* 42:48 */       ex.printStackTrace();
/* 43:49 */       map.put("data", ex.getMessage());
/* 44:   */     }
/* 45:50 */     return map;
/* 46:   */   }
/* 47:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.collect.select_collect_id

 * JD-Core Version:    0.7.0.1

 */