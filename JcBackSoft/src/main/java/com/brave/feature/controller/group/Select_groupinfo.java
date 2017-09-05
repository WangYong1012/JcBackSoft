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
/* 14:   */ import org.springframework.web.servlet.ModelAndView;
/* 15:   */ 
/* 16:   */ @Controller
/* 17:   */ @Scope("prototype")
/* 18:   */ public class Select_groupinfo
/* 19:   */ {
/* 20:   */   @Autowired
/* 21:   */   private GroupInfoService groupInfoService;
/* 22:   */   
/* 23:   */   @ResponseBody
/* 24:   */   @RequestMapping(value={"/Select_groupinfo"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 25:   */   public Map<String, Object> Select_groupinfo_data(HttpServletRequest req, HttpServletResponse resp)
/* 26:   */   {
/* 27:38 */     Map<String, Object> map = new HashMap();
/* 28:39 */     ModelAndView model = new ModelAndView();
/* 29:   */     try
/* 30:   */     {
/* 31:42 */       req.setCharacterEncoding("utf-8");
/* 32:43 */       resp.setCharacterEncoding("utf-8");
/* 33:44 */       List<Map<String, Object>> list = this.groupInfoService.SelectGroupinfo();
/* 34:45 */       map.put("data", list);
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

 * Qualified Name:     com.jcsoft.feature.controller.group.Select_groupinfo

 * JD-Core Version:    0.7.0.1

 */