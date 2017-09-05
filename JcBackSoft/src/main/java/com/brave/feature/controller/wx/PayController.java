/*  1:   */ package com.brave.feature.controller.wx;
/*  2:   */ 
/*  3:   */ import com.brave.feature.app.model.MdlPay;
/*  4:   */ import com.brave.feature.app.service.WXPay;
/*  5:   */ import com.brave.feature.app.service.WXPrepay;
/*  6:   */ import com.brave.feature.util.OrderUtil;
/*  7:   */ import java.io.PrintStream;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import org.slf4j.Logger;
/* 10:   */ import org.slf4j.LoggerFactory;
/* 11:   */ import org.springframework.stereotype.Controller;
/* 12:   */ import org.springframework.ui.Model;
/* 13:   */ import org.springframework.ui.ModelMap;
/* 14:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 15:   */ import org.springframework.web.bind.annotation.SessionAttributes;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ @SessionAttributes({"pay"})
/* 19:   */ public class PayController
/* 20:   */ {
/* 21:20 */   private static final Logger logger = LoggerFactory.getLogger(PayController.class);
/* 22:22 */   String notifyUrl = "http://wxpay.omsapp.cn/notice";
/* 23:   */   
/* 24:   */   @RequestMapping({"/config"})
/* 25:   */   public String config(String appId, String partnerId, String partnerKey, ModelMap model)
/* 26:   */   {
/* 27:37 */     MdlPay pay = new MdlPay();
/* 28:38 */     pay.setAppId(appId);
/* 29:39 */     pay.setPartnerId(partnerId);
/* 30:40 */     pay.setPartnerKey(partnerKey);
/* 31:41 */     logger.info("pay对象初始化：" + pay);
/* 32:42 */     model.addAttribute("pay", pay);
/* 33:43 */     return "forward:wxpay";
/* 34:   */   }
/* 35:   */   
/* 36:   */   @RequestMapping({"/wxpay"})
/* 37:   */   public String pay(HttpServletRequest request, Model model)
/* 38:   */   {
/* 39:54 */     String spbill_create_ip = request.getRemoteAddr();
/* 40:55 */     WXPrepay prePay = new WXPrepay();
/* 41:56 */     prePay.setAppid(request.getParameter("appId"));
/* 42:57 */     prePay.setBody("来自Sunlight的微信支付测试");
/* 43:58 */     prePay.setPartnerKey(request.getParameter("partnerKey"));
/* 44:59 */     prePay.setMch_id(request.getParameter("partnerId"));
/* 45:60 */     prePay.setNotify_url(this.notifyUrl);
/* 46:61 */     prePay.setOut_trade_no(OrderUtil.GetOrderNumber(""));
/* 47:62 */     prePay.setSpbill_create_ip(spbill_create_ip);
/* 48:63 */     prePay.setTotal_fee("1");
/* 49:64 */     prePay.setTrade_type("JSAPI");
/* 50:   */     
/* 51:   */ 
/* 52:67 */     String prepayid = prePay.submitXmlGetPrepayId();
/* 53:68 */     logger.info("获取的预支付订单是：" + prepayid);
/* 54:69 */     if ((prepayid != null) && (prepayid.length() > 10))
/* 55:   */     {
/* 56:71 */       String jsParam = WXPay.createPackageValue(request.getParameter("appId"), request.getParameter("partnerKey"), prepayid);
/* 57:72 */       System.out.println("jsParam=" + jsParam);
/* 58:   */       
/* 59:74 */       model.addAttribute("jsParam", jsParam);
/* 60:75 */       logger.info("生成的微信调起JS参数为：" + jsParam);
/* 61:   */     }
/* 62:77 */     model.addAttribute("prepayid", prepayid);
/* 63:78 */     return "wxpay";
/* 64:   */   }
/* 65:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.wx.PayController

 * JD-Core Version:    0.7.0.1

 */