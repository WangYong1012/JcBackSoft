/*  1:   */ package com.brave.feature.controller.group;
/*  2:   */ 
/*  3:   */ import com.fasterxml.jackson.databind.node.ArrayNode;
/*  4:   */ import com.fasterxml.jackson.databind.node.JsonNodeFactory;
/*  5:   */ import com.fasterxml.jackson.databind.node.ObjectNode;
/*  6:   */ import com.brave.feature.service.GroupInfoService;
/*  7:   */ import com.brave.feature.util.EasemobMessages;
/*  8:   */ import java.util.HashMap;
/*  9:   */ import java.util.Map;
/* 10:   */ import javax.servlet.http.HttpServletRequest;
/* 11:   */ import javax.servlet.http.HttpServletResponse;
/* 12:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 13:   */ import org.springframework.context.annotation.Scope;
/* 14:   */ import org.springframework.stereotype.Controller;
/* 15:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 16:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 17:   */ 
/* 18:   */ @Controller
/* 19:   */ @Scope("prototype")
/* 20:   */ public class Insert_groupinfo_data
/* 21:   */ {
/* 22:   */   @Autowired
/* 23:   */   private GroupInfoService groupInfoService;
/* 24:39 */   private static final JsonNodeFactory factory = new JsonNodeFactory(false);
/* 25:   */   
/* 26:   */   @ResponseBody
/* 27:   */   @RequestMapping(value={"/insert_groupinfo_data"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 28:   */   public Map<String, Object> Select_userinfo_data(HttpServletRequest req, HttpServletResponse resp)
/* 29:   */   {
/* 30:46 */     Map<String, Object> map = new HashMap();
/* 31:   */     try
/* 32:   */     {
/* 33:49 */       req.setCharacterEncoding("utf-8");
/* 34:50 */       resp.setCharacterEncoding("utf-8");
/* 35:51 */       String group_id = req.getParameter("groupid");
/* 36:52 */       String group_summary = req.getParameter("summary");
/* 37:53 */       String group_rule = req.getParameter("rule");
/* 38:54 */       String province = req.getParameter("province");
/* 39:55 */       String group_master = req.getParameter("groupmaster");
/* 40:56 */       Map<String, Object> GroupMap = new HashMap();
/* 41:57 */       if (province == null) {
/* 42:58 */         province = "";
/* 43:   */       }
/* 44:60 */       GroupMap.put("Groupid", group_id);
/* 45:61 */       GroupMap.put("Summary", group_summary);
/* 46:62 */       GroupMap.put("Rule", group_rule);
/* 47:63 */       GroupMap.put("Groupmaster", group_master);
/* 48:64 */       GroupMap.put("Province", province);
/* 49:65 */       int i = this.groupInfoService.insertGroupinfo(GroupMap);
/* 50:66 */       if (i > 0)
/* 51:   */       {
/* 52:67 */         String msg = "创建群组成功,请查看!";
/* 53:   */         
/* 54:69 */         String from = "系统消息";
/* 55:70 */         ArrayNode targetgroup = factory.arrayNode();
/* 56:71 */         targetgroup.add(group_id);
/* 57:72 */         ObjectNode txtmsg = factory.objectNode();
/* 58:73 */         ObjectNode ext = factory.objectNode();
/* 59:74 */         txtmsg.put("msg", msg);
/* 60:75 */         txtmsg.put("type", "txt");
/* 61:76 */         ext.put("trueusername", "系统消息");
/* 62:   */         
/* 63:78 */         String targetTypegr = "chatgroups";
/* 64:79 */         ObjectNode sendTxtMessagegroupnode = EasemobMessages.sendMessages(targetTypegr, targetgroup, txtmsg, from, ext);
/* 65:81 */         if (null == sendTxtMessagegroupnode) {}
/* 66:   */       }
/* 67:85 */       map.put("data", i + "");
/* 68:86 */       return map;
/* 69:   */     }
/* 70:   */     catch (Exception ex)
/* 71:   */     {
/* 72:89 */       ex.printStackTrace();
/* 73:90 */       map.put("error", ex.getMessage());
/* 74:   */     }
/* 75:91 */     return map;
/* 76:   */   }
/* 77:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.group.Insert_groupinfo_data

 * JD-Core Version:    0.7.0.1

 */