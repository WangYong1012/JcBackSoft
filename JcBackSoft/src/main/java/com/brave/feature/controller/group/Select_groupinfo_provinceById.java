/*  1:   */ package com.brave.feature.controller.group;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.GroupInfoService;
/*  4:   */ import java.io.PrintStream;
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
/* 18:   */ public class Select_groupinfo_provinceById
/* 19:   */ {
/* 20:   */   @Autowired
/* 21:   */   private GroupInfoService groupInfoService;
/* 22:   */   
/* 23:   */   @ResponseBody
/* 24:   */   @RequestMapping(value={"/select_groupinfo_provinceById"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 25:   */   public Map<String, Object> select_groupinfo_data(HttpServletRequest req, HttpServletResponse resp)
/* 26:   */   {
/* 27:35 */     Map<String, Object> map = new HashMap();
/* 28:   */     try
/* 29:   */     {
/* 30:38 */       req.setCharacterEncoding("utf-8");
/* 31:39 */       resp.setCharacterEncoding("utf-8");
/* 32:40 */       String group_id = req.getParameter("groupid");
/* 33:41 */       List<Map<String, Object>> list = this.groupInfoService.selectGroupinfoData(group_id);
/* 34:   */       
/* 35:43 */       String province = "";
/* 36:44 */       if (list.size() > 0)
/* 37:   */       {
/* 38:45 */         System.out.println("list:" + list.toString());
/* 39:46 */         province = ((Map)list.get(0)).get("province").toString();
/* 40:   */       }
/* 41:48 */       map.put("province", province);
/* 42:49 */       return map;
/* 43:   */     }
/* 44:   */     catch (Exception ex)
/* 45:   */     {
/* 46:52 */       ex.printStackTrace();
/* 47:53 */       map.put("error", ex.getMessage());
/* 48:   */     }
/* 49:54 */     return map;
/* 50:   */   }
/* 51:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.group.Select_groupinfo_provinceById

 * JD-Core Version:    0.7.0.1

 */