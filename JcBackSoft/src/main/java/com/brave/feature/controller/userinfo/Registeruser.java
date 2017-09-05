/*   1:    */ package com.brave.feature.controller.userinfo;
/*   2:    */ 
/*   3:    */ import com.fasterxml.jackson.databind.node.JsonNodeFactory;
/*   4:    */ import com.fasterxml.jackson.databind.node.ObjectNode;
/*   5:    */ import com.brave.feature.entity.JcUserBalance;
/*   6:    */ import com.brave.feature.service.ErrorInfoService;
/*   7:    */ import com.brave.feature.service.FriendService;
/*   8:    */ import com.brave.feature.service.UserBalanceService;
/*   9:    */ import com.brave.feature.service.UserService;
/*  10:    */ import com.brave.feature.util.EasemobIMUsers;
/*  11:    */ import com.brave.feature.util.MD5;
/*  12:    */ import java.io.PrintStream;
/*  13:    */ import java.text.SimpleDateFormat;
/*  14:    */ import java.util.Date;
/*  15:    */ import java.util.HashMap;
/*  16:    */ import java.util.List;
/*  17:    */ import java.util.Map;
/*  18:    */ import java.util.regex.Matcher;
/*  19:    */ import java.util.regex.Pattern;
/*  20:    */ import javax.servlet.http.HttpServletRequest;
/*  21:    */ import javax.servlet.http.HttpServletResponse;
/*  22:    */ import net.sf.json.JSONObject;
/*  23:    */ import org.apache.commons.lang3.StringUtils;
/*  24:    */ import org.slf4j.Logger;
/*  25:    */ import org.slf4j.LoggerFactory;
/*  26:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  27:    */ import org.springframework.context.annotation.Scope;
/*  28:    */ import org.springframework.stereotype.Controller;
/*  29:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  30:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  31:    */ import org.springframework.web.servlet.ModelAndView;
/*  32:    */ 
/*  33:    */ @Controller
/*  34:    */ @Scope("prototype")
/*  35:    */ public class Registeruser
/*  36:    */ {
/*  37:    */   @Autowired
/*  38:    */   public UserService userService;
/*  39:    */   @Autowired
/*  40:    */   public FriendService friendService;
/*  41:    */   @Autowired
/*  42:    */   public ErrorInfoService errorInfoService;
/*  43:    */   @Autowired
/*  44:    */   private UserBalanceService userBalanceService;
/*  45: 57 */   private static final Logger log = LoggerFactory.getLogger(Registeruser.class);
/*  46:    */   
/*  47:    */   @ResponseBody
/*  48:    */   @RequestMapping(value={"/registeruser"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  49:    */   public ModelAndView registeruser(HttpServletRequest req, HttpServletResponse resp)
/*  50:    */   {
/*  51: 63 */     ModelAndView model = new ModelAndView();
/*  52: 64 */     Map<String, Object> map = new HashMap();
/*  53:    */     try
/*  54:    */     {
/*  55: 66 */       req.setCharacterEncoding("utf-8");
/*  56: 67 */       resp.setCharacterEncoding("utf-8");
/*  57:    */       
/*  58: 69 */       String useridentity = req.getParameter("useridentity");
/*  59: 70 */       String username = req.getParameter("username");
/*  60: 71 */       String trueusername = req.getParameter("trueusername");
/*  61: 72 */       String companyname = req.getParameter("companyaddress");
/*  62: 73 */       String companyaddress = req.getParameter("companyname");
/*  63: 74 */       String channelId = req.getParameter("channelId");
/*  64: 75 */       String pwd = req.getParameter("password");
/*  65:    */       
/*  66: 77 */       String sex = req.getParameter("sex");
/*  67: 78 */       String phone = req.getParameter("phone");
/*  68: 79 */       String state = req.getParameter("state");
/*  69: 80 */       String userexplain = req.getParameter("userexplain");
/*  70: 81 */       String REGISTERSTATE = "1";
/*  71: 82 */       String hxid = phone;
/*  72: 83 */       String publicity = req.getParameter("publicity");
/*  73: 84 */       String id = req.getParameter("id");
/*  74: 85 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  75: 86 */       String REGISTERDATE = df.format(new Date());
/*  76: 87 */       String panding = "";
/*  77:    */       
/*  78: 89 */       ModelAndView modelView = new ModelAndView();
/*  79: 90 */       Map<String, Object> userMap = new HashMap();
/*  80: 91 */       userMap.put("Useridentity", useridentity);
/*  81: 92 */       userMap.put("Username", username);
/*  82: 93 */       userMap.put("Trueusername", trueusername);
/*  83: 94 */       userMap.put("Companyaddress", companyaddress);
/*  84: 95 */       userMap.put("Companyname", companyname);
/*  85: 96 */       userMap.put("Password", pwd);
/*  86: 97 */       userMap.put("Sex", sex);
/*  87: 98 */       userMap.put("Phone", phone);
/*  88: 99 */       userMap.put("State", state);
/*  89:100 */       userMap.put("Userexplain", userexplain);
/*  90:101 */       userMap.put("Registerstate", REGISTERSTATE);
/*  91:102 */       userMap.put("Hxid", hxid);
/*  92:103 */       userMap.put("Registerdate", REGISTERDATE);
/*  93:104 */       userMap.put("Publicity", publicity);
/*  94:105 */       userMap.put("Id", id);
/*  95:    */       
/*  96:107 */       List<Map<String, Object>> list_rtn = this.userService.selectMydata(userMap);
/*  97:111 */       if (list_rtn.size() > 0)
/*  98:    */       {
/*  99:112 */         panding = "0";
/* 100:113 */         log.error(username + "该用户名已存在");
/* 101:    */       }
/* 102:    */       else
/* 103:    */       {
/* 104:116 */         if (StringUtils.isNotEmpty(channelId))
/* 105:    */         {
/* 106:117 */           userMap.put("ChannelId", channelId);
/* 107:    */         }
/* 108:    */         else
/* 109:    */         {
/* 110:119 */           channelId = "123";
/* 111:120 */           userMap.put("ChannelId", channelId);
/* 112:    */         }
/* 113:122 */         System.out.println(hxid + ":1111:" + userMap + ":channelId:" + channelId);
/* 114:    */         
/* 115:124 */         int i = this.userService.insertUserInfo(userMap);
/* 116:125 */         System.out.println(userMap);
/* 117:126 */         Map<String, Object> registMap = new HashMap();
/* 118:127 */         registMap.put("ReTime", i + "");
/* 119:128 */         registMap.put("UserName", username);
/* 120:129 */         this.errorInfoService.insertErrorInfo(registMap);
/* 121:130 */         if (i == 0)
/* 122:    */         {
/* 123:132 */           panding = "0";
/* 124:133 */           log.error(username + "对app软件的注册操作失败,其注册信息:" + userMap);
/* 125:    */         }
/* 126:134 */         else if (i > 0)
/* 127:    */         {
/* 128:140 */           String pwd1 = phone.substring(phone.length() - 6, phone
/* 129:141 */             .length());
/* 130:142 */           ObjectNode datanode = JsonNodeFactory.instance.objectNode();
/* 131:143 */           datanode.put("username", phone);
/* 132:144 */           datanode.put("password", pwd1);
/* 133:145 */           datanode.put("nickname", trueusername);
/* 134:146 */           System.out.println(trueusername + ";" + pwd1 + ";" + phone);
/* 135:    */           
/* 136:148 */           ObjectNode createNewIMUserSingleNode = EasemobIMUsers.createNewIMUserSingle(datanode);
/* 137:149 */           if (null != createNewIMUserSingleNode)
/* 138:    */           {
/* 139:150 */             EasemobIMUsers.LOGGER.info("注册IM用户[单个]: " + createNewIMUserSingleNode
/* 140:151 */               .toString());
/* 141:    */             
/* 142:153 */             String fanhuizhi = createNewIMUserSingleNode.toString();
/* 143:154 */             JSONObject json = JSONObject.fromObject(fanhuizhi);
/* 144:155 */             String zhuangtaima = json.getString("statusCode");
/* 145:156 */             if ((!"".equals(zhuangtaima)) && 
/* 146:157 */               ("200".equals(zhuangtaima)))
/* 147:    */             {
/* 148:159 */               panding = "1";
/* 149:    */               
/* 150:    */ 
/* 151:    */ 
/* 152:163 */               Map<String, Object> map1 = new HashMap();
/* 153:    */               
/* 154:165 */               map1.put("Username", username);
/* 155:166 */               map1.put("Userphone", phone);
/* 156:167 */               map1.put("Friendstatr", "1");
/* 157:168 */               map1.put("FriendUsername", "15588892250");
/* 158:169 */               map1.put("Friendphone", "15588892250");
/* 159:170 */               this.friendService.insertFriend(map1);
/* 160:171 */               EasemobIMUsers.addFriendSingle(username, "15588892250");
/* 161:    */               
/* 162:    */ 
/* 163:    */ 
/* 164:    */ 
/* 165:176 */               JcUserBalance jcUserBalance = new JcUserBalance();
/* 166:177 */               jcUserBalance.setUsername(username);
/* 167:178 */               jcUserBalance.setPurpose("INIT");
/* 168:179 */               jcUserBalance.setRemark("注册成功,并向用户虚拟余额内充值￥100.");
/* 169:180 */               jcUserBalance.setId(null);
/* 170:181 */               jcUserBalance.setOperdate(new Date());
/* 171:182 */               this.userBalanceService.insertSelective(jcUserBalance);
/* 172:    */             }
/* 173:184 */             else if ((!"".equals(zhuangtaima)) && 
/* 174:185 */               (!"200".equals(zhuangtaima)))
/* 175:    */             {
/* 176:186 */               panding = "2";
/* 177:187 */               for (int j = 0; j < 2; j++)
/* 178:    */               {
/* 179:189 */                 createNewIMUserSingleNode = EasemobIMUsers.createNewIMUserSingle(datanode);
/* 180:    */                 
/* 181:191 */                 fanhuizhi = createNewIMUserSingleNode.toString();
/* 182:192 */                 json = JSONObject.fromObject(fanhuizhi);
/* 183:193 */                 zhuangtaima = json.getString("statusCode");
/* 184:194 */                 if ((!"".equals(zhuangtaima)) && 
/* 185:195 */                   ("200".equals(zhuangtaima)))
/* 186:    */                 {
/* 187:196 */                   panding = "1";
/* 188:197 */                   break;
/* 189:    */                 }
/* 190:199 */                 panding = "2";
/* 191:200 */                 String errorTime = df.format(new Date());
/* 192:201 */                 Map<String, Object> errorMap = new HashMap();
/* 193:202 */                 errorMap.put("CodeStatus", zhuangtaima);
/* 194:203 */                 errorMap.put("UserName", username);
/* 195:204 */                 errorMap.put("ErrorTime", errorTime);
/* 196:    */                 
/* 197:206 */                 this.errorInfoService.updateErrorInfo(errorMap);
/* 198:    */               }
/* 199:210 */               this.userService.deletetUserInfo(userMap);
/* 200:    */             }
/* 201:    */           }
/* 202:    */         }
/* 203:    */       }
/* 204:216 */       map.put("data", panding);
/* 205:217 */       model.addAllObjects(map);
/* 206:218 */       return model;
/* 207:    */     }
/* 208:    */     catch (Exception ex)
/* 209:    */     {
/* 210:220 */       ex.printStackTrace();
/* 211:221 */       map.put("error", ex.getMessage());
/* 212:222 */       model.addAllObjects(map);
/* 213:    */     }
/* 214:223 */     return model;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public static boolean isNumeric(String str)
/* 218:    */   {
/* 219:228 */     Pattern pattern = Pattern.compile("[0-9]*");
/* 220:229 */     Matcher isNum = pattern.matcher(str);
/* 221:230 */     if (!isNum.matches()) {
/* 222:231 */       return false;
/* 223:    */     }
/* 224:233 */     return true;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public static void main(String[] args)
/* 228:    */   {
/* 229:237 */     String s = MD5.GetMD5String("666666");
/* 230:238 */     System.out.println(s);
/* 231:    */   }
/* 232:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Registeruser

 * JD-Core Version:    0.7.0.1

 */