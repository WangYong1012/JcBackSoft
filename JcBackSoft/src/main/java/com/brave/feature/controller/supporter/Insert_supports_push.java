/*   1:    */ package com.brave.feature.controller.supporter;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.UserService;
/*   4:    */ import com.brave.feature.util.Pushall_ser;
/*   5:    */ import com.brave.feature.util.Pushall_ser_ios;
/*   6:    */ import java.util.ArrayList;
/*   7:    */ import java.util.HashMap;
/*   8:    */ import java.util.List;
/*   9:    */ import java.util.Map;
/*  10:    */ import java.util.regex.Matcher;
/*  11:    */ import java.util.regex.Pattern;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import org.slf4j.Logger;
/*  15:    */ import org.slf4j.LoggerFactory;
/*  16:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  17:    */ import org.springframework.context.annotation.Scope;
/*  18:    */ import org.springframework.stereotype.Controller;
/*  19:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  20:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  21:    */ import org.springframework.web.servlet.ModelAndView;
/*  22:    */ 
/*  23:    */ @Controller
/*  24:    */ @Scope("prototype")
/*  25:    */ public class Insert_supports_push
/*  26:    */ {
/*  27:    */   @Autowired
/*  28:    */   private UserService userService;
/*  29: 40 */   private static final Logger log = LoggerFactory.getLogger(Insert_supports_push.class);
/*  30:    */   
/*  31:    */   @ResponseBody
/*  32:    */   @RequestMapping(value={"/insert_supporters_push"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  33:    */   public ModelAndView insert_supporters(HttpServletRequest req, HttpServletResponse resp)
/*  34:    */   {
/*  35: 46 */     ModelAndView model = new ModelAndView();
/*  36: 47 */     Map<String, Object> resultMap = new HashMap();
/*  37:    */     try
/*  38:    */     {
/*  39: 50 */       log.error("[insert_supporters] 开始进入方法..");
/*  40: 51 */       String channelId = req.getParameter("channelId");
/*  41: 52 */       String zhangshu = req.getParameter("zhangshu");
/*  42: 53 */       String money = req.getParameter("money");
/*  43: 54 */       String bankname = req.getParameter("bankname");
/*  44: 55 */       String dudate = req.getParameter("dudate");
/*  45: 56 */       log.error("[insert_supporters] channelId:" + channelId);
/*  46: 57 */       if ((zhangshu != null) && (money != null))
/*  47:    */       {
/*  48: 59 */         String neirong = zhangshu + "张-" + bankname + "-" + money + "万-" + dudate + "到期";
/*  49: 61 */         if (("未填写".equals(bankname)) || (bankname == null))
/*  50:    */         {
/*  51: 62 */           if (("未填写".equals(dudate)) || (dudate == null)) {
/*  52: 63 */             neirong = zhangshu + "张-" + money + "万";
/*  53:    */           } else {
/*  54: 65 */             neirong = zhangshu + "张-" + money + "万-" + dudate + "到期";
/*  55:    */           }
/*  56:    */         }
/*  57: 68 */         else if (("未填写".equals(dudate)) || (dudate == null)) {
/*  58: 69 */           neirong = zhangshu + "张-" + bankname + "-" + money + "万";
/*  59:    */         } else {
/*  60: 71 */           neirong = zhangshu + "张-" + bankname + "-" + money + "万-" + dudate + "到期";
/*  61:    */         }
/*  62: 75 */         List<Map<String, Object>> listandroid = new ArrayList();
/*  63: 76 */         List<Map<String, Object>> listios = new ArrayList();
/*  64: 77 */         log.error("[insert_supporters] 77");
/*  65: 79 */         if ((!"".equals(channelId)) && (null != channelId))
/*  66:    */         {
/*  67: 80 */           listandroid = this.userService.selectUserChannelIdByAd1(channelId);
/*  68: 81 */           listios = this.userService.selectUserChannelIdByIos1(channelId);
/*  69:    */         }
/*  70:    */         else
/*  71:    */         {
/*  72: 84 */           listandroid = this.userService.selectUserChannelIdByAd2();
/*  73: 85 */           listios = this.userService.selectUserChannelIdByIos2();
/*  74:    */         }
/*  75: 87 */         if (listandroid != null)
/*  76:    */         {
/*  77: 91 */           List<String> listchannelandroid = new ArrayList();
/*  78: 93 */           for (int x = 0; x < listandroid.size(); x++)
/*  79:    */           {
/*  80: 94 */             boolean b = isNumeric(((Map)listandroid.get(x)).get("channelid")
/*  81: 95 */               .toString());
/*  82: 96 */             if ((b == true) && 
/*  83: 97 */               (!"123".equals(((Map)listandroid.get(x)).get("channelid")
/*  84: 98 */               .toString()))) {
/*  85: 99 */               listchannelandroid.add(((Map)listandroid.get(x)).get("channelid")
/*  86:100 */                 .toString());
/*  87:    */             }
/*  88:    */           }
/*  89:107 */           for (int g = 0; g < listchannelandroid.size() - 1; g++) {
/*  90:108 */             for (int j = listchannelandroid.size() - 1; j > g; j--) {
/*  91:109 */               if (((String)listchannelandroid.get(j)).equals(listchannelandroid
/*  92:110 */                 .get(g))) {
/*  93:111 */                 listchannelandroid.remove(j);
/*  94:    */               }
/*  95:    */             }
/*  96:    */           }
/*  97:115 */           Pushall_ser ph = new Pushall_ser();
/*  98:116 */           ph.push_ser(listchannelandroid, "新信息提示", neirong);
/*  99:    */         }
/* 100:118 */         if (listios != null)
/* 101:    */         {
/* 102:123 */           log.error("[insert_supporters] 123");
/* 103:124 */           for (int g = 0; g < listios.size() - 1; g++) {
/* 104:125 */             for (int j = listios.size() - 1; j > g; j--) {
/* 105:126 */               if (((Map)listios.get(j)).get("channelid").equals(
/* 106:127 */                 ((Map)listios.get(g)).get("channelid"))) {
/* 107:128 */                 listios.remove(j);
/* 108:    */               }
/* 109:    */             }
/* 110:    */           }
/* 111:132 */           log.error("[insert_supporters] 132");
/* 112:134 */           for (int x = 0; x < listios.size(); x++)
/* 113:    */           {
/* 114:135 */             boolean b = isNumeric(((Map)listios.get(x)).get("channelid")
/* 115:136 */               .toString());
/* 116:137 */             if (b != true) {
/* 117:138 */               listios.remove(x);
/* 118:    */             }
/* 119:    */           }
/* 120:143 */           log.error("[insert_supporters] 143");
/* 121:144 */           log.error("[insert_supporters] listios:" + listios);
/* 122:    */           
/* 123:146 */           Pushall_ser_ios pios = new Pushall_ser_ios();
/* 124:147 */           String s = "";
/* 125:148 */           for (int m = 0; m < listios.size(); m++) {
/* 126:149 */             if ("1".equals(((Map)listios.get(m)).get("push_music").toString()))
/* 127:    */             {
/* 128:150 */               s = "sound.caf";
/* 129:151 */               pios.pushall_ser_ios(((Map)listios.get(m)).get("channelid")
/* 130:152 */                 .toString(), neirong, s);
/* 131:    */             }
/* 132:153 */             else if ("0".equals(((Map)listios.get(m)).get("push_music")
/* 133:154 */               .toString()))
/* 134:    */             {
/* 135:155 */               s = "";
/* 136:156 */               pios.pushall_ser_ios(((Map)listios.get(m)).get("channelid")
/* 137:157 */                 .toString(), neirong, s);
/* 138:    */             }
/* 139:    */           }
/* 140:160 */           log.error("[insert_supporters] 160");
/* 141:    */         }
/* 142:    */       }
/* 143:163 */       log.error("[insert_supporters] 163");
/* 144:164 */       resultMap.put("data", "SUCCESS");
/* 145:165 */       model.addAllObjects(resultMap);
/* 146:166 */       return model;
/* 147:    */     }
/* 148:    */     catch (Exception ex)
/* 149:    */     {
/* 150:169 */       ex.printStackTrace();
/* 151:170 */       resultMap.put("data", "FAIL");
/* 152:171 */       log.error("[insert_supporters] error exception");
/* 153:172 */       model.addAllObjects(resultMap);
/* 154:    */     }
/* 155:173 */     return model;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public static boolean isNumeric(String str)
/* 159:    */   {
/* 160:179 */     Pattern pattern = Pattern.compile("[0-9]*");
/* 161:180 */     Matcher isNum = pattern.matcher(str);
/* 162:181 */     if (!isNum.matches()) {
/* 163:182 */       return false;
/* 164:    */     }
/* 165:184 */     return true;
/* 166:    */   }
/* 167:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.supporter.Insert_supports_push

 * JD-Core Version:    0.7.0.1

 */