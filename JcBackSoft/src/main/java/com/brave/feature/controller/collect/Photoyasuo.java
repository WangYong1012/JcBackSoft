/*   1:    */ package com.brave.feature.controller.collect;
/*   2:    */ 
/*   3:    */ import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/*   4:    */ import java.awt.Graphics;
/*   5:    */ import java.awt.Image;
/*   6:    */ import java.awt.image.BufferedImage;
/*   7:    */ import java.io.File;
/*   8:    */ import java.io.FileOutputStream;
/*   9:    */ import java.io.IOException;
/*  10:    */ import java.io.PrintStream;
/*  11:    */ import java.util.HashMap;
/*  12:    */ import java.util.Map;
/*  13:    */ import javax.imageio.ImageIO;
/*  14:    */ import javax.servlet.ServletContext;
/*  15:    */ import javax.servlet.http.HttpServletRequest;
/*  16:    */ import javax.servlet.http.HttpServletResponse;
/*  17:    */ import javax.servlet.http.HttpSession;
/*  18:    */ 
/*  19:    */ public class Photoyasuo
/*  20:    */ {
/*  21: 22 */   private int outputWidth = 500;
/*  22: 23 */   private int outputHeight = 500;
/*  23:    */   
/*  24:    */   public Map<String, Object> photojieshou(HttpServletRequest req, HttpServletResponse resp)
/*  25:    */   {
/*  26: 28 */     Map<String, Object> map = new HashMap();
/*  27:    */     try
/*  28:    */     {
/*  29: 31 */       req.setCharacterEncoding("utf-8");
/*  30: 32 */       resp.setCharacterEncoding("utf-8");
/*  31: 33 */       resp.setContentType("text/html");
/*  32: 34 */       String photo = req.getParameter("photo");
/*  33: 35 */       String username = req.getParameter("username");
/*  34: 36 */       System.out.println(photo);
/*  35: 37 */       System.out.println(username);
/*  36: 38 */       String s = "0";
/*  37: 39 */       String x = "0";
/*  38:    */       
/*  39: 41 */       byte[] decode = Base64.decode(photo);
/*  40:    */       
/*  41: 43 */       File file = new File(req.getSession().getServletContext().getRealPath("/image/" + username + ".jpg"));
/*  42: 44 */       if (!file.exists()) {
/*  43: 45 */         file.createNewFile();
/*  44:    */       }
/*  45: 48 */       FileOutputStream out = new FileOutputStream(file);
/*  46:    */       
/*  47: 50 */       out.write(decode);
/*  48:    */       
/*  49: 52 */       out.flush();
/*  50:    */       
/*  51: 54 */       out.close();
/*  52: 56 */       if (file.exists())
/*  53:    */       {
/*  54: 57 */         s = "1";
/*  55:    */         
/*  56: 59 */         String uploadPath = req.getSession().getServletContext().getRealPath("/image/" + username + ".jpg");
/*  57:    */         
/*  58: 61 */         String filePath = req.getSession().getServletContext().getRealPath("/reduceimage/" + username + ".jpg");
/*  59: 62 */         boolean b = reduce(uploadPath, filePath);
/*  60: 63 */         if (b == true) {
/*  61: 64 */           x = "1";
/*  62:    */         } else {
/*  63: 67 */           x = "0";
/*  64:    */         }
/*  65: 69 */         map.put("reduce", x);
/*  66:    */       }
/*  67:    */       else
/*  68:    */       {
/*  69: 71 */         s = "0";
/*  70:    */       }
/*  71: 73 */       map.put("data", s);
/*  72: 74 */       return map;
/*  73:    */     }
/*  74:    */     catch (Exception ex)
/*  75:    */     {
/*  76: 77 */       ex.printStackTrace();
/*  77: 78 */       map.put("error", ex.getMessage());
/*  78:    */     }
/*  79: 79 */     return map;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public boolean reduce(String uploadPath, String filePath)
/*  83:    */   {
/*  84: 93 */     String filePath_new = uploadPath;
/*  85: 94 */     File f = new File(filePath_new);
/*  86: 95 */     File newfile = new File(filePath);
/*  87: 96 */     FileOutputStream out = null;
/*  88: 97 */     boolean flag = true;
/*  89:    */     try
/*  90:    */     {
/*  91: 99 */       Image img = ImageIO.read(f);
/*  92:    */       
/*  93:101 */       double rate1 = img.getWidth(null) / this.outputWidth + 0.1D;
/*  94:    */       
/*  95:103 */       double rate2 = img.getHeight(null) / this.outputHeight + 0.1D;
/*  96:    */       
/*  97:    */ 
/*  98:106 */       double rate = rate1 > rate2 ? rate1 : rate2;
/*  99:107 */       int newwidth = (int)(img.getWidth(null) / rate);
/* 100:108 */       int newheigh = (int)(img.getHeight(null) / rate);
/* 101:109 */       BufferedImage tag = new BufferedImage(newwidth, newheigh, 1);
/* 102:    */       
/* 103:111 */       tag.getGraphics().drawImage(img
/* 104:112 */         .getScaledInstance(newwidth, newheigh, 4), 0, 0, null);
/* 105:114 */       if (!newfile.exists()) {
/* 106:115 */         newfile.createNewFile();
/* 107:    */       }
/* 108:117 */       out = new FileOutputStream(newfile);
/* 109:118 */       String formatName = filePath_new.substring(filePath_new.lastIndexOf(".") + 1);
/* 110:119 */       BufferedImage save_image = new BufferedImage(newwidth, newheigh, 1);
/* 111:120 */       ImageIO.write(save_image, formatName, new File(filePath));
/* 112:122 */       if (!newfile.exists()) {
/* 113:123 */         flag = false;
/* 114:    */       }
/* 115:129 */       if (out != null) {
/* 116:    */         try
/* 117:    */         {
/* 118:131 */           out.close();
/* 119:    */         }
/* 120:    */         catch (IOException e)
/* 121:    */         {
/* 122:134 */           e.printStackTrace();
/* 123:    */         }
/* 124:    */       }
/* 125:138 */       f = new File(filePath_new);
/* 126:    */     }
/* 127:    */     catch (IOException e)
/* 128:    */     {
/* 129:127 */       e.printStackTrace();
/* 130:    */     }
/* 131:    */     finally
/* 132:    */     {
/* 133:129 */       if (out != null) {
/* 134:    */         try
/* 135:    */         {
/* 136:131 */           out.close();
/* 137:    */         }
/* 138:    */         catch (IOException e)
/* 139:    */         {
/* 140:134 */           e.printStackTrace();
/* 141:    */         }
/* 142:    */       }
/* 143:    */     }
/* 144:139 */     return flag;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public static void main(String[] args)
/* 148:    */   {
/* 149:145 */     HttpServletRequest req = null;
/* 150:    */     
/* 151:147 */     String fileth = req.getSession().getServletContext().getRealPath("/image/a/21.jpg");
/* 152:148 */     System.out.println(fileth);
/* 153:149 */     File newfile = new File(fileth);
/* 154:150 */     if (!newfile.isDirectory()) {
/* 155:151 */       newfile.mkdirs();
/* 156:    */     }
/* 157:    */   }
/* 158:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.collect.Photoyasuo

 * JD-Core Version:    0.7.0.1

 */