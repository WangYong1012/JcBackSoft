/*   1:    */ package com.brave.feature.controller.supporter;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.SupporterService;
/*   4:    */ import java.io.PrintStream;
/*   5:    */ import java.text.SimpleDateFormat;
/*   6:    */ import java.util.Date;
/*   7:    */ import java.util.HashMap;
/*   8:    */ import java.util.List;
/*   9:    */ import java.util.Map;
/*  10:    */ import javax.servlet.http.HttpServletRequest;
/*  11:    */ import javax.servlet.http.HttpServletResponse;
/*  12:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  13:    */ import org.springframework.context.annotation.Scope;
/*  14:    */ import org.springframework.stereotype.Controller;
/*  15:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  16:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  17:    */ import org.springframework.web.servlet.ModelAndView;
/*  18:    */ 
/*  19:    */ @Controller
/*  20:    */ @Scope("prototype")
/*  21:    */ public class Insert_supporters
/*  22:    */ {
/*  23:    */   @Autowired
/*  24:    */   private SupporterService supporterService;
/*  25:    */   
/*  26:    */   @ResponseBody
/*  27:    */   @RequestMapping(value={"/insert_supporters"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  28:    */   public ModelAndView insert_supporters(HttpServletRequest req, HttpServletResponse resp)
/*  29:    */   {
/*  30: 40 */     ModelAndView model = new ModelAndView();
/*  31: 41 */     Map<String, Object> map = new HashMap();
/*  32:    */     try
/*  33:    */     {
/*  34: 44 */       req.setCharacterEncoding("utf-8");
/*  35: 45 */       resp.setCharacterEncoding("utf-8");
/*  36: 46 */       String Data = req.getParameter("data");
/*  37: 47 */       System.out.println("Data；" + Data);
/*  38: 48 */       int z = Data.indexOf("fengefu");
/*  39: 49 */       String username = Data.split(",")[7].replaceAll("\\D", "");
/*  40: 50 */       System.out.println("username:" + username);
/*  41: 51 */       List<Map<String, Object>> list = this.supporterService.selectSupportersState(username);
/*  42: 52 */       System.out.println("list.size():" + list.size());
/*  43: 53 */       if (list.size() > 0)
/*  44:    */       {
/*  45: 54 */         map.put("data", "2");
/*  46: 55 */         model.addAllObjects(map);
/*  47: 56 */         return model;
/*  48:    */       }
/*  49: 60 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  50: 61 */       String issuetime = df.format(new Date());
/*  51: 62 */       Map<String, Object> supportersMap = new HashMap();
/*  52: 63 */       StringBuffer stringBuffer = new StringBuffer();
/*  53: 65 */       if (z == -1)
/*  54:    */       {
/*  55: 66 */         String[] supporter = Data.split(",");
/*  56: 67 */         supporter[11] = ("\"" + issuetime + "\"");
/*  57: 68 */         for (int m = 0; m < supporter.length - 1; m++) {
/*  58: 69 */           stringBuffer.append(supporter[m] + ",");
/*  59:    */         }
/*  60: 71 */         stringBuffer.append(supporter[(supporter.length - 1)]);
/*  61: 72 */         supportersMap.put("Data", stringBuffer.toString());
/*  62: 73 */         System.out.println("supportersMap:" + supportersMap);
/*  63: 74 */         int i = this.supporterService.insertSupportersInfo(supportersMap);
/*  64: 75 */         map.put("data", Integer.valueOf(i));
/*  65: 76 */         model.addAllObjects(map);
/*  66:    */       }
/*  67:    */       else
/*  68:    */       {
/*  69: 78 */         String[] strshuzu = Data.split("fengefu");
/*  70: 79 */         int k = 0;
/*  71: 80 */         for (int i = 0; i < strshuzu.length; i++)
/*  72:    */         {
/*  73: 81 */           StringBuffer shuzuBuffer = new StringBuffer();
/*  74: 82 */           Map<String, Object> mapArr = new HashMap();
/*  75: 83 */           String[] supporter = strshuzu[i].split(",");
/*  76: 84 */           supporter[11] = ("\"" + issuetime + "\"");
/*  77: 85 */           for (int m = 0; m < supporter.length - 1; m++) {
/*  78: 86 */             shuzuBuffer.append(supporter[m] + ",");
/*  79:    */           }
/*  80: 88 */           shuzuBuffer.append(supporter[(supporter.length - 1)]);
/*  81: 89 */           mapArr.put("Data", shuzuBuffer.toString());
/*  82: 90 */           int j = this.supporterService.insertSupportersInfo(mapArr);
/*  83: 91 */           if (j > 0)
/*  84:    */           {
/*  85: 92 */             k++;
/*  86: 93 */             if (k == strshuzu.length) {
/*  87: 94 */               map.put("data", "true");
/*  88:    */             } else {
/*  89: 96 */               map.put("data", "false");
/*  90:    */             }
/*  91:    */           }
/*  92:    */         }
/*  93:100 */         model.addAllObjects(map);
/*  94:    */       }
/*  95:102 */       return model;
/*  96:    */     }
/*  97:    */     catch (Exception ex)
/*  98:    */     {
/*  99:105 */       ex.printStackTrace();
/* 100:106 */       map.put("error", ex.getMessage());
/* 101:107 */       model.addAllObjects(map);
/* 102:    */     }
/* 103:108 */     return model;
/* 104:    */   }
/* 105:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.supporter.Insert_supporters

 * JD-Core Version:    0.7.0.1

 */