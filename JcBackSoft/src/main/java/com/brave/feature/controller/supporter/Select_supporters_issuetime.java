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
/* 13:   */ import org.springframework.web.servlet.ModelAndView;
/* 14:   */ 
/* 15:   */ @Controller
/* 16:   */ @Scope("prototype")
/* 17:   */ public class Select_supporters_issuetime
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private SupporterService supporterService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/select_supporters_issuetime"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public ModelAndView select_supporters_issuetime(HttpServletRequest request, HttpServletResponse response)
/* 25:   */   {
/* 26:35 */     ModelAndView model = new ModelAndView();
/* 27:36 */     Map<String, Object> map = new HashMap();
/* 28:   */     try
/* 29:   */     {
/* 30:39 */       request.setCharacterEncoding("utf-8");
/* 31:40 */       response.setCharacterEncoding("utf-8");
/* 32:41 */       String Issuetime = request.getParameter("issuetime");
/* 33:42 */       int amount = this.supporterService.selectSupportersAmountByIssuetime(Issuetime);
/* 34:43 */       map.put("amount", Integer.valueOf(amount));
/* 35:44 */       model.addAllObjects(map);
/* 36:45 */       return model;
/* 37:   */     }
/* 38:   */     catch (Exception ex)
/* 39:   */     {
/* 40:48 */       ex.printStackTrace();
/* 41:49 */       map.put("error", ex.getMessage());
/* 42:50 */       model.addAllObjects(map);
/* 43:   */     }
/* 44:51 */     return model;
/* 45:   */   }
/* 46:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.supporter.Select_supporters_issuetime

 * JD-Core Version:    0.7.0.1

 */