/*  1:   */ package com.brave.feature.controller.suggest;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.SuggestService;
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
/* 16:   */ public class Insert_suggest
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private SuggestService suggestService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/insert_suggest"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> insert_suggest(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:37 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:40 */       req.setCharacterEncoding("utf-8");
/* 29:41 */       resp.setCharacterEncoding("utf-8");
/* 30:42 */       String username = req.getParameter("username");
/* 31:43 */       String issuetime = req.getParameter("issuetime");
/* 32:44 */       String suggest = req.getParameter("suggest");
/* 33:45 */       String suggestid = req.getParameter("suggestid");
/* 34:46 */       String phone = req.getParameter("phone");
/* 35:47 */       Map<String, Object> suggestMap = new HashMap();
/* 36:48 */       suggestMap.put("Username", username);
/* 37:49 */       suggestMap.put("Suggest", suggest);
/* 38:50 */       suggestMap.put("Issuetime", issuetime);
/* 39:51 */       suggestMap.put("SuggestId", suggestid);
/* 40:52 */       suggestMap.put("Phone", phone);
/* 41:53 */       suggestMap.put("DealState", "0");
/* 42:54 */       int result = this.suggestService.insertSuggest(suggestMap);
/* 43:55 */       map.put("data", result + "");
/* 44:56 */       return map;
/* 45:   */     }
/* 46:   */     catch (Exception ex)
/* 47:   */     {
/* 48:59 */       ex.printStackTrace();
/* 49:60 */       map.put("error", ex.getMessage());
/* 50:   */     }
/* 51:61 */     return map;
/* 52:   */   }
/* 53:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.suggest.Insert_suggest

 * JD-Core Version:    0.7.0.1

 */