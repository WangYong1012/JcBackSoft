/*  1:   */ package com.brave.feature.controller.group;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.GroupInfoService;
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
/* 16:   */ public class Update_groupinfo_rule
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private GroupInfoService groupInfoService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/update_groupinfo_rule"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> update_groupinfo_rule(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:37 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:40 */       req.setCharacterEncoding("utf-8");
/* 29:41 */       resp.setCharacterEncoding("utf-8");
/* 30:42 */       String rule = req.getParameter("rule");
/* 31:43 */       String group_id = req.getParameter("groupid");
/* 32:44 */       Map<String, Object> GroupMap = new HashMap();
/* 33:45 */       GroupMap.put("Rule", rule);
/* 34:46 */       GroupMap.put("Groupid", group_id);
/* 35:47 */       int i = this.groupInfoService.updateGroupinfoRule(GroupMap);
/* 36:48 */       map.put("data", i + "");
/* 37:49 */       return map;
/* 38:   */     }
/* 39:   */     catch (Exception ex)
/* 40:   */     {
/* 41:52 */       ex.printStackTrace();
/* 42:53 */       map.put("error", ex.getMessage());
/* 43:   */     }
/* 44:54 */     return map;
/* 45:   */   }
/* 46:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.group.Update_groupinfo_rule

 * JD-Core Version:    0.7.0.1

 */