/*  1:   */ package com.brave.feature.controller.userbalance;
/*  2:   */ 
/*  3:   */ import com.brave.feature.entity.JcUserBalance;
/*  4:   */ import com.brave.feature.entity.JcUserBalanceExample;
/*  5:   */ import com.brave.feature.entity.JcUserBalanceExample.Criteria;
/*  6:   */ import com.brave.feature.service.UserBalanceService;
/*  7:   */ import java.util.HashMap;
/*  8:   */ import java.util.List;
/*  9:   */ import java.util.Map;
/* 10:   */ import javax.servlet.http.HttpServletRequest;
/* 11:   */ import javax.servlet.http.HttpServletResponse;
/* 12:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 13:   */ import org.springframework.context.annotation.Scope;
/* 14:   */ import org.springframework.stereotype.Controller;
/* 15:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 16:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 17:   */ import org.springframework.web.servlet.ModelAndView;
/* 18:   */ 
/* 19:   */ @Controller
/* 20:   */ @Scope("prototype")
/* 21:   */ public class GetUserBalance
/* 22:   */ {
/* 23:   */   @Autowired
/* 24:   */   private UserBalanceService userBalanceService;
/* 25:   */   
/* 26:   */   @ResponseBody
/* 27:   */   @RequestMapping(value={"/getUserBalance"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 28:   */   public ModelAndView getUserBalance(HttpServletRequest request, HttpServletResponse response)
/* 29:   */   {
/* 30:44 */     ModelAndView model = new ModelAndView();
/* 31:45 */     Map<String, Object> resultMap = new HashMap();
/* 32:   */     try
/* 33:   */     {
/* 34:48 */       String username = request.getParameter("username");
/* 35:   */       
/* 36:50 */       JcUserBalanceExample example = new JcUserBalanceExample();
/* 37:51 */       JcUserBalanceExample.Criteria criteria = example.createCriteria();
/* 38:   */       
/* 39:53 */       criteria.andUsernameEqualTo(username);
/* 40:   */       
/* 41:55 */       example.setOrderByClause("operdate desc ");
/* 42:56 */       example.setLimitStart(Integer.valueOf(0));
/* 43:57 */       example.setLimitEnd(Integer.valueOf(1));
/* 44:   */       
/* 45:59 */       List<JcUserBalance> jcUserBalanceList = this.userBalanceService.selectByExample(example);
/* 46:60 */       JcUserBalance jcUserBalance = (JcUserBalance)jcUserBalanceList.get(0);
/* 47:61 */       resultMap.put("balance", jcUserBalance.getBalance() + "");
/* 48:   */       
/* 49:63 */       model.addAllObjects(resultMap);
/* 50:64 */       return model;
/* 51:   */     }
/* 52:   */     catch (Exception ex)
/* 53:   */     {
/* 54:67 */       ex.printStackTrace();
/* 55:68 */       resultMap.put("error", ex.getMessage());
/* 56:69 */       model.addAllObjects(resultMap);
/* 57:   */     }
/* 58:70 */     return model;
/* 59:   */   }
/* 60:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userbalance.GetUserBalance

 * JD-Core Version:    0.7.0.1

 */