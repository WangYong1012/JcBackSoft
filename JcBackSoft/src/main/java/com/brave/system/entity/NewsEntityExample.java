/*   1:    */ package com.brave.system.entity;
/*   2:    */ 
/*   3:    */ import java.util.ArrayList;
/*   4:    */ import java.util.List;
/*   5:    */ 
/*   6:    */ public class NewsEntityExample
/*   7:    */ {
/*   8:    */   protected String orderByClause;
/*   9:    */   protected boolean distinct;
/*  10:    */   protected List<Criteria> oredCriteria;
/*  11:    */   protected Integer limitStart;
/*  12:    */   protected Integer limitEnd;
/*  13:    */   
/*  14:    */   public NewsEntityExample()
/*  15:    */   {
/*  16: 18 */     this.oredCriteria = new ArrayList();
/*  17:    */   }
/*  18:    */   
/*  19:    */   public void setOrderByClause(String orderByClause)
/*  20:    */   {
/*  21: 22 */     this.orderByClause = orderByClause;
/*  22:    */   }
/*  23:    */   
/*  24:    */   public String getOrderByClause()
/*  25:    */   {
/*  26: 26 */     return this.orderByClause;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public void setDistinct(boolean distinct)
/*  30:    */   {
/*  31: 30 */     this.distinct = distinct;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public boolean isDistinct()
/*  35:    */   {
/*  36: 34 */     return this.distinct;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public List<Criteria> getOredCriteria()
/*  40:    */   {
/*  41: 38 */     return this.oredCriteria;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void or(Criteria criteria)
/*  45:    */   {
/*  46: 42 */     this.oredCriteria.add(criteria);
/*  47:    */   }
/*  48:    */   
/*  49:    */   public Criteria or()
/*  50:    */   {
/*  51: 46 */     Criteria criteria = createCriteriaInternal();
/*  52: 47 */     this.oredCriteria.add(criteria);
/*  53: 48 */     return criteria;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public Criteria createCriteria()
/*  57:    */   {
/*  58: 52 */     Criteria criteria = createCriteriaInternal();
/*  59: 53 */     if (this.oredCriteria.size() == 0) {
/*  60: 54 */       this.oredCriteria.add(criteria);
/*  61:    */     }
/*  62: 56 */     return criteria;
/*  63:    */   }
/*  64:    */   
/*  65:    */   protected Criteria createCriteriaInternal()
/*  66:    */   {
/*  67: 60 */     Criteria criteria = new Criteria();
/*  68: 61 */     return criteria;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void clear()
/*  72:    */   {
/*  73: 65 */     this.oredCriteria.clear();
/*  74: 66 */     this.orderByClause = null;
/*  75: 67 */     this.distinct = false;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setLimitStart(Integer limitStart)
/*  79:    */   {
/*  80: 71 */     this.limitStart = limitStart;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public Integer getLimitStart()
/*  84:    */   {
/*  85: 75 */     return this.limitStart;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setLimitEnd(Integer limitEnd)
/*  89:    */   {
/*  90: 79 */     this.limitEnd = limitEnd;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public Integer getLimitEnd()
/*  94:    */   {
/*  95: 83 */     return this.limitEnd;
/*  96:    */   }
/*  97:    */   
/*  98:    */   protected static abstract class GeneratedCriteria
/*  99:    */   {
/* 100:    */     protected List<Criterion> criteria;
/* 101:    */     
/* 102:    */     protected GeneratedCriteria()
/* 103:    */     {
/* 104: 91 */       this.criteria = new ArrayList();
/* 105:    */     }
/* 106:    */     
/* 107:    */     public boolean isValid()
/* 108:    */     {
/* 109: 95 */       return this.criteria.size() > 0;
/* 110:    */     }
/* 111:    */     
/* 112:    */     public List<Criterion> getAllCriteria()
/* 113:    */     {
/* 114: 99 */       return this.criteria;
/* 115:    */     }
/* 116:    */     
/* 117:    */     public List<Criterion> getCriteria()
/* 118:    */     {
/* 119:103 */       return this.criteria;
/* 120:    */     }
/* 121:    */     
/* 122:    */     protected void addCriterion(String condition)
/* 123:    */     {
/* 124:107 */       if (condition == null) {
/* 125:108 */         throw new RuntimeException("Value for condition cannot be null");
/* 126:    */       }
/* 127:110 */       this.criteria.add(new Criterion(condition));
/* 128:    */     }
/* 129:    */     
/* 130:    */     protected void addCriterion(String condition, Object value, String property)
/* 131:    */     {
/* 132:114 */       if (value == null) {
/* 133:115 */         throw new RuntimeException("Value for " + property + " cannot be null");
/* 134:    */       }
/* 135:117 */       this.criteria.add(new Criterion(condition, value));
/* 136:    */     }
/* 137:    */     
/* 138:    */     protected void addCriterion(String condition, Object value1, Object value2, String property)
/* 139:    */     {
/* 140:121 */       if ((value1 == null) || (value2 == null)) {
/* 141:122 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/* 142:    */       }
/* 143:124 */       this.criteria.add(new Criterion(condition, value1, value2));
/* 144:    */     }
/* 145:    */     
/* 146:    */     public Criteria andNewsidIsNull()
/* 147:    */     {
/* 148:128 */       addCriterion("NewsEntity.newsid is null");
/* 149:129 */       return (Criteria)this;
/* 150:    */     }
/* 151:    */     
/* 152:    */     public Criteria andNewsidIsNotNull()
/* 153:    */     {
/* 154:133 */       addCriterion("NewsEntity.newsid is not null");
/* 155:134 */       return (Criteria)this;
/* 156:    */     }
/* 157:    */     
/* 158:    */     public Criteria andNewsidEqualTo(String value)
/* 159:    */     {
/* 160:138 */       addCriterion("NewsEntity.newsid =", value, "newsid");
/* 161:139 */       return (Criteria)this;
/* 162:    */     }
/* 163:    */     
/* 164:    */     public Criteria andNewsidNotEqualTo(String value)
/* 165:    */     {
/* 166:143 */       addCriterion("NewsEntity.newsid <>", value, "newsid");
/* 167:144 */       return (Criteria)this;
/* 168:    */     }
/* 169:    */     
/* 170:    */     public Criteria andNewsidGreaterThan(String value)
/* 171:    */     {
/* 172:148 */       addCriterion("NewsEntity.newsid >", value, "newsid");
/* 173:149 */       return (Criteria)this;
/* 174:    */     }
/* 175:    */     
/* 176:    */     public Criteria andNewsidGreaterThanOrEqualTo(String value)
/* 177:    */     {
/* 178:153 */       addCriterion("NewsEntity.newsid >=", value, "newsid");
/* 179:154 */       return (Criteria)this;
/* 180:    */     }
/* 181:    */     
/* 182:    */     public Criteria andNewsidLessThan(String value)
/* 183:    */     {
/* 184:158 */       addCriterion("NewsEntity.newsid <", value, "newsid");
/* 185:159 */       return (Criteria)this;
/* 186:    */     }
/* 187:    */     
/* 188:    */     public Criteria andNewsidLessThanOrEqualTo(String value)
/* 189:    */     {
/* 190:163 */       addCriterion("NewsEntity.newsid <=", value, "newsid");
/* 191:164 */       return (Criteria)this;
/* 192:    */     }
/* 193:    */     
/* 194:    */     public Criteria andNewsidLike(String value)
/* 195:    */     {
/* 196:168 */       addCriterion("NewsEntity.newsid like", value, "newsid");
/* 197:169 */       return (Criteria)this;
/* 198:    */     }
/* 199:    */     
/* 200:    */     public Criteria andNewsidNotLike(String value)
/* 201:    */     {
/* 202:173 */       addCriterion("NewsEntity.newsid not like", value, "newsid");
/* 203:174 */       return (Criteria)this;
/* 204:    */     }
/* 205:    */     
/* 206:    */     public Criteria andNewsidIn(List<String> values)
/* 207:    */     {
/* 208:178 */       addCriterion("NewsEntity.newsid in", values, "newsid");
/* 209:179 */       return (Criteria)this;
/* 210:    */     }
/* 211:    */     
/* 212:    */     public Criteria andNewsidNotIn(List<String> values)
/* 213:    */     {
/* 214:183 */       addCriterion("NewsEntity.newsid not in", values, "newsid");
/* 215:184 */       return (Criteria)this;
/* 216:    */     }
/* 217:    */     
/* 218:    */     public Criteria andNewsidBetween(String value1, String value2)
/* 219:    */     {
/* 220:188 */       addCriterion("NewsEntity.newsid between", value1, value2, "newsid");
/* 221:189 */       return (Criteria)this;
/* 222:    */     }
/* 223:    */     
/* 224:    */     public Criteria andNewsidNotBetween(String value1, String value2)
/* 225:    */     {
/* 226:193 */       addCriterion("NewsEntity.newsid not between", value1, value2, "newsid");
/* 227:194 */       return (Criteria)this;
/* 228:    */     }
/* 229:    */     
/* 230:    */     public Criteria andIssuetimeIsNull()
/* 231:    */     {
/* 232:198 */       addCriterion("NewsEntity.issuetime is null");
/* 233:199 */       return (Criteria)this;
/* 234:    */     }
/* 235:    */     
/* 236:    */     public Criteria andIssuetimeIsNotNull()
/* 237:    */     {
/* 238:203 */       addCriterion("NewsEntity.issuetime is not null");
/* 239:204 */       return (Criteria)this;
/* 240:    */     }
/* 241:    */     
/* 242:    */     public Criteria andIssuetimeEqualTo(String value)
/* 243:    */     {
/* 244:208 */       addCriterion("NewsEntity.issuetime =", value, "issuetime");
/* 245:209 */       return (Criteria)this;
/* 246:    */     }
/* 247:    */     
/* 248:    */     public Criteria andIssuetimeNotEqualTo(String value)
/* 249:    */     {
/* 250:213 */       addCriterion("NewsEntity.issuetime <>", value, "issuetime");
/* 251:214 */       return (Criteria)this;
/* 252:    */     }
/* 253:    */     
/* 254:    */     public Criteria andIssuetimeGreaterThan(String value)
/* 255:    */     {
/* 256:218 */       addCriterion("NewsEntity.issuetime >", value, "issuetime");
/* 257:219 */       return (Criteria)this;
/* 258:    */     }
/* 259:    */     
/* 260:    */     public Criteria andIssuetimeGreaterThanOrEqualTo(String value)
/* 261:    */     {
/* 262:223 */       addCriterion("NewsEntity.issuetime >=", value, "issuetime");
/* 263:224 */       return (Criteria)this;
/* 264:    */     }
/* 265:    */     
/* 266:    */     public Criteria andIssuetimeLessThan(String value)
/* 267:    */     {
/* 268:228 */       addCriterion("NewsEntity.issuetime <", value, "issuetime");
/* 269:229 */       return (Criteria)this;
/* 270:    */     }
/* 271:    */     
/* 272:    */     public Criteria andIssuetimeLessThanOrEqualTo(String value)
/* 273:    */     {
/* 274:233 */       addCriterion("NewsEntity.issuetime <=", value, "issuetime");
/* 275:234 */       return (Criteria)this;
/* 276:    */     }
/* 277:    */     
/* 278:    */     public Criteria andIssuetimeLike(String value)
/* 279:    */     {
/* 280:238 */       addCriterion("NewsEntity.issuetime like", value, "issuetime");
/* 281:239 */       return (Criteria)this;
/* 282:    */     }
/* 283:    */     
/* 284:    */     public Criteria andIssuetimeNotLike(String value)
/* 285:    */     {
/* 286:243 */       addCriterion("NewsEntity.issuetime not like", value, "issuetime");
/* 287:244 */       return (Criteria)this;
/* 288:    */     }
/* 289:    */     
/* 290:    */     public Criteria andIssuetimeIn(List<String> values)
/* 291:    */     {
/* 292:248 */       addCriterion("NewsEntity.issuetime in", values, "issuetime");
/* 293:249 */       return (Criteria)this;
/* 294:    */     }
/* 295:    */     
/* 296:    */     public Criteria andIssuetimeNotIn(List<String> values)
/* 297:    */     {
/* 298:253 */       addCriterion("NewsEntity.issuetime not in", values, "issuetime");
/* 299:254 */       return (Criteria)this;
/* 300:    */     }
/* 301:    */     
/* 302:    */     public Criteria andIssuetimeBetween(String value1, String value2)
/* 303:    */     {
/* 304:258 */       addCriterion("NewsEntity.issuetime between", value1, value2, "issuetime");
/* 305:259 */       return (Criteria)this;
/* 306:    */     }
/* 307:    */     
/* 308:    */     public Criteria andIssuetimeNotBetween(String value1, String value2)
/* 309:    */     {
/* 310:263 */       addCriterion("NewsEntity.issuetime not between", value1, value2, "issuetime");
/* 311:264 */       return (Criteria)this;
/* 312:    */     }
/* 313:    */     
/* 314:    */     public Criteria andContentIsNull()
/* 315:    */     {
/* 316:268 */       addCriterion("NewsEntity.content is null");
/* 317:269 */       return (Criteria)this;
/* 318:    */     }
/* 319:    */     
/* 320:    */     public Criteria andContentIsNotNull()
/* 321:    */     {
/* 322:273 */       addCriterion("NewsEntity.content is not null");
/* 323:274 */       return (Criteria)this;
/* 324:    */     }
/* 325:    */     
/* 326:    */     public Criteria andContentEqualTo(String value)
/* 327:    */     {
/* 328:278 */       addCriterion("NewsEntity.content =", value, "content");
/* 329:279 */       return (Criteria)this;
/* 330:    */     }
/* 331:    */     
/* 332:    */     public Criteria andContentNotEqualTo(String value)
/* 333:    */     {
/* 334:283 */       addCriterion("NewsEntity.content <>", value, "content");
/* 335:284 */       return (Criteria)this;
/* 336:    */     }
/* 337:    */     
/* 338:    */     public Criteria andContentGreaterThan(String value)
/* 339:    */     {
/* 340:288 */       addCriterion("NewsEntity.content >", value, "content");
/* 341:289 */       return (Criteria)this;
/* 342:    */     }
/* 343:    */     
/* 344:    */     public Criteria andContentGreaterThanOrEqualTo(String value)
/* 345:    */     {
/* 346:293 */       addCriterion("NewsEntity.content >=", value, "content");
/* 347:294 */       return (Criteria)this;
/* 348:    */     }
/* 349:    */     
/* 350:    */     public Criteria andContentLessThan(String value)
/* 351:    */     {
/* 352:298 */       addCriterion("NewsEntity.content <", value, "content");
/* 353:299 */       return (Criteria)this;
/* 354:    */     }
/* 355:    */     
/* 356:    */     public Criteria andContentLessThanOrEqualTo(String value)
/* 357:    */     {
/* 358:303 */       addCriterion("NewsEntity.content <=", value, "content");
/* 359:304 */       return (Criteria)this;
/* 360:    */     }
/* 361:    */     
/* 362:    */     public Criteria andContentLike(String value)
/* 363:    */     {
/* 364:308 */       addCriterion("NewsEntity.content like", value, "content");
/* 365:309 */       return (Criteria)this;
/* 366:    */     }
/* 367:    */     
/* 368:    */     public Criteria andContentNotLike(String value)
/* 369:    */     {
/* 370:313 */       addCriterion("NewsEntity.content not like", value, "content");
/* 371:314 */       return (Criteria)this;
/* 372:    */     }
/* 373:    */     
/* 374:    */     public Criteria andContentIn(List<String> values)
/* 375:    */     {
/* 376:318 */       addCriterion("NewsEntity.content in", values, "content");
/* 377:319 */       return (Criteria)this;
/* 378:    */     }
/* 379:    */     
/* 380:    */     public Criteria andContentNotIn(List<String> values)
/* 381:    */     {
/* 382:323 */       addCriterion("NewsEntity.content not in", values, "content");
/* 383:324 */       return (Criteria)this;
/* 384:    */     }
/* 385:    */     
/* 386:    */     public Criteria andContentBetween(String value1, String value2)
/* 387:    */     {
/* 388:328 */       addCriterion("NewsEntity.content between", value1, value2, "content");
/* 389:329 */       return (Criteria)this;
/* 390:    */     }
/* 391:    */     
/* 392:    */     public Criteria andContentNotBetween(String value1, String value2)
/* 393:    */     {
/* 394:333 */       addCriterion("NewsEntity.content not between", value1, value2, "content");
/* 395:334 */       return (Criteria)this;
/* 396:    */     }
/* 397:    */     
/* 398:    */     public Criteria andUsernameIsNull()
/* 399:    */     {
/* 400:338 */       addCriterion("NewsEntity.username is null");
/* 401:339 */       return (Criteria)this;
/* 402:    */     }
/* 403:    */     
/* 404:    */     public Criteria andUsernameIsNotNull()
/* 405:    */     {
/* 406:343 */       addCriterion("NewsEntity.username is not null");
/* 407:344 */       return (Criteria)this;
/* 408:    */     }
/* 409:    */     
/* 410:    */     public Criteria andUsernameEqualTo(String value)
/* 411:    */     {
/* 412:348 */       addCriterion("NewsEntity.username =", value, "username");
/* 413:349 */       return (Criteria)this;
/* 414:    */     }
/* 415:    */     
/* 416:    */     public Criteria andUsernameNotEqualTo(String value)
/* 417:    */     {
/* 418:353 */       addCriterion("NewsEntity.username <>", value, "username");
/* 419:354 */       return (Criteria)this;
/* 420:    */     }
/* 421:    */     
/* 422:    */     public Criteria andUsernameGreaterThan(String value)
/* 423:    */     {
/* 424:358 */       addCriterion("NewsEntity.username >", value, "username");
/* 425:359 */       return (Criteria)this;
/* 426:    */     }
/* 427:    */     
/* 428:    */     public Criteria andUsernameGreaterThanOrEqualTo(String value)
/* 429:    */     {
/* 430:363 */       addCriterion("NewsEntity.username >=", value, "username");
/* 431:364 */       return (Criteria)this;
/* 432:    */     }
/* 433:    */     
/* 434:    */     public Criteria andUsernameLessThan(String value)
/* 435:    */     {
/* 436:368 */       addCriterion("NewsEntity.username <", value, "username");
/* 437:369 */       return (Criteria)this;
/* 438:    */     }
/* 439:    */     
/* 440:    */     public Criteria andUsernameLessThanOrEqualTo(String value)
/* 441:    */     {
/* 442:373 */       addCriterion("NewsEntity.username <=", value, "username");
/* 443:374 */       return (Criteria)this;
/* 444:    */     }
/* 445:    */     
/* 446:    */     public Criteria andUsernameLike(String value)
/* 447:    */     {
/* 448:378 */       addCriterion("NewsEntity.username like", value, "username");
/* 449:379 */       return (Criteria)this;
/* 450:    */     }
/* 451:    */     
/* 452:    */     public Criteria andUsernameNotLike(String value)
/* 453:    */     {
/* 454:383 */       addCriterion("NewsEntity.username not like", value, "username");
/* 455:384 */       return (Criteria)this;
/* 456:    */     }
/* 457:    */     
/* 458:    */     public Criteria andUsernameIn(List<String> values)
/* 459:    */     {
/* 460:388 */       addCriterion("NewsEntity.username in", values, "username");
/* 461:389 */       return (Criteria)this;
/* 462:    */     }
/* 463:    */     
/* 464:    */     public Criteria andUsernameNotIn(List<String> values)
/* 465:    */     {
/* 466:393 */       addCriterion("NewsEntity.username not in", values, "username");
/* 467:394 */       return (Criteria)this;
/* 468:    */     }
/* 469:    */     
/* 470:    */     public Criteria andUsernameBetween(String value1, String value2)
/* 471:    */     {
/* 472:398 */       addCriterion("NewsEntity.username between", value1, value2, "username");
/* 473:399 */       return (Criteria)this;
/* 474:    */     }
/* 475:    */     
/* 476:    */     public Criteria andUsernameNotBetween(String value1, String value2)
/* 477:    */     {
/* 478:403 */       addCriterion("NewsEntity.username not between", value1, value2, "username");
/* 479:404 */       return (Criteria)this;
/* 480:    */     }
/* 481:    */     
/* 482:    */     public Criteria andAuthorIsNull()
/* 483:    */     {
/* 484:408 */       addCriterion("NewsEntity.author is null");
/* 485:409 */       return (Criteria)this;
/* 486:    */     }
/* 487:    */     
/* 488:    */     public Criteria andAuthorIsNotNull()
/* 489:    */     {
/* 490:413 */       addCriterion("NewsEntity.author is not null");
/* 491:414 */       return (Criteria)this;
/* 492:    */     }
/* 493:    */     
/* 494:    */     public Criteria andAuthorEqualTo(String value)
/* 495:    */     {
/* 496:418 */       addCriterion("NewsEntity.author =", value, "author");
/* 497:419 */       return (Criteria)this;
/* 498:    */     }
/* 499:    */     
/* 500:    */     public Criteria andAuthorNotEqualTo(String value)
/* 501:    */     {
/* 502:423 */       addCriterion("NewsEntity.author <>", value, "author");
/* 503:424 */       return (Criteria)this;
/* 504:    */     }
/* 505:    */     
/* 506:    */     public Criteria andAuthorGreaterThan(String value)
/* 507:    */     {
/* 508:428 */       addCriterion("NewsEntity.author >", value, "author");
/* 509:429 */       return (Criteria)this;
/* 510:    */     }
/* 511:    */     
/* 512:    */     public Criteria andAuthorGreaterThanOrEqualTo(String value)
/* 513:    */     {
/* 514:433 */       addCriterion("NewsEntity.author >=", value, "author");
/* 515:434 */       return (Criteria)this;
/* 516:    */     }
/* 517:    */     
/* 518:    */     public Criteria andAuthorLessThan(String value)
/* 519:    */     {
/* 520:438 */       addCriterion("NewsEntity.author <", value, "author");
/* 521:439 */       return (Criteria)this;
/* 522:    */     }
/* 523:    */     
/* 524:    */     public Criteria andAuthorLessThanOrEqualTo(String value)
/* 525:    */     {
/* 526:443 */       addCriterion("NewsEntity.author <=", value, "author");
/* 527:444 */       return (Criteria)this;
/* 528:    */     }
/* 529:    */     
/* 530:    */     public Criteria andAuthorLike(String value)
/* 531:    */     {
/* 532:448 */       addCriterion("NewsEntity.author like", value, "author");
/* 533:449 */       return (Criteria)this;
/* 534:    */     }
/* 535:    */     
/* 536:    */     public Criteria andAuthorNotLike(String value)
/* 537:    */     {
/* 538:453 */       addCriterion("NewsEntity.author not like", value, "author");
/* 539:454 */       return (Criteria)this;
/* 540:    */     }
/* 541:    */     
/* 542:    */     public Criteria andAuthorIn(List<String> values)
/* 543:    */     {
/* 544:458 */       addCriterion("NewsEntity.author in", values, "author");
/* 545:459 */       return (Criteria)this;
/* 546:    */     }
/* 547:    */     
/* 548:    */     public Criteria andAuthorNotIn(List<String> values)
/* 549:    */     {
/* 550:463 */       addCriterion("NewsEntity.author not in", values, "author");
/* 551:464 */       return (Criteria)this;
/* 552:    */     }
/* 553:    */     
/* 554:    */     public Criteria andAuthorBetween(String value1, String value2)
/* 555:    */     {
/* 556:468 */       addCriterion("NewsEntity.author between", value1, value2, "author");
/* 557:469 */       return (Criteria)this;
/* 558:    */     }
/* 559:    */     
/* 560:    */     public Criteria andAuthorNotBetween(String value1, String value2)
/* 561:    */     {
/* 562:473 */       addCriterion("NewsEntity.author not between", value1, value2, "author");
/* 563:474 */       return (Criteria)this;
/* 564:    */     }
/* 565:    */     
/* 566:    */     public Criteria andUrlIsNull()
/* 567:    */     {
/* 568:478 */       addCriterion("NewsEntity.url is null");
/* 569:479 */       return (Criteria)this;
/* 570:    */     }
/* 571:    */     
/* 572:    */     public Criteria andUrlIsNotNull()
/* 573:    */     {
/* 574:483 */       addCriterion("NewsEntity.url is not null");
/* 575:484 */       return (Criteria)this;
/* 576:    */     }
/* 577:    */     
/* 578:    */     public Criteria andUrlEqualTo(String value)
/* 579:    */     {
/* 580:488 */       addCriterion("NewsEntity.url =", value, "url");
/* 581:489 */       return (Criteria)this;
/* 582:    */     }
/* 583:    */     
/* 584:    */     public Criteria andUrlNotEqualTo(String value)
/* 585:    */     {
/* 586:493 */       addCriterion("NewsEntity.url <>", value, "url");
/* 587:494 */       return (Criteria)this;
/* 588:    */     }
/* 589:    */     
/* 590:    */     public Criteria andUrlGreaterThan(String value)
/* 591:    */     {
/* 592:498 */       addCriterion("NewsEntity.url >", value, "url");
/* 593:499 */       return (Criteria)this;
/* 594:    */     }
/* 595:    */     
/* 596:    */     public Criteria andUrlGreaterThanOrEqualTo(String value)
/* 597:    */     {
/* 598:503 */       addCriterion("NewsEntity.url >=", value, "url");
/* 599:504 */       return (Criteria)this;
/* 600:    */     }
/* 601:    */     
/* 602:    */     public Criteria andUrlLessThan(String value)
/* 603:    */     {
/* 604:508 */       addCriterion("NewsEntity.url <", value, "url");
/* 605:509 */       return (Criteria)this;
/* 606:    */     }
/* 607:    */     
/* 608:    */     public Criteria andUrlLessThanOrEqualTo(String value)
/* 609:    */     {
/* 610:513 */       addCriterion("NewsEntity.url <=", value, "url");
/* 611:514 */       return (Criteria)this;
/* 612:    */     }
/* 613:    */     
/* 614:    */     public Criteria andUrlLike(String value)
/* 615:    */     {
/* 616:518 */       addCriterion("NewsEntity.url like", value, "url");
/* 617:519 */       return (Criteria)this;
/* 618:    */     }
/* 619:    */     
/* 620:    */     public Criteria andUrlNotLike(String value)
/* 621:    */     {
/* 622:523 */       addCriterion("NewsEntity.url not like", value, "url");
/* 623:524 */       return (Criteria)this;
/* 624:    */     }
/* 625:    */     
/* 626:    */     public Criteria andUrlIn(List<String> values)
/* 627:    */     {
/* 628:528 */       addCriterion("NewsEntity.url in", values, "url");
/* 629:529 */       return (Criteria)this;
/* 630:    */     }
/* 631:    */     
/* 632:    */     public Criteria andUrlNotIn(List<String> values)
/* 633:    */     {
/* 634:533 */       addCriterion("NewsEntity.url not in", values, "url");
/* 635:534 */       return (Criteria)this;
/* 636:    */     }
/* 637:    */     
/* 638:    */     public Criteria andUrlBetween(String value1, String value2)
/* 639:    */     {
/* 640:538 */       addCriterion("NewsEntity.url between", value1, value2, "url");
/* 641:539 */       return (Criteria)this;
/* 642:    */     }
/* 643:    */     
/* 644:    */     public Criteria andUrlNotBetween(String value1, String value2)
/* 645:    */     {
/* 646:543 */       addCriterion("NewsEntity.url not between", value1, value2, "url");
/* 647:544 */       return (Criteria)this;
/* 648:    */     }
/* 649:    */     
/* 650:    */     public Criteria andTitleIsNull()
/* 651:    */     {
/* 652:548 */       addCriterion("NewsEntity.title is null");
/* 653:549 */       return (Criteria)this;
/* 654:    */     }
/* 655:    */     
/* 656:    */     public Criteria andTitleIsNotNull()
/* 657:    */     {
/* 658:553 */       addCriterion("NewsEntity.title is not null");
/* 659:554 */       return (Criteria)this;
/* 660:    */     }
/* 661:    */     
/* 662:    */     public Criteria andTitleEqualTo(String value)
/* 663:    */     {
/* 664:558 */       addCriterion("NewsEntity.title =", value, "title");
/* 665:559 */       return (Criteria)this;
/* 666:    */     }
/* 667:    */     
/* 668:    */     public Criteria andTitleNotEqualTo(String value)
/* 669:    */     {
/* 670:563 */       addCriterion("NewsEntity.title <>", value, "title");
/* 671:564 */       return (Criteria)this;
/* 672:    */     }
/* 673:    */     
/* 674:    */     public Criteria andTitleGreaterThan(String value)
/* 675:    */     {
/* 676:568 */       addCriterion("NewsEntity.title >", value, "title");
/* 677:569 */       return (Criteria)this;
/* 678:    */     }
/* 679:    */     
/* 680:    */     public Criteria andTitleGreaterThanOrEqualTo(String value)
/* 681:    */     {
/* 682:573 */       addCriterion("NewsEntity.title >=", value, "title");
/* 683:574 */       return (Criteria)this;
/* 684:    */     }
/* 685:    */     
/* 686:    */     public Criteria andTitleLessThan(String value)
/* 687:    */     {
/* 688:578 */       addCriterion("NewsEntity.title <", value, "title");
/* 689:579 */       return (Criteria)this;
/* 690:    */     }
/* 691:    */     
/* 692:    */     public Criteria andTitleLessThanOrEqualTo(String value)
/* 693:    */     {
/* 694:583 */       addCriterion("NewsEntity.title <=", value, "title");
/* 695:584 */       return (Criteria)this;
/* 696:    */     }
/* 697:    */     
/* 698:    */     public Criteria andTitleLike(String value)
/* 699:    */     {
/* 700:588 */       addCriterion("NewsEntity.title like", value, "title");
/* 701:589 */       return (Criteria)this;
/* 702:    */     }
/* 703:    */     
/* 704:    */     public Criteria andTitleNotLike(String value)
/* 705:    */     {
/* 706:593 */       addCriterion("NewsEntity.title not like", value, "title");
/* 707:594 */       return (Criteria)this;
/* 708:    */     }
/* 709:    */     
/* 710:    */     public Criteria andTitleIn(List<String> values)
/* 711:    */     {
/* 712:598 */       addCriterion("NewsEntity.title in", values, "title");
/* 713:599 */       return (Criteria)this;
/* 714:    */     }
/* 715:    */     
/* 716:    */     public Criteria andTitleNotIn(List<String> values)
/* 717:    */     {
/* 718:603 */       addCriterion("NewsEntity.title not in", values, "title");
/* 719:604 */       return (Criteria)this;
/* 720:    */     }
/* 721:    */     
/* 722:    */     public Criteria andTitleBetween(String value1, String value2)
/* 723:    */     {
/* 724:608 */       addCriterion("NewsEntity.title between", value1, value2, "title");
/* 725:609 */       return (Criteria)this;
/* 726:    */     }
/* 727:    */     
/* 728:    */     public Criteria andTitleNotBetween(String value1, String value2)
/* 729:    */     {
/* 730:613 */       addCriterion("NewsEntity.title not between", value1, value2, "title");
/* 731:614 */       return (Criteria)this;
/* 732:    */     }
/* 733:    */     
/* 734:    */     public Criteria andHeadimageIsNull()
/* 735:    */     {
/* 736:618 */       addCriterion("NewsEntity.headimage is null");
/* 737:619 */       return (Criteria)this;
/* 738:    */     }
/* 739:    */     
/* 740:    */     public Criteria andHeadimageIsNotNull()
/* 741:    */     {
/* 742:623 */       addCriterion("NewsEntity.headimage is not null");
/* 743:624 */       return (Criteria)this;
/* 744:    */     }
/* 745:    */     
/* 746:    */     public Criteria andHeadimageEqualTo(String value)
/* 747:    */     {
/* 748:628 */       addCriterion("NewsEntity.headimage =", value, "headimage");
/* 749:629 */       return (Criteria)this;
/* 750:    */     }
/* 751:    */     
/* 752:    */     public Criteria andHeadimageNotEqualTo(String value)
/* 753:    */     {
/* 754:633 */       addCriterion("NewsEntity.headimage <>", value, "headimage");
/* 755:634 */       return (Criteria)this;
/* 756:    */     }
/* 757:    */     
/* 758:    */     public Criteria andHeadimageGreaterThan(String value)
/* 759:    */     {
/* 760:638 */       addCriterion("NewsEntity.headimage >", value, "headimage");
/* 761:639 */       return (Criteria)this;
/* 762:    */     }
/* 763:    */     
/* 764:    */     public Criteria andHeadimageGreaterThanOrEqualTo(String value)
/* 765:    */     {
/* 766:643 */       addCriterion("NewsEntity.headimage >=", value, "headimage");
/* 767:644 */       return (Criteria)this;
/* 768:    */     }
/* 769:    */     
/* 770:    */     public Criteria andHeadimageLessThan(String value)
/* 771:    */     {
/* 772:648 */       addCriterion("NewsEntity.headimage <", value, "headimage");
/* 773:649 */       return (Criteria)this;
/* 774:    */     }
/* 775:    */     
/* 776:    */     public Criteria andHeadimageLessThanOrEqualTo(String value)
/* 777:    */     {
/* 778:653 */       addCriterion("NewsEntity.headimage <=", value, "headimage");
/* 779:654 */       return (Criteria)this;
/* 780:    */     }
/* 781:    */     
/* 782:    */     public Criteria andHeadimageLike(String value)
/* 783:    */     {
/* 784:658 */       addCriterion("NewsEntity.headimage like", value, "headimage");
/* 785:659 */       return (Criteria)this;
/* 786:    */     }
/* 787:    */     
/* 788:    */     public Criteria andHeadimageNotLike(String value)
/* 789:    */     {
/* 790:663 */       addCriterion("NewsEntity.headimage not like", value, "headimage");
/* 791:664 */       return (Criteria)this;
/* 792:    */     }
/* 793:    */     
/* 794:    */     public Criteria andHeadimageIn(List<String> values)
/* 795:    */     {
/* 796:668 */       addCriterion("NewsEntity.headimage in", values, "headimage");
/* 797:669 */       return (Criteria)this;
/* 798:    */     }
/* 799:    */     
/* 800:    */     public Criteria andHeadimageNotIn(List<String> values)
/* 801:    */     {
/* 802:673 */       addCriterion("NewsEntity.headimage not in", values, "headimage");
/* 803:674 */       return (Criteria)this;
/* 804:    */     }
/* 805:    */     
/* 806:    */     public Criteria andHeadimageBetween(String value1, String value2)
/* 807:    */     {
/* 808:678 */       addCriterion("NewsEntity.headimage between", value1, value2, "headimage");
/* 809:679 */       return (Criteria)this;
/* 810:    */     }
/* 811:    */     
/* 812:    */     public Criteria andHeadimageNotBetween(String value1, String value2)
/* 813:    */     {
/* 814:683 */       addCriterion("NewsEntity.headimage not between", value1, value2, "headimage");
/* 815:684 */       return (Criteria)this;
/* 816:    */     }
/* 817:    */   }
/* 818:    */   
/* 819:    */   public static class Criteria
/* 820:    */     extends GeneratedCriteria
/* 821:    */   {}
/* 822:    */   
/* 823:    */   public static class Criterion
/* 824:    */   {
/* 825:    */     private String condition;
/* 826:    */     private Object value;
/* 827:    */     private Object secondValue;
/* 828:    */     private boolean noValue;
/* 829:    */     private boolean singleValue;
/* 830:    */     private boolean betweenValue;
/* 831:    */     private boolean listValue;
/* 832:    */     private String typeHandler;
/* 833:    */     
/* 834:    */     public String getCondition()
/* 835:    */     {
/* 836:713 */       return this.condition;
/* 837:    */     }
/* 838:    */     
/* 839:    */     public Object getValue()
/* 840:    */     {
/* 841:717 */       return this.value;
/* 842:    */     }
/* 843:    */     
/* 844:    */     public Object getSecondValue()
/* 845:    */     {
/* 846:721 */       return this.secondValue;
/* 847:    */     }
/* 848:    */     
/* 849:    */     public boolean isNoValue()
/* 850:    */     {
/* 851:725 */       return this.noValue;
/* 852:    */     }
/* 853:    */     
/* 854:    */     public boolean isSingleValue()
/* 855:    */     {
/* 856:729 */       return this.singleValue;
/* 857:    */     }
/* 858:    */     
/* 859:    */     public boolean isBetweenValue()
/* 860:    */     {
/* 861:733 */       return this.betweenValue;
/* 862:    */     }
/* 863:    */     
/* 864:    */     public boolean isListValue()
/* 865:    */     {
/* 866:737 */       return this.listValue;
/* 867:    */     }
/* 868:    */     
/* 869:    */     public String getTypeHandler()
/* 870:    */     {
/* 871:741 */       return this.typeHandler;
/* 872:    */     }
/* 873:    */     
/* 874:    */     protected Criterion(String condition)
/* 875:    */     {
/* 876:746 */       this.condition = condition;
/* 877:747 */       this.typeHandler = null;
/* 878:748 */       this.noValue = true;
/* 879:    */     }
/* 880:    */     
/* 881:    */     protected Criterion(String condition, Object value, String typeHandler)
/* 882:    */     {
/* 883:753 */       this.condition = condition;
/* 884:754 */       this.value = value;
/* 885:755 */       this.typeHandler = typeHandler;
/* 886:756 */       if ((value instanceof List)) {
/* 887:757 */         this.listValue = true;
/* 888:    */       } else {
/* 889:759 */         this.singleValue = true;
/* 890:    */       }
/* 891:    */     }
/* 892:    */     
/* 893:    */     protected Criterion(String condition, Object value)
/* 894:    */     {
/* 895:764 */       this(condition, value, null);
/* 896:    */     }
/* 897:    */     
/* 898:    */     protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
/* 899:    */     {
/* 900:769 */       this.condition = condition;
/* 901:770 */       this.value = value;
/* 902:771 */       this.secondValue = secondValue;
/* 903:772 */       this.typeHandler = typeHandler;
/* 904:773 */       this.betweenValue = true;
/* 905:    */     }
/* 906:    */     
/* 907:    */     protected Criterion(String condition, Object value, Object secondValue)
/* 908:    */     {
/* 909:777 */       this(condition, value, secondValue, null);
/* 910:    */     }
/* 911:    */   }
/* 912:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.entity.NewsEntityExample

 * JD-Core Version:    0.7.0.1

 */