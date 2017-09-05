/*  1:   */ package com.brave.feature.controller.supporter;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.SupporterService;
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
/* 17:   */ public class Select_supporters
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private SupporterService supporterService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/select_supporters"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> select_supporters(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:38 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:41 */       req.setCharacterEncoding("utf-8");
/* 30:42 */       resp.setCharacterEncoding("utf-8");
/* 31:43 */       int maxnum = Integer.parseInt(req.getParameter("maxnum").toString());
/* 32:44 */       int currentPage = Integer.parseInt(req.getParameter("currentPage").toString());
/* 33:45 */       Map<String, Object> supportersMap = new HashMap();
/* 34:46 */       supportersMap.put("CurrentPage", Integer.valueOf(currentPage));
/* 35:47 */       supportersMap.put("PageSize", Integer.valueOf(maxnum));
/* 36:48 */       List<Map<String, Object>> list = this.supporterService.selectSupportersDataByPage(supportersMap);
/* 37:   */       
/* 38:50 */       map.put("data", list);
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

 * Qualified Name:     com.jcsoft.feature.controller.supporter.Select_supporters

 * JD-Core Version:    0.7.0.1

 */