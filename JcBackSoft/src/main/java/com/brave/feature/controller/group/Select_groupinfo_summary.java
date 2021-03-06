/*  1:   */ package com.brave.feature.controller.group;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.GroupInfoService;
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
/* 17:   */ public class Select_groupinfo_summary
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private GroupInfoService groupInfoService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/select_groupinfo_summary"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> select_groupinfo_summary(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:38 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:41 */       req.setCharacterEncoding("utf-8");
/* 30:42 */       resp.setCharacterEncoding("utf-8");
/* 31:43 */       String groupinfo_id = req.getParameter("groupid");
/* 32:44 */       List<Map<String, Object>> result = this.groupInfoService.selectGroupinfoSummaryById(groupinfo_id);
/* 33:45 */       map.put("data", result);
/* 34:46 */       return map;
/* 35:   */     }
/* 36:   */     catch (Exception ex)
/* 37:   */     {
/* 38:49 */       ex.printStackTrace();
/* 39:50 */       map.put("error", ex.getMessage());
/* 40:   */     }
/* 41:51 */     return map;
/* 42:   */   }
/* 43:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.group.Select_groupinfo_summary

 * JD-Core Version:    0.7.0.1

 */