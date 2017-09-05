/*  1:   */ package com.brave.feature.controller.huanxin;
/*  2:   */ 
/*  3:   */ import com.fasterxml.jackson.databind.node.ArrayNode;
/*  4:   */ import com.fasterxml.jackson.databind.node.JsonNodeFactory;
/*  5:   */ import com.fasterxml.jackson.databind.node.ObjectNode;
/*  6:   */ import com.brave.feature.service.GroupInfoService;
/*  7:   */ import com.brave.feature.service.UserService;
/*  8:   */ import com.brave.feature.util.EasemobMessages;
/*  9:   */ import java.util.ArrayList;
/* 10:   */ import java.util.HashMap;
/* 11:   */ import java.util.List;
/* 12:   */ import java.util.Map;
/* 13:   */ import javax.servlet.http.HttpServletRequest;
/* 14:   */ import javax.servlet.http.HttpServletResponse;
/* 15:   */ import org.slf4j.Logger;
/* 16:   */ import org.slf4j.LoggerFactory;
/* 17:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 18:   */ import org.springframework.context.annotation.Scope;
/* 19:   */ import org.springframework.stereotype.Controller;
/* 20:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 21:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 22:   */ 
/* 23:   */ @Controller
/* 24:   */ @Scope("prototype")
/* 25:   */ public class Sendgroupmsg
/* 26:   */ {
/* 27:   */   @Autowired
/* 28:   */   private UserService userService;
/* 29:   */   @Autowired
/* 30:   */   private GroupInfoService groupInfoService;
/* 31:41 */   private static final Logger LOGGER = LoggerFactory.getLogger(Sendgroupmsg.class);
/* 32:42 */   private static final JsonNodeFactory factory = new JsonNodeFactory(false);
/* 33:   */   
/* 34:   */   @ResponseBody
/* 35:   */   @RequestMapping(value={"/send_group_message"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 36:   */   public Map<String, Object> groupmembers(HttpServletRequest req, HttpServletResponse resp)
/* 37:   */   {
/* 38:48 */     Map<String, Object> map = new HashMap();
/* 39:   */     try
/* 40:   */     {
/* 41:51 */       req.setCharacterEncoding("utf-8");
/* 42:52 */       resp.setCharacterEncoding("utf-8");
/* 43:53 */       String groupid = req.getParameter("groupid");
/* 44:54 */       String huanxinid = req.getParameter("hxid");
/* 45:55 */       List<Map<String, Object>> result = this.userService.selectUserDataInfoByHxid(huanxinid);
/* 46:56 */       String truename = ((Map)result.get(0)).get("Trueusername").toString();
/* 47:   */       
/* 48:58 */       List<Map<String, Object>> rules = this.groupInfoService.selectGroupinfoRuleById(groupid);
/* 49:59 */       ObjectNode txtmsg = factory.objectNode();
/* 50:60 */       String rule = null;
/* 51:61 */       if (rules.size() > 0) {
/* 52:62 */         rule = "　本群群规：" + ((Map)rules.get(0)).get("rule").toString();
/* 53:   */       }
/* 54:64 */       String msg = "欢迎" + truename + "加入群!" + rule;
/* 55:65 */       List<String> list = new ArrayList();
/* 56:66 */       list.add(0, groupid);
/* 57:67 */       String from = "系统消息";
/* 58:68 */       ObjectNode ext = factory.objectNode();
/* 59:69 */       ext.put("trueusername", "系统消息");
/* 60:   */       
/* 61:71 */       String targetTypegr = "chatgroups";
/* 62:72 */       ArrayNode targetgroup = factory.arrayNode();
/* 63:73 */       targetgroup.add(groupid);
/* 64:74 */       txtmsg.put("msg", msg);
/* 65:75 */       txtmsg.put("type", "txt");
/* 66:76 */       ObjectNode sendTxtMessagegroupnode = EasemobMessages.sendMessages(targetTypegr, targetgroup, txtmsg, from, ext);
/* 67:78 */       if (null != sendTxtMessagegroupnode)
/* 68:   */       {
/* 69:79 */         LOGGER.info("给一个群组发文本消息: " + sendTxtMessagegroupnode.toString());
/* 70:80 */         map.put("data", "1");
/* 71:   */       }
/* 72:   */       else
/* 73:   */       {
/* 74:82 */         map.put("data", "0");
/* 75:   */       }
/* 76:84 */       return map;
/* 77:   */     }
/* 78:   */     catch (Exception ex)
/* 79:   */     {
/* 80:87 */       ex.printStackTrace();
/* 81:88 */       map.put("error", ex.getMessage());
/* 82:   */     }
/* 83:89 */     return map;
/* 84:   */   }
/* 85:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.huanxin.Sendgroupmsg

 * JD-Core Version:    0.7.0.1

 */