/*   1:    */ package com.brave.system.controller;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.NewService;
/*   4:    */ import com.brave.system.entity.NewsEntity;
/*   5:    */ import com.brave.system.entity.NewsEntityExample;
/*   6:    */ import com.brave.system.entity.NewsEntityExample.Criteria;
/*   7:    */ import com.brave.system.util.PageUtils;
/*   8:    */ import java.text.SimpleDateFormat;
/*   9:    */ import java.util.Date;
/*  10:    */ import java.util.HashMap;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.Map;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  16:    */ import org.springframework.context.annotation.Scope;
/*  17:    */ import org.springframework.security.core.Authentication;
/*  18:    */ import org.springframework.security.core.context.SecurityContext;
/*  19:    */ import org.springframework.security.core.context.SecurityContextHolder;
/*  20:    */ import org.springframework.security.core.userdetails.UserDetails;
/*  21:    */ import org.springframework.stereotype.Controller;
/*  22:    */ import org.springframework.ui.ModelMap;
/*  23:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  24:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  25:    */ 
/*  26:    */ @Controller
/*  27:    */ @Scope("prototype")
/*  28:    */ @RequestMapping({"/system/news"})
/*  29:    */ public class NewsController
/*  30:    */ {
/*  31: 41 */   private static int PageRecorders = 10;
/*  32:    */   @Autowired
/*  33:    */   private NewService newService;
/*  34:    */   
/*  35:    */   @ResponseBody
/*  36:    */   @RequestMapping(value={"/deleteNews"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  37:    */   public void deleteNews(HttpServletRequest request, HttpServletResponse response, String newsId)
/*  38:    */   {
/*  39:    */     try
/*  40:    */     {
/*  41: 52 */       this.newService.deleteByPrimaryKey(newsId);
/*  42:    */     }
/*  43:    */     catch (Exception ex)
/*  44:    */     {
/*  45: 56 */       ex.printStackTrace();
/*  46:    */     }
/*  47:    */   }
/*  48:    */   
/*  49:    */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  50:    */   public String edit(HttpServletRequest request, HttpServletResponse response, String newId, ModelMap model)
/*  51:    */   {
/*  52:    */     try
/*  53:    */     {
/*  54: 65 */       model.addAttribute("newId", newId);
/*  55: 66 */       return "system/news/edit";
/*  56:    */     }
/*  57:    */     catch (Exception ex)
/*  58:    */     {
/*  59: 69 */       ex.printStackTrace();
/*  60:    */     }
/*  61: 70 */     return "system/news/edit";
/*  62:    */   }
/*  63:    */   
/*  64:    */   @RequestMapping({"/list"})
/*  65:    */   public String list(HttpServletRequest request, HttpServletResponse response)
/*  66:    */   {
/*  67:    */     try
/*  68:    */     {
/*  69: 83 */       return "system/news/list";
/*  70:    */     }
/*  71:    */     catch (Exception ex)
/*  72:    */     {
/*  73: 86 */       ex.printStackTrace();
/*  74:    */     }
/*  75: 87 */     return "system/news/list";
/*  76:    */   }
/*  77:    */   
/*  78:    */   @ResponseBody
/*  79:    */   @RequestMapping(value={"/getNewsList"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  80:    */   public Map<String, Object> getNewsList(HttpServletRequest request, HttpServletResponse response, String titleName, String authorName, String beginDate, String endDate, int pages)
/*  81:    */   {
/*  82:106 */     response.setCharacterEncoding("UTF-8");
/*  83:107 */     Map<String, Object> map = new HashMap();
/*  84:    */     try
/*  85:    */     {
/*  86:111 */       if (0 == pages) {
/*  87:113 */         pages = 1;
/*  88:    */       }
/*  89:115 */       NewsEntityExample example = new NewsEntityExample();
/*  90:116 */       NewsEntityExample.Criteria criteria = example.createCriteria();
/*  91:118 */       if ((null != titleName) && (!"".equals(titleName))) {
/*  92:120 */         criteria.andTitleLike("%" + titleName + "%");
/*  93:    */       }
/*  94:122 */       if ((null != authorName) && (!"".equals(authorName))) {
/*  95:124 */         criteria.andAuthorLike("%" + authorName + "%");
/*  96:    */       }
/*  97:126 */       long listSize = 0L;
/*  98:127 */       List<NewsEntity> newsEntityList = this.newService.selectByExample(example);
/*  99:128 */       if ((null != newsEntityList) && (0 < newsEntityList.size())) {
/* 100:130 */         listSize = newsEntityList.size();
/* 101:    */       }
/* 102:132 */       example.setLimitStart(Integer.valueOf((pages - 1) * PageRecorders));
/* 103:133 */       example.setLimitEnd(Integer.valueOf(PageRecorders));
/* 104:    */       
/* 105:135 */       List<NewsEntity> finalNewsEntityList = this.newService.selectByExample(example);
/* 106:    */       
/* 107:    */ 
/* 108:138 */       map.put("lists", finalNewsEntityList);
/* 109:    */       
/* 110:140 */       map.put("listSize", Long.valueOf(listSize));
/* 111:141 */       map.put("pagenation", PageUtils.getPagenationInfo(listSize, pages, "goPage"));
/* 112:    */       
/* 113:143 */       return map;
/* 114:    */     }
/* 115:    */     catch (Exception ex)
/* 116:    */     {
/* 117:146 */       ex.printStackTrace();
/* 118:147 */       map.put("error", ex.getMessage());
/* 119:    */     }
/* 120:148 */     return map;
/* 121:    */   }
/* 122:    */   
/* 123:    */   @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 124:    */   public String index(HttpServletRequest request, HttpServletResponse response, String newId, ModelMap model)
/* 125:    */   {
/* 126:    */     try
/* 127:    */     {
/* 128:157 */       model.addAttribute("newId", newId);
/* 129:158 */       return "system/news/index";
/* 130:    */     }
/* 131:    */     catch (Exception ex)
/* 132:    */     {
/* 133:161 */       ex.printStackTrace();
/* 134:    */     }
/* 135:162 */     return "system/news/index";
/* 136:    */   }
/* 137:    */   
/* 138:    */   @ResponseBody
/* 139:    */   @RequestMapping(value={"/loadContent"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 140:    */   public Map<String, Object> loadContent(HttpServletRequest request, HttpServletResponse response, String newId)
/* 141:    */   {
/* 142:170 */     Map<String, Object> resultMap = new HashMap();
/* 143:    */     try
/* 144:    */     {
/* 145:173 */       NewsEntity entity = this.newService.selectByPrimaryKey(newId);
/* 146:174 */       resultMap.put("newsEntity", entity);
/* 147:175 */       return resultMap;
/* 148:    */     }
/* 149:    */     catch (Exception ex)
/* 150:    */     {
/* 151:178 */       ex.printStackTrace();
/* 152:179 */       resultMap.put("error", ex.getMessage());
/* 153:    */     }
/* 154:180 */     return resultMap;
/* 155:    */   }
/* 156:    */   
/* 157:    */   @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 158:    */   public String add(HttpServletRequest request, HttpServletResponse response)
/* 159:    */   {
/* 160:    */     try
/* 161:    */     {
/* 162:192 */       return "system/news/add";
/* 163:    */     }
/* 164:    */     catch (Exception ex)
/* 165:    */     {
/* 166:195 */       ex.printStackTrace();
/* 167:    */     }
/* 168:196 */     return "system/news/add";
/* 169:    */   }
/* 170:    */   
/* 171:    */   @ResponseBody
/* 172:    */   @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 173:    */   public Map<String, Object> save(String author, String title, String content, String files)
/* 174:    */   {
/* 175:204 */     Map<String, Object> resultMap = new HashMap();
/* 176:    */     try
/* 177:    */     {
/* 178:209 */       UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
/* 179:210 */       String userName = userDetails.getUsername();
/* 180:211 */       if ("".equals(author)) {
/* 181:213 */         author = "管理员";
/* 182:    */       }
/* 183:215 */       Date date = new Date();
/* 184:216 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 185:217 */       SimpleDateFormat fileSdf = new SimpleDateFormat("yyyy");
/* 186:218 */       String issuetime = sdf.format(date);
/* 187:    */       
/* 188:    */ 
/* 189:    */ 
/* 190:    */ 
/* 191:223 */       files = "http://inf.shandongjinchi.com/image/" + fileSdf.format(date) + "/" + files;
/* 192:224 */       NewsEntity newsEntity = new NewsEntity();
/* 193:225 */       newsEntity.setNewsid(null);
/* 194:226 */       newsEntity.setTitle(title);
/* 195:227 */       newsEntity.setIssuetime(issuetime);
/* 196:228 */       newsEntity.setAuthor(author);
/* 197:229 */       newsEntity.setContent(content);
/* 198:230 */       newsEntity.setUsername(userName);
/* 199:231 */       newsEntity.setUrl("");
/* 200:232 */       newsEntity.setHeadimage(files);
/* 201:233 */       this.newService.insertSelective(newsEntity);
/* 202:234 */       resultMap.put("Result", "SUCCESS");
/* 203:235 */       return resultMap;
/* 204:    */     }
/* 205:    */     catch (Exception ex)
/* 206:    */     {
/* 207:238 */       ex.printStackTrace();
/* 208:239 */       resultMap.put("Result", "ERROR");
/* 209:    */     }
/* 210:240 */     return resultMap;
/* 211:    */   }
/* 212:    */   
/* 213:    */   @ResponseBody
/* 214:    */   @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 215:    */   public Map<String, Object> update(String newsId, String author, String title, String content, String files)
/* 216:    */   {
/* 217:248 */     Map<String, Object> resultMap = new HashMap();
/* 218:    */     try
/* 219:    */     {
/* 220:253 */       UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
/* 221:254 */       String userName = userDetails.getUsername();
/* 222:255 */       if ("".equals(author)) {
/* 223:257 */         author = "管理员";
/* 224:    */       }
/* 225:259 */       Date date = new Date();
/* 226:260 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 227:261 */       SimpleDateFormat fileSdf = new SimpleDateFormat("yyyy");
/* 228:262 */       String issuetime = sdf.format(date);
/* 229:    */       
/* 230:    */ 
/* 231:    */ 
/* 232:    */ 
/* 233:267 */       files = "http://inf.shandongjinchi.com/image/" + fileSdf.format(date) + "/" + files;
/* 234:268 */       NewsEntity newsEntity = new NewsEntity();
/* 235:269 */       newsEntity.setNewsid(newsId);
/* 236:270 */       newsEntity.setTitle(title);
/* 237:271 */       newsEntity.setIssuetime(issuetime);
/* 238:272 */       newsEntity.setAuthor(author);
/* 239:273 */       newsEntity.setContent(content);
/* 240:274 */       newsEntity.setUsername(userName);
/* 241:275 */       newsEntity.setUrl("");
/* 242:276 */       newsEntity.setHeadimage(files);
/* 243:277 */       this.newService.updateByPrimaryKey(newsEntity);
/* 244:278 */       resultMap.put("Result", "SUCCESS");
/* 245:279 */       return resultMap;
/* 246:    */     }
/* 247:    */     catch (Exception ex)
/* 248:    */     {
/* 249:282 */       ex.printStackTrace();
/* 250:283 */       resultMap.put("Result", "ERROR");
/* 251:    */     }
/* 252:284 */     return resultMap;
/* 253:    */   }
/* 254:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.controller.NewsController

 * JD-Core Version:    0.7.0.1

 */