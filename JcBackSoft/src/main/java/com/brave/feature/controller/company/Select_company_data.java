/*  1:   */ package com.brave.feature.controller.company;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.CompanyService;
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
/* 17:   */ public class Select_company_data
/* 18:   */ {
/* 19:   */   @Autowired
/* 20:   */   private CompanyService companyService;
/* 21:   */   
/* 22:   */   @ResponseBody
/* 23:   */   @RequestMapping(value={"/select_company_data"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 24:   */   public Map<String, Object> select_company_data(HttpServletRequest req, HttpServletResponse resp)
/* 25:   */   {
/* 26:37 */     Map<String, Object> map = new HashMap();
/* 27:   */     try
/* 28:   */     {
/* 29:40 */       req.setCharacterEncoding("utf-8");
/* 30:41 */       resp.setCharacterEncoding("utf-8");
/* 31:42 */       String username = req.getParameter("username");
/* 32:43 */       String companyId = req.getParameter("companyid");
/* 33:44 */       Map<String, Object> companymap = new HashMap();
/* 34:45 */       companymap.put("Username", username);
/* 35:46 */       companymap.put("CompanyId", companyId);
/* 36:47 */       List<Map<String, Object>> list = this.companyService.selectRelationCompany(companymap);
/* 37:48 */       if (list.size() > 0)
/* 38:   */       {
/* 39:49 */         List<Map<String, Object>> list_rtn = this.companyService.selectCompanyById(companymap);
/* 40:50 */         map.put("data", list_rtn);
/* 41:   */       }
/* 42:   */       else
/* 43:   */       {
/* 44:52 */         map.put("data", "0");
/* 45:   */       }
/* 46:54 */       return map;
/* 47:   */     }
/* 48:   */     catch (Exception ex)
/* 49:   */     {
/* 50:57 */       ex.printStackTrace();
/* 51:58 */       map.put("error", ex.getMessage());
/* 52:   */     }
/* 53:59 */     return map;
/* 54:   */   }
/* 55:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.company.Select_company_data

 * JD-Core Version:    0.7.0.1

 */