/*  1:   */ package com.brave.feature.controller.userbalance;
/*  2:   */ 
/*  3:   */ import com.brave.feature.entity.JcUserBalance;
/*  4:   */ import com.brave.feature.entity.JcUserBalanceExample;
/*  6:   */ import com.brave.feature.service.UserBalanceService;
/*  7:   */ import com.brave.system.entity.UserInfo;
/*  8:   */ import com.brave.system.entity.UserInfoExample;
/* 10:   */ import com.brave.system.service.IUserInfoService;
/* 12:   */ import java.util.Date;
/* 13:   */ import java.util.HashMap;
/* 14:   */ import java.util.List;
/* 15:   */ import java.util.Map;
/* 16:   */ import javax.servlet.http.HttpServletRequest;
/* 17:   */ import javax.servlet.http.HttpServletResponse;
/* 18:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 19:   */ import org.springframework.context.annotation.Scope;
/* 20:   */ import org.springframework.stereotype.Controller;
/* 21:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 22:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 23:   */ import org.springframework.web.servlet.ModelAndView;
/* 24:   */ 
/* 25:   */ @Controller
/* 26:   */ @Scope("prototype")
/* 27:   */ public class InsertUserBalance
/* 28:   */ {
/* 29:   */   @Autowired
/* 30:   */   private UserBalanceService userBalanceService;
/* 31:   */   @Autowired
/* 32:   */   private IUserInfoService userInfoMapper;
/* 33:   */   
/* 34:   */   @ResponseBody
/* 35:   */   @RequestMapping(value={"/insertUserBalance"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 36:   */   public ModelAndView insertUserBalance(HttpServletRequest request, HttpServletResponse response)
/* 37:   */   {
/* 38:46 */     ModelAndView model = new ModelAndView();
/* 39:47 */     Map<String, Object> resultMap = new HashMap();
/* 40:   */     try
/* 41:   */     {
/* 42:51 */       UserInfoExample example = new UserInfoExample();
/* 43:52 */       UserInfoExample.Criteria criteria = example.createCriteria();
/* 44:   */       
/* 45:54 */       List<UserInfo> userInfoList = this.userInfoMapper.selectByExample(example);
/* 46:   */       
/* 47:56 */       int count = 0;
/* 48:57 */       for (int i = 0; i < userInfoList.size(); i++)
/* 49:   */       {
/* 50:60 */         UserInfo userInfo = (UserInfo)userInfoList.get(i);
/* 51:   */         
/* 52:62 */         JcUserBalanceExample balanceExample = new JcUserBalanceExample();
/* 53:63 */         JcUserBalanceExample.Criteria balanceCriteria = balanceExample.createCriteria();
/* 54:64 */         balanceCriteria.andUsernameEqualTo(userInfo.getUsername());
/* 55:   */         
/* 56:66 */         List<JcUserBalance> jcUserBalanceList = this.userBalanceService.selectByExample(balanceExample);
/* 57:67 */         if ((null != jcUserBalanceList) && (0 < jcUserBalanceList.size()))
/* 58:   */         {
/* 59:69 */           System.out.print("已经存在用户余额记录,不做保存.");
/* 60:   */         }
/* 61:   */         else
/* 62:   */         {
/* 63:72 */           JcUserBalance jcUserBalance = new JcUserBalance();
/* 64:73 */           jcUserBalance.setUsername(userInfo.getUsername());
/* 65:74 */           jcUserBalance.setPurpose("INIT");
/* 66:75 */           jcUserBalance.setRemark("注册成功,并向用户虚拟余额内充值￥100.");
/* 67:76 */           jcUserBalance.setId(null);
/* 68:77 */           jcUserBalance.setOperdate(new Date());
/* 69:78 */           this.userBalanceService.insertSelective(jcUserBalance);
/* 70:79 */           count++;
/* 71:80 */           System.out.println("[ " + userInfo.getTrueusername() + " ] 用户已经生成余额记录.");
/* 72:   */         }
/* 73:   */       }
/* 74:83 */       resultMap.put("data", "共保存了 [ " + count + " ] 条记录.");
/* 75:84 */       model.addAllObjects(resultMap);
/* 76:85 */       return model;
/* 77:   */     }
/* 78:   */     catch (Exception ex)
/* 79:   */     {
/* 80:88 */       ex.printStackTrace();
/* 81:89 */       resultMap.put("error", ex.getMessage());
/* 82:90 */       model.addAllObjects(resultMap);
/* 83:   */     }
/* 84:91 */     return model;
/* 85:   */   }
/* 86:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userbalance.InsertUserBalance

 * JD-Core Version:    0.7.0.1

 */