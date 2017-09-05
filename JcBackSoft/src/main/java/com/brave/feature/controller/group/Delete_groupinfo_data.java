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
/* 16:   */ public class Delete_groupinfo_data
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private GroupInfoService groupInfoService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/delete_groupinfo_data"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> delete_groupinfo(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:36 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:39 */       req.setCharacterEncoding("utf-8");
/* 29:40 */       resp.setCharacterEncoding("utf-8");
/* 30:41 */       String groupid = req.getParameter("groupid");
/* 31:42 */       Map<String, Object> GroupMap = new HashMap();
/* 32:43 */       GroupMap.put("Groupid", groupid);
/* 33:44 */       int i = this.groupInfoService.deleteGroupinfoById(GroupMap);
/* 34:45 */       map.put("data", i + "");
/* 35:46 */       return map;
/* 36:   */     }
/* 37:   */     catch (Exception ex)
/* 38:   */     {
/* 39:49 */       ex.printStackTrace();
/* 40:50 */       map.put("error", ex.getMessage());
/* 41:   */     }
/* 42:51 */     return map;
/* 43:   */   }
/* 44:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.group.Delete_groupinfo_data

 * JD-Core Version:    0.7.0.1

 */