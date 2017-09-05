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
/* 17:   */ public class Select_groupinfo_id_province
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private GroupInfoService groupInfoService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/select_groupinfo_id_province"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> Select_groupinfo_data(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:35 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:38 */       req.setCharacterEncoding("utf-8");
/* 30:39 */       resp.setCharacterEncoding("utf-8");
/* 31:40 */       List<Map<String, Object>> list = this.groupInfoService.SelectGroupinfoIdAndProvince();
/* 32:41 */       map.put("data", list);
/* 33:42 */       return map;
/* 34:   */     }
/* 35:   */     catch (Exception ex)
/* 36:   */     {
/* 37:45 */       ex.printStackTrace();
/* 38:46 */       map.put("error", ex.getMessage());
/* 39:   */     }
/* 40:47 */     return map;
/* 41:   */   }
/* 42:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.group.Select_groupinfo_id_province

 * JD-Core Version:    0.7.0.1

 */