/*   1:    */ package com.brave.feature.controller.supporter;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.SupporterService;
/*   4:    */ import com.brave.feature.service.UserService;
/*   5:    */ import java.io.PrintStream;
/*   6:    */ import java.util.ArrayList;
/*   7:    */ import java.util.HashMap;
/*   8:    */ import java.util.List;
/*   9:    */ import java.util.Map;
/*  10:    */ import javax.servlet.http.HttpServletRequest;
/*  11:    */ import javax.servlet.http.HttpServletResponse;
/*  12:    */ import org.slf4j.Logger;
/*  13:    */ import org.slf4j.LoggerFactory;
/*  14:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  15:    */ import org.springframework.context.annotation.Scope;
/*  16:    */ import org.springframework.stereotype.Controller;
/*  17:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  18:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  19:    */ 
/*  20:    */ @Controller
/*  21:    */ @Scope("prototype")
/*  22:    */ public class Screen_Invoice
/*  23:    */ {
/*  24:    */   @Autowired
/*  25:    */   private UserService userService;
/*  26:    */   @Autowired
/*  27:    */   private SupporterService supporterService;
/*  28: 41 */   private static final Logger log = LoggerFactory.getLogger(Screen_Invoice.class);
/*  29:    */   
/*  30:    */   @ResponseBody
/*  31:    */   @RequestMapping(value={"/screen_Invoice"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  32:    */   public Map<String, Object> screen_Invoice(HttpServletRequest req, HttpServletResponse resp)
/*  33:    */   {
/*  34: 47 */     Map<String, Object> map = new HashMap();
/*  35:    */     try
/*  36:    */     {
/*  37: 50 */       req.setCharacterEncoding("utf-8");
/*  38: 51 */       resp.setCharacterEncoding("utf-8");
/*  39: 52 */       String check_statr = req.getParameter("check_statr");
/*  40: 53 */       String type = req.getParameter("type");
/*  41: 54 */       String min_money = req.getParameter("min_money");
/*  42: 55 */       String max_money = req.getParameter("max_money");
/*  43: 56 */       String start_data = req.getParameter("start_data");
/*  44: 57 */       String over_data = req.getParameter("over_data");
/*  45: 58 */       String endorsement = req.getParameter("endorsement");
/*  46: 59 */       String juli = req.getParameter("juli");
/*  47: 60 */       String sql = "Select * from supporters where ";
/*  48: 62 */       if ((check_statr.length() <= 0) && (type.length() <= 0) && 
/*  49: 63 */         (max_money.length() <= 0) && (min_money.length() <= 0) && 
/*  50: 64 */         (start_data.length() <= 0) && (over_data.length() <= 0) && 
/*  51: 65 */         (endorsement.length() <= 0) && (juli.length() > 0))
/*  52:    */       {
/*  53: 66 */         sql = "Select * from supporters where issuetime>=DATE_SUB(NOW(),INTERVAL 480 hour) order by issuetime desc";
/*  54:    */       }
/*  55:    */       else
/*  56:    */       {
/*  57: 68 */         if (check_statr.length() > 0)
/*  58:    */         {
/*  59: 69 */           int z = check_statr.indexOf(",");
/*  60: 70 */           if (z == -1)
/*  61:    */           {
/*  62: 71 */             sql = sql + "bankpoce = '" + check_statr + "'";
/*  63:    */           }
/*  64:    */           else
/*  65:    */           {
/*  66: 73 */             String[] strshuzu = check_statr.split(",");
/*  67: 74 */             sql = sql + "(";
/*  68: 75 */             for (int i = 0; i < strshuzu.length; i++) {
/*  69: 76 */               sql = sql + "bankpoce = '" + strshuzu[i] + "' or ";
/*  70:    */             }
/*  71: 78 */             sql = sql.substring(0, sql.length() - 3);
/*  72: 79 */             sql = sql + ")";
/*  73:    */           }
/*  74: 81 */           if (type.length() > 0) {
/*  75: 83 */             sql = sql + " and type = '" + type + "'";
/*  76:    */           }
/*  77: 86 */           if ((max_money.length() > 0) && (min_money.length() > 0)) {
/*  78: 87 */             sql = sql + " and money between " + min_money + " and " + max_money;
/*  79: 89 */           } else if (max_money.length() > 0) {
/*  80: 90 */             sql = sql + " and money<" + max_money;
/*  81: 91 */           } else if (min_money.length() > 0) {
/*  82: 92 */             sql = sql + " and money>" + min_money;
/*  83:    */           }
/*  84: 95 */           if ((start_data.length() > 0) && (over_data.length() > 0)) {
/*  85: 96 */             sql = sql + " and duedate between '" + start_data + "' and '" + over_data + "'";
/*  86: 98 */           } else if (start_data.length() > 0) {
/*  87: 99 */             sql = sql + " and duedate >'" + start_data + "'";
/*  88:100 */           } else if (over_data.length() > 0) {
/*  89:101 */             sql = sql + " and duedate <'" + over_data + "'";
/*  90:    */           }
/*  91:104 */           if (endorsement.length() > 0) {
/*  92:105 */             sql = sql + " and endorsement < " + endorsement;
/*  93:    */           }
/*  94:    */         }
/*  95:107 */         else if (type.length() > 0)
/*  96:    */         {
/*  97:109 */           sql = sql + "type = '" + type + "'";
/*  98:111 */           if ((max_money.length() > 0) && (min_money.length() > 0)) {
/*  99:112 */             sql = sql + " and money between " + min_money + " and " + max_money;
/* 100:114 */           } else if (max_money.length() > 0) {
/* 101:115 */             sql = sql + " and money<" + max_money;
/* 102:116 */           } else if (min_money.length() > 0) {
/* 103:117 */             sql = sql + " and money>" + min_money;
/* 104:    */           }
/* 105:120 */           if ((start_data.length() > 0) && (over_data.length() > 0)) {
/* 106:121 */             sql = sql + " and duedate between '" + start_data + "' and '" + over_data + "'";
/* 107:123 */           } else if (start_data.length() > 0) {
/* 108:124 */             sql = sql + " and duedate >'" + start_data + "'";
/* 109:125 */           } else if (over_data.length() > 0) {
/* 110:126 */             sql = sql + " and duedate <'" + over_data + "'";
/* 111:    */           }
/* 112:129 */           if (endorsement.length() > 0) {
/* 113:130 */             sql = sql + " and endorsement < " + endorsement;
/* 114:    */           }
/* 115:    */         }
/* 116:132 */         else if ((max_money.length() > 0) && (min_money.length() > 0))
/* 117:    */         {
/* 118:133 */           sql = sql + " money between " + min_money + " and " + max_money;
/* 119:135 */           if (endorsement.length() > 0) {
/* 120:136 */             sql = sql + " and endorsement < " + endorsement;
/* 121:    */           }
/* 122:139 */           if ((start_data.length() > 0) && (over_data.length() > 0)) {
/* 123:140 */             sql = sql + " and duedate between '" + start_data + "' and '" + over_data + "'";
/* 124:142 */           } else if (start_data.length() > 0) {
/* 125:143 */             sql = sql + " and duedate >'" + start_data + "'";
/* 126:144 */           } else if (over_data.length() > 0) {
/* 127:145 */             sql = sql + " and duedate <'" + over_data + "'";
/* 128:    */           }
/* 129:    */         }
/* 130:147 */         else if (max_money.length() > 0)
/* 131:    */         {
/* 132:148 */           sql = sql + " money<" + max_money;
/* 133:150 */           if (endorsement.length() > 0) {
/* 134:151 */             sql = sql + " and endorsement < " + endorsement;
/* 135:    */           }
/* 136:154 */           if ((start_data.length() > 0) && (over_data.length() > 0)) {
/* 137:155 */             sql = sql + " and duedate between '" + start_data + "' and '" + over_data + "'";
/* 138:157 */           } else if (start_data.length() > 0) {
/* 139:158 */             sql = sql + " and duedate >'" + start_data + "'";
/* 140:159 */           } else if (over_data.length() > 0) {
/* 141:160 */             sql = sql + " and duedate <'" + over_data + "'";
/* 142:    */           }
/* 143:    */         }
/* 144:162 */         else if (min_money.length() > 0)
/* 145:    */         {
/* 146:163 */           sql = sql + " money >" + min_money;
/* 147:165 */           if (endorsement.length() > 0) {
/* 148:166 */             sql = sql + " and endorsement < " + endorsement;
/* 149:    */           }
/* 150:169 */           if ((start_data.length() > 0) && (over_data.length() > 0)) {
/* 151:170 */             sql = sql + " and duedate between '" + start_data + "' and '" + over_data + "'";
/* 152:172 */           } else if (start_data.length() > 0) {
/* 153:173 */             sql = sql + " and duedate >'" + start_data + "'";
/* 154:174 */           } else if (over_data.length() > 0) {
/* 155:175 */             sql = sql + " and duedate <'" + over_data + "'";
/* 156:    */           }
/* 157:    */         }
/* 158:177 */         else if ((start_data.length() > 0) && (over_data.length() > 0))
/* 159:    */         {
/* 160:179 */           sql = sql + "duedate between '" + start_data + "' and '" + over_data + "'";
/* 161:182 */           if (endorsement.length() > 0) {
/* 162:183 */             sql = sql + " and endorsement < " + endorsement;
/* 163:    */           }
/* 164:    */         }
/* 165:185 */         else if (start_data.length() > 0)
/* 166:    */         {
/* 167:186 */           sql = sql + "duedate >'" + start_data + "'";
/* 168:188 */           if (endorsement.length() > 0) {
/* 169:189 */             sql = sql + " and endorsement < " + endorsement;
/* 170:    */           }
/* 171:    */         }
/* 172:191 */         else if (over_data.length() > 0)
/* 173:    */         {
/* 174:192 */           sql = sql + " duedate <'" + over_data + "'";
/* 175:194 */           if (endorsement.length() > 0) {
/* 176:195 */             sql = sql + " and endorsement < " + endorsement;
/* 177:    */           }
/* 178:    */         }
/* 179:197 */         else if (endorsement.length() > 0)
/* 180:    */         {
/* 181:198 */           sql = sql + "endorsement <= " + endorsement;
/* 182:    */         }
/* 183:200 */         sql = sql + " and  issuetime>=DATE_SUB(NOW(),INTERVAL 480 hour) order by issuetime desc ";
/* 184:    */       }
/* 185:202 */       List<Map<String, Object>> list = new ArrayList();
/* 186:203 */       List<Map<String, Object>> zuobiao = this.userService.selectTitudeAll();
/* 187:204 */       list = this.supporterService.screenSupportersByCondition(sql);
/* 188:205 */       System.out.println("sql:" + sql);
/* 189:206 */       map.put("data", list);
/* 190:207 */       map.put("zuobiao", zuobiao);
/* 191:208 */       return map;
/* 192:    */     }
/* 193:    */     catch (Exception ex)
/* 194:    */     {
/* 195:211 */       ex.printStackTrace();
/* 196:212 */       map.put("error", ex.getMessage());
/* 197:    */     }
/* 198:213 */     return map;
/* 199:    */   }
/* 200:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.supporter.Screen_Invoice

 * JD-Core Version:    0.7.0.1

 */