/*  1:   */ package com.brave.feature.controller.supporter;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.SupporterService;
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
/* 16:   */ public class Update_supporters_checkeout
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private SupporterService supporterService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/Update_supporters_checkeout"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> update_supporters_checkeout(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:37 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:40 */       req.setCharacterEncoding("utf-8");
/* 29:41 */       resp.setCharacterEncoding("utf-8");
/* 30:   */       
/* 31:43 */       String checkedout = req.getParameter("checkedout");
/* 32:44 */       String supportersid = req.getParameter("supportersid");
/* 33:45 */       Map<String, Object> supportersMap = new HashMap();
/* 34:46 */       supportersMap.put("Checkedout", checkedout);
/* 35:47 */       supportersMap.put("Supportersid", supportersid);
/* 36:48 */       int i = this.supporterService.updateSupportersCheckOut(supportersMap);
/* 37:   */       
/* 38:50 */       map.put("data", i + "");
/* 39:51 */       return map;
/* 40:   */     }
/* 41:   */     catch (Exception ex)
/* 42:   */     {
/* 43:54 */       ex.printStackTrace();
/* 44:55 */       map.put("error", ex.getMessage());
/* 45:   */     }
/* 46:56 */     return map;
/* 47:   */   }
/* 48:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.supporter.Update_supporters_checkeout

 * JD-Core Version:    0.7.0.1

 */