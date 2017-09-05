/*   1:    */ package com.brave.system.controller;
/*   2:    */ 
/*   3:    */ import com.brave.system.entity.UserInfo;
/*   4:    */ import com.brave.system.entity.UserInfoExample;
/*   5:    */ import com.brave.system.entity.UserInfoExample.Criteria;
/*   6:    */ import com.brave.system.service.IUserInfoService;
/*   7:    */ import com.brave.system.util.PageUtils;
/*   8:    */ import java.io.IOException;
/*   9:    */ import java.io.PrintWriter;
/*  10:    */ import java.text.SimpleDateFormat;
/*  11:    */ import java.util.ArrayList;
/*  12:    */ import java.util.Calendar;
/*  13:    */ import java.util.Date;
/*  14:    */ import java.util.HashMap;
/*  15:    */ import java.util.List;
/*  16:    */ import java.util.Map;
/*  17:    */ import javax.servlet.http.HttpServletRequest;
/*  18:    */ import javax.servlet.http.HttpServletResponse;
/*  19:    */ import net.sf.json.JSONObject;
/*  20:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  21:    */ import org.springframework.context.annotation.Scope;
/*  22:    */ import org.springframework.stereotype.Controller;
/*  23:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  24:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  25:    */ 
/*  26:    */ @Controller
/*  27:    */ @RequestMapping({"/system/user"})
/*  28:    */ @Scope("prototype")
/*  29:    */ public class UserController
/*  30:    */ {
/*  31: 34 */   private static int PageRecorders = 10;
/*  32:    */   @Autowired
/*  33:    */   private IUserInfoService userInfoMapper;
/*  34:    */   
/*  35:    */   @RequestMapping(value={"/pie"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  36:    */   public String pie(HttpServletRequest request, HttpServletResponse response)
/*  37:    */   {
/*  38: 42 */     return "system/query_pie";
/*  39:    */   }
/*  40:    */   
/*  41:    */   @ResponseBody
/*  42:    */   @RequestMapping(value={"/getUserList"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  43:    */   public Map<String, Object> getUserList(HttpServletRequest request, HttpServletResponse response, int pages, String loginName, String userName)
/*  44:    */   {
/*  45: 50 */     response.setCharacterEncoding("UTF-8");
/*  46:    */     try
/*  47:    */     {
/*  48: 53 */       Map<String, Object> map = new HashMap();
/*  49: 54 */       if (0 == pages) {
/*  50: 56 */         pages = 1;
/*  51:    */       }
/*  52: 58 */       UserInfoExample example = new UserInfoExample();
/*  53: 59 */       UserInfoExample.Criteria criteria = example.createCriteria();
/*  54: 61 */       if ((null != loginName) && (!"".equals(loginName))) {
/*  55: 63 */         criteria.andUsernameLike("%" + loginName + "%");
/*  56:    */       }
/*  57: 65 */       if ((null != userName) && (!"".equals(userName))) {
/*  58: 67 */         criteria.andTrueusernameLike("%" + userName + "%");
/*  59:    */       }
/*  60: 69 */       long listSize = 0L;
/*  61: 70 */       if ((null != this.userInfoMapper.selectByExample(example)) && (0 < this.userInfoMapper.selectByExample(example).size())) {
/*  62: 72 */         listSize = this.userInfoMapper.selectByExample(example).size();
/*  63:    */       }
/*  64: 74 */       example.setLimitStart(Integer.valueOf((pages - 1) * PageRecorders));
/*  65: 75 */       example.setLimitEnd(Integer.valueOf(PageRecorders));
/*  66: 76 */       List<UserInfo> userInfoList = this.userInfoMapper.selectByExample(example);
/*  67:    */       
/*  68:    */ 
/*  69: 79 */       map.put("lists", userInfoList);
/*  70:    */       
/*  71: 81 */       map.put("listSize", Long.valueOf(listSize));
/*  72: 82 */       map.put("pagenation", PageUtils.getPagenationInfo(listSize, pages, "goPage"));
/*  73: 83 */       return map;
/*  74:    */     }
/*  75:    */     catch (Exception ex)
/*  76:    */     {
/*  77: 86 */       ex.printStackTrace();
/*  78:    */     }
/*  79: 87 */     return null;
/*  80:    */   }
/*  81:    */   
/*  82:    */   @ResponseBody
/*  83:    */   @RequestMapping(value={"/userinfo2d"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  84:    */   public void userinfo2d(HttpServletRequest request, HttpServletResponse response, String beginDate, String endDate)
/*  85:    */   {
/*  86:101 */     Map<String, Object> resultMap = new HashMap();
/*  87:    */     try
/*  88:    */     {
/*  89:105 */       beginDate = beginDate == null ? "" : beginDate;
/*  90:106 */       endDate = endDate == null ? "" : endDate;
/*  91:    */       
/*  92:108 */       response.setCharacterEncoding("UTF-8");
/*  93:109 */       request.setCharacterEncoding("UTF-8");
/*  94:    */       
/*  95:111 */       Map<String, Object> chartDescription = new HashMap();
/*  96:112 */       chartDescription.put("caption", "最近一段时间内用户注册量");
/*  97:113 */       chartDescription.put("subCaption", "报表");
/*  98:114 */       chartDescription.put("xAxisName", "日期 (年/月/日)");
/*  99:115 */       chartDescription.put("yAxisName", "注册数量 (人)");
/* 100:116 */       chartDescription.put("theme", "fint");
/* 101:117 */       resultMap.put("chart", chartDescription);
/* 102:    */       
/* 103:119 */       Map<String, Object> param = new HashMap();
/* 104:121 */       if (("".equals(beginDate)) && ("".equals(endDate)))
/* 105:    */       {
/* 106:123 */         Date today = new Date();
/* 107:124 */         SimpleDateFormat startFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 108:125 */         SimpleDateFormat endFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 109:126 */         endDate = endFormat.format(today);
/* 110:127 */         Calendar calendar = Calendar.getInstance();
/* 111:128 */         calendar.setTime(today);
/* 112:129 */         calendar.set(5, calendar.get(5) - 7);
/* 113:130 */         beginDate = startFormat.format(calendar.getTime());
/* 114:131 */         param.put("beginDate", beginDate);
/* 115:132 */         param.put("endDate", endDate);
/* 116:    */       }
/* 117:    */       else
/* 118:    */       {
/* 119:135 */         param.put("beginDate", beginDate);
/* 120:136 */         param.put("endDate", endDate);
/* 121:    */       }
/* 122:139 */       List<Map<String, Object>> resultList = new ArrayList();
/* 123:140 */       resultList = this.userInfoMapper.userinfo2d(param);
/* 124:141 */       resultMap.put("data", resultList);
/* 125:    */       
/* 126:143 */       JSONObject json = JSONObject.fromObject(resultMap);
/* 127:144 */       response.getWriter().print(json.toString());
/* 128:    */     }
/* 129:    */     catch (Exception ex)
/* 130:    */     {
/* 131:147 */       ex.printStackTrace();
/* 132:    */     }
/* 133:    */   }
/* 134:    */   
/* 135:    */   @ResponseBody
/* 136:    */   @RequestMapping(value={"/userinfopie"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 137:    */   public void userinfopie(HttpServletRequest request, HttpServletResponse response, String beginDate, String endDate, String property)
/* 138:    */   {
/* 139:156 */     Map<String, Object> resultMap = new HashMap();
/* 140:    */     try
/* 141:    */     {
/* 142:159 */       beginDate = beginDate == null ? "" : beginDate;
/* 143:160 */       endDate = endDate == null ? "" : endDate;
/* 144:    */       
/* 145:162 */       response.setCharacterEncoding("UTF-8");
/* 146:163 */       request.setCharacterEncoding("UTF-8");
/* 147:    */       
/* 148:165 */       Map<String, Object> chartDescription = new HashMap();
/* 149:166 */       chartDescription.put("caption", "最近一段时间内用户注册量");
/* 150:167 */       chartDescription.put("subCaption", "报表");
/* 151:168 */       chartDescription.put("showBorder", "0");
/* 152:169 */       chartDescription.put("use3DLighting", "0");
/* 153:170 */       chartDescription.put("enableSmartLabels", "0");
/* 154:171 */       chartDescription.put("startingAngle", "310");
/* 155:172 */       chartDescription.put("showLabels", "0");
/* 156:173 */       chartDescription.put("showPercentValues", "1");
/* 157:174 */       chartDescription.put("showLegend", "1");
/* 158:175 */       chartDescription.put("centerLabel", "$label 数量 : $value");
/* 159:176 */       chartDescription.put("centerLabelBold", "1");
/* 160:177 */       chartDescription.put("showTooltip", "0");
/* 161:178 */       chartDescription.put("decimals", "0");
/* 162:179 */       chartDescription.put("useDataPlotColorForLabels", "1");
/* 163:180 */       chartDescription.put("theme", "fint");
/* 164:    */       
/* 165:    */ 
/* 166:    */ 
/* 167:    */ 
/* 168:    */ 
/* 169:    */ 
/* 170:    */ 
/* 171:    */ 
/* 172:    */ 
/* 173:    */ 
/* 174:191 */       Map<String, Object> param = new HashMap();
/* 175:193 */       if (("".equals(beginDate)) && ("".equals(endDate)))
/* 176:    */       {
/* 177:195 */         Date today = new Date();
/* 178:196 */         SimpleDateFormat startFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 179:197 */         SimpleDateFormat endFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 180:198 */         endDate = endFormat.format(today);
/* 181:199 */         Calendar calendar = Calendar.getInstance();
/* 182:200 */         calendar.setTime(today);
/* 183:201 */         calendar.set(5, calendar.get(5) - 7);
/* 184:202 */         beginDate = startFormat.format(calendar.getTime());
/* 185:203 */         param.put("beginDate", beginDate);
/* 186:204 */         param.put("endDate", endDate);
/* 187:205 */         param.put("property", property);
/* 188:    */         
/* 189:207 */         int allCount = this.userInfoMapper.userinfopieAllCount(param);
/* 190:208 */         chartDescription.put("defaultCenterLabel", "总数量 : " + allCount);
/* 191:    */       }
/* 192:    */       else
/* 193:    */       {
/* 194:211 */         param.put("beginDate", beginDate);
/* 195:212 */         param.put("endDate", endDate);
/* 196:213 */         param.put("property", property);
/* 197:    */         
/* 198:215 */         int allCount = this.userInfoMapper.userinfopieAllCount(param);
/* 199:216 */         chartDescription.put("defaultCenterLabel", "总数量 : " + allCount);
/* 200:    */       }
/* 201:218 */       resultMap.put("chart", chartDescription);
/* 202:    */       
/* 203:220 */       List<Map<String, Object>> resultList = new ArrayList();
/* 204:221 */       resultList = this.userInfoMapper.userinfopiePlat(param);
/* 205:222 */       resultMap.put("data", resultList);
/* 206:    */       
/* 207:224 */       JSONObject json = JSONObject.fromObject(resultMap);
/* 208:225 */       response.getWriter().print(json.toString());
/* 209:    */     }
/* 210:    */     catch (Exception ex)
/* 211:    */     {
/* 212:228 */       ex.printStackTrace();
/* 213:    */     }
/* 214:    */   }
/* 215:    */   
/* 216:    */   @ResponseBody
/* 217:    */   @RequestMapping(value={"/existUser"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 218:    */   public void existUser(HttpServletRequest request, HttpServletResponse response, String username)
/* 219:    */   {
/* 220:236 */     Map<String, Object> param = new HashMap();
/* 221:    */     try
/* 222:    */     {
/* 223:239 */       response.setCharacterEncoding("UTF-8");
/* 224:240 */       request.setCharacterEncoding("UTF-8");
/* 225:    */       
/* 226:242 */       UserInfoExample example = new UserInfoExample();
/* 227:243 */       UserInfoExample.Criteria criteria = example.createCriteria();
/* 228:    */       
/* 229:245 */       criteria.andUsernameEqualTo(username);
/* 230:246 */       List<UserInfo> userInfoList = this.userInfoMapper.selectByExample(example);
/* 231:248 */       if ((null != userInfoList) && (0 < userInfoList.size()))
/* 232:    */       {
/* 233:250 */         param.put("resultCode", "SUCCESS");
/* 234:251 */         param.put("resultMsg", "存在的用户.");
/* 235:    */       }
/* 236:    */       else
/* 237:    */       {
/* 238:254 */         param.put("resultCode", "FAIL");
/* 239:255 */         param.put("resultMsg", "不存在的用户.");
/* 240:    */       }
/* 241:257 */       response.getWriter().print(JSONObject.fromObject(param).toString());
/* 242:    */     }
/* 243:    */     catch (Exception ex)
/* 244:    */     {
/* 245:    */       try
/* 246:    */       {
/* 247:262 */         param.put("resultCode", "FAIL");
/* 248:263 */         param.put("resultMsg", "查询出现错误.");
/* 249:264 */         response.getWriter().print(JSONObject.fromObject(param).toString());
/* 250:    */       }
/* 251:    */       catch (IOException ioe)
/* 252:    */       {
/* 253:267 */         ioe.printStackTrace();
/* 254:    */       }
/* 255:    */     }
/* 256:    */   }
/* 257:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.controller.UserController

 * JD-Core Version:    0.7.0.1

 */