/*   1:    */ package com.brave.feature.controller.huanxin;
/*   2:    */ 
/*   3:    */ import java.io.ByteArrayOutputStream;
/*   4:    */ import java.io.InputStream;
/*   5:    */ import java.net.URLDecoder;
/*   6:    */ import java.net.URLEncoder;
/*   7:    */ import org.apache.commons.httpclient.HttpClient;
/*   8:    */ import org.apache.commons.httpclient.NameValuePair;
/*   9:    */ import org.apache.commons.httpclient.URI;
/*  10:    */ import org.apache.commons.httpclient.methods.GetMethod;
/*  11:    */ 
/*  12:    */ public class HttpSender
/*  13:    */ {
/*  14:    */   public static String send(String mobile, String msg)
/*  15:    */     throws Exception
/*  16:    */   {
/*  17: 24 */     HttpClient client = new HttpClient();
/*  18: 25 */     GetMethod method = new GetMethod();
/*  19: 26 */     String url = "http://222.73.117.169/msg/main.do";
/*  20: 27 */     String account = "jinchijr";
/*  21: 28 */     String pswd = "Jinchi1688";
/*  22: 29 */     boolean needstatus = true;
/*  23: 30 */     String product = null;
/*  24: 31 */     String extno = null;
/*  25:    */     try
/*  26:    */     {
/*  27: 33 */       URI base = new URI(url, false);
/*  28: 34 */       method.setURI(new URI(base, "HttpSendSM", false));
/*  29: 35 */       method.setQueryString(new NameValuePair[] { new NameValuePair("account", account), new NameValuePair("pswd", pswd), new NameValuePair("mobile", mobile), new NameValuePair("needstatus", 
/*  30:    */       
/*  31:    */ 
/*  32:    */ 
/*  33: 39 */         String.valueOf(needstatus)), new NameValuePair("msg", msg), new NameValuePair("product", product), new NameValuePair("extno", extno) });
/*  34:    */       
/*  35:    */ 
/*  36:    */ 
/*  37:    */ 
/*  38: 44 */       int result = client.executeMethod(method);
/*  39: 45 */       if (result == 200)
/*  40:    */       {
/*  41: 46 */         InputStream in = method.getResponseBodyAsStream();
/*  42: 47 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*  43: 48 */         byte[] buffer = new byte[1024];
/*  44: 49 */         int len = 0;
/*  45: 50 */         while ((len = in.read(buffer)) != -1) {
/*  46: 51 */           baos.write(buffer, 0, len);
/*  47:    */         }
/*  48: 53 */         return URLDecoder.decode(baos.toString(), "UTF-8");
/*  49:    */       }
/*  50: 55 */       throw new Exception("HTTP ERROR Status: " + method.getStatusCode() + ":" + method.getStatusText());
/*  51:    */     }
/*  52:    */     finally
/*  53:    */     {
/*  54: 58 */       method.releaseConnection();
/*  55:    */     }
/*  56:    */   }
/*  57:    */   
/*  58:    */   public static String batchSend(String mobile, String msg)
/*  59:    */     throws Exception
/*  60:    */   {
/*  61: 65 */     HttpClient client = new HttpClient();
/*  62: 66 */     GetMethod method = new GetMethod();
/*  63: 67 */     String url = "http://222.73.117.169/msg/main.do";
/*  64: 68 */     String account = "jinchijr";
/*  65: 69 */     String pswd = "Jinchi1688";
/*  66: 70 */     boolean needstatus = true;
/*  67: 71 */     String product = null;
/*  68: 72 */     String extno = null;
/*  69:    */     try
/*  70:    */     {
/*  71: 74 */       URI base = new URI(url, false);
/*  72: 75 */       method.setURI(new URI(base, "HttpBatchSendSM", false));
/*  73: 76 */       method.setQueryString(new NameValuePair[] { new NameValuePair("account", account), new NameValuePair("pswd", pswd), new NameValuePair("mobile", mobile), new NameValuePair("needstatus", 
/*  74:    */       
/*  75:    */ 
/*  76:    */ 
/*  77: 80 */         String.valueOf(needstatus)), new NameValuePair("msg", msg), new NameValuePair("product", product), new NameValuePair("extno", extno) });
/*  78:    */       
/*  79:    */ 
/*  80:    */ 
/*  81:    */ 
/*  82: 85 */       int result = client.executeMethod(method);
/*  83: 86 */       if (result == 200)
/*  84:    */       {
/*  85: 87 */         InputStream in = method.getResponseBodyAsStream();
/*  86: 88 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*  87: 89 */         byte[] buffer = new byte[1024];
/*  88: 90 */         int len = 0;
/*  89: 91 */         while ((len = in.read(buffer)) != -1) {
/*  90: 92 */           baos.write(buffer, 0, len);
/*  91:    */         }
/*  92: 94 */         return URLDecoder.decode(baos.toString(), "UTF-8");
/*  93:    */       }
/*  94: 96 */       throw new Exception("HTTP ERROR Status: " + method.getStatusCode() + ":" + method.getStatusText());
/*  95:    */     }
/*  96:    */     finally
/*  97:    */     {
/*  98: 99 */       method.releaseConnection();
/*  99:    */     }
/* 100:    */   }
/* 101:    */   
/* 102:    */   public static String sendcode(String mobile, String msg)
/* 103:    */     throws Exception
/* 104:    */   {
/* 105:106 */     HttpClient client = new HttpClient();
/* 106:107 */     GetMethod method = new GetMethod();
/* 107:108 */     String url = "http://web.duanxinwang.cc/asmx/smsservice.aspx";
/* 108:109 */     String account = "Shandongjinchi";
/* 109:110 */     String pswd = "6CBDADCDA70DF8021C5DAA21AEC3";
/* 110:111 */     String sign = "【金池金融汇】";
/* 111:112 */     sign = URLEncoder.encode(sign, "UTF-8");
/* 112:    */     try
/* 113:    */     {
/* 114:114 */       URI base = new URI(url, false);
/* 115:115 */       method.setURI(new URI(base, "HttpBatchSendSM", false));
/* 116:116 */       method.setQueryString(new NameValuePair[] { new NameValuePair("name", account), new NameValuePair("pwd", pswd), new NameValuePair("type", "pt"), new NameValuePair("mobile", mobile), new NameValuePair("content", msg), new NameValuePair("sign", sign) });
/* 117:    */       
/* 118:    */ 
/* 119:    */ 
/* 120:    */ 
/* 121:    */ 
/* 122:    */ 
/* 123:    */ 
/* 124:124 */       int result = client.executeMethod(method);
/* 125:125 */       if (result == 200)
/* 126:    */       {
/* 127:126 */         InputStream in = method.getResponseBodyAsStream();
/* 128:127 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 129:128 */         byte[] buffer = new byte[1024];
/* 130:129 */         int len = 0;
/* 131:130 */         while ((len = in.read(buffer)) != -1) {
/* 132:131 */           baos.write(buffer, 0, len);
/* 133:    */         }
/* 134:133 */         return URLDecoder.decode(baos.toString(), "UTF-8");
/* 135:    */       }
/* 136:135 */       throw new Exception("HTTP ERROR Status: " + method.getStatusCode() + ":" + method.getStatusText());
/* 137:    */     }
/* 138:    */     finally
/* 139:    */     {
/* 140:138 */       method.releaseConnection();
/* 141:    */     }
/* 142:    */   }
/* 143:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.huanxin.HttpSender

 * JD-Core Version:    0.7.0.1

 */