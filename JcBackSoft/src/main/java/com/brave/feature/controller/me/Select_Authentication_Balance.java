/*  1:   */ package com.brave.feature.controller.me;
/*  2:   */ 
/*  3:   */ import java.util.HashMap;
/*  4:   */ import java.util.Locale;
/*  5:   */ import java.util.Map;
/*  6:   */ import java.util.ResourceBundle;
/*  7:   */ import org.springframework.context.annotation.Scope;
/*  8:   */ import org.springframework.stereotype.Controller;
/*  9:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 10:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 11:   */ import org.springframework.web.servlet.ModelAndView;
/* 12:   */ 
/* 13:   */ @Controller
/* 14:   */ @Scope("prototype")
/* 15:   */ public class Select_Authentication_Balance
/* 16:   */ {
/* 17:   */   @ResponseBody
/* 18:   */   @RequestMapping(value={"/selectAuthenticationBalance"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 19:   */   public ModelAndView selectAuthenticationBalance()
/* 20:   */   {
/* 21:31 */     ModelAndView mv = new ModelAndView();
/* 22:32 */     Map<String, Object> result = new HashMap();
/* 23:   */     try
/* 24:   */     {
/* 25:36 */       Locale locale = new Locale("zh", "CN");
/* 26:37 */       ResourceBundle boundle = ResourceBundle.getBundle("RestAPIConfig", locale);
/* 27:38 */       String balance = boundle.getString("BALANCE_OF_AUTHENTICATION");
/* 28:39 */       result.put("data", balance);
/* 29:40 */       mv.addAllObjects(result);
/* 30:41 */       return mv;
/* 31:   */     }
/* 32:   */     catch (Exception ex)
/* 33:   */     {
/* 34:44 */       ex.printStackTrace();
/* 35:45 */       result.put("error", ex.getMessage());
/* 36:46 */       mv.addAllObjects(result);
/* 37:   */     }
/* 38:47 */     return mv;
/* 39:   */   }
/* 40:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.me.Select_Authentication_Balance

 * JD-Core Version:    0.7.0.1

 */