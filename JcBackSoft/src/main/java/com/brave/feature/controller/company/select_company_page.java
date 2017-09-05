/*   1:    */ package com.brave.feature.controller.company;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.CompanyService;
/*   4:    */ import com.brave.feature.util.PageUtil;
/*   5:    */ import java.util.ArrayList;
/*   6:    */ import java.util.HashMap;
/*   7:    */ import java.util.List;
/*   8:    */ import java.util.Map;
/*   9:    */ import javax.servlet.http.HttpServletRequest;
/*  10:    */ import javax.servlet.http.HttpServletResponse;
/*  11:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  12:    */ import org.springframework.context.annotation.Scope;
/*  13:    */ import org.springframework.stereotype.Controller;
/*  14:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  15:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  16:    */ 
/*  17:    */ @Controller
/*  18:    */ @Scope("prototype")
/*  19:    */ public class select_company_page
/*  20:    */ {
/*  21: 33 */   private int pagesize = 10;
/*  22:    */   @Autowired
/*  23:    */   private CompanyService companyService;
/*  24:    */   
/*  25:    */   @ResponseBody
/*  26:    */   @RequestMapping(value={"/Select_company_page"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  27:    */   public Map<String, Object> Select_company_page(HttpServletRequest req, HttpServletResponse resp)
/*  28:    */   {
/*  29: 42 */     Map<String, Object> map = new HashMap();
/*  30:    */     try
/*  31:    */     {
/*  32: 45 */       req.setCharacterEncoding("utf-8");
/*  33: 46 */       resp.setCharacterEncoding("utf-8");
/*  34: 47 */       String username = req.getParameter("username");
/*  35: 48 */       int pageIndex = Integer.parseInt(req.getParameter("pageindex"));
/*  36: 49 */       String city = req.getParameter("city");
/*  37: 50 */       Map<String, Object> commap = new HashMap();
/*  38:    */       
/*  39: 52 */       int startRow = PageUtil.getStartRow(pageIndex, this.pagesize).intValue();
/*  40: 53 */       commap.put("Username", username);
/*  41: 54 */       commap.put("City", city);
/*  42: 55 */       commap.put("StartRow", Integer.valueOf(startRow));
/*  43: 56 */       commap.put("Pagesize", Integer.valueOf(this.pagesize));
/*  44: 57 */       List<Map<String, Object>> list = this.companyService.selectCompanyNumByCity(city);
/*  45: 58 */       String count = ((Map)list.get(0)).get("num").toString();
/*  46:    */       
/*  47: 60 */       int pageCount = Integer.parseInt(PageUtil.setTotalPageCountByRs(count, this.pagesize));
/*  48:    */       
/*  49: 62 */       List<Map<String, Object>> list_limit = this.companyService.selectCompanyDataByPage(commap);
/*  50:    */       
/*  51: 64 */       List<Map<String, Object>> list_relaton = this.companyService.selectRelationCompanyByCity(commap);
/*  52:    */       
/*  53: 66 */       List<String> list_appList = new ArrayList();
/*  54: 67 */       for (int i = 0; i < list_limit.size(); i++)
/*  55:    */       {
/*  56: 69 */         String companyid_limit = ((Map)list_limit.get(i)).get("companyid").toString();
/*  57: 70 */         if (list_relaton.size() > 0)
/*  58:    */         {
/*  59: 71 */           for (int j = 0; j < list_relaton.size(); j++)
/*  60:    */           {
/*  61: 73 */             String companyid_relaton = ((Map)list_relaton.get(j)).get("companyid").toString();
/*  62: 74 */             list_appList.add(companyid_relaton);
/*  63:    */           }
/*  64: 76 */           if (list_appList.contains(companyid_limit))
/*  65:    */           {
/*  66: 77 */             ((Map)list_limit.get(i)).put("state", "1");
/*  67:    */           }
/*  68:    */           else
/*  69:    */           {
/*  70: 79 */             ((Map)list_limit.get(i)).put("state", "0");
/*  71: 80 */             ((Map)list_limit.get(i)).remove("companyname");
/*  72: 81 */             ((Map)list_limit.get(i)).remove("companyaddress");
/*  73: 82 */             ((Map)list_limit.get(i)).remove("phone");
/*  74: 83 */             ((Map)list_limit.get(i)).remove("linkname");
/*  75: 84 */             ((Map)list_limit.get(i)).remove("cptime");
/*  76:    */           }
/*  77:    */         }
/*  78:    */         else
/*  79:    */         {
/*  80: 87 */           ((Map)list_limit.get(i)).put("state", "0");
/*  81: 88 */           ((Map)list_limit.get(i)).remove("companyname");
/*  82: 89 */           ((Map)list_limit.get(i)).remove("companyaddress");
/*  83: 90 */           ((Map)list_limit.get(i)).remove("phone");
/*  84: 91 */           ((Map)list_limit.get(i)).remove("linkname");
/*  85: 92 */           ((Map)list_limit.get(i)).remove("cptime");
/*  86:    */         }
/*  87:    */       }
/*  88: 95 */       map.put("data", list_limit);
/*  89: 96 */       map.put("num", pageCount + "");
/*  90: 97 */       return map;
/*  91:    */     }
/*  92:    */     catch (Exception ex)
/*  93:    */     {
/*  94:100 */       ex.printStackTrace();
/*  95:101 */       map.put("error", ex.getMessage());
/*  96:    */     }
/*  97:102 */     return map;
/*  98:    */   }
/*  99:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.company.select_company_page

 * JD-Core Version:    0.7.0.1

 */