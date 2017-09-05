/*   1:    */ package com.brave.feature.controller.huanxin;
/*   2:    */ 
/*   3:    */ import com.fasterxml.jackson.databind.node.ArrayNode;
/*   4:    */ import com.fasterxml.jackson.databind.node.JsonNodeFactory;
/*   5:    */ import com.fasterxml.jackson.databind.node.ObjectNode;
/*   6:    */ import com.brave.feature.util.EasemobMessages;
/*   7:    */ import java.util.HashMap;
/*   8:    */ import java.util.Map;
/*   9:    */ import javax.servlet.http.HttpServletRequest;
/*  10:    */ import javax.servlet.http.HttpServletResponse;
/*  11:    */ import org.slf4j.Logger;
/*  12:    */ import org.slf4j.LoggerFactory;
/*  13:    */ import org.springframework.context.annotation.Scope;
/*  14:    */ import org.springframework.stereotype.Controller;
/*  15:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  16:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  17:    */ import org.springframework.web.servlet.ModelAndView;
/*  18:    */ 
/*  19:    */ @Controller
/*  20:    */ @Scope("prototype")
/*  21:    */ public class SendUsersMessage
/*  22:    */ {
/*  23: 34 */   private int pagesize = 200;
/*  24: 36 */   private static final Logger LOGGER = LoggerFactory.getLogger(SendUsersMessage.class);
/*  25: 37 */   private static final JsonNodeFactory factory = new JsonNodeFactory(false);
/*  26:    */   
/*  27:    */   @ResponseBody
/*  28:    */   @RequestMapping(value={"/send_Users_Message"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  29:    */   public ModelAndView update_groupinfo_summary(HttpServletRequest req, HttpServletResponse resp)
/*  30:    */   {
/*  31: 43 */     Map<String, Object> map = new HashMap();
/*  32: 44 */     ModelAndView model = new ModelAndView();
/*  33:    */     try
/*  34:    */     {
/*  35: 47 */       req.setCharacterEncoding("utf-8");
/*  36: 48 */       resp.setCharacterEncoding("utf-8");
/*  37: 49 */       String from = req.getParameter("hxid");
/*  38: 50 */       String userid = req.getParameter("userid");
/*  39: 51 */       String msg = req.getParameter("msg");
/*  40: 52 */       ObjectNode ext = factory.objectNode();
/*  41: 53 */       ObjectNode txtmsg = factory.objectNode();
/*  42: 54 */       txtmsg.put("msg", msg);
/*  43: 55 */       txtmsg.put("type", "txt");
/*  44: 56 */       String targetTypegr = "users";
/*  45:    */       
/*  46:    */ 
/*  47: 59 */       String[] arrStr = userid.trim().replaceAll("\r|\n", "").replace("(", "").replace(")", "").replace("[", "").replace("]", "").split(",");
/*  48: 60 */       ArrayNode targetgroup = factory.arrayNode();
/*  49: 61 */       int count = arrStr.length;
/*  50: 62 */       if (count <= 200)
/*  51:    */       {
/*  52: 63 */         for (int i = 0; i < count; i++) {
/*  53: 64 */           targetgroup.add(arrStr[i].trim());
/*  54:    */         }
/*  55: 66 */         ObjectNode sendTxtMessagegroupnode = EasemobMessages.sendMessages(targetTypegr, targetgroup, txtmsg, from, ext);
/*  56: 68 */         if (null != sendTxtMessagegroupnode)
/*  57:    */         {
/*  58: 70 */           LOGGER.info("给一个群组发文本消息: " + sendTxtMessagegroupnode
/*  59: 71 */             .toString());
/*  60: 72 */           map.put("data", "1");
/*  61:    */         }
/*  62:    */         else
/*  63:    */         {
/*  64: 74 */           map.put("data", "0");
/*  65:    */         }
/*  66:    */       }
/*  67:    */       else
/*  68:    */       {
/*  69: 77 */         int num = setTotalPageCountByRs(count, this.pagesize);
/*  70: 78 */         int startRow = 0;
/*  71: 79 */         for (int j = 1; j <= num; j++)
/*  72:    */         {
/*  73: 80 */           if (j != 1) {
/*  74: 82 */             startRow = getStartRow(j) + 1;
/*  75:    */           } else {
/*  76: 85 */             startRow = getStartRow(j);
/*  77:    */           }
/*  78: 87 */           int EndRow = getEndRow(j, arrStr.length);
/*  79: 88 */           for (int k = startRow; k < EndRow; k++) {
/*  80: 89 */             targetgroup.add(arrStr[k]);
/*  81:    */           }
/*  82: 92 */           ObjectNode sendTxtMessagegroupnode = EasemobMessages.sendMessages(targetTypegr, targetgroup, txtmsg, from, ext);
/*  83:    */           
/*  84: 94 */           map.put("data", "1");
/*  85: 95 */           if (null != sendTxtMessagegroupnode)
/*  86:    */           {
/*  87: 96 */             LOGGER.info("给一个群组发文本消息: " + sendTxtMessagegroupnode
/*  88: 97 */               .toString());
/*  89: 98 */             map.put("data", "1");
/*  90:    */           }
/*  91:    */           else
/*  92:    */           {
/*  93:100 */             map.put("data", "0");
/*  94:    */           }
/*  95:    */         }
/*  96:    */       }
/*  97:104 */       model.addAllObjects(map);
/*  98:105 */       return model;
/*  99:    */     }
/* 100:    */     catch (Exception ex)
/* 101:    */     {
/* 102:108 */       ex.printStackTrace();
/* 103:109 */       map.put("error", ex.getMessage());
/* 104:110 */       model.addAllObjects(map);
/* 105:    */     }
/* 106:111 */     return model;
/* 107:    */   }
/* 108:    */   
/* 109:    */   private int setTotalPageCountByRs(int count, int pagesize)
/* 110:    */   {
/* 111:120 */     int pageCount = 0;
/* 112:121 */     if ((pagesize > 0) && (count > 0) && (count % pagesize == 0)) {
/* 113:122 */       pageCount = count / pagesize;
/* 114:123 */     } else if ((pagesize > 0) && (count > 0) && (count % pagesize > 0)) {
/* 115:124 */       pageCount = count / pagesize + 1;
/* 116:    */     } else {
/* 117:126 */       pageCount = 0;
/* 118:    */     }
/* 119:128 */     return pageCount;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public int getStartRow(int index)
/* 123:    */   {
/* 124:137 */     return (index - 1) * this.pagesize;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public int getEndRow(int index, int totalLenth)
/* 128:    */   {
/* 129:147 */     if (totalLenth < index * this.pagesize) {
/* 130:149 */       return totalLenth;
/* 131:    */     }
/* 132:152 */     return index * this.pagesize;
/* 133:    */   }
/* 134:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.huanxin.SendUsersMessage

 * JD-Core Version:    0.7.0.1

 */