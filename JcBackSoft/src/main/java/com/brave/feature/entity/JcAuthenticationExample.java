/*   1:    */ package com.brave.feature.entity;
/*   2:    */ 
/*   3:    */ import java.util.ArrayList;
/*   4:    */ import java.util.Iterator;
/*   5:    */ import java.util.List;
/*   6:    */ 
/*   7:    */ public class JcAuthenticationExample
/*   8:    */ {
/*   9:    */   protected String orderByClause;
/*  10:    */   protected boolean distinct;
/*  11:    */   protected List<Criteria> oredCriteria;
/*  12:    */   protected Integer limitStart;
/*  13:    */   protected Integer limitEnd;
/*  14:    */   
/*  15:    */   public JcAuthenticationExample()
/*  16:    */   {
/*  17: 20 */     this.oredCriteria = new ArrayList();
/*  18:    */   }
/*  19:    */   
/*  20:    */   public void setOrderByClause(String orderByClause)
/*  21:    */   {
/*  22: 24 */     this.orderByClause = orderByClause;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public String getOrderByClause()
/*  26:    */   {
/*  27: 28 */     return this.orderByClause;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void setDistinct(boolean distinct)
/*  31:    */   {
/*  32: 32 */     this.distinct = distinct;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public boolean isDistinct()
/*  36:    */   {
/*  37: 36 */     return this.distinct;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public List<Criteria> getOredCriteria()
/*  41:    */   {
/*  42: 40 */     return this.oredCriteria;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void or(Criteria criteria)
/*  46:    */   {
/*  47: 44 */     this.oredCriteria.add(criteria);
/*  48:    */   }
/*  49:    */   
/*  50:    */   public Criteria or()
/*  51:    */   {
/*  52: 48 */     Criteria criteria = createCriteriaInternal();
/*  53: 49 */     this.oredCriteria.add(criteria);
/*  54: 50 */     return criteria;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public Criteria createCriteria()
/*  58:    */   {
/*  59: 54 */     Criteria criteria = createCriteriaInternal();
/*  60: 55 */     if (this.oredCriteria.size() == 0) {
/*  61: 56 */       this.oredCriteria.add(criteria);
/*  62:    */     }
/*  63: 58 */     return criteria;
/*  64:    */   }
/*  65:    */   
/*  66:    */   protected Criteria createCriteriaInternal()
/*  67:    */   {
/*  68: 62 */     Criteria criteria = new Criteria();
/*  69: 63 */     return criteria;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void clear()
/*  73:    */   {
/*  74: 67 */     this.oredCriteria.clear();
/*  75: 68 */     this.orderByClause = null;
/*  76: 69 */     this.distinct = false;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setLimitStart(Integer limitStart)
/*  80:    */   {
/*  81: 73 */     this.limitStart = limitStart;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public Integer getLimitStart()
/*  85:    */   {
/*  86: 77 */     return this.limitStart;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setLimitEnd(Integer limitEnd)
/*  90:    */   {
/*  91: 81 */     this.limitEnd = limitEnd;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public Integer getLimitEnd()
/*  95:    */   {
/*  96: 85 */     return this.limitEnd;
/*  97:    */   }
/*  98:    */   
/*  99:    */   protected static abstract class GeneratedCriteria
/* 100:    */   {
/* 101:    */     protected List<Criterion> criteria;
/* 102:    */     
/* 103:    */     protected GeneratedCriteria()
/* 104:    */     {
/* 105: 93 */       this.criteria = new ArrayList();
/* 106:    */     }
/* 107:    */     
/* 108:    */     public boolean isValid()
/* 109:    */     {
/* 110: 97 */       return this.criteria.size() > 0;
/* 111:    */     }
/* 112:    */     
/* 113:    */     public List<Criterion> getAllCriteria()
/* 114:    */     {
/* 115:101 */       return this.criteria;
/* 116:    */     }
/* 117:    */     
/* 118:    */     public List<Criterion> getCriteria()
/* 119:    */     {
/* 120:105 */       return this.criteria;
/* 121:    */     }
/* 122:    */     
/* 123:    */     protected void addCriterion(String condition)
/* 124:    */     {
/* 125:109 */       if (condition == null) {
/* 126:110 */         throw new RuntimeException("Value for condition cannot be null");
/* 127:    */       }
/* 128:112 */       this.criteria.add(new Criterion(condition));
/* 129:    */     }
/* 130:    */     
/* 131:    */     protected void addCriterion(String condition, Object value, String property)
/* 132:    */     {
/* 133:116 */       if (value == null) {
/* 134:117 */         throw new RuntimeException("Value for " + property + " cannot be null");
/* 135:    */       }
/* 136:119 */       this.criteria.add(new Criterion(condition, value));
/* 137:    */     }
/* 138:    */     
/* 139:    */     protected void addCriterion(String condition, Object value1, Object value2, String property)
/* 140:    */     {
/* 141:123 */       if ((value1 == null) || (value2 == null)) {
/* 142:124 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/* 143:    */       }
/* 144:126 */       this.criteria.add(new Criterion(condition, value1, value2));
/* 145:    */     }
/* 146:    */     
/* 147:    */     protected void addCriterionForJDBCDate(String condition, java.util.Date value, String property)
/* 148:    */     {
/* 149:130 */       if (value == null) {
/* 150:131 */         throw new RuntimeException("Value for " + property + " cannot be null");
/* 151:    */       }
/* 152:133 */       addCriterion(condition, new java.sql.Date(value.getTime()), property);
/* 153:    */     }
/* 154:    */     
/* 155:    */     protected void addCriterionForJDBCDate(String condition, List<java.util.Date> values, String property)
/* 156:    */     {
/* 157:137 */       if ((values == null) || (values.size() == 0)) {
/* 158:138 */         throw new RuntimeException("Value list for " + property + " cannot be null or empty");
/* 159:    */       }
/* 160:140 */       List<java.sql.Date> dateList = new ArrayList();
/* 161:141 */       Iterator<java.util.Date> iter = values.iterator();
/* 162:142 */       while (iter.hasNext()) {
/* 163:143 */         dateList.add(new java.sql.Date(((java.util.Date)iter.next()).getTime()));
/* 164:    */       }
/* 165:145 */       addCriterion(condition, dateList, property);
/* 166:    */     }
/* 167:    */     
/* 168:    */     protected void addCriterionForJDBCDate(String condition, java.util.Date value1, java.util.Date value2, String property)
/* 169:    */     {
/* 170:149 */       if ((value1 == null) || (value2 == null)) {
/* 171:150 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/* 172:    */       }
/* 173:152 */       addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
/* 174:    */     }
/* 175:    */     
/* 176:    */     public Criteria andIdIsNull()
/* 177:    */     {
/* 178:156 */       addCriterion("JcAuthentication.id is null");
/* 179:157 */       return (Criteria)this;
/* 180:    */     }
/* 181:    */     
/* 182:    */     public Criteria andIdIsNotNull()
/* 183:    */     {
/* 184:161 */       addCriterion("JcAuthentication.id is not null");
/* 185:162 */       return (Criteria)this;
/* 186:    */     }
/* 187:    */     
/* 188:    */     public Criteria andIdEqualTo(Integer value)
/* 189:    */     {
/* 190:166 */       addCriterion("JcAuthentication.id =", value, "id");
/* 191:167 */       return (Criteria)this;
/* 192:    */     }
/* 193:    */     
/* 194:    */     public Criteria andIdNotEqualTo(Integer value)
/* 195:    */     {
/* 196:171 */       addCriterion("JcAuthentication.id <>", value, "id");
/* 197:172 */       return (Criteria)this;
/* 198:    */     }
/* 199:    */     
/* 200:    */     public Criteria andIdGreaterThan(Integer value)
/* 201:    */     {
/* 202:176 */       addCriterion("JcAuthentication.id >", value, "id");
/* 203:177 */       return (Criteria)this;
/* 204:    */     }
/* 205:    */     
/* 206:    */     public Criteria andIdGreaterThanOrEqualTo(Integer value)
/* 207:    */     {
/* 208:181 */       addCriterion("JcAuthentication.id >=", value, "id");
/* 209:182 */       return (Criteria)this;
/* 210:    */     }
/* 211:    */     
/* 212:    */     public Criteria andIdLessThan(Integer value)
/* 213:    */     {
/* 214:186 */       addCriterion("JcAuthentication.id <", value, "id");
/* 215:187 */       return (Criteria)this;
/* 216:    */     }
/* 217:    */     
/* 218:    */     public Criteria andIdLessThanOrEqualTo(Integer value)
/* 219:    */     {
/* 220:191 */       addCriterion("JcAuthentication.id <=", value, "id");
/* 221:192 */       return (Criteria)this;
/* 222:    */     }
/* 223:    */     
/* 224:    */     public Criteria andIdIn(List<Integer> values)
/* 225:    */     {
/* 226:196 */       addCriterion("JcAuthentication.id in", values, "id");
/* 227:197 */       return (Criteria)this;
/* 228:    */     }
/* 229:    */     
/* 230:    */     public Criteria andIdNotIn(List<Integer> values)
/* 231:    */     {
/* 232:201 */       addCriterion("JcAuthentication.id not in", values, "id");
/* 233:202 */       return (Criteria)this;
/* 234:    */     }
/* 235:    */     
/* 236:    */     public Criteria andIdBetween(Integer value1, Integer value2)
/* 237:    */     {
/* 238:206 */       addCriterion("JcAuthentication.id between", value1, value2, "id");
/* 239:207 */       return (Criteria)this;
/* 240:    */     }
/* 241:    */     
/* 242:    */     public Criteria andIdNotBetween(Integer value1, Integer value2)
/* 243:    */     {
/* 244:211 */       addCriterion("JcAuthentication.id not between", value1, value2, "id");
/* 245:212 */       return (Criteria)this;
/* 246:    */     }
/* 247:    */     
/* 248:    */     public Criteria andUsernameIsNull()
/* 249:    */     {
/* 250:216 */       addCriterion("JcAuthentication.username is null");
/* 251:217 */       return (Criteria)this;
/* 252:    */     }
/* 253:    */     
/* 254:    */     public Criteria andUsernameIsNotNull()
/* 255:    */     {
/* 256:221 */       addCriterion("JcAuthentication.username is not null");
/* 257:222 */       return (Criteria)this;
/* 258:    */     }
/* 259:    */     
/* 260:    */     public Criteria andUsernameEqualTo(String value)
/* 261:    */     {
/* 262:226 */       addCriterion("JcAuthentication.username =", value, "username");
/* 263:227 */       return (Criteria)this;
/* 264:    */     }
/* 265:    */     
/* 266:    */     public Criteria andUsernameNotEqualTo(String value)
/* 267:    */     {
/* 268:231 */       addCriterion("JcAuthentication.username <>", value, "username");
/* 269:232 */       return (Criteria)this;
/* 270:    */     }
/* 271:    */     
/* 272:    */     public Criteria andUsernameGreaterThan(String value)
/* 273:    */     {
/* 274:236 */       addCriterion("JcAuthentication.username >", value, "username");
/* 275:237 */       return (Criteria)this;
/* 276:    */     }
/* 277:    */     
/* 278:    */     public Criteria andUsernameGreaterThanOrEqualTo(String value)
/* 279:    */     {
/* 280:241 */       addCriterion("JcAuthentication.username >=", value, "username");
/* 281:242 */       return (Criteria)this;
/* 282:    */     }
/* 283:    */     
/* 284:    */     public Criteria andUsernameLessThan(String value)
/* 285:    */     {
/* 286:246 */       addCriterion("JcAuthentication.username <", value, "username");
/* 287:247 */       return (Criteria)this;
/* 288:    */     }
/* 289:    */     
/* 290:    */     public Criteria andUsernameLessThanOrEqualTo(String value)
/* 291:    */     {
/* 292:251 */       addCriterion("JcAuthentication.username <=", value, "username");
/* 293:252 */       return (Criteria)this;
/* 294:    */     }
/* 295:    */     
/* 296:    */     public Criteria andUsernameLike(String value)
/* 297:    */     {
/* 298:256 */       addCriterion("JcAuthentication.username like", value, "username");
/* 299:257 */       return (Criteria)this;
/* 300:    */     }
/* 301:    */     
/* 302:    */     public Criteria andUsernameNotLike(String value)
/* 303:    */     {
/* 304:261 */       addCriterion("JcAuthentication.username not like", value, "username");
/* 305:262 */       return (Criteria)this;
/* 306:    */     }
/* 307:    */     
/* 308:    */     public Criteria andUsernameIn(List<String> values)
/* 309:    */     {
/* 310:266 */       addCriterion("JcAuthentication.username in", values, "username");
/* 311:267 */       return (Criteria)this;
/* 312:    */     }
/* 313:    */     
/* 314:    */     public Criteria andUsernameNotIn(List<String> values)
/* 315:    */     {
/* 316:271 */       addCriterion("JcAuthentication.username not in", values, "username");
/* 317:272 */       return (Criteria)this;
/* 318:    */     }
/* 319:    */     
/* 320:    */     public Criteria andUsernameBetween(String value1, String value2)
/* 321:    */     {
/* 322:276 */       addCriterion("JcAuthentication.username between", value1, value2, "username");
/* 323:277 */       return (Criteria)this;
/* 324:    */     }
/* 325:    */     
/* 326:    */     public Criteria andUsernameNotBetween(String value1, String value2)
/* 327:    */     {
/* 328:281 */       addCriterion("JcAuthentication.username not between", value1, value2, "username");
/* 329:282 */       return (Criteria)this;
/* 330:    */     }
/* 331:    */     
/* 332:    */     public Criteria andStartdateIsNull()
/* 333:    */     {
/* 334:286 */       addCriterion("JcAuthentication.startdate is null");
/* 335:287 */       return (Criteria)this;
/* 336:    */     }
/* 337:    */     
/* 338:    */     public Criteria andStartdateIsNotNull()
/* 339:    */     {
/* 340:291 */       addCriterion("JcAuthentication.startdate is not null");
/* 341:292 */       return (Criteria)this;
/* 342:    */     }
/* 343:    */     
/* 344:    */     public Criteria andStartdateEqualTo(java.util.Date value)
/* 345:    */     {
/* 346:296 */       addCriterionForJDBCDate("JcAuthentication.startdate =", value, "startdate");
/* 347:297 */       return (Criteria)this;
/* 348:    */     }
/* 349:    */     
/* 350:    */     public Criteria andStartdateNotEqualTo(java.util.Date value)
/* 351:    */     {
/* 352:301 */       addCriterionForJDBCDate("JcAuthentication.startdate <>", value, "startdate");
/* 353:302 */       return (Criteria)this;
/* 354:    */     }
/* 355:    */     
/* 356:    */     public Criteria andStartdateGreaterThan(java.util.Date value)
/* 357:    */     {
/* 358:306 */       addCriterionForJDBCDate("JcAuthentication.startdate >", value, "startdate");
/* 359:307 */       return (Criteria)this;
/* 360:    */     }
/* 361:    */     
/* 362:    */     public Criteria andStartdateGreaterThanOrEqualTo(java.util.Date value)
/* 363:    */     {
/* 364:311 */       addCriterionForJDBCDate("JcAuthentication.startdate >=", value, "startdate");
/* 365:312 */       return (Criteria)this;
/* 366:    */     }
/* 367:    */     
/* 368:    */     public Criteria andStartdateLessThan(java.util.Date value)
/* 369:    */     {
/* 370:316 */       addCriterionForJDBCDate("JcAuthentication.startdate <", value, "startdate");
/* 371:317 */       return (Criteria)this;
/* 372:    */     }
/* 373:    */     
/* 374:    */     public Criteria andStartdateLessThanOrEqualTo(java.util.Date value)
/* 375:    */     {
/* 376:321 */       addCriterionForJDBCDate("JcAuthentication.startdate <=", value, "startdate");
/* 377:322 */       return (Criteria)this;
/* 378:    */     }
/* 379:    */     
/* 380:    */     public Criteria andStartdateIn(List<java.util.Date> values)
/* 381:    */     {
/* 382:326 */       addCriterionForJDBCDate("JcAuthentication.startdate in", values, "startdate");
/* 383:327 */       return (Criteria)this;
/* 384:    */     }
/* 385:    */     
/* 386:    */     public Criteria andStartdateNotIn(List<java.util.Date> values)
/* 387:    */     {
/* 388:331 */       addCriterionForJDBCDate("JcAuthentication.startdate not in", values, "startdate");
/* 389:332 */       return (Criteria)this;
/* 390:    */     }
/* 391:    */     
/* 392:    */     public Criteria andStartdateBetween(java.util.Date value1, java.util.Date value2)
/* 393:    */     {
/* 394:336 */       addCriterionForJDBCDate("JcAuthentication.startdate between", value1, value2, "startdate");
/* 395:337 */       return (Criteria)this;
/* 396:    */     }
/* 397:    */     
/* 398:    */     public Criteria andStartdateNotBetween(java.util.Date value1, java.util.Date value2)
/* 399:    */     {
/* 400:341 */       addCriterionForJDBCDate("JcAuthentication.startdate not between", value1, value2, "startdate");
/* 401:342 */       return (Criteria)this;
/* 402:    */     }
/* 403:    */     
/* 404:    */     public Criteria andDuedateIsNull()
/* 405:    */     {
/* 406:346 */       addCriterion("JcAuthentication.duedate is null");
/* 407:347 */       return (Criteria)this;
/* 408:    */     }
/* 409:    */     
/* 410:    */     public Criteria andDuedateIsNotNull()
/* 411:    */     {
/* 412:351 */       addCriterion("JcAuthentication.duedate is not null");
/* 413:352 */       return (Criteria)this;
/* 414:    */     }
/* 415:    */     
/* 416:    */     public Criteria andDuedateEqualTo(java.util.Date value)
/* 417:    */     {
/* 418:356 */       addCriterionForJDBCDate("JcAuthentication.duedate =", value, "duedate");
/* 419:357 */       return (Criteria)this;
/* 420:    */     }
/* 421:    */     
/* 422:    */     public Criteria andDuedateNotEqualTo(java.util.Date value)
/* 423:    */     {
/* 424:361 */       addCriterionForJDBCDate("JcAuthentication.duedate <>", value, "duedate");
/* 425:362 */       return (Criteria)this;
/* 426:    */     }
/* 427:    */     
/* 428:    */     public Criteria andDuedateGreaterThan(java.util.Date value)
/* 429:    */     {
/* 430:366 */       addCriterionForJDBCDate("JcAuthentication.duedate >", value, "duedate");
/* 431:367 */       return (Criteria)this;
/* 432:    */     }
/* 433:    */     
/* 434:    */     public Criteria andDuedateGreaterThanOrEqualTo(java.util.Date value)
/* 435:    */     {
/* 436:371 */       addCriterionForJDBCDate("JcAuthentication.duedate >=", value, "duedate");
/* 437:372 */       return (Criteria)this;
/* 438:    */     }
/* 439:    */     
/* 440:    */     public Criteria andDuedateLessThan(java.util.Date value)
/* 441:    */     {
/* 442:376 */       addCriterionForJDBCDate("JcAuthentication.duedate <", value, "duedate");
/* 443:377 */       return (Criteria)this;
/* 444:    */     }
/* 445:    */     
/* 446:    */     public Criteria andDuedateLessThanOrEqualTo(java.util.Date value)
/* 447:    */     {
/* 448:381 */       addCriterionForJDBCDate("JcAuthentication.duedate <=", value, "duedate");
/* 449:382 */       return (Criteria)this;
/* 450:    */     }
/* 451:    */     
/* 452:    */     public Criteria andDuedateIn(List<java.util.Date> values)
/* 453:    */     {
/* 454:386 */       addCriterionForJDBCDate("JcAuthentication.duedate in", values, "duedate");
/* 455:387 */       return (Criteria)this;
/* 456:    */     }
/* 457:    */     
/* 458:    */     public Criteria andDuedateNotIn(List<java.util.Date> values)
/* 459:    */     {
/* 460:391 */       addCriterionForJDBCDate("JcAuthentication.duedate not in", values, "duedate");
/* 461:392 */       return (Criteria)this;
/* 462:    */     }
/* 463:    */     
/* 464:    */     public Criteria andDuedateBetween(java.util.Date value1, java.util.Date value2)
/* 465:    */     {
/* 466:396 */       addCriterionForJDBCDate("JcAuthentication.duedate between", value1, value2, "duedate");
/* 467:397 */       return (Criteria)this;
/* 468:    */     }
/* 469:    */     
/* 470:    */     public Criteria andDuedateNotBetween(java.util.Date value1, java.util.Date value2)
/* 471:    */     {
/* 472:401 */       addCriterionForJDBCDate("JcAuthentication.duedate not between", value1, value2, "duedate");
/* 473:402 */       return (Criteria)this;
/* 474:    */     }
/* 475:    */     
/* 476:    */     public Criteria andRegionIsNull()
/* 477:    */     {
/* 478:406 */       addCriterion("JcAuthentication.region is null");
/* 479:407 */       return (Criteria)this;
/* 480:    */     }
/* 481:    */     
/* 482:    */     public Criteria andRegionIsNotNull()
/* 483:    */     {
/* 484:411 */       addCriterion("JcAuthentication.region is not null");
/* 485:412 */       return (Criteria)this;
/* 486:    */     }
/* 487:    */     
/* 488:    */     public Criteria andRegionEqualTo(String value)
/* 489:    */     {
/* 490:416 */       addCriterion("JcAuthentication.region =", value, "region");
/* 491:417 */       return (Criteria)this;
/* 492:    */     }
/* 493:    */     
/* 494:    */     public Criteria andRegionNotEqualTo(String value)
/* 495:    */     {
/* 496:421 */       addCriterion("JcAuthentication.region <>", value, "region");
/* 497:422 */       return (Criteria)this;
/* 498:    */     }
/* 499:    */     
/* 500:    */     public Criteria andRegionGreaterThan(String value)
/* 501:    */     {
/* 502:426 */       addCriterion("JcAuthentication.region >", value, "region");
/* 503:427 */       return (Criteria)this;
/* 504:    */     }
/* 505:    */     
/* 506:    */     public Criteria andRegionGreaterThanOrEqualTo(String value)
/* 507:    */     {
/* 508:431 */       addCriterion("JcAuthentication.region >=", value, "region");
/* 509:432 */       return (Criteria)this;
/* 510:    */     }
/* 511:    */     
/* 512:    */     public Criteria andRegionLessThan(String value)
/* 513:    */     {
/* 514:436 */       addCriterion("JcAuthentication.region <", value, "region");
/* 515:437 */       return (Criteria)this;
/* 516:    */     }
/* 517:    */     
/* 518:    */     public Criteria andRegionLessThanOrEqualTo(String value)
/* 519:    */     {
/* 520:441 */       addCriterion("JcAuthentication.region <=", value, "region");
/* 521:442 */       return (Criteria)this;
/* 522:    */     }
/* 523:    */     
/* 524:    */     public Criteria andRegionLike(String value)
/* 525:    */     {
/* 526:446 */       addCriterion("JcAuthentication.region like", value, "region");
/* 527:447 */       return (Criteria)this;
/* 528:    */     }
/* 529:    */     
/* 530:    */     public Criteria andRegionNotLike(String value)
/* 531:    */     {
/* 532:451 */       addCriterion("JcAuthentication.region not like", value, "region");
/* 533:452 */       return (Criteria)this;
/* 534:    */     }
/* 535:    */     
/* 536:    */     public Criteria andRegionIn(List<String> values)
/* 537:    */     {
/* 538:456 */       addCriterion("JcAuthentication.region in", values, "region");
/* 539:457 */       return (Criteria)this;
/* 540:    */     }
/* 541:    */     
/* 542:    */     public Criteria andRegionNotIn(List<String> values)
/* 543:    */     {
/* 544:461 */       addCriterion("JcAuthentication.region not in", values, "region");
/* 545:462 */       return (Criteria)this;
/* 546:    */     }
/* 547:    */     
/* 548:    */     public Criteria andRegionBetween(String value1, String value2)
/* 549:    */     {
/* 550:466 */       addCriterion("JcAuthentication.region between", value1, value2, "region");
/* 551:467 */       return (Criteria)this;
/* 552:    */     }
/* 553:    */     
/* 554:    */     public Criteria andRegionNotBetween(String value1, String value2)
/* 555:    */     {
/* 556:471 */       addCriterion("JcAuthentication.region not between", value1, value2, "region");
/* 557:472 */       return (Criteria)this;
/* 558:    */     }
/* 559:    */     
/* 560:    */     public Criteria andTypeIsNull()
/* 561:    */     {
/* 562:476 */       addCriterion("JcAuthentication.type is null");
/* 563:477 */       return (Criteria)this;
/* 564:    */     }
/* 565:    */     
/* 566:    */     public Criteria andTypeIsNotNull()
/* 567:    */     {
/* 568:481 */       addCriterion("JcAuthentication.type is not null");
/* 569:482 */       return (Criteria)this;
/* 570:    */     }
/* 571:    */     
/* 572:    */     public Criteria andTypeEqualTo(String value)
/* 573:    */     {
/* 574:486 */       addCriterion("JcAuthentication.type =", value, "type");
/* 575:487 */       return (Criteria)this;
/* 576:    */     }
/* 577:    */     
/* 578:    */     public Criteria andTypeNotEqualTo(String value)
/* 579:    */     {
/* 580:491 */       addCriterion("JcAuthentication.type <>", value, "type");
/* 581:492 */       return (Criteria)this;
/* 582:    */     }
/* 583:    */     
/* 584:    */     public Criteria andTypeGreaterThan(String value)
/* 585:    */     {
/* 586:496 */       addCriterion("JcAuthentication.type >", value, "type");
/* 587:497 */       return (Criteria)this;
/* 588:    */     }
/* 589:    */     
/* 590:    */     public Criteria andTypeGreaterThanOrEqualTo(String value)
/* 591:    */     {
/* 592:501 */       addCriterion("JcAuthentication.type >=", value, "type");
/* 593:502 */       return (Criteria)this;
/* 594:    */     }
/* 595:    */     
/* 596:    */     public Criteria andTypeLessThan(String value)
/* 597:    */     {
/* 598:506 */       addCriterion("JcAuthentication.type <", value, "type");
/* 599:507 */       return (Criteria)this;
/* 600:    */     }
/* 601:    */     
/* 602:    */     public Criteria andTypeLessThanOrEqualTo(String value)
/* 603:    */     {
/* 604:511 */       addCriterion("JcAuthentication.type <=", value, "type");
/* 605:512 */       return (Criteria)this;
/* 606:    */     }
/* 607:    */     
/* 608:    */     public Criteria andTypeLike(String value)
/* 609:    */     {
/* 610:516 */       addCriterion("JcAuthentication.type like", value, "type");
/* 611:517 */       return (Criteria)this;
/* 612:    */     }
/* 613:    */     
/* 614:    */     public Criteria andTypeNotLike(String value)
/* 615:    */     {
/* 616:521 */       addCriterion("JcAuthentication.type not like", value, "type");
/* 617:522 */       return (Criteria)this;
/* 618:    */     }
/* 619:    */     
/* 620:    */     public Criteria andTypeIn(List<String> values)
/* 621:    */     {
/* 622:526 */       addCriterion("JcAuthentication.type in", values, "type");
/* 623:527 */       return (Criteria)this;
/* 624:    */     }
/* 625:    */     
/* 626:    */     public Criteria andTypeNotIn(List<String> values)
/* 627:    */     {
/* 628:531 */       addCriterion("JcAuthentication.type not in", values, "type");
/* 629:532 */       return (Criteria)this;
/* 630:    */     }
/* 631:    */     
/* 632:    */     public Criteria andTypeBetween(String value1, String value2)
/* 633:    */     {
/* 634:536 */       addCriterion("JcAuthentication.type between", value1, value2, "type");
/* 635:537 */       return (Criteria)this;
/* 636:    */     }
/* 637:    */     
/* 638:    */     public Criteria andTypeNotBetween(String value1, String value2)
/* 639:    */     {
/* 640:541 */       addCriterion("JcAuthentication.type not between", value1, value2, "type");
/* 641:542 */       return (Criteria)this;
/* 642:    */     }
/* 643:    */     
/* 644:    */     public Criteria andPaytypeIsNull()
/* 645:    */     {
/* 646:546 */       addCriterion("JcAuthentication.payType is null");
/* 647:547 */       return (Criteria)this;
/* 648:    */     }
/* 649:    */     
/* 650:    */     public Criteria andPaytypeIsNotNull()
/* 651:    */     {
/* 652:551 */       addCriterion("JcAuthentication.payType is not null");
/* 653:552 */       return (Criteria)this;
/* 654:    */     }
/* 655:    */     
/* 656:    */     public Criteria andPaytypeEqualTo(String value)
/* 657:    */     {
/* 658:556 */       addCriterion("JcAuthentication.payType =", value, "paytype");
/* 659:557 */       return (Criteria)this;
/* 660:    */     }
/* 661:    */     
/* 662:    */     public Criteria andPaytypeNotEqualTo(String value)
/* 663:    */     {
/* 664:561 */       addCriterion("JcAuthentication.payType <>", value, "paytype");
/* 665:562 */       return (Criteria)this;
/* 666:    */     }
/* 667:    */     
/* 668:    */     public Criteria andPaytypeGreaterThan(String value)
/* 669:    */     {
/* 670:566 */       addCriterion("JcAuthentication.payType >", value, "paytype");
/* 671:567 */       return (Criteria)this;
/* 672:    */     }
/* 673:    */     
/* 674:    */     public Criteria andPaytypeGreaterThanOrEqualTo(String value)
/* 675:    */     {
/* 676:571 */       addCriterion("JcAuthentication.payType >=", value, "paytype");
/* 677:572 */       return (Criteria)this;
/* 678:    */     }
/* 679:    */     
/* 680:    */     public Criteria andPaytypeLessThan(String value)
/* 681:    */     {
/* 682:576 */       addCriterion("JcAuthentication.payType <", value, "paytype");
/* 683:577 */       return (Criteria)this;
/* 684:    */     }
/* 685:    */     
/* 686:    */     public Criteria andPaytypeLessThanOrEqualTo(String value)
/* 687:    */     {
/* 688:581 */       addCriterion("JcAuthentication.payType <=", value, "paytype");
/* 689:582 */       return (Criteria)this;
/* 690:    */     }
/* 691:    */     
/* 692:    */     public Criteria andPaytypeLike(String value)
/* 693:    */     {
/* 694:586 */       addCriterion("JcAuthentication.payType like", value, "paytype");
/* 695:587 */       return (Criteria)this;
/* 696:    */     }
/* 697:    */     
/* 698:    */     public Criteria andPaytypeNotLike(String value)
/* 699:    */     {
/* 700:591 */       addCriterion("JcAuthentication.payType not like", value, "paytype");
/* 701:592 */       return (Criteria)this;
/* 702:    */     }
/* 703:    */     
/* 704:    */     public Criteria andPaytypeIn(List<String> values)
/* 705:    */     {
/* 706:596 */       addCriterion("JcAuthentication.payType in", values, "paytype");
/* 707:597 */       return (Criteria)this;
/* 708:    */     }
/* 709:    */     
/* 710:    */     public Criteria andPaytypeNotIn(List<String> values)
/* 711:    */     {
/* 712:601 */       addCriterion("JcAuthentication.payType not in", values, "paytype");
/* 713:602 */       return (Criteria)this;
/* 714:    */     }
/* 715:    */     
/* 716:    */     public Criteria andPaytypeBetween(String value1, String value2)
/* 717:    */     {
/* 718:606 */       addCriterion("JcAuthentication.payType between", value1, value2, "paytype");
/* 719:607 */       return (Criteria)this;
/* 720:    */     }
/* 721:    */     
/* 722:    */     public Criteria andPaytypeNotBetween(String value1, String value2)
/* 723:    */     {
/* 724:611 */       addCriterion("JcAuthentication.payType not between", value1, value2, "paytype");
/* 725:612 */       return (Criteria)this;
/* 726:    */     }
/* 727:    */   }
/* 728:    */   
/* 729:    */   public static class Criteria
/* 730:    */     extends GeneratedCriteria
/* 731:    */   {}
/* 732:    */   
/* 733:    */   public static class Criterion
/* 734:    */   {
/* 735:    */     private String condition;
/* 736:    */     private Object value;
/* 737:    */     private Object secondValue;
/* 738:    */     private boolean noValue;
/* 739:    */     private boolean singleValue;
/* 740:    */     private boolean betweenValue;
/* 741:    */     private boolean listValue;
/* 742:    */     private String typeHandler;
/* 743:    */     
/* 744:    */     public String getCondition()
/* 745:    */     {
/* 746:641 */       return this.condition;
/* 747:    */     }
/* 748:    */     
/* 749:    */     public Object getValue()
/* 750:    */     {
/* 751:645 */       return this.value;
/* 752:    */     }
/* 753:    */     
/* 754:    */     public Object getSecondValue()
/* 755:    */     {
/* 756:649 */       return this.secondValue;
/* 757:    */     }
/* 758:    */     
/* 759:    */     public boolean isNoValue()
/* 760:    */     {
/* 761:653 */       return this.noValue;
/* 762:    */     }
/* 763:    */     
/* 764:    */     public boolean isSingleValue()
/* 765:    */     {
/* 766:657 */       return this.singleValue;
/* 767:    */     }
/* 768:    */     
/* 769:    */     public boolean isBetweenValue()
/* 770:    */     {
/* 771:661 */       return this.betweenValue;
/* 772:    */     }
/* 773:    */     
/* 774:    */     public boolean isListValue()
/* 775:    */     {
/* 776:665 */       return this.listValue;
/* 777:    */     }
/* 778:    */     
/* 779:    */     public String getTypeHandler()
/* 780:    */     {
/* 781:669 */       return this.typeHandler;
/* 782:    */     }
/* 783:    */     
/* 784:    */     protected Criterion(String condition)
/* 785:    */     {
/* 786:674 */       this.condition = condition;
/* 787:675 */       this.typeHandler = null;
/* 788:676 */       this.noValue = true;
/* 789:    */     }
/* 790:    */     
/* 791:    */     protected Criterion(String condition, Object value, String typeHandler)
/* 792:    */     {
/* 793:681 */       this.condition = condition;
/* 794:682 */       this.value = value;
/* 795:683 */       this.typeHandler = typeHandler;
/* 796:684 */       if ((value instanceof List)) {
/* 797:685 */         this.listValue = true;
/* 798:    */       } else {
/* 799:687 */         this.singleValue = true;
/* 800:    */       }
/* 801:    */     }
/* 802:    */     
/* 803:    */     protected Criterion(String condition, Object value)
/* 804:    */     {
/* 805:692 */       this(condition, value, null);
/* 806:    */     }
/* 807:    */     
/* 808:    */     protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
/* 809:    */     {
/* 810:697 */       this.condition = condition;
/* 811:698 */       this.value = value;
/* 812:699 */       this.secondValue = secondValue;
/* 813:700 */       this.typeHandler = typeHandler;
/* 814:701 */       this.betweenValue = true;
/* 815:    */     }
/* 816:    */     
/* 817:    */     protected Criterion(String condition, Object value, Object secondValue)
/* 818:    */     {
/* 819:705 */       this(condition, value, secondValue, null);
/* 820:    */     }
/* 821:    */   }
/* 822:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.entity.JcAuthenticationExample

 * JD-Core Version:    0.7.0.1

 */