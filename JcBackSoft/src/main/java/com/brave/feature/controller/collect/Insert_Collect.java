/*  1:   */ package com.brave.feature.controller.collect;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.CollectService;
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
/* 16:   */ public class Insert_Collect
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private CollectService service;
/* 20:   */   
/* 21:   */   @ResponseBody
/* 22:   */   @RequestMapping(value={"/insert_collect"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 23:   */   public Map<String, Object> insert_collect(HttpServletRequest req, HttpServletResponse resp)
/* 24:   */   {
/* 25:37 */     Map<String, Object> map = new HashMap();
/* 26:   */     try
/* 27:   */     {
/* 28:40 */       req.setCharacterEncoding("utf-8");
/* 29:41 */       resp.setCharacterEncoding("utf-8");
/* 30:   */       
/* 31:43 */       String Bankpoce = req.getParameter("Bankpoce");
/* 32:   */       
/* 33:45 */       String Linkman = req.getParameter("Linkman");
/* 34:   */       
/* 35:47 */       String Bank = req.getParameter("Bank");
/* 36:   */       
/* 37:49 */       String PHONE = req.getParameter("PHONE");
/* 38:   */       
/* 39:51 */       String Type = req.getParameter("Type");
/* 40:   */       
/* 41:53 */       String Money = req.getParameter("Money");
/* 42:   */       
/* 43:55 */       String Dudate = req.getParameter("Dudate");
/* 44:   */       
/* 45:57 */       String Endorsement = req.getParameter("Endorsement");
/* 46:   */       
/* 47:59 */       String Remark = req.getParameter("Remark");
/* 48:   */       
/* 49:61 */       String Supportersid = req.getParameter("Supportersid");
/* 50:   */       
/* 51:63 */       String username = req.getParameter("username");
/* 52:   */       
/* 53:65 */       String Issuetime = req.getParameter("issuetime");
/* 54:   */       
/* 55:67 */       String piaonum = req.getParameter("piaonum");
/* 56:   */       
/* 57:69 */       String zhangshu = req.getParameter("zhangshu");
/* 58:   */       
/* 59:71 */       String jingdu = req.getParameter("jingdu");
/* 60:   */       
/* 61:73 */       String weidu = req.getParameter("weidu");
/* 62:74 */       Map<String, Object> CollectMap = new HashMap();
/* 63:75 */       CollectMap.put("Bankpoce", Bankpoce);
/* 64:76 */       CollectMap.put("Bank", Bank);
/* 65:77 */       CollectMap.put("Type", Type);
/* 66:78 */       CollectMap.put("Dudate", Dudate);
/* 67:79 */       CollectMap.put("Linkman", Linkman);
/* 68:80 */       CollectMap.put("PHONE", PHONE);
/* 69:81 */       CollectMap.put("Supportersid", Supportersid);
/* 70:82 */       CollectMap.put("Money", Money);
/* 71:83 */       CollectMap.put("Remark", Remark);
/* 72:84 */       CollectMap.put("Endorsement", Endorsement);
/* 73:85 */       CollectMap.put("Username", username);
/* 74:86 */       CollectMap.put("Issuetime", Issuetime);
/* 75:87 */       CollectMap.put("Piaonum", piaonum);
/* 76:88 */       CollectMap.put("Zhangshu", zhangshu);
/* 77:89 */       CollectMap.put("Jingdu", jingdu);
/* 78:90 */       CollectMap.put("Weidu", weidu);
/* 79:91 */       int i = this.service.insertCollect(CollectMap);
/* 80:92 */       map.put("data", i + "");
/* 81:93 */       return map;
/* 82:   */     }
/* 83:   */     catch (Exception ex)
/* 84:   */     {
/* 85:96 */       ex.printStackTrace();
/* 86:97 */       map.put("error", ex.getMessage());
/* 87:   */     }
/* 88:98 */     return map;
/* 89:   */   }
/* 90:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.collect.Insert_Collect

 * JD-Core Version:    0.7.0.1

 */