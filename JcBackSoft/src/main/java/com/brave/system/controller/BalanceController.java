/*   1:    */ package com.brave.system.controller;
/*   2:    */ 
/*   3:    */ import com.brave.feature.entity.JcUserBalance;
/*   4:    */ import com.brave.feature.entity.JcUserBalanceExample;
/*   5:    */ import com.brave.feature.entity.JcUserBalanceExample.Criteria;
/*   6:    */ import com.brave.feature.service.UserBalanceService;
/*   7:    */ import com.brave.system.util.PageUtils;
/*   8:    */ import java.util.Date;
/*   9:    */ import java.util.HashMap;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.Map;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  15:    */ import org.springframework.context.annotation.Scope;
/*  16:    */ import org.springframework.stereotype.Controller;
/*  17:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  18:    */ 
/*  19:    */ @Controller
/*  20:    */ @Scope("prototype")
/*  21:    */ @RequestMapping({"/system/balance"})
/*  22:    */ public class BalanceController
/*  23:    */ {
/*  24: 35 */   private static int PageRecorders = 10;
/*  25:    */   @Autowired
/*  26:    */   private UserBalanceService userBalanceService;
/*  27:    */   
/*  28:    */   @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  29:    */   public String index(HttpServletRequest request, HttpServletResponse response)
/*  30:    */   {
/*  31: 50 */     return "system/balance/index";
/*  32:    */   }
/*  33:    */   
/*  34:    */   @RequestMapping(value={"/loadContent"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  35:    */   public Map<String, Object> loadContent(HttpServletRequest request, HttpServletResponse response, String mobileName, int pages)
/*  36:    */   {
/*  37: 57 */     response.setCharacterEncoding("UTF-8");
/*  38: 58 */     Map<String, Object> map = new HashMap();
/*  39:    */     try
/*  40:    */     {
/*  41: 62 */       if (0 == pages) {
/*  42: 64 */         pages = 1;
/*  43:    */       }
/*  44: 66 */       JcUserBalanceExample example = new JcUserBalanceExample();
/*  45: 67 */       JcUserBalanceExample.Criteria criteria = example.createCriteria();
/*  46: 69 */       if ((null != mobileName) && (!"".equals(mobileName))) {
/*  47: 71 */         criteria.andUsernameLike("%" + mobileName + "%");
/*  48:    */       }
/*  49: 74 */       long listSize = 0L;
/*  50: 75 */       List<JcUserBalance> jcUserBalanceList = this.userBalanceService.selectByExample(example);
/*  51: 76 */       if ((null != jcUserBalanceList) && (0 < jcUserBalanceList.size())) {
/*  52: 78 */         listSize = jcUserBalanceList.size();
/*  53:    */       }
/*  54: 80 */       example.setLimitStart(Integer.valueOf((pages - 1) * PageRecorders));
/*  55: 81 */       example.setLimitEnd(Integer.valueOf(PageRecorders));
/*  56:    */       
/*  57: 83 */       List<JcUserBalance> finalJcUserBalanceList = this.userBalanceService.selectByExample(example);
/*  58:    */       
/*  59:    */ 
/*  60: 86 */       map.put("lists", finalJcUserBalanceList);
/*  61:    */       
/*  62: 88 */       map.put("listSize", Long.valueOf(listSize));
/*  63: 89 */       map.put("pagenation", PageUtils.getPagenationInfo(listSize, pages, "goPage"));
/*  64:    */       
/*  65: 91 */       return map;
/*  66:    */     }
/*  67:    */     catch (Exception ex)
/*  68:    */     {
/*  69: 94 */       ex.printStackTrace();
/*  70: 95 */       map.put("error", ex.getMessage());
/*  71:    */     }
/*  72: 96 */     return map;
/*  73:    */   }
/*  74:    */   
/*  75:    */   @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  76:    */   public void updateBalance(HttpServletRequest request, HttpServletResponse response, String mobileName, int balance)
/*  77:    */   {
/*  78:    */     try
/*  79:    */     {
/*  80:106 */       JcUserBalanceExample example = new JcUserBalanceExample();
/*  81:107 */       JcUserBalanceExample.Criteria criteria = example.createCriteria();
/*  82:108 */       criteria.andUsernameEqualTo(mobileName);
/*  83:    */       
/*  84:110 */       example.setLimitStart(Integer.valueOf(0));
/*  85:111 */       example.setLimitEnd(Integer.valueOf(1));
/*  86:112 */       example.setOrderByClause("operdate desc ");
/*  87:    */       
/*  88:114 */       List<JcUserBalance> userBalances = this.userBalanceService.selectByExample(example);
/*  89:115 */       JcUserBalance userBalance = (JcUserBalance)userBalances.get(0);
/*  90:    */       
/*  91:117 */       JcUserBalance jcUserBalance = new JcUserBalance();
/*  92:118 */       jcUserBalance.setId(null);
/*  93:119 */       jcUserBalance.setBalance(Integer.valueOf(userBalance.getBalance().intValue() + balance));
/*  94:120 */       jcUserBalance.setPurpose("BACKRECHARGE");
/*  95:121 */       jcUserBalance.setRemark("[ 后台充值 ] , 金额￥" + balance);
/*  96:122 */       jcUserBalance.setOperdate(new Date());
/*  97:123 */       jcUserBalance.setUsername(mobileName);
/*  98:    */       
/*  99:125 */       this.userBalanceService.insertSelective(jcUserBalance);
/* 100:    */     }
/* 101:    */     catch (Exception ex)
/* 102:    */     {
/* 103:129 */       ex.printStackTrace();
/* 104:    */     }
/* 105:    */   }
/* 106:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.controller.BalanceController

 * JD-Core Version:    0.7.0.1

 */