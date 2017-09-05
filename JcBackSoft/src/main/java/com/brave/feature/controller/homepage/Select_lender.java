/*  1:   */ package com.brave.feature.controller.homepage;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.LoanService;
/*  4:   */ import com.brave.system.util.PageUtil;
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
/* 18:   */ public class Select_lender
/* 19:   */ {
/* 20:33 */   private int pagesize = 10;
/* 21:   */   @Autowired
/* 22:   */   private LoanService loanService;
/* 23:   */   
/* 24:   */   @ResponseBody
/* 25:   */   @RequestMapping(value={"/select_lender"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 26:   */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/* 27:   */   {
/* 28:41 */     Map<String, Object> map = new HashMap();
/* 29:   */     try
/* 30:   */     {
/* 31:44 */       req.setCharacterEncoding("utf-8");
/* 32:45 */       resp.setCharacterEncoding("utf-8");
/* 33:46 */       int pageindex = Integer.parseInt(req.getParameter("pageindex"));
/* 34:47 */       Map<String, Object> loanMap = new HashMap();
/* 35:48 */       loanMap.put("Pageindex", PageUtil.getStartRow(pageindex, this.pagesize));
/* 36:49 */       loanMap.put("Pagesize", Integer.valueOf(this.pagesize));
/* 37:50 */       List<Map<String, Object>> list = this.loanService.selectLenderList(loanMap);
/* 38:51 */       map.put("data", list);
/* 39:52 */       return map;
/* 40:   */     }
/* 41:   */     catch (Exception ex)
/* 42:   */     {
/* 43:55 */       ex.printStackTrace();
/* 44:56 */       map.put("error", ex.getMessage());
/* 45:   */     }
/* 46:57 */     return map;
/* 47:   */   }
/* 48:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Select_lender

 * JD-Core Version:    0.7.0.1

 */