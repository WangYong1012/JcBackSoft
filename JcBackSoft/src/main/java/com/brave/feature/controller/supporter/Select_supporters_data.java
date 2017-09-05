/*   1:    */ package com.brave.feature.controller.supporter;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.SupporterService;
/*   4:    */ import java.io.IOException;
/*   5:    */ import java.io.PrintStream;
/*   6:    */ import java.io.PrintWriter;
/*   7:    */ import java.io.UnsupportedEncodingException;
/*   8:    */ import java.util.HashMap;
/*   9:    */ import java.util.List;
/*  10:    */ import java.util.Map;
/*  11:    */ import javax.servlet.http.HttpServletRequest;
/*  12:    */ import javax.servlet.http.HttpServletResponse;
/*  13:    */ import net.sf.json.JSONObject;
/*  14:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  15:    */ import org.springframework.context.annotation.Scope;
/*  16:    */ import org.springframework.stereotype.Controller;
/*  17:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  18:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  19:    */ 
/*  20:    */ @Controller
/*  21:    */ @Scope("prototype")
/*  22:    */ public class Select_supporters_data
/*  23:    */ {
/*  24:    */   @Autowired
/*  25:    */   private SupporterService supporterService;
/*  26:    */   
/*  27:    */   @ResponseBody
/*  28:    */   @RequestMapping(value={"/select_supporters_data"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  29:    */   public Map<String, Object> select_supporters(HttpServletRequest req, HttpServletResponse resp)
/*  30:    */   {
/*  31: 42 */     Map<String, Object> map = new HashMap();
/*  32:    */     try
/*  33:    */     {
/*  34: 45 */       req.setCharacterEncoding("utf-8");
/*  35: 46 */       resp.setCharacterEncoding("utf-8");
/*  36: 47 */       List<Map<String, Object>> list = this.supporterService.selectSupportersData();
/*  37: 48 */       map.put("data", list);
/*  38: 49 */       return map;
/*  39:    */     }
/*  40:    */     catch (Exception ex)
/*  41:    */     {
/*  42: 52 */       ex.printStackTrace();
/*  43: 53 */       map.put("error", ex.getMessage());
/*  44:    */     }
/*  45: 54 */     return map;
/*  46:    */   }
/*  47:    */   
/*  48:    */   @ResponseBody
/*  49:    */   @RequestMapping(value={"/select_supporters_jsondata"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  50:    */   public void select_supporters_jsondata(HttpServletRequest req, HttpServletResponse resp)
/*  51:    */     throws UnsupportedEncodingException
/*  52:    */   {
/*  53: 62 */     req.setCharacterEncoding("utf-8");
/*  54: 63 */     resp.setCharacterEncoding("utf-8");
/*  55: 64 */     List<Map<String, Object>> list = this.supporterService.selectSupportersData();
/*  56: 65 */     JSONObject json = new JSONObject();
/*  57: 66 */     if ((null != list) && (0 < list.size()))
/*  58:    */     {
/*  59: 68 */       json.accumulate("total", list.size());
/*  60: 69 */       json.accumulate("rows", list);
/*  61:    */       
/*  62: 71 */       System.out.println("Json.toString():\n" + json);
/*  63:    */       try
/*  64:    */       {
/*  65: 73 */         resp.getWriter().print(json);
/*  66:    */       }
/*  67:    */       catch (IOException e)
/*  68:    */       {
/*  69: 77 */         e.printStackTrace();
/*  70:    */       }
/*  71:    */     }
/*  72:    */   }
/*  73:    */   
/*  74:    */   @RequestMapping(value={"/select_supporters_jsondata"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  75:    */   public void select_supporters_jsondata_get(HttpServletRequest req, HttpServletResponse resp)
/*  76:    */     throws UnsupportedEncodingException
/*  77:    */   {
/*  78: 87 */     req.setCharacterEncoding("utf-8");
/*  79: 88 */     resp.setCharacterEncoding("utf-8");
/*  80: 89 */     List<Map<String, Object>> list = this.supporterService.selectSupportersData();
/*  81: 90 */     JSONObject json = new JSONObject();
/*  82: 91 */     if ((null != list) && (0 < list.size()))
/*  83:    */     {
/*  84: 93 */       json.accumulate("total", list.size());
/*  85: 94 */       json.accumulate("rows", list);
/*  86: 95 */       System.out.println("Json.toString():\n" + json.toString());
/*  87:    */       try
/*  88:    */       {
/*  89: 97 */         resp.getWriter().print(json.toString());
/*  90:    */       }
/*  91:    */       catch (IOException e)
/*  92:    */       {
/*  93:101 */         e.printStackTrace();
/*  94:    */       }
/*  95:    */     }
/*  96:    */   }
/*  97:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.supporter.Select_supporters_data

 * JD-Core Version:    0.7.0.1

 */