/*    1:     */ package com.brave.system.entity;
/*    2:     */ 
/*    3:     */ import java.util.ArrayList;
/*    4:     */ import java.util.List;
/*    5:     */ 
/*    6:     */ public class UserInfoExample
/*    7:     */ {
/*    8:     */   protected String orderByClause;
/*    9:     */   protected boolean distinct;
/*   10:     */   protected List<Criteria> oredCriteria;
/*   11:     */   protected Integer limitStart;
/*   12:     */   protected Integer limitEnd;
/*   13:     */   
/*   14:     */   public UserInfoExample()
/*   15:     */   {
/*   16:  18 */     this.oredCriteria = new ArrayList();
/*   17:     */   }
/*   18:     */   
/*   19:     */   public void setOrderByClause(String orderByClause)
/*   20:     */   {
/*   21:  22 */     this.orderByClause = orderByClause;
/*   22:     */   }
/*   23:     */   
/*   24:     */   public String getOrderByClause()
/*   25:     */   {
/*   26:  26 */     return this.orderByClause;
/*   27:     */   }
/*   28:     */   
/*   29:     */   public void setDistinct(boolean distinct)
/*   30:     */   {
/*   31:  30 */     this.distinct = distinct;
/*   32:     */   }
/*   33:     */   
/*   34:     */   public boolean isDistinct()
/*   35:     */   {
/*   36:  34 */     return this.distinct;
/*   37:     */   }
/*   38:     */   
/*   39:     */   public List<Criteria> getOredCriteria()
/*   40:     */   {
/*   41:  38 */     return this.oredCriteria;
/*   42:     */   }
/*   43:     */   
/*   44:     */   public void or(Criteria criteria)
/*   45:     */   {
/*   46:  42 */     this.oredCriteria.add(criteria);
/*   47:     */   }
/*   48:     */   
/*   49:     */   public Criteria or()
/*   50:     */   {
/*   51:  46 */     Criteria criteria = createCriteriaInternal();
/*   52:  47 */     this.oredCriteria.add(criteria);
/*   53:  48 */     return criteria;
/*   54:     */   }
/*   55:     */   
/*   56:     */   public Criteria createCriteria()
/*   57:     */   {
/*   58:  52 */     Criteria criteria = createCriteriaInternal();
/*   59:  53 */     if (this.oredCriteria.size() == 0) {
/*   60:  54 */       this.oredCriteria.add(criteria);
/*   61:     */     }
/*   62:  56 */     return criteria;
/*   63:     */   }
/*   64:     */   
/*   65:     */   protected Criteria createCriteriaInternal()
/*   66:     */   {
/*   67:  60 */     Criteria criteria = new Criteria();
/*   68:  61 */     return criteria;
/*   69:     */   }
/*   70:     */   
/*   71:     */   public void clear()
/*   72:     */   {
/*   73:  65 */     this.oredCriteria.clear();
/*   74:  66 */     this.orderByClause = null;
/*   75:  67 */     this.distinct = false;
/*   76:     */   }
/*   77:     */   
/*   78:     */   public void setLimitStart(Integer limitStart)
/*   79:     */   {
/*   80:  71 */     this.limitStart = limitStart;
/*   81:     */   }
/*   82:     */   
/*   83:     */   public Integer getLimitStart()
/*   84:     */   {
/*   85:  75 */     return this.limitStart;
/*   86:     */   }
/*   87:     */   
/*   88:     */   public void setLimitEnd(Integer limitEnd)
/*   89:     */   {
/*   90:  79 */     this.limitEnd = limitEnd;
/*   91:     */   }
/*   92:     */   
/*   93:     */   public Integer getLimitEnd()
/*   94:     */   {
/*   95:  83 */     return this.limitEnd;
/*   96:     */   }
/*   97:     */   
/*   98:     */   protected static abstract class GeneratedCriteria
/*   99:     */   {
/*  100:     */     protected List<Criterion> criteria;
/*  101:     */     
/*  102:     */     protected GeneratedCriteria()
/*  103:     */     {
/*  104:  91 */       this.criteria = new ArrayList();
/*  105:     */     }
/*  106:     */     
/*  107:     */     public boolean isValid()
/*  108:     */     {
/*  109:  95 */       return this.criteria.size() > 0;
/*  110:     */     }
/*  111:     */     
/*  112:     */     public List<Criterion> getAllCriteria()
/*  113:     */     {
/*  114:  99 */       return this.criteria;
/*  115:     */     }
/*  116:     */     
/*  117:     */     public List<Criterion> getCriteria()
/*  118:     */     {
/*  119: 103 */       return this.criteria;
/*  120:     */     }
/*  121:     */     
/*  122:     */     protected void addCriterion(String condition)
/*  123:     */     {
/*  124: 107 */       if (condition == null) {
/*  125: 108 */         throw new RuntimeException("Value for condition cannot be null");
/*  126:     */       }
/*  127: 110 */       this.criteria.add(new Criterion(condition));
/*  128:     */     }
/*  129:     */     
/*  130:     */     protected void addCriterion(String condition, Object value, String property)
/*  131:     */     {
/*  132: 114 */       if (value == null) {
/*  133: 115 */         throw new RuntimeException("Value for " + property + " cannot be null");
/*  134:     */       }
/*  135: 117 */       this.criteria.add(new Criterion(condition, value));
/*  136:     */     }
/*  137:     */     
/*  138:     */     protected void addCriterion(String condition, Object value1, Object value2, String property)
/*  139:     */     {
/*  140: 121 */       if ((value1 == null) || (value2 == null)) {
/*  141: 122 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/*  142:     */       }
/*  143: 124 */       this.criteria.add(new Criterion(condition, value1, value2));
/*  144:     */     }
/*  145:     */     
/*  146:     */     public Criteria andIdIsNull()
/*  147:     */     {
/*  148: 128 */       addCriterion("UserInfo.id is null");
/*  149: 129 */       return (Criteria)this;
/*  150:     */     }
/*  151:     */     
/*  152:     */     public Criteria andIdIsNotNull()
/*  153:     */     {
/*  154: 133 */       addCriterion("UserInfo.id is not null");
/*  155: 134 */       return (Criteria)this;
/*  156:     */     }
/*  157:     */     
/*  158:     */     public Criteria andIdEqualTo(String value)
/*  159:     */     {
/*  160: 138 */       addCriterion("UserInfo.id =", value, "id");
/*  161: 139 */       return (Criteria)this;
/*  162:     */     }
/*  163:     */     
/*  164:     */     public Criteria andIdNotEqualTo(String value)
/*  165:     */     {
/*  166: 143 */       addCriterion("UserInfo.id <>", value, "id");
/*  167: 144 */       return (Criteria)this;
/*  168:     */     }
/*  169:     */     
/*  170:     */     public Criteria andIdGreaterThan(String value)
/*  171:     */     {
/*  172: 148 */       addCriterion("UserInfo.id >", value, "id");
/*  173: 149 */       return (Criteria)this;
/*  174:     */     }
/*  175:     */     
/*  176:     */     public Criteria andIdGreaterThanOrEqualTo(String value)
/*  177:     */     {
/*  178: 153 */       addCriterion("UserInfo.id >=", value, "id");
/*  179: 154 */       return (Criteria)this;
/*  180:     */     }
/*  181:     */     
/*  182:     */     public Criteria andIdLessThan(String value)
/*  183:     */     {
/*  184: 158 */       addCriterion("UserInfo.id <", value, "id");
/*  185: 159 */       return (Criteria)this;
/*  186:     */     }
/*  187:     */     
/*  188:     */     public Criteria andIdLessThanOrEqualTo(String value)
/*  189:     */     {
/*  190: 163 */       addCriterion("UserInfo.id <=", value, "id");
/*  191: 164 */       return (Criteria)this;
/*  192:     */     }
/*  193:     */     
/*  194:     */     public Criteria andIdLike(String value)
/*  195:     */     {
/*  196: 168 */       addCriterion("UserInfo.id like", value, "id");
/*  197: 169 */       return (Criteria)this;
/*  198:     */     }
/*  199:     */     
/*  200:     */     public Criteria andIdNotLike(String value)
/*  201:     */     {
/*  202: 173 */       addCriterion("UserInfo.id not like", value, "id");
/*  203: 174 */       return (Criteria)this;
/*  204:     */     }
/*  205:     */     
/*  206:     */     public Criteria andIdIn(List<String> values)
/*  207:     */     {
/*  208: 178 */       addCriterion("UserInfo.id in", values, "id");
/*  209: 179 */       return (Criteria)this;
/*  210:     */     }
/*  211:     */     
/*  212:     */     public Criteria andIdNotIn(List<String> values)
/*  213:     */     {
/*  214: 183 */       addCriterion("UserInfo.id not in", values, "id");
/*  215: 184 */       return (Criteria)this;
/*  216:     */     }
/*  217:     */     
/*  218:     */     public Criteria andIdBetween(String value1, String value2)
/*  219:     */     {
/*  220: 188 */       addCriterion("UserInfo.id between", value1, value2, "id");
/*  221: 189 */       return (Criteria)this;
/*  222:     */     }
/*  223:     */     
/*  224:     */     public Criteria andIdNotBetween(String value1, String value2)
/*  225:     */     {
/*  226: 193 */       addCriterion("UserInfo.id not between", value1, value2, "id");
/*  227: 194 */       return (Criteria)this;
/*  228:     */     }
/*  229:     */     
/*  230:     */     public Criteria andUsernameIsNull()
/*  231:     */     {
/*  232: 198 */       addCriterion("UserInfo.username is null");
/*  233: 199 */       return (Criteria)this;
/*  234:     */     }
/*  235:     */     
/*  236:     */     public Criteria andUsernameIsNotNull()
/*  237:     */     {
/*  238: 203 */       addCriterion("UserInfo.username is not null");
/*  239: 204 */       return (Criteria)this;
/*  240:     */     }
/*  241:     */     
/*  242:     */     public Criteria andUsernameEqualTo(String value)
/*  243:     */     {
/*  244: 208 */       addCriterion("UserInfo.username =", value, "username");
/*  245: 209 */       return (Criteria)this;
/*  246:     */     }
/*  247:     */     
/*  248:     */     public Criteria andUsernameNotEqualTo(String value)
/*  249:     */     {
/*  250: 213 */       addCriterion("UserInfo.username <>", value, "username");
/*  251: 214 */       return (Criteria)this;
/*  252:     */     }
/*  253:     */     
/*  254:     */     public Criteria andUsernameGreaterThan(String value)
/*  255:     */     {
/*  256: 218 */       addCriterion("UserInfo.username >", value, "username");
/*  257: 219 */       return (Criteria)this;
/*  258:     */     }
/*  259:     */     
/*  260:     */     public Criteria andUsernameGreaterThanOrEqualTo(String value)
/*  261:     */     {
/*  262: 223 */       addCriterion("UserInfo.username >=", value, "username");
/*  263: 224 */       return (Criteria)this;
/*  264:     */     }
/*  265:     */     
/*  266:     */     public Criteria andUsernameLessThan(String value)
/*  267:     */     {
/*  268: 228 */       addCriterion("UserInfo.username <", value, "username");
/*  269: 229 */       return (Criteria)this;
/*  270:     */     }
/*  271:     */     
/*  272:     */     public Criteria andUsernameLessThanOrEqualTo(String value)
/*  273:     */     {
/*  274: 233 */       addCriterion("UserInfo.username <=", value, "username");
/*  275: 234 */       return (Criteria)this;
/*  276:     */     }
/*  277:     */     
/*  278:     */     public Criteria andUsernameLike(String value)
/*  279:     */     {
/*  280: 238 */       addCriterion("UserInfo.username like", value, "username");
/*  281: 239 */       return (Criteria)this;
/*  282:     */     }
/*  283:     */     
/*  284:     */     public Criteria andUsernameNotLike(String value)
/*  285:     */     {
/*  286: 243 */       addCriterion("UserInfo.username not like", value, "username");
/*  287: 244 */       return (Criteria)this;
/*  288:     */     }
/*  289:     */     
/*  290:     */     public Criteria andUsernameIn(List<String> values)
/*  291:     */     {
/*  292: 248 */       addCriterion("UserInfo.username in", values, "username");
/*  293: 249 */       return (Criteria)this;
/*  294:     */     }
/*  295:     */     
/*  296:     */     public Criteria andUsernameNotIn(List<String> values)
/*  297:     */     {
/*  298: 253 */       addCriterion("UserInfo.username not in", values, "username");
/*  299: 254 */       return (Criteria)this;
/*  300:     */     }
/*  301:     */     
/*  302:     */     public Criteria andUsernameBetween(String value1, String value2)
/*  303:     */     {
/*  304: 258 */       addCriterion("UserInfo.username between", value1, value2, "username");
/*  305: 259 */       return (Criteria)this;
/*  306:     */     }
/*  307:     */     
/*  308:     */     public Criteria andUsernameNotBetween(String value1, String value2)
/*  309:     */     {
/*  310: 263 */       addCriterion("UserInfo.username not between", value1, value2, "username");
/*  311: 264 */       return (Criteria)this;
/*  312:     */     }
/*  313:     */     
/*  314:     */     public Criteria andHxidIsNull()
/*  315:     */     {
/*  316: 268 */       addCriterion("UserInfo.hxid is null");
/*  317: 269 */       return (Criteria)this;
/*  318:     */     }
/*  319:     */     
/*  320:     */     public Criteria andHxidIsNotNull()
/*  321:     */     {
/*  322: 273 */       addCriterion("UserInfo.hxid is not null");
/*  323: 274 */       return (Criteria)this;
/*  324:     */     }
/*  325:     */     
/*  326:     */     public Criteria andHxidEqualTo(String value)
/*  327:     */     {
/*  328: 278 */       addCriterion("UserInfo.hxid =", value, "hxid");
/*  329: 279 */       return (Criteria)this;
/*  330:     */     }
/*  331:     */     
/*  332:     */     public Criteria andHxidNotEqualTo(String value)
/*  333:     */     {
/*  334: 283 */       addCriterion("UserInfo.hxid <>", value, "hxid");
/*  335: 284 */       return (Criteria)this;
/*  336:     */     }
/*  337:     */     
/*  338:     */     public Criteria andHxidGreaterThan(String value)
/*  339:     */     {
/*  340: 288 */       addCriterion("UserInfo.hxid >", value, "hxid");
/*  341: 289 */       return (Criteria)this;
/*  342:     */     }
/*  343:     */     
/*  344:     */     public Criteria andHxidGreaterThanOrEqualTo(String value)
/*  345:     */     {
/*  346: 293 */       addCriterion("UserInfo.hxid >=", value, "hxid");
/*  347: 294 */       return (Criteria)this;
/*  348:     */     }
/*  349:     */     
/*  350:     */     public Criteria andHxidLessThan(String value)
/*  351:     */     {
/*  352: 298 */       addCriterion("UserInfo.hxid <", value, "hxid");
/*  353: 299 */       return (Criteria)this;
/*  354:     */     }
/*  355:     */     
/*  356:     */     public Criteria andHxidLessThanOrEqualTo(String value)
/*  357:     */     {
/*  358: 303 */       addCriterion("UserInfo.hxid <=", value, "hxid");
/*  359: 304 */       return (Criteria)this;
/*  360:     */     }
/*  361:     */     
/*  362:     */     public Criteria andHxidLike(String value)
/*  363:     */     {
/*  364: 308 */       addCriterion("UserInfo.hxid like", value, "hxid");
/*  365: 309 */       return (Criteria)this;
/*  366:     */     }
/*  367:     */     
/*  368:     */     public Criteria andHxidNotLike(String value)
/*  369:     */     {
/*  370: 313 */       addCriterion("UserInfo.hxid not like", value, "hxid");
/*  371: 314 */       return (Criteria)this;
/*  372:     */     }
/*  373:     */     
/*  374:     */     public Criteria andHxidIn(List<String> values)
/*  375:     */     {
/*  376: 318 */       addCriterion("UserInfo.hxid in", values, "hxid");
/*  377: 319 */       return (Criteria)this;
/*  378:     */     }
/*  379:     */     
/*  380:     */     public Criteria andHxidNotIn(List<String> values)
/*  381:     */     {
/*  382: 323 */       addCriterion("UserInfo.hxid not in", values, "hxid");
/*  383: 324 */       return (Criteria)this;
/*  384:     */     }
/*  385:     */     
/*  386:     */     public Criteria andHxidBetween(String value1, String value2)
/*  387:     */     {
/*  388: 328 */       addCriterion("UserInfo.hxid between", value1, value2, "hxid");
/*  389: 329 */       return (Criteria)this;
/*  390:     */     }
/*  391:     */     
/*  392:     */     public Criteria andHxidNotBetween(String value1, String value2)
/*  393:     */     {
/*  394: 333 */       addCriterion("UserInfo.hxid not between", value1, value2, "hxid");
/*  395: 334 */       return (Criteria)this;
/*  396:     */     }
/*  397:     */     
/*  398:     */     public Criteria andPasswordIsNull()
/*  399:     */     {
/*  400: 338 */       addCriterion("UserInfo.password is null");
/*  401: 339 */       return (Criteria)this;
/*  402:     */     }
/*  403:     */     
/*  404:     */     public Criteria andPasswordIsNotNull()
/*  405:     */     {
/*  406: 343 */       addCriterion("UserInfo.password is not null");
/*  407: 344 */       return (Criteria)this;
/*  408:     */     }
/*  409:     */     
/*  410:     */     public Criteria andPasswordEqualTo(String value)
/*  411:     */     {
/*  412: 348 */       addCriterion("UserInfo.password =", value, "password");
/*  413: 349 */       return (Criteria)this;
/*  414:     */     }
/*  415:     */     
/*  416:     */     public Criteria andPasswordNotEqualTo(String value)
/*  417:     */     {
/*  418: 353 */       addCriterion("UserInfo.password <>", value, "password");
/*  419: 354 */       return (Criteria)this;
/*  420:     */     }
/*  421:     */     
/*  422:     */     public Criteria andPasswordGreaterThan(String value)
/*  423:     */     {
/*  424: 358 */       addCriterion("UserInfo.password >", value, "password");
/*  425: 359 */       return (Criteria)this;
/*  426:     */     }
/*  427:     */     
/*  428:     */     public Criteria andPasswordGreaterThanOrEqualTo(String value)
/*  429:     */     {
/*  430: 363 */       addCriterion("UserInfo.password >=", value, "password");
/*  431: 364 */       return (Criteria)this;
/*  432:     */     }
/*  433:     */     
/*  434:     */     public Criteria andPasswordLessThan(String value)
/*  435:     */     {
/*  436: 368 */       addCriterion("UserInfo.password <", value, "password");
/*  437: 369 */       return (Criteria)this;
/*  438:     */     }
/*  439:     */     
/*  440:     */     public Criteria andPasswordLessThanOrEqualTo(String value)
/*  441:     */     {
/*  442: 373 */       addCriterion("UserInfo.password <=", value, "password");
/*  443: 374 */       return (Criteria)this;
/*  444:     */     }
/*  445:     */     
/*  446:     */     public Criteria andPasswordLike(String value)
/*  447:     */     {
/*  448: 378 */       addCriterion("UserInfo.password like", value, "password");
/*  449: 379 */       return (Criteria)this;
/*  450:     */     }
/*  451:     */     
/*  452:     */     public Criteria andPasswordNotLike(String value)
/*  453:     */     {
/*  454: 383 */       addCriterion("UserInfo.password not like", value, "password");
/*  455: 384 */       return (Criteria)this;
/*  456:     */     }
/*  457:     */     
/*  458:     */     public Criteria andPasswordIn(List<String> values)
/*  459:     */     {
/*  460: 388 */       addCriterion("UserInfo.password in", values, "password");
/*  461: 389 */       return (Criteria)this;
/*  462:     */     }
/*  463:     */     
/*  464:     */     public Criteria andPasswordNotIn(List<String> values)
/*  465:     */     {
/*  466: 393 */       addCriterion("UserInfo.password not in", values, "password");
/*  467: 394 */       return (Criteria)this;
/*  468:     */     }
/*  469:     */     
/*  470:     */     public Criteria andPasswordBetween(String value1, String value2)
/*  471:     */     {
/*  472: 398 */       addCriterion("UserInfo.password between", value1, value2, "password");
/*  473: 399 */       return (Criteria)this;
/*  474:     */     }
/*  475:     */     
/*  476:     */     public Criteria andPasswordNotBetween(String value1, String value2)
/*  477:     */     {
/*  478: 403 */       addCriterion("UserInfo.password not between", value1, value2, "password");
/*  479: 404 */       return (Criteria)this;
/*  480:     */     }
/*  481:     */     
/*  482:     */     public Criteria andStateIsNull()
/*  483:     */     {
/*  484: 408 */       addCriterion("UserInfo.state is null");
/*  485: 409 */       return (Criteria)this;
/*  486:     */     }
/*  487:     */     
/*  488:     */     public Criteria andStateIsNotNull()
/*  489:     */     {
/*  490: 413 */       addCriterion("UserInfo.state is not null");
/*  491: 414 */       return (Criteria)this;
/*  492:     */     }
/*  493:     */     
/*  494:     */     public Criteria andStateEqualTo(String value)
/*  495:     */     {
/*  496: 418 */       addCriterion("UserInfo.state =", value, "state");
/*  497: 419 */       return (Criteria)this;
/*  498:     */     }
/*  499:     */     
/*  500:     */     public Criteria andStateNotEqualTo(String value)
/*  501:     */     {
/*  502: 423 */       addCriterion("UserInfo.state <>", value, "state");
/*  503: 424 */       return (Criteria)this;
/*  504:     */     }
/*  505:     */     
/*  506:     */     public Criteria andStateGreaterThan(String value)
/*  507:     */     {
/*  508: 428 */       addCriterion("UserInfo.state >", value, "state");
/*  509: 429 */       return (Criteria)this;
/*  510:     */     }
/*  511:     */     
/*  512:     */     public Criteria andStateGreaterThanOrEqualTo(String value)
/*  513:     */     {
/*  514: 433 */       addCriterion("UserInfo.state >=", value, "state");
/*  515: 434 */       return (Criteria)this;
/*  516:     */     }
/*  517:     */     
/*  518:     */     public Criteria andStateLessThan(String value)
/*  519:     */     {
/*  520: 438 */       addCriterion("UserInfo.state <", value, "state");
/*  521: 439 */       return (Criteria)this;
/*  522:     */     }
/*  523:     */     
/*  524:     */     public Criteria andStateLessThanOrEqualTo(String value)
/*  525:     */     {
/*  526: 443 */       addCriterion("UserInfo.state <=", value, "state");
/*  527: 444 */       return (Criteria)this;
/*  528:     */     }
/*  529:     */     
/*  530:     */     public Criteria andStateLike(String value)
/*  531:     */     {
/*  532: 448 */       addCriterion("UserInfo.state like", value, "state");
/*  533: 449 */       return (Criteria)this;
/*  534:     */     }
/*  535:     */     
/*  536:     */     public Criteria andStateNotLike(String value)
/*  537:     */     {
/*  538: 453 */       addCriterion("UserInfo.state not like", value, "state");
/*  539: 454 */       return (Criteria)this;
/*  540:     */     }
/*  541:     */     
/*  542:     */     public Criteria andStateIn(List<String> values)
/*  543:     */     {
/*  544: 458 */       addCriterion("UserInfo.state in", values, "state");
/*  545: 459 */       return (Criteria)this;
/*  546:     */     }
/*  547:     */     
/*  548:     */     public Criteria andStateNotIn(List<String> values)
/*  549:     */     {
/*  550: 463 */       addCriterion("UserInfo.state not in", values, "state");
/*  551: 464 */       return (Criteria)this;
/*  552:     */     }
/*  553:     */     
/*  554:     */     public Criteria andStateBetween(String value1, String value2)
/*  555:     */     {
/*  556: 468 */       addCriterion("UserInfo.state between", value1, value2, "state");
/*  557: 469 */       return (Criteria)this;
/*  558:     */     }
/*  559:     */     
/*  560:     */     public Criteria andStateNotBetween(String value1, String value2)
/*  561:     */     {
/*  562: 473 */       addCriterion("UserInfo.state not between", value1, value2, "state");
/*  563: 474 */       return (Criteria)this;
/*  564:     */     }
/*  565:     */     
/*  566:     */     public Criteria andSexIsNull()
/*  567:     */     {
/*  568: 478 */       addCriterion("UserInfo.sex is null");
/*  569: 479 */       return (Criteria)this;
/*  570:     */     }
/*  571:     */     
/*  572:     */     public Criteria andSexIsNotNull()
/*  573:     */     {
/*  574: 483 */       addCriterion("UserInfo.sex is not null");
/*  575: 484 */       return (Criteria)this;
/*  576:     */     }
/*  577:     */     
/*  578:     */     public Criteria andSexEqualTo(String value)
/*  579:     */     {
/*  580: 488 */       addCriterion("UserInfo.sex =", value, "sex");
/*  581: 489 */       return (Criteria)this;
/*  582:     */     }
/*  583:     */     
/*  584:     */     public Criteria andSexNotEqualTo(String value)
/*  585:     */     {
/*  586: 493 */       addCriterion("UserInfo.sex <>", value, "sex");
/*  587: 494 */       return (Criteria)this;
/*  588:     */     }
/*  589:     */     
/*  590:     */     public Criteria andSexGreaterThan(String value)
/*  591:     */     {
/*  592: 498 */       addCriterion("UserInfo.sex >", value, "sex");
/*  593: 499 */       return (Criteria)this;
/*  594:     */     }
/*  595:     */     
/*  596:     */     public Criteria andSexGreaterThanOrEqualTo(String value)
/*  597:     */     {
/*  598: 503 */       addCriterion("UserInfo.sex >=", value, "sex");
/*  599: 504 */       return (Criteria)this;
/*  600:     */     }
/*  601:     */     
/*  602:     */     public Criteria andSexLessThan(String value)
/*  603:     */     {
/*  604: 508 */       addCriterion("UserInfo.sex <", value, "sex");
/*  605: 509 */       return (Criteria)this;
/*  606:     */     }
/*  607:     */     
/*  608:     */     public Criteria andSexLessThanOrEqualTo(String value)
/*  609:     */     {
/*  610: 513 */       addCriterion("UserInfo.sex <=", value, "sex");
/*  611: 514 */       return (Criteria)this;
/*  612:     */     }
/*  613:     */     
/*  614:     */     public Criteria andSexLike(String value)
/*  615:     */     {
/*  616: 518 */       addCriterion("UserInfo.sex like", value, "sex");
/*  617: 519 */       return (Criteria)this;
/*  618:     */     }
/*  619:     */     
/*  620:     */     public Criteria andSexNotLike(String value)
/*  621:     */     {
/*  622: 523 */       addCriterion("UserInfo.sex not like", value, "sex");
/*  623: 524 */       return (Criteria)this;
/*  624:     */     }
/*  625:     */     
/*  626:     */     public Criteria andSexIn(List<String> values)
/*  627:     */     {
/*  628: 528 */       addCriterion("UserInfo.sex in", values, "sex");
/*  629: 529 */       return (Criteria)this;
/*  630:     */     }
/*  631:     */     
/*  632:     */     public Criteria andSexNotIn(List<String> values)
/*  633:     */     {
/*  634: 533 */       addCriterion("UserInfo.sex not in", values, "sex");
/*  635: 534 */       return (Criteria)this;
/*  636:     */     }
/*  637:     */     
/*  638:     */     public Criteria andSexBetween(String value1, String value2)
/*  639:     */     {
/*  640: 538 */       addCriterion("UserInfo.sex between", value1, value2, "sex");
/*  641: 539 */       return (Criteria)this;
/*  642:     */     }
/*  643:     */     
/*  644:     */     public Criteria andSexNotBetween(String value1, String value2)
/*  645:     */     {
/*  646: 543 */       addCriterion("UserInfo.sex not between", value1, value2, "sex");
/*  647: 544 */       return (Criteria)this;
/*  648:     */     }
/*  649:     */     
/*  650:     */     public Criteria andPhoneIsNull()
/*  651:     */     {
/*  652: 548 */       addCriterion("UserInfo.phone is null");
/*  653: 549 */       return (Criteria)this;
/*  654:     */     }
/*  655:     */     
/*  656:     */     public Criteria andPhoneIsNotNull()
/*  657:     */     {
/*  658: 553 */       addCriterion("UserInfo.phone is not null");
/*  659: 554 */       return (Criteria)this;
/*  660:     */     }
/*  661:     */     
/*  662:     */     public Criteria andPhoneEqualTo(String value)
/*  663:     */     {
/*  664: 558 */       addCriterion("UserInfo.phone =", value, "phone");
/*  665: 559 */       return (Criteria)this;
/*  666:     */     }
/*  667:     */     
/*  668:     */     public Criteria andPhoneNotEqualTo(String value)
/*  669:     */     {
/*  670: 563 */       addCriterion("UserInfo.phone <>", value, "phone");
/*  671: 564 */       return (Criteria)this;
/*  672:     */     }
/*  673:     */     
/*  674:     */     public Criteria andPhoneGreaterThan(String value)
/*  675:     */     {
/*  676: 568 */       addCriterion("UserInfo.phone >", value, "phone");
/*  677: 569 */       return (Criteria)this;
/*  678:     */     }
/*  679:     */     
/*  680:     */     public Criteria andPhoneGreaterThanOrEqualTo(String value)
/*  681:     */     {
/*  682: 573 */       addCriterion("UserInfo.phone >=", value, "phone");
/*  683: 574 */       return (Criteria)this;
/*  684:     */     }
/*  685:     */     
/*  686:     */     public Criteria andPhoneLessThan(String value)
/*  687:     */     {
/*  688: 578 */       addCriterion("UserInfo.phone <", value, "phone");
/*  689: 579 */       return (Criteria)this;
/*  690:     */     }
/*  691:     */     
/*  692:     */     public Criteria andPhoneLessThanOrEqualTo(String value)
/*  693:     */     {
/*  694: 583 */       addCriterion("UserInfo.phone <=", value, "phone");
/*  695: 584 */       return (Criteria)this;
/*  696:     */     }
/*  697:     */     
/*  698:     */     public Criteria andPhoneLike(String value)
/*  699:     */     {
/*  700: 588 */       addCriterion("UserInfo.phone like", value, "phone");
/*  701: 589 */       return (Criteria)this;
/*  702:     */     }
/*  703:     */     
/*  704:     */     public Criteria andPhoneNotLike(String value)
/*  705:     */     {
/*  706: 593 */       addCriterion("UserInfo.phone not like", value, "phone");
/*  707: 594 */       return (Criteria)this;
/*  708:     */     }
/*  709:     */     
/*  710:     */     public Criteria andPhoneIn(List<String> values)
/*  711:     */     {
/*  712: 598 */       addCriterion("UserInfo.phone in", values, "phone");
/*  713: 599 */       return (Criteria)this;
/*  714:     */     }
/*  715:     */     
/*  716:     */     public Criteria andPhoneNotIn(List<String> values)
/*  717:     */     {
/*  718: 603 */       addCriterion("UserInfo.phone not in", values, "phone");
/*  719: 604 */       return (Criteria)this;
/*  720:     */     }
/*  721:     */     
/*  722:     */     public Criteria andPhoneBetween(String value1, String value2)
/*  723:     */     {
/*  724: 608 */       addCriterion("UserInfo.phone between", value1, value2, "phone");
/*  725: 609 */       return (Criteria)this;
/*  726:     */     }
/*  727:     */     
/*  728:     */     public Criteria andPhoneNotBetween(String value1, String value2)
/*  729:     */     {
/*  730: 613 */       addCriterion("UserInfo.phone not between", value1, value2, "phone");
/*  731: 614 */       return (Criteria)this;
/*  732:     */     }
/*  733:     */     
/*  734:     */     public Criteria andRegisterstateIsNull()
/*  735:     */     {
/*  736: 618 */       addCriterion("UserInfo.registerstate is null");
/*  737: 619 */       return (Criteria)this;
/*  738:     */     }
/*  739:     */     
/*  740:     */     public Criteria andRegisterstateIsNotNull()
/*  741:     */     {
/*  742: 623 */       addCriterion("UserInfo.registerstate is not null");
/*  743: 624 */       return (Criteria)this;
/*  744:     */     }
/*  745:     */     
/*  746:     */     public Criteria andRegisterstateEqualTo(String value)
/*  747:     */     {
/*  748: 628 */       addCriterion("UserInfo.registerstate =", value, "registerstate");
/*  749: 629 */       return (Criteria)this;
/*  750:     */     }
/*  751:     */     
/*  752:     */     public Criteria andRegisterstateNotEqualTo(String value)
/*  753:     */     {
/*  754: 633 */       addCriterion("UserInfo.registerstate <>", value, "registerstate");
/*  755: 634 */       return (Criteria)this;
/*  756:     */     }
/*  757:     */     
/*  758:     */     public Criteria andRegisterstateGreaterThan(String value)
/*  759:     */     {
/*  760: 638 */       addCriterion("UserInfo.registerstate >", value, "registerstate");
/*  761: 639 */       return (Criteria)this;
/*  762:     */     }
/*  763:     */     
/*  764:     */     public Criteria andRegisterstateGreaterThanOrEqualTo(String value)
/*  765:     */     {
/*  766: 643 */       addCriterion("UserInfo.registerstate >=", value, "registerstate");
/*  767: 644 */       return (Criteria)this;
/*  768:     */     }
/*  769:     */     
/*  770:     */     public Criteria andRegisterstateLessThan(String value)
/*  771:     */     {
/*  772: 648 */       addCriterion("UserInfo.registerstate <", value, "registerstate");
/*  773: 649 */       return (Criteria)this;
/*  774:     */     }
/*  775:     */     
/*  776:     */     public Criteria andRegisterstateLessThanOrEqualTo(String value)
/*  777:     */     {
/*  778: 653 */       addCriterion("UserInfo.registerstate <=", value, "registerstate");
/*  779: 654 */       return (Criteria)this;
/*  780:     */     }
/*  781:     */     
/*  782:     */     public Criteria andRegisterstateLike(String value)
/*  783:     */     {
/*  784: 658 */       addCriterion("UserInfo.registerstate like", value, "registerstate");
/*  785: 659 */       return (Criteria)this;
/*  786:     */     }
/*  787:     */     
/*  788:     */     public Criteria andRegisterstateNotLike(String value)
/*  789:     */     {
/*  790: 663 */       addCriterion("UserInfo.registerstate not like", value, "registerstate");
/*  791: 664 */       return (Criteria)this;
/*  792:     */     }
/*  793:     */     
/*  794:     */     public Criteria andRegisterstateIn(List<String> values)
/*  795:     */     {
/*  796: 668 */       addCriterion("UserInfo.registerstate in", values, "registerstate");
/*  797: 669 */       return (Criteria)this;
/*  798:     */     }
/*  799:     */     
/*  800:     */     public Criteria andRegisterstateNotIn(List<String> values)
/*  801:     */     {
/*  802: 673 */       addCriterion("UserInfo.registerstate not in", values, "registerstate");
/*  803: 674 */       return (Criteria)this;
/*  804:     */     }
/*  805:     */     
/*  806:     */     public Criteria andRegisterstateBetween(String value1, String value2)
/*  807:     */     {
/*  808: 678 */       addCriterion("UserInfo.registerstate between", value1, value2, "registerstate");
/*  809: 679 */       return (Criteria)this;
/*  810:     */     }
/*  811:     */     
/*  812:     */     public Criteria andRegisterstateNotBetween(String value1, String value2)
/*  813:     */     {
/*  814: 683 */       addCriterion("UserInfo.registerstate not between", value1, value2, "registerstate");
/*  815: 684 */       return (Criteria)this;
/*  816:     */     }
/*  817:     */     
/*  818:     */     public Criteria andCompanyaddressIsNull()
/*  819:     */     {
/*  820: 688 */       addCriterion("UserInfo.Companyaddress is null");
/*  821: 689 */       return (Criteria)this;
/*  822:     */     }
/*  823:     */     
/*  824:     */     public Criteria andCompanyaddressIsNotNull()
/*  825:     */     {
/*  826: 693 */       addCriterion("UserInfo.Companyaddress is not null");
/*  827: 694 */       return (Criteria)this;
/*  828:     */     }
/*  829:     */     
/*  830:     */     public Criteria andCompanyaddressEqualTo(String value)
/*  831:     */     {
/*  832: 698 */       addCriterion("UserInfo.Companyaddress =", value, "companyaddress");
/*  833: 699 */       return (Criteria)this;
/*  834:     */     }
/*  835:     */     
/*  836:     */     public Criteria andCompanyaddressNotEqualTo(String value)
/*  837:     */     {
/*  838: 703 */       addCriterion("UserInfo.Companyaddress <>", value, "companyaddress");
/*  839: 704 */       return (Criteria)this;
/*  840:     */     }
/*  841:     */     
/*  842:     */     public Criteria andCompanyaddressGreaterThan(String value)
/*  843:     */     {
/*  844: 708 */       addCriterion("UserInfo.Companyaddress >", value, "companyaddress");
/*  845: 709 */       return (Criteria)this;
/*  846:     */     }
/*  847:     */     
/*  848:     */     public Criteria andCompanyaddressGreaterThanOrEqualTo(String value)
/*  849:     */     {
/*  850: 713 */       addCriterion("UserInfo.Companyaddress >=", value, "companyaddress");
/*  851: 714 */       return (Criteria)this;
/*  852:     */     }
/*  853:     */     
/*  854:     */     public Criteria andCompanyaddressLessThan(String value)
/*  855:     */     {
/*  856: 718 */       addCriterion("UserInfo.Companyaddress <", value, "companyaddress");
/*  857: 719 */       return (Criteria)this;
/*  858:     */     }
/*  859:     */     
/*  860:     */     public Criteria andCompanyaddressLessThanOrEqualTo(String value)
/*  861:     */     {
/*  862: 723 */       addCriterion("UserInfo.Companyaddress <=", value, "companyaddress");
/*  863: 724 */       return (Criteria)this;
/*  864:     */     }
/*  865:     */     
/*  866:     */     public Criteria andCompanyaddressLike(String value)
/*  867:     */     {
/*  868: 728 */       addCriterion("UserInfo.Companyaddress like", value, "companyaddress");
/*  869: 729 */       return (Criteria)this;
/*  870:     */     }
/*  871:     */     
/*  872:     */     public Criteria andCompanyaddressNotLike(String value)
/*  873:     */     {
/*  874: 733 */       addCriterion("UserInfo.Companyaddress not like", value, "companyaddress");
/*  875: 734 */       return (Criteria)this;
/*  876:     */     }
/*  877:     */     
/*  878:     */     public Criteria andCompanyaddressIn(List<String> values)
/*  879:     */     {
/*  880: 738 */       addCriterion("UserInfo.Companyaddress in", values, "companyaddress");
/*  881: 739 */       return (Criteria)this;
/*  882:     */     }
/*  883:     */     
/*  884:     */     public Criteria andCompanyaddressNotIn(List<String> values)
/*  885:     */     {
/*  886: 743 */       addCriterion("UserInfo.Companyaddress not in", values, "companyaddress");
/*  887: 744 */       return (Criteria)this;
/*  888:     */     }
/*  889:     */     
/*  890:     */     public Criteria andCompanyaddressBetween(String value1, String value2)
/*  891:     */     {
/*  892: 748 */       addCriterion("UserInfo.Companyaddress between", value1, value2, "companyaddress");
/*  893: 749 */       return (Criteria)this;
/*  894:     */     }
/*  895:     */     
/*  896:     */     public Criteria andCompanyaddressNotBetween(String value1, String value2)
/*  897:     */     {
/*  898: 753 */       addCriterion("UserInfo.Companyaddress not between", value1, value2, "companyaddress");
/*  899: 754 */       return (Criteria)this;
/*  900:     */     }
/*  901:     */     
/*  902:     */     public Criteria andCompanynameIsNull()
/*  903:     */     {
/*  904: 758 */       addCriterion("UserInfo.Companyname is null");
/*  905: 759 */       return (Criteria)this;
/*  906:     */     }
/*  907:     */     
/*  908:     */     public Criteria andCompanynameIsNotNull()
/*  909:     */     {
/*  910: 763 */       addCriterion("UserInfo.Companyname is not null");
/*  911: 764 */       return (Criteria)this;
/*  912:     */     }
/*  913:     */     
/*  914:     */     public Criteria andCompanynameEqualTo(String value)
/*  915:     */     {
/*  916: 768 */       addCriterion("UserInfo.Companyname =", value, "companyname");
/*  917: 769 */       return (Criteria)this;
/*  918:     */     }
/*  919:     */     
/*  920:     */     public Criteria andCompanynameNotEqualTo(String value)
/*  921:     */     {
/*  922: 773 */       addCriterion("UserInfo.Companyname <>", value, "companyname");
/*  923: 774 */       return (Criteria)this;
/*  924:     */     }
/*  925:     */     
/*  926:     */     public Criteria andCompanynameGreaterThan(String value)
/*  927:     */     {
/*  928: 778 */       addCriterion("UserInfo.Companyname >", value, "companyname");
/*  929: 779 */       return (Criteria)this;
/*  930:     */     }
/*  931:     */     
/*  932:     */     public Criteria andCompanynameGreaterThanOrEqualTo(String value)
/*  933:     */     {
/*  934: 783 */       addCriterion("UserInfo.Companyname >=", value, "companyname");
/*  935: 784 */       return (Criteria)this;
/*  936:     */     }
/*  937:     */     
/*  938:     */     public Criteria andCompanynameLessThan(String value)
/*  939:     */     {
/*  940: 788 */       addCriterion("UserInfo.Companyname <", value, "companyname");
/*  941: 789 */       return (Criteria)this;
/*  942:     */     }
/*  943:     */     
/*  944:     */     public Criteria andCompanynameLessThanOrEqualTo(String value)
/*  945:     */     {
/*  946: 793 */       addCriterion("UserInfo.Companyname <=", value, "companyname");
/*  947: 794 */       return (Criteria)this;
/*  948:     */     }
/*  949:     */     
/*  950:     */     public Criteria andCompanynameLike(String value)
/*  951:     */     {
/*  952: 798 */       addCriterion("UserInfo.Companyname like", value, "companyname");
/*  953: 799 */       return (Criteria)this;
/*  954:     */     }
/*  955:     */     
/*  956:     */     public Criteria andCompanynameNotLike(String value)
/*  957:     */     {
/*  958: 803 */       addCriterion("UserInfo.Companyname not like", value, "companyname");
/*  959: 804 */       return (Criteria)this;
/*  960:     */     }
/*  961:     */     
/*  962:     */     public Criteria andCompanynameIn(List<String> values)
/*  963:     */     {
/*  964: 808 */       addCriterion("UserInfo.Companyname in", values, "companyname");
/*  965: 809 */       return (Criteria)this;
/*  966:     */     }
/*  967:     */     
/*  968:     */     public Criteria andCompanynameNotIn(List<String> values)
/*  969:     */     {
/*  970: 813 */       addCriterion("UserInfo.Companyname not in", values, "companyname");
/*  971: 814 */       return (Criteria)this;
/*  972:     */     }
/*  973:     */     
/*  974:     */     public Criteria andCompanynameBetween(String value1, String value2)
/*  975:     */     {
/*  976: 818 */       addCriterion("UserInfo.Companyname between", value1, value2, "companyname");
/*  977: 819 */       return (Criteria)this;
/*  978:     */     }
/*  979:     */     
/*  980:     */     public Criteria andCompanynameNotBetween(String value1, String value2)
/*  981:     */     {
/*  982: 823 */       addCriterion("UserInfo.Companyname not between", value1, value2, "companyname");
/*  983: 824 */       return (Criteria)this;
/*  984:     */     }
/*  985:     */     
/*  986:     */     public Criteria andTrueusernameIsNull()
/*  987:     */     {
/*  988: 828 */       addCriterion("UserInfo.Trueusername is null");
/*  989: 829 */       return (Criteria)this;
/*  990:     */     }
/*  991:     */     
/*  992:     */     public Criteria andTrueusernameIsNotNull()
/*  993:     */     {
/*  994: 833 */       addCriterion("UserInfo.Trueusername is not null");
/*  995: 834 */       return (Criteria)this;
/*  996:     */     }
/*  997:     */     
/*  998:     */     public Criteria andTrueusernameEqualTo(String value)
/*  999:     */     {
/* 1000: 838 */       addCriterion("UserInfo.Trueusername =", value, "trueusername");
/* 1001: 839 */       return (Criteria)this;
/* 1002:     */     }
/* 1003:     */     
/* 1004:     */     public Criteria andTrueusernameNotEqualTo(String value)
/* 1005:     */     {
/* 1006: 843 */       addCriterion("UserInfo.Trueusername <>", value, "trueusername");
/* 1007: 844 */       return (Criteria)this;
/* 1008:     */     }
/* 1009:     */     
/* 1010:     */     public Criteria andTrueusernameGreaterThan(String value)
/* 1011:     */     {
/* 1012: 848 */       addCriterion("UserInfo.Trueusername >", value, "trueusername");
/* 1013: 849 */       return (Criteria)this;
/* 1014:     */     }
/* 1015:     */     
/* 1016:     */     public Criteria andTrueusernameGreaterThanOrEqualTo(String value)
/* 1017:     */     {
/* 1018: 853 */       addCriterion("UserInfo.Trueusername >=", value, "trueusername");
/* 1019: 854 */       return (Criteria)this;
/* 1020:     */     }
/* 1021:     */     
/* 1022:     */     public Criteria andTrueusernameLessThan(String value)
/* 1023:     */     {
/* 1024: 858 */       addCriterion("UserInfo.Trueusername <", value, "trueusername");
/* 1025: 859 */       return (Criteria)this;
/* 1026:     */     }
/* 1027:     */     
/* 1028:     */     public Criteria andTrueusernameLessThanOrEqualTo(String value)
/* 1029:     */     {
/* 1030: 863 */       addCriterion("UserInfo.Trueusername <=", value, "trueusername");
/* 1031: 864 */       return (Criteria)this;
/* 1032:     */     }
/* 1033:     */     
/* 1034:     */     public Criteria andTrueusernameLike(String value)
/* 1035:     */     {
/* 1036: 868 */       addCriterion("UserInfo.Trueusername like", value, "trueusername");
/* 1037: 869 */       return (Criteria)this;
/* 1038:     */     }
/* 1039:     */     
/* 1040:     */     public Criteria andTrueusernameNotLike(String value)
/* 1041:     */     {
/* 1042: 873 */       addCriterion("UserInfo.Trueusername not like", value, "trueusername");
/* 1043: 874 */       return (Criteria)this;
/* 1044:     */     }
/* 1045:     */     
/* 1046:     */     public Criteria andTrueusernameIn(List<String> values)
/* 1047:     */     {
/* 1048: 878 */       addCriterion("UserInfo.Trueusername in", values, "trueusername");
/* 1049: 879 */       return (Criteria)this;
/* 1050:     */     }
/* 1051:     */     
/* 1052:     */     public Criteria andTrueusernameNotIn(List<String> values)
/* 1053:     */     {
/* 1054: 883 */       addCriterion("UserInfo.Trueusername not in", values, "trueusername");
/* 1055: 884 */       return (Criteria)this;
/* 1056:     */     }
/* 1057:     */     
/* 1058:     */     public Criteria andTrueusernameBetween(String value1, String value2)
/* 1059:     */     {
/* 1060: 888 */       addCriterion("UserInfo.Trueusername between", value1, value2, "trueusername");
/* 1061: 889 */       return (Criteria)this;
/* 1062:     */     }
/* 1063:     */     
/* 1064:     */     public Criteria andTrueusernameNotBetween(String value1, String value2)
/* 1065:     */     {
/* 1066: 893 */       addCriterion("UserInfo.Trueusername not between", value1, value2, "trueusername");
/* 1067: 894 */       return (Criteria)this;
/* 1068:     */     }
/* 1069:     */     
/* 1070:     */     public Criteria andRegisterdateIsNull()
/* 1071:     */     {
/* 1072: 898 */       addCriterion("UserInfo.registerdate is null");
/* 1073: 899 */       return (Criteria)this;
/* 1074:     */     }
/* 1075:     */     
/* 1076:     */     public Criteria andRegisterdateIsNotNull()
/* 1077:     */     {
/* 1078: 903 */       addCriterion("UserInfo.registerdate is not null");
/* 1079: 904 */       return (Criteria)this;
/* 1080:     */     }
/* 1081:     */     
/* 1082:     */     public Criteria andRegisterdateEqualTo(String value)
/* 1083:     */     {
/* 1084: 908 */       addCriterion("UserInfo.registerdate =", value, "registerdate");
/* 1085: 909 */       return (Criteria)this;
/* 1086:     */     }
/* 1087:     */     
/* 1088:     */     public Criteria andRegisterdateNotEqualTo(String value)
/* 1089:     */     {
/* 1090: 913 */       addCriterion("UserInfo.registerdate <>", value, "registerdate");
/* 1091: 914 */       return (Criteria)this;
/* 1092:     */     }
/* 1093:     */     
/* 1094:     */     public Criteria andRegisterdateGreaterThan(String value)
/* 1095:     */     {
/* 1096: 918 */       addCriterion("UserInfo.registerdate >", value, "registerdate");
/* 1097: 919 */       return (Criteria)this;
/* 1098:     */     }
/* 1099:     */     
/* 1100:     */     public Criteria andRegisterdateGreaterThanOrEqualTo(String value)
/* 1101:     */     {
/* 1102: 923 */       addCriterion("UserInfo.registerdate >=", value, "registerdate");
/* 1103: 924 */       return (Criteria)this;
/* 1104:     */     }
/* 1105:     */     
/* 1106:     */     public Criteria andRegisterdateLessThan(String value)
/* 1107:     */     {
/* 1108: 928 */       addCriterion("UserInfo.registerdate <", value, "registerdate");
/* 1109: 929 */       return (Criteria)this;
/* 1110:     */     }
/* 1111:     */     
/* 1112:     */     public Criteria andRegisterdateLessThanOrEqualTo(String value)
/* 1113:     */     {
/* 1114: 933 */       addCriterion("UserInfo.registerdate <=", value, "registerdate");
/* 1115: 934 */       return (Criteria)this;
/* 1116:     */     }
/* 1117:     */     
/* 1118:     */     public Criteria andRegisterdateLike(String value)
/* 1119:     */     {
/* 1120: 938 */       addCriterion("UserInfo.registerdate like", value, "registerdate");
/* 1121: 939 */       return (Criteria)this;
/* 1122:     */     }
/* 1123:     */     
/* 1124:     */     public Criteria andRegisterdateNotLike(String value)
/* 1125:     */     {
/* 1126: 943 */       addCriterion("UserInfo.registerdate not like", value, "registerdate");
/* 1127: 944 */       return (Criteria)this;
/* 1128:     */     }
/* 1129:     */     
/* 1130:     */     public Criteria andRegisterdateIn(List<String> values)
/* 1131:     */     {
/* 1132: 948 */       addCriterion("UserInfo.registerdate in", values, "registerdate");
/* 1133: 949 */       return (Criteria)this;
/* 1134:     */     }
/* 1135:     */     
/* 1136:     */     public Criteria andRegisterdateNotIn(List<String> values)
/* 1137:     */     {
/* 1138: 953 */       addCriterion("UserInfo.registerdate not in", values, "registerdate");
/* 1139: 954 */       return (Criteria)this;
/* 1140:     */     }
/* 1141:     */     
/* 1142:     */     public Criteria andRegisterdateBetween(String value1, String value2)
/* 1143:     */     {
/* 1144: 958 */       addCriterion("UserInfo.registerdate between", value1, value2, "registerdate");
/* 1145: 959 */       return (Criteria)this;
/* 1146:     */     }
/* 1147:     */     
/* 1148:     */     public Criteria andRegisterdateNotBetween(String value1, String value2)
/* 1149:     */     {
/* 1150: 963 */       addCriterion("UserInfo.registerdate not between", value1, value2, "registerdate");
/* 1151: 964 */       return (Criteria)this;
/* 1152:     */     }
/* 1153:     */     
/* 1154:     */     public Criteria andLoginleftdateIsNull()
/* 1155:     */     {
/* 1156: 968 */       addCriterion("UserInfo.loginleftdate is null");
/* 1157: 969 */       return (Criteria)this;
/* 1158:     */     }
/* 1159:     */     
/* 1160:     */     public Criteria andLoginleftdateIsNotNull()
/* 1161:     */     {
/* 1162: 973 */       addCriterion("UserInfo.loginleftdate is not null");
/* 1163: 974 */       return (Criteria)this;
/* 1164:     */     }
/* 1165:     */     
/* 1166:     */     public Criteria andLoginleftdateEqualTo(String value)
/* 1167:     */     {
/* 1168: 978 */       addCriterion("UserInfo.loginleftdate =", value, "loginleftdate");
/* 1169: 979 */       return (Criteria)this;
/* 1170:     */     }
/* 1171:     */     
/* 1172:     */     public Criteria andLoginleftdateNotEqualTo(String value)
/* 1173:     */     {
/* 1174: 983 */       addCriterion("UserInfo.loginleftdate <>", value, "loginleftdate");
/* 1175: 984 */       return (Criteria)this;
/* 1176:     */     }
/* 1177:     */     
/* 1178:     */     public Criteria andLoginleftdateGreaterThan(String value)
/* 1179:     */     {
/* 1180: 988 */       addCriterion("UserInfo.loginleftdate >", value, "loginleftdate");
/* 1181: 989 */       return (Criteria)this;
/* 1182:     */     }
/* 1183:     */     
/* 1184:     */     public Criteria andLoginleftdateGreaterThanOrEqualTo(String value)
/* 1185:     */     {
/* 1186: 993 */       addCriterion("UserInfo.loginleftdate >=", value, "loginleftdate");
/* 1187: 994 */       return (Criteria)this;
/* 1188:     */     }
/* 1189:     */     
/* 1190:     */     public Criteria andLoginleftdateLessThan(String value)
/* 1191:     */     {
/* 1192: 998 */       addCriterion("UserInfo.loginleftdate <", value, "loginleftdate");
/* 1193: 999 */       return (Criteria)this;
/* 1194:     */     }
/* 1195:     */     
/* 1196:     */     public Criteria andLoginleftdateLessThanOrEqualTo(String value)
/* 1197:     */     {
/* 1198:1003 */       addCriterion("UserInfo.loginleftdate <=", value, "loginleftdate");
/* 1199:1004 */       return (Criteria)this;
/* 1200:     */     }
/* 1201:     */     
/* 1202:     */     public Criteria andLoginleftdateLike(String value)
/* 1203:     */     {
/* 1204:1008 */       addCriterion("UserInfo.loginleftdate like", value, "loginleftdate");
/* 1205:1009 */       return (Criteria)this;
/* 1206:     */     }
/* 1207:     */     
/* 1208:     */     public Criteria andLoginleftdateNotLike(String value)
/* 1209:     */     {
/* 1210:1013 */       addCriterion("UserInfo.loginleftdate not like", value, "loginleftdate");
/* 1211:1014 */       return (Criteria)this;
/* 1212:     */     }
/* 1213:     */     
/* 1214:     */     public Criteria andLoginleftdateIn(List<String> values)
/* 1215:     */     {
/* 1216:1018 */       addCriterion("UserInfo.loginleftdate in", values, "loginleftdate");
/* 1217:1019 */       return (Criteria)this;
/* 1218:     */     }
/* 1219:     */     
/* 1220:     */     public Criteria andLoginleftdateNotIn(List<String> values)
/* 1221:     */     {
/* 1222:1023 */       addCriterion("UserInfo.loginleftdate not in", values, "loginleftdate");
/* 1223:1024 */       return (Criteria)this;
/* 1224:     */     }
/* 1225:     */     
/* 1226:     */     public Criteria andLoginleftdateBetween(String value1, String value2)
/* 1227:     */     {
/* 1228:1028 */       addCriterion("UserInfo.loginleftdate between", value1, value2, "loginleftdate");
/* 1229:1029 */       return (Criteria)this;
/* 1230:     */     }
/* 1231:     */     
/* 1232:     */     public Criteria andLoginleftdateNotBetween(String value1, String value2)
/* 1233:     */     {
/* 1234:1033 */       addCriterion("UserInfo.loginleftdate not between", value1, value2, "loginleftdate");
/* 1235:1034 */       return (Criteria)this;
/* 1236:     */     }
/* 1237:     */     
/* 1238:     */     public Criteria andCheckdateIsNull()
/* 1239:     */     {
/* 1240:1038 */       addCriterion("UserInfo.checkdate is null");
/* 1241:1039 */       return (Criteria)this;
/* 1242:     */     }
/* 1243:     */     
/* 1244:     */     public Criteria andCheckdateIsNotNull()
/* 1245:     */     {
/* 1246:1043 */       addCriterion("UserInfo.checkdate is not null");
/* 1247:1044 */       return (Criteria)this;
/* 1248:     */     }
/* 1249:     */     
/* 1250:     */     public Criteria andCheckdateEqualTo(String value)
/* 1251:     */     {
/* 1252:1048 */       addCriterion("UserInfo.checkdate =", value, "checkdate");
/* 1253:1049 */       return (Criteria)this;
/* 1254:     */     }
/* 1255:     */     
/* 1256:     */     public Criteria andCheckdateNotEqualTo(String value)
/* 1257:     */     {
/* 1258:1053 */       addCriterion("UserInfo.checkdate <>", value, "checkdate");
/* 1259:1054 */       return (Criteria)this;
/* 1260:     */     }
/* 1261:     */     
/* 1262:     */     public Criteria andCheckdateGreaterThan(String value)
/* 1263:     */     {
/* 1264:1058 */       addCriterion("UserInfo.checkdate >", value, "checkdate");
/* 1265:1059 */       return (Criteria)this;
/* 1266:     */     }
/* 1267:     */     
/* 1268:     */     public Criteria andCheckdateGreaterThanOrEqualTo(String value)
/* 1269:     */     {
/* 1270:1063 */       addCriterion("UserInfo.checkdate >=", value, "checkdate");
/* 1271:1064 */       return (Criteria)this;
/* 1272:     */     }
/* 1273:     */     
/* 1274:     */     public Criteria andCheckdateLessThan(String value)
/* 1275:     */     {
/* 1276:1068 */       addCriterion("UserInfo.checkdate <", value, "checkdate");
/* 1277:1069 */       return (Criteria)this;
/* 1278:     */     }
/* 1279:     */     
/* 1280:     */     public Criteria andCheckdateLessThanOrEqualTo(String value)
/* 1281:     */     {
/* 1282:1073 */       addCriterion("UserInfo.checkdate <=", value, "checkdate");
/* 1283:1074 */       return (Criteria)this;
/* 1284:     */     }
/* 1285:     */     
/* 1286:     */     public Criteria andCheckdateLike(String value)
/* 1287:     */     {
/* 1288:1078 */       addCriterion("UserInfo.checkdate like", value, "checkdate");
/* 1289:1079 */       return (Criteria)this;
/* 1290:     */     }
/* 1291:     */     
/* 1292:     */     public Criteria andCheckdateNotLike(String value)
/* 1293:     */     {
/* 1294:1083 */       addCriterion("UserInfo.checkdate not like", value, "checkdate");
/* 1295:1084 */       return (Criteria)this;
/* 1296:     */     }
/* 1297:     */     
/* 1298:     */     public Criteria andCheckdateIn(List<String> values)
/* 1299:     */     {
/* 1300:1088 */       addCriterion("UserInfo.checkdate in", values, "checkdate");
/* 1301:1089 */       return (Criteria)this;
/* 1302:     */     }
/* 1303:     */     
/* 1304:     */     public Criteria andCheckdateNotIn(List<String> values)
/* 1305:     */     {
/* 1306:1093 */       addCriterion("UserInfo.checkdate not in", values, "checkdate");
/* 1307:1094 */       return (Criteria)this;
/* 1308:     */     }
/* 1309:     */     
/* 1310:     */     public Criteria andCheckdateBetween(String value1, String value2)
/* 1311:     */     {
/* 1312:1098 */       addCriterion("UserInfo.checkdate between", value1, value2, "checkdate");
/* 1313:1099 */       return (Criteria)this;
/* 1314:     */     }
/* 1315:     */     
/* 1316:     */     public Criteria andCheckdateNotBetween(String value1, String value2)
/* 1317:     */     {
/* 1318:1103 */       addCriterion("UserInfo.checkdate not between", value1, value2, "checkdate");
/* 1319:1104 */       return (Criteria)this;
/* 1320:     */     }
/* 1321:     */     
/* 1322:     */     public Criteria andOperationdateIsNull()
/* 1323:     */     {
/* 1324:1108 */       addCriterion("UserInfo.operationdate is null");
/* 1325:1109 */       return (Criteria)this;
/* 1326:     */     }
/* 1327:     */     
/* 1328:     */     public Criteria andOperationdateIsNotNull()
/* 1329:     */     {
/* 1330:1113 */       addCriterion("UserInfo.operationdate is not null");
/* 1331:1114 */       return (Criteria)this;
/* 1332:     */     }
/* 1333:     */     
/* 1334:     */     public Criteria andOperationdateEqualTo(String value)
/* 1335:     */     {
/* 1336:1118 */       addCriterion("UserInfo.operationdate =", value, "operationdate");
/* 1337:1119 */       return (Criteria)this;
/* 1338:     */     }
/* 1339:     */     
/* 1340:     */     public Criteria andOperationdateNotEqualTo(String value)
/* 1341:     */     {
/* 1342:1123 */       addCriterion("UserInfo.operationdate <>", value, "operationdate");
/* 1343:1124 */       return (Criteria)this;
/* 1344:     */     }
/* 1345:     */     
/* 1346:     */     public Criteria andOperationdateGreaterThan(String value)
/* 1347:     */     {
/* 1348:1128 */       addCriterion("UserInfo.operationdate >", value, "operationdate");
/* 1349:1129 */       return (Criteria)this;
/* 1350:     */     }
/* 1351:     */     
/* 1352:     */     public Criteria andOperationdateGreaterThanOrEqualTo(String value)
/* 1353:     */     {
/* 1354:1133 */       addCriterion("UserInfo.operationdate >=", value, "operationdate");
/* 1355:1134 */       return (Criteria)this;
/* 1356:     */     }
/* 1357:     */     
/* 1358:     */     public Criteria andOperationdateLessThan(String value)
/* 1359:     */     {
/* 1360:1138 */       addCriterion("UserInfo.operationdate <", value, "operationdate");
/* 1361:1139 */       return (Criteria)this;
/* 1362:     */     }
/* 1363:     */     
/* 1364:     */     public Criteria andOperationdateLessThanOrEqualTo(String value)
/* 1365:     */     {
/* 1366:1143 */       addCriterion("UserInfo.operationdate <=", value, "operationdate");
/* 1367:1144 */       return (Criteria)this;
/* 1368:     */     }
/* 1369:     */     
/* 1370:     */     public Criteria andOperationdateLike(String value)
/* 1371:     */     {
/* 1372:1148 */       addCriterion("UserInfo.operationdate like", value, "operationdate");
/* 1373:1149 */       return (Criteria)this;
/* 1374:     */     }
/* 1375:     */     
/* 1376:     */     public Criteria andOperationdateNotLike(String value)
/* 1377:     */     {
/* 1378:1153 */       addCriterion("UserInfo.operationdate not like", value, "operationdate");
/* 1379:1154 */       return (Criteria)this;
/* 1380:     */     }
/* 1381:     */     
/* 1382:     */     public Criteria andOperationdateIn(List<String> values)
/* 1383:     */     {
/* 1384:1158 */       addCriterion("UserInfo.operationdate in", values, "operationdate");
/* 1385:1159 */       return (Criteria)this;
/* 1386:     */     }
/* 1387:     */     
/* 1388:     */     public Criteria andOperationdateNotIn(List<String> values)
/* 1389:     */     {
/* 1390:1163 */       addCriterion("UserInfo.operationdate not in", values, "operationdate");
/* 1391:1164 */       return (Criteria)this;
/* 1392:     */     }
/* 1393:     */     
/* 1394:     */     public Criteria andOperationdateBetween(String value1, String value2)
/* 1395:     */     {
/* 1396:1168 */       addCriterion("UserInfo.operationdate between", value1, value2, "operationdate");
/* 1397:1169 */       return (Criteria)this;
/* 1398:     */     }
/* 1399:     */     
/* 1400:     */     public Criteria andOperationdateNotBetween(String value1, String value2)
/* 1401:     */     {
/* 1402:1173 */       addCriterion("UserInfo.operationdate not between", value1, value2, "operationdate");
/* 1403:1174 */       return (Criteria)this;
/* 1404:     */     }
/* 1405:     */     
/* 1406:     */     public Criteria andChannelidIsNull()
/* 1407:     */     {
/* 1408:1178 */       addCriterion("UserInfo.channelid is null");
/* 1409:1179 */       return (Criteria)this;
/* 1410:     */     }
/* 1411:     */     
/* 1412:     */     public Criteria andChannelidIsNotNull()
/* 1413:     */     {
/* 1414:1183 */       addCriterion("UserInfo.channelid is not null");
/* 1415:1184 */       return (Criteria)this;
/* 1416:     */     }
/* 1417:     */     
/* 1418:     */     public Criteria andChannelidEqualTo(String value)
/* 1419:     */     {
/* 1420:1188 */       addCriterion("UserInfo.channelid =", value, "channelid");
/* 1421:1189 */       return (Criteria)this;
/* 1422:     */     }
/* 1423:     */     
/* 1424:     */     public Criteria andChannelidNotEqualTo(String value)
/* 1425:     */     {
/* 1426:1193 */       addCriterion("UserInfo.channelid <>", value, "channelid");
/* 1427:1194 */       return (Criteria)this;
/* 1428:     */     }
/* 1429:     */     
/* 1430:     */     public Criteria andChannelidGreaterThan(String value)
/* 1431:     */     {
/* 1432:1198 */       addCriterion("UserInfo.channelid >", value, "channelid");
/* 1433:1199 */       return (Criteria)this;
/* 1434:     */     }
/* 1435:     */     
/* 1436:     */     public Criteria andChannelidGreaterThanOrEqualTo(String value)
/* 1437:     */     {
/* 1438:1203 */       addCriterion("UserInfo.channelid >=", value, "channelid");
/* 1439:1204 */       return (Criteria)this;
/* 1440:     */     }
/* 1441:     */     
/* 1442:     */     public Criteria andChannelidLessThan(String value)
/* 1443:     */     {
/* 1444:1208 */       addCriterion("UserInfo.channelid <", value, "channelid");
/* 1445:1209 */       return (Criteria)this;
/* 1446:     */     }
/* 1447:     */     
/* 1448:     */     public Criteria andChannelidLessThanOrEqualTo(String value)
/* 1449:     */     {
/* 1450:1213 */       addCriterion("UserInfo.channelid <=", value, "channelid");
/* 1451:1214 */       return (Criteria)this;
/* 1452:     */     }
/* 1453:     */     
/* 1454:     */     public Criteria andChannelidLike(String value)
/* 1455:     */     {
/* 1456:1218 */       addCriterion("UserInfo.channelid like", value, "channelid");
/* 1457:1219 */       return (Criteria)this;
/* 1458:     */     }
/* 1459:     */     
/* 1460:     */     public Criteria andChannelidNotLike(String value)
/* 1461:     */     {
/* 1462:1223 */       addCriterion("UserInfo.channelid not like", value, "channelid");
/* 1463:1224 */       return (Criteria)this;
/* 1464:     */     }
/* 1465:     */     
/* 1466:     */     public Criteria andChannelidIn(List<String> values)
/* 1467:     */     {
/* 1468:1228 */       addCriterion("UserInfo.channelid in", values, "channelid");
/* 1469:1229 */       return (Criteria)this;
/* 1470:     */     }
/* 1471:     */     
/* 1472:     */     public Criteria andChannelidNotIn(List<String> values)
/* 1473:     */     {
/* 1474:1233 */       addCriterion("UserInfo.channelid not in", values, "channelid");
/* 1475:1234 */       return (Criteria)this;
/* 1476:     */     }
/* 1477:     */     
/* 1478:     */     public Criteria andChannelidBetween(String value1, String value2)
/* 1479:     */     {
/* 1480:1238 */       addCriterion("UserInfo.channelid between", value1, value2, "channelid");
/* 1481:1239 */       return (Criteria)this;
/* 1482:     */     }
/* 1483:     */     
/* 1484:     */     public Criteria andChannelidNotBetween(String value1, String value2)
/* 1485:     */     {
/* 1486:1243 */       addCriterion("UserInfo.channelid not between", value1, value2, "channelid");
/* 1487:1244 */       return (Criteria)this;
/* 1488:     */     }
/* 1489:     */     
/* 1490:     */     public Criteria andLongitudeIsNull()
/* 1491:     */     {
/* 1492:1248 */       addCriterion("UserInfo.longitude is null");
/* 1493:1249 */       return (Criteria)this;
/* 1494:     */     }
/* 1495:     */     
/* 1496:     */     public Criteria andLongitudeIsNotNull()
/* 1497:     */     {
/* 1498:1253 */       addCriterion("UserInfo.longitude is not null");
/* 1499:1254 */       return (Criteria)this;
/* 1500:     */     }
/* 1501:     */     
/* 1502:     */     public Criteria andLongitudeEqualTo(String value)
/* 1503:     */     {
/* 1504:1258 */       addCriterion("UserInfo.longitude =", value, "longitude");
/* 1505:1259 */       return (Criteria)this;
/* 1506:     */     }
/* 1507:     */     
/* 1508:     */     public Criteria andLongitudeNotEqualTo(String value)
/* 1509:     */     {
/* 1510:1263 */       addCriterion("UserInfo.longitude <>", value, "longitude");
/* 1511:1264 */       return (Criteria)this;
/* 1512:     */     }
/* 1513:     */     
/* 1514:     */     public Criteria andLongitudeGreaterThan(String value)
/* 1515:     */     {
/* 1516:1268 */       addCriterion("UserInfo.longitude >", value, "longitude");
/* 1517:1269 */       return (Criteria)this;
/* 1518:     */     }
/* 1519:     */     
/* 1520:     */     public Criteria andLongitudeGreaterThanOrEqualTo(String value)
/* 1521:     */     {
/* 1522:1273 */       addCriterion("UserInfo.longitude >=", value, "longitude");
/* 1523:1274 */       return (Criteria)this;
/* 1524:     */     }
/* 1525:     */     
/* 1526:     */     public Criteria andLongitudeLessThan(String value)
/* 1527:     */     {
/* 1528:1278 */       addCriterion("UserInfo.longitude <", value, "longitude");
/* 1529:1279 */       return (Criteria)this;
/* 1530:     */     }
/* 1531:     */     
/* 1532:     */     public Criteria andLongitudeLessThanOrEqualTo(String value)
/* 1533:     */     {
/* 1534:1283 */       addCriterion("UserInfo.longitude <=", value, "longitude");
/* 1535:1284 */       return (Criteria)this;
/* 1536:     */     }
/* 1537:     */     
/* 1538:     */     public Criteria andLongitudeLike(String value)
/* 1539:     */     {
/* 1540:1288 */       addCriterion("UserInfo.longitude like", value, "longitude");
/* 1541:1289 */       return (Criteria)this;
/* 1542:     */     }
/* 1543:     */     
/* 1544:     */     public Criteria andLongitudeNotLike(String value)
/* 1545:     */     {
/* 1546:1293 */       addCriterion("UserInfo.longitude not like", value, "longitude");
/* 1547:1294 */       return (Criteria)this;
/* 1548:     */     }
/* 1549:     */     
/* 1550:     */     public Criteria andLongitudeIn(List<String> values)
/* 1551:     */     {
/* 1552:1298 */       addCriterion("UserInfo.longitude in", values, "longitude");
/* 1553:1299 */       return (Criteria)this;
/* 1554:     */     }
/* 1555:     */     
/* 1556:     */     public Criteria andLongitudeNotIn(List<String> values)
/* 1557:     */     {
/* 1558:1303 */       addCriterion("UserInfo.longitude not in", values, "longitude");
/* 1559:1304 */       return (Criteria)this;
/* 1560:     */     }
/* 1561:     */     
/* 1562:     */     public Criteria andLongitudeBetween(String value1, String value2)
/* 1563:     */     {
/* 1564:1308 */       addCriterion("UserInfo.longitude between", value1, value2, "longitude");
/* 1565:1309 */       return (Criteria)this;
/* 1566:     */     }
/* 1567:     */     
/* 1568:     */     public Criteria andLongitudeNotBetween(String value1, String value2)
/* 1569:     */     {
/* 1570:1313 */       addCriterion("UserInfo.longitude not between", value1, value2, "longitude");
/* 1571:1314 */       return (Criteria)this;
/* 1572:     */     }
/* 1573:     */     
/* 1574:     */     public Criteria andLatitudeIsNull()
/* 1575:     */     {
/* 1576:1318 */       addCriterion("UserInfo.latitude is null");
/* 1577:1319 */       return (Criteria)this;
/* 1578:     */     }
/* 1579:     */     
/* 1580:     */     public Criteria andLatitudeIsNotNull()
/* 1581:     */     {
/* 1582:1323 */       addCriterion("UserInfo.latitude is not null");
/* 1583:1324 */       return (Criteria)this;
/* 1584:     */     }
/* 1585:     */     
/* 1586:     */     public Criteria andLatitudeEqualTo(String value)
/* 1587:     */     {
/* 1588:1328 */       addCriterion("UserInfo.latitude =", value, "latitude");
/* 1589:1329 */       return (Criteria)this;
/* 1590:     */     }
/* 1591:     */     
/* 1592:     */     public Criteria andLatitudeNotEqualTo(String value)
/* 1593:     */     {
/* 1594:1333 */       addCriterion("UserInfo.latitude <>", value, "latitude");
/* 1595:1334 */       return (Criteria)this;
/* 1596:     */     }
/* 1597:     */     
/* 1598:     */     public Criteria andLatitudeGreaterThan(String value)
/* 1599:     */     {
/* 1600:1338 */       addCriterion("UserInfo.latitude >", value, "latitude");
/* 1601:1339 */       return (Criteria)this;
/* 1602:     */     }
/* 1603:     */     
/* 1604:     */     public Criteria andLatitudeGreaterThanOrEqualTo(String value)
/* 1605:     */     {
/* 1606:1343 */       addCriterion("UserInfo.latitude >=", value, "latitude");
/* 1607:1344 */       return (Criteria)this;
/* 1608:     */     }
/* 1609:     */     
/* 1610:     */     public Criteria andLatitudeLessThan(String value)
/* 1611:     */     {
/* 1612:1348 */       addCriterion("UserInfo.latitude <", value, "latitude");
/* 1613:1349 */       return (Criteria)this;
/* 1614:     */     }
/* 1615:     */     
/* 1616:     */     public Criteria andLatitudeLessThanOrEqualTo(String value)
/* 1617:     */     {
/* 1618:1353 */       addCriterion("UserInfo.latitude <=", value, "latitude");
/* 1619:1354 */       return (Criteria)this;
/* 1620:     */     }
/* 1621:     */     
/* 1622:     */     public Criteria andLatitudeLike(String value)
/* 1623:     */     {
/* 1624:1358 */       addCriterion("UserInfo.latitude like", value, "latitude");
/* 1625:1359 */       return (Criteria)this;
/* 1626:     */     }
/* 1627:     */     
/* 1628:     */     public Criteria andLatitudeNotLike(String value)
/* 1629:     */     {
/* 1630:1363 */       addCriterion("UserInfo.latitude not like", value, "latitude");
/* 1631:1364 */       return (Criteria)this;
/* 1632:     */     }
/* 1633:     */     
/* 1634:     */     public Criteria andLatitudeIn(List<String> values)
/* 1635:     */     {
/* 1636:1368 */       addCriterion("UserInfo.latitude in", values, "latitude");
/* 1637:1369 */       return (Criteria)this;
/* 1638:     */     }
/* 1639:     */     
/* 1640:     */     public Criteria andLatitudeNotIn(List<String> values)
/* 1641:     */     {
/* 1642:1373 */       addCriterion("UserInfo.latitude not in", values, "latitude");
/* 1643:1374 */       return (Criteria)this;
/* 1644:     */     }
/* 1645:     */     
/* 1646:     */     public Criteria andLatitudeBetween(String value1, String value2)
/* 1647:     */     {
/* 1648:1378 */       addCriterion("UserInfo.latitude between", value1, value2, "latitude");
/* 1649:1379 */       return (Criteria)this;
/* 1650:     */     }
/* 1651:     */     
/* 1652:     */     public Criteria andLatitudeNotBetween(String value1, String value2)
/* 1653:     */     {
/* 1654:1383 */       addCriterion("UserInfo.latitude not between", value1, value2, "latitude");
/* 1655:1384 */       return (Criteria)this;
/* 1656:     */     }
/* 1657:     */     
/* 1658:     */     public Criteria andTerminalstateIsNull()
/* 1659:     */     {
/* 1660:1388 */       addCriterion("UserInfo.terminalstate is null");
/* 1661:1389 */       return (Criteria)this;
/* 1662:     */     }
/* 1663:     */     
/* 1664:     */     public Criteria andTerminalstateIsNotNull()
/* 1665:     */     {
/* 1666:1393 */       addCriterion("UserInfo.terminalstate is not null");
/* 1667:1394 */       return (Criteria)this;
/* 1668:     */     }
/* 1669:     */     
/* 1670:     */     public Criteria andTerminalstateEqualTo(String value)
/* 1671:     */     {
/* 1672:1398 */       addCriterion("UserInfo.terminalstate =", value, "terminalstate");
/* 1673:1399 */       return (Criteria)this;
/* 1674:     */     }
/* 1675:     */     
/* 1676:     */     public Criteria andTerminalstateNotEqualTo(String value)
/* 1677:     */     {
/* 1678:1403 */       addCriterion("UserInfo.terminalstate <>", value, "terminalstate");
/* 1679:1404 */       return (Criteria)this;
/* 1680:     */     }
/* 1681:     */     
/* 1682:     */     public Criteria andTerminalstateGreaterThan(String value)
/* 1683:     */     {
/* 1684:1408 */       addCriterion("UserInfo.terminalstate >", value, "terminalstate");
/* 1685:1409 */       return (Criteria)this;
/* 1686:     */     }
/* 1687:     */     
/* 1688:     */     public Criteria andTerminalstateGreaterThanOrEqualTo(String value)
/* 1689:     */     {
/* 1690:1413 */       addCriterion("UserInfo.terminalstate >=", value, "terminalstate");
/* 1691:1414 */       return (Criteria)this;
/* 1692:     */     }
/* 1693:     */     
/* 1694:     */     public Criteria andTerminalstateLessThan(String value)
/* 1695:     */     {
/* 1696:1418 */       addCriterion("UserInfo.terminalstate <", value, "terminalstate");
/* 1697:1419 */       return (Criteria)this;
/* 1698:     */     }
/* 1699:     */     
/* 1700:     */     public Criteria andTerminalstateLessThanOrEqualTo(String value)
/* 1701:     */     {
/* 1702:1423 */       addCriterion("UserInfo.terminalstate <=", value, "terminalstate");
/* 1703:1424 */       return (Criteria)this;
/* 1704:     */     }
/* 1705:     */     
/* 1706:     */     public Criteria andTerminalstateLike(String value)
/* 1707:     */     {
/* 1708:1428 */       addCriterion("UserInfo.terminalstate like", value, "terminalstate");
/* 1709:1429 */       return (Criteria)this;
/* 1710:     */     }
/* 1711:     */     
/* 1712:     */     public Criteria andTerminalstateNotLike(String value)
/* 1713:     */     {
/* 1714:1433 */       addCriterion("UserInfo.terminalstate not like", value, "terminalstate");
/* 1715:1434 */       return (Criteria)this;
/* 1716:     */     }
/* 1717:     */     
/* 1718:     */     public Criteria andTerminalstateIn(List<String> values)
/* 1719:     */     {
/* 1720:1438 */       addCriterion("UserInfo.terminalstate in", values, "terminalstate");
/* 1721:1439 */       return (Criteria)this;
/* 1722:     */     }
/* 1723:     */     
/* 1724:     */     public Criteria andTerminalstateNotIn(List<String> values)
/* 1725:     */     {
/* 1726:1443 */       addCriterion("UserInfo.terminalstate not in", values, "terminalstate");
/* 1727:1444 */       return (Criteria)this;
/* 1728:     */     }
/* 1729:     */     
/* 1730:     */     public Criteria andTerminalstateBetween(String value1, String value2)
/* 1731:     */     {
/* 1732:1448 */       addCriterion("UserInfo.terminalstate between", value1, value2, "terminalstate");
/* 1733:1449 */       return (Criteria)this;
/* 1734:     */     }
/* 1735:     */     
/* 1736:     */     public Criteria andTerminalstateNotBetween(String value1, String value2)
/* 1737:     */     {
/* 1738:1453 */       addCriterion("UserInfo.terminalstate not between", value1, value2, "terminalstate");
/* 1739:1454 */       return (Criteria)this;
/* 1740:     */     }
/* 1741:     */     
/* 1742:     */     public Criteria andPushStatrSupportersIsNull()
/* 1743:     */     {
/* 1744:1458 */       addCriterion("UserInfo.push_statr_supporters is null");
/* 1745:1459 */       return (Criteria)this;
/* 1746:     */     }
/* 1747:     */     
/* 1748:     */     public Criteria andPushStatrSupportersIsNotNull()
/* 1749:     */     {
/* 1750:1463 */       addCriterion("UserInfo.push_statr_supporters is not null");
/* 1751:1464 */       return (Criteria)this;
/* 1752:     */     }
/* 1753:     */     
/* 1754:     */     public Criteria andPushStatrSupportersEqualTo(String value)
/* 1755:     */     {
/* 1756:1468 */       addCriterion("UserInfo.push_statr_supporters =", value, "pushStatrSupporters");
/* 1757:1469 */       return (Criteria)this;
/* 1758:     */     }
/* 1759:     */     
/* 1760:     */     public Criteria andPushStatrSupportersNotEqualTo(String value)
/* 1761:     */     {
/* 1762:1473 */       addCriterion("UserInfo.push_statr_supporters <>", value, "pushStatrSupporters");
/* 1763:1474 */       return (Criteria)this;
/* 1764:     */     }
/* 1765:     */     
/* 1766:     */     public Criteria andPushStatrSupportersGreaterThan(String value)
/* 1767:     */     {
/* 1768:1478 */       addCriterion("UserInfo.push_statr_supporters >", value, "pushStatrSupporters");
/* 1769:1479 */       return (Criteria)this;
/* 1770:     */     }
/* 1771:     */     
/* 1772:     */     public Criteria andPushStatrSupportersGreaterThanOrEqualTo(String value)
/* 1773:     */     {
/* 1774:1483 */       addCriterion("UserInfo.push_statr_supporters >=", value, "pushStatrSupporters");
/* 1775:1484 */       return (Criteria)this;
/* 1776:     */     }
/* 1777:     */     
/* 1778:     */     public Criteria andPushStatrSupportersLessThan(String value)
/* 1779:     */     {
/* 1780:1488 */       addCriterion("UserInfo.push_statr_supporters <", value, "pushStatrSupporters");
/* 1781:1489 */       return (Criteria)this;
/* 1782:     */     }
/* 1783:     */     
/* 1784:     */     public Criteria andPushStatrSupportersLessThanOrEqualTo(String value)
/* 1785:     */     {
/* 1786:1493 */       addCriterion("UserInfo.push_statr_supporters <=", value, "pushStatrSupporters");
/* 1787:1494 */       return (Criteria)this;
/* 1788:     */     }
/* 1789:     */     
/* 1790:     */     public Criteria andPushStatrSupportersLike(String value)
/* 1791:     */     {
/* 1792:1498 */       addCriterion("UserInfo.push_statr_supporters like", value, "pushStatrSupporters");
/* 1793:1499 */       return (Criteria)this;
/* 1794:     */     }
/* 1795:     */     
/* 1796:     */     public Criteria andPushStatrSupportersNotLike(String value)
/* 1797:     */     {
/* 1798:1503 */       addCriterion("UserInfo.push_statr_supporters not like", value, "pushStatrSupporters");
/* 1799:1504 */       return (Criteria)this;
/* 1800:     */     }
/* 1801:     */     
/* 1802:     */     public Criteria andPushStatrSupportersIn(List<String> values)
/* 1803:     */     {
/* 1804:1508 */       addCriterion("UserInfo.push_statr_supporters in", values, "pushStatrSupporters");
/* 1805:1509 */       return (Criteria)this;
/* 1806:     */     }
/* 1807:     */     
/* 1808:     */     public Criteria andPushStatrSupportersNotIn(List<String> values)
/* 1809:     */     {
/* 1810:1513 */       addCriterion("UserInfo.push_statr_supporters not in", values, "pushStatrSupporters");
/* 1811:1514 */       return (Criteria)this;
/* 1812:     */     }
/* 1813:     */     
/* 1814:     */     public Criteria andPushStatrSupportersBetween(String value1, String value2)
/* 1815:     */     {
/* 1816:1518 */       addCriterion("UserInfo.push_statr_supporters between", value1, value2, "pushStatrSupporters");
/* 1817:1519 */       return (Criteria)this;
/* 1818:     */     }
/* 1819:     */     
/* 1820:     */     public Criteria andPushStatrSupportersNotBetween(String value1, String value2)
/* 1821:     */     {
/* 1822:1523 */       addCriterion("UserInfo.push_statr_supporters not between", value1, value2, "pushStatrSupporters");
/* 1823:1524 */       return (Criteria)this;
/* 1824:     */     }
/* 1825:     */     
/* 1826:     */     public Criteria andPushMusicIsNull()
/* 1827:     */     {
/* 1828:1528 */       addCriterion("UserInfo.push_music is null");
/* 1829:1529 */       return (Criteria)this;
/* 1830:     */     }
/* 1831:     */     
/* 1832:     */     public Criteria andPushMusicIsNotNull()
/* 1833:     */     {
/* 1834:1533 */       addCriterion("UserInfo.push_music is not null");
/* 1835:1534 */       return (Criteria)this;
/* 1836:     */     }
/* 1837:     */     
/* 1838:     */     public Criteria andPushMusicEqualTo(String value)
/* 1839:     */     {
/* 1840:1538 */       addCriterion("UserInfo.push_music =", value, "pushMusic");
/* 1841:1539 */       return (Criteria)this;
/* 1842:     */     }
/* 1843:     */     
/* 1844:     */     public Criteria andPushMusicNotEqualTo(String value)
/* 1845:     */     {
/* 1846:1543 */       addCriterion("UserInfo.push_music <>", value, "pushMusic");
/* 1847:1544 */       return (Criteria)this;
/* 1848:     */     }
/* 1849:     */     
/* 1850:     */     public Criteria andPushMusicGreaterThan(String value)
/* 1851:     */     {
/* 1852:1548 */       addCriterion("UserInfo.push_music >", value, "pushMusic");
/* 1853:1549 */       return (Criteria)this;
/* 1854:     */     }
/* 1855:     */     
/* 1856:     */     public Criteria andPushMusicGreaterThanOrEqualTo(String value)
/* 1857:     */     {
/* 1858:1553 */       addCriterion("UserInfo.push_music >=", value, "pushMusic");
/* 1859:1554 */       return (Criteria)this;
/* 1860:     */     }
/* 1861:     */     
/* 1862:     */     public Criteria andPushMusicLessThan(String value)
/* 1863:     */     {
/* 1864:1558 */       addCriterion("UserInfo.push_music <", value, "pushMusic");
/* 1865:1559 */       return (Criteria)this;
/* 1866:     */     }
/* 1867:     */     
/* 1868:     */     public Criteria andPushMusicLessThanOrEqualTo(String value)
/* 1869:     */     {
/* 1870:1563 */       addCriterion("UserInfo.push_music <=", value, "pushMusic");
/* 1871:1564 */       return (Criteria)this;
/* 1872:     */     }
/* 1873:     */     
/* 1874:     */     public Criteria andPushMusicLike(String value)
/* 1875:     */     {
/* 1876:1568 */       addCriterion("UserInfo.push_music like", value, "pushMusic");
/* 1877:1569 */       return (Criteria)this;
/* 1878:     */     }
/* 1879:     */     
/* 1880:     */     public Criteria andPushMusicNotLike(String value)
/* 1881:     */     {
/* 1882:1573 */       addCriterion("UserInfo.push_music not like", value, "pushMusic");
/* 1883:1574 */       return (Criteria)this;
/* 1884:     */     }
/* 1885:     */     
/* 1886:     */     public Criteria andPushMusicIn(List<String> values)
/* 1887:     */     {
/* 1888:1578 */       addCriterion("UserInfo.push_music in", values, "pushMusic");
/* 1889:1579 */       return (Criteria)this;
/* 1890:     */     }
/* 1891:     */     
/* 1892:     */     public Criteria andPushMusicNotIn(List<String> values)
/* 1893:     */     {
/* 1894:1583 */       addCriterion("UserInfo.push_music not in", values, "pushMusic");
/* 1895:1584 */       return (Criteria)this;
/* 1896:     */     }
/* 1897:     */     
/* 1898:     */     public Criteria andPushMusicBetween(String value1, String value2)
/* 1899:     */     {
/* 1900:1588 */       addCriterion("UserInfo.push_music between", value1, value2, "pushMusic");
/* 1901:1589 */       return (Criteria)this;
/* 1902:     */     }
/* 1903:     */     
/* 1904:     */     public Criteria andPushMusicNotBetween(String value1, String value2)
/* 1905:     */     {
/* 1906:1593 */       addCriterion("UserInfo.push_music not between", value1, value2, "pushMusic");
/* 1907:1594 */       return (Criteria)this;
/* 1908:     */     }
/* 1909:     */     
/* 1910:     */     public Criteria andPushStartInvoiceIsNull()
/* 1911:     */     {
/* 1912:1598 */       addCriterion("UserInfo.push_start_invoice is null");
/* 1913:1599 */       return (Criteria)this;
/* 1914:     */     }
/* 1915:     */     
/* 1916:     */     public Criteria andPushStartInvoiceIsNotNull()
/* 1917:     */     {
/* 1918:1603 */       addCriterion("UserInfo.push_start_invoice is not null");
/* 1919:1604 */       return (Criteria)this;
/* 1920:     */     }
/* 1921:     */     
/* 1922:     */     public Criteria andPushStartInvoiceEqualTo(String value)
/* 1923:     */     {
/* 1924:1608 */       addCriterion("UserInfo.push_start_invoice =", value, "pushStartInvoice");
/* 1925:1609 */       return (Criteria)this;
/* 1926:     */     }
/* 1927:     */     
/* 1928:     */     public Criteria andPushStartInvoiceNotEqualTo(String value)
/* 1929:     */     {
/* 1930:1613 */       addCriterion("UserInfo.push_start_invoice <>", value, "pushStartInvoice");
/* 1931:1614 */       return (Criteria)this;
/* 1932:     */     }
/* 1933:     */     
/* 1934:     */     public Criteria andPushStartInvoiceGreaterThan(String value)
/* 1935:     */     {
/* 1936:1618 */       addCriterion("UserInfo.push_start_invoice >", value, "pushStartInvoice");
/* 1937:1619 */       return (Criteria)this;
/* 1938:     */     }
/* 1939:     */     
/* 1940:     */     public Criteria andPushStartInvoiceGreaterThanOrEqualTo(String value)
/* 1941:     */     {
/* 1942:1623 */       addCriterion("UserInfo.push_start_invoice >=", value, "pushStartInvoice");
/* 1943:1624 */       return (Criteria)this;
/* 1944:     */     }
/* 1945:     */     
/* 1946:     */     public Criteria andPushStartInvoiceLessThan(String value)
/* 1947:     */     {
/* 1948:1628 */       addCriterion("UserInfo.push_start_invoice <", value, "pushStartInvoice");
/* 1949:1629 */       return (Criteria)this;
/* 1950:     */     }
/* 1951:     */     
/* 1952:     */     public Criteria andPushStartInvoiceLessThanOrEqualTo(String value)
/* 1953:     */     {
/* 1954:1633 */       addCriterion("UserInfo.push_start_invoice <=", value, "pushStartInvoice");
/* 1955:1634 */       return (Criteria)this;
/* 1956:     */     }
/* 1957:     */     
/* 1958:     */     public Criteria andPushStartInvoiceLike(String value)
/* 1959:     */     {
/* 1960:1638 */       addCriterion("UserInfo.push_start_invoice like", value, "pushStartInvoice");
/* 1961:1639 */       return (Criteria)this;
/* 1962:     */     }
/* 1963:     */     
/* 1964:     */     public Criteria andPushStartInvoiceNotLike(String value)
/* 1965:     */     {
/* 1966:1643 */       addCriterion("UserInfo.push_start_invoice not like", value, "pushStartInvoice");
/* 1967:1644 */       return (Criteria)this;
/* 1968:     */     }
/* 1969:     */     
/* 1970:     */     public Criteria andPushStartInvoiceIn(List<String> values)
/* 1971:     */     {
/* 1972:1648 */       addCriterion("UserInfo.push_start_invoice in", values, "pushStartInvoice");
/* 1973:1649 */       return (Criteria)this;
/* 1974:     */     }
/* 1975:     */     
/* 1976:     */     public Criteria andPushStartInvoiceNotIn(List<String> values)
/* 1977:     */     {
/* 1978:1653 */       addCriterion("UserInfo.push_start_invoice not in", values, "pushStartInvoice");
/* 1979:1654 */       return (Criteria)this;
/* 1980:     */     }
/* 1981:     */     
/* 1982:     */     public Criteria andPushStartInvoiceBetween(String value1, String value2)
/* 1983:     */     {
/* 1984:1658 */       addCriterion("UserInfo.push_start_invoice between", value1, value2, "pushStartInvoice");
/* 1985:1659 */       return (Criteria)this;
/* 1986:     */     }
/* 1987:     */     
/* 1988:     */     public Criteria andPushStartInvoiceNotBetween(String value1, String value2)
/* 1989:     */     {
/* 1990:1663 */       addCriterion("UserInfo.push_start_invoice not between", value1, value2, "pushStartInvoice");
/* 1991:1664 */       return (Criteria)this;
/* 1992:     */     }
/* 1993:     */     
/* 1994:     */     public Criteria andDaysIsNull()
/* 1995:     */     {
/* 1996:1668 */       addCriterion("UserInfo.days is null");
/* 1997:1669 */       return (Criteria)this;
/* 1998:     */     }
/* 1999:     */     
/* 2000:     */     public Criteria andDaysIsNotNull()
/* 2001:     */     {
/* 2002:1673 */       addCriterion("UserInfo.days is not null");
/* 2003:1674 */       return (Criteria)this;
/* 2004:     */     }
/* 2005:     */     
/* 2006:     */     public Criteria andDaysEqualTo(String value)
/* 2007:     */     {
/* 2008:1678 */       addCriterion("UserInfo.days =", value, "days");
/* 2009:1679 */       return (Criteria)this;
/* 2010:     */     }
/* 2011:     */     
/* 2012:     */     public Criteria andDaysNotEqualTo(String value)
/* 2013:     */     {
/* 2014:1683 */       addCriterion("UserInfo.days <>", value, "days");
/* 2015:1684 */       return (Criteria)this;
/* 2016:     */     }
/* 2017:     */     
/* 2018:     */     public Criteria andDaysGreaterThan(String value)
/* 2019:     */     {
/* 2020:1688 */       addCriterion("UserInfo.days >", value, "days");
/* 2021:1689 */       return (Criteria)this;
/* 2022:     */     }
/* 2023:     */     
/* 2024:     */     public Criteria andDaysGreaterThanOrEqualTo(String value)
/* 2025:     */     {
/* 2026:1693 */       addCriterion("UserInfo.days >=", value, "days");
/* 2027:1694 */       return (Criteria)this;
/* 2028:     */     }
/* 2029:     */     
/* 2030:     */     public Criteria andDaysLessThan(String value)
/* 2031:     */     {
/* 2032:1698 */       addCriterion("UserInfo.days <", value, "days");
/* 2033:1699 */       return (Criteria)this;
/* 2034:     */     }
/* 2035:     */     
/* 2036:     */     public Criteria andDaysLessThanOrEqualTo(String value)
/* 2037:     */     {
/* 2038:1703 */       addCriterion("UserInfo.days <=", value, "days");
/* 2039:1704 */       return (Criteria)this;
/* 2040:     */     }
/* 2041:     */     
/* 2042:     */     public Criteria andDaysLike(String value)
/* 2043:     */     {
/* 2044:1708 */       addCriterion("UserInfo.days like", value, "days");
/* 2045:1709 */       return (Criteria)this;
/* 2046:     */     }
/* 2047:     */     
/* 2048:     */     public Criteria andDaysNotLike(String value)
/* 2049:     */     {
/* 2050:1713 */       addCriterion("UserInfo.days not like", value, "days");
/* 2051:1714 */       return (Criteria)this;
/* 2052:     */     }
/* 2053:     */     
/* 2054:     */     public Criteria andDaysIn(List<String> values)
/* 2055:     */     {
/* 2056:1718 */       addCriterion("UserInfo.days in", values, "days");
/* 2057:1719 */       return (Criteria)this;
/* 2058:     */     }
/* 2059:     */     
/* 2060:     */     public Criteria andDaysNotIn(List<String> values)
/* 2061:     */     {
/* 2062:1723 */       addCriterion("UserInfo.days not in", values, "days");
/* 2063:1724 */       return (Criteria)this;
/* 2064:     */     }
/* 2065:     */     
/* 2066:     */     public Criteria andDaysBetween(String value1, String value2)
/* 2067:     */     {
/* 2068:1728 */       addCriterion("UserInfo.days between", value1, value2, "days");
/* 2069:1729 */       return (Criteria)this;
/* 2070:     */     }
/* 2071:     */     
/* 2072:     */     public Criteria andDaysNotBetween(String value1, String value2)
/* 2073:     */     {
/* 2074:1733 */       addCriterion("UserInfo.days not between", value1, value2, "days");
/* 2075:1734 */       return (Criteria)this;
/* 2076:     */     }
/* 2077:     */     
/* 2078:     */     public Criteria andQiandaotimeIsNull()
/* 2079:     */     {
/* 2080:1738 */       addCriterion("UserInfo.qiandaotime is null");
/* 2081:1739 */       return (Criteria)this;
/* 2082:     */     }
/* 2083:     */     
/* 2084:     */     public Criteria andQiandaotimeIsNotNull()
/* 2085:     */     {
/* 2086:1743 */       addCriterion("UserInfo.qiandaotime is not null");
/* 2087:1744 */       return (Criteria)this;
/* 2088:     */     }
/* 2089:     */     
/* 2090:     */     public Criteria andQiandaotimeEqualTo(String value)
/* 2091:     */     {
/* 2092:1748 */       addCriterion("UserInfo.qiandaotime =", value, "qiandaotime");
/* 2093:1749 */       return (Criteria)this;
/* 2094:     */     }
/* 2095:     */     
/* 2096:     */     public Criteria andQiandaotimeNotEqualTo(String value)
/* 2097:     */     {
/* 2098:1753 */       addCriterion("UserInfo.qiandaotime <>", value, "qiandaotime");
/* 2099:1754 */       return (Criteria)this;
/* 2100:     */     }
/* 2101:     */     
/* 2102:     */     public Criteria andQiandaotimeGreaterThan(String value)
/* 2103:     */     {
/* 2104:1758 */       addCriterion("UserInfo.qiandaotime >", value, "qiandaotime");
/* 2105:1759 */       return (Criteria)this;
/* 2106:     */     }
/* 2107:     */     
/* 2108:     */     public Criteria andQiandaotimeGreaterThanOrEqualTo(String value)
/* 2109:     */     {
/* 2110:1763 */       addCriterion("UserInfo.qiandaotime >=", value, "qiandaotime");
/* 2111:1764 */       return (Criteria)this;
/* 2112:     */     }
/* 2113:     */     
/* 2114:     */     public Criteria andQiandaotimeLessThan(String value)
/* 2115:     */     {
/* 2116:1768 */       addCriterion("UserInfo.qiandaotime <", value, "qiandaotime");
/* 2117:1769 */       return (Criteria)this;
/* 2118:     */     }
/* 2119:     */     
/* 2120:     */     public Criteria andQiandaotimeLessThanOrEqualTo(String value)
/* 2121:     */     {
/* 2122:1773 */       addCriterion("UserInfo.qiandaotime <=", value, "qiandaotime");
/* 2123:1774 */       return (Criteria)this;
/* 2124:     */     }
/* 2125:     */     
/* 2126:     */     public Criteria andQiandaotimeLike(String value)
/* 2127:     */     {
/* 2128:1778 */       addCriterion("UserInfo.qiandaotime like", value, "qiandaotime");
/* 2129:1779 */       return (Criteria)this;
/* 2130:     */     }
/* 2131:     */     
/* 2132:     */     public Criteria andQiandaotimeNotLike(String value)
/* 2133:     */     {
/* 2134:1783 */       addCriterion("UserInfo.qiandaotime not like", value, "qiandaotime");
/* 2135:1784 */       return (Criteria)this;
/* 2136:     */     }
/* 2137:     */     
/* 2138:     */     public Criteria andQiandaotimeIn(List<String> values)
/* 2139:     */     {
/* 2140:1788 */       addCriterion("UserInfo.qiandaotime in", values, "qiandaotime");
/* 2141:1789 */       return (Criteria)this;
/* 2142:     */     }
/* 2143:     */     
/* 2144:     */     public Criteria andQiandaotimeNotIn(List<String> values)
/* 2145:     */     {
/* 2146:1793 */       addCriterion("UserInfo.qiandaotime not in", values, "qiandaotime");
/* 2147:1794 */       return (Criteria)this;
/* 2148:     */     }
/* 2149:     */     
/* 2150:     */     public Criteria andQiandaotimeBetween(String value1, String value2)
/* 2151:     */     {
/* 2152:1798 */       addCriterion("UserInfo.qiandaotime between", value1, value2, "qiandaotime");
/* 2153:1799 */       return (Criteria)this;
/* 2154:     */     }
/* 2155:     */     
/* 2156:     */     public Criteria andQiandaotimeNotBetween(String value1, String value2)
/* 2157:     */     {
/* 2158:1803 */       addCriterion("UserInfo.qiandaotime not between", value1, value2, "qiandaotime");
/* 2159:1804 */       return (Criteria)this;
/* 2160:     */     }
/* 2161:     */     
/* 2162:     */     public Criteria andUserexplainIsNull()
/* 2163:     */     {
/* 2164:1808 */       addCriterion("UserInfo.userexplain is null");
/* 2165:1809 */       return (Criteria)this;
/* 2166:     */     }
/* 2167:     */     
/* 2168:     */     public Criteria andUserexplainIsNotNull()
/* 2169:     */     {
/* 2170:1813 */       addCriterion("UserInfo.userexplain is not null");
/* 2171:1814 */       return (Criteria)this;
/* 2172:     */     }
/* 2173:     */     
/* 2174:     */     public Criteria andUserexplainEqualTo(String value)
/* 2175:     */     {
/* 2176:1818 */       addCriterion("UserInfo.userexplain =", value, "userexplain");
/* 2177:1819 */       return (Criteria)this;
/* 2178:     */     }
/* 2179:     */     
/* 2180:     */     public Criteria andUserexplainNotEqualTo(String value)
/* 2181:     */     {
/* 2182:1823 */       addCriterion("UserInfo.userexplain <>", value, "userexplain");
/* 2183:1824 */       return (Criteria)this;
/* 2184:     */     }
/* 2185:     */     
/* 2186:     */     public Criteria andUserexplainGreaterThan(String value)
/* 2187:     */     {
/* 2188:1828 */       addCriterion("UserInfo.userexplain >", value, "userexplain");
/* 2189:1829 */       return (Criteria)this;
/* 2190:     */     }
/* 2191:     */     
/* 2192:     */     public Criteria andUserexplainGreaterThanOrEqualTo(String value)
/* 2193:     */     {
/* 2194:1833 */       addCriterion("UserInfo.userexplain >=", value, "userexplain");
/* 2195:1834 */       return (Criteria)this;
/* 2196:     */     }
/* 2197:     */     
/* 2198:     */     public Criteria andUserexplainLessThan(String value)
/* 2199:     */     {
/* 2200:1838 */       addCriterion("UserInfo.userexplain <", value, "userexplain");
/* 2201:1839 */       return (Criteria)this;
/* 2202:     */     }
/* 2203:     */     
/* 2204:     */     public Criteria andUserexplainLessThanOrEqualTo(String value)
/* 2205:     */     {
/* 2206:1843 */       addCriterion("UserInfo.userexplain <=", value, "userexplain");
/* 2207:1844 */       return (Criteria)this;
/* 2208:     */     }
/* 2209:     */     
/* 2210:     */     public Criteria andUserexplainLike(String value)
/* 2211:     */     {
/* 2212:1848 */       addCriterion("UserInfo.userexplain like", value, "userexplain");
/* 2213:1849 */       return (Criteria)this;
/* 2214:     */     }
/* 2215:     */     
/* 2216:     */     public Criteria andUserexplainNotLike(String value)
/* 2217:     */     {
/* 2218:1853 */       addCriterion("UserInfo.userexplain not like", value, "userexplain");
/* 2219:1854 */       return (Criteria)this;
/* 2220:     */     }
/* 2221:     */     
/* 2222:     */     public Criteria andUserexplainIn(List<String> values)
/* 2223:     */     {
/* 2224:1858 */       addCriterion("UserInfo.userexplain in", values, "userexplain");
/* 2225:1859 */       return (Criteria)this;
/* 2226:     */     }
/* 2227:     */     
/* 2228:     */     public Criteria andUserexplainNotIn(List<String> values)
/* 2229:     */     {
/* 2230:1863 */       addCriterion("UserInfo.userexplain not in", values, "userexplain");
/* 2231:1864 */       return (Criteria)this;
/* 2232:     */     }
/* 2233:     */     
/* 2234:     */     public Criteria andUserexplainBetween(String value1, String value2)
/* 2235:     */     {
/* 2236:1868 */       addCriterion("UserInfo.userexplain between", value1, value2, "userexplain");
/* 2237:1869 */       return (Criteria)this;
/* 2238:     */     }
/* 2239:     */     
/* 2240:     */     public Criteria andUserexplainNotBetween(String value1, String value2)
/* 2241:     */     {
/* 2242:1873 */       addCriterion("UserInfo.userexplain not between", value1, value2, "userexplain");
/* 2243:1874 */       return (Criteria)this;
/* 2244:     */     }
/* 2245:     */     
/* 2246:     */     public Criteria andPhotourlIsNull()
/* 2247:     */     {
/* 2248:1878 */       addCriterion("UserInfo.photourl is null");
/* 2249:1879 */       return (Criteria)this;
/* 2250:     */     }
/* 2251:     */     
/* 2252:     */     public Criteria andPhotourlIsNotNull()
/* 2253:     */     {
/* 2254:1883 */       addCriterion("UserInfo.photourl is not null");
/* 2255:1884 */       return (Criteria)this;
/* 2256:     */     }
/* 2257:     */     
/* 2258:     */     public Criteria andPhotourlEqualTo(String value)
/* 2259:     */     {
/* 2260:1888 */       addCriterion("UserInfo.photourl =", value, "photourl");
/* 2261:1889 */       return (Criteria)this;
/* 2262:     */     }
/* 2263:     */     
/* 2264:     */     public Criteria andPhotourlNotEqualTo(String value)
/* 2265:     */     {
/* 2266:1893 */       addCriterion("UserInfo.photourl <>", value, "photourl");
/* 2267:1894 */       return (Criteria)this;
/* 2268:     */     }
/* 2269:     */     
/* 2270:     */     public Criteria andPhotourlGreaterThan(String value)
/* 2271:     */     {
/* 2272:1898 */       addCriterion("UserInfo.photourl >", value, "photourl");
/* 2273:1899 */       return (Criteria)this;
/* 2274:     */     }
/* 2275:     */     
/* 2276:     */     public Criteria andPhotourlGreaterThanOrEqualTo(String value)
/* 2277:     */     {
/* 2278:1903 */       addCriterion("UserInfo.photourl >=", value, "photourl");
/* 2279:1904 */       return (Criteria)this;
/* 2280:     */     }
/* 2281:     */     
/* 2282:     */     public Criteria andPhotourlLessThan(String value)
/* 2283:     */     {
/* 2284:1908 */       addCriterion("UserInfo.photourl <", value, "photourl");
/* 2285:1909 */       return (Criteria)this;
/* 2286:     */     }
/* 2287:     */     
/* 2288:     */     public Criteria andPhotourlLessThanOrEqualTo(String value)
/* 2289:     */     {
/* 2290:1913 */       addCriterion("UserInfo.photourl <=", value, "photourl");
/* 2291:1914 */       return (Criteria)this;
/* 2292:     */     }
/* 2293:     */     
/* 2294:     */     public Criteria andPhotourlLike(String value)
/* 2295:     */     {
/* 2296:1918 */       addCriterion("UserInfo.photourl like", value, "photourl");
/* 2297:1919 */       return (Criteria)this;
/* 2298:     */     }
/* 2299:     */     
/* 2300:     */     public Criteria andPhotourlNotLike(String value)
/* 2301:     */     {
/* 2302:1923 */       addCriterion("UserInfo.photourl not like", value, "photourl");
/* 2303:1924 */       return (Criteria)this;
/* 2304:     */     }
/* 2305:     */     
/* 2306:     */     public Criteria andPhotourlIn(List<String> values)
/* 2307:     */     {
/* 2308:1928 */       addCriterion("UserInfo.photourl in", values, "photourl");
/* 2309:1929 */       return (Criteria)this;
/* 2310:     */     }
/* 2311:     */     
/* 2312:     */     public Criteria andPhotourlNotIn(List<String> values)
/* 2313:     */     {
/* 2314:1933 */       addCriterion("UserInfo.photourl not in", values, "photourl");
/* 2315:1934 */       return (Criteria)this;
/* 2316:     */     }
/* 2317:     */     
/* 2318:     */     public Criteria andPhotourlBetween(String value1, String value2)
/* 2319:     */     {
/* 2320:1938 */       addCriterion("UserInfo.photourl between", value1, value2, "photourl");
/* 2321:1939 */       return (Criteria)this;
/* 2322:     */     }
/* 2323:     */     
/* 2324:     */     public Criteria andPhotourlNotBetween(String value1, String value2)
/* 2325:     */     {
/* 2326:1943 */       addCriterion("UserInfo.photourl not between", value1, value2, "photourl");
/* 2327:1944 */       return (Criteria)this;
/* 2328:     */     }
/* 2329:     */     
/* 2330:     */     public Criteria andPublicityIsNull()
/* 2331:     */     {
/* 2332:1948 */       addCriterion("UserInfo.publicity is null");
/* 2333:1949 */       return (Criteria)this;
/* 2334:     */     }
/* 2335:     */     
/* 2336:     */     public Criteria andPublicityIsNotNull()
/* 2337:     */     {
/* 2338:1953 */       addCriterion("UserInfo.publicity is not null");
/* 2339:1954 */       return (Criteria)this;
/* 2340:     */     }
/* 2341:     */     
/* 2342:     */     public Criteria andPublicityEqualTo(String value)
/* 2343:     */     {
/* 2344:1958 */       addCriterion("UserInfo.publicity =", value, "publicity");
/* 2345:1959 */       return (Criteria)this;
/* 2346:     */     }
/* 2347:     */     
/* 2348:     */     public Criteria andPublicityNotEqualTo(String value)
/* 2349:     */     {
/* 2350:1963 */       addCriterion("UserInfo.publicity <>", value, "publicity");
/* 2351:1964 */       return (Criteria)this;
/* 2352:     */     }
/* 2353:     */     
/* 2354:     */     public Criteria andPublicityGreaterThan(String value)
/* 2355:     */     {
/* 2356:1968 */       addCriterion("UserInfo.publicity >", value, "publicity");
/* 2357:1969 */       return (Criteria)this;
/* 2358:     */     }
/* 2359:     */     
/* 2360:     */     public Criteria andPublicityGreaterThanOrEqualTo(String value)
/* 2361:     */     {
/* 2362:1973 */       addCriterion("UserInfo.publicity >=", value, "publicity");
/* 2363:1974 */       return (Criteria)this;
/* 2364:     */     }
/* 2365:     */     
/* 2366:     */     public Criteria andPublicityLessThan(String value)
/* 2367:     */     {
/* 2368:1978 */       addCriterion("UserInfo.publicity <", value, "publicity");
/* 2369:1979 */       return (Criteria)this;
/* 2370:     */     }
/* 2371:     */     
/* 2372:     */     public Criteria andPublicityLessThanOrEqualTo(String value)
/* 2373:     */     {
/* 2374:1983 */       addCriterion("UserInfo.publicity <=", value, "publicity");
/* 2375:1984 */       return (Criteria)this;
/* 2376:     */     }
/* 2377:     */     
/* 2378:     */     public Criteria andPublicityLike(String value)
/* 2379:     */     {
/* 2380:1988 */       addCriterion("UserInfo.publicity like", value, "publicity");
/* 2381:1989 */       return (Criteria)this;
/* 2382:     */     }
/* 2383:     */     
/* 2384:     */     public Criteria andPublicityNotLike(String value)
/* 2385:     */     {
/* 2386:1993 */       addCriterion("UserInfo.publicity not like", value, "publicity");
/* 2387:1994 */       return (Criteria)this;
/* 2388:     */     }
/* 2389:     */     
/* 2390:     */     public Criteria andPublicityIn(List<String> values)
/* 2391:     */     {
/* 2392:1998 */       addCriterion("UserInfo.publicity in", values, "publicity");
/* 2393:1999 */       return (Criteria)this;
/* 2394:     */     }
/* 2395:     */     
/* 2396:     */     public Criteria andPublicityNotIn(List<String> values)
/* 2397:     */     {
/* 2398:2003 */       addCriterion("UserInfo.publicity not in", values, "publicity");
/* 2399:2004 */       return (Criteria)this;
/* 2400:     */     }
/* 2401:     */     
/* 2402:     */     public Criteria andPublicityBetween(String value1, String value2)
/* 2403:     */     {
/* 2404:2008 */       addCriterion("UserInfo.publicity between", value1, value2, "publicity");
/* 2405:2009 */       return (Criteria)this;
/* 2406:     */     }
/* 2407:     */     
/* 2408:     */     public Criteria andPublicityNotBetween(String value1, String value2)
/* 2409:     */     {
/* 2410:2013 */       addCriterion("UserInfo.publicity not between", value1, value2, "publicity");
/* 2411:2014 */       return (Criteria)this;
/* 2412:     */     }
/* 2413:     */     
/* 2414:     */     public Criteria andAreaIsNull()
/* 2415:     */     {
/* 2416:2018 */       addCriterion("UserInfo.area is null");
/* 2417:2019 */       return (Criteria)this;
/* 2418:     */     }
/* 2419:     */     
/* 2420:     */     public Criteria andAreaIsNotNull()
/* 2421:     */     {
/* 2422:2023 */       addCriterion("UserInfo.area is not null");
/* 2423:2024 */       return (Criteria)this;
/* 2424:     */     }
/* 2425:     */     
/* 2426:     */     public Criteria andAreaEqualTo(String value)
/* 2427:     */     {
/* 2428:2028 */       addCriterion("UserInfo.area =", value, "area");
/* 2429:2029 */       return (Criteria)this;
/* 2430:     */     }
/* 2431:     */     
/* 2432:     */     public Criteria andAreaNotEqualTo(String value)
/* 2433:     */     {
/* 2434:2033 */       addCriterion("UserInfo.area <>", value, "area");
/* 2435:2034 */       return (Criteria)this;
/* 2436:     */     }
/* 2437:     */     
/* 2438:     */     public Criteria andAreaGreaterThan(String value)
/* 2439:     */     {
/* 2440:2038 */       addCriterion("UserInfo.area >", value, "area");
/* 2441:2039 */       return (Criteria)this;
/* 2442:     */     }
/* 2443:     */     
/* 2444:     */     public Criteria andAreaGreaterThanOrEqualTo(String value)
/* 2445:     */     {
/* 2446:2043 */       addCriterion("UserInfo.area >=", value, "area");
/* 2447:2044 */       return (Criteria)this;
/* 2448:     */     }
/* 2449:     */     
/* 2450:     */     public Criteria andAreaLessThan(String value)
/* 2451:     */     {
/* 2452:2048 */       addCriterion("UserInfo.area <", value, "area");
/* 2453:2049 */       return (Criteria)this;
/* 2454:     */     }
/* 2455:     */     
/* 2456:     */     public Criteria andAreaLessThanOrEqualTo(String value)
/* 2457:     */     {
/* 2458:2053 */       addCriterion("UserInfo.area <=", value, "area");
/* 2459:2054 */       return (Criteria)this;
/* 2460:     */     }
/* 2461:     */     
/* 2462:     */     public Criteria andAreaLike(String value)
/* 2463:     */     {
/* 2464:2058 */       addCriterion("UserInfo.area like", value, "area");
/* 2465:2059 */       return (Criteria)this;
/* 2466:     */     }
/* 2467:     */     
/* 2468:     */     public Criteria andAreaNotLike(String value)
/* 2469:     */     {
/* 2470:2063 */       addCriterion("UserInfo.area not like", value, "area");
/* 2471:2064 */       return (Criteria)this;
/* 2472:     */     }
/* 2473:     */     
/* 2474:     */     public Criteria andAreaIn(List<String> values)
/* 2475:     */     {
/* 2476:2068 */       addCriterion("UserInfo.area in", values, "area");
/* 2477:2069 */       return (Criteria)this;
/* 2478:     */     }
/* 2479:     */     
/* 2480:     */     public Criteria andAreaNotIn(List<String> values)
/* 2481:     */     {
/* 2482:2073 */       addCriterion("UserInfo.area not in", values, "area");
/* 2483:2074 */       return (Criteria)this;
/* 2484:     */     }
/* 2485:     */     
/* 2486:     */     public Criteria andAreaBetween(String value1, String value2)
/* 2487:     */     {
/* 2488:2078 */       addCriterion("UserInfo.area between", value1, value2, "area");
/* 2489:2079 */       return (Criteria)this;
/* 2490:     */     }
/* 2491:     */     
/* 2492:     */     public Criteria andAreaNotBetween(String value1, String value2)
/* 2493:     */     {
/* 2494:2083 */       addCriterion("UserInfo.area not between", value1, value2, "area");
/* 2495:2084 */       return (Criteria)this;
/* 2496:     */     }
/* 2497:     */     
/* 2498:     */     public Criteria andAdverIsNull()
/* 2499:     */     {
/* 2500:2088 */       addCriterion("UserInfo.adver is null");
/* 2501:2089 */       return (Criteria)this;
/* 2502:     */     }
/* 2503:     */     
/* 2504:     */     public Criteria andAdverIsNotNull()
/* 2505:     */     {
/* 2506:2093 */       addCriterion("UserInfo.adver is not null");
/* 2507:2094 */       return (Criteria)this;
/* 2508:     */     }
/* 2509:     */     
/* 2510:     */     public Criteria andAdverEqualTo(String value)
/* 2511:     */     {
/* 2512:2098 */       addCriterion("UserInfo.adver =", value, "adver");
/* 2513:2099 */       return (Criteria)this;
/* 2514:     */     }
/* 2515:     */     
/* 2516:     */     public Criteria andAdverNotEqualTo(String value)
/* 2517:     */     {
/* 2518:2103 */       addCriterion("UserInfo.adver <>", value, "adver");
/* 2519:2104 */       return (Criteria)this;
/* 2520:     */     }
/* 2521:     */     
/* 2522:     */     public Criteria andAdverGreaterThan(String value)
/* 2523:     */     {
/* 2524:2108 */       addCriterion("UserInfo.adver >", value, "adver");
/* 2525:2109 */       return (Criteria)this;
/* 2526:     */     }
/* 2527:     */     
/* 2528:     */     public Criteria andAdverGreaterThanOrEqualTo(String value)
/* 2529:     */     {
/* 2530:2113 */       addCriterion("UserInfo.adver >=", value, "adver");
/* 2531:2114 */       return (Criteria)this;
/* 2532:     */     }
/* 2533:     */     
/* 2534:     */     public Criteria andAdverLessThan(String value)
/* 2535:     */     {
/* 2536:2118 */       addCriterion("UserInfo.adver <", value, "adver");
/* 2537:2119 */       return (Criteria)this;
/* 2538:     */     }
/* 2539:     */     
/* 2540:     */     public Criteria andAdverLessThanOrEqualTo(String value)
/* 2541:     */     {
/* 2542:2123 */       addCriterion("UserInfo.adver <=", value, "adver");
/* 2543:2124 */       return (Criteria)this;
/* 2544:     */     }
/* 2545:     */     
/* 2546:     */     public Criteria andAdverLike(String value)
/* 2547:     */     {
/* 2548:2128 */       addCriterion("UserInfo.adver like", value, "adver");
/* 2549:2129 */       return (Criteria)this;
/* 2550:     */     }
/* 2551:     */     
/* 2552:     */     public Criteria andAdverNotLike(String value)
/* 2553:     */     {
/* 2554:2133 */       addCriterion("UserInfo.adver not like", value, "adver");
/* 2555:2134 */       return (Criteria)this;
/* 2556:     */     }
/* 2557:     */     
/* 2558:     */     public Criteria andAdverIn(List<String> values)
/* 2559:     */     {
/* 2560:2138 */       addCriterion("UserInfo.adver in", values, "adver");
/* 2561:2139 */       return (Criteria)this;
/* 2562:     */     }
/* 2563:     */     
/* 2564:     */     public Criteria andAdverNotIn(List<String> values)
/* 2565:     */     {
/* 2566:2143 */       addCriterion("UserInfo.adver not in", values, "adver");
/* 2567:2144 */       return (Criteria)this;
/* 2568:     */     }
/* 2569:     */     
/* 2570:     */     public Criteria andAdverBetween(String value1, String value2)
/* 2571:     */     {
/* 2572:2148 */       addCriterion("UserInfo.adver between", value1, value2, "adver");
/* 2573:2149 */       return (Criteria)this;
/* 2574:     */     }
/* 2575:     */     
/* 2576:     */     public Criteria andAdverNotBetween(String value1, String value2)
/* 2577:     */     {
/* 2578:2153 */       addCriterion("UserInfo.adver not between", value1, value2, "adver");
/* 2579:2154 */       return (Criteria)this;
/* 2580:     */     }
/* 2581:     */     
/* 2582:     */     public Criteria andIosverIsNull()
/* 2583:     */     {
/* 2584:2158 */       addCriterion("UserInfo.iosver is null");
/* 2585:2159 */       return (Criteria)this;
/* 2586:     */     }
/* 2587:     */     
/* 2588:     */     public Criteria andIosverIsNotNull()
/* 2589:     */     {
/* 2590:2163 */       addCriterion("UserInfo.iosver is not null");
/* 2591:2164 */       return (Criteria)this;
/* 2592:     */     }
/* 2593:     */     
/* 2594:     */     public Criteria andIosverEqualTo(String value)
/* 2595:     */     {
/* 2596:2168 */       addCriterion("UserInfo.iosver =", value, "iosver");
/* 2597:2169 */       return (Criteria)this;
/* 2598:     */     }
/* 2599:     */     
/* 2600:     */     public Criteria andIosverNotEqualTo(String value)
/* 2601:     */     {
/* 2602:2173 */       addCriterion("UserInfo.iosver <>", value, "iosver");
/* 2603:2174 */       return (Criteria)this;
/* 2604:     */     }
/* 2605:     */     
/* 2606:     */     public Criteria andIosverGreaterThan(String value)
/* 2607:     */     {
/* 2608:2178 */       addCriterion("UserInfo.iosver >", value, "iosver");
/* 2609:2179 */       return (Criteria)this;
/* 2610:     */     }
/* 2611:     */     
/* 2612:     */     public Criteria andIosverGreaterThanOrEqualTo(String value)
/* 2613:     */     {
/* 2614:2183 */       addCriterion("UserInfo.iosver >=", value, "iosver");
/* 2615:2184 */       return (Criteria)this;
/* 2616:     */     }
/* 2617:     */     
/* 2618:     */     public Criteria andIosverLessThan(String value)
/* 2619:     */     {
/* 2620:2188 */       addCriterion("UserInfo.iosver <", value, "iosver");
/* 2621:2189 */       return (Criteria)this;
/* 2622:     */     }
/* 2623:     */     
/* 2624:     */     public Criteria andIosverLessThanOrEqualTo(String value)
/* 2625:     */     {
/* 2626:2193 */       addCriterion("UserInfo.iosver <=", value, "iosver");
/* 2627:2194 */       return (Criteria)this;
/* 2628:     */     }
/* 2629:     */     
/* 2630:     */     public Criteria andIosverLike(String value)
/* 2631:     */     {
/* 2632:2198 */       addCriterion("UserInfo.iosver like", value, "iosver");
/* 2633:2199 */       return (Criteria)this;
/* 2634:     */     }
/* 2635:     */     
/* 2636:     */     public Criteria andIosverNotLike(String value)
/* 2637:     */     {
/* 2638:2203 */       addCriterion("UserInfo.iosver not like", value, "iosver");
/* 2639:2204 */       return (Criteria)this;
/* 2640:     */     }
/* 2641:     */     
/* 2642:     */     public Criteria andIosverIn(List<String> values)
/* 2643:     */     {
/* 2644:2208 */       addCriterion("UserInfo.iosver in", values, "iosver");
/* 2645:2209 */       return (Criteria)this;
/* 2646:     */     }
/* 2647:     */     
/* 2648:     */     public Criteria andIosverNotIn(List<String> values)
/* 2649:     */     {
/* 2650:2213 */       addCriterion("UserInfo.iosver not in", values, "iosver");
/* 2651:2214 */       return (Criteria)this;
/* 2652:     */     }
/* 2653:     */     
/* 2654:     */     public Criteria andIosverBetween(String value1, String value2)
/* 2655:     */     {
/* 2656:2218 */       addCriterion("UserInfo.iosver between", value1, value2, "iosver");
/* 2657:2219 */       return (Criteria)this;
/* 2658:     */     }
/* 2659:     */     
/* 2660:     */     public Criteria andIosverNotBetween(String value1, String value2)
/* 2661:     */     {
/* 2662:2223 */       addCriterion("UserInfo.iosver not between", value1, value2, "iosver");
/* 2663:2224 */       return (Criteria)this;
/* 2664:     */     }
/* 2665:     */     
/* 2666:     */     public Criteria andPlatIsNull()
/* 2667:     */     {
/* 2668:2228 */       addCriterion("UserInfo.plat is null");
/* 2669:2229 */       return (Criteria)this;
/* 2670:     */     }
/* 2671:     */     
/* 2672:     */     public Criteria andPlatIsNotNull()
/* 2673:     */     {
/* 2674:2233 */       addCriterion("UserInfo.plat is not null");
/* 2675:2234 */       return (Criteria)this;
/* 2676:     */     }
/* 2677:     */     
/* 2678:     */     public Criteria andPlatEqualTo(String value)
/* 2679:     */     {
/* 2680:2238 */       addCriterion("UserInfo.plat =", value, "plat");
/* 2681:2239 */       return (Criteria)this;
/* 2682:     */     }
/* 2683:     */     
/* 2684:     */     public Criteria andPlatNotEqualTo(String value)
/* 2685:     */     {
/* 2686:2243 */       addCriterion("UserInfo.plat <>", value, "plat");
/* 2687:2244 */       return (Criteria)this;
/* 2688:     */     }
/* 2689:     */     
/* 2690:     */     public Criteria andPlatGreaterThan(String value)
/* 2691:     */     {
/* 2692:2248 */       addCriterion("UserInfo.plat >", value, "plat");
/* 2693:2249 */       return (Criteria)this;
/* 2694:     */     }
/* 2695:     */     
/* 2696:     */     public Criteria andPlatGreaterThanOrEqualTo(String value)
/* 2697:     */     {
/* 2698:2253 */       addCriterion("UserInfo.plat >=", value, "plat");
/* 2699:2254 */       return (Criteria)this;
/* 2700:     */     }
/* 2701:     */     
/* 2702:     */     public Criteria andPlatLessThan(String value)
/* 2703:     */     {
/* 2704:2258 */       addCriterion("UserInfo.plat <", value, "plat");
/* 2705:2259 */       return (Criteria)this;
/* 2706:     */     }
/* 2707:     */     
/* 2708:     */     public Criteria andPlatLessThanOrEqualTo(String value)
/* 2709:     */     {
/* 2710:2263 */       addCriterion("UserInfo.plat <=", value, "plat");
/* 2711:2264 */       return (Criteria)this;
/* 2712:     */     }
/* 2713:     */     
/* 2714:     */     public Criteria andPlatLike(String value)
/* 2715:     */     {
/* 2716:2268 */       addCriterion("UserInfo.plat like", value, "plat");
/* 2717:2269 */       return (Criteria)this;
/* 2718:     */     }
/* 2719:     */     
/* 2720:     */     public Criteria andPlatNotLike(String value)
/* 2721:     */     {
/* 2722:2273 */       addCriterion("UserInfo.plat not like", value, "plat");
/* 2723:2274 */       return (Criteria)this;
/* 2724:     */     }
/* 2725:     */     
/* 2726:     */     public Criteria andPlatIn(List<String> values)
/* 2727:     */     {
/* 2728:2278 */       addCriterion("UserInfo.plat in", values, "plat");
/* 2729:2279 */       return (Criteria)this;
/* 2730:     */     }
/* 2731:     */     
/* 2732:     */     public Criteria andPlatNotIn(List<String> values)
/* 2733:     */     {
/* 2734:2283 */       addCriterion("UserInfo.plat not in", values, "plat");
/* 2735:2284 */       return (Criteria)this;
/* 2736:     */     }
/* 2737:     */     
/* 2738:     */     public Criteria andPlatBetween(String value1, String value2)
/* 2739:     */     {
/* 2740:2288 */       addCriterion("UserInfo.plat between", value1, value2, "plat");
/* 2741:2289 */       return (Criteria)this;
/* 2742:     */     }
/* 2743:     */     
/* 2744:     */     public Criteria andPlatNotBetween(String value1, String value2)
/* 2745:     */     {
/* 2746:2293 */       addCriterion("UserInfo.plat not between", value1, value2, "plat");
/* 2747:2294 */       return (Criteria)this;
/* 2748:     */     }
/* 2749:     */     
/* 2750:     */     public Criteria andScoreIsNull()
/* 2751:     */     {
/* 2752:2298 */       addCriterion("UserInfo.score is null");
/* 2753:2299 */       return (Criteria)this;
/* 2754:     */     }
/* 2755:     */     
/* 2756:     */     public Criteria andScoreIsNotNull()
/* 2757:     */     {
/* 2758:2303 */       addCriterion("UserInfo.score is not null");
/* 2759:2304 */       return (Criteria)this;
/* 2760:     */     }
/* 2761:     */     
/* 2762:     */     public Criteria andScoreEqualTo(String value)
/* 2763:     */     {
/* 2764:2308 */       addCriterion("UserInfo.score =", value, "score");
/* 2765:2309 */       return (Criteria)this;
/* 2766:     */     }
/* 2767:     */     
/* 2768:     */     public Criteria andScoreNotEqualTo(String value)
/* 2769:     */     {
/* 2770:2313 */       addCriterion("UserInfo.score <>", value, "score");
/* 2771:2314 */       return (Criteria)this;
/* 2772:     */     }
/* 2773:     */     
/* 2774:     */     public Criteria andScoreGreaterThan(String value)
/* 2775:     */     {
/* 2776:2318 */       addCriterion("UserInfo.score >", value, "score");
/* 2777:2319 */       return (Criteria)this;
/* 2778:     */     }
/* 2779:     */     
/* 2780:     */     public Criteria andScoreGreaterThanOrEqualTo(String value)
/* 2781:     */     {
/* 2782:2323 */       addCriterion("UserInfo.score >=", value, "score");
/* 2783:2324 */       return (Criteria)this;
/* 2784:     */     }
/* 2785:     */     
/* 2786:     */     public Criteria andScoreLessThan(String value)
/* 2787:     */     {
/* 2788:2328 */       addCriterion("UserInfo.score <", value, "score");
/* 2789:2329 */       return (Criteria)this;
/* 2790:     */     }
/* 2791:     */     
/* 2792:     */     public Criteria andScoreLessThanOrEqualTo(String value)
/* 2793:     */     {
/* 2794:2333 */       addCriterion("UserInfo.score <=", value, "score");
/* 2795:2334 */       return (Criteria)this;
/* 2796:     */     }
/* 2797:     */     
/* 2798:     */     public Criteria andScoreLike(String value)
/* 2799:     */     {
/* 2800:2338 */       addCriterion("UserInfo.score like", value, "score");
/* 2801:2339 */       return (Criteria)this;
/* 2802:     */     }
/* 2803:     */     
/* 2804:     */     public Criteria andScoreNotLike(String value)
/* 2805:     */     {
/* 2806:2343 */       addCriterion("UserInfo.score not like", value, "score");
/* 2807:2344 */       return (Criteria)this;
/* 2808:     */     }
/* 2809:     */     
/* 2810:     */     public Criteria andScoreIn(List<String> values)
/* 2811:     */     {
/* 2812:2348 */       addCriterion("UserInfo.score in", values, "score");
/* 2813:2349 */       return (Criteria)this;
/* 2814:     */     }
/* 2815:     */     
/* 2816:     */     public Criteria andScoreNotIn(List<String> values)
/* 2817:     */     {
/* 2818:2353 */       addCriterion("UserInfo.score not in", values, "score");
/* 2819:2354 */       return (Criteria)this;
/* 2820:     */     }
/* 2821:     */     
/* 2822:     */     public Criteria andScoreBetween(String value1, String value2)
/* 2823:     */     {
/* 2824:2358 */       addCriterion("UserInfo.score between", value1, value2, "score");
/* 2825:2359 */       return (Criteria)this;
/* 2826:     */     }
/* 2827:     */     
/* 2828:     */     public Criteria andScoreNotBetween(String value1, String value2)
/* 2829:     */     {
/* 2830:2363 */       addCriterion("UserInfo.score not between", value1, value2, "score");
/* 2831:2364 */       return (Criteria)this;
/* 2832:     */     }
/* 2833:     */     
/* 2834:     */     public Criteria andSumdaysIsNull()
/* 2835:     */     {
/* 2836:2368 */       addCriterion("UserInfo.sumdays is null");
/* 2837:2369 */       return (Criteria)this;
/* 2838:     */     }
/* 2839:     */     
/* 2840:     */     public Criteria andSumdaysIsNotNull()
/* 2841:     */     {
/* 2842:2373 */       addCriterion("UserInfo.sumdays is not null");
/* 2843:2374 */       return (Criteria)this;
/* 2844:     */     }
/* 2845:     */     
/* 2846:     */     public Criteria andSumdaysEqualTo(String value)
/* 2847:     */     {
/* 2848:2378 */       addCriterion("UserInfo.sumdays =", value, "sumdays");
/* 2849:2379 */       return (Criteria)this;
/* 2850:     */     }
/* 2851:     */     
/* 2852:     */     public Criteria andSumdaysNotEqualTo(String value)
/* 2853:     */     {
/* 2854:2383 */       addCriterion("UserInfo.sumdays <>", value, "sumdays");
/* 2855:2384 */       return (Criteria)this;
/* 2856:     */     }
/* 2857:     */     
/* 2858:     */     public Criteria andSumdaysGreaterThan(String value)
/* 2859:     */     {
/* 2860:2388 */       addCriterion("UserInfo.sumdays >", value, "sumdays");
/* 2861:2389 */       return (Criteria)this;
/* 2862:     */     }
/* 2863:     */     
/* 2864:     */     public Criteria andSumdaysGreaterThanOrEqualTo(String value)
/* 2865:     */     {
/* 2866:2393 */       addCriterion("UserInfo.sumdays >=", value, "sumdays");
/* 2867:2394 */       return (Criteria)this;
/* 2868:     */     }
/* 2869:     */     
/* 2870:     */     public Criteria andSumdaysLessThan(String value)
/* 2871:     */     {
/* 2872:2398 */       addCriterion("UserInfo.sumdays <", value, "sumdays");
/* 2873:2399 */       return (Criteria)this;
/* 2874:     */     }
/* 2875:     */     
/* 2876:     */     public Criteria andSumdaysLessThanOrEqualTo(String value)
/* 2877:     */     {
/* 2878:2403 */       addCriterion("UserInfo.sumdays <=", value, "sumdays");
/* 2879:2404 */       return (Criteria)this;
/* 2880:     */     }
/* 2881:     */     
/* 2882:     */     public Criteria andSumdaysLike(String value)
/* 2883:     */     {
/* 2884:2408 */       addCriterion("UserInfo.sumdays like", value, "sumdays");
/* 2885:2409 */       return (Criteria)this;
/* 2886:     */     }
/* 2887:     */     
/* 2888:     */     public Criteria andSumdaysNotLike(String value)
/* 2889:     */     {
/* 2890:2413 */       addCriterion("UserInfo.sumdays not like", value, "sumdays");
/* 2891:2414 */       return (Criteria)this;
/* 2892:     */     }
/* 2893:     */     
/* 2894:     */     public Criteria andSumdaysIn(List<String> values)
/* 2895:     */     {
/* 2896:2418 */       addCriterion("UserInfo.sumdays in", values, "sumdays");
/* 2897:2419 */       return (Criteria)this;
/* 2898:     */     }
/* 2899:     */     
/* 2900:     */     public Criteria andSumdaysNotIn(List<String> values)
/* 2901:     */     {
/* 2902:2423 */       addCriterion("UserInfo.sumdays not in", values, "sumdays");
/* 2903:2424 */       return (Criteria)this;
/* 2904:     */     }
/* 2905:     */     
/* 2906:     */     public Criteria andSumdaysBetween(String value1, String value2)
/* 2907:     */     {
/* 2908:2428 */       addCriterion("UserInfo.sumdays between", value1, value2, "sumdays");
/* 2909:2429 */       return (Criteria)this;
/* 2910:     */     }
/* 2911:     */     
/* 2912:     */     public Criteria andSumdaysNotBetween(String value1, String value2)
/* 2913:     */     {
/* 2914:2433 */       addCriterion("UserInfo.sumdays not between", value1, value2, "sumdays");
/* 2915:2434 */       return (Criteria)this;
/* 2916:     */     }
/* 2917:     */     
/* 2918:     */     public Criteria andSharenumIsNull()
/* 2919:     */     {
/* 2920:2438 */       addCriterion("UserInfo.sharenum is null");
/* 2921:2439 */       return (Criteria)this;
/* 2922:     */     }
/* 2923:     */     
/* 2924:     */     public Criteria andSharenumIsNotNull()
/* 2925:     */     {
/* 2926:2443 */       addCriterion("UserInfo.sharenum is not null");
/* 2927:2444 */       return (Criteria)this;
/* 2928:     */     }
/* 2929:     */     
/* 2930:     */     public Criteria andSharenumEqualTo(String value)
/* 2931:     */     {
/* 2932:2448 */       addCriterion("UserInfo.sharenum =", value, "sharenum");
/* 2933:2449 */       return (Criteria)this;
/* 2934:     */     }
/* 2935:     */     
/* 2936:     */     public Criteria andSharenumNotEqualTo(String value)
/* 2937:     */     {
/* 2938:2453 */       addCriterion("UserInfo.sharenum <>", value, "sharenum");
/* 2939:2454 */       return (Criteria)this;
/* 2940:     */     }
/* 2941:     */     
/* 2942:     */     public Criteria andSharenumGreaterThan(String value)
/* 2943:     */     {
/* 2944:2458 */       addCriterion("UserInfo.sharenum >", value, "sharenum");
/* 2945:2459 */       return (Criteria)this;
/* 2946:     */     }
/* 2947:     */     
/* 2948:     */     public Criteria andSharenumGreaterThanOrEqualTo(String value)
/* 2949:     */     {
/* 2950:2463 */       addCriterion("UserInfo.sharenum >=", value, "sharenum");
/* 2951:2464 */       return (Criteria)this;
/* 2952:     */     }
/* 2953:     */     
/* 2954:     */     public Criteria andSharenumLessThan(String value)
/* 2955:     */     {
/* 2956:2468 */       addCriterion("UserInfo.sharenum <", value, "sharenum");
/* 2957:2469 */       return (Criteria)this;
/* 2958:     */     }
/* 2959:     */     
/* 2960:     */     public Criteria andSharenumLessThanOrEqualTo(String value)
/* 2961:     */     {
/* 2962:2473 */       addCriterion("UserInfo.sharenum <=", value, "sharenum");
/* 2963:2474 */       return (Criteria)this;
/* 2964:     */     }
/* 2965:     */     
/* 2966:     */     public Criteria andSharenumLike(String value)
/* 2967:     */     {
/* 2968:2478 */       addCriterion("UserInfo.sharenum like", value, "sharenum");
/* 2969:2479 */       return (Criteria)this;
/* 2970:     */     }
/* 2971:     */     
/* 2972:     */     public Criteria andSharenumNotLike(String value)
/* 2973:     */     {
/* 2974:2483 */       addCriterion("UserInfo.sharenum not like", value, "sharenum");
/* 2975:2484 */       return (Criteria)this;
/* 2976:     */     }
/* 2977:     */     
/* 2978:     */     public Criteria andSharenumIn(List<String> values)
/* 2979:     */     {
/* 2980:2488 */       addCriterion("UserInfo.sharenum in", values, "sharenum");
/* 2981:2489 */       return (Criteria)this;
/* 2982:     */     }
/* 2983:     */     
/* 2984:     */     public Criteria andSharenumNotIn(List<String> values)
/* 2985:     */     {
/* 2986:2493 */       addCriterion("UserInfo.sharenum not in", values, "sharenum");
/* 2987:2494 */       return (Criteria)this;
/* 2988:     */     }
/* 2989:     */     
/* 2990:     */     public Criteria andSharenumBetween(String value1, String value2)
/* 2991:     */     {
/* 2992:2498 */       addCriterion("UserInfo.sharenum between", value1, value2, "sharenum");
/* 2993:2499 */       return (Criteria)this;
/* 2994:     */     }
/* 2995:     */     
/* 2996:     */     public Criteria andSharenumNotBetween(String value1, String value2)
/* 2997:     */     {
/* 2998:2503 */       addCriterion("UserInfo.sharenum not between", value1, value2, "sharenum");
/* 2999:2504 */       return (Criteria)this;
/* 3000:     */     }
/* 3001:     */     
/* 3002:     */     public Criteria andSharetimeIsNull()
/* 3003:     */     {
/* 3004:2508 */       addCriterion("UserInfo.sharetime is null");
/* 3005:2509 */       return (Criteria)this;
/* 3006:     */     }
/* 3007:     */     
/* 3008:     */     public Criteria andSharetimeIsNotNull()
/* 3009:     */     {
/* 3010:2513 */       addCriterion("UserInfo.sharetime is not null");
/* 3011:2514 */       return (Criteria)this;
/* 3012:     */     }
/* 3013:     */     
/* 3014:     */     public Criteria andSharetimeEqualTo(String value)
/* 3015:     */     {
/* 3016:2518 */       addCriterion("UserInfo.sharetime =", value, "sharetime");
/* 3017:2519 */       return (Criteria)this;
/* 3018:     */     }
/* 3019:     */     
/* 3020:     */     public Criteria andSharetimeNotEqualTo(String value)
/* 3021:     */     {
/* 3022:2523 */       addCriterion("UserInfo.sharetime <>", value, "sharetime");
/* 3023:2524 */       return (Criteria)this;
/* 3024:     */     }
/* 3025:     */     
/* 3026:     */     public Criteria andSharetimeGreaterThan(String value)
/* 3027:     */     {
/* 3028:2528 */       addCriterion("UserInfo.sharetime >", value, "sharetime");
/* 3029:2529 */       return (Criteria)this;
/* 3030:     */     }
/* 3031:     */     
/* 3032:     */     public Criteria andSharetimeGreaterThanOrEqualTo(String value)
/* 3033:     */     {
/* 3034:2533 */       addCriterion("UserInfo.sharetime >=", value, "sharetime");
/* 3035:2534 */       return (Criteria)this;
/* 3036:     */     }
/* 3037:     */     
/* 3038:     */     public Criteria andSharetimeLessThan(String value)
/* 3039:     */     {
/* 3040:2538 */       addCriterion("UserInfo.sharetime <", value, "sharetime");
/* 3041:2539 */       return (Criteria)this;
/* 3042:     */     }
/* 3043:     */     
/* 3044:     */     public Criteria andSharetimeLessThanOrEqualTo(String value)
/* 3045:     */     {
/* 3046:2543 */       addCriterion("UserInfo.sharetime <=", value, "sharetime");
/* 3047:2544 */       return (Criteria)this;
/* 3048:     */     }
/* 3049:     */     
/* 3050:     */     public Criteria andSharetimeLike(String value)
/* 3051:     */     {
/* 3052:2548 */       addCriterion("UserInfo.sharetime like", value, "sharetime");
/* 3053:2549 */       return (Criteria)this;
/* 3054:     */     }
/* 3055:     */     
/* 3056:     */     public Criteria andSharetimeNotLike(String value)
/* 3057:     */     {
/* 3058:2553 */       addCriterion("UserInfo.sharetime not like", value, "sharetime");
/* 3059:2554 */       return (Criteria)this;
/* 3060:     */     }
/* 3061:     */     
/* 3062:     */     public Criteria andSharetimeIn(List<String> values)
/* 3063:     */     {
/* 3064:2558 */       addCriterion("UserInfo.sharetime in", values, "sharetime");
/* 3065:2559 */       return (Criteria)this;
/* 3066:     */     }
/* 3067:     */     
/* 3068:     */     public Criteria andSharetimeNotIn(List<String> values)
/* 3069:     */     {
/* 3070:2563 */       addCriterion("UserInfo.sharetime not in", values, "sharetime");
/* 3071:2564 */       return (Criteria)this;
/* 3072:     */     }
/* 3073:     */     
/* 3074:     */     public Criteria andSharetimeBetween(String value1, String value2)
/* 3075:     */     {
/* 3076:2568 */       addCriterion("UserInfo.sharetime between", value1, value2, "sharetime");
/* 3077:2569 */       return (Criteria)this;
/* 3078:     */     }
/* 3079:     */     
/* 3080:     */     public Criteria andSharetimeNotBetween(String value1, String value2)
/* 3081:     */     {
/* 3082:2573 */       addCriterion("UserInfo.sharetime not between", value1, value2, "sharetime");
/* 3083:2574 */       return (Criteria)this;
/* 3084:     */     }
/* 3085:     */     
/* 3086:     */     public Criteria andGrouptimeIsNull()
/* 3087:     */     {
/* 3088:2578 */       addCriterion("UserInfo.grouptime is null");
/* 3089:2579 */       return (Criteria)this;
/* 3090:     */     }
/* 3091:     */     
/* 3092:     */     public Criteria andGrouptimeIsNotNull()
/* 3093:     */     {
/* 3094:2583 */       addCriterion("UserInfo.grouptime is not null");
/* 3095:2584 */       return (Criteria)this;
/* 3096:     */     }
/* 3097:     */     
/* 3098:     */     public Criteria andGrouptimeEqualTo(String value)
/* 3099:     */     {
/* 3100:2588 */       addCriterion("UserInfo.grouptime =", value, "grouptime");
/* 3101:2589 */       return (Criteria)this;
/* 3102:     */     }
/* 3103:     */     
/* 3104:     */     public Criteria andGrouptimeNotEqualTo(String value)
/* 3105:     */     {
/* 3106:2593 */       addCriterion("UserInfo.grouptime <>", value, "grouptime");
/* 3107:2594 */       return (Criteria)this;
/* 3108:     */     }
/* 3109:     */     
/* 3110:     */     public Criteria andGrouptimeGreaterThan(String value)
/* 3111:     */     {
/* 3112:2598 */       addCriterion("UserInfo.grouptime >", value, "grouptime");
/* 3113:2599 */       return (Criteria)this;
/* 3114:     */     }
/* 3115:     */     
/* 3116:     */     public Criteria andGrouptimeGreaterThanOrEqualTo(String value)
/* 3117:     */     {
/* 3118:2603 */       addCriterion("UserInfo.grouptime >=", value, "grouptime");
/* 3119:2604 */       return (Criteria)this;
/* 3120:     */     }
/* 3121:     */     
/* 3122:     */     public Criteria andGrouptimeLessThan(String value)
/* 3123:     */     {
/* 3124:2608 */       addCriterion("UserInfo.grouptime <", value, "grouptime");
/* 3125:2609 */       return (Criteria)this;
/* 3126:     */     }
/* 3127:     */     
/* 3128:     */     public Criteria andGrouptimeLessThanOrEqualTo(String value)
/* 3129:     */     {
/* 3130:2613 */       addCriterion("UserInfo.grouptime <=", value, "grouptime");
/* 3131:2614 */       return (Criteria)this;
/* 3132:     */     }
/* 3133:     */     
/* 3134:     */     public Criteria andGrouptimeLike(String value)
/* 3135:     */     {
/* 3136:2618 */       addCriterion("UserInfo.grouptime like", value, "grouptime");
/* 3137:2619 */       return (Criteria)this;
/* 3138:     */     }
/* 3139:     */     
/* 3140:     */     public Criteria andGrouptimeNotLike(String value)
/* 3141:     */     {
/* 3142:2623 */       addCriterion("UserInfo.grouptime not like", value, "grouptime");
/* 3143:2624 */       return (Criteria)this;
/* 3144:     */     }
/* 3145:     */     
/* 3146:     */     public Criteria andGrouptimeIn(List<String> values)
/* 3147:     */     {
/* 3148:2628 */       addCriterion("UserInfo.grouptime in", values, "grouptime");
/* 3149:2629 */       return (Criteria)this;
/* 3150:     */     }
/* 3151:     */     
/* 3152:     */     public Criteria andGrouptimeNotIn(List<String> values)
/* 3153:     */     {
/* 3154:2633 */       addCriterion("UserInfo.grouptime not in", values, "grouptime");
/* 3155:2634 */       return (Criteria)this;
/* 3156:     */     }
/* 3157:     */     
/* 3158:     */     public Criteria andGrouptimeBetween(String value1, String value2)
/* 3159:     */     {
/* 3160:2638 */       addCriterion("UserInfo.grouptime between", value1, value2, "grouptime");
/* 3161:2639 */       return (Criteria)this;
/* 3162:     */     }
/* 3163:     */     
/* 3164:     */     public Criteria andGrouptimeNotBetween(String value1, String value2)
/* 3165:     */     {
/* 3166:2643 */       addCriterion("UserInfo.grouptime not between", value1, value2, "grouptime");
/* 3167:2644 */       return (Criteria)this;
/* 3168:     */     }
/* 3169:     */     
/* 3170:     */     public Criteria andAuthenticationstatusIsNull()
/* 3171:     */     {
/* 3172:2648 */       addCriterion("UserInfo.authenticationStatus is null");
/* 3173:2649 */       return (Criteria)this;
/* 3174:     */     }
/* 3175:     */     
/* 3176:     */     public Criteria andAuthenticationstatusIsNotNull()
/* 3177:     */     {
/* 3178:2653 */       addCriterion("UserInfo.authenticationStatus is not null");
/* 3179:2654 */       return (Criteria)this;
/* 3180:     */     }
/* 3181:     */     
/* 3182:     */     public Criteria andAuthenticationstatusEqualTo(String value)
/* 3183:     */     {
/* 3184:2658 */       addCriterion("UserInfo.authenticationStatus =", value, "authenticationstatus");
/* 3185:2659 */       return (Criteria)this;
/* 3186:     */     }
/* 3187:     */     
/* 3188:     */     public Criteria andAuthenticationstatusNotEqualTo(String value)
/* 3189:     */     {
/* 3190:2663 */       addCriterion("UserInfo.authenticationStatus <>", value, "authenticationstatus");
/* 3191:2664 */       return (Criteria)this;
/* 3192:     */     }
/* 3193:     */     
/* 3194:     */     public Criteria andAuthenticationstatusGreaterThan(String value)
/* 3195:     */     {
/* 3196:2668 */       addCriterion("UserInfo.authenticationStatus >", value, "authenticationstatus");
/* 3197:2669 */       return (Criteria)this;
/* 3198:     */     }
/* 3199:     */     
/* 3200:     */     public Criteria andAuthenticationstatusGreaterThanOrEqualTo(String value)
/* 3201:     */     {
/* 3202:2673 */       addCriterion("UserInfo.authenticationStatus >=", value, "authenticationstatus");
/* 3203:2674 */       return (Criteria)this;
/* 3204:     */     }
/* 3205:     */     
/* 3206:     */     public Criteria andAuthenticationstatusLessThan(String value)
/* 3207:     */     {
/* 3208:2678 */       addCriterion("UserInfo.authenticationStatus <", value, "authenticationstatus");
/* 3209:2679 */       return (Criteria)this;
/* 3210:     */     }
/* 3211:     */     
/* 3212:     */     public Criteria andAuthenticationstatusLessThanOrEqualTo(String value)
/* 3213:     */     {
/* 3214:2683 */       addCriterion("UserInfo.authenticationStatus <=", value, "authenticationstatus");
/* 3215:2684 */       return (Criteria)this;
/* 3216:     */     }
/* 3217:     */     
/* 3218:     */     public Criteria andAuthenticationstatusLike(String value)
/* 3219:     */     {
/* 3220:2688 */       addCriterion("UserInfo.authenticationStatus like", value, "authenticationstatus");
/* 3221:2689 */       return (Criteria)this;
/* 3222:     */     }
/* 3223:     */     
/* 3224:     */     public Criteria andAuthenticationstatusNotLike(String value)
/* 3225:     */     {
/* 3226:2693 */       addCriterion("UserInfo.authenticationStatus not like", value, "authenticationstatus");
/* 3227:2694 */       return (Criteria)this;
/* 3228:     */     }
/* 3229:     */     
/* 3230:     */     public Criteria andAuthenticationstatusIn(List<String> values)
/* 3231:     */     {
/* 3232:2698 */       addCriterion("UserInfo.authenticationStatus in", values, "authenticationstatus");
/* 3233:2699 */       return (Criteria)this;
/* 3234:     */     }
/* 3235:     */     
/* 3236:     */     public Criteria andAuthenticationstatusNotIn(List<String> values)
/* 3237:     */     {
/* 3238:2703 */       addCriterion("UserInfo.authenticationStatus not in", values, "authenticationstatus");
/* 3239:2704 */       return (Criteria)this;
/* 3240:     */     }
/* 3241:     */     
/* 3242:     */     public Criteria andAuthenticationstatusBetween(String value1, String value2)
/* 3243:     */     {
/* 3244:2708 */       addCriterion("UserInfo.authenticationStatus between", value1, value2, "authenticationstatus");
/* 3245:2709 */       return (Criteria)this;
/* 3246:     */     }
/* 3247:     */     
/* 3248:     */     public Criteria andAuthenticationstatusNotBetween(String value1, String value2)
/* 3249:     */     {
/* 3250:2713 */       addCriterion("UserInfo.authenticationStatus not between", value1, value2, "authenticationstatus");
/* 3251:2714 */       return (Criteria)this;
/* 3252:     */     }
/* 3253:     */     
/* 3254:     */     public Criteria andUseridentityIsNull()
/* 3255:     */     {
/* 3256:2718 */       addCriterion("UserInfo.useridentity is null");
/* 3257:2719 */       return (Criteria)this;
/* 3258:     */     }
/* 3259:     */     
/* 3260:     */     public Criteria andUseridentityIsNotNull()
/* 3261:     */     {
/* 3262:2723 */       addCriterion("UserInfo.useridentity is not null");
/* 3263:2724 */       return (Criteria)this;
/* 3264:     */     }
/* 3265:     */     
/* 3266:     */     public Criteria andUseridentityEqualTo(String value)
/* 3267:     */     {
/* 3268:2728 */       addCriterion("UserInfo.useridentity =", value, "useridentity");
/* 3269:2729 */       return (Criteria)this;
/* 3270:     */     }
/* 3271:     */     
/* 3272:     */     public Criteria andUseridentityNotEqualTo(String value)
/* 3273:     */     {
/* 3274:2733 */       addCriterion("UserInfo.useridentity <>", value, "useridentity");
/* 3275:2734 */       return (Criteria)this;
/* 3276:     */     }
/* 3277:     */     
/* 3278:     */     public Criteria andUseridentityGreaterThan(String value)
/* 3279:     */     {
/* 3280:2738 */       addCriterion("UserInfo.useridentity >", value, "useridentity");
/* 3281:2739 */       return (Criteria)this;
/* 3282:     */     }
/* 3283:     */     
/* 3284:     */     public Criteria andUseridentityGreaterThanOrEqualTo(String value)
/* 3285:     */     {
/* 3286:2743 */       addCriterion("UserInfo.useridentity >=", value, "useridentity");
/* 3287:2744 */       return (Criteria)this;
/* 3288:     */     }
/* 3289:     */     
/* 3290:     */     public Criteria andUseridentityLessThan(String value)
/* 3291:     */     {
/* 3292:2748 */       addCriterion("UserInfo.useridentity <", value, "useridentity");
/* 3293:2749 */       return (Criteria)this;
/* 3294:     */     }
/* 3295:     */     
/* 3296:     */     public Criteria andUseridentityLessThanOrEqualTo(String value)
/* 3297:     */     {
/* 3298:2753 */       addCriterion("UserInfo.useridentity <=", value, "useridentity");
/* 3299:2754 */       return (Criteria)this;
/* 3300:     */     }
/* 3301:     */     
/* 3302:     */     public Criteria andUseridentityLike(String value)
/* 3303:     */     {
/* 3304:2758 */       addCriterion("UserInfo.useridentity like", value, "useridentity");
/* 3305:2759 */       return (Criteria)this;
/* 3306:     */     }
/* 3307:     */     
/* 3308:     */     public Criteria andUseridentityNotLike(String value)
/* 3309:     */     {
/* 3310:2763 */       addCriterion("UserInfo.useridentity not like", value, "useridentity");
/* 3311:2764 */       return (Criteria)this;
/* 3312:     */     }
/* 3313:     */     
/* 3314:     */     public Criteria andUseridentityIn(List<String> values)
/* 3315:     */     {
/* 3316:2768 */       addCriterion("UserInfo.useridentity in", values, "useridentity");
/* 3317:2769 */       return (Criteria)this;
/* 3318:     */     }
/* 3319:     */     
/* 3320:     */     public Criteria andUseridentityNotIn(List<String> values)
/* 3321:     */     {
/* 3322:2773 */       addCriterion("UserInfo.useridentity not in", values, "useridentity");
/* 3323:2774 */       return (Criteria)this;
/* 3324:     */     }
/* 3325:     */     
/* 3326:     */     public Criteria andUseridentityBetween(String value1, String value2)
/* 3327:     */     {
/* 3328:2778 */       addCriterion("UserInfo.useridentity between", value1, value2, "useridentity");
/* 3329:2779 */       return (Criteria)this;
/* 3330:     */     }
/* 3331:     */     
/* 3332:     */     public Criteria andUseridentityNotBetween(String value1, String value2)
/* 3333:     */     {
/* 3334:2783 */       addCriterion("UserInfo.useridentity not between", value1, value2, "useridentity");
/* 3335:2784 */       return (Criteria)this;
/* 3336:     */     }
/* 3337:     */     
/* 3338:     */     public Criteria andTotalsharetimesIsNull()
/* 3339:     */     {
/* 3340:2788 */       addCriterion("UserInfo.totalSharetimes is null");
/* 3341:2789 */       return (Criteria)this;
/* 3342:     */     }
/* 3343:     */     
/* 3344:     */     public Criteria andTotalsharetimesIsNotNull()
/* 3345:     */     {
/* 3346:2793 */       addCriterion("UserInfo.totalSharetimes is not null");
/* 3347:2794 */       return (Criteria)this;
/* 3348:     */     }
/* 3349:     */     
/* 3350:     */     public Criteria andTotalsharetimesEqualTo(String value)
/* 3351:     */     {
/* 3352:2798 */       addCriterion("UserInfo.totalSharetimes =", value, "totalsharetimes");
/* 3353:2799 */       return (Criteria)this;
/* 3354:     */     }
/* 3355:     */     
/* 3356:     */     public Criteria andTotalsharetimesNotEqualTo(String value)
/* 3357:     */     {
/* 3358:2803 */       addCriterion("UserInfo.totalSharetimes <>", value, "totalsharetimes");
/* 3359:2804 */       return (Criteria)this;
/* 3360:     */     }
/* 3361:     */     
/* 3362:     */     public Criteria andTotalsharetimesGreaterThan(String value)
/* 3363:     */     {
/* 3364:2808 */       addCriterion("UserInfo.totalSharetimes >", value, "totalsharetimes");
/* 3365:2809 */       return (Criteria)this;
/* 3366:     */     }
/* 3367:     */     
/* 3368:     */     public Criteria andTotalsharetimesGreaterThanOrEqualTo(String value)
/* 3369:     */     {
/* 3370:2813 */       addCriterion("UserInfo.totalSharetimes >=", value, "totalsharetimes");
/* 3371:2814 */       return (Criteria)this;
/* 3372:     */     }
/* 3373:     */     
/* 3374:     */     public Criteria andTotalsharetimesLessThan(String value)
/* 3375:     */     {
/* 3376:2818 */       addCriterion("UserInfo.totalSharetimes <", value, "totalsharetimes");
/* 3377:2819 */       return (Criteria)this;
/* 3378:     */     }
/* 3379:     */     
/* 3380:     */     public Criteria andTotalsharetimesLessThanOrEqualTo(String value)
/* 3381:     */     {
/* 3382:2823 */       addCriterion("UserInfo.totalSharetimes <=", value, "totalsharetimes");
/* 3383:2824 */       return (Criteria)this;
/* 3384:     */     }
/* 3385:     */     
/* 3386:     */     public Criteria andTotalsharetimesLike(String value)
/* 3387:     */     {
/* 3388:2828 */       addCriterion("UserInfo.totalSharetimes like", value, "totalsharetimes");
/* 3389:2829 */       return (Criteria)this;
/* 3390:     */     }
/* 3391:     */     
/* 3392:     */     public Criteria andTotalsharetimesNotLike(String value)
/* 3393:     */     {
/* 3394:2833 */       addCriterion("UserInfo.totalSharetimes not like", value, "totalsharetimes");
/* 3395:2834 */       return (Criteria)this;
/* 3396:     */     }
/* 3397:     */     
/* 3398:     */     public Criteria andTotalsharetimesIn(List<String> values)
/* 3399:     */     {
/* 3400:2838 */       addCriterion("UserInfo.totalSharetimes in", values, "totalsharetimes");
/* 3401:2839 */       return (Criteria)this;
/* 3402:     */     }
/* 3403:     */     
/* 3404:     */     public Criteria andTotalsharetimesNotIn(List<String> values)
/* 3405:     */     {
/* 3406:2843 */       addCriterion("UserInfo.totalSharetimes not in", values, "totalsharetimes");
/* 3407:2844 */       return (Criteria)this;
/* 3408:     */     }
/* 3409:     */     
/* 3410:     */     public Criteria andTotalsharetimesBetween(String value1, String value2)
/* 3411:     */     {
/* 3412:2848 */       addCriterion("UserInfo.totalSharetimes between", value1, value2, "totalsharetimes");
/* 3413:2849 */       return (Criteria)this;
/* 3414:     */     }
/* 3415:     */     
/* 3416:     */     public Criteria andTotalsharetimesNotBetween(String value1, String value2)
/* 3417:     */     {
/* 3418:2853 */       addCriterion("UserInfo.totalSharetimes not between", value1, value2, "totalsharetimes");
/* 3419:2854 */       return (Criteria)this;
/* 3420:     */     }
/* 3421:     */     
/* 3422:     */     public Criteria andSharetimesIsNull()
/* 3423:     */     {
/* 3424:2858 */       addCriterion("UserInfo.sharetimes is null");
/* 3425:2859 */       return (Criteria)this;
/* 3426:     */     }
/* 3427:     */     
/* 3428:     */     public Criteria andSharetimesIsNotNull()
/* 3429:     */     {
/* 3430:2863 */       addCriterion("UserInfo.sharetimes is not null");
/* 3431:2864 */       return (Criteria)this;
/* 3432:     */     }
/* 3433:     */     
/* 3434:     */     public Criteria andSharetimesEqualTo(String value)
/* 3435:     */     {
/* 3436:2868 */       addCriterion("UserInfo.sharetimes =", value, "sharetimes");
/* 3437:2869 */       return (Criteria)this;
/* 3438:     */     }
/* 3439:     */     
/* 3440:     */     public Criteria andSharetimesNotEqualTo(String value)
/* 3441:     */     {
/* 3442:2873 */       addCriterion("UserInfo.sharetimes <>", value, "sharetimes");
/* 3443:2874 */       return (Criteria)this;
/* 3444:     */     }
/* 3445:     */     
/* 3446:     */     public Criteria andSharetimesGreaterThan(String value)
/* 3447:     */     {
/* 3448:2878 */       addCriterion("UserInfo.sharetimes >", value, "sharetimes");
/* 3449:2879 */       return (Criteria)this;
/* 3450:     */     }
/* 3451:     */     
/* 3452:     */     public Criteria andSharetimesGreaterThanOrEqualTo(String value)
/* 3453:     */     {
/* 3454:2883 */       addCriterion("UserInfo.sharetimes >=", value, "sharetimes");
/* 3455:2884 */       return (Criteria)this;
/* 3456:     */     }
/* 3457:     */     
/* 3458:     */     public Criteria andSharetimesLessThan(String value)
/* 3459:     */     {
/* 3460:2888 */       addCriterion("UserInfo.sharetimes <", value, "sharetimes");
/* 3461:2889 */       return (Criteria)this;
/* 3462:     */     }
/* 3463:     */     
/* 3464:     */     public Criteria andSharetimesLessThanOrEqualTo(String value)
/* 3465:     */     {
/* 3466:2893 */       addCriterion("UserInfo.sharetimes <=", value, "sharetimes");
/* 3467:2894 */       return (Criteria)this;
/* 3468:     */     }
/* 3469:     */     
/* 3470:     */     public Criteria andSharetimesLike(String value)
/* 3471:     */     {
/* 3472:2898 */       addCriterion("UserInfo.sharetimes like", value, "sharetimes");
/* 3473:2899 */       return (Criteria)this;
/* 3474:     */     }
/* 3475:     */     
/* 3476:     */     public Criteria andSharetimesNotLike(String value)
/* 3477:     */     {
/* 3478:2903 */       addCriterion("UserInfo.sharetimes not like", value, "sharetimes");
/* 3479:2904 */       return (Criteria)this;
/* 3480:     */     }
/* 3481:     */     
/* 3482:     */     public Criteria andSharetimesIn(List<String> values)
/* 3483:     */     {
/* 3484:2908 */       addCriterion("UserInfo.sharetimes in", values, "sharetimes");
/* 3485:2909 */       return (Criteria)this;
/* 3486:     */     }
/* 3487:     */     
/* 3488:     */     public Criteria andSharetimesNotIn(List<String> values)
/* 3489:     */     {
/* 3490:2913 */       addCriterion("UserInfo.sharetimes not in", values, "sharetimes");
/* 3491:2914 */       return (Criteria)this;
/* 3492:     */     }
/* 3493:     */     
/* 3494:     */     public Criteria andSharetimesBetween(String value1, String value2)
/* 3495:     */     {
/* 3496:2918 */       addCriterion("UserInfo.sharetimes between", value1, value2, "sharetimes");
/* 3497:2919 */       return (Criteria)this;
/* 3498:     */     }
/* 3499:     */     
/* 3500:     */     public Criteria andSharetimesNotBetween(String value1, String value2)
/* 3501:     */     {
/* 3502:2923 */       addCriterion("UserInfo.sharetimes not between", value1, value2, "sharetimes");
/* 3503:2924 */       return (Criteria)this;
/* 3504:     */     }
/* 3505:     */     
/* 3506:     */     public Criteria andLastsharetimeIsNull()
/* 3507:     */     {
/* 3508:2928 */       addCriterion("UserInfo.lastSharetime is null");
/* 3509:2929 */       return (Criteria)this;
/* 3510:     */     }
/* 3511:     */     
/* 3512:     */     public Criteria andLastsharetimeIsNotNull()
/* 3513:     */     {
/* 3514:2933 */       addCriterion("UserInfo.lastSharetime is not null");
/* 3515:2934 */       return (Criteria)this;
/* 3516:     */     }
/* 3517:     */     
/* 3518:     */     public Criteria andLastsharetimeEqualTo(String value)
/* 3519:     */     {
/* 3520:2938 */       addCriterion("UserInfo.lastSharetime =", value, "lastsharetime");
/* 3521:2939 */       return (Criteria)this;
/* 3522:     */     }
/* 3523:     */     
/* 3524:     */     public Criteria andLastsharetimeNotEqualTo(String value)
/* 3525:     */     {
/* 3526:2943 */       addCriterion("UserInfo.lastSharetime <>", value, "lastsharetime");
/* 3527:2944 */       return (Criteria)this;
/* 3528:     */     }
/* 3529:     */     
/* 3530:     */     public Criteria andLastsharetimeGreaterThan(String value)
/* 3531:     */     {
/* 3532:2948 */       addCriterion("UserInfo.lastSharetime >", value, "lastsharetime");
/* 3533:2949 */       return (Criteria)this;
/* 3534:     */     }
/* 3535:     */     
/* 3536:     */     public Criteria andLastsharetimeGreaterThanOrEqualTo(String value)
/* 3537:     */     {
/* 3538:2953 */       addCriterion("UserInfo.lastSharetime >=", value, "lastsharetime");
/* 3539:2954 */       return (Criteria)this;
/* 3540:     */     }
/* 3541:     */     
/* 3542:     */     public Criteria andLastsharetimeLessThan(String value)
/* 3543:     */     {
/* 3544:2958 */       addCriterion("UserInfo.lastSharetime <", value, "lastsharetime");
/* 3545:2959 */       return (Criteria)this;
/* 3546:     */     }
/* 3547:     */     
/* 3548:     */     public Criteria andLastsharetimeLessThanOrEqualTo(String value)
/* 3549:     */     {
/* 3550:2963 */       addCriterion("UserInfo.lastSharetime <=", value, "lastsharetime");
/* 3551:2964 */       return (Criteria)this;
/* 3552:     */     }
/* 3553:     */     
/* 3554:     */     public Criteria andLastsharetimeLike(String value)
/* 3555:     */     {
/* 3556:2968 */       addCriterion("UserInfo.lastSharetime like", value, "lastsharetime");
/* 3557:2969 */       return (Criteria)this;
/* 3558:     */     }
/* 3559:     */     
/* 3560:     */     public Criteria andLastsharetimeNotLike(String value)
/* 3561:     */     {
/* 3562:2973 */       addCriterion("UserInfo.lastSharetime not like", value, "lastsharetime");
/* 3563:2974 */       return (Criteria)this;
/* 3564:     */     }
/* 3565:     */     
/* 3566:     */     public Criteria andLastsharetimeIn(List<String> values)
/* 3567:     */     {
/* 3568:2978 */       addCriterion("UserInfo.lastSharetime in", values, "lastsharetime");
/* 3569:2979 */       return (Criteria)this;
/* 3570:     */     }
/* 3571:     */     
/* 3572:     */     public Criteria andLastsharetimeNotIn(List<String> values)
/* 3573:     */     {
/* 3574:2983 */       addCriterion("UserInfo.lastSharetime not in", values, "lastsharetime");
/* 3575:2984 */       return (Criteria)this;
/* 3576:     */     }
/* 3577:     */     
/* 3578:     */     public Criteria andLastsharetimeBetween(String value1, String value2)
/* 3579:     */     {
/* 3580:2988 */       addCriterion("UserInfo.lastSharetime between", value1, value2, "lastsharetime");
/* 3581:2989 */       return (Criteria)this;
/* 3582:     */     }
/* 3583:     */     
/* 3584:     */     public Criteria andLastsharetimeNotBetween(String value1, String value2)
/* 3585:     */     {
/* 3586:2993 */       addCriterion("UserInfo.lastSharetime not between", value1, value2, "lastsharetime");
/* 3587:2994 */       return (Criteria)this;
/* 3588:     */     }
/* 3589:     */   }
/* 3590:     */   
/* 3591:     */   public static class Criteria
/* 3592:     */     extends GeneratedCriteria
/* 3593:     */   {}
/* 3594:     */   
/* 3595:     */   public static class Criterion
/* 3596:     */   {
/* 3597:     */     private String condition;
/* 3598:     */     private Object value;
/* 3599:     */     private Object secondValue;
/* 3600:     */     private boolean noValue;
/* 3601:     */     private boolean singleValue;
/* 3602:     */     private boolean betweenValue;
/* 3603:     */     private boolean listValue;
/* 3604:     */     private String typeHandler;
/* 3605:     */     
/* 3606:     */     public String getCondition()
/* 3607:     */     {
/* 3608:3023 */       return this.condition;
/* 3609:     */     }
/* 3610:     */     
/* 3611:     */     public Object getValue()
/* 3612:     */     {
/* 3613:3027 */       return this.value;
/* 3614:     */     }
/* 3615:     */     
/* 3616:     */     public Object getSecondValue()
/* 3617:     */     {
/* 3618:3031 */       return this.secondValue;
/* 3619:     */     }
/* 3620:     */     
/* 3621:     */     public boolean isNoValue()
/* 3622:     */     {
/* 3623:3035 */       return this.noValue;
/* 3624:     */     }
/* 3625:     */     
/* 3626:     */     public boolean isSingleValue()
/* 3627:     */     {
/* 3628:3039 */       return this.singleValue;
/* 3629:     */     }
/* 3630:     */     
/* 3631:     */     public boolean isBetweenValue()
/* 3632:     */     {
/* 3633:3043 */       return this.betweenValue;
/* 3634:     */     }
/* 3635:     */     
/* 3636:     */     public boolean isListValue()
/* 3637:     */     {
/* 3638:3047 */       return this.listValue;
/* 3639:     */     }
/* 3640:     */     
/* 3641:     */     public String getTypeHandler()
/* 3642:     */     {
/* 3643:3051 */       return this.typeHandler;
/* 3644:     */     }
/* 3645:     */     
/* 3646:     */     protected Criterion(String condition)
/* 3647:     */     {
/* 3648:3056 */       this.condition = condition;
/* 3649:3057 */       this.typeHandler = null;
/* 3650:3058 */       this.noValue = true;
/* 3651:     */     }
/* 3652:     */     
/* 3653:     */     protected Criterion(String condition, Object value, String typeHandler)
/* 3654:     */     {
/* 3655:3063 */       this.condition = condition;
/* 3656:3064 */       this.value = value;
/* 3657:3065 */       this.typeHandler = typeHandler;
/* 3658:3066 */       if ((value instanceof List)) {
/* 3659:3067 */         this.listValue = true;
/* 3660:     */       } else {
/* 3661:3069 */         this.singleValue = true;
/* 3662:     */       }
/* 3663:     */     }
/* 3664:     */     
/* 3665:     */     protected Criterion(String condition, Object value)
/* 3666:     */     {
/* 3667:3074 */       this(condition, value, null);
/* 3668:     */     }
/* 3669:     */     
/* 3670:     */     protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
/* 3671:     */     {
/* 3672:3079 */       this.condition = condition;
/* 3673:3080 */       this.value = value;
/* 3674:3081 */       this.secondValue = secondValue;
/* 3675:3082 */       this.typeHandler = typeHandler;
/* 3676:3083 */       this.betweenValue = true;
/* 3677:     */     }
/* 3678:     */     
/* 3679:     */     protected Criterion(String condition, Object value, Object secondValue)
/* 3680:     */     {
/* 3681:3087 */       this(condition, value, secondValue, null);
/* 3682:     */     }
/* 3683:     */   }
/* 3684:     */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.entity.UserInfoExample

 * JD-Core Version:    0.7.0.1

 */