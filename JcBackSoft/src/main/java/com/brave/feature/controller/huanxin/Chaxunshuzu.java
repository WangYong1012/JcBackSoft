/*  1:   */ package com.brave.feature.controller.huanxin;
/*  2:   */ 
/*  3:   */ import com.fasterxml.jackson.databind.node.ObjectNode;
/*  4:   */ import com.brave.feature.util.EasemobChatGroups;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import java.util.Map;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import javax.servlet.http.HttpServletResponse;
/*  9:   */ import org.springframework.context.annotation.Scope;
/* 10:   */ import org.springframework.stereotype.Controller;
/* 11:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 12:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 13:   */ 
/* 14:   */ @Controller
/* 15:   */ @Scope("prototype")
/* 16:   */ public class Chaxunshuzu
/* 17:   */ {
/* 18:   */   @ResponseBody
/* 19:   */   @RequestMapping(value={"/chaxunshuzu"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 20:   */   public Map<String, Object> shuzuchaxun(HttpServletRequest req, HttpServletResponse resp)
/* 21:   */   {
/* 22:35 */     Map<String, Object> map = new HashMap();
/* 23:   */     try
/* 24:   */     {
/* 25:38 */       req.setCharacterEncoding("utf-8");
/* 26:39 */       resp.setCharacterEncoding("utf-8");
/* 27:40 */       String QunzuID = req.getParameter("qunzuid");
/* 28:41 */       ObjectNode groupDetailNode = EasemobChatGroups.getGroupDetailsByChatgroupid(QunzuID);
/* 29:42 */       map.put("data", groupDetailNode.toString());
/* 30:43 */       return map;
/* 31:   */     }
/* 32:   */     catch (Exception ex)
/* 33:   */     {
/* 34:46 */       ex.printStackTrace();
/* 35:47 */       map.put("error", ex.getMessage());
/* 36:   */     }
/* 37:48 */     return map;
/* 38:   */   }
/* 39:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.huanxin.Chaxunshuzu

 * JD-Core Version:    0.7.0.1

 */