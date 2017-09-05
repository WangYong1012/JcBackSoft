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
/* 17:   */ public class Select_groupinfo_data
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private GroupInfoService groupInfoService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/select_groupinfo_data"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> select_groupinfo_data(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:37 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:40 */       req.setCharacterEncoding("utf-8");
/* 30:41 */       resp.setCharacterEncoding("utf-8");
/* 31:42 */       String group_id = req.getParameter("groupid");
/* 32:43 */       List<Map<String, Object>> list = this.groupInfoService.selectGroupinfoData(group_id);
/* 33:44 */       map.put("data", list);
/* 34:45 */       return map;
/* 35:   */     }
/* 36:   */     catch (Exception ex)
/* 37:   */     {
/* 38:48 */       ex.printStackTrace();
/* 39:49 */       map.put("error", ex.getMessage());
/* 40:   */     }
/* 41:50 */     return map;
/* 42:   */   }
/* 43:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.group.Select_groupinfo_data

 * JD-Core Version:    0.7.0.1

 */