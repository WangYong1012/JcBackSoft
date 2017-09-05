/*  1:   */ package com.brave.feature.controller.collect;
/*  2:   */ 
/*  3:   */ import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/*  4:   */ import java.io.File;
/*  5:   */ import java.io.FileOutputStream;
/*  6:   */ import java.util.HashMap;
/*  7:   */ import java.util.Map;
/*  8:   */ import javax.servlet.ServletContext;
/*  9:   */ import javax.servlet.http.HttpServletRequest;
/* 10:   */ import javax.servlet.http.HttpServletResponse;
/* 11:   */ import javax.servlet.http.HttpSession;
/* 12:   */ import org.springframework.context.annotation.Scope;
/* 13:   */ import org.springframework.stereotype.Controller;
/* 14:   */ 
/* 15:   */ @Controller
/* 16:   */ @Scope("prototype")
/* 17:   */ public class Photojieshou
/* 18:   */ {
/* 19:   */   public Map<String, Object> photojieshou(HttpServletRequest req, HttpServletResponse resp, String photo, String username)
/* 20:   */   {
/* 21:30 */     Map<String, Object> map = new HashMap();
/* 22:   */     try
/* 23:   */     {
/* 24:33 */       req.setCharacterEncoding("utf-8");
/* 25:34 */       resp.setCharacterEncoding("utf-8");
/* 26:35 */       resp.setContentType("text/html");
/* 27:36 */       String s = "0";
/* 28:   */       
/* 29:38 */       byte[] decode = Base64.decode(photo);
/* 30:   */       
/* 31:   */ 
/* 32:   */ 
/* 33:42 */       File file = new File(req.getSession().getServletContext().getRealPath("/image/" + username + ".jpg"));
/* 34:44 */       if (!file.exists()) {
/* 35:45 */         file.createNewFile();
/* 36:   */       }
/* 37:48 */       FileOutputStream out = new FileOutputStream(file);
/* 38:   */       
/* 39:50 */       out.write(decode);
/* 40:   */       
/* 41:52 */       out.flush();
/* 42:   */       
/* 43:54 */       out.close();
/* 44:56 */       if (file.exists()) {
/* 45:57 */         s = "1";
/* 46:   */       } else {
/* 47:59 */         s = "0";
/* 48:   */       }
/* 49:61 */       map.put("data", s);
/* 50:62 */       return map;
/* 51:   */     }
/* 52:   */     catch (Exception ex)
/* 53:   */     {
/* 54:65 */       ex.printStackTrace();
/* 55:66 */       map.put("error", ex.getMessage());
/* 56:   */     }
/* 57:67 */     return map;
/* 58:   */   }
/* 59:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.collect.Photojieshou

 * JD-Core Version:    0.7.0.1

 */