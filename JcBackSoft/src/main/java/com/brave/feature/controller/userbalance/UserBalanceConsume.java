/*   1:    */ package com.brave.feature.controller.userbalance;
/*   2:    */ 
/*   3:    */ import com.brave.feature.entity.JcUserBalance;
/*   4:    */ import com.brave.feature.entity.JcUserBalanceExample;
/*   5:    */ import com.brave.feature.entity.JcUserBalanceExample.Criteria;
/*   6:    */ import com.brave.feature.service.UserBalanceService;
/*   7:    */ import java.util.Date;
/*   8:    */ import java.util.HashMap;
/*   9:    */ import java.util.List;
/*  10:    */ import java.util.Map;
/*  11:    */ import javax.servlet.http.HttpServletRequest;
/*  12:    */ import javax.servlet.http.HttpServletResponse;
/*  13:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  14:    */ import org.springframework.context.annotation.Scope;
/*  15:    */ import org.springframework.stereotype.Controller;
/*  16:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  17:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  18:    */ import org.springframework.web.servlet.ModelAndView;
/*  19:    */ 
/*  20:    */ @Controller
/*  21:    */ @Scope("prototype")
/*  22:    */ public class UserBalanceConsume
/*  23:    */ {
/*  24:    */   @Autowired
/*  25:    */   private UserBalanceService userBalanceService;
/*  26:    */   
/*  27:    */   @ResponseBody
/*  28:    */   @RequestMapping(value={"/userBalanceConsume"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  29:    */   public ModelAndView userBalanceConsume(HttpServletRequest request, HttpServletResponse response)
/*  30:    */   {
/*  31: 39 */     ModelAndView model = new ModelAndView();
/*  32: 40 */     Map<String, Object> resultMap = new HashMap();
/*  33:    */     try
/*  34:    */     {
/*  35: 43 */       int balance = Integer.parseInt(request.getParameter("balance"));
/*  36: 44 */       String username = request.getParameter("username");
/*  37: 45 */       String purple = request.getParameter("purple");
/*  38:    */       
/*  39: 47 */       JcUserBalanceExample example = new JcUserBalanceExample();
/*  40: 48 */       JcUserBalanceExample.Criteria criteria = example.createCriteria();
/*  41:    */       
/*  42:    */ 
/*  43: 51 */       criteria.andUsernameEqualTo(username);
/*  44:    */       
/*  45: 53 */       example.setLimitStart(Integer.valueOf(0));
/*  46: 54 */       example.setLimitEnd(Integer.valueOf(1));
/*  47: 55 */       example.setOrderByClause("operdate desc ");
/*  48:    */       
/*  49: 57 */       List<JcUserBalance> jcUserBalanceList = this.userBalanceService.selectByExample(example);
/*  50:    */       
/*  51:    */ 
/*  52: 60 */       JcUserBalance jcUserBalance = (JcUserBalance)jcUserBalanceList.get(0);
/*  53:    */       
/*  54: 62 */       String purpleRemark = "";
/*  55: 63 */       switch (purple)
/*  56:    */       {
/*  57:    */       case "INIT": 
/*  58: 66 */         purpleRemark = "初始化";
/*  59: 67 */         break;
/*  60:    */       case "GROUPJOIN": 
/*  61: 69 */         purpleRemark = "加入群组";
/*  62: 70 */         break;
/*  63:    */       case "GROUPCREATE": 
/*  64: 72 */         purpleRemark = "创建群组";
/*  65: 73 */         break;
/*  66:    */       default: 
/*  67: 75 */         purpleRemark = "";
/*  68:    */       }
/*  69: 79 */       if (balance <= jcUserBalance.getBalance().intValue())
/*  70:    */       {
/*  71: 81 */         jcUserBalance.setId(null);
/*  72: 82 */         jcUserBalance.setOperdate(new Date());
/*  73: 83 */         jcUserBalance.setRemark("[ " + purpleRemark + " ] , 消费￥" + balance);
/*  74: 84 */         jcUserBalance.setPurpose(purple);
/*  75: 85 */         jcUserBalance.setBalance(Integer.valueOf(jcUserBalance.getBalance().intValue() - balance));
/*  76:    */         
/*  77: 87 */         this.userBalanceService.insertSelective(jcUserBalance);
/*  78: 88 */         resultMap.put("data", "success");
/*  79: 89 */         resultMap.put("resultMsg", "消费成功.");
/*  80:    */       }
/*  81:    */       else
/*  82:    */       {
/*  83: 92 */         resultMap.put("data", "fail");
/*  84: 93 */         resultMap.put("resultMsg", "余额不足.");
/*  85:    */       }
/*  86: 96 */       model.addAllObjects(resultMap);
/*  87: 97 */       return model;
/*  88:    */     }
/*  89:    */     catch (Exception ex)
/*  90:    */     {
/*  91:100 */       ex.printStackTrace();
/*  92:101 */       resultMap.put("error", ex.getMessage());
/*  93:102 */       model.addAllObjects(resultMap);
/*  94:    */     }
/*  95:103 */     return model;
/*  96:    */   }
/*  97:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.brave.feature.controller.userbalance.UserBalanceConsume

 * JD-Core Version:    0.7.0.1

 */