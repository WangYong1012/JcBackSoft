/*  1:   */ package com.brave.feature.controller.homepage;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.LoanService;
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
/* 16:   */ public class Insert_loaninfo
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private LoanService loanService;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/Insert_loaninfo"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> insert_relation_company(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:42 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:45 */       req.setCharacterEncoding("utf-8");
/* 29:46 */       resp.setCharacterEncoding("utf-8");
/* 30:47 */       String username = req.getParameter("username");
/* 31:48 */       String trueusername = req.getParameter("trueusername");
/* 32:49 */       String sex = req.getParameter("sex");
/* 33:50 */       String idcardnum = req.getParameter("idcardnum");
/* 34:51 */       String phone = req.getParameter("phone");
/* 35:52 */       String companyname = req.getParameter("companyname");
/* 36:53 */       String registeredcapital = req.getParameter("registeredcapital");
/* 37:54 */       String registerdate = req.getParameter("registerdate");
/* 38:55 */       String annualsales = req.getParameter("annualsales");
/* 39:56 */       String borrowamount = req.getParameter("borrowamount");
/* 40:57 */       String loantype = req.getParameter("loantype");
/* 41:58 */       String funduse = req.getParameter("funduse");
/* 42:59 */       String mortgagestatus = req.getParameter("mortgagestatus");
/* 43:60 */       String intangibleassets = req.getParameter("intangibleassets");
/* 44:61 */       Map<String, Object> loanMap = new HashMap();
/* 45:   */       
/* 46:63 */       loanMap.put("Trueusername", trueusername);
/* 47:64 */       loanMap.put("Sex", sex);
/* 48:65 */       loanMap.put("Idcardnum", idcardnum);
/* 49:66 */       loanMap.put("Phone", phone);
/* 50:67 */       loanMap.put("Companyname", companyname);
/* 51:68 */       loanMap.put("Registeredcapital", registeredcapital);
/* 52:69 */       loanMap.put("Registerdate", registerdate);
/* 53:70 */       loanMap.put("Annualsales", annualsales);
/* 54:71 */       loanMap.put("Borrowamount", borrowamount);
/* 55:72 */       loanMap.put("Funduse", funduse);
/* 56:73 */       loanMap.put("Loantype", loantype);
/* 57:74 */       loanMap.put("Username", username);
/* 58:75 */       loanMap.put("Mortgagestatus", mortgagestatus);
/* 59:76 */       loanMap.put("Intangibleassets", intangibleassets);
/* 60:77 */       loanMap.put("Registerstatus", "0");
/* 61:78 */       int data = this.loanService.insertLoaninfo(loanMap);
/* 62:79 */       map.put("data", data + "");
/* 63:80 */       return map;
/* 64:   */     }
/* 65:   */     catch (Exception ex)
/* 66:   */     {
/* 67:83 */       ex.printStackTrace();
/* 68:84 */       map.put("error", ex.getMessage());
/* 69:   */     }
/* 70:85 */     return map;
/* 71:   */   }
/* 72:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Insert_loaninfo

 * JD-Core Version:    0.7.0.1

 */