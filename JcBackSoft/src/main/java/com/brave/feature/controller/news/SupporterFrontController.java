/*  1:   */ package com.brave.feature.controller.news;
/*  2:   */ 
/*  3:   */ import org.springframework.stereotype.Controller;
/*  4:   */ import org.springframework.web.bind.annotation.RequestMapping;
/*  5:   */ 
/*  6:   */ @Controller
/*  7:   */ @RequestMapping({"/supporters"})
/*  8:   */ public class SupporterFrontController
/*  9:   */ {
/* 10:   */   @RequestMapping(value={"/detail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 11:   */   public String index()
/* 12:   */   {
/* 13:17 */     return "supporters_detail";
/* 14:   */   }
/* 15:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.news.SupporterFrontController

 * JD-Core Version:    0.7.0.1

 */