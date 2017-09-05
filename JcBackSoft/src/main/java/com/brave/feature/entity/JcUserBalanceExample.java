/*   1:    */ package com.brave.feature.entity;
/*   2:    */ 
/*   3:    */ import java.util.ArrayList;
/*   4:    */ import java.util.Date;
/*   5:    */ import java.util.List;
/*   6:    */ 
/*   7:    */ public class JcUserBalanceExample
/*   8:    */ {
/*   9:    */   protected String orderByClause;
/*  10:    */   protected boolean distinct;
/*  11:    */   protected List<Criteria> oredCriteria;
/*  12:    */   protected Integer limitStart;
/*  13:    */   protected Integer limitEnd;
/*  14:    */   
/*  15:    */   public JcUserBalanceExample()
/*  16:    */   {
/*  17: 19 */     this.oredCriteria = new ArrayList();
/*  18:    */   }
/*  19:    */   
/*  20:    */   public void setOrderByClause(String orderByClause)
/*  21:    */   {
/*  22: 23 */     this.orderByClause = orderByClause;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public String getOrderByClause()
/*  26:    */   {
/*  27: 27 */     return this.orderByClause;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void setDistinct(boolean distinct)
/*  31:    */   {
/*  32: 31 */     this.distinct = distinct;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public boolean isDistinct()
/*  36:    */   {
/*  37: 35 */     return this.distinct;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public List<Criteria> getOredCriteria()
/*  41:    */   {
/*  42: 39 */     return this.oredCriteria;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void or(Criteria criteria)
/*  46:    */   {
/*  47: 43 */     this.oredCriteria.add(criteria);
/*  48:    */   }
/*  49:    */   
/*  50:    */   public Criteria or()
/*  51:    */   {
/*  52: 47 */     Criteria criteria = createCriteriaInternal();
/*  53: 48 */     this.oredCriteria.add(criteria);
/*  54: 49 */     return criteria;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public Criteria createCriteria()
/*  58:    */   {
/*  59: 53 */     Criteria criteria = createCriteriaInternal();
/*  60: 54 */     if (this.oredCriteria.size() == 0) {
/*  61: 55 */       this.oredCriteria.add(criteria);
/*  62:    */     }
/*  63: 57 */     return criteria;
/*  64:    */   }
/*  65:    */   
/*  66:    */   protected Criteria createCriteriaInternal()
/*  67:    */   {
/*  68: 61 */     Criteria criteria = new Criteria();
/*  69: 62 */     return criteria;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void clear()
/*  73:    */   {
/*  74: 66 */     this.oredCriteria.clear();
/*  75: 67 */     this.orderByClause = null;
/*  76: 68 */     this.distinct = false;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setLimitStart(Integer limitStart)
/*  80:    */   {
/*  81: 72 */     this.limitStart = limitStart;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public Integer getLimitStart()
/*  85:    */   {
/*  86: 76 */     return this.limitStart;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setLimitEnd(Integer limitEnd)
/*  90:    */   {
/*  91: 80 */     this.limitEnd = limitEnd;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public Integer getLimitEnd()
/*  95:    */   {
/*  96: 84 */     return this.limitEnd;
/*  97:    */   }
/*  98:    */   
/*  99:    */   protected static abstract class GeneratedCriteria
/* 100:    */   {
/* 101:    */     protected List<Criterion> criteria;
/* 102:    */     
/* 103:    */     protected GeneratedCriteria()
/* 104:    */     {
/* 105: 92 */       this.criteria = new ArrayList();
/* 106:    */     }
/* 107:    */     
/* 108:    */     public boolean isValid()
/* 109:    */     {
/* 110: 96 */       return this.criteria.size() > 0;
/* 111:    */     }
/* 112:    */     
/* 113:    */     public List<Criterion> getAllCriteria()
/* 114:    */     {
/* 115:100 */       return this.criteria;
/* 116:    */     }
/* 117:    */     
/* 118:    */     public List<Criterion> getCriteria()
/* 119:    */     {
/* 120:104 */       return this.criteria;
/* 121:    */     }
/* 122:    */     
/* 123:    */     protected void addCriterion(String condition)
/* 124:    */     {
/* 125:108 */       if (condition == null) {
/* 126:109 */         throw new RuntimeException("Value for condition cannot be null");
/* 127:    */       }
/* 128:111 */       this.criteria.add(new Criterion(condition));
/* 129:    */     }
/* 130:    */     
/* 131:    */     protected void addCriterion(String condition, Object value, String property)
/* 132:    */     {
/* 133:115 */       if (value == null) {
/* 134:116 */         throw new RuntimeException("Value for " + property + " cannot be null");
/* 135:    */       }
/* 136:118 */       this.criteria.add(new Criterion(condition, value));
/* 137:    */     }
/* 138:    */     
/* 139:    */     protected void addCriterion(String condition, Object value1, Object value2, String property)
/* 140:    */     {
/* 141:122 */       if ((value1 == null) || (value2 == null)) {
/* 142:123 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/* 143:    */       }
/* 144:125 */       this.criteria.add(new Criterion(condition, value1, value2));
/* 145:    */     }
/* 146:    */     
/* 147:    */     public Criteria andIdIsNull()
/* 148:    */     {
/* 149:129 */       addCriterion("JcUserBalance.id is null");
/* 150:130 */       return (Criteria)this;
/* 151:    */     }
/* 152:    */     
/* 153:    */     public Criteria andIdIsNotNull()
/* 154:    */     {
/* 155:134 */       addCriterion("JcUserBalance.id is not null");
/* 156:135 */       return (Criteria)this;
/* 157:    */     }
/* 158:    */     
/* 159:    */     public Criteria andIdEqualTo(Integer value)
/* 160:    */     {
/* 161:139 */       addCriterion("JcUserBalance.id =", value, "id");
/* 162:140 */       return (Criteria)this;
/* 163:    */     }
/* 164:    */     
/* 165:    */     public Criteria andIdNotEqualTo(Integer value)
/* 166:    */     {
/* 167:144 */       addCriterion("JcUserBalance.id <>", value, "id");
/* 168:145 */       return (Criteria)this;
/* 169:    */     }
/* 170:    */     
/* 171:    */     public Criteria andIdGreaterThan(Integer value)
/* 172:    */     {
/* 173:149 */       addCriterion("JcUserBalance.id >", value, "id");
/* 174:150 */       return (Criteria)this;
/* 175:    */     }
/* 176:    */     
/* 177:    */     public Criteria andIdGreaterThanOrEqualTo(Integer value)
/* 178:    */     {
/* 179:154 */       addCriterion("JcUserBalance.id >=", value, "id");
/* 180:155 */       return (Criteria)this;
/* 181:    */     }
/* 182:    */     
/* 183:    */     public Criteria andIdLessThan(Integer value)
/* 184:    */     {
/* 185:159 */       addCriterion("JcUserBalance.id <", value, "id");
/* 186:160 */       return (Criteria)this;
/* 187:    */     }
/* 188:    */     
/* 189:    */     public Criteria andIdLessThanOrEqualTo(Integer value)
/* 190:    */     {
/* 191:164 */       addCriterion("JcUserBalance.id <=", value, "id");
/* 192:165 */       return (Criteria)this;
/* 193:    */     }
/* 194:    */     
/* 195:    */     public Criteria andIdIn(List<Integer> values)
/* 196:    */     {
/* 197:169 */       addCriterion("JcUserBalance.id in", values, "id");
/* 198:170 */       return (Criteria)this;
/* 199:    */     }
/* 200:    */     
/* 201:    */     public Criteria andIdNotIn(List<Integer> values)
/* 202:    */     {
/* 203:174 */       addCriterion("JcUserBalance.id not in", values, "id");
/* 204:175 */       return (Criteria)this;
/* 205:    */     }
/* 206:    */     
/* 207:    */     public Criteria andIdBetween(Integer value1, Integer value2)
/* 208:    */     {
/* 209:179 */       addCriterion("JcUserBalance.id between", value1, value2, "id");
/* 210:180 */       return (Criteria)this;
/* 211:    */     }
/* 212:    */     
/* 213:    */     public Criteria andIdNotBetween(Integer value1, Integer value2)
/* 214:    */     {
/* 215:184 */       addCriterion("JcUserBalance.id not between", value1, value2, "id");
/* 216:185 */       return (Criteria)this;
/* 217:    */     }
/* 218:    */     
/* 219:    */     public Criteria andUsernameIsNull()
/* 220:    */     {
/* 221:189 */       addCriterion("JcUserBalance.username is null");
/* 222:190 */       return (Criteria)this;
/* 223:    */     }
/* 224:    */     
/* 225:    */     public Criteria andUsernameIsNotNull()
/* 226:    */     {
/* 227:194 */       addCriterion("JcUserBalance.username is not null");
/* 228:195 */       return (Criteria)this;
/* 229:    */     }
/* 230:    */     
/* 231:    */     public Criteria andUsernameEqualTo(String value)
/* 232:    */     {
/* 233:199 */       addCriterion("JcUserBalance.username =", value, "username");
/* 234:200 */       return (Criteria)this;
/* 235:    */     }
/* 236:    */     
/* 237:    */     public Criteria andUsernameNotEqualTo(String value)
/* 238:    */     {
/* 239:204 */       addCriterion("JcUserBalance.username <>", value, "username");
/* 240:205 */       return (Criteria)this;
/* 241:    */     }
/* 242:    */     
/* 243:    */     public Criteria andUsernameGreaterThan(String value)
/* 244:    */     {
/* 245:209 */       addCriterion("JcUserBalance.username >", value, "username");
/* 246:210 */       return (Criteria)this;
/* 247:    */     }
/* 248:    */     
/* 249:    */     public Criteria andUsernameGreaterThanOrEqualTo(String value)
/* 250:    */     {
/* 251:214 */       addCriterion("JcUserBalance.username >=", value, "username");
/* 252:215 */       return (Criteria)this;
/* 253:    */     }
/* 254:    */     
/* 255:    */     public Criteria andUsernameLessThan(String value)
/* 256:    */     {
/* 257:219 */       addCriterion("JcUserBalance.username <", value, "username");
/* 258:220 */       return (Criteria)this;
/* 259:    */     }
/* 260:    */     
/* 261:    */     public Criteria andUsernameLessThanOrEqualTo(String value)
/* 262:    */     {
/* 263:224 */       addCriterion("JcUserBalance.username <=", value, "username");
/* 264:225 */       return (Criteria)this;
/* 265:    */     }
/* 266:    */     
/* 267:    */     public Criteria andUsernameLike(String value)
/* 268:    */     {
/* 269:229 */       addCriterion("JcUserBalance.username like", value, "username");
/* 270:230 */       return (Criteria)this;
/* 271:    */     }
/* 272:    */     
/* 273:    */     public Criteria andUsernameNotLike(String value)
/* 274:    */     {
/* 275:234 */       addCriterion("JcUserBalance.username not like", value, "username");
/* 276:235 */       return (Criteria)this;
/* 277:    */     }
/* 278:    */     
/* 279:    */     public Criteria andUsernameIn(List<String> values)
/* 280:    */     {
/* 281:239 */       addCriterion("JcUserBalance.username in", values, "username");
/* 282:240 */       return (Criteria)this;
/* 283:    */     }
/* 284:    */     
/* 285:    */     public Criteria andUsernameNotIn(List<String> values)
/* 286:    */     {
/* 287:244 */       addCriterion("JcUserBalance.username not in", values, "username");
/* 288:245 */       return (Criteria)this;
/* 289:    */     }
/* 290:    */     
/* 291:    */     public Criteria andUsernameBetween(String value1, String value2)
/* 292:    */     {
/* 293:249 */       addCriterion("JcUserBalance.username between", value1, value2, "username");
/* 294:250 */       return (Criteria)this;
/* 295:    */     }
/* 296:    */     
/* 297:    */     public Criteria andUsernameNotBetween(String value1, String value2)
/* 298:    */     {
/* 299:254 */       addCriterion("JcUserBalance.username not between", value1, value2, "username");
/* 300:255 */       return (Criteria)this;
/* 301:    */     }
/* 302:    */     
/* 303:    */     public Criteria andBalanceIsNull()
/* 304:    */     {
/* 305:259 */       addCriterion("JcUserBalance.balance is null");
/* 306:260 */       return (Criteria)this;
/* 307:    */     }
/* 308:    */     
/* 309:    */     public Criteria andBalanceIsNotNull()
/* 310:    */     {
/* 311:264 */       addCriterion("JcUserBalance.balance is not null");
/* 312:265 */       return (Criteria)this;
/* 313:    */     }
/* 314:    */     
/* 315:    */     public Criteria andBalanceEqualTo(Integer value)
/* 316:    */     {
/* 317:269 */       addCriterion("JcUserBalance.balance =", value, "balance");
/* 318:270 */       return (Criteria)this;
/* 319:    */     }
/* 320:    */     
/* 321:    */     public Criteria andBalanceNotEqualTo(Integer value)
/* 322:    */     {
/* 323:274 */       addCriterion("JcUserBalance.balance <>", value, "balance");
/* 324:275 */       return (Criteria)this;
/* 325:    */     }
/* 326:    */     
/* 327:    */     public Criteria andBalanceGreaterThan(Integer value)
/* 328:    */     {
/* 329:279 */       addCriterion("JcUserBalance.balance >", value, "balance");
/* 330:280 */       return (Criteria)this;
/* 331:    */     }
/* 332:    */     
/* 333:    */     public Criteria andBalanceGreaterThanOrEqualTo(Integer value)
/* 334:    */     {
/* 335:284 */       addCriterion("JcUserBalance.balance >=", value, "balance");
/* 336:285 */       return (Criteria)this;
/* 337:    */     }
/* 338:    */     
/* 339:    */     public Criteria andBalanceLessThan(Integer value)
/* 340:    */     {
/* 341:289 */       addCriterion("JcUserBalance.balance <", value, "balance");
/* 342:290 */       return (Criteria)this;
/* 343:    */     }
/* 344:    */     
/* 345:    */     public Criteria andBalanceLessThanOrEqualTo(Integer value)
/* 346:    */     {
/* 347:294 */       addCriterion("JcUserBalance.balance <=", value, "balance");
/* 348:295 */       return (Criteria)this;
/* 349:    */     }
/* 350:    */     
/* 351:    */     public Criteria andBalanceIn(List<Integer> values)
/* 352:    */     {
/* 353:299 */       addCriterion("JcUserBalance.balance in", values, "balance");
/* 354:300 */       return (Criteria)this;
/* 355:    */     }
/* 356:    */     
/* 357:    */     public Criteria andBalanceNotIn(List<Integer> values)
/* 358:    */     {
/* 359:304 */       addCriterion("JcUserBalance.balance not in", values, "balance");
/* 360:305 */       return (Criteria)this;
/* 361:    */     }
/* 362:    */     
/* 363:    */     public Criteria andBalanceBetween(Integer value1, Integer value2)
/* 364:    */     {
/* 365:309 */       addCriterion("JcUserBalance.balance between", value1, value2, "balance");
/* 366:310 */       return (Criteria)this;
/* 367:    */     }
/* 368:    */     
/* 369:    */     public Criteria andBalanceNotBetween(Integer value1, Integer value2)
/* 370:    */     {
/* 371:314 */       addCriterion("JcUserBalance.balance not between", value1, value2, "balance");
/* 372:315 */       return (Criteria)this;
/* 373:    */     }
/* 374:    */     
/* 375:    */     public Criteria andPurposeIsNull()
/* 376:    */     {
/* 377:319 */       addCriterion("JcUserBalance.purpose is null");
/* 378:320 */       return (Criteria)this;
/* 379:    */     }
/* 380:    */     
/* 381:    */     public Criteria andPurposeIsNotNull()
/* 382:    */     {
/* 383:324 */       addCriterion("JcUserBalance.purpose is not null");
/* 384:325 */       return (Criteria)this;
/* 385:    */     }
/* 386:    */     
/* 387:    */     public Criteria andPurposeEqualTo(String value)
/* 388:    */     {
/* 389:329 */       addCriterion("JcUserBalance.purpose =", value, "purpose");
/* 390:330 */       return (Criteria)this;
/* 391:    */     }
/* 392:    */     
/* 393:    */     public Criteria andPurposeNotEqualTo(String value)
/* 394:    */     {
/* 395:334 */       addCriterion("JcUserBalance.purpose <>", value, "purpose");
/* 396:335 */       return (Criteria)this;
/* 397:    */     }
/* 398:    */     
/* 399:    */     public Criteria andPurposeGreaterThan(String value)
/* 400:    */     {
/* 401:339 */       addCriterion("JcUserBalance.purpose >", value, "purpose");
/* 402:340 */       return (Criteria)this;
/* 403:    */     }
/* 404:    */     
/* 405:    */     public Criteria andPurposeGreaterThanOrEqualTo(String value)
/* 406:    */     {
/* 407:344 */       addCriterion("JcUserBalance.purpose >=", value, "purpose");
/* 408:345 */       return (Criteria)this;
/* 409:    */     }
/* 410:    */     
/* 411:    */     public Criteria andPurposeLessThan(String value)
/* 412:    */     {
/* 413:349 */       addCriterion("JcUserBalance.purpose <", value, "purpose");
/* 414:350 */       return (Criteria)this;
/* 415:    */     }
/* 416:    */     
/* 417:    */     public Criteria andPurposeLessThanOrEqualTo(String value)
/* 418:    */     {
/* 419:354 */       addCriterion("JcUserBalance.purpose <=", value, "purpose");
/* 420:355 */       return (Criteria)this;
/* 421:    */     }
/* 422:    */     
/* 423:    */     public Criteria andPurposeLike(String value)
/* 424:    */     {
/* 425:359 */       addCriterion("JcUserBalance.purpose like", value, "purpose");
/* 426:360 */       return (Criteria)this;
/* 427:    */     }
/* 428:    */     
/* 429:    */     public Criteria andPurposeNotLike(String value)
/* 430:    */     {
/* 431:364 */       addCriterion("JcUserBalance.purpose not like", value, "purpose");
/* 432:365 */       return (Criteria)this;
/* 433:    */     }
/* 434:    */     
/* 435:    */     public Criteria andPurposeIn(List<String> values)
/* 436:    */     {
/* 437:369 */       addCriterion("JcUserBalance.purpose in", values, "purpose");
/* 438:370 */       return (Criteria)this;
/* 439:    */     }
/* 440:    */     
/* 441:    */     public Criteria andPurposeNotIn(List<String> values)
/* 442:    */     {
/* 443:374 */       addCriterion("JcUserBalance.purpose not in", values, "purpose");
/* 444:375 */       return (Criteria)this;
/* 445:    */     }
/* 446:    */     
/* 447:    */     public Criteria andPurposeBetween(String value1, String value2)
/* 448:    */     {
/* 449:379 */       addCriterion("JcUserBalance.purpose between", value1, value2, "purpose");
/* 450:380 */       return (Criteria)this;
/* 451:    */     }
/* 452:    */     
/* 453:    */     public Criteria andPurposeNotBetween(String value1, String value2)
/* 454:    */     {
/* 455:384 */       addCriterion("JcUserBalance.purpose not between", value1, value2, "purpose");
/* 456:385 */       return (Criteria)this;
/* 457:    */     }
/* 458:    */     
/* 459:    */     public Criteria andOperdateIsNull()
/* 460:    */     {
/* 461:389 */       addCriterion("JcUserBalance.operdate is null");
/* 462:390 */       return (Criteria)this;
/* 463:    */     }
/* 464:    */     
/* 465:    */     public Criteria andOperdateIsNotNull()
/* 466:    */     {
/* 467:394 */       addCriterion("JcUserBalance.operdate is not null");
/* 468:395 */       return (Criteria)this;
/* 469:    */     }
/* 470:    */     
/* 471:    */     public Criteria andOperdateEqualTo(Date value)
/* 472:    */     {
/* 473:399 */       addCriterion("JcUserBalance.operdate =", value, "operdate");
/* 474:400 */       return (Criteria)this;
/* 475:    */     }
/* 476:    */     
/* 477:    */     public Criteria andOperdateNotEqualTo(Date value)
/* 478:    */     {
/* 479:404 */       addCriterion("JcUserBalance.operdate <>", value, "operdate");
/* 480:405 */       return (Criteria)this;
/* 481:    */     }
/* 482:    */     
/* 483:    */     public Criteria andOperdateGreaterThan(Date value)
/* 484:    */     {
/* 485:409 */       addCriterion("JcUserBalance.operdate >", value, "operdate");
/* 486:410 */       return (Criteria)this;
/* 487:    */     }
/* 488:    */     
/* 489:    */     public Criteria andOperdateGreaterThanOrEqualTo(Date value)
/* 490:    */     {
/* 491:414 */       addCriterion("JcUserBalance.operdate >=", value, "operdate");
/* 492:415 */       return (Criteria)this;
/* 493:    */     }
/* 494:    */     
/* 495:    */     public Criteria andOperdateLessThan(Date value)
/* 496:    */     {
/* 497:419 */       addCriterion("JcUserBalance.operdate <", value, "operdate");
/* 498:420 */       return (Criteria)this;
/* 499:    */     }
/* 500:    */     
/* 501:    */     public Criteria andOperdateLessThanOrEqualTo(Date value)
/* 502:    */     {
/* 503:424 */       addCriterion("JcUserBalance.operdate <=", value, "operdate");
/* 504:425 */       return (Criteria)this;
/* 505:    */     }
/* 506:    */     
/* 507:    */     public Criteria andOperdateIn(List<Date> values)
/* 508:    */     {
/* 509:429 */       addCriterion("JcUserBalance.operdate in", values, "operdate");
/* 510:430 */       return (Criteria)this;
/* 511:    */     }
/* 512:    */     
/* 513:    */     public Criteria andOperdateNotIn(List<Date> values)
/* 514:    */     {
/* 515:434 */       addCriterion("JcUserBalance.operdate not in", values, "operdate");
/* 516:435 */       return (Criteria)this;
/* 517:    */     }
/* 518:    */     
/* 519:    */     public Criteria andOperdateBetween(Date value1, Date value2)
/* 520:    */     {
/* 521:439 */       addCriterion("JcUserBalance.operdate between", value1, value2, "operdate");
/* 522:440 */       return (Criteria)this;
/* 523:    */     }
/* 524:    */     
/* 525:    */     public Criteria andOperdateNotBetween(Date value1, Date value2)
/* 526:    */     {
/* 527:444 */       addCriterion("JcUserBalance.operdate not between", value1, value2, "operdate");
/* 528:445 */       return (Criteria)this;
/* 529:    */     }
/* 530:    */     
/* 531:    */     public Criteria andRemarkIsNull()
/* 532:    */     {
/* 533:449 */       addCriterion("JcUserBalance.remark is null");
/* 534:450 */       return (Criteria)this;
/* 535:    */     }
/* 536:    */     
/* 537:    */     public Criteria andRemarkIsNotNull()
/* 538:    */     {
/* 539:454 */       addCriterion("JcUserBalance.remark is not null");
/* 540:455 */       return (Criteria)this;
/* 541:    */     }
/* 542:    */     
/* 543:    */     public Criteria andRemarkEqualTo(String value)
/* 544:    */     {
/* 545:459 */       addCriterion("JcUserBalance.remark =", value, "remark");
/* 546:460 */       return (Criteria)this;
/* 547:    */     }
/* 548:    */     
/* 549:    */     public Criteria andRemarkNotEqualTo(String value)
/* 550:    */     {
/* 551:464 */       addCriterion("JcUserBalance.remark <>", value, "remark");
/* 552:465 */       return (Criteria)this;
/* 553:    */     }
/* 554:    */     
/* 555:    */     public Criteria andRemarkGreaterThan(String value)
/* 556:    */     {
/* 557:469 */       addCriterion("JcUserBalance.remark >", value, "remark");
/* 558:470 */       return (Criteria)this;
/* 559:    */     }
/* 560:    */     
/* 561:    */     public Criteria andRemarkGreaterThanOrEqualTo(String value)
/* 562:    */     {
/* 563:474 */       addCriterion("JcUserBalance.remark >=", value, "remark");
/* 564:475 */       return (Criteria)this;
/* 565:    */     }
/* 566:    */     
/* 567:    */     public Criteria andRemarkLessThan(String value)
/* 568:    */     {
/* 569:479 */       addCriterion("JcUserBalance.remark <", value, "remark");
/* 570:480 */       return (Criteria)this;
/* 571:    */     }
/* 572:    */     
/* 573:    */     public Criteria andRemarkLessThanOrEqualTo(String value)
/* 574:    */     {
/* 575:484 */       addCriterion("JcUserBalance.remark <=", value, "remark");
/* 576:485 */       return (Criteria)this;
/* 577:    */     }
/* 578:    */     
/* 579:    */     public Criteria andRemarkLike(String value)
/* 580:    */     {
/* 581:489 */       addCriterion("JcUserBalance.remark like", value, "remark");
/* 582:490 */       return (Criteria)this;
/* 583:    */     }
/* 584:    */     
/* 585:    */     public Criteria andRemarkNotLike(String value)
/* 586:    */     {
/* 587:494 */       addCriterion("JcUserBalance.remark not like", value, "remark");
/* 588:495 */       return (Criteria)this;
/* 589:    */     }
/* 590:    */     
/* 591:    */     public Criteria andRemarkIn(List<String> values)
/* 592:    */     {
/* 593:499 */       addCriterion("JcUserBalance.remark in", values, "remark");
/* 594:500 */       return (Criteria)this;
/* 595:    */     }
/* 596:    */     
/* 597:    */     public Criteria andRemarkNotIn(List<String> values)
/* 598:    */     {
/* 599:504 */       addCriterion("JcUserBalance.remark not in", values, "remark");
/* 600:505 */       return (Criteria)this;
/* 601:    */     }
/* 602:    */     
/* 603:    */     public Criteria andRemarkBetween(String value1, String value2)
/* 604:    */     {
/* 605:509 */       addCriterion("JcUserBalance.remark between", value1, value2, "remark");
/* 606:510 */       return (Criteria)this;
/* 607:    */     }
/* 608:    */     
/* 609:    */     public Criteria andRemarkNotBetween(String value1, String value2)
/* 610:    */     {
/* 611:514 */       addCriterion("JcUserBalance.remark not between", value1, value2, "remark");
/* 612:515 */       return (Criteria)this;
/* 613:    */     }
/* 614:    */   }
/* 615:    */   
/* 616:    */   public static class Criteria
/* 617:    */     extends GeneratedCriteria
/* 618:    */   {}
/* 619:    */   
/* 620:    */   public static class Criterion
/* 621:    */   {
/* 622:    */     private String condition;
/* 623:    */     private Object value;
/* 624:    */     private Object secondValue;
/* 625:    */     private boolean noValue;
/* 626:    */     private boolean singleValue;
/* 627:    */     private boolean betweenValue;
/* 628:    */     private boolean listValue;
/* 629:    */     private String typeHandler;
/* 630:    */     
/* 631:    */     public String getCondition()
/* 632:    */     {
/* 633:544 */       return this.condition;
/* 634:    */     }
/* 635:    */     
/* 636:    */     public Object getValue()
/* 637:    */     {
/* 638:548 */       return this.value;
/* 639:    */     }
/* 640:    */     
/* 641:    */     public Object getSecondValue()
/* 642:    */     {
/* 643:552 */       return this.secondValue;
/* 644:    */     }
/* 645:    */     
/* 646:    */     public boolean isNoValue()
/* 647:    */     {
/* 648:556 */       return this.noValue;
/* 649:    */     }
/* 650:    */     
/* 651:    */     public boolean isSingleValue()
/* 652:    */     {
/* 653:560 */       return this.singleValue;
/* 654:    */     }
/* 655:    */     
/* 656:    */     public boolean isBetweenValue()
/* 657:    */     {
/* 658:564 */       return this.betweenValue;
/* 659:    */     }
/* 660:    */     
/* 661:    */     public boolean isListValue()
/* 662:    */     {
/* 663:568 */       return this.listValue;
/* 664:    */     }
/* 665:    */     
/* 666:    */     public String getTypeHandler()
/* 667:    */     {
/* 668:572 */       return this.typeHandler;
/* 669:    */     }
/* 670:    */     
/* 671:    */     protected Criterion(String condition)
/* 672:    */     {
/* 673:577 */       this.condition = condition;
/* 674:578 */       this.typeHandler = null;
/* 675:579 */       this.noValue = true;
/* 676:    */     }
/* 677:    */     
/* 678:    */     protected Criterion(String condition, Object value, String typeHandler)
/* 679:    */     {
/* 680:584 */       this.condition = condition;
/* 681:585 */       this.value = value;
/* 682:586 */       this.typeHandler = typeHandler;
/* 683:587 */       if ((value instanceof List)) {
/* 684:588 */         this.listValue = true;
/* 685:    */       } else {
/* 686:590 */         this.singleValue = true;
/* 687:    */       }
/* 688:    */     }
/* 689:    */     
/* 690:    */     protected Criterion(String condition, Object value)
/* 691:    */     {
/* 692:595 */       this(condition, value, null);
/* 693:    */     }
/* 694:    */     
/* 695:    */     protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
/* 696:    */     {
/* 697:600 */       this.condition = condition;
/* 698:601 */       this.value = value;
/* 699:602 */       this.secondValue = secondValue;
/* 700:603 */       this.typeHandler = typeHandler;
/* 701:604 */       this.betweenValue = true;
/* 702:    */     }
/* 703:    */     
/* 704:    */     protected Criterion(String condition, Object value, Object secondValue)
/* 705:    */     {
/* 706:608 */       this(condition, value, secondValue, null);
/* 707:    */     }
/* 708:    */   }
/* 709:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.entity.JcUserBalanceExample

 * JD-Core Version:    0.7.0.1

 */