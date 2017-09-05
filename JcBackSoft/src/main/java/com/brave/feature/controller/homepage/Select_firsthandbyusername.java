/*  1:   */ package com.brave.feature.controller.homepage;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.FirsthandResourcesService;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.util.Arrays;
/*  6:   */ import java.util.HashMap;
/*  7:   */ import java.util.List;
/*  8:   */ import java.util.Map;
/*  9:   */ import javax.servlet.http.HttpServletRequest;
/* 10:   */ import javax.servlet.http.HttpServletResponse;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.context.annotation.Scope;
/* 13:   */ import org.springframework.stereotype.Controller;
/* 14:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 15:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ @Scope("prototype")
/* 19:   */ public class Select_firsthandbyusername
/* 20:   */ {
/* 21:   */   @Autowired
/* 22:   */   private FirsthandResourcesService service;
/* 23:   */   
/* 24:   */   @ResponseBody
/* 25:   */   @RequestMapping(value={"/select_firsthandbyusername"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 26:   */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/* 27:   */   {
/* 28:46 */     Map<String, Object> map = new HashMap();
/* 29:   */     try
/* 30:   */     {
/* 31:49 */       req.setCharacterEncoding("utf-8");
/* 32:50 */       resp.setCharacterEncoding("utf-8");
/* 33:51 */       String username = req.getParameter("username");
/* 34:52 */       List<Map<String, Object>> list = this.service.selectFirsthandByUsername(username);
/* 35:53 */       System.out.println("listSize:" + list.size());
/* 36:54 */       if (list.size() == 0) {
/* 37:55 */         return null;
/* 38:   */       }
/* 39:57 */       List<Map<String, Object>> regionList = this.service.selectAuthenticationRegionByUsername(username);
/* 40:58 */       String[] regions = new String[regionList.size()];
/* 41:59 */       for (int i = 0; i < regionList.size(); i++)
/* 42:   */       {
/* 43:60 */         String region = ((Map)regionList.get(i)).get("authenticationRegion").toString();
/* 44:61 */         regions[i] = region;
/* 45:   */       }
/* 46:63 */       System.out.println(Arrays.toString(regions));
/* 47:64 */       String region = Arrays.toString(regions).replaceAll("\\[", "").replaceAll("\\]", "");
/* 48:65 */       System.out.println("region:" + region);
/* 49:66 */       ((Map)list.get(0)).put("region", region);
/* 50:67 */       map.put("data", list);
/* 51:68 */       return map;
/* 52:   */     }
/* 53:   */     catch (Exception ex)
/* 54:   */     {
/* 55:71 */       ex.printStackTrace();
/* 56:72 */       map.put("error", ex.getMessage());
/* 57:   */     }
/* 58:73 */     return map;
/* 59:   */   }
/* 60:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Select_firsthandbyusername

 * JD-Core Version:    0.7.0.1

 */