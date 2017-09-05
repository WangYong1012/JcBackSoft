/*   1:    */ package com.brave.system.entity;
/*   2:    */ 
/*   3:    */ public class UserInfo
/*   4:    */   extends UserInfoKey
/*   5:    */ {
/*   6:    */   private String hxid;
/*   7:    */   private String password;
/*   8:    */   private String state;
/*   9:    */   private String sex;
/*  10:    */   private String phone;
/*  11:    */   private String registerstate;
/*  12:    */   private String companyaddress;
/*  13:    */   private String companyname;
/*  14:    */   private String trueusername;
/*  15:    */   private String registerdate;
/*  16:    */   private String loginleftdate;
/*  17:    */   private String checkdate;
/*  18:    */   private String operationdate;
/*  19:    */   private String channelid;
/*  20:    */   private String longitude;
/*  21:    */   private String latitude;
/*  22:    */   private String terminalstate;
/*  23:    */   private String pushStatrSupporters;
/*  24:    */   private String pushMusic;
/*  25:    */   private String pushStartInvoice;
/*  26:    */   private String days;
/*  27:    */   private String qiandaotime;
/*  28:    */   private String userexplain;
/*  29:    */   private String photourl;
/*  30:    */   private String publicity;
/*  31:    */   private String area;
/*  32:    */   private String adver;
/*  33:    */   private String iosver;
/*  34:    */   private String plat;
/*  35:    */   private String score;
/*  36:    */   private String sumdays;
/*  37:    */   private String sharenum;
/*  38:    */   private String sharetime;
/*  39:    */   private String grouptime;
/*  40:    */   private String authenticationstatus;
/*  41:    */   private String useridentity;
/*  42:    */   private String totalsharetimes;
/*  43:    */   private String sharetimes;
/*  44:    */   private String lastsharetime;
/*  45:    */   
/*  46:    */   public String getHxid()
/*  47:    */   {
/*  48: 83 */     return this.hxid;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setHxid(String hxid)
/*  52:    */   {
/*  53: 87 */     this.hxid = (hxid == null ? null : hxid.trim());
/*  54:    */   }
/*  55:    */   
/*  56:    */   public String getPassword()
/*  57:    */   {
/*  58: 91 */     return this.password;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setPassword(String password)
/*  62:    */   {
/*  63: 95 */     this.password = (password == null ? null : password.trim());
/*  64:    */   }
/*  65:    */   
/*  66:    */   public String getState()
/*  67:    */   {
/*  68: 99 */     return this.state;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setState(String state)
/*  72:    */   {
/*  73:103 */     this.state = (state == null ? null : state.trim());
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String getSex()
/*  77:    */   {
/*  78:107 */     return this.sex;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setSex(String sex)
/*  82:    */   {
/*  83:111 */     this.sex = (sex == null ? null : sex.trim());
/*  84:    */   }
/*  85:    */   
/*  86:    */   public String getPhone()
/*  87:    */   {
/*  88:115 */     return this.phone;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setPhone(String phone)
/*  92:    */   {
/*  93:119 */     this.phone = (phone == null ? null : phone.trim());
/*  94:    */   }
/*  95:    */   
/*  96:    */   public String getRegisterstate()
/*  97:    */   {
/*  98:123 */     return this.registerstate;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setRegisterstate(String registerstate)
/* 102:    */   {
/* 103:127 */     this.registerstate = (registerstate == null ? null : registerstate.trim());
/* 104:    */   }
/* 105:    */   
/* 106:    */   public String getCompanyaddress()
/* 107:    */   {
/* 108:131 */     return this.companyaddress;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setCompanyaddress(String companyaddress)
/* 112:    */   {
/* 113:135 */     this.companyaddress = (companyaddress == null ? null : companyaddress.trim());
/* 114:    */   }
/* 115:    */   
/* 116:    */   public String getCompanyname()
/* 117:    */   {
/* 118:139 */     return this.companyname;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setCompanyname(String companyname)
/* 122:    */   {
/* 123:143 */     this.companyname = (companyname == null ? null : companyname.trim());
/* 124:    */   }
/* 125:    */   
/* 126:    */   public String getTrueusername()
/* 127:    */   {
/* 128:147 */     return this.trueusername;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setTrueusername(String trueusername)
/* 132:    */   {
/* 133:151 */     this.trueusername = (trueusername == null ? null : trueusername.trim());
/* 134:    */   }
/* 135:    */   
/* 136:    */   public String getRegisterdate()
/* 137:    */   {
/* 138:155 */     return this.registerdate;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public void setRegisterdate(String registerdate)
/* 142:    */   {
/* 143:159 */     this.registerdate = (registerdate == null ? null : registerdate.trim());
/* 144:    */   }
/* 145:    */   
/* 146:    */   public String getLoginleftdate()
/* 147:    */   {
/* 148:163 */     return this.loginleftdate;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public void setLoginleftdate(String loginleftdate)
/* 152:    */   {
/* 153:167 */     this.loginleftdate = (loginleftdate == null ? null : loginleftdate.trim());
/* 154:    */   }
/* 155:    */   
/* 156:    */   public String getCheckdate()
/* 157:    */   {
/* 158:171 */     return this.checkdate;
/* 159:    */   }
/* 160:    */   
/* 161:    */   public void setCheckdate(String checkdate)
/* 162:    */   {
/* 163:175 */     this.checkdate = (checkdate == null ? null : checkdate.trim());
/* 164:    */   }
/* 165:    */   
/* 166:    */   public String getOperationdate()
/* 167:    */   {
/* 168:179 */     return this.operationdate;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public void setOperationdate(String operationdate)
/* 172:    */   {
/* 173:183 */     this.operationdate = (operationdate == null ? null : operationdate.trim());
/* 174:    */   }
/* 175:    */   
/* 176:    */   public String getChannelid()
/* 177:    */   {
/* 178:187 */     return this.channelid;
/* 179:    */   }
/* 180:    */   
/* 181:    */   public void setChannelid(String channelid)
/* 182:    */   {
/* 183:191 */     this.channelid = (channelid == null ? null : channelid.trim());
/* 184:    */   }
/* 185:    */   
/* 186:    */   public String getLongitude()
/* 187:    */   {
/* 188:195 */     return this.longitude;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public void setLongitude(String longitude)
/* 192:    */   {
/* 193:199 */     this.longitude = (longitude == null ? null : longitude.trim());
/* 194:    */   }
/* 195:    */   
/* 196:    */   public String getLatitude()
/* 197:    */   {
/* 198:203 */     return this.latitude;
/* 199:    */   }
/* 200:    */   
/* 201:    */   public void setLatitude(String latitude)
/* 202:    */   {
/* 203:207 */     this.latitude = (latitude == null ? null : latitude.trim());
/* 204:    */   }
/* 205:    */   
/* 206:    */   public String getTerminalstate()
/* 207:    */   {
/* 208:211 */     return this.terminalstate;
/* 209:    */   }
/* 210:    */   
/* 211:    */   public void setTerminalstate(String terminalstate)
/* 212:    */   {
/* 213:215 */     this.terminalstate = (terminalstate == null ? null : terminalstate.trim());
/* 214:    */   }
/* 215:    */   
/* 216:    */   public String getPushStatrSupporters()
/* 217:    */   {
/* 218:219 */     return this.pushStatrSupporters;
/* 219:    */   }
/* 220:    */   
/* 221:    */   public void setPushStatrSupporters(String pushStatrSupporters)
/* 222:    */   {
/* 223:223 */     this.pushStatrSupporters = (pushStatrSupporters == null ? null : pushStatrSupporters.trim());
/* 224:    */   }
/* 225:    */   
/* 226:    */   public String getPushMusic()
/* 227:    */   {
/* 228:227 */     return this.pushMusic;
/* 229:    */   }
/* 230:    */   
/* 231:    */   public void setPushMusic(String pushMusic)
/* 232:    */   {
/* 233:231 */     this.pushMusic = (pushMusic == null ? null : pushMusic.trim());
/* 234:    */   }
/* 235:    */   
/* 236:    */   public String getPushStartInvoice()
/* 237:    */   {
/* 238:235 */     return this.pushStartInvoice;
/* 239:    */   }
/* 240:    */   
/* 241:    */   public void setPushStartInvoice(String pushStartInvoice)
/* 242:    */   {
/* 243:239 */     this.pushStartInvoice = (pushStartInvoice == null ? null : pushStartInvoice.trim());
/* 244:    */   }
/* 245:    */   
/* 246:    */   public String getDays()
/* 247:    */   {
/* 248:243 */     return this.days;
/* 249:    */   }
/* 250:    */   
/* 251:    */   public void setDays(String days)
/* 252:    */   {
/* 253:247 */     this.days = (days == null ? null : days.trim());
/* 254:    */   }
/* 255:    */   
/* 256:    */   public String getQiandaotime()
/* 257:    */   {
/* 258:251 */     return this.qiandaotime;
/* 259:    */   }
/* 260:    */   
/* 261:    */   public void setQiandaotime(String qiandaotime)
/* 262:    */   {
/* 263:255 */     this.qiandaotime = (qiandaotime == null ? null : qiandaotime.trim());
/* 264:    */   }
/* 265:    */   
/* 266:    */   public String getUserexplain()
/* 267:    */   {
/* 268:259 */     return this.userexplain;
/* 269:    */   }
/* 270:    */   
/* 271:    */   public void setUserexplain(String userexplain)
/* 272:    */   {
/* 273:263 */     this.userexplain = (userexplain == null ? null : userexplain.trim());
/* 274:    */   }
/* 275:    */   
/* 276:    */   public String getPhotourl()
/* 277:    */   {
/* 278:267 */     return this.photourl;
/* 279:    */   }
/* 280:    */   
/* 281:    */   public void setPhotourl(String photourl)
/* 282:    */   {
/* 283:271 */     this.photourl = (photourl == null ? null : photourl.trim());
/* 284:    */   }
/* 285:    */   
/* 286:    */   public String getPublicity()
/* 287:    */   {
/* 288:275 */     return this.publicity;
/* 289:    */   }
/* 290:    */   
/* 291:    */   public void setPublicity(String publicity)
/* 292:    */   {
/* 293:279 */     this.publicity = (publicity == null ? null : publicity.trim());
/* 294:    */   }
/* 295:    */   
/* 296:    */   public String getArea()
/* 297:    */   {
/* 298:283 */     return this.area;
/* 299:    */   }
/* 300:    */   
/* 301:    */   public void setArea(String area)
/* 302:    */   {
/* 303:287 */     this.area = (area == null ? null : area.trim());
/* 304:    */   }
/* 305:    */   
/* 306:    */   public String getAdver()
/* 307:    */   {
/* 308:291 */     return this.adver;
/* 309:    */   }
/* 310:    */   
/* 311:    */   public void setAdver(String adver)
/* 312:    */   {
/* 313:295 */     this.adver = (adver == null ? null : adver.trim());
/* 314:    */   }
/* 315:    */   
/* 316:    */   public String getIosver()
/* 317:    */   {
/* 318:299 */     return this.iosver;
/* 319:    */   }
/* 320:    */   
/* 321:    */   public void setIosver(String iosver)
/* 322:    */   {
/* 323:303 */     this.iosver = (iosver == null ? null : iosver.trim());
/* 324:    */   }
/* 325:    */   
/* 326:    */   public String getPlat()
/* 327:    */   {
/* 328:307 */     return this.plat;
/* 329:    */   }
/* 330:    */   
/* 331:    */   public void setPlat(String plat)
/* 332:    */   {
/* 333:311 */     this.plat = (plat == null ? null : plat.trim());
/* 334:    */   }
/* 335:    */   
/* 336:    */   public String getScore()
/* 337:    */   {
/* 338:315 */     return this.score;
/* 339:    */   }
/* 340:    */   
/* 341:    */   public void setScore(String score)
/* 342:    */   {
/* 343:319 */     this.score = (score == null ? null : score.trim());
/* 344:    */   }
/* 345:    */   
/* 346:    */   public String getSumdays()
/* 347:    */   {
/* 348:323 */     return this.sumdays;
/* 349:    */   }
/* 350:    */   
/* 351:    */   public void setSumdays(String sumdays)
/* 352:    */   {
/* 353:327 */     this.sumdays = (sumdays == null ? null : sumdays.trim());
/* 354:    */   }
/* 355:    */   
/* 356:    */   public String getSharenum()
/* 357:    */   {
/* 358:331 */     return this.sharenum;
/* 359:    */   }
/* 360:    */   
/* 361:    */   public void setSharenum(String sharenum)
/* 362:    */   {
/* 363:335 */     this.sharenum = (sharenum == null ? null : sharenum.trim());
/* 364:    */   }
/* 365:    */   
/* 366:    */   public String getSharetime()
/* 367:    */   {
/* 368:339 */     return this.sharetime;
/* 369:    */   }
/* 370:    */   
/* 371:    */   public void setSharetime(String sharetime)
/* 372:    */   {
/* 373:343 */     this.sharetime = (sharetime == null ? null : sharetime.trim());
/* 374:    */   }
/* 375:    */   
/* 376:    */   public String getGrouptime()
/* 377:    */   {
/* 378:347 */     return this.grouptime;
/* 379:    */   }
/* 380:    */   
/* 381:    */   public void setGrouptime(String grouptime)
/* 382:    */   {
/* 383:351 */     this.grouptime = (grouptime == null ? null : grouptime.trim());
/* 384:    */   }
/* 385:    */   
/* 386:    */   public String getAuthenticationstatus()
/* 387:    */   {
/* 388:355 */     return this.authenticationstatus;
/* 389:    */   }
/* 390:    */   
/* 391:    */   public void setAuthenticationstatus(String authenticationstatus)
/* 392:    */   {
/* 393:359 */     this.authenticationstatus = (authenticationstatus == null ? null : authenticationstatus.trim());
/* 394:    */   }
/* 395:    */   
/* 396:    */   public String getUseridentity()
/* 397:    */   {
/* 398:363 */     return this.useridentity;
/* 399:    */   }
/* 400:    */   
/* 401:    */   public void setUseridentity(String useridentity)
/* 402:    */   {
/* 403:367 */     this.useridentity = (useridentity == null ? null : useridentity.trim());
/* 404:    */   }
/* 405:    */   
/* 406:    */   public String getTotalsharetimes()
/* 407:    */   {
/* 408:371 */     return this.totalsharetimes;
/* 409:    */   }
/* 410:    */   
/* 411:    */   public void setTotalsharetimes(String totalsharetimes)
/* 412:    */   {
/* 413:375 */     this.totalsharetimes = (totalsharetimes == null ? null : totalsharetimes.trim());
/* 414:    */   }
/* 415:    */   
/* 416:    */   public String getSharetimes()
/* 417:    */   {
/* 418:379 */     return this.sharetimes;
/* 419:    */   }
/* 420:    */   
/* 421:    */   public void setSharetimes(String sharetimes)
/* 422:    */   {
/* 423:383 */     this.sharetimes = (sharetimes == null ? null : sharetimes.trim());
/* 424:    */   }
/* 425:    */   
/* 426:    */   public String getLastsharetime()
/* 427:    */   {
/* 428:387 */     return this.lastsharetime;
/* 429:    */   }
/* 430:    */   
/* 431:    */   public void setLastsharetime(String lastsharetime)
/* 432:    */   {
/* 433:391 */     this.lastsharetime = (lastsharetime == null ? null : lastsharetime.trim());
/* 434:    */   }
/* 435:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.entity.UserInfo

 * JD-Core Version:    0.7.0.1

 */