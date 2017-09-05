/*  1:   */ package com.brave.feature.controller.me;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.FirsthandResourcesService;
/*  4:   */ import com.brave.feature.service.UserService;
/*  5:   */ import java.io.PrintStream;
/*  6:   */ import java.util.ArrayList;
/*  7:   */ import java.util.HashMap;
/*  8:   */ import java.util.List;
/*  9:   */ import java.util.Map;
/* 10:   */ import javax.servlet.http.HttpServletRequest;
/* 11:   */ import javax.servlet.http.HttpServletResponse;
/* 12:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 13:   */ import org.springframework.context.annotation.Scope;
/* 14:   */ import org.springframework.stereotype.Controller;
/* 15:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 16:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 17:   */ 
/* 18:   */ @Controller
/* 19:   */ @Scope("prototype")
/* 20:   */ public class Select_batchdata
/* 21:   */ {
/* 22:   */   @Autowired
/* 23:   */   private UserService userService;
/* 24:   */   @Autowired
/* 25:   */   private FirsthandResourcesService service;
/* 26:   */   
/* 27:   */   @ResponseBody
/* 28:   */   @RequestMapping(value={"/select_batchdata"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 29:   */   public Map<String, Object> select_Mydata(HttpServletRequest req, HttpServletResponse resp)
/* 30:   */   {
/* 31:43 */     Map<String, Object> map = new HashMap();
/* 32:   */     try
/* 33:   */     {
/* 34:46 */       req.setCharacterEncoding("utf-8");
/* 35:47 */       resp.setCharacterEncoding("utf-8");
/* 36:48 */       String Hxid = req.getParameter("hxid");
/* 37:   */       
/* 38:   */ 
/* 39:51 */       Hxid = Hxid.replace("[", "").replace("]", "").replace(" ", "").replace("(", "").replace(")", "");
/* 40:52 */       System.out.println("admin:" + Hxid);
/* 41:53 */       if ((Hxid == null) || (Hxid.equals("")))
/* 42:   */       {
/* 43:54 */         map.put("data", "0");
/* 44:   */       }
/* 45:   */       else
/* 46:   */       {
/* 47:58 */         List<Map<String, Object>> list = new ArrayList();
/* 48:59 */         System.out.println("Hxid:" + Hxid);
/* 49:60 */         list = this.userService.selectBatchdataByHxid(Hxid);
/* 50:   */         
/* 51:62 */         String status = "";
/* 52:63 */         String useridentity = "";
/* 53:64 */         for (Map<String, Object> map2 : list)
/* 54:   */         {
/* 55:65 */           String type = "";
/* 56:66 */           status = map2.get("authenticationStatus").toString();
/* 57:67 */           useridentity = map2.get("useridentity").toString();
/* 58:68 */           System.out.println("status:" + status);
/* 59:69 */           if (("1".equals(status)) || ("2".equals(status)))
/* 60:   */           {
/* 61:70 */             List<Map<String, Object>> list3 = this.service.selectAuthenticationTypeByUsername(map2.get("username").toString());
/* 62:71 */             if (list3.size() > 0) {
/* 63:72 */               type = ((Map)list3.get(0)).get("type").toString();
/* 64:   */             }
/* 65:   */           }
/* 66:76 */           if ("有票企业".equals(useridentity)) {
/* 67:77 */             type = "企业";
/* 68:   */           }
/* 69:79 */           map2.put("type", type);
/* 70:80 */           map2.remove("authenticationStatus");
/* 71:81 */           map2.remove("username");
/* 72:82 */           map2.remove("useridentity");
/* 73:   */         }
/* 74:84 */         map.put("data", list);
/* 75:   */       }
/* 76:86 */       return map;
/* 77:   */     }
/* 78:   */     catch (Exception ex)
/* 79:   */     {
/* 80:89 */       ex.printStackTrace();
/* 81:90 */       map.put("error", ex.getMessage());
/* 82:   */     }
/* 83:91 */     return map;
/* 84:   */   }
/* 85:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.me.Select_batchdata

 * JD-Core Version:    0.7.0.1

 */