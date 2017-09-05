/*  1:   */ package com.brave.feature.controller.supporter;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.SupporterService;
/*  4:   */ import com.brave.feature.service.UserService;
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
/* 18:   */ public class Select_supporters_userputong
/* 19:   */ {
/* 20:   */   @Autowired
/* 21:   */   private SupporterService supporterService;
/* 22:   */   @Autowired
/* 23:   */   private UserService userService;
/* 24:   */   
/* 25:   */   @ResponseBody
/* 26:   */   @RequestMapping(value={"/Select_supporters_userputong"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 27:   */   public Map<String, Object> select_supporters(HttpServletRequest req, HttpServletResponse resp)
/* 28:   */   {
/* 29:41 */     Map<String, Object> map = new HashMap();
/* 30:   */     try
/* 31:   */     {
/* 32:44 */       req.setCharacterEncoding("utf-8");
/* 33:45 */       resp.setCharacterEncoding("utf-8");
/* 34:46 */       String num = req.getParameter("num");
/* 35:   */       int i;
/* 36:48 */       if ("0".equals(num))
/* 37:   */       {
/* 38:49 */         i = 0;
/* 39:   */       }
/* 40:   */       else
/* 41:   */       {
/* 42:51 */         i = Integer.parseInt(num) * 10;
/* 43:   */         
/* 44:53 */         List<Map<String, Object>> list = this.supporterService.selectCommonUser(i);
/* 45:54 */         List<Map<String, Object>> zuobiao = this.userService.selectTitudeAll();
/* 46:   */         
/* 47:56 */         map.put("data", list);
/* 48:57 */         map.put("zuobiao", zuobiao);
/* 49:   */       }
/* 50:59 */       return map;
/* 51:   */     }
/* 52:   */     catch (Exception ex)
/* 53:   */     {
/* 54:62 */       ex.printStackTrace();
/* 55:63 */       map.put("error", ex.getMessage());
/* 56:   */     }
/* 57:64 */     return map;
/* 58:   */   }
/* 59:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.supporter.Select_supporters_userputong

 * JD-Core Version:    0.7.0.1

 */