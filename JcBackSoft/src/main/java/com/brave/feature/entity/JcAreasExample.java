/*   1:    */ package com.brave.feature.entity;
/*   2:    */ 
/*   3:    */ import java.util.ArrayList;
/*   4:    */ import java.util.List;
/*   5:    */ 
/*   6:    */ public class JcAreasExample
/*   7:    */ {
/*   8:    */   protected String orderByClause;
/*   9:    */   protected boolean distinct;
/*  10:    */   protected List<Criteria> oredCriteria;
/*  11:    */   protected Integer limitStart;
/*  12:    */   protected Integer limitEnd;
/*  13:    */   
/*  14:    */   public JcAreasExample()
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
/* 146:    */     public Criteria andIdIsNull()
/* 147:    */     {
/* 148:128 */       addCriterion("JcAreas.id is null");
/* 149:129 */       return (Criteria)this;
/* 150:    */     }
/* 151:    */     
/* 152:    */     public Criteria andIdIsNotNull()
/* 153:    */     {
/* 154:133 */       addCriterion("JcAreas.id is not null");
/* 155:134 */       return (Criteria)this;
/* 156:    */     }
/* 157:    */     
/* 158:    */     public Criteria andIdEqualTo(Integer value)
/* 159:    */     {
/* 160:138 */       addCriterion("JcAreas.id =", value, "id");
/* 161:139 */       return (Criteria)this;
/* 162:    */     }
/* 163:    */     
/* 164:    */     public Criteria andIdNotEqualTo(Integer value)
/* 165:    */     {
/* 166:143 */       addCriterion("JcAreas.id <>", value, "id");
/* 167:144 */       return (Criteria)this;
/* 168:    */     }
/* 169:    */     
/* 170:    */     public Criteria andIdGreaterThan(Integer value)
/* 171:    */     {
/* 172:148 */       addCriterion("JcAreas.id >", value, "id");
/* 173:149 */       return (Criteria)this;
/* 174:    */     }
/* 175:    */     
/* 176:    */     public Criteria andIdGreaterThanOrEqualTo(Integer value)
/* 177:    */     {
/* 178:153 */       addCriterion("JcAreas.id >=", value, "id");
/* 179:154 */       return (Criteria)this;
/* 180:    */     }
/* 181:    */     
/* 182:    */     public Criteria andIdLessThan(Integer value)
/* 183:    */     {
/* 184:158 */       addCriterion("JcAreas.id <", value, "id");
/* 185:159 */       return (Criteria)this;
/* 186:    */     }
/* 187:    */     
/* 188:    */     public Criteria andIdLessThanOrEqualTo(Integer value)
/* 189:    */     {
/* 190:163 */       addCriterion("JcAreas.id <=", value, "id");
/* 191:164 */       return (Criteria)this;
/* 192:    */     }
/* 193:    */     
/* 194:    */     public Criteria andIdIn(List<Integer> values)
/* 195:    */     {
/* 196:168 */       addCriterion("JcAreas.id in", values, "id");
/* 197:169 */       return (Criteria)this;
/* 198:    */     }
/* 199:    */     
/* 200:    */     public Criteria andIdNotIn(List<Integer> values)
/* 201:    */     {
/* 202:173 */       addCriterion("JcAreas.id not in", values, "id");
/* 203:174 */       return (Criteria)this;
/* 204:    */     }
/* 205:    */     
/* 206:    */     public Criteria andIdBetween(Integer value1, Integer value2)
/* 207:    */     {
/* 208:178 */       addCriterion("JcAreas.id between", value1, value2, "id");
/* 209:179 */       return (Criteria)this;
/* 210:    */     }
/* 211:    */     
/* 212:    */     public Criteria andIdNotBetween(Integer value1, Integer value2)
/* 213:    */     {
/* 214:183 */       addCriterion("JcAreas.id not between", value1, value2, "id");
/* 215:184 */       return (Criteria)this;
/* 216:    */     }
/* 217:    */     
/* 218:    */     public Criteria andAreaidIsNull()
/* 219:    */     {
/* 220:188 */       addCriterion("JcAreas.areaid is null");
/* 221:189 */       return (Criteria)this;
/* 222:    */     }
/* 223:    */     
/* 224:    */     public Criteria andAreaidIsNotNull()
/* 225:    */     {
/* 226:193 */       addCriterion("JcAreas.areaid is not null");
/* 227:194 */       return (Criteria)this;
/* 228:    */     }
/* 229:    */     
/* 230:    */     public Criteria andAreaidEqualTo(String value)
/* 231:    */     {
/* 232:198 */       addCriterion("JcAreas.areaid =", value, "areaid");
/* 233:199 */       return (Criteria)this;
/* 234:    */     }
/* 235:    */     
/* 236:    */     public Criteria andAreaidNotEqualTo(String value)
/* 237:    */     {
/* 238:203 */       addCriterion("JcAreas.areaid <>", value, "areaid");
/* 239:204 */       return (Criteria)this;
/* 240:    */     }
/* 241:    */     
/* 242:    */     public Criteria andAreaidGreaterThan(String value)
/* 243:    */     {
/* 244:208 */       addCriterion("JcAreas.areaid >", value, "areaid");
/* 245:209 */       return (Criteria)this;
/* 246:    */     }
/* 247:    */     
/* 248:    */     public Criteria andAreaidGreaterThanOrEqualTo(String value)
/* 249:    */     {
/* 250:213 */       addCriterion("JcAreas.areaid >=", value, "areaid");
/* 251:214 */       return (Criteria)this;
/* 252:    */     }
/* 253:    */     
/* 254:    */     public Criteria andAreaidLessThan(String value)
/* 255:    */     {
/* 256:218 */       addCriterion("JcAreas.areaid <", value, "areaid");
/* 257:219 */       return (Criteria)this;
/* 258:    */     }
/* 259:    */     
/* 260:    */     public Criteria andAreaidLessThanOrEqualTo(String value)
/* 261:    */     {
/* 262:223 */       addCriterion("JcAreas.areaid <=", value, "areaid");
/* 263:224 */       return (Criteria)this;
/* 264:    */     }
/* 265:    */     
/* 266:    */     public Criteria andAreaidLike(String value)
/* 267:    */     {
/* 268:228 */       addCriterion("JcAreas.areaid like", value, "areaid");
/* 269:229 */       return (Criteria)this;
/* 270:    */     }
/* 271:    */     
/* 272:    */     public Criteria andAreaidNotLike(String value)
/* 273:    */     {
/* 274:233 */       addCriterion("JcAreas.areaid not like", value, "areaid");
/* 275:234 */       return (Criteria)this;
/* 276:    */     }
/* 277:    */     
/* 278:    */     public Criteria andAreaidIn(List<String> values)
/* 279:    */     {
/* 280:238 */       addCriterion("JcAreas.areaid in", values, "areaid");
/* 281:239 */       return (Criteria)this;
/* 282:    */     }
/* 283:    */     
/* 284:    */     public Criteria andAreaidNotIn(List<String> values)
/* 285:    */     {
/* 286:243 */       addCriterion("JcAreas.areaid not in", values, "areaid");
/* 287:244 */       return (Criteria)this;
/* 288:    */     }
/* 289:    */     
/* 290:    */     public Criteria andAreaidBetween(String value1, String value2)
/* 291:    */     {
/* 292:248 */       addCriterion("JcAreas.areaid between", value1, value2, "areaid");
/* 293:249 */       return (Criteria)this;
/* 294:    */     }
/* 295:    */     
/* 296:    */     public Criteria andAreaidNotBetween(String value1, String value2)
/* 297:    */     {
/* 298:253 */       addCriterion("JcAreas.areaid not between", value1, value2, "areaid");
/* 299:254 */       return (Criteria)this;
/* 300:    */     }
/* 301:    */     
/* 302:    */     public Criteria andAreapidIsNull()
/* 303:    */     {
/* 304:258 */       addCriterion("JcAreas.areapid is null");
/* 305:259 */       return (Criteria)this;
/* 306:    */     }
/* 307:    */     
/* 308:    */     public Criteria andAreapidIsNotNull()
/* 309:    */     {
/* 310:263 */       addCriterion("JcAreas.areapid is not null");
/* 311:264 */       return (Criteria)this;
/* 312:    */     }
/* 313:    */     
/* 314:    */     public Criteria andAreapidEqualTo(String value)
/* 315:    */     {
/* 316:268 */       addCriterion("JcAreas.areapid =", value, "areapid");
/* 317:269 */       return (Criteria)this;
/* 318:    */     }
/* 319:    */     
/* 320:    */     public Criteria andAreapidNotEqualTo(String value)
/* 321:    */     {
/* 322:273 */       addCriterion("JcAreas.areapid <>", value, "areapid");
/* 323:274 */       return (Criteria)this;
/* 324:    */     }
/* 325:    */     
/* 326:    */     public Criteria andAreapidGreaterThan(String value)
/* 327:    */     {
/* 328:278 */       addCriterion("JcAreas.areapid >", value, "areapid");
/* 329:279 */       return (Criteria)this;
/* 330:    */     }
/* 331:    */     
/* 332:    */     public Criteria andAreapidGreaterThanOrEqualTo(String value)
/* 333:    */     {
/* 334:283 */       addCriterion("JcAreas.areapid >=", value, "areapid");
/* 335:284 */       return (Criteria)this;
/* 336:    */     }
/* 337:    */     
/* 338:    */     public Criteria andAreapidLessThan(String value)
/* 339:    */     {
/* 340:288 */       addCriterion("JcAreas.areapid <", value, "areapid");
/* 341:289 */       return (Criteria)this;
/* 342:    */     }
/* 343:    */     
/* 344:    */     public Criteria andAreapidLessThanOrEqualTo(String value)
/* 345:    */     {
/* 346:293 */       addCriterion("JcAreas.areapid <=", value, "areapid");
/* 347:294 */       return (Criteria)this;
/* 348:    */     }
/* 349:    */     
/* 350:    */     public Criteria andAreapidLike(String value)
/* 351:    */     {
/* 352:298 */       addCriterion("JcAreas.areapid like", value, "areapid");
/* 353:299 */       return (Criteria)this;
/* 354:    */     }
/* 355:    */     
/* 356:    */     public Criteria andAreapidNotLike(String value)
/* 357:    */     {
/* 358:303 */       addCriterion("JcAreas.areapid not like", value, "areapid");
/* 359:304 */       return (Criteria)this;
/* 360:    */     }
/* 361:    */     
/* 362:    */     public Criteria andAreapidIn(List<String> values)
/* 363:    */     {
/* 364:308 */       addCriterion("JcAreas.areapid in", values, "areapid");
/* 365:309 */       return (Criteria)this;
/* 366:    */     }
/* 367:    */     
/* 368:    */     public Criteria andAreapidNotIn(List<String> values)
/* 369:    */     {
/* 370:313 */       addCriterion("JcAreas.areapid not in", values, "areapid");
/* 371:314 */       return (Criteria)this;
/* 372:    */     }
/* 373:    */     
/* 374:    */     public Criteria andAreapidBetween(String value1, String value2)
/* 375:    */     {
/* 376:318 */       addCriterion("JcAreas.areapid between", value1, value2, "areapid");
/* 377:319 */       return (Criteria)this;
/* 378:    */     }
/* 379:    */     
/* 380:    */     public Criteria andAreapidNotBetween(String value1, String value2)
/* 381:    */     {
/* 382:323 */       addCriterion("JcAreas.areapid not between", value1, value2, "areapid");
/* 383:324 */       return (Criteria)this;
/* 384:    */     }
/* 385:    */     
/* 386:    */     public Criteria andAreanameIsNull()
/* 387:    */     {
/* 388:328 */       addCriterion("JcAreas.areaname is null");
/* 389:329 */       return (Criteria)this;
/* 390:    */     }
/* 391:    */     
/* 392:    */     public Criteria andAreanameIsNotNull()
/* 393:    */     {
/* 394:333 */       addCriterion("JcAreas.areaname is not null");
/* 395:334 */       return (Criteria)this;
/* 396:    */     }
/* 397:    */     
/* 398:    */     public Criteria andAreanameEqualTo(String value)
/* 399:    */     {
/* 400:338 */       addCriterion("JcAreas.areaname =", value, "areaname");
/* 401:339 */       return (Criteria)this;
/* 402:    */     }
/* 403:    */     
/* 404:    */     public Criteria andAreanameNotEqualTo(String value)
/* 405:    */     {
/* 406:343 */       addCriterion("JcAreas.areaname <>", value, "areaname");
/* 407:344 */       return (Criteria)this;
/* 408:    */     }
/* 409:    */     
/* 410:    */     public Criteria andAreanameGreaterThan(String value)
/* 411:    */     {
/* 412:348 */       addCriterion("JcAreas.areaname >", value, "areaname");
/* 413:349 */       return (Criteria)this;
/* 414:    */     }
/* 415:    */     
/* 416:    */     public Criteria andAreanameGreaterThanOrEqualTo(String value)
/* 417:    */     {
/* 418:353 */       addCriterion("JcAreas.areaname >=", value, "areaname");
/* 419:354 */       return (Criteria)this;
/* 420:    */     }
/* 421:    */     
/* 422:    */     public Criteria andAreanameLessThan(String value)
/* 423:    */     {
/* 424:358 */       addCriterion("JcAreas.areaname <", value, "areaname");
/* 425:359 */       return (Criteria)this;
/* 426:    */     }
/* 427:    */     
/* 428:    */     public Criteria andAreanameLessThanOrEqualTo(String value)
/* 429:    */     {
/* 430:363 */       addCriterion("JcAreas.areaname <=", value, "areaname");
/* 431:364 */       return (Criteria)this;
/* 432:    */     }
/* 433:    */     
/* 434:    */     public Criteria andAreanameLike(String value)
/* 435:    */     {
/* 436:368 */       addCriterion("JcAreas.areaname like", value, "areaname");
/* 437:369 */       return (Criteria)this;
/* 438:    */     }
/* 439:    */     
/* 440:    */     public Criteria andAreanameNotLike(String value)
/* 441:    */     {
/* 442:373 */       addCriterion("JcAreas.areaname not like", value, "areaname");
/* 443:374 */       return (Criteria)this;
/* 444:    */     }
/* 445:    */     
/* 446:    */     public Criteria andAreanameIn(List<String> values)
/* 447:    */     {
/* 448:378 */       addCriterion("JcAreas.areaname in", values, "areaname");
/* 449:379 */       return (Criteria)this;
/* 450:    */     }
/* 451:    */     
/* 452:    */     public Criteria andAreanameNotIn(List<String> values)
/* 453:    */     {
/* 454:383 */       addCriterion("JcAreas.areaname not in", values, "areaname");
/* 455:384 */       return (Criteria)this;
/* 456:    */     }
/* 457:    */     
/* 458:    */     public Criteria andAreanameBetween(String value1, String value2)
/* 459:    */     {
/* 460:388 */       addCriterion("JcAreas.areaname between", value1, value2, "areaname");
/* 461:389 */       return (Criteria)this;
/* 462:    */     }
/* 463:    */     
/* 464:    */     public Criteria andAreanameNotBetween(String value1, String value2)
/* 465:    */     {
/* 466:393 */       addCriterion("JcAreas.areaname not between", value1, value2, "areaname");
/* 467:394 */       return (Criteria)this;
/* 468:    */     }
/* 469:    */     
/* 470:    */     public Criteria andSortIsNull()
/* 471:    */     {
/* 472:398 */       addCriterion("JcAreas.sort is null");
/* 473:399 */       return (Criteria)this;
/* 474:    */     }
/* 475:    */     
/* 476:    */     public Criteria andSortIsNotNull()
/* 477:    */     {
/* 478:403 */       addCriterion("JcAreas.sort is not null");
/* 479:404 */       return (Criteria)this;
/* 480:    */     }
/* 481:    */     
/* 482:    */     public Criteria andSortEqualTo(Integer value)
/* 483:    */     {
/* 484:408 */       addCriterion("JcAreas.sort =", value, "sort");
/* 485:409 */       return (Criteria)this;
/* 486:    */     }
/* 487:    */     
/* 488:    */     public Criteria andSortNotEqualTo(Integer value)
/* 489:    */     {
/* 490:413 */       addCriterion("JcAreas.sort <>", value, "sort");
/* 491:414 */       return (Criteria)this;
/* 492:    */     }
/* 493:    */     
/* 494:    */     public Criteria andSortGreaterThan(Integer value)
/* 495:    */     {
/* 496:418 */       addCriterion("JcAreas.sort >", value, "sort");
/* 497:419 */       return (Criteria)this;
/* 498:    */     }
/* 499:    */     
/* 500:    */     public Criteria andSortGreaterThanOrEqualTo(Integer value)
/* 501:    */     {
/* 502:423 */       addCriterion("JcAreas.sort >=", value, "sort");
/* 503:424 */       return (Criteria)this;
/* 504:    */     }
/* 505:    */     
/* 506:    */     public Criteria andSortLessThan(Integer value)
/* 507:    */     {
/* 508:428 */       addCriterion("JcAreas.sort <", value, "sort");
/* 509:429 */       return (Criteria)this;
/* 510:    */     }
/* 511:    */     
/* 512:    */     public Criteria andSortLessThanOrEqualTo(Integer value)
/* 513:    */     {
/* 514:433 */       addCriterion("JcAreas.sort <=", value, "sort");
/* 515:434 */       return (Criteria)this;
/* 516:    */     }
/* 517:    */     
/* 518:    */     public Criteria andSortIn(List<Integer> values)
/* 519:    */     {
/* 520:438 */       addCriterion("JcAreas.sort in", values, "sort");
/* 521:439 */       return (Criteria)this;
/* 522:    */     }
/* 523:    */     
/* 524:    */     public Criteria andSortNotIn(List<Integer> values)
/* 525:    */     {
/* 526:443 */       addCriterion("JcAreas.sort not in", values, "sort");
/* 527:444 */       return (Criteria)this;
/* 528:    */     }
/* 529:    */     
/* 530:    */     public Criteria andSortBetween(Integer value1, Integer value2)
/* 531:    */     {
/* 532:448 */       addCriterion("JcAreas.sort between", value1, value2, "sort");
/* 533:449 */       return (Criteria)this;
/* 534:    */     }
/* 535:    */     
/* 536:    */     public Criteria andSortNotBetween(Integer value1, Integer value2)
/* 537:    */     {
/* 538:453 */       addCriterion("JcAreas.sort not between", value1, value2, "sort");
/* 539:454 */       return (Criteria)this;
/* 540:    */     }
/* 541:    */   }
/* 542:    */   
/* 543:    */   public static class Criteria
/* 544:    */     extends GeneratedCriteria
/* 545:    */   {}
/* 546:    */   
/* 547:    */   public static class Criterion
/* 548:    */   {
/* 549:    */     private String condition;
/* 550:    */     private Object value;
/* 551:    */     private Object secondValue;
/* 552:    */     private boolean noValue;
/* 553:    */     private boolean singleValue;
/* 554:    */     private boolean betweenValue;
/* 555:    */     private boolean listValue;
/* 556:    */     private String typeHandler;
/* 557:    */     
/* 558:    */     public String getCondition()
/* 559:    */     {
/* 560:483 */       return this.condition;
/* 561:    */     }
/* 562:    */     
/* 563:    */     public Object getValue()
/* 564:    */     {
/* 565:487 */       return this.value;
/* 566:    */     }
/* 567:    */     
/* 568:    */     public Object getSecondValue()
/* 569:    */     {
/* 570:491 */       return this.secondValue;
/* 571:    */     }
/* 572:    */     
/* 573:    */     public boolean isNoValue()
/* 574:    */     {
/* 575:495 */       return this.noValue;
/* 576:    */     }
/* 577:    */     
/* 578:    */     public boolean isSingleValue()
/* 579:    */     {
/* 580:499 */       return this.singleValue;
/* 581:    */     }
/* 582:    */     
/* 583:    */     public boolean isBetweenValue()
/* 584:    */     {
/* 585:503 */       return this.betweenValue;
/* 586:    */     }
/* 587:    */     
/* 588:    */     public boolean isListValue()
/* 589:    */     {
/* 590:507 */       return this.listValue;
/* 591:    */     }
/* 592:    */     
/* 593:    */     public String getTypeHandler()
/* 594:    */     {
/* 595:511 */       return this.typeHandler;
/* 596:    */     }
/* 597:    */     
/* 598:    */     protected Criterion(String condition)
/* 599:    */     {
/* 600:516 */       this.condition = condition;
/* 601:517 */       this.typeHandler = null;
/* 602:518 */       this.noValue = true;
/* 603:    */     }
/* 604:    */     
/* 605:    */     protected Criterion(String condition, Object value, String typeHandler)
/* 606:    */     {
/* 607:523 */       this.condition = condition;
/* 608:524 */       this.value = value;
/* 609:525 */       this.typeHandler = typeHandler;
/* 610:526 */       if ((value instanceof List)) {
/* 611:527 */         this.listValue = true;
/* 612:    */       } else {
/* 613:529 */         this.singleValue = true;
/* 614:    */       }
/* 615:    */     }
/* 616:    */     
/* 617:    */     protected Criterion(String condition, Object value)
/* 618:    */     {
/* 619:534 */       this(condition, value, null);
/* 620:    */     }
/* 621:    */     
/* 622:    */     protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
/* 623:    */     {
/* 624:539 */       this.condition = condition;
/* 625:540 */       this.value = value;
/* 626:541 */       this.secondValue = secondValue;
/* 627:542 */       this.typeHandler = typeHandler;
/* 628:543 */       this.betweenValue = true;
/* 629:    */     }
/* 630:    */     
/* 631:    */     protected Criterion(String condition, Object value, Object secondValue)
/* 632:    */     {
/* 633:547 */       this(condition, value, secondValue, null);
/* 634:    */     }
/* 635:    */   }
/* 636:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.entity.JcAreasExample

 * JD-Core Version:    0.7.0.1

 */