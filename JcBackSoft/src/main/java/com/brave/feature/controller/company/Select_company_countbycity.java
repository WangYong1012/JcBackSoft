/*  1:   */ package com.brave.feature.controller.company;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.CompanyService;
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
/* 18:   */ public class Select_company_countbycity
/* 19:   */ {
/* 20:   */   @Autowired
/* 21:   */   private CompanyService companyService;
/* 22:   */   
/* 23:   */   @ResponseBody
/* 24:   */   @RequestMapping(value={"/Select_company_countbycity"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 25:   */   public Map<String, Object> select_company_countbycity(HttpServletRequest req, HttpServletResponse resp)
/* 26:   */   {
/* 27:37 */     Map<String, Object> map = new HashMap();
/* 28:   */     try
/* 29:   */     {
/* 30:40 */       req.setCharacterEncoding("utf-8");
/* 31:41 */       resp.setCharacterEncoding("utf-8");
/* 32:42 */       List<Map<String, Object>> list = this.companyService.selectCompanyByCity();
/* 33:43 */       for (int i = 0; i < list.size(); i++)
/* 34:   */       {
/* 35:44 */         String city = ((Map)list.get(i)).get("city").toString();
/* 36:45 */         List<Map<String, Object>> list_rtn = this.companyService.selectCompanyCountByCity(city);
/* 37:46 */         int count = 0;
/* 38:47 */         for (int j = 0; j < list_rtn.size(); j++)
/* 39:   */         {
/* 40:48 */           int num = Integer.parseInt(((Map)list_rtn.get(j)).get("purchasemount")
/* 41:49 */             .toString());
/* 42:50 */           count += num;
/* 43:   */         }
/* 44:52 */         map.put(city, count + "");
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
/* 55:   */   
/* 56:   */   public static void main(String[] args)
/* 57:   */   {
/* 58:64 */     int a = 0;int c = 0;
/* 59:   */     do
/* 60:   */     {
/* 61:66 */       c--;
/* 62:67 */       a -= 1;
/* 63:68 */     } while (a > 0);
/* 64:69 */     System.out.println(c);
/* 65:70 */     int[] arr = { 1, 2, 3, 4 };
/* 66:71 */     int[] brr = new int[4];
/* 67:72 */     int b = 0;
/* 68:73 */     for (int i = 0; i < arr.length - 1; i++)
/* 69:   */     {
/* 70:74 */       for (int j = 0; j <= i; j++) {
/* 71:75 */         b += arr[j];
/* 72:   */       }
/* 73:77 */       brr[i] = b;
/* 74:78 */       arr[i] = brr[i];
/* 75:   */     }
/* 76:80 */     System.out.println(arr[1]);
/* 77:   */   }
/* 78:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.company.Select_company_countbycity

 * JD-Core Version:    0.7.0.1

 */