/*   1:    */ package com.brave.system.controller;
/*   2:    */ 
/*   3:    */ import com.brave.feature.entity.JcAuthentication;
/*   4:    */ import com.brave.feature.service.AuthenticationService;
/*   5:    */ import com.brave.system.entity.UserInfo;
/*   6:    */ import com.brave.system.entity.UserInfoExample;
/*   7:    */ import com.brave.system.entity.UserInfoExample.Criteria;
/*   8:    */ import com.brave.system.service.IUserInfoService;
/*   9:    */ import java.io.PrintWriter;
/*  10:    */ import java.text.DateFormat;
/*  11:    */ import java.text.SimpleDateFormat;
/*  12:    */ import java.util.Calendar;
/*  13:    */ import java.util.Date;
/*  14:    */ import java.util.HashMap;
/*  15:    */ import java.util.Map;
/*  16:    */ import javax.servlet.http.HttpServletRequest;
/*  17:    */ import javax.servlet.http.HttpServletResponse;
/*  18:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  19:    */ import org.springframework.context.annotation.Scope;
/*  20:    */ import org.springframework.stereotype.Controller;
/*  21:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  22:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  23:    */ 
/*  24:    */ @RequestMapping({"/system/authentication"})
/*  25:    */ @Controller
/*  26:    */ @Scope("prototype")
/*  27:    */ public class AuthenticationController
/*  28:    */ {
/*  29:    */   @Autowired
/*  30:    */   private AuthenticationService authenticationService;
/*  31:    */   @Autowired
/*  32:    */   private IUserInfoService userInfoService;
/*  33:    */   
/*  34:    */   @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  35:    */   public String index(HttpServletRequest request, HttpServletResponse response)
/*  36:    */   {
/*  37: 50 */     return "system/authentication/index";
/*  38:    */   }
/*  39:    */   
/*  40:    */   @RequestMapping(value={"/chechStatus"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  41:    */   public void checkStatus(HttpServletRequest request, HttpServletResponse response)
/*  42:    */   {
/*  43: 56 */     Map<String, Object> resultMap = new HashMap();
/*  44:    */     try
/*  45:    */     {
/*  46: 59 */       request.setCharacterEncoding("UTF-8");
/*  47: 60 */       response.setCharacterEncoding("UTF-8");
/*  48:    */       
/*  49: 62 */       resultMap.put("resultMsg", "已经存在该条信息.");
/*  50: 63 */       resultMap.put("resultCode", "FAIL");
/*  51: 64 */       response.getWriter().print("FAIL");
/*  52:    */     }
/*  53:    */     catch (Exception ex)
/*  54:    */     {
/*  55: 67 */       ex.printStackTrace();
/*  56:    */     }
/*  57:    */   }
/*  58:    */   
/*  59:    */   @ResponseBody
/*  60:    */   @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  61:    */   public void saveAuthentication(String username, String beginDate, String endDate, String region, String type, String payType)
/*  62:    */   {
/*  63:    */     try
/*  64:    */     {
/*  65: 78 */       Calendar calendar = Calendar.getInstance();
/*  66: 79 */       calendar.add(2, 1);
/*  67:    */       
/*  68: 81 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*  69: 82 */       DateFormat format = DateFormat.getDateInstance();
/*  70: 83 */       JcAuthentication jcAuthentication = new JcAuthentication();
/*  71: 84 */       jcAuthentication.setUsername(username);
/*  72: 85 */       Date date = new Date();
/*  73: 86 */       jcAuthentication.setStartdate(format.parse(sdf.format(date)));
/*  74: 87 */       jcAuthentication.setDuedate(calendar.getTime());
/*  75: 88 */       jcAuthentication.setPaytype(payType);
/*  76: 89 */       jcAuthentication.setRegion(region);
/*  77: 90 */       jcAuthentication.setType(type);
/*  78: 91 */       jcAuthentication.setId(null);
/*  79:    */       
/*  80: 93 */       this.authenticationService.insertSelective(jcAuthentication);
/*  81:    */       
/*  82: 95 */       UserInfoExample example = new UserInfoExample();
/*  83: 96 */       UserInfoExample.Criteria criteria = example.createCriteria();
/*  84: 97 */       criteria.andUsernameEqualTo(username);
/*  85:    */       
/*  86: 99 */       UserInfo userInfo = new UserInfo();
/*  87:100 */       userInfo.setAuthenticationstatus("1");
/*  88:    */       
/*  89:102 */       this.userInfoService.updateByExampleSelective(userInfo, example);
/*  90:    */     }
/*  91:    */     catch (Exception ex)
/*  92:    */     {
/*  93:105 */       ex.printStackTrace();
/*  94:    */     }
/*  95:    */   }
/*  96:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.controller.AuthenticationController

 * JD-Core Version:    0.7.0.1

 */