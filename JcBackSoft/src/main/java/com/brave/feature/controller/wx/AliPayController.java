/*   1:    */ package com.brave.feature.controller.wx;
/*   2:    */ 
/*   3:    */ import com.brave.feature.util.AlipayConfig;
/*   4:    */ import com.brave.feature.util.AlipayNotify;
/*   5:    */ import com.brave.feature.util.SignUtils;
/*   6:    */ import java.io.PrintStream;
/*   7:    */ import java.net.URLEncoder;
/*   8:    */ import java.util.Date;
/*   9:    */ import java.util.HashMap;
/*  10:    */ import java.util.Iterator;
/*  11:    */ import java.util.Map;
/*  12:    */ import java.util.Set;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import org.apache.commons.logging.Log;
/*  16:    */ import org.apache.commons.logging.LogFactory;
/*  17:    */ import org.slf4j.Logger;
/*  18:    */ import org.slf4j.LoggerFactory;
/*  19:    */ import org.springframework.stereotype.Controller;
/*  20:    */ import org.springframework.ui.Model;
/*  21:    */ import org.springframework.web.bind.ServletRequestUtils;
/*  22:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  23:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  24:    */ 
/*  25:    */ @Controller
/*  26:    */ @RequestMapping({"/alipay"})
/*  27:    */ public class AliPayController
/*  28:    */ {
/*  29: 36 */   private static final Logger logger = LoggerFactory.getLogger(AliPayController.class);
/*  30: 38 */   String notifyUrl = "http://wxpay.omsapp.cn/notice";
/*  31: 39 */   private static Log log = LogFactory.getLog(AliPayController.class);
/*  32:    */   
/*  33:    */   @RequestMapping({"/index"})
/*  34:    */   public String index(HttpServletRequest request, HttpServletResponse response)
/*  35:    */   {
/*  36: 44 */     return "web/pay/fund";
/*  37:    */   }
/*  38:    */   
/*  39:    */   @ResponseBody
/*  40:    */   @RequestMapping(value={"/deposit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  41:    */   public Map<String, Object> deposit(HttpServletRequest request, HttpServletResponse response, Model model)
/*  42:    */     throws Exception
/*  43:    */   {
/*  44: 51 */     String total_fee = ServletRequestUtils.getStringParameter(request, "amount", "");
/*  45: 52 */     String subject = ServletRequestUtils.getStringParameter(request, "subject", "");
/*  46:    */     
/*  47: 54 */     String body = ServletRequestUtils.getStringParameter(request, "body", "test");
/*  48: 55 */     String orderInfo = getOrderInfo(subject, body, total_fee);
/*  49:    */     
/*  50:    */ 
/*  51:    */ 
/*  52: 59 */     System.out.println("amount:" + total_fee);
/*  53: 60 */     System.out.println("body:" + body);
/*  54: 61 */     String sign = SignUtils.sign(orderInfo, AlipayConfig.rsa_private);
/*  55:    */     try
/*  56:    */     {
/*  57: 64 */       sign = URLEncoder.encode(sign, "UTF-8");
/*  58: 65 */       System.out.println("sign:" + sign);
/*  59:    */     }
/*  60:    */     catch (Exception e)
/*  61:    */     {
/*  62: 67 */       e.printStackTrace();
/*  63:    */     }
/*  64: 71 */     String sHtmlText = orderInfo + "&sign=\"" + sign + "\"" + "&sign_type=" + "\"" + AlipayConfig.sign_type + "\"";
/*  65:    */     
/*  66: 73 */     System.out.println("sHtmlText:" + sHtmlText);
/*  67:    */     try
/*  68:    */     {
/*  69: 81 */       model.addAttribute("sHtmlText", sHtmlText);
/*  70: 82 */       request.setAttribute("sHtmlText", sHtmlText);
/*  71: 83 */       System.out.println("s:" + sHtmlText);
/*  72:    */       
/*  73: 85 */       Map<String, Object> map = new HashMap();
/*  74: 86 */       map.put("status", "success");
/*  75: 87 */       map.put("sHtmlText", sHtmlText);
/*  76: 88 */       return map;
/*  77:    */     }
/*  78:    */     catch (Exception e)
/*  79:    */     {
/*  80: 90 */       if (log.isErrorEnabled()) {
/*  81: 91 */         log.error("ddddddddddddddddddddd");
/*  82:    */       }
/*  83: 94 */       Map<String, Object> map = new HashMap();
/*  84: 95 */       map.put("status", "fail");
/*  85: 96 */       return map;
/*  86:    */     }
/*  87:    */   }
/*  88:    */   
/*  89:    */   @RequestMapping({"/return_url"})
/*  90:    */   public String Return_url(HttpServletRequest request, HttpServletResponse response)
/*  91:    */   {
/*  92:108 */     return "web/pay/success";
/*  93:    */   }
/*  94:    */   
/*  95:    */   @RequestMapping(value={"/async"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  96:    */   public String async(HttpServletRequest request, HttpServletResponse response)
/*  97:    */   {
/*  98:121 */     Map<String, String> params = new HashMap();
/*  99:122 */     Map requestParams = request.getParameterMap();
/* 100:123 */     for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();)
/* 101:    */     {
/* 102:124 */       String name = (String)iter.next();
/* 103:125 */       String[] values = (String[])requestParams.get(name);
/* 104:126 */       String valueStr = "";
/* 105:127 */       for (int i = 0; i < values.length; i++) {
/* 106:128 */         valueStr = valueStr + values[i] + ",";
/* 107:    */       }
/* 108:130 */       params.put(name, valueStr);
/* 109:    */     }
/* 110:132 */     String tradeNo = request.getParameter("out_trade_no");
/* 111:133 */     String tradeStatus = request.getParameter("trade_status");
/* 112:135 */     if (AlipayNotify.verify(params))
/* 113:    */     {
/* 114:136 */       if ((tradeStatus.equals("TRADE_FINISHED")) || (tradeStatus.equals("TRADE_SUCCESS")))
/* 115:    */       {
/* 116:138 */         log.error("ok.......");
/* 117:139 */         System.out.println(">>>>>充值成功" + tradeNo);
/* 118:    */       }
/* 119:141 */       return "web/pay/success";
/* 120:    */     }
/* 121:143 */     return "web/pay/fail";
/* 122:    */   }
/* 123:    */   
/* 124:    */   public String getOrderInfo(String subject, String body, String price)
/* 125:    */   {
/* 126:149 */     String orderInfo = "partner=\"" + AlipayConfig.partner + "\"";
/* 127:    */     
/* 128:    */ 
/* 129:152 */     orderInfo = orderInfo + "&seller_id=\"" + AlipayConfig.seller_email + "\"";
/* 130:153 */     Date date = new Date();
/* 131:    */     
/* 132:    */ 
/* 133:156 */     orderInfo = orderInfo + "&out_trade_no=\"" + date.getTime() + "1" + "\"";
/* 134:    */     
/* 135:    */ 
/* 136:159 */     orderInfo = orderInfo + "&subject=\"" + subject + "\"";
/* 137:    */     
/* 138:161 */     orderInfo = orderInfo + "&show_url=\"m.alipay.com\"";
/* 139:    */     
/* 140:    */ 
/* 141:164 */     orderInfo = orderInfo + "&body=\"" + body + "\"";
/* 142:    */     
/* 143:    */ 
/* 144:167 */     orderInfo = orderInfo + "&total_fee=\"" + price + "\"";
/* 145:    */     
/* 146:    */ 
/* 147:170 */     orderInfo = orderInfo + "&notify_url=\"http://www.shandongjinchi.com/alipay/notify_url.jsp\"";
/* 148:    */     
/* 149:    */ 
/* 150:    */ 
/* 151:174 */     orderInfo = orderInfo + "&service=\"mobile.securitypay.pay\"";
/* 152:    */     
/* 153:    */ 
/* 154:177 */     orderInfo = orderInfo + "&payment_type=\"1\"";
/* 155:    */     
/* 156:    */ 
/* 157:180 */     orderInfo = orderInfo + "&_input_charset=\"utf-8\"";
/* 158:    */     
/* 159:    */ 
/* 160:    */ 
/* 161:    */ 
/* 162:    */ 
/* 163:    */ 
/* 164:187 */     orderInfo = orderInfo + "&it_b_pay=\"30m\"";
/* 165:    */     
/* 166:    */ 
/* 167:    */ 
/* 168:    */ 
/* 169:    */ 
/* 170:193 */     orderInfo = orderInfo + "&return_url=\"http://www.shandongjinchi.com/alipay/notify_url.jsp\"";
/* 171:    */     
/* 172:    */ 
/* 173:    */ 
/* 174:    */ 
/* 175:198 */     return orderInfo;
/* 176:    */   }
/* 177:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.wx.AliPayController

 * JD-Core Version:    0.7.0.1

 */