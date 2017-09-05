/*   1:    */ package com.brave.feature.controller.userinfo;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.ImageService;
/*   4:    */ import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/*   5:    */ import java.io.File;
/*   6:    */ import java.io.FileOutputStream;
/*   7:    */ import java.io.PrintStream;
/*   8:    */ import java.util.Date;
/*   9:    */ import java.util.HashMap;
/*  10:    */ import java.util.Map;
/*  11:    */ import javax.servlet.ServletContext;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import javax.servlet.http.HttpSession;
/*  15:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  16:    */ import org.springframework.context.annotation.Scope;
/*  17:    */ import org.springframework.stereotype.Controller;
/*  18:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  19:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  20:    */ import org.springframework.web.servlet.ModelAndView;
/*  21:    */ 
/*  22:    */ @Controller
/*  23:    */ @Scope("prototype")
/*  24:    */ public class Update_head_image
/*  25:    */ {
/*  26:    */   @Autowired
/*  27:    */   private ImageService imageService;
/*  28:    */   
/*  29:    */   @ResponseBody
/*  30:    */   @RequestMapping(value={"/ReceiveHeadImage"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  31:    */   public ModelAndView photojieshou(HttpServletRequest req, HttpServletResponse resp)
/*  32:    */   {
/*  33: 40 */     ModelAndView modelView = new ModelAndView();
/*  34: 41 */     Map<String, Object> map = new HashMap();
/*  35:    */     try
/*  36:    */     {
/*  37: 44 */       req.setCharacterEncoding("utf-8");
/*  38: 45 */       resp.setCharacterEncoding("utf-8");
/*  39: 46 */       resp.setContentType("text/html");
/*  40: 47 */       String photo = req.getParameter("photo");
/*  41: 48 */       String username = req.getParameter("username");
/*  42: 49 */       String Photourl = "";
/*  43: 50 */       String state = null;
/*  44: 51 */       Date date = new Date();
/*  45: 52 */       String url = date.getTime() + "";
/*  46: 53 */       String name = "";
/*  47:    */       
/*  48: 55 */       byte[] decode = Base64.decode(photo);
/*  49:    */       
/*  50:    */ 
/*  51:    */ 
/*  52:    */ 
/*  53: 60 */       name = "/image/" + url + username + ".jpg";
/*  54:    */       
/*  55: 62 */       File file = new File(req.getSession().getServletContext().getRealPath(name));
/*  56:    */       
/*  57:    */ 
/*  58:    */ 
/*  59: 66 */       File file1 = new File(req.getSession().getServletContext().getRealPath("/image/" + username + ".jpg"));
/*  60: 67 */       System.out.println("路径4：" + req.getRequestURL());
/*  61: 68 */       System.out.println("lujing1:" + req.getServletPath());
/*  62: 69 */       System.out.println("lujing2:" + req.getSession().getServletContext()
/*  63: 70 */         .getRealPath("/"));
/*  64: 72 */       if (!file.exists()) {
/*  65: 73 */         file.createNewFile();
/*  66:    */       }
/*  67: 75 */       if (!file1.exists())
/*  68:    */       {
/*  69: 76 */         file1.createNewFile();
/*  70:    */       }
/*  71:    */       else
/*  72:    */       {
/*  73: 78 */         file1.delete();
/*  74: 79 */         file1.createNewFile();
/*  75:    */       }
/*  76: 82 */       FileOutputStream outer = new FileOutputStream(file);
/*  77: 84 */       if (decode != null) {
/*  78: 85 */         outer.write(decode);
/*  79:    */       }
/*  80: 87 */       outer = new FileOutputStream(file1);
/*  81: 89 */       if (decode != null) {
/*  82: 90 */         outer.write(decode);
/*  83:    */       }
/*  84: 93 */       outer.flush();
/*  85:    */       
/*  86: 95 */       outer.close();
/*  87: 97 */       if (file.exists())
/*  88:    */       {
/*  89: 98 */         Photourl = url + username + ".jpg";
/*  90: 99 */         state = "1";
/*  91:    */       }
/*  92:    */       else
/*  93:    */       {
/*  94:101 */         state = "0";
/*  95:    */       }
/*  96:103 */       if ("1".equals(state))
/*  97:    */       {
/*  98:104 */         Map<String, Object> userMap = new HashMap();
/*  99:105 */         userMap.put("Username", username);
/* 100:106 */         userMap.put("Photourl", Photourl);
/* 101:    */         
/* 102:108 */         this.imageService.updateUserinfoImage(userMap);
/* 103:    */       }
/* 104:111 */       map.put("data", state + "");
/* 105:112 */       map.put("photourl", Photourl);
/* 106:113 */       return modelView.addAllObjects(map);
/* 107:    */     }
/* 108:    */     catch (Exception ex)
/* 109:    */     {
/* 110:116 */       map.put("data", "0");
/* 111:117 */       map.put("error", ex.getMessage());
/* 112:    */     }
/* 113:118 */     return modelView.addAllObjects(map);
/* 114:    */   }
/* 115:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Update_head_image

 * JD-Core Version:    0.7.0.1

 */