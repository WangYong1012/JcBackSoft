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
/* 17:   */ public class Select_groupinfo_master
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private GroupInfoService groupInfoService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/Select_groupinfo_master"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> select_groupinfo_master(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:38 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:41 */       req.setCharacterEncoding("utf-8");
/* 30:42 */       resp.setCharacterEncoding("utf-8");
/* 31:43 */       String group_master = req.getParameter("groupmaster");
/* 32:44 */       List<Map<String, Object>> list = this.groupInfoService.SelectGroupinfoByMaster(group_master);
/* 33:45 */       if (list.size() < 5) {
/* 34:46 */         map.put("data", "0");
/* 35:   */       } else {
/* 36:48 */         map.put("data", "1");
/* 37:   */       }
/* 38:50 */       return map;
/* 39:   */     }
/* 40:   */     catch (Exception ex)
/* 41:   */     {
/* 42:53 */       ex.printStackTrace();
/* 43:54 */       map.put("error", ex.getMessage());
/* 44:   */     }
/* 45:55 */     return map;
/* 46:   */   }
/* 47:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.group.Select_groupinfo_master

 * JD-Core Version:    0.7.0.1

 */