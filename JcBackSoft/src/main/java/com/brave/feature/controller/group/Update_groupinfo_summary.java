/*  1:   */ package com.brave.feature.controller.group;
/*  2:   */ 
/*  3:   */ import com.fasterxml.jackson.databind.node.ArrayNode;
/*  4:   */ import com.fasterxml.jackson.databind.node.JsonNodeFactory;
/*  5:   */ import com.fasterxml.jackson.databind.node.ObjectNode;
/*  6:   */ import com.brave.feature.service.GroupInfoService;
/*  7:   */ import com.brave.feature.util.EasemobMessages;
/*  8:   */ import java.io.PrintStream;
/*  9:   */ import java.util.HashMap;
/* 10:   */ import java.util.Map;
/* 11:   */ import javax.servlet.http.HttpServletRequest;
/* 12:   */ import javax.servlet.http.HttpServletResponse;
/* 13:   */ import org.slf4j.Logger;
/* 14:   */ import org.slf4j.LoggerFactory;
/* 15:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 16:   */ import org.springframework.context.annotation.Scope;
/* 17:   */ import org.springframework.stereotype.Controller;
/* 18:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 19:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 20:   */ 
/* 21:   */ @Controller
/* 22:   */ @Scope("prototype")
/* 23:   */ public class Update_groupinfo_summary
/* 24:   */ {
/* 25:   */   @Autowired
/* 26:   */   private GroupInfoService groupInfoService;
/* 27:38 */   private static final Logger LOGGER = LoggerFactory.getLogger(Update_groupinfo_summary.class);
/* 28:39 */   private static final JsonNodeFactory factory = new JsonNodeFactory(false);
/* 29:   */   
/* 30:   */   @ResponseBody
/* 31:   */   @RequestMapping(value={"/update_groupinfo_summary"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 32:   */   public Map<String, Object> update_groupinfo_summary(HttpServletRequest req, HttpServletResponse resp)
/* 33:   */   {
/* 34:45 */     Map<String, Object> map = new HashMap();
/* 35:   */     try
/* 36:   */     {
/* 37:48 */       req.setCharacterEncoding("utf-8");
/* 38:49 */       resp.setCharacterEncoding("utf-8");
/* 39:50 */       String group_id = req.getParameter("groupid");
/* 40:51 */       String summary = req.getParameter("summary");
/* 41:52 */       Map<String, Object> GroupMap = new HashMap();
/* 42:53 */       GroupMap.put("Summary", summary);
/* 43:54 */       GroupMap.put("Groupid", group_id);
/* 44:55 */       int i = this.groupInfoService.updateGroupinfoSummary(GroupMap);
/* 45:56 */       if (i > 0)
/* 46:   */       {
/* 47:57 */         String msg = "群公告已更改，请查看!";
/* 48:58 */         String from = "系统消息";
/* 49:59 */         System.out.println("system:" + from);
/* 50:60 */         ObjectNode ext = factory.objectNode();
/* 51:61 */         ext.put("trueusername", "系统消息");
/* 52:   */         
/* 53:63 */         String targetTypegr = "chatgroups";
/* 54:64 */         ArrayNode targetgroup = factory.arrayNode();
/* 55:65 */         targetgroup.add(group_id);
/* 56:66 */         ObjectNode txtmsg = factory.objectNode();
/* 57:67 */         txtmsg.put("msg", msg);
/* 58:68 */         txtmsg.put("type", "txt");
/* 59:69 */         ObjectNode sendTxtMessagegroupnode = EasemobMessages.sendMessages(targetTypegr, targetgroup, txtmsg, from, ext);
/* 60:71 */         if (null != sendTxtMessagegroupnode) {
/* 61:72 */           LOGGER.info("给一个群组发文本消息: " + sendTxtMessagegroupnode.toString());
/* 62:   */         }
/* 63:74 */         System.out.println("给一个群组发文本消息: " + sendTxtMessagegroupnode.toString());
/* 64:   */       }
/* 65:76 */       map.put("data", i + "");
/* 66:77 */       return map;
/* 67:   */     }
/* 68:   */     catch (Exception ex)
/* 69:   */     {
/* 70:80 */       ex.printStackTrace();
/* 71:81 */       map.put("error", ex.getMessage());
/* 72:   */     }
/* 73:82 */     return map;
/* 74:   */   }
/* 75:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.group.Update_groupinfo_summary

 * JD-Core Version:    0.7.0.1

 */