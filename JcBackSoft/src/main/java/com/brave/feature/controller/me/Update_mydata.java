/*   1:    */ package com.brave.feature.controller.me;
/*   2:    */ 
/*   3:    */ import com.fasterxml.jackson.databind.node.ObjectNode;
/*   4:    */ import com.brave.feature.service.CollectService;
/*   5:    */ import com.brave.feature.service.SupporterService;
/*   6:    */ import com.brave.feature.service.UserService;
/*   7:    */ import com.brave.feature.util.EasemobIMUsers;
/*   8:    */ import java.util.HashMap;
/*   9:    */ import java.util.List;
/*  10:    */ import java.util.Map;
/*  11:    */ import javax.servlet.http.HttpServletRequest;
/*  12:    */ import javax.servlet.http.HttpServletResponse;
/*  13:    */ import net.sf.json.JSONObject;
/*  14:    */ import org.slf4j.Logger;
/*  15:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  16:    */ import org.springframework.context.annotation.Scope;
/*  17:    */ import org.springframework.stereotype.Controller;
/*  18:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  19:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  20:    */ 
/*  21:    */ @Controller
/*  22:    */ @Scope("prototype")
/*  23:    */ public class Update_mydata
/*  24:    */ {
/*  25:    */   @Autowired
/*  26:    */   private UserService userService;
/*  27:    */   @Autowired
/*  28:    */   private SupporterService supporterService;
/*  29:    */   @Autowired
/*  30:    */   private CollectService collectService;
/*  31:    */   
/*  32:    */   @ResponseBody
/*  33:    */   @RequestMapping(value={"/update_mydata"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  34:    */   public Map<String, Object> update_mydata(HttpServletRequest req, HttpServletResponse resp)
/*  35:    */   {
/*  36: 48 */     Map<String, Object> map = new HashMap();
/*  37:    */     try
/*  38:    */     {
/*  39: 51 */       req.setCharacterEncoding("utf-8");
/*  40: 52 */       resp.setCharacterEncoding("utf-8");
/*  41: 53 */       String username = req.getParameter("name");
/*  42: 54 */       String truename = req.getParameter("truename");
/*  43: 55 */       String password = req.getParameter("password");
/*  44: 56 */       String phone = req.getParameter("phone");
/*  45: 57 */       String company = req.getParameter("company");
/*  46: 58 */       String companyname = req.getParameter("companyname");
/*  47: 59 */       String sex = req.getParameter("sex");
/*  48: 60 */       String shuoming = req.getParameter("shuoming");
/*  49: 61 */       String publicity = req.getParameter("publicity");
/*  50: 62 */       Map<String, Object> userMap = new HashMap();
/*  51: 63 */       userMap.put("Password", password);
/*  52: 64 */       userMap.put("Sex", sex);
/*  53: 65 */       userMap.put("Phone", phone);
/*  54: 66 */       userMap.put("Companyaddress", company);
/*  55: 67 */       userMap.put("Companyname", companyname);
/*  56: 68 */       userMap.put("Truename", truename);
/*  57: 69 */       userMap.put("Userexplain", shuoming);
/*  58: 70 */       userMap.put("Publicity", publicity);
/*  59: 71 */       userMap.put("Username", username);
/*  60:    */       
/*  61:    */ 
/*  62: 74 */       int supportersphone = this.supporterService.updateSupportersPhone(userMap);
/*  63:    */       
/*  64:    */ 
/*  65:    */ 
/*  66: 78 */       int collectphone = this.collectService.updateCollectPhone(userMap);
/*  67: 79 */       List<Map<String, Object>> list_rtn = this.userService.selectMydata(userMap);
/*  68: 80 */       String trueusername = ((Map)list_rtn.get(0)).get("Trueusername").toString();
/*  69: 81 */       String hxid = ((Map)list_rtn.get(0)).get("hxid").toString();
/*  70: 82 */       String nick = "0";
/*  71: 83 */       if (!truename.equals(trueusername))
/*  72:    */       {
/*  73: 84 */         ObjectNode updatenicknameNode = EasemobIMUsers.update_nickname(hxid, truename);
/*  74: 86 */         if (null != updatenicknameNode)
/*  75:    */         {
/*  76: 87 */           EasemobIMUsers.LOGGER.info("更改用户昵称: " + updatenicknameNode
/*  77: 88 */             .toString());
/*  78:    */           
/*  79: 90 */           String fanhuizhi = updatenicknameNode.toString();
/*  80: 91 */           JSONObject json = JSONObject.fromObject(fanhuizhi);
/*  81: 92 */           String zhuangtaima = json.getString("statusCode");
/*  82: 94 */           if ((!"".equals(zhuangtaima)) && ("200".equals(zhuangtaima))) {
/*  83: 96 */             nick = "1";
/*  84: 97 */           } else if ((!"".equals(zhuangtaima)) && 
/*  85: 98 */             (!"200".equals(zhuangtaima))) {
/*  86:100 */             nick = "2";
/*  87:    */           }
/*  88:    */         }
/*  89:    */       }
/*  90:104 */       int i = this.userService.updateUserinfo(userMap);
/*  91:105 */       map.put("data", i + "");
/*  92:106 */       map.put("supportersphone", Integer.valueOf(supportersphone));
/*  93:107 */       map.put("collectphone", Integer.valueOf(collectphone));
/*  94:108 */       map.put("nickname", nick);
/*  95:109 */       return map;
/*  96:    */     }
/*  97:    */     catch (Exception ex)
/*  98:    */     {
/*  99:112 */       ex.printStackTrace();
/* 100:113 */       map.put("error", ex.getMessage());
/* 101:    */     }
/* 102:114 */     return map;
/* 103:    */   }
/* 104:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.me.Update_mydata

 * JD-Core Version:    0.7.0.1

 */