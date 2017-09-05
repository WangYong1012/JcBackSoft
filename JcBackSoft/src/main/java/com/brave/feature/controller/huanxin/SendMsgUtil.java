/*   1:    */ package com.brave.feature.controller.huanxin;
/*   2:    */ 
/*   3:    */ import java.io.InputStream;
/*   4:    */ import java.io.PrintStream;
/*   5:    */ import java.net.HttpURLConnection;
/*   6:    */ import java.net.URL;
/*   7:    */ import java.net.URLEncoder;
/*   8:    */ import java.util.HashMap;
/*   9:    */ import java.util.Map;
/*  10:    */ import javax.servlet.http.HttpServletRequest;
/*  11:    */ import javax.servlet.http.HttpServletResponse;
/*  12:    */ import org.springframework.context.annotation.Scope;
/*  13:    */ import org.springframework.stereotype.Controller;
/*  14:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  15:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  16:    */ import org.springframework.web.servlet.ModelAndView;
/*  17:    */ 
/*  18:    */ @Controller
/*  19:    */ @Scope("prototype")
/*  20:    */ public class SendMsgUtil
/*  21:    */ {
/*  22:    */   @ResponseBody
/*  23:    */   @RequestMapping(value={"/send_identify_code"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  24:    */   public ModelAndView sendMsg(HttpServletRequest request, HttpServletResponse response)
/*  25:    */   {
/*  26: 36 */     ModelAndView model = new ModelAndView();
/*  27: 37 */     Map<String, Object> map = new HashMap();
/*  28:    */     try
/*  29:    */     {
/*  30: 40 */       request.setCharacterEncoding("UTF-8");
/*  31: 41 */       response.setCharacterEncoding("UTF-8");
/*  32:    */       
/*  33: 43 */       String phone = request.getParameter("phone");
/*  34: 44 */       String code = createRandomVcode();
/*  35:    */       
/*  36: 46 */       StringBuffer content = new StringBuffer("【金池金融汇】短信验证码为：");
/*  37: 47 */       content.append(code);
/*  38: 48 */       content.append(".请勿将验证码提供给他人");
/*  39: 49 */       StringBuffer sb = new StringBuffer("http://web.duanxinwang.cc/asmx/smsservice.aspx?");
/*  40: 50 */       sb.append("name=Shandongjinchi");
/*  41: 51 */       sb.append("&pwd=6CBDADCDA70DF8021C5DAA21AEC3");
/*  42: 52 */       sb.append("&mobile=").append(phone.toString().trim());
/*  43: 53 */       sb.append("&content=" + URLEncoder.encode(content.toString(), "UTF-8"));
/*  44: 54 */       sb.append("&stime=");
/*  45: 55 */       sb.append("&sign=");
/*  46: 56 */       sb.append("&type=pt&extno=");
/*  47:    */       
/*  48:    */ 
/*  49: 59 */       URL url = new URL(sb.toString());
/*  50: 60 */       HttpURLConnection connection = (HttpURLConnection)url.openConnection();
/*  51: 61 */       connection.setRequestMethod("POST");
/*  52: 62 */       InputStream is = url.openStream();
/*  53: 63 */       String returnStr = convertStreamToString(is);
/*  54: 64 */       System.out.println(returnStr);
/*  55: 65 */       String[] arrStr = returnStr.split(",");
/*  56: 66 */       String result = arrStr[(arrStr.length - 1)];
/*  57: 67 */       if (result.equals("提交成功"))
/*  58:    */       {
/*  59: 68 */         map.put("data", "1");
/*  60: 69 */         map.put("code", code);
/*  61:    */       }
/*  62:    */       else
/*  63:    */       {
/*  64: 71 */         map.put("data", "0");
/*  65:    */       }
/*  66: 74 */       model.addAllObjects(map);
/*  67: 75 */       return model;
/*  68:    */     }
/*  69:    */     catch (Exception ex)
/*  70:    */     {
/*  71: 78 */       ex.printStackTrace();
/*  72: 79 */       map.put("error", ex.getMessage());
/*  73: 80 */       model.addAllObjects(map);
/*  74:    */     }
/*  75: 81 */     return model;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public static String createRandomVcode()
/*  79:    */   {
/*  80: 87 */     String vcode = "";
/*  81: 88 */     for (int i = 0; i < 6; i++) {
/*  82: 89 */       vcode = vcode + (int)(Math.random() * 9.0D);
/*  83:    */     }
/*  84: 91 */     return vcode;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public static String convertStreamToString(InputStream is)
/*  88:    */   {
/*  89: 96 */     StringBuilder sb1 = new StringBuilder();
/*  90:    */     try
/*  91:    */     {
/*  92: 99 */       byte[] bytes = new byte[4096];
/*  93:100 */       int size = 0;
/*  94:101 */       while ((size = is.read(bytes)) > 0)
/*  95:    */       {
/*  96:102 */         String str = new String(bytes, 0, size, "UTF-8");
/*  97:103 */         sb1.append(str);
/*  98:    */       }
/*  99:    */     }
/* 100:    */     catch (Exception ex)
/* 101:    */     {
/* 102:107 */       ex.printStackTrace();
/* 103:    */     }
/* 104:109 */     return sb1.toString();
/* 105:    */   }
/* 106:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.huanxin.SendMsgUtil

 * JD-Core Version:    0.7.0.1

 */