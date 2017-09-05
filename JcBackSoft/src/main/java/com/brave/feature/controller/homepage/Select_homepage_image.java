/*  1:   */ package com.brave.feature.controller.homepage;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.FirsthandResourcesService;
/*  4:   */ import java.io.File;
/*  5:   */ import java.io.PrintStream;
/*  6:   */ import java.util.HashMap;
/*  7:   */ import java.util.Map;
/*  8:   */ import javax.servlet.ServletContext;
/*  9:   */ import javax.servlet.http.HttpServletRequest;
/* 10:   */ import javax.servlet.http.HttpServletResponse;
/* 11:   */ import javax.servlet.http.HttpSession;
/* 12:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 13:   */ import org.springframework.context.annotation.Scope;
/* 14:   */ import org.springframework.stereotype.Controller;
/* 15:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 16:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 17:   */ 
/* 18:   */ @Controller
/* 19:   */ @Scope("prototype")
/* 20:   */ public class Select_homepage_image
/* 21:   */ {
/* 22:   */   @Autowired
/* 23:   */   private FirsthandResourcesService service;
/* 24:   */   
/* 25:   */   @ResponseBody
/* 26:   */   @RequestMapping(value={"/select_homepage_image"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 27:   */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/* 28:   */   {
/* 29:46 */     Map<String, Object> map = new HashMap();
/* 30:   */     try
/* 31:   */     {
/* 32:49 */       req.setCharacterEncoding("utf-8");
/* 33:50 */       resp.setCharacterEncoding("utf-8");
/* 34:   */       
/* 35:52 */       String path = req.getSession().getServletContext().getRealPath("/homeimage/");
/* 36:53 */       System.out.println("path:" + path);
/* 37:54 */       File file = new File(path);
/* 38:55 */       String imageURL = null;
/* 39:56 */       if (file.isDirectory())
/* 40:   */       {
/* 41:57 */         File[] files = file.listFiles();
/* 42:58 */         imageURL = path + files[0].getName();
/* 43:   */       }
/* 44:   */       else
/* 45:   */       {
/* 46:60 */         return null;
/* 47:   */       }
/* 48:62 */       map.put("imageURL", imageURL);
/* 49:63 */       return map;
/* 50:   */     }
/* 51:   */     catch (Exception ex)
/* 52:   */     {
/* 53:66 */       ex.printStackTrace();
/* 54:67 */       map.put("error", ex.getMessage());
/* 55:   */     }
/* 56:68 */     return map;
/* 57:   */   }
/* 58:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Select_homepage_image

 * JD-Core Version:    0.7.0.1

 */