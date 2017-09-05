/*  1:   */ package com.brave.feature.controller.company;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.CompanyService;
/*  4:   */ import com.brave.feature.service.UserService;
/*  5:   */ import java.io.PrintStream;
/*  6:   */ import java.text.SimpleDateFormat;
/*  7:   */ import java.util.Date;
/*  8:   */ import java.util.HashMap;
/*  9:   */ import java.util.List;
/* 10:   */ import java.util.Map;
/* 11:   */ import javax.servlet.http.HttpServletRequest;
/* 12:   */ import javax.servlet.http.HttpServletResponse;
/* 13:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 14:   */ import org.springframework.context.annotation.Scope;
/* 15:   */ import org.springframework.stereotype.Controller;
/* 16:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 17:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 18:   */ 
/* 19:   */ @Controller
/* 20:   */ @Scope("prototype")
/* 21:   */ public class Insert_relation
/* 22:   */ {
/* 23:   */   @Autowired
/* 24:   */   private CompanyService companyService;
/* 25:   */   @Autowired
/* 26:   */   private UserService userService;
/* 27:   */   
/* 28:   */   @ResponseBody
/* 29:   */   @RequestMapping(value={"/Insert_relation_company"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 30:   */   public Map<String, Object> insert_relation_company(HttpServletRequest req, HttpServletResponse resp)
/* 31:   */   {
/* 32:41 */     Map<String, Object> map = new HashMap();
/* 33:   */     try
/* 34:   */     {
/* 35:44 */       req.setCharacterEncoding("utf-8");
/* 36:45 */       resp.setCharacterEncoding("utf-8");
/* 37:46 */       String username = req.getParameter("username");
/* 38:47 */       String companyid = req.getParameter("companyid");
/* 39:48 */       String city = req.getParameter("city");
/* 40:49 */       Map<String, Object> companyMap = new HashMap();
/* 41:50 */       companyMap.put("Username", username);
/* 42:51 */       companyMap.put("Companyid", companyid);
/* 43:52 */       companyMap.put("City", city);
/* 44:53 */       List<Map<String, Object>> list = this.userService.selectUserScore(companyMap);
/* 45:54 */       int score = Integer.parseInt(((Map)list.get(0)).get("score").toString());
/* 46:55 */       List<Map<String, Object>> list_rtn = this.companyService.selectMountCompany(companyMap);
/* 47:56 */       List<Map<String, Object>> list_relstion = this.companyService.selectRelationCompany(companyMap);
/* 48:57 */       int purchasemount = Integer.parseInt(((Map)list_rtn.get(0)).get("purchasemount")
/* 49:58 */         .toString());
/* 50:59 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 51:60 */       String attentionTime = df.format(new Date());
/* 52:61 */       int i = 0;
/* 53:62 */       System.out.println("list_relstion:" + list_relstion.size());
/* 54:63 */       if (list_relstion.size() == 0)
/* 55:   */       {
/* 56:64 */         if (score >= 3)
/* 57:   */         {
/* 58:65 */           score -= 3;
/* 59:66 */           purchasemount++;
/* 60:67 */           Map<String, Object> userMap = new HashMap();
/* 61:68 */           userMap.put("Username", username);
/* 62:69 */           userMap.put("Score", Integer.valueOf(score));
/* 63:70 */           userMap.put("City", city);
/* 64:71 */           userMap.put("Companyid", companyid);
/* 65:72 */           userMap.put("AttentionTime", attentionTime);
/* 66:73 */           userMap.put("PurchaseMount", purchasemount + "");
/* 67:74 */           i = this.userService.updateUserinfoScoreByusername(userMap);
/* 68:75 */           int j = this.companyService.insertRelationCompany(userMap);
/* 69:76 */           int k = this.companyService.updateCompanyPurchaseMount(userMap);
/* 70:77 */           if ((i > 0) && (j > 0) && (k > 0))
/* 71:   */           {
/* 72:78 */             List<Map<String, Object>> list_data = this.companyService.selectCompanyById(userMap);
/* 73:79 */             ((Map)list_data.get(0)).put("state", "1");
/* 74:80 */             ((Map)list_data.get(0)).remove("purchasemount");
/* 75:81 */             ((Map)list_data.get(0)).put("purchasemount", purchasemount + "");
/* 76:82 */             map.put("info", list_data);
/* 77:83 */             map.put("data", "1");
/* 78:   */           }
/* 79:   */           else
/* 80:   */           {
/* 81:85 */             map.put("data", "0");
/* 82:   */           }
/* 83:   */         }
/* 84:   */         else
/* 85:   */         {
/* 86:88 */           map.put("data", "0");
/* 87:   */         }
/* 88:   */       }
/* 89:   */       else {
/* 90:91 */         map.put("data", "0");
/* 91:   */       }
/* 92:93 */       return map;
/* 93:   */     }
/* 94:   */     catch (Exception ex)
/* 95:   */     {
/* 96:96 */       ex.printStackTrace();
/* 97:97 */       map.put("error", ex.getMessage());
/* 98:   */     }
/* 99:98 */     return map;
/* :0:   */   }
/* :1:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.company.Insert_relation

 * JD-Core Version:    0.7.0.1

 */